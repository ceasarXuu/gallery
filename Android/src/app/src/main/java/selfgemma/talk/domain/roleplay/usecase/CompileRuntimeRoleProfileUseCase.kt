package selfgemma.talk.domain.roleplay.usecase

import java.security.MessageDigest
import javax.inject.Inject
import selfgemma.talk.domain.roleplay.model.MemoryPolicy
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile
import selfgemma.talk.domain.roleplay.model.RuntimeModelParams
import selfgemma.talk.domain.roleplay.model.RuntimeSafetyPolicy
import selfgemma.talk.domain.roleplay.model.cardDataOrEmpty
import selfgemma.talk.domain.roleplay.model.resolvedExampleDialogues
import selfgemma.talk.domain.roleplay.model.resolvedName
import selfgemma.talk.domain.roleplay.model.resolvedPersonaDescription
import selfgemma.talk.domain.roleplay.model.resolvedSummary
import selfgemma.talk.domain.roleplay.model.resolvedSystemPrompt
import selfgemma.talk.domain.roleplay.model.resolvedTags
import selfgemma.talk.domain.roleplay.model.resolvedWorldSettings

private const val CORE_PROMPT_CHAR_LIMIT = 1200
private const val PERSONA_PROMPT_CHAR_LIMIT = 720
private const val WORLD_PROMPT_CHAR_LIMIT = 720
private const val STYLE_PROMPT_CHAR_LIMIT = 360
private const val EXAMPLE_DIGEST_CHAR_LIMIT = 480
private const val COMPILED_RUNTIME_ROLE_WARNING_TOKENS = 768

class CompileRuntimeRoleProfileUseCase @Inject constructor(private val tokenEstimator: TokenEstimator) {
  operator fun invoke(role: RoleCard, now: Long = System.currentTimeMillis()): RoleCard {
    val existingProfile = role.runtimeProfile ?: buildDefaultRuntimeProfile(role)
    val compiledCorePrompt = buildCorePrompt(role).fitToLimit(CORE_PROMPT_CHAR_LIMIT)
    val compiledPersonaPrompt = role.resolvedPersonaDescription().fitToLimit(PERSONA_PROMPT_CHAR_LIMIT)
    val compiledWorldPrompt = role.resolvedWorldSettings().fitToLimit(WORLD_PROMPT_CHAR_LIMIT)
    val compiledStylePrompt = buildStylePrompt(role).fitToLimit(STYLE_PROMPT_CHAR_LIMIT)
    val compiledExampleDigest = buildExampleDigest(role).fitToLimit(EXAMPLE_DIGEST_CHAR_LIMIT)
    val corePromptTokenEstimate = tokenEstimator.estimate(compiledCorePrompt)
    val personaPromptTokenEstimate = tokenEstimator.estimate(compiledPersonaPrompt)
    val worldPromptTokenEstimate = tokenEstimator.estimate(compiledWorldPrompt)
    val stylePromptTokenEstimate = tokenEstimator.estimate(compiledStylePrompt)
    val exampleDigestTokenEstimate = tokenEstimator.estimate(compiledExampleDigest)
    val compiledTotalTokenEstimate =
      corePromptTokenEstimate +
        personaPromptTokenEstimate +
        worldPromptTokenEstimate +
        stylePromptTokenEstimate +
        exampleDigestTokenEstimate

    return role.copy(
      runtimeProfile =
        existingProfile.copy(
          summary = existingProfile.summary.ifBlank { role.resolvedSummary() },
          compiledCorePrompt = compiledCorePrompt,
          compiledPersonaPrompt = compiledPersonaPrompt,
          compiledWorldPrompt = compiledWorldPrompt,
          compiledStylePrompt = compiledStylePrompt,
          compiledExampleDigest = compiledExampleDigest,
          corePromptTokenEstimate = corePromptTokenEstimate,
          personaPromptTokenEstimate = personaPromptTokenEstimate,
          worldPromptTokenEstimate = worldPromptTokenEstimate,
          stylePromptTokenEstimate = stylePromptTokenEstimate,
          exampleDigestTokenEstimate = exampleDigestTokenEstimate,
          compiledTotalTokenEstimate = compiledTotalTokenEstimate,
          oversizeWarning = compiledTotalTokenEstimate > COMPILED_RUNTIME_ROLE_WARNING_TOKENS,
          sourceFingerprint = computeSourceFingerprint(role),
          compiledAt = now,
        )
    )
  }

  private fun buildDefaultRuntimeProfile(role: RoleCard): RoleRuntimeProfile {
    return RoleRuntimeProfile(
      summary = role.summary,
      modelParams =
        RuntimeModelParams(
          preferredModelId = role.defaultModelId,
          temperature = role.defaultTemperature,
          topP = role.defaultTopP,
          topK = role.defaultTopK,
          enableThinking = role.enableThinking,
        ),
      memoryPolicy =
        MemoryPolicy(
          enabled = role.memoryEnabled,
          maxItems = role.memoryMaxItems,
          summaryTurnThreshold = role.summaryTurnThreshold,
        ),
      safetyPolicy = RuntimeSafetyPolicy(policyText = role.safetyPolicy),
    )
  }

  private fun buildCorePrompt(role: RoleCard): String {
    val systemPrompt = role.resolvedSystemPrompt().trim()
    val summary = role.resolvedSummary().trim()
    return buildString {
      append("You are roleplaying as ")
      append(role.resolvedName().ifBlank { "the character" })
      append(".")
      if (systemPrompt.isNotBlank()) {
        append("\n")
        append(systemPrompt)
      }
      if (summary.isNotBlank()) {
        append("\n")
        append("Core character: ")
        append(summary)
      }
    }
  }

  private fun buildStylePrompt(role: RoleCard): String {
    val openingLine = role.openingLine.fitToLimit(140)
    val creatorNotes = role.stCard.cardDataOrEmpty().creator_notes.fitToLimit(180)
    val tags = role.resolvedTags().take(6).joinToString(", ").fitToLimit(120)
    return buildString {
      if (openingLine.isNotBlank()) {
        append("Opening tone: ")
        append(openingLine)
      }
      if (creatorNotes.isNotBlank()) {
        if (isNotBlank()) {
          append("\n")
        }
        append("Creator notes: ")
        append(creatorNotes)
      }
      if (tags.isNotBlank()) {
        if (isNotBlank()) {
          append("\n")
        }
        append("Tags: ")
        append(tags)
      }
    }
  }

  private fun buildExampleDigest(role: RoleCard): String {
    val examples =
      role
        .resolvedExampleDialogues()
        .map { it.normalizeWhitespace() }
        .filter(String::isNotBlank)
        .take(2)
    if (examples.isEmpty()) {
      return ""
    }
    return buildString {
      append("Example cues:\n")
      examples.forEachIndexed { index, example ->
        append("- ")
        append(example.fitToLimit(200))
        if (index != examples.lastIndex) {
          append("\n")
        }
      }
    }
  }

  private fun computeSourceFingerprint(role: RoleCard): String {
    val source =
      listOf(
        role.resolvedName(),
        role.resolvedSummary(),
        role.resolvedSystemPrompt(),
        role.resolvedPersonaDescription(),
        role.resolvedWorldSettings(),
        role.openingLine,
        role.resolvedExampleDialogues().joinToString(separator = "\n\n"),
      ).joinToString(separator = "\u001f") { it.normalizeWhitespace() }
    val digest = MessageDigest.getInstance("SHA-256")
    return digest.digest(source.toByteArray()).joinToString(separator = "") { byte -> "%02x".format(byte) }
  }

  private fun String?.fitToLimit(maxLength: Int): String {
    return normalizeWhitespace().take(maxLength)
  }

  private fun String?.normalizeWhitespace(): String {
    return this.orEmpty().trim().replace(WHITESPACE_REGEX, " ")
  }

  companion object {
    private val WHITESPACE_REGEX = Regex("\\s+")
  }
}
