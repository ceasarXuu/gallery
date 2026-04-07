package selfgemma.talk.feature.roleplay.roles

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.usecase.ExportStV2RoleCardToUriUseCase
import selfgemma.talk.domain.roleplay.usecase.ImportStV2RoleCardFromUriUseCase
import selfgemma.talk.domain.roleplay.repository.RoleRepository

data class RoleEditorUiState(
  val loading: Boolean = true,
  val roleId: String? = null,
  val isNewRole: Boolean = true,
  val builtIn: Boolean = false,
  val name: String = "",
  val summary: String = "",
  val systemPrompt: String = "",
  val personaDescription: String = "",
  val worldSettings: String = "",
  val openingLine: String = "",
  val safetyPolicy: String = "",
  val tagsText: String = "",
  val defaultModelId: String? = null,
  val statusMessage: String? = null,
  val errorMessage: String? = null,
)

@HiltViewModel
class RoleEditorViewModel
@Inject
constructor(
  savedStateHandle: SavedStateHandle,
  private val roleRepository: RoleRepository,
  private val importStV2RoleCardFromUriUseCase: ImportStV2RoleCardFromUriUseCase,
  private val exportStV2RoleCardToUriUseCase: ExportStV2RoleCardToUriUseCase,
) : ViewModel() {
  private val editingRoleId: String? = savedStateHandle.get<String?>("roleId")?.takeIf { it.isNotBlank() }
  private val _uiState = MutableStateFlow(RoleEditorUiState())
  val uiState: StateFlow<RoleEditorUiState> = _uiState.asStateFlow()
  private var loadedRole: RoleCard? = null

  init {
    loadRole()
  }

  fun updateName(value: String) {
    _uiState.update { it.copy(name = value, errorMessage = null, statusMessage = null) }
  }

  fun updateSummary(value: String) {
    _uiState.update { it.copy(summary = value, errorMessage = null, statusMessage = null) }
  }

  fun updateSystemPrompt(value: String) {
    _uiState.update { it.copy(systemPrompt = value, errorMessage = null, statusMessage = null) }
  }

  fun updatePersonaDescription(value: String) {
    _uiState.update { it.copy(personaDescription = value, errorMessage = null, statusMessage = null) }
  }

  fun updateWorldSettings(value: String) {
    _uiState.update { it.copy(worldSettings = value, errorMessage = null, statusMessage = null) }
  }

  fun updateOpeningLine(value: String) {
    _uiState.update { it.copy(openingLine = value, errorMessage = null, statusMessage = null) }
  }

  fun updateSafetyPolicy(value: String) {
    _uiState.update { it.copy(safetyPolicy = value, errorMessage = null, statusMessage = null) }
  }

  fun updateTagsText(value: String) {
    _uiState.update { it.copy(tagsText = value, errorMessage = null, statusMessage = null) }
  }

  fun updateDefaultModelId(value: String?) {
    _uiState.update { it.copy(defaultModelId = value, errorMessage = null, statusMessage = null) }
  }

  fun importStCardFromUri(uri: String) {
    viewModelScope.launch {
      runCatching {
        val existingRole = editingRoleId?.let { roleId -> roleRepository.getRole(roleId) }
        importStV2RoleCardFromUriUseCase.importFromUri(
          uri = uri,
          existingRole = existingRole,
        )
      }
        .onSuccess { importedRole ->
          loadedRole = importedRole
          _uiState.value =
            RoleEditorUiState(
              loading = false,
              roleId = importedRole.id,
              isNewRole = editingRoleId == null,
              builtIn = false,
              name = importedRole.name,
              summary = importedRole.summary,
              systemPrompt = importedRole.systemPrompt,
              personaDescription = importedRole.personaDescription,
              worldSettings = importedRole.worldSettings,
              openingLine = importedRole.openingLine,
              safetyPolicy = importedRole.safetyPolicy,
              tagsText = importedRole.tags.joinToString(", "),
              defaultModelId = importedRole.defaultModelId,
              statusMessage = "Imported ST role card JSON. Review and save to persist changes.",
            )
        }
        .onFailure { error ->
          _uiState.update {
            it.copy(
              errorMessage = error.message ?: "Failed to import ST role card JSON.",
              statusMessage = null,
            )
          }
        }
    }
  }

  fun exportStCardToUri(uri: String) {
    val snapshot = buildRoleSnapshot() ?: return
    viewModelScope.launch {
      runCatching {
        exportStV2RoleCardToUriUseCase.exportToUri(
          uri = uri,
          role = snapshot,
        )
      }
        .onSuccess {
          _uiState.update {
            it.copy(
              statusMessage = "Exported ST role card JSON to the selected location.",
              errorMessage = null,
            )
          }
        }
        .onFailure { error ->
          _uiState.update {
            it.copy(
              errorMessage = error.message ?: "Failed to export ST role card JSON.",
              statusMessage = null,
            )
          }
        }
    }
  }

  fun saveRole(onSaved: (String) -> Unit) {
    val role = buildRoleSnapshot() ?: return

    viewModelScope.launch {
      roleRepository.saveRole(role)
      onSaved(role.id)
    }
  }

  fun deleteRole(onDeleted: () -> Unit) {
    val roleId = _uiState.value.roleId ?: return
    viewModelScope.launch {
      roleRepository.deleteRole(roleId)
      onDeleted()
    }
  }

  private fun buildRoleSnapshot(): RoleCard? {
    val snapshot = _uiState.value
    val roleName = snapshot.name.trim()
    val systemPrompt = snapshot.systemPrompt.trim()
    if (roleName.isBlank() || systemPrompt.isBlank()) {
      _uiState.update {
        it.copy(errorMessage = "Role name and system prompt are required.")
      }
      return null
    }

    val now = System.currentTimeMillis()
    val existingRole = loadedRole

    return RoleCard(
      id = editingRoleId ?: UUID.randomUUID().toString(),
      name = roleName,
      summary = snapshot.summary.trim(),
      systemPrompt = systemPrompt,
      personaDescription = snapshot.personaDescription.trim(),
      worldSettings = snapshot.worldSettings.trim(),
      openingLine = snapshot.openingLine.trim(),
      safetyPolicy = snapshot.safetyPolicy.trim(),
      defaultModelId = snapshot.defaultModelId,
      tags = snapshot.tagsText.toTagList(),
      builtIn = snapshot.builtIn,
      createdAt = existingRole?.createdAt ?: now,
      updatedAt = now,
      exampleDialogues = existingRole?.exampleDialogues.orEmpty(),
      defaultTemperature = existingRole?.defaultTemperature,
      defaultTopP = existingRole?.defaultTopP,
      defaultTopK = existingRole?.defaultTopK,
      enableThinking = existingRole?.enableThinking ?: false,
      summaryTurnThreshold = existingRole?.summaryTurnThreshold ?: 6,
      memoryEnabled = existingRole?.memoryEnabled ?: true,
      memoryMaxItems = existingRole?.memoryMaxItems ?: 32,
      avatarUri = existingRole?.avatarUri,
      coverUri = existingRole?.coverUri,
      cardCore = existingRole?.cardCore,
      runtimeProfile = existingRole?.runtimeProfile,
      interopState = existingRole?.interopState,
      archived = false,
    )
  }

  private fun loadRole() {
    viewModelScope.launch {
      val role: RoleCard? = editingRoleId?.let { roleId -> roleRepository.getRole(roleId) }
      if (role == null) {
        loadedRole = null
        _uiState.value =
          RoleEditorUiState(
            loading = false,
            roleId = null,
            isNewRole = true,
            systemPrompt = "Stay in character, answer naturally, and maintain continuity with the user's previous turns.",
          )
        return@launch
      }

      loadedRole = role
      _uiState.value =
        RoleEditorUiState(
          loading = false,
          roleId = role.id,
          isNewRole = false,
          builtIn = role.builtIn,
          name = role.name,
          summary = role.summary,
          systemPrompt = role.systemPrompt,
          personaDescription = role.personaDescription,
          worldSettings = role.worldSettings,
          openingLine = role.openingLine,
          safetyPolicy = role.safetyPolicy,
          tagsText = role.tags.joinToString(", "),
          defaultModelId = role.defaultModelId,
          statusMessage = null,
        )
    }
  }
}

private fun String.toTagList(): List<String> {
  return split(",")
    .map { it.trim() }
    .filter { it.isNotBlank() }
    .distinct()
}
