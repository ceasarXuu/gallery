package selfgemma.talk.feature.roleplay.roles

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.UUID
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import selfgemma.talk.R
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.RoleCardSourceFormat
import selfgemma.talk.domain.roleplay.model.RoleMediaAsset
import selfgemma.talk.domain.roleplay.model.RoleMediaExportPolicy
import selfgemma.talk.domain.roleplay.model.RoleMediaImportState
import selfgemma.talk.domain.roleplay.model.RoleMediaKind
import selfgemma.talk.domain.roleplay.model.RoleMediaProfile
import selfgemma.talk.domain.roleplay.model.RoleMediaSource
import selfgemma.talk.domain.roleplay.model.RoleMediaUsage
import selfgemma.talk.domain.roleplay.model.RoleSpriteAsset
import selfgemma.talk.domain.roleplay.model.StCharacterCardData
import selfgemma.talk.domain.roleplay.model.coverImageUri
import selfgemma.talk.domain.roleplay.model.primaryAvatarUri
import selfgemma.talk.domain.roleplay.model.resolvedDescription
import selfgemma.talk.domain.roleplay.model.resolvedFirstMessage
import selfgemma.talk.domain.roleplay.model.resolvedName
import selfgemma.talk.domain.roleplay.model.resolvedOpeningLine
import selfgemma.talk.domain.roleplay.model.resolvedPersonality
import selfgemma.talk.domain.roleplay.model.resolvedPersonaDescription
import selfgemma.talk.domain.roleplay.model.resolvedScenario
import selfgemma.talk.domain.roleplay.model.resolvedSummary
import selfgemma.talk.domain.roleplay.model.resolvedSystemPrompt
import selfgemma.talk.domain.roleplay.model.resolvedTags
import selfgemma.talk.domain.roleplay.model.resolvedWorldSettings
import selfgemma.talk.domain.roleplay.model.StCharacterCard
import selfgemma.talk.domain.roleplay.usecase.ExportStRoleCardToUriUseCase
import selfgemma.talk.domain.roleplay.usecase.ImportStRoleCardFromUriUseCase
import selfgemma.talk.domain.roleplay.repository.RoleRepository
import selfgemma.talk.domain.roleplay.model.withUpdatedCoreFields

data class RoleEditorUiState(
  val loading: Boolean = true,
  val roleId: String? = null,
  val isNewRole: Boolean = true,
  val builtIn: Boolean = false,
  val stCard: StCharacterCard = emptyEditorStCard(),
  val name: String = "",
  val summary: String = "",
  val systemPrompt: String = "",
  val personaDescription: String = "",
  val worldSettings: String = "",
  val openingLine: String = "",
  val safetyPolicy: String = "",
  val tagsText: String = "",
  val defaultModelId: String? = null,
  val avatarUri: String? = null,
  val coverUri: String? = null,
  val avatarSource: RoleMediaSource? = null,
  val coverSource: RoleMediaSource? = null,
  val galleryAssets: List<RoleMediaAsset> = emptyList(),
  val spriteAssets: List<RoleSpriteAsset> = emptyList(),
  val importedFromStPng: Boolean = false,
  val statusMessage: String? = null,
  val errorMessage: String? = null,
)

