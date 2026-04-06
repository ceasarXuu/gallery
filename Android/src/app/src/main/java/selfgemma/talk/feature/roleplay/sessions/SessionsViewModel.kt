package selfgemma.talk.feature.roleplay.sessions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import selfgemma.talk.domain.roleplay.repository.ConversationRepository
import selfgemma.talk.domain.roleplay.repository.RoleRepository
import selfgemma.talk.domain.roleplay.usecase.EnsureRoleplaySeedDataUseCase

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
  val errorMessage: String? = null,
)

@HiltViewModel
class SessionsViewModel
@Inject
constructor(
  private val conversationRepository: ConversationRepository,
  roleRepository: RoleRepository,
  ensureRoleplaySeedData: EnsureRoleplaySeedDataUseCase,
) : ViewModel() {
  val uiState: StateFlow<SessionsUiState> =
    combine(conversationRepository.observeSessions(), roleRepository.observeRoles()) { sessions, roles ->
      SessionsUiState(
        loading = false,
        sessions =
          sessions.map { session ->
            val role = roles.find { it.id == session.roleId }
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
}