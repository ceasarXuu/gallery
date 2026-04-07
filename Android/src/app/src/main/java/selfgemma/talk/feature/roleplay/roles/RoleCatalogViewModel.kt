package selfgemma.talk.feature.roleplay.roles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.repository.ConversationRepository
import selfgemma.talk.domain.roleplay.repository.RoleRepository

data class RoleCatalogUiState(
  val loading: Boolean = true,
  val builtInRoles: List<RoleCard> = emptyList(),
  val customRoles: List<RoleCard> = emptyList(),
)

@HiltViewModel
class RoleCatalogViewModel
@Inject
constructor(
  private val roleRepository: RoleRepository,
  private val conversationRepository: ConversationRepository,
) : ViewModel() {
  val uiState: StateFlow<RoleCatalogUiState> =
    roleRepository.observeRoles().map { roles ->
      RoleCatalogUiState(
        loading = false,
        builtInRoles = roles.filter { it.builtIn },
        customRoles = roles.filterNot { it.builtIn },
      )
    }
      .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = RoleCatalogUiState(),
      )

  suspend fun createSession(roleId: String, modelId: String): String {
    return conversationRepository.createSession(roleId = roleId, modelId = modelId).id
  }

  fun deleteRole(roleId: String) {
    viewModelScope.launch {
      roleRepository.deleteRole(roleId)
    }
  }
}