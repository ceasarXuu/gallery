package selfgemma.talk.domain.roleplay.usecase

import android.os.SystemClock
import android.util.Log
import com.google.ai.edge.litertlm.Contents
import java.util.UUID
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import selfgemma.talk.data.ConfigKeys
import selfgemma.talk.data.DataStoreRepository
import selfgemma.talk.data.Model
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.MessageStatus
import selfgemma.talk.domain.roleplay.model.Session
import selfgemma.talk.domain.roleplay.model.SessionEvent
import selfgemma.talk.domain.roleplay.model.SessionEventType
import selfgemma.talk.domain.roleplay.model.toStChatRuntimeRole
import selfgemma.talk.domain.roleplay.model.toStChatRuntimeSession
import selfgemma.talk.domain.roleplay.model.toModelContextProfile
import selfgemma.talk.domain.roleplay.repository.ConversationRepository
import selfgemma.talk.domain.roleplay.repository.MemoryRepository
import selfgemma.talk.domain.roleplay.repository.RoleRepository
import selfgemma.talk.runtime.runtimeHelper

data class SendRoleplayMessageResult(
  val assistantMessage: Message? = null,
  val interrupted: Boolean = false,
  val errorMessage: String? = null,
)

data class PendingRoleplayMessage(
  val session: Session,
  val userMessages: List<Message>,
  val assistantSeed: Message,
  val combinedUserInput: String,
)

data class StagedRoleplayTurn(
  val userMessages: List<Message>,
  val assistantMessage: Message,
  val combinedUserInput: String,
)

private data class ModelReadinessResult(
  val ready: Boolean,
  val interrupted: Boolean = false,
  val errorMessage: String? = null,
)

private data class InferenceAttemptResult(
  val message: Message,
  val overflowDetected: Boolean,
)

private data class ConversationPreparationResult(
  val failureMessage: Message? = null,
  val overflowDetected: Boolean = false,
)

private const val TAG = "SendRoleplayMessage"

