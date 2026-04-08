package selfgemma.talk.feature.roleplay.roles

import org.junit.Test
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.RoleCardSourceFormat
import selfgemma.talk.domain.roleplay.model.RoleInteropState
import selfgemma.talk.domain.roleplay.model.StCharacterCard
import selfgemma.talk.domain.roleplay.model.StCharacterCardData

class RoleEditorViewModelTest {
  @Test
  fun toEditorUiState_preservesBuiltInFlagAcrossImportedRoleProjection() {
    val role =
      RoleCard(
        id = "builtin-role",
        stCard =
          StCharacterCard(
            spec = "chara_card_v2",
            spec_version = "2.0",
            name = "Builtin",
            data = StCharacterCardData(name = "Builtin", system_prompt = "prompt"),
          ),
        builtIn = true,
        interopState = RoleInteropState(sourceFormat = RoleCardSourceFormat.ST_PNG),
        createdAt = 1L,
        updatedAt = 1L,
      )

    val uiState = role.toEditorUiState(isNewRole = false, statusMessage = "imported")

    assertTrue(uiState.builtIn)
    assertFalse(uiState.isNewRole)
    assertTrue(uiState.importedFromStPng)
  }
}
