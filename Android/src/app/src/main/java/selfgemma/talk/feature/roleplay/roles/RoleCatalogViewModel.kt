package selfgemma.talk.feature.roleplay.roles

import android.content.Context
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import selfgemma.talk.R
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.repository.RoleRepository
import selfgemma.talk.domain.roleplay.usecase.CompileRuntimeRoleProfileUseCase
import selfgemma.talk.domain.roleplay.usecase.CreateRoleplaySessionUseCase
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
  @ApplicationContext private val appContext: Context,
  private val roleRepository: RoleRepository,
  private val createRoleplaySessionUseCase: CreateRoleplaySessionUseCase,
  private val importStRoleCardFromUriUseCase: ImportStRoleCardFromUriUseCase,
  private val compileRuntimeRoleProfileUseCase: CompileRuntimeRoleProfileUseCase,
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
    return createRoleplaySessionUseCase(roleId = roleId, modelId = modelId).id
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
          roleRepository.saveRole(compileRuntimeRoleProfileUseCase(importedRole))
          feedbackState.update {
            it.copy(
              statusMessage = appString(R.string.role_catalog_status_st_imported),
              errorMessage = null,
            )
          }
        }
        .onFailure { error ->
          feedbackState.update {
            it.copy(
              statusMessage = null,
              errorMessage = error.message ?: appString(R.string.role_catalog_error_st_import_failed),
            )
          }
        }
    }
  }

  private fun appString(@StringRes resId: Int, vararg args: Any): String {
    return appContext.getString(resId, *args)
  }
}
