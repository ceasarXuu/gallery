package selfgemma.talk.feature.roleplay.profile

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import selfgemma.talk.domain.roleplay.model.DEFAULT_ST_USER_NAME
import selfgemma.talk.domain.roleplay.model.StPersonaDescriptor
import selfgemma.talk.domain.roleplay.model.StUserProfile
import selfgemma.talk.testing.FakeDataStoreRepository

class MyProfileViewModelTest {
  @Test
  fun switchingSlots_preservesUnsavedPersonaEdits() {
    val viewModel =
      MyProfileViewModel(
        FakeDataStoreRepository(
          stUserProfile =
            StUserProfile(
              userAvatarId = "slot-a",
              defaultPersonaId = "slot-a",
              personas = mapOf("slot-a" to "Alice"),
              personaDescriptions =
                mapOf(
                  "slot-a" to StPersonaDescriptor(description = "old description"),
                ),
            ).ensureDefaults(),
        ),
      )

    viewModel.updatePersonaName("Alice Updated")
    viewModel.updatePersonaDescription("new description")
    viewModel.createAvatarSlot("slot-b")

    val slotBState = viewModel.uiState.value
    assertEquals("slot-b", slotBState.avatarSlotId)
    assertEquals(DEFAULT_ST_USER_NAME, slotBState.personaName)
    assertTrue(slotBState.availableSlotIds.contains("slot-a"))
    assertTrue(slotBState.availableSlotIds.contains("slot-b"))

    viewModel.selectAvatarSlot("slot-a")

    val slotAState = viewModel.uiState.value
    assertEquals("slot-a", slotAState.avatarSlotId)
    assertEquals("Alice Updated", slotAState.personaName)
    assertEquals("new description", slotAState.personaDescription)
    assertTrue(slotAState.dirty)
  }

  @Test
  fun saveProfile_persistsNewSlotAndDefaultPersona() {
    val dataStoreRepository =
      FakeDataStoreRepository(
        stUserProfile =
          StUserProfile(
            userAvatarId = "slot-a",
            defaultPersonaId = "slot-a",
            personas = mapOf("slot-a" to "Alice"),
            personaDescriptions =
              mapOf(
                "slot-a" to StPersonaDescriptor(description = "old description"),
              ),
          ).ensureDefaults(),
      )
    val viewModel = MyProfileViewModel(dataStoreRepository)

    viewModel.createAvatarSlot("slot-b")
    viewModel.updatePersonaName("Bob")
    viewModel.updatePersonaDescription("traveler")
    viewModel.updateDefaultPersonaEnabled(true)
    viewModel.saveProfile()

    val savedProfile = dataStoreRepository.getStUserProfile()
    assertEquals("slot-b", savedProfile.userAvatarId)
    assertEquals("slot-b", savedProfile.defaultPersonaId)
    assertEquals("Bob", savedProfile.personas["slot-b"])
    assertEquals("traveler", savedProfile.personaDescriptions["slot-b"]?.description)
    assertEquals("Alice", savedProfile.personas["slot-a"])
  }
}
