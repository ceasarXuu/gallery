package selfgemma.talk.feature.roleplay.roles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.repository.ConversationRepository
import selfgemma.talk.domain.roleplay.repository.RoleRepository
import selfgemma.talk.domain.roleplay.usecase.ImportStRoleCardFromUriUseCase

data class RoleCatalogUiState(
  val loading: Boolean = true,
  val builtInRoles: List<RoleCard> = emptyList(),
  val customRoles: List<RoleCard> = emptyList(),
  val statusMessage: String? = null,
  val errorMessage: String? = null,
)

@HiltViewModel
class RoleCatalogViewModel
@Inject
constructor(
  private val roleRepository: RoleRepository,
  private val conversationRepository: ConversationRepository,
  private val importStRoleCardFromUriUseCase: ImportStRoleCardFromUriUseCase,
) : ViewModel() {
  private val feedbackState = MutableStateFlow(RoleCatalogUiState(loading = false))

  val uiState: StateFlow<RoleCatalogUiState> =
    combine(roleRepository.observeRoles(), feedbackState) { roles, feedback ->
      RoleCatalogUiState(
        loading = false,
        builtInRoles = roles.filter { it.builtIn },
        customRoles = roles.filterNot { it.builtIn },
        statusMessage = feedback.statusMessage,
        errorMessage = feedback.errorMessage,
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

  fun importStRoleCard(uri: String) {
    viewModelScope.launch {
      runCatching {
        importStRoleCardFromUriUseCase.importFromUri(uri = uri)
      }
        .onSuccess { importedRole ->
          roleRepository.saveRole(importedRole)
          feedbackState.update {
            it.copy(
              statusMessage = "Imported ST role card into your custom roles.",
              errorMessage = null,
            )
          }
        }
        .onFailure { error ->
          feedbackState.update {
            it.copy(
              statusMessage = null,
              errorMessage = error.message ?: "Failed to import ST role card.",
            )
          }
        }
    }
  }
}
