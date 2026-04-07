package selfgemma.talk.feature.roleplay.chat

import android.content.Context
import android.os.SystemClock
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import selfgemma.talk.data.ConfigKeys
import selfgemma.talk.data.DataStoreRepository
import selfgemma.talk.data.Model
import selfgemma.talk.domain.roleplay.model.MemoryCategory
import selfgemma.talk.domain.roleplay.model.MemoryItem
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.MessageStatus
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.Session
import selfgemma.talk.domain.roleplay.model.SessionEvent
import selfgemma.talk.domain.roleplay.model.SessionEventType
import selfgemma.talk.domain.roleplay.model.SessionSummary
import selfgemma.talk.domain.roleplay.repository.ConversationRepository
import selfgemma.talk.domain.roleplay.repository.MemoryRepository
import selfgemma.talk.domain.roleplay.repository.RoleRepository
import selfgemma.talk.domain.roleplay.usecase.ExtractMemoriesUseCase
import selfgemma.talk.domain.roleplay.usecase.SendRoleplayMessageUseCase
import selfgemma.talk.domain.roleplay.usecase.StagedRoleplayTurn
import selfgemma.talk.runtime.runtimeHelper

data class RoleplayChatUiState(
  val loading: Boolean = true,
  val session: Session? = null,
  val role: RoleCard? = null,
  val messages: List<Message> = emptyList(),
  val draft: String = "",
  val summary: SessionSummary? = null,
  val pinnedMemories: List<MemoryItem> = emptyList(),
  val inProgress: Boolean = false,
  val errorMessage: String? = null,
)

private const val TAG = "RoleplayChatViewModel"
private const val SEND_DISPATCH_DELAY_MS = 2_000L

private data class QueuedUserMessage(
  val message: Message,
  val persisted: Boolean = false,
)

private data class RoleplayChatMetaState(
  val summary: SessionSummary? = null,
  val pinnedMemories: List<MemoryItem> = emptyList(),
  val pendingUserMessages: List<QueuedUserMessage> = emptyList(),
  val inProgress: Boolean = false,
  val errorMessage: String? = null,
)