class SendRoleplayMessageUseCase
@Inject
constructor(
  private val dataStoreRepository: DataStoreRepository,
  private val conversationRepository: ConversationRepository,
  private val roleRepository: RoleRepository,
  private val memoryRepository: MemoryRepository,
  private val promptAssembler: PromptAssembler,
  private val summarizeSessionUseCase: SummarizeSessionUseCase,
  private val extractMemoriesUseCase: ExtractMemoriesUseCase,
) {
  companion object {
    private const val MODEL_READY_TIMEOUT_MS = 60_000L
    private const val MODEL_READY_POLL_INTERVAL_MS = 50L
  }

  suspend operator fun invoke(
    sessionId: String,
    model: Model,
    userInput: String,
    stagedTurn: StagedRoleplayTurn? = null,
    enableStreamingOutput: Boolean = true,
    isStopRequested: () -> Boolean,
  ): SendRoleplayMessageResult {
    val resolvedTurn =
      stagedTurn ?: createStagedTurn(sessionId = sessionId, model = model, userInputs = listOf(userInput))
    val pendingMessage =
      enqueuePendingMessage(
        sessionId = sessionId,
        stagedTurn = resolvedTurn,
      ) ?: return SendRoleplayMessageResult(errorMessage = "Session no longer exists.")

    return completePendingMessage(
      pendingMessage = pendingMessage,
      model = model,
      enableStreamingOutput = enableStreamingOutput,
      isStopRequested = isStopRequested,
    )
  }

  suspend fun enqueuePendingMessage(
    sessionId: String,
    stagedTurn: StagedRoleplayTurn,
    persistedUserMessageIds: Set<String> = emptySet(),
  ): PendingRoleplayMessage? {
    val startTime = SystemClock.elapsedRealtime()
    val trimmedInput = stagedTurn.combinedUserInput.trim()
    if (trimmedInput.isBlank()) {
      return null
    }

    val session = conversationRepository.getSession(sessionId)
    if (session == null) {
      return null
    }
    Log.d(TAG, "queue session loaded after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId")

    val userMessages = stagedTurn.userMessages.map { it.copy(content = it.content.trim()) }
    userMessages
      .filterNot { message -> message.id in persistedUserMessageIds }
      .forEach { userMessage ->
        conversationRepository.appendMessage(userMessage)
        Log.d(
          TAG,
          "queued user message after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId messageId=${userMessage.id}",
        )
      }

    val assistantSeed = stagedTurn.assistantMessage.copy(parentMessageId = userMessages.lastOrNull()?.id)
    conversationRepository.appendMessage(assistantSeed)
    Log.d(
      TAG,
      "queued assistant seed after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId messageId=${assistantSeed.id} userMessageCount=${userMessages.size}",
    )

    return PendingRoleplayMessage(
      session = session,
      userMessages = userMessages,
      assistantSeed = assistantSeed,
      combinedUserInput = trimmedInput,
    )
  }

  suspend fun completePendingMessage(
    pendingMessage: PendingRoleplayMessage,
    model: Model,
    enableStreamingOutput: Boolean = true,
    isStopRequested: () -> Boolean,
  ): SendRoleplayMessageResult {
    val startTime = SystemClock.elapsedRealtime()
    val sessionId = pendingMessage.session.id
    val session = pendingMessage.session
    val userMessages = pendingMessage.userMessages
    val assistantSeed = pendingMessage.assistantSeed
    val trimmedInput = pendingMessage.combinedUserInput
    val modelReadiness = awaitModelReady(model = model, isStopRequested = isStopRequested)
    Log.d(
      TAG,
      "model readiness resolved after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId ready=${modelReadiness.ready} interrupted=${modelReadiness.interrupted}",
    )
    if (!modelReadiness.ready) {
      val pendingMessage =
        assistantSeed.copy(
          status = if (modelReadiness.interrupted) MessageStatus.INTERRUPTED else MessageStatus.FAILED,
          errorMessage = modelReadiness.errorMessage,
          updatedAt = System.currentTimeMillis(),
        )
      conversationRepository.updateMessage(pendingMessage)
      return SendRoleplayMessageResult(
        assistantMessage = pendingMessage,
        interrupted = modelReadiness.interrupted,
        errorMessage = pendingMessage.errorMessage,
      )
    }

    val role = roleRepository.getRole(session.roleId)
    if (role == null) {
      val failedMessage =
        assistantSeed.copy(
          status = MessageStatus.FAILED,
          errorMessage = "Role data is missing for this session.",
          updatedAt = System.currentTimeMillis(),
        )
      conversationRepository.updateMessage(failedMessage)
      return SendRoleplayMessageResult(
        assistantMessage = failedMessage,
        errorMessage = failedMessage.errorMessage,
      )
    }

    val recentMessages =
      conversationRepository.observeMessages(sessionId).first().filter { message ->
        message.id != assistantSeed.id && userMessages.none { userMessage -> userMessage.id == message.id }
      }
    val summary = conversationRepository.getSummary(sessionId)
    val memoryLimit = role.memoryMaxItems.coerceIn(0, 8)
    val relevantMemories =
      if (role.memoryEnabled && memoryLimit > 0) {
        memoryRepository.searchRelevant(
          roleId = role.id,
          sessionId = sessionId,
          query = trimmedInput,
          limit = memoryLimit,
        )
      } else {
        emptyList()
      }

    if (relevantMemories.isNotEmpty()) {
      memoryRepository.markUsed(relevantMemories.map { it.id }, System.currentTimeMillis())
    }

    val runtimeRole = role.toStChatRuntimeRole(userProfile = dataStoreRepository.getStUserProfile())
    val runtimeSession = session.toStChatRuntimeSession(generationTrigger = "normal")
    val contextProfile = model.toModelContextProfile()
    var attemptMode = PromptBudgetMode.FULL
    var promptAssembly =
      assemblePrompt(
        runtimeRole = runtimeRole,
        runtimeSession = runtimeSession,
        summary = summary,
        relevantMemories = relevantMemories,
        recentMessages = recentMessages,
        trimmedInput = trimmedInput,
        role = role,
        contextProfile = contextProfile,
        budgetMode = attemptMode,
      )
    if (ContextOverflowRecovery.shouldUseAggressiveModePreflight(promptAssembly.budgetReport)) {
      attemptMode = PromptBudgetMode.AGGRESSIVE
      Log.w(
        TAG,
        "prompt preflight overflow sessionId=$sessionId estimatedTokens=${promptAssembly.budgetReport?.estimatedInputTokens} usableTokens=${promptAssembly.budgetReport?.usableInputTokens} switchingTo=$attemptMode",
      )
      promptAssembly =
        assemblePrompt(
          runtimeRole = runtimeRole,
          runtimeSession = runtimeSession,
          summary = summary,
          relevantMemories = relevantMemories,
          recentMessages = recentMessages,
          trimmedInput = trimmedInput,
          role = role,
          contextProfile = contextProfile,
          budgetMode = attemptMode,
        )
    }
    appendBudgetEventIfNeeded(sessionId = sessionId, report = promptAssembly.budgetReport)

    var finalMessage: Message? = null
    var overflowRetries = 0
    while (true) {
      applyUpdatedChatMetadata(session = session, promptAssembly = promptAssembly)
      val preparationResult =
        prepareConversation(
          assistantSeed = assistantSeed,
          model = model,
          promptAssembly = promptAssembly,
          sessionId = sessionId,
          recentMessages = recentMessages,
          relevantMemories = relevantMemories,
          trigger = runtimeSession.generationTrigger,
          startTime = startTime,
        )
      if (preparationResult.failureMessage != null) {
        if (
          preparationResult.overflowDetected &&
            overflowRetries < ContextOverflowRecovery.MAX_OVERFLOW_RETRIES
        ) {
          overflowRetries += 1
          attemptMode = PromptBudgetMode.AGGRESSIVE
          Log.w(
            TAG,
            "context overflow during reset sessionId=$sessionId retry=$overflowRetries message=${preparationResult.failureMessage.errorMessage}",
          )
          appendOverflowRecoveryEvent(
            sessionId = sessionId,
            stage = "reset",
            retry = overflowRetries,
            report = promptAssembly.budgetReport,
          )
          promptAssembly =
            assemblePrompt(
              runtimeRole = runtimeRole,
              runtimeSession = runtimeSession,
              summary = summary,
              relevantMemories = relevantMemories,
              recentMessages = recentMessages,
              trimmedInput = trimmedInput,
              role = role,
              contextProfile = contextProfile,
              budgetMode = attemptMode,
            )
          appendBudgetEventIfNeeded(sessionId = sessionId, report = promptAssembly.budgetReport)
          continue
        }
        val failedMessage = preparationResult.failureMessage
        conversationRepository.updateMessage(failedMessage)
        return SendRoleplayMessageResult(
          assistantMessage = failedMessage,
          errorMessage = failedMessage.errorMessage,
        )
      }

      val inferenceResult =
        runInferenceAttempt(
          assistantSeed = assistantSeed,
          model = model,
          input = trimmedInput,
          role = role,
          sessionId = sessionId,
          startTime = startTime,
          enableStreamingOutput = enableStreamingOutput,
          isStopRequested = isStopRequested,
        )
      finalMessage = inferenceResult.message
      if (
        !inferenceResult.overflowDetected ||
          finalMessage.status == MessageStatus.INTERRUPTED ||
          overflowRetries >= ContextOverflowRecovery.MAX_OVERFLOW_RETRIES
      ) {
        break
      }

      overflowRetries += 1
      attemptMode = PromptBudgetMode.AGGRESSIVE
      Log.w(
        TAG,
        "context overflow retry sessionId=$sessionId retry=$overflowRetries message=${finalMessage.errorMessage}",
      )
      appendOverflowRecoveryEvent(
        sessionId = sessionId,
        stage = "inference",
        retry = overflowRetries,
        report = promptAssembly.budgetReport,
      )
      promptAssembly =
        assemblePrompt(
          runtimeRole = runtimeRole,
          runtimeSession = runtimeSession,
          summary = summary,
          relevantMemories = relevantMemories,
          recentMessages = recentMessages,
          trimmedInput = trimmedInput,
          role = role,
          contextProfile = contextProfile,
          budgetMode = attemptMode,
        )
      appendBudgetEventIfNeeded(sessionId = sessionId, report = promptAssembly.budgetReport)
    }
    finalMessage = normalizeFinalMessage(checkNotNull(finalMessage))
    conversationRepository.updateMessage(finalMessage)

    if (finalMessage.status == MessageStatus.COMPLETED) {
      summarizeSessionUseCase(sessionId)
      extractMemoriesUseCase(
        session = session,
        role = role,
        userMessage = userMessages.last(),
        assistantMessage = finalMessage,
      )
    }

    return SendRoleplayMessageResult(
      assistantMessage = finalMessage,
      interrupted = finalMessage.status == MessageStatus.INTERRUPTED,
      errorMessage = finalMessage.errorMessage,
    )
  }

  private suspend fun assemblePrompt(
    runtimeRole: selfgemma.talk.domain.roleplay.model.StChatRuntimeRole,
    runtimeSession: selfgemma.talk.domain.roleplay.model.StChatRuntimeSession,
    summary: selfgemma.talk.domain.roleplay.model.SessionSummary?,
    relevantMemories: List<selfgemma.talk.domain.roleplay.model.MemoryItem>,
    recentMessages: List<Message>,
    trimmedInput: String,
    role: selfgemma.talk.domain.roleplay.model.RoleCard,
    contextProfile: selfgemma.talk.domain.roleplay.model.ModelContextProfile,
    budgetMode: PromptBudgetMode,
  ): PromptAssemblyResult {
    return promptAssembler.assembleForSession(
      runtimeRole = runtimeRole,
      runtimeSession = runtimeSession,
      summary = summary,
      memories = relevantMemories,
      recentMessages = recentMessages,
      pendingUserInput = trimmedInput,
      runtimeProfile = role.runtimeProfile,
      contextProfile = contextProfile,
      budgetMode = budgetMode,
    )
  }

  private suspend fun applyUpdatedChatMetadata(session: Session, promptAssembly: PromptAssemblyResult) {
    promptAssembly.updatedChatMetadataJson
      ?.takeIf { it != session.interopChatMetadataJson }
      ?.let { updatedChatMetadataJson ->
        conversationRepository.updateSession(
          session.copy(
            interopChatMetadataJson = updatedChatMetadataJson,
            updatedAt = System.currentTimeMillis(),
          )
        )
      }
  }

  private suspend fun appendBudgetEventIfNeeded(sessionId: String, report: PromptBudgetReport?) {
    if (
      report == null ||
        report.mode == PromptBudgetMode.FULL ||
        (report.compactedSectionIds.isEmpty() && report.droppedSectionIds.isEmpty())
    ) {
      return
    }
    conversationRepository.appendEvent(
      SessionEvent(
        id = UUID.randomUUID().toString(),
        sessionId = sessionId,
        eventType = SessionEventType.CONTEXT_BUDGET_APPLIED,
        payloadJson =
          """{"mode":"${report.mode.name}","estimatedInputTokens":${report.estimatedInputTokens},"usableInputTokens":${report.usableInputTokens},"compactedSectionCount":${report.compactedSectionIds.size},"droppedSectionCount":${report.droppedSectionIds.size}}""",
        createdAt = System.currentTimeMillis(),
      )
    )
  }

  private suspend fun appendOverflowRecoveryEvent(
    sessionId: String,
    stage: String,
    retry: Int,
    report: PromptBudgetReport?,
  ) {
    conversationRepository.appendEvent(
      SessionEvent(
        id = UUID.randomUUID().toString(),
        sessionId = sessionId,
        eventType = SessionEventType.CONTEXT_OVERFLOW_RECOVERED,
        payloadJson =
          """{"stage":"$stage","retry":$retry,"mode":"${report?.mode?.name ?: PromptBudgetMode.AGGRESSIVE.name}","estimatedInputTokens":${report?.estimatedInputTokens ?: -1},"usableInputTokens":${report?.usableInputTokens ?: -1}}""",
        createdAt = System.currentTimeMillis(),
      )
    )
  }

  private fun normalizeFinalMessage(message: Message): Message {
    if (message.status != MessageStatus.FAILED || !ContextOverflowRecovery.isContextOverflow(message.errorMessage)) {
      return message
    }
    return message.copy(errorMessage = ContextOverflowRecovery.toUserFacingError(message.errorMessage))
  }

  private fun prepareConversation(
    assistantSeed: Message,
    model: Model,
    promptAssembly: PromptAssemblyResult,
    sessionId: String,
    recentMessages: List<Message>,
    relevantMemories: List<selfgemma.talk.domain.roleplay.model.MemoryItem>,
    trigger: String,
    startTime: Long,
  ): ConversationPreparationResult {
    val systemInstruction = Contents.of(promptAssembly.prompt)
    Log.d(
      TAG,
      "assembled prompt sessionId=$sessionId trigger=$trigger recentMessages=${recentMessages.size} memories=${relevantMemories.size} promptChars=${systemInstruction.toString().length} estimatedTokens=${promptAssembly.budgetReport?.estimatedInputTokens} usableTokens=${promptAssembly.budgetReport?.usableInputTokens} budgetMode=${promptAssembly.budgetReport?.mode}",
    )

    return try {
      model.runtimeHelper.resetConversation(
        model = model,
        supportImage = false,
        supportAudio = false,
        systemInstruction = systemInstruction,
      )
      Log.d(TAG, "conversation reset after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId")
      ConversationPreparationResult()
    } catch (exception: Exception) {
      val errorMessage = exception.message ?: "Failed to prepare the chat session."
      ConversationPreparationResult(
        failureMessage =
          assistantSeed.copy(
            status = MessageStatus.FAILED,
            errorMessage = ContextOverflowRecovery.toUserFacingError(errorMessage),
            updatedAt = System.currentTimeMillis(),
          ),
        overflowDetected = ContextOverflowRecovery.isContextOverflow(errorMessage),
      )
    }
  }

  private suspend fun runInferenceAttempt(
    assistantSeed: Message,
    model: Model,
    input: String,
    role: selfgemma.talk.domain.roleplay.model.RoleCard,
    sessionId: String,
    startTime: Long,
    enableStreamingOutput: Boolean,
    isStopRequested: () -> Boolean,
  ): InferenceAttemptResult {
    val callbackScope = CoroutineScope(Dispatchers.IO)
    val partialContent = StringBuilder()
    val completed = AtomicBoolean(false)
    val inferenceStart = System.currentTimeMillis()
    val hasLoggedStreamingUpdate = AtomicBoolean(false)

    return try {
      suspendCancellableCoroutine { continuation ->
        fun finish(status: MessageStatus, errorMessage: String? = null) {
          if (!completed.compareAndSet(false, true)) {
            return
          }
          val updatedMessage =
            assistantSeed.copy(
              content = partialContent.toString().trim(),
              status = status,
              errorMessage = errorMessage,
              latencyMs = (System.currentTimeMillis() - inferenceStart).toDouble(),
              updatedAt = System.currentTimeMillis(),
            )
          if (continuation.isActive) {
            continuation.resume(
              InferenceAttemptResult(
                message = updatedMessage,
                overflowDetected = status == MessageStatus.FAILED && ContextOverflowRecovery.isContextOverflow(errorMessage),
              )
            )
          }
        }

        try {
          model.runtimeHelper.runInference(
            model = model,
            input = input,
            resultListener = { partialResult, done, _ ->
              if (!partialResult.startsWith("<ctrl") && partialResult.isNotEmpty()) {
                partialContent.append(partialResult)

                if (enableStreamingOutput && !isStopRequested()) {
                  if (hasLoggedStreamingUpdate.compareAndSet(false, true)) {
                    Log.d(
                      TAG,
                      "streaming content updates enabled sessionId=$sessionId assistantMessageId=${assistantSeed.id}",
                    )
                  }
                  val streamingMessage =
                    assistantSeed.copy(
                      content = partialContent.toString(),
                      status = MessageStatus.STREAMING,
                      updatedAt = System.currentTimeMillis(),
                    )
                  callbackScope.launch { conversationRepository.updateMessage(streamingMessage) }
                }
              }

              if (done) {
                Log.d(
                  TAG,
                  "inference callback done after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId",
                )
                finish(
                  status =
                    if (isStopRequested()) {
                      MessageStatus.INTERRUPTED
                    } else {
                      MessageStatus.COMPLETED
                    }
                )
              }
            },
            cleanUpListener = {},
            onError = { message ->
              Log.d(
                TAG,
                "inference error after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId message=$message",
              )
              finish(
                status =
                  if (isStopRequested()) {
                    MessageStatus.INTERRUPTED
                  } else {
                    MessageStatus.FAILED
                  },
                errorMessage = if (isStopRequested()) null else message,
              )
            },
            extraContext =
              if (
                role.enableThinking &&
                  model.getBooleanConfigValue(
                    key = ConfigKeys.ENABLE_THINKING,
                    defaultValue = false,
                  )
              ) {
                mapOf("enable_thinking" to "true")
              } else {
                null
              },
          )
          Log.d(TAG, "runInference dispatched after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId")
        } catch (exception: Exception) {
          finish(
            status = MessageStatus.FAILED,
            errorMessage = exception.message ?: "Failed to generate a reply.",
          )
        }

        continuation.invokeOnCancellation {
          if (!completed.get()) {
            model.runtimeHelper.stopResponse(model)
          }
        }
      }
    } catch (exception: Exception) {
      InferenceAttemptResult(
        message =
          assistantSeed.copy(
            content = partialContent.toString().trim(),
            status = MessageStatus.FAILED,
            errorMessage = exception.message ?: "Failed to generate a reply.",
            latencyMs = (System.currentTimeMillis() - inferenceStart).toDouble(),
            updatedAt = System.currentTimeMillis(),
          ),
        overflowDetected = ContextOverflowRecovery.isContextOverflow(exception.message),
      )
    }
  }

  private suspend fun awaitModelReady(
    model: Model,
    isStopRequested: () -> Boolean,
  ): ModelReadinessResult {
    val startTime = System.currentTimeMillis()
    var sawInitialization = model.initializing

    while (model.instance == null) {
      if (isStopRequested()) {
        return ModelReadinessResult(ready = false, interrupted = true)
      }

      sawInitialization = sawInitialization || model.initializing
      if (sawInitialization && !model.initializing) {
        return ModelReadinessResult(
          ready = false,
          errorMessage = "Selected model failed to initialize.",
        )
      }

      if (System.currentTimeMillis() - startTime >= MODEL_READY_TIMEOUT_MS) {
        return ModelReadinessResult(
          ready = false,
          errorMessage = "Selected model is still preparing.",
        )
      }

      delay(MODEL_READY_POLL_INTERVAL_MS)
    }

    return ModelReadinessResult(ready = true)
  }

  private suspend fun createStagedTurn(
    sessionId: String,
    model: Model,
    userInputs: List<String>,
  ): StagedRoleplayTurn {
    val now = System.currentTimeMillis()
    val accelerator = model.getStringConfigValue(key = ConfigKeys.ACCELERATOR, defaultValue = "")
    val firstSeq = conversationRepository.nextMessageSeq(sessionId)
    Log.d(TAG, "queue next seq resolved sessionId=$sessionId seq=$firstSeq")
    val sanitizedInputs = userInputs.map(String::trim).filter(String::isNotBlank)
    return StagedRoleplayTurn(
      userMessages =
        sanitizedInputs.mapIndexed { index, input ->
          Message(
            id = UUID.randomUUID().toString(),
            sessionId = sessionId,
            seq = firstSeq + index,
            side = MessageSide.USER,
            status = MessageStatus.COMPLETED,
            content = input,
            createdAt = now,
            updatedAt = now,
          )
        },
      assistantMessage =
        Message(
          id = UUID.randomUUID().toString(),
          sessionId = sessionId,
          seq = firstSeq + sanitizedInputs.size,
          side = MessageSide.ASSISTANT,
          status = MessageStatus.STREAMING,
          content = "",
          accelerator = accelerator,
          createdAt = now,
          updatedAt = now,
        ),
      combinedUserInput = sanitizedInputs.joinToString(separator = "\n\n"),
    )
  }
}
