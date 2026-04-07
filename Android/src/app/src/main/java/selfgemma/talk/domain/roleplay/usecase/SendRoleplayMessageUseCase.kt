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
import selfgemma.talk.data.Model
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.MessageStatus
import selfgemma.talk.domain.roleplay.repository.ConversationRepository
import selfgemma.talk.domain.roleplay.repository.MemoryRepository
import selfgemma.talk.domain.roleplay.repository.RoleRepository
import selfgemma.talk.runtime.runtimeHelper

data class SendRoleplayMessageResult(
  val assistantMessage: Message? = null,
  val interrupted: Boolean = false,
  val errorMessage: String? = null,
)

private data class ModelReadinessResult(
  val ready: Boolean,
  val interrupted: Boolean = false,
  val errorMessage: String? = null,
)

private const val TAG = "SendRoleplayMessage"

class SendRoleplayMessageUseCase
@Inject
constructor(
  private val conversationRepository: ConversationRepository,
  private val roleRepository: RoleRepository,
  private val memoryRepository: MemoryRepository,
  private val promptAssembler: PromptAssembler,
  private val summarizeSessionUseCase: SummarizeSessionUseCase,
  private val extractMemoriesUseCase: ExtractMemoriesUseCase,
) {
  companion object {
    const val ENABLE_STREAMING = false
    private const val MODEL_READY_TIMEOUT_MS = 60_000L
    private const val MODEL_READY_POLL_INTERVAL_MS = 50L
  }

  suspend operator fun invoke(
    sessionId: String,
    model: Model,
    userInput: String,
    isStopRequested: () -> Boolean,
  ): SendRoleplayMessageResult {
    val startTime = SystemClock.elapsedRealtime()
    val trimmedInput = userInput.trim()
    if (trimmedInput.isBlank()) {
      return SendRoleplayMessageResult(errorMessage = "Message is empty.")
    }

    val session = conversationRepository.getSession(sessionId)
    if (session == null) {
      return SendRoleplayMessageResult(errorMessage = "Session no longer exists.")
    }
    Log.d(TAG, "session loaded after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId")

    val now = System.currentTimeMillis()
    val accelerator = model.getStringConfigValue(key = ConfigKeys.ACCELERATOR, defaultValue = "")
    val firstSeq = conversationRepository.nextMessageSeq(sessionId)
    Log.d(TAG, "next seq resolved after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId seq=$firstSeq")
    val userMessage =
      Message(
        id = UUID.randomUUID().toString(),
        sessionId = sessionId,
        seq = firstSeq,
        side = MessageSide.USER,
        status = MessageStatus.COMPLETED,
        content = trimmedInput,
        createdAt = now,
        updatedAt = now,
      )
    conversationRepository.appendMessage(userMessage)
    Log.d(
      TAG,
      "user message appended after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId messageId=${userMessage.id}",
    )

    val assistantSeed =
      Message(
        id = UUID.randomUUID().toString(),
        sessionId = sessionId,
        seq = firstSeq + 1,
        side = MessageSide.ASSISTANT,
        status = MessageStatus.STREAMING,
        content = "",
        accelerator = accelerator,
        parentMessageId = userMessage.id,
        createdAt = now,
        updatedAt = now,
      )
    conversationRepository.appendMessage(assistantSeed)
    Log.d(
      TAG,
      "assistant seed appended after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId messageId=${assistantSeed.id}",
    )

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
        message.id != userMessage.id && message.id != assistantSeed.id
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

    val systemInstruction =
      Contents.of(
        promptAssembler.assemble(
          role = role,
          summary = summary,
          memories = relevantMemories,
          recentMessages = recentMessages,
        )
      )

    try {
      model.runtimeHelper.resetConversation(
        model = model,
        supportImage = false,
        supportAudio = false,
        systemInstruction = systemInstruction,
      )
      Log.d(TAG, "conversation reset after ${SystemClock.elapsedRealtime() - startTime}ms sessionId=$sessionId")
    } catch (exception: Exception) {
      val failedMessage =
        assistantSeed.copy(
          status = MessageStatus.FAILED,
          errorMessage = exception.message ?: "Failed to prepare the chat session.",
          updatedAt = System.currentTimeMillis(),
        )
      conversationRepository.updateMessage(failedMessage)
      return SendRoleplayMessageResult(
        assistantMessage = failedMessage,
        errorMessage = failedMessage.errorMessage,
      )
    }

    val callbackScope = CoroutineScope(Dispatchers.IO)
    val partialContent = StringBuilder()
    val completed = AtomicBoolean(false)
    val start = System.currentTimeMillis()

    val finalMessage =
      try {
        suspendCancellableCoroutine<Message> { continuation ->
          fun finish(status: MessageStatus, errorMessage: String? = null) {
            if (!completed.compareAndSet(false, true)) {
              return
            }

            val updatedMessage =
              assistantSeed.copy(
                content = partialContent.toString().trim(),
                status = status,
                errorMessage = errorMessage,
                latencyMs = (System.currentTimeMillis() - start).toDouble(),
                updatedAt = System.currentTimeMillis(),
              )
            callbackScope.launch {
              conversationRepository.updateMessage(updatedMessage)
              if (continuation.isActive) {
                continuation.resume(updatedMessage)
              }
            }
          }

          try {
            model.runtimeHelper.runInference(
              model = model,
              input = trimmedInput,
              resultListener = { partialResult, done, _ ->
                if (!partialResult.startsWith("<ctrl") && partialResult.isNotEmpty()) {
                  partialContent.append(partialResult)

                  if (ENABLE_STREAMING) {
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
        val failedMessage =
          assistantSeed.copy(
            content = partialContent.toString().trim(),
            status = MessageStatus.FAILED,
            errorMessage = exception.message ?: "Failed to generate a reply.",
            latencyMs = (System.currentTimeMillis() - start).toDouble(),
            updatedAt = System.currentTimeMillis(),
          )
        conversationRepository.updateMessage(failedMessage)
        return SendRoleplayMessageResult(
          assistantMessage = failedMessage,
          errorMessage = failedMessage.errorMessage,
        )
      }

    if (finalMessage.status == MessageStatus.COMPLETED) {
      summarizeSessionUseCase(sessionId)
      extractMemoriesUseCase(
        session = session,
        role = role,
        userMessage = userMessage,
        assistantMessage = finalMessage,
      )
    }

    return SendRoleplayMessageResult(
      assistantMessage = finalMessage,
      interrupted = finalMessage.status == MessageStatus.INTERRUPTED,
      errorMessage = finalMessage.errorMessage,
    )
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
}