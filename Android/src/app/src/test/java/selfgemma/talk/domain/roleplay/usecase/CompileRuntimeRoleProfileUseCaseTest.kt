package selfgemma.talk.domain.roleplay.usecase

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile
import selfgemma.talk.domain.roleplay.model.RuntimeModelParams

class CompileRuntimeRoleProfileUseCaseTest {
  private val useCase = CompileRuntimeRoleProfileUseCase(TokenEstimator())

  @Test
  fun invoke_compilesRuntimePromptFieldsWithoutDroppingExistingPolicies() {
    val role =
      RoleCard(
        id = "role-1",
        name = "Iris",
        summary = "A dry-witted investigator with a precise memory.",
        systemPrompt = "Stay in character and never break the case tone.",
        personaDescription = "Calm, sharp, and skeptical.",
        worldSettings = "A rain-soaked neon city full of internal sabotage.",
        openingLine = "The case file is already open.",
        exampleDialogues = listOf("User: Start.\nIris: Then give me facts, not fog."),
        runtimeProfile = RoleRuntimeProfile(modelParams = RuntimeModelParams(enableThinking = true)),
        createdAt = 10L,
        updatedAt = 10L,
      )

    val compiled = useCase(role, now = 50L)
    val runtimeProfile = checkNotNull(compiled.runtimeProfile)

    assertTrue(runtimeProfile.compiledCorePrompt.contains("You are roleplaying as Iris."))
    assertTrue(runtimeProfile.compiledCorePrompt.contains("Stay in character"))
    assertEquals(true, runtimeProfile.modelParams.enableThinking)
    assertTrue(runtimeProfile.compiledPersonaPrompt.contains("Calm, sharp, and skeptical."))
    assertTrue(runtimeProfile.compiledWorldPrompt.contains("rain-soaked neon city"))
    assertTrue(runtimeProfile.compiledStylePrompt.contains("Opening tone"))
    assertTrue(runtimeProfile.compiledExampleDigest.contains("Example cues"))
    assertTrue(runtimeProfile.sourceFingerprint.isNotBlank())
    assertEquals(50L, runtimeProfile.compiledAt)
    assertFalse(runtimeProfile.oversizeWarning)
  }

  @Test
  fun invoke_marksOversizeRuntimeProfilesWhenCompiledPayloadStaysLarge() {
    val longText = (1..600).joinToString(" ") { "detail$it" }
    val role =
      RoleCard(
        id = "role-2",
        name = "Archivist",
        summary = longText,
        systemPrompt = longText,
        personaDescription = longText,
        worldSettings = longText,
        openingLine = longText,
        exampleDialogues = listOf(longText, longText),
        createdAt = 20L,
        updatedAt = 20L,
      )

    val compiled = useCase(role, now = 60L)
    val runtimeProfile = checkNotNull(compiled.runtimeProfile)

    assertTrue(runtimeProfile.compiledTotalTokenEstimate > 0)
    assertTrue(runtimeProfile.oversizeWarning)
    assertTrue(runtimeProfile.compiledCorePrompt.length <= 1200)
    assertTrue(runtimeProfile.compiledExampleDigest.length <= 480)
  }
}