@HiltViewModel
class RoleplayChatViewModel
@Inject
constructor(
  savedStateHandle: SavedStateHandle,
  @ApplicationContext private val appContext: Context,
  private val dataStoreRepository: DataStoreRepository,
  private val conversationRepository: ConversationRepository,
  private val roleRepository: RoleRepository,
  private val memoryRepository: MemoryRepository,
  private val sendRoleplayMessageUseCase: SendRoleplayMessageUseCase,
  private val extractMemoriesUseCase: ExtractMemoriesUseCase,
) : ViewModel() {
  private val sessionId: String = checkNotNull(savedStateHandle["sessionId"])
  private val draft = MutableStateFlow("")
  private val metaState = MutableStateFlow(RoleplayChatMetaState())
  private val stopRequested = MutableStateFlow(false)
  private var dispatchJob: Job? = null
  private var lastDraftEditAtElapsed = 0L
  private var latestQueuedModel: Model? = null
  private var activeAssistantMessageId: String? = null
  private var activeDispatchSuperseded = false

  private val sessionFlow =
    conversationRepository.observeSessions().map { sessions ->
      sessions.firstOrNull { it.id == sessionId }
    }.distinctUntilChanged()
  private val roleFlow =
    combine(sessionFlow, roleRepository.observeRoles()) { session, roles ->
      roles.firstOrNull { it.id == session?.roleId }
    }.distinctUntilChanged()

  val uiState: StateFlow<RoleplayChatUiState> =
    combine(
      sessionFlow,
      conversationRepository.observeMessages(sessionId).distinctUntilChanged(),
      roleFlow,
      draft,
      metaState,
    ) { session, messages, role, draftValue, meta ->
      RoleplayChatUiState(
        loading = session == null,
        session = session,
        role = role,
        messages = mergeMessages(messages = messages, queuedMessages = meta.pendingUserMessages),
        draft = draftValue,
        summary = meta.summary,
        pinnedMemories = meta.pinnedMemories,
        inProgress = meta.inProgress,
        errorMessage = meta.errorMessage,
      )
    }
      .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = RoleplayChatUiState(),
      )

  init {
    RoleplaySoundEffectPlayer.prepare(appContext)
    refreshSupplementalState()
  }

  fun updateDraft(value: String) {
    if (draft.value == value) {
      return
    }

    draft.value = value
    lastDraftEditAtElapsed = SystemClock.elapsedRealtime()
    if (metaState.value.pendingUserMessages.isNotEmpty() && !metaState.value.inProgress) {
      scheduleDispatch(reason = "draft changed while send pending")
    }
  }

  fun sendMessage(model: Model) {
    val input = draft.value.trim()
    if (input.isBlank()) {
      return
    }

    latestQueuedModel = model
    draft.value = ""
    lastDraftEditAtElapsed = SystemClock.elapsedRealtime()

    val queuedMessage = stagePendingUserMessage(input = input)
    metaState.update { current ->
      current.copy(
        pendingUserMessages = current.pendingUserMessages + queuedMessage,
        errorMessage = null,
      )
    }
    Log.d(
      TAG,
      "send accepted sessionId=$sessionId model=${model.name} inputLength=${input.length} pendingCount=${metaState.value.pendingUserMessages.size} messageId=${queuedMessage.message.id}",
    )

    viewModelScope.launch(Dispatchers.Default) {
      playSendSound()
    }

    if (metaState.value.inProgress) {
      requestMergeAndStop(model = model)
      return
    }

    scheduleDispatch(reason = "send accepted")
  }

  fun switchModel(modelId: String) {
    viewModelScope.launch {
      val session = conversationRepository.getSession(sessionId) ?: return@launch
      if (session.activeModelId == modelId) {
        return@launch
      }

      val now = System.currentTimeMillis()
      conversationRepository.updateSession(
        session.copy(activeModelId = modelId, updatedAt = now, lastMessageAt = session.lastMessageAt)
      )
      conversationRepository.appendEvent(
        SessionEvent(
          id = UUID.randomUUID().toString(),
          sessionId = sessionId,
          eventType = SessionEventType.MODEL_SWITCH,
          payloadJson = """{"activeModelId":"${modelId.escapeJson()}"}""",
          createdAt = now,
        )
      )
      metaState.update { current -> current.copy(errorMessage = null) }
      refreshSupplementalState()
    }
  }

  fun pinMessage(message: Message) {
    viewModelScope.launch {
      val session = conversationRepository.getSession(sessionId) ?: return@launch
      val role = roleRepository.getRole(session.roleId) ?: return@launch
      extractMemoriesUseCase.pinMessage(session = session, role = role, message = message)
      refreshSupplementalState()
    }
  }

  fun addManualMemory(content: String, category: MemoryCategory) {
    viewModelScope.launch {
      val session = conversationRepository.getSession(sessionId) ?: return@launch
      val role = roleRepository.getRole(session.roleId) ?: return@launch
      extractMemoriesUseCase.addManualMemory(
        session = session,
        role = role,
        content = content,
        category = category,
      )
      refreshSupplementalState()
    }
  }

  private fun scheduleDispatch(reason: String) {
    val model = latestQueuedModel ?: return
    dispatchJob?.cancel()
    dispatchJob =
      viewModelScope.launch {
        while (true) {
          val delayMs = remainingDispatchDelay()
          if (delayMs <= 0L) {
            break
          }
          Log.d(
            TAG,
            "dispatch paused sessionId=$sessionId reason=$reason delayMs=$delayMs pendingCount=${metaState.value.pendingUserMessages.size}",
          )
          delay(delayMs)
        }

        if (metaState.value.inProgress || metaState.value.pendingUserMessages.isEmpty()) {
          return@launch
        }

        dispatchPendingMessages(model = model)
      }
  }

  private fun requestMergeAndStop(model: Model) {
    if (!metaState.value.inProgress) {
      return
    }

    stopRequested.value = true
    activeDispatchSuperseded = true
    metaState.update { current -> current.copy(errorMessage = null) }
    Log.d(
      TAG,
      "send merge requested sessionId=$sessionId model=${model.name} pendingCount=${metaState.value.pendingUserMessages.size} activeAssistantMessageId=$activeAssistantMessageId",
    )
    model.runtimeHelper.stopResponse(model)
  }

  private fun dispatchPendingMessages(model: Model) {
    val queuedMessages = metaState.value.pendingUserMessages
    if (queuedMessages.isEmpty() || metaState.value.inProgress) {
      return
    }

    val stagedTurn = stageDispatchTurn(userMessages = queuedMessages.map { it.message }, model = model)
    val persistedIds = queuedMessages.filter { it.persisted }.mapTo(mutableSetOf()) { it.message.id }
    val queuedIds = queuedMessages.mapTo(mutableSetOf()) { it.message.id }
    val dispatchStartedAt = SystemClock.elapsedRealtime()

    stopRequested.value = false
    activeAssistantMessageId = stagedTurn.assistantMessage.id
    activeDispatchSuperseded = false
    metaState.update { current ->
      current.copy(
        inProgress = true,
        errorMessage = null,
      )
    }
    Log.d(
      TAG,
      "dispatch starting sessionId=$sessionId model=${model.name} pendingCount=${queuedMessages.size} persistedCount=${persistedIds.size} combinedLength=${stagedTurn.combinedUserInput.length} assistantMessageId=${stagedTurn.assistantMessage.id}",
    )

    viewModelScope.launch(Dispatchers.IO) {
      val pendingMessage =
        sendRoleplayMessageUseCase.enqueuePendingMessage(
          sessionId = sessionId,
          stagedTurn = stagedTurn,
          persistedUserMessageIds = persistedIds,
        )

      if (pendingMessage == null) {
        Log.d(
          TAG,
          "dispatch queue failed after ${SystemClock.elapsedRealtime() - dispatchStartedAt}ms sessionId=$sessionId",
        )
        draft.value = stagedTurn.combinedUserInput
        stopRequested.value = false
        activeAssistantMessageId = null
        metaState.update { current ->
          current.copy(
            pendingUserMessages = current.pendingUserMessages.filterNot { it.message.id in queuedIds },
            inProgress = false,
            errorMessage = "Session no longer exists.",
          )
        }
        return@launch
      }

      metaState.update { current ->
        current.copy(
          pendingUserMessages =
            current.pendingUserMessages.map { queued ->
              if (queued.message.id in queuedIds) {
                queued.copy(persisted = true)
              } else {
                queued
              }
            }
        )
      }
      Log.d(
        TAG,
        "dispatch queued after ${SystemClock.elapsedRealtime() - dispatchStartedAt}ms sessionId=$sessionId assistantMessageId=${pendingMessage.assistantSeed.id}",
      )

      val result =
        sendRoleplayMessageUseCase.completePendingMessage(
          pendingMessage = pendingMessage,
          model = model,
          isStopRequested = { stopRequested.value },
        )
      val superseded = activeDispatchSuperseded

      Log.d(
        TAG,
        "dispatch finished after ${SystemClock.elapsedRealtime() - dispatchStartedAt}ms sessionId=$sessionId interrupted=${result.interrupted} superseded=$superseded error=${result.errorMessage != null}",
      )

      if (superseded && result.assistantMessage != null) {
        conversationRepository.updateMessage(
          result.assistantMessage.copy(
            content = "",
            status = MessageStatus.INTERRUPTED,
            errorMessage = null,
            updatedAt = System.currentTimeMillis(),
          )
        )
      }

      if (!superseded && result.assistantMessage != null && result.assistantMessage.status == MessageStatus.COMPLETED) {
        launch(Dispatchers.Default) {
          playReceiveSound()
        }
      }
      if (!superseded && result.errorMessage != null && !result.interrupted) {
        draft.value = stagedTurn.combinedUserInput
      }

      stopRequested.value = false
      activeAssistantMessageId = null
      activeDispatchSuperseded = false
      metaState.update { current ->
        current.copy(
          pendingUserMessages =
            if (result.interrupted || superseded) {
              current.pendingUserMessages
            } else {
              current.pendingUserMessages.filterNot { it.message.id in queuedIds }
            },
          inProgress = false,
          errorMessage = if (result.interrupted || superseded) null else result.errorMessage,
        )
      }
      refreshSupplementalState()

      if (metaState.value.pendingUserMessages.isNotEmpty()) {
        scheduleDispatch(reason = "pending queue remains after completion")
      }
    }
  }

  private fun refreshSupplementalState() {
    viewModelScope.launch {
      val session = conversationRepository.getSession(sessionId)
      if (session == null) {
        metaState.update { current ->
          current.copy(summary = null, pinnedMemories = emptyList())
        }
        return@launch
      }

      val summary = conversationRepository.getSummary(sessionId)
      val pinnedMemories = loadPinnedMemories(session)
      metaState.update { current ->
        current.copy(summary = summary, pinnedMemories = pinnedMemories)
      }
    }
  }

  private suspend fun loadPinnedMemories(session: Session): List<MemoryItem> {
    return (memoryRepository.listSessionMemories(session.id) + memoryRepository.listRoleMemories(session.roleId))
      .filter { it.pinned }
      .distinctBy { it.normalizedHash }
      .sortedByDescending { it.updatedAt }
      .take(8)
  }

  private fun stagePendingUserMessage(input: String): QueuedUserMessage {
    val now = System.currentTimeMillis()
    val nextSeq = (uiState.value.messages.maxOfOrNull { it.seq } ?: 0) + 1
    val userMessage =
      Message(
        id = UUID.randomUUID().toString(),
        sessionId = sessionId,
        seq = nextSeq,
        side = MessageSide.USER,
        status = MessageStatus.COMPLETED,
        content = input,
        createdAt = now,
        updatedAt = now,
      )
    Log.d(TAG, "queued user draft sessionId=$sessionId seq=$nextSeq messageId=${userMessage.id}")
    return QueuedUserMessage(message = userMessage)
  }

  private fun stageDispatchTurn(userMessages: List<Message>, model: Model): StagedRoleplayTurn {
    val now = System.currentTimeMillis()
    val assistantMessage =
      Message(
        id = UUID.randomUUID().toString(),
        sessionId = sessionId,
        seq = (userMessages.maxOfOrNull { it.seq } ?: 0) + 1,
        side = MessageSide.ASSISTANT,
        status = MessageStatus.STREAMING,
        content = "",
        accelerator = model.getStringConfigValue(key = ConfigKeys.ACCELERATOR, defaultValue = ""),
        parentMessageId = userMessages.lastOrNull()?.id,
        createdAt = now,
        updatedAt = now,
      )
    Log.d(
      TAG,
      "dispatch turn staged sessionId=$sessionId userMessageCount=${userMessages.size} assistantMessageId=${assistantMessage.id}",
    )
    return StagedRoleplayTurn(
      userMessages = userMessages,
      assistantMessage = assistantMessage,
      combinedUserInput = userMessages.joinToString(separator = "\n\n") { it.content.trim() },
    )
  }

  private fun remainingDispatchDelay(): Long {
    val elapsed = SystemClock.elapsedRealtime() - lastDraftEditAtElapsed
    return (SEND_DISPATCH_DELAY_MS - elapsed).coerceAtLeast(0L)
  }

  private fun mergeMessages(messages: List<Message>, queuedMessages: List<QueuedUserMessage>): List<Message> {
    val persistedIds = messages.mapTo(mutableSetOf()) { it.id }
    return (messages + queuedMessages.map { it.message }.filterNot { it.id in persistedIds })
      .filterNot { message ->
        message.side == MessageSide.ASSISTANT &&
          message.status == MessageStatus.INTERRUPTED &&
          message.content.isBlank()
      }
      .sortedWith(compareBy<Message>({ it.seq }, { it.createdAt }, { it.id }))
  }

  private fun String.escapeJson(): String {
    return replace("\\", "\\\\").replace("\"", "\\\"")
  }

  private fun playSendSound() {
    if (!dataStoreRepository.areMessageSoundsEnabled()) {
      return
    }
    RoleplaySoundEffectPlayer.playSend(appContext)
  }

  private fun playReceiveSound() {
    if (!dataStoreRepository.areMessageSoundsEnabled()) {
      return
    }
    RoleplaySoundEffectPlayer.playReceive(appContext)
  }
}
