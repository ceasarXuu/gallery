package selfgemma.talk.feature.roleplay.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import selfgemma.talk.data.DataStoreRepository
import selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition
import selfgemma.talk.domain.roleplay.model.StUserProfile

private const val TAG = "MyProfileViewModel"

data class MyProfileUiState(
  val personaName: String = "",
  val personaTitle: String = "",
  val personaDescription: String = "",
  val personaPosition: StPersonaDescriptionPosition = StPersonaDescriptionPosition.IN_PROMPT,
  val personaDepth: String = "2",
  val personaRole: Int = 0,
  val avatarSlotId: String = "",
  val defaultPersonaEnabled: Boolean = true,
  val dirty: Boolean = false,
)

@HiltViewModel
class MyProfileViewModel
@Inject
constructor(
  private val dataStoreRepository: DataStoreRepository,
) : ViewModel() {
  private var persistedProfile: StUserProfile = dataStoreRepository.getStUserProfile()
  private val _uiState = MutableStateFlow(persistedProfile.toUiState())
  val uiState: StateFlow<MyProfileUiState> = _uiState.asStateFlow()

  fun updatePersonaName(value: String) {
    _uiState.value = _uiState.value.copy(personaName = value, dirty = true)
  }

  fun updatePersonaTitle(value: String) {
    _uiState.value = _uiState.value.copy(personaTitle = value, dirty = true)
  }

  fun updatePersonaDescription(value: String) {
    _uiState.value = _uiState.value.copy(personaDescription = value, dirty = true)
  }

  fun updatePersonaPosition(value: StPersonaDescriptionPosition) {
    _uiState.value = _uiState.value.copy(personaPosition = value, dirty = true)
  }

  fun updatePersonaDepth(value: String) {
    _uiState.value = _uiState.value.copy(personaDepth = value, dirty = true)
  }

  fun updatePersonaRole(value: Int) {
    _uiState.value = _uiState.value.copy(personaRole = value, dirty = true)
  }

  fun updateDefaultPersonaEnabled(enabled: Boolean) {
    _uiState.value = _uiState.value.copy(defaultPersonaEnabled = enabled, dirty = true)
  }

  fun saveProfile() {
    val current = _uiState.value
    val avatarId = current.avatarSlotId.ifBlank { persistedProfile.resolvedUserAvatarId() }
    val updatedProfile =
      persistedProfile
        .copy(
          userAvatarId = avatarId,
          defaultPersonaId = if (current.defaultPersonaEnabled) avatarId else null,
        )
        .withActivePersona(
          name = current.personaName.trim(),
          title = current.personaTitle.trim(),
          description = current.personaDescription.trim(),
          position = current.personaPosition,
          depth = current.personaDepth.toIntOrNull()?.coerceAtLeast(0) ?: persistedProfile.personaDescriptionDepth,
          role = current.personaRole,
          lorebook = persistedProfile.personaDescriptionLorebook,
          avatarUri = persistedProfile.activeAvatarUri,
        )
        .ensureDefaults()
    dataStoreRepository.setStUserProfile(updatedProfile)
    persistedProfile = updatedProfile
    _uiState.value = updatedProfile.toUiState()
    Log.d(
      TAG,
      "saved ST user persona avatarId=${updatedProfile.resolvedUserAvatarId()} name=${updatedProfile.userName} position=${updatedProfile.personaDescriptionPosition.rawValue}",
    )
  }

  fun resetProfile() {
    val defaultProfile = StUserProfile().ensureDefaults()
    dataStoreRepository.setStUserProfile(defaultProfile)
    persistedProfile = defaultProfile
    _uiState.value = defaultProfile.toUiState()
    Log.d(TAG, "reset ST user persona profile to defaults")
  }
}

private fun StUserProfile.toUiState(): MyProfileUiState {
  return MyProfileUiState(
    personaName = userName,
    personaTitle = personaTitle,
    personaDescription = personaDescription,
    personaPosition = personaDescriptionPosition,
    personaDepth = personaDescriptionDepth.toString(),
    personaRole = personaDescriptionRole,
    avatarSlotId = resolvedUserAvatarId(),
    defaultPersonaEnabled = defaultPersonaId == resolvedUserAvatarId(),
    dirty = false,
  )
}
