package selfgemma.talk.feature.roleplay.sessions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import selfgemma.talk.domain.roleplay.repository.ConversationRepository
import selfgemma.talk.domain.roleplay.repository.RoleRepository
import selfgemma.talk.domain.roleplay.usecase.EnsureRoleplaySeedDataUseCase
import selfgemma.talk.domain.roleplay.usecase.ExportStChatJsonlFromSessionUseCase
import selfgemma.talk.domain.roleplay.usecase.ImportStChatJsonlIntoSessionUseCase

data class SessionListItemUiState(
  val id: String,
  val title: String,
  val roleName: String,
  val avatarUri: String?,
  val pinned: Boolean,
  val updatedAt: Long,
  val lastMessage: String,
)

data class SessionsUiState(
  val loading: Boolean = true,
  val sessions: List<SessionListItemUiState> = emptyList(),
  val statusMessage: String? = null,
  val errorMessage: String? = null,
)

@HiltViewModel
class SessionsViewModel
@Inject
constructor(
  private val conversationRepository: ConversationRepository,
  roleRepository: RoleRepository,
  ensureRoleplaySeedData: EnsureRoleplaySeedDataUseCase,
  private val importStChatJsonlIntoSessionUseCase: ImportStChatJsonlIntoSessionUseCase,
  private val exportStChatJsonlFromSessionUseCase: ExportStChatJsonlFromSessionUseCase,
) : ViewModel() {
  private val feedbackState = MutableStateFlow(SessionsUiState(loading = false))

  val uiState: StateFlow<SessionsUiState> =
    combine(
      conversationRepository.observeSessions(),
      roleRepository.observeRoles(),
      feedbackState,
    ) { sessions, roles, feedback ->
      val rolesById = roles.associateBy { it.id }
      SessionsUiState(
        loading = false,
        sessions =
          sessions.map { session ->
            val role = rolesById[session.roleId]
            SessionListItemUiState(
              id = session.id,
              title = session.title,
              roleName = role?.name ?: "Unknown role",
              avatarUri = role?.avatarUri,
              pinned = session.pinned,
              updatedAt = session.updatedAt,
              lastMessage =
                session.lastAssistantMessageExcerpt
                  ?: session.lastUserMessageExcerpt
                  ?: session.lastSummary
                  ?: "No messages yet",
            )
          },
        statusMessage = feedback.statusMessage,
        errorMessage = feedback.errorMessage,
      )
    }
      .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SessionsUiState(),
      )

  init {
    viewModelScope.launch {
      ensureRoleplaySeedData()
    }
  }

  fun togglePin(sessionId: String) {
    viewModelScope.launch {
      val session = conversationRepository.getSession(sessionId) ?: return@launch
      val now = System.currentTimeMillis()
      conversationRepository.updateSession(
        session.copy(pinned = !session.pinned, updatedAt = now, lastMessageAt = session.lastMessageAt)
      )
    }
  }

  fun archiveSession(sessionId: String) {
    viewModelScope.launch {
      conversationRepository.archiveSession(sessionId)
    }
  }

  fun deleteSession(sessionId: String) {
    viewModelScope.launch {
      conversationRepository.deleteSession(sessionId)
    }
  }

  fun importChatJsonl(sessionId: String, uri: String) {
    viewModelScope.launch {
      runCatching {
        importStChatJsonlIntoSessionUseCase.importIntoSession(sessionId = sessionId, uri = uri)
      }
        .onSuccess {
          feedbackState.update {
            it.copy(
              statusMessage = "Imported ST chat JSONL into the selected session.",
              errorMessage = null,
            )
          }
        }
        .onFailure { error ->
          feedbackState.update {
            it.copy(
              statusMessage = null,
              errorMessage = error.message ?: "Failed to import ST chat JSONL.",
            )
          }
        }
    }
  }

  fun exportChatJsonl(sessionId: String, uri: String) {
    viewModelScope.launch {
      runCatching {
        exportStChatJsonlFromSessionUseCase.exportFromSession(sessionId = sessionId, uri = uri)
      }
        .onSuccess {
          feedbackState.update {
            it.copy(
              statusMessage = "Exported ST chat JSONL to the selected location.",
              errorMessage = null,
            )
          }
        }
        .onFailure { error ->
          feedbackState.update {
            it.copy(
              statusMessage = null,
              errorMessage = error.message ?: "Failed to export ST chat JSONL.",
            )
          }
        }
    }
  }
}