@HiltViewModel
class RoleEditorViewModel
@Inject
constructor(
  savedStateHandle: SavedStateHandle,
  @ApplicationContext private val appContext: Context,
  private val roleRepository: RoleRepository,
  private val importStRoleCardFromUriUseCase: ImportStRoleCardFromUriUseCase,
  private val exportStRoleCardToUriUseCase: ExportStRoleCardToUriUseCase,
) : ViewModel() {
  private val editingRoleId: String? = savedStateHandle.get<String?>("roleId")?.takeIf { it.isNotBlank() }
  private val _uiState = MutableStateFlow(RoleEditorUiState())
  val uiState: StateFlow<RoleEditorUiState> = _uiState.asStateFlow()
  private var loadedRole: RoleCard? = null

  init {
    loadRole()
  }

  fun updateName(value: String) {
    updateCanonicalCard { card ->
      card.withUpdatedCoreFields(name = value, systemPrompt = card.resolvedSystemPrompt())
    }
  }

  fun updateSummary(value: String) {
    updateCanonicalCard { card ->
      card.withUpdatedCoreFields(description = value, systemPrompt = card.resolvedSystemPrompt())
    }
  }

  fun updateSystemPrompt(value: String) {
    updateCanonicalCard { card ->
      card.withUpdatedCoreFields(systemPrompt = value)
    }
  }

  fun updatePersonaDescription(value: String) {
    updateCanonicalCard { card ->
      card.withUpdatedCoreFields(personality = value, systemPrompt = card.resolvedSystemPrompt())
    }
  }

  fun updateWorldSettings(value: String) {
    updateCanonicalCard { card ->
      card.withUpdatedCoreFields(scenario = value, systemPrompt = card.resolvedSystemPrompt())
    }
  }

  fun updateOpeningLine(value: String) {
    updateCanonicalCard { card ->
      card.withUpdatedCoreFields(firstMessage = value, systemPrompt = card.resolvedSystemPrompt())
    }
  }

  fun updateSafetyPolicy(value: String) {
    _uiState.update { it.copy(safetyPolicy = value, errorMessage = null, statusMessage = null) }
  }

  fun updateTagsText(value: String) {
    val updatedTags = value.toTagList()
    _uiState.update {
      val nextCard = it.stCard.withUpdatedCoreFields(tags = updatedTags, systemPrompt = it.stCard.resolvedSystemPrompt())
      it.copy(
        stCard = nextCard,
        tagsText = value,
        errorMessage = null,
        statusMessage = null,
      )
    }
  }

  fun updateDefaultModelId(value: String?) {
    _uiState.update { it.copy(defaultModelId = value, errorMessage = null, statusMessage = null) }
  }

  fun updateAvatarUri(value: String?) {
    val now = System.currentTimeMillis()
    _uiState.update {
      it.copy(
        avatarUri = value,
        avatarSource = if (value.isNullOrBlank()) null else RoleMediaSource.LOCAL_PICKER,
        errorMessage = null,
        statusMessage =
          if (value.isNullOrBlank()) {
            appContext.getString(R.string.role_editor_status_avatar_cleared)
          } else {
            appContext.getString(R.string.role_editor_status_avatar_updated)
          },
        importedFromStPng = false,
      )
    }
    syncPrimaryAvatarAsset(uri = value, source = RoleMediaSource.LOCAL_PICKER, now = now)
  }

  fun updateCoverUri(value: String?) {
    val now = System.currentTimeMillis()
    _uiState.update {
      it.copy(
        coverUri = value,
        coverSource = if (value.isNullOrBlank()) null else RoleMediaSource.LOCAL_PICKER,
        errorMessage = null,
        statusMessage =
          if (value.isNullOrBlank()) {
            appContext.getString(R.string.role_editor_status_cover_cleared)
          } else {
            appContext.getString(R.string.role_editor_status_cover_updated)
          },
      )
    }
    syncCoverImageAsset(uri = value, now = now)
  }

  fun addGalleryAssets(uris: List<String>) {
    if (uris.isEmpty()) {
      return
    }
    val now = System.currentTimeMillis()
    val newAssets =
      uris.distinct().map { uri ->
        RoleMediaAsset(
          id = UUID.randomUUID().toString(),
          kind = RoleMediaKind.GALLERY,
          uri = uri,
          displayName = uri.substringAfterLast('/').substringBefore('?').ifBlank { null },
          source = RoleMediaSource.LOCAL_PICKER,
          createdAt = now,
          updatedAt = now,
        )
      }
    _uiState.update {
      it.copy(
        galleryAssets = it.galleryAssets + newAssets,
        statusMessage = appContext.getString(R.string.role_editor_status_gallery_added, newAssets.size),
        errorMessage = null,
      )
    }
  }

  fun removeGalleryAsset(assetId: String) {
    _uiState.update {
      val removedAsset = it.galleryAssets.firstOrNull { asset -> asset.id == assetId }
      it.copy(
        galleryAssets = it.galleryAssets.filterNot { asset -> asset.id == assetId },
        avatarUri = if (removedAsset?.uri == it.avatarUri) null else it.avatarUri,
        avatarSource = if (removedAsset?.uri == it.avatarUri) null else it.avatarSource,
        coverUri = if (removedAsset?.uri == it.coverUri) null else it.coverUri,
        coverSource = if (removedAsset?.uri == it.coverUri) null else it.coverSource,
        importedFromStPng = if (removedAsset?.uri == it.avatarUri) false else it.importedFromStPng,
        statusMessage = appContext.getString(R.string.role_editor_status_gallery_removed),
        errorMessage = null,
      )
    }
  }

  fun updateGalleryAssetName(assetId: String, value: String) {
    updateGalleryAsset(assetId) { asset ->
      asset.copy(displayName = value.ifBlank { null }, updatedAt = System.currentTimeMillis())
    }
  }

  fun updateGalleryAssetUsage(assetId: String, usage: RoleMediaUsage) {
    updateGalleryAsset(assetId) { asset ->
      asset.copy(usage = usage, updatedAt = System.currentTimeMillis())
    }
  }

  fun setGalleryAssetAsAvatar(assetId: String) {
    val asset = _uiState.value.galleryAssets.firstOrNull { it.id == assetId } ?: return
    val now = System.currentTimeMillis()
    _uiState.update {
      it.copy(
        avatarUri = asset.uri,
        avatarSource = asset.source,
        statusMessage = appContext.getString(R.string.role_editor_status_gallery_avatar),
        errorMessage = null,
        importedFromStPng = asset.source == RoleMediaSource.ST_PNG_IMPORT,
      )
    }
    syncPrimaryAvatarAsset(uri = asset.uri, source = asset.source, now = now)
  }

  fun setGalleryAssetAsCover(assetId: String) {
    val asset = _uiState.value.galleryAssets.firstOrNull { it.id == assetId } ?: return
    val now = System.currentTimeMillis()
    _uiState.update {
      it.copy(
        coverUri = asset.uri,
        coverSource = asset.source,
        statusMessage = appContext.getString(R.string.role_editor_status_gallery_cover),
        errorMessage = null,
      )
    }
    syncCoverImageAsset(uri = asset.uri, now = now, source = asset.source)
  }

  fun addSpriteAssets(uris: List<String>) {
    if (uris.isEmpty()) {
      return
    }
    val now = System.currentTimeMillis()
    val newAssets =
      uris.distinct().map { uri ->
        val displayName = uri.substringAfterLast('/').substringBefore('?').ifBlank { null }
        RoleSpriteAsset(
          id = UUID.randomUUID().toString(),
          uri = uri,
          displayName = displayName,
          stateTag = displayName?.substringBeforeLast('.')?.ifBlank { "neutral" } ?: "neutral",
          source = RoleMediaSource.LOCAL_PICKER,
          createdAt = now,
          updatedAt = now,
        )
      }
    _uiState.update {
      it.copy(
        spriteAssets = it.spriteAssets + newAssets,
        statusMessage = appContext.getString(R.string.role_editor_status_sprite_added, newAssets.size),
        errorMessage = null,
      )
    }
  }

  fun removeSpriteAsset(assetId: String) {
    _uiState.update {
      it.copy(
        spriteAssets = it.spriteAssets.filterNot { asset -> asset.id == assetId },
        statusMessage = appContext.getString(R.string.role_editor_status_sprite_removed),
        errorMessage = null,
      )
    }
  }

  fun updateSpriteAssetName(assetId: String, value: String) {
    _uiState.update {
      it.copy(
        spriteAssets =
          it.spriteAssets.map { asset ->
            if (asset.id == assetId) {
              asset.copy(displayName = value.ifBlank { null }, updatedAt = System.currentTimeMillis())
            } else {
              asset
            }
          },
        errorMessage = null,
      )
    }
  }

  fun updateSpriteStateTag(assetId: String, value: String) {
    _uiState.update {
      it.copy(
        spriteAssets =
          it.spriteAssets.map { asset ->
            if (asset.id == assetId) {
              asset.copy(stateTag = value.ifBlank { "neutral" }, updatedAt = System.currentTimeMillis())
            } else {
              asset
            }
          },
        errorMessage = null,
      )
    }
  }

  fun importStCardFromUri(uri: String) {
    viewModelScope.launch {
      runCatching {
        val existingRole = editingRoleId?.let { roleId -> roleRepository.getRole(roleId) }
        importStRoleCardFromUriUseCase.importFromUri(
          uri = uri,
          existingRole = existingRole,
        )
      }
        .onSuccess { importedRole ->
          loadedRole = importedRole
          _uiState.value =
            importedRole.toEditorUiState(
              isNewRole = editingRoleId == null,
              statusMessage = appContext.getString(R.string.role_editor_status_st_imported),
            )
        }
        .onFailure { error ->
          _uiState.update {
            it.copy(
              errorMessage = error.message ?: appContext.getString(R.string.role_editor_error_st_import_failed),
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
        exportStRoleCardToUriUseCase.exportToUri(
          uri = uri,
          role = snapshot,
        )
      }
        .onSuccess {
          _uiState.update {
            it.copy(
              statusMessage = appContext.getString(R.string.role_editor_status_st_exported),
              errorMessage = null,
            )
          }
        }
        .onFailure { error ->
          _uiState.update {
            it.copy(
              errorMessage = error.message ?: appContext.getString(R.string.role_editor_error_st_export_failed),
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
    if (roleName.isBlank()) {
      _uiState.update {
        it.copy(errorMessage = appContext.getString(R.string.role_editor_error_required_fields))
      }
      return null
    }

    val now = System.currentTimeMillis()
    val existingRole = loadedRole
    val roleId = editingRoleId ?: UUID.randomUUID().toString()
    return RoleCard(
      id = roleId,
      stCard = snapshot.stCard,
      safetyPolicy = snapshot.safetyPolicy.trim(),
      defaultModelId = snapshot.defaultModelId,
      builtIn = snapshot.builtIn,
      createdAt = existingRole?.createdAt ?: now,
      updatedAt = now,
      defaultTemperature = existingRole?.defaultTemperature,
      defaultTopP = existingRole?.defaultTopP,
      defaultTopK = existingRole?.defaultTopK,
      enableThinking = existingRole?.enableThinking ?: false,
      summaryTurnThreshold = existingRole?.summaryTurnThreshold ?: 6,
      memoryEnabled = existingRole?.memoryEnabled ?: true,
      memoryMaxItems = existingRole?.memoryMaxItems ?: 32,
      avatarUri = snapshot.avatarUri ?: existingRole?.primaryAvatarUri(),
      coverUri = snapshot.coverUri ?: existingRole?.coverImageUri(),
      runtimeProfile = existingRole?.runtimeProfile,
      mediaProfile =
        RoleMediaProfile(
          primaryAvatar =
            snapshot.avatarUri?.let { uri ->
              RoleMediaAsset(
              id = existingRole?.mediaProfile?.primaryAvatar?.id ?: UUID.randomUUID().toString(),
                kind = RoleMediaKind.PRIMARY_AVATAR,
                uri = uri,
                source =
                  snapshot.avatarSource ?: existingRole?.mediaProfile?.primaryAvatar?.source ?: RoleMediaSource.LOCAL_PICKER,
                createdAt = existingRole?.mediaProfile?.primaryAvatar?.createdAt ?: now,
                updatedAt = now,
              )
            },
          coverImage =
            snapshot.coverUri?.let { uri ->
              RoleMediaAsset(
                id = existingRole?.mediaProfile?.coverImage?.id ?: UUID.randomUUID().toString(),
                kind = RoleMediaKind.COVER,
                uri = uri,
                source = snapshot.coverSource ?: existingRole?.mediaProfile?.coverImage?.source ?: RoleMediaSource.LOCAL_PICKER,
                createdAt = existingRole?.mediaProfile?.coverImage?.createdAt ?: now,
                updatedAt = now,
              )
            },
          galleryAssets = snapshot.galleryAssets,
          spriteAssets = snapshot.spriteAssets,
          exportPolicy = existingRole?.mediaProfile?.exportPolicy ?: RoleMediaExportPolicy(),
          importState =
            existingRole?.mediaProfile?.importState
              ?: RoleMediaImportState(importedFromStPng = snapshot.importedFromStPng),
        ),
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
            stCard = emptyEditorStCard(appContext.getString(R.string.role_editor_default_system_prompt)),
            systemPrompt = appContext.getString(R.string.role_editor_default_system_prompt),
          )
        return@launch
      }

      loadedRole = role
      _uiState.value = role.toEditorUiState(isNewRole = false)
    }
  }

  private fun updateGalleryAsset(assetId: String, transformer: (RoleMediaAsset) -> RoleMediaAsset) {
    _uiState.update {
      it.copy(
        galleryAssets =
          it.galleryAssets.map { asset ->
            if (asset.id == assetId) {
              transformer(asset)
            } else {
              asset
            }
          },
        errorMessage = null,
      )
    }
  }

  private fun updateCanonicalCard(transformer: (StCharacterCard) -> StCharacterCard) {
    _uiState.update { current ->
      val nextCard = transformer(current.stCard)
      current.copy(
        stCard = nextCard,
        name = nextCard.resolvedName(),
        summary = nextCard.resolvedDescription(),
        systemPrompt = nextCard.resolvedSystemPrompt(),
        personaDescription = nextCard.resolvedPersonality(),
        worldSettings = nextCard.resolvedScenario(),
        openingLine = nextCard.resolvedFirstMessage(),
        tagsText = nextCard.resolvedTags().joinToString(", "),
        errorMessage = null,
        statusMessage = null,
      )
    }
  }

  private fun syncPrimaryAvatarAsset(uri: String?, source: RoleMediaSource, now: Long) {
    val existingProfile = loadedRole?.mediaProfile
    loadedRole =
      loadedRole?.copy(
        mediaProfile =
          (existingProfile ?: RoleMediaProfile()).copy(
            primaryAvatar =
              uri?.let {
                RoleMediaAsset(
                  id = existingProfile?.primaryAvatar?.id ?: UUID.randomUUID().toString(),
                  kind = RoleMediaKind.PRIMARY_AVATAR,
                  uri = it,
                  source = source,
                  createdAt = existingProfile?.primaryAvatar?.createdAt ?: now,
                  updatedAt = now,
                )
              },
            importState =
              (existingProfile?.importState ?: RoleMediaImportState()).copy(
                importedFromStPng = source == RoleMediaSource.ST_PNG_IMPORT,
                lastImportedPrimaryAvatarSource = if (source == RoleMediaSource.ST_PNG_IMPORT) uri else existingProfile?.importState?.lastImportedPrimaryAvatarSource,
                lastImportHadEmbeddedImage = source == RoleMediaSource.ST_PNG_IMPORT,
              ),
          ),
      )
  }

  private fun syncCoverImageAsset(
    uri: String?,
    now: Long,
    source: RoleMediaSource = RoleMediaSource.LOCAL_PICKER,
  ) {
    val existingProfile = loadedRole?.mediaProfile
    loadedRole =
      loadedRole?.copy(
        mediaProfile =
          (existingProfile ?: RoleMediaProfile()).copy(
            coverImage =
              uri?.let {
                RoleMediaAsset(
                  id = existingProfile?.coverImage?.id ?: UUID.randomUUID().toString(),
                  kind = RoleMediaKind.COVER,
                  uri = it,
                  source = source,
                  createdAt = existingProfile?.coverImage?.createdAt ?: now,
                  updatedAt = now,
                )
              },
          ),
      )
  }
}

private fun String.toTagList(): List<String> {
  return split(",")
    .map { it.trim() }
    .filter { it.isNotBlank() }
    .distinct()
}

private fun emptyEditorStCard(systemPrompt: String = ""): StCharacterCard {
  return StCharacterCard(
    spec = "chara_card_v2",
    spec_version = "2.0",
    data = StCharacterCardData(system_prompt = systemPrompt),
  )
}

internal fun RoleCard.toEditorUiState(
  isNewRole: Boolean,
  statusMessage: String? = null,
): RoleEditorUiState {
  return RoleEditorUiState(
    loading = false,
    roleId = id,
    isNewRole = isNewRole,
    builtIn = builtIn,
    stCard = stCard,
    name = name,
    summary = resolvedSummary(),
    systemPrompt = resolvedSystemPrompt(),
    personaDescription = resolvedPersonaDescription(),
    worldSettings = resolvedWorldSettings(),
    openingLine = resolvedOpeningLine(),
    safetyPolicy = safetyPolicy,
    tagsText = resolvedTags().joinToString(", "),
    defaultModelId = defaultModelId,
    avatarUri = primaryAvatarUri(),
    coverUri = coverImageUri(),
    avatarSource = mediaProfile?.primaryAvatar?.source,
    coverSource = mediaProfile?.coverImage?.source,
    galleryAssets = mediaProfile?.galleryAssets.orEmpty(),
    spriteAssets = mediaProfile?.spriteAssets.orEmpty(),
    importedFromStPng =
      mediaProfile?.importState?.importedFromStPng
        ?: (interopState?.sourceFormat == RoleCardSourceFormat.ST_PNG),
    statusMessage = statusMessage,
  )
}
