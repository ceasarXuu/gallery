package selfgemma.talk.feature.roleplay.chat

import android.media.ToneGenerator
import android.media.AudioManager
import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import selfgemma.talk.data.Model
import selfgemma.talk.domain.roleplay.model.MemoryCategory
import selfgemma.talk.domain.roleplay.model.MemoryItem
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.Session
import selfgemma.talk.domain.roleplay.model.SessionEvent
import selfgemma.talk.domain.roleplay.model.SessionEventType
import selfgemma.talk.domain.roleplay.model.SessionSummary
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.repository.ConversationRepository
import selfgemma.talk.domain.roleplay.repository.MemoryRepository
import selfgemma.talk.domain.roleplay.repository.RoleRepository
import selfgemma.talk.domain.roleplay.usecase.ExtractMemoriesUseCase
import selfgemma.talk.domain.roleplay.usecase.SendRoleplayMessageUseCase
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

private data class RoleplayChatMetaState(
  val summary: SessionSummary? = null,
  val pinnedMemories: List<MemoryItem> = emptyList(),
  val inProgress: Boolean = false,
  val errorMessage: String? = null,
)

@HiltViewModel
class RoleplayChatViewModel
@Inject
constructor(
  savedStateHandle: SavedStateHandle,
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
        messages = messages,
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
    refreshSupplementalState()
  }

  fun updateDraft(value: String) {
    draft.value = value
  }

  fun sendMessage(model: Model) {
    if (metaState.value.inProgress) {
      return
    }

    val input = draft.value.trim()
    if (input.isBlank()) {
      return
    }

    playSendSound()
    draft.value = ""
    stopRequested.value = false
    metaState.update { current -> current.copy(inProgress = true, errorMessage = null) }
    val clickTimestamp = SystemClock.elapsedRealtime()
    Log.d(
      TAG,
      "send click accepted sessionId=$sessionId model=${model.name} inputLength=${input.length}",
    )

    viewModelScope.launch(Dispatchers.IO) {
      Log.d(
        TAG,
        "send worker started after ${SystemClock.elapsedRealtime() - clickTimestamp}ms sessionId=$sessionId",
      )
      val result =
        sendRoleplayMessageUseCase(
          sessionId = sessionId,
          model = model,
          userInput = input,
          isStopRequested = { stopRequested.value },
        )

      Log.d(
        TAG,
        "send worker finished after ${SystemClock.elapsedRealtime() - clickTimestamp}ms sessionId=$sessionId error=${result.errorMessage != null} interrupted=${result.interrupted}",
      )

      if (result.errorMessage != null && !result.interrupted) {
        draft.value = input
      } else if (result.assistantMessage != null && result.assistantMessage.status.name == "COMPLETED") {
        playReceiveSound()
      }

      stopRequested.value = false
      metaState.update { current ->
        current.copy(inProgress = false, errorMessage = result.errorMessage)
      }
      refreshSupplementalState()
    }
  }

  fun stopGeneration(model: Model) {
    if (!metaState.value.inProgress) {
      return
    }

    stopRequested.value = true
    metaState.update { current -> current.copy(errorMessage = null) }
    model.runtimeHelper.stopResponse(model)
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

  private fun String.escapeJson(): String {
    return replace("\\", "\\\\").replace("\"", "\\\"")
  }

  private fun playSendSound() {
    try {
      val toneGenerator = ToneGenerator(AudioManager.STREAM_NOTIFICATION, 80)
      toneGenerator.startTone(ToneGenerator.TONE_PROP_ACK, 150)
      toneGenerator.release()
    } catch (e: Exception) {
    }
  }

  private fun playReceiveSound() {
    try {
      val toneGenerator = ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100)
      toneGenerator.startTone(ToneGenerator.TONE_PROP_BEEP2, 200)
      toneGenerator.release()
    } catch (e: Exception) {
    }
  }
}