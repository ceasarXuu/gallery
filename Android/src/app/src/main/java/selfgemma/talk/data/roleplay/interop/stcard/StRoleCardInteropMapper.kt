package selfgemma.talk.data.roleplay.interop.stcard

import java.util.UUID
import selfgemma.talk.data.roleplay.mapper.toPersistedRoleInteropState
import selfgemma.talk.data.roleplay.mapper.toPersistedRoleRuntimeProfile
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.RoleCardCore
import selfgemma.talk.domain.roleplay.model.RoleCardExportTarget
import selfgemma.talk.domain.roleplay.model.RoleCardSourceFormat
import selfgemma.talk.domain.roleplay.model.RoleInteropState

internal object StRoleCardInteropMapper {
  fun importedV2ToRoleCard(
    parsed: ParsedStCardV2,
    now: Long,
    existingRole: RoleCard? = null,
    roleId: String = existingRole?.id ?: UUID.randomUUID().toString(),
  ): RoleCard {
    val core = parsed.core
    val runtimeProfile = existingRole?.toPersistedRoleRuntimeProfile()
    val interopState = mergeInteropState(parsed.interopState, existingRole)

    return RoleCard(
      id = roleId,
      name = core.name,
      avatarUri = existingRole?.avatarUri,
      coverUri = existingRole?.coverUri,
      summary = core.description,
      systemPrompt = core.systemPrompt,
      personaDescription = core.personality,
      worldSettings = core.scenario,
      openingLine = core.firstMessage,
      exampleDialogues = core.messageExample.toExampleDialogues(),
      safetyPolicy = runtimeProfile?.safetyPolicy?.policyText.orEmpty(),
      defaultModelId = runtimeProfile?.modelParams?.preferredModelId,
      defaultTemperature = runtimeProfile?.modelParams?.temperature,
      defaultTopP = runtimeProfile?.modelParams?.topP,
      defaultTopK = runtimeProfile?.modelParams?.topK,
      enableThinking = runtimeProfile?.modelParams?.enableThinking ?: false,
      summaryTurnThreshold = runtimeProfile?.memoryPolicy?.summaryTurnThreshold ?: 6,
      memoryEnabled = runtimeProfile?.memoryPolicy?.enabled ?: true,
      memoryMaxItems = runtimeProfile?.memoryPolicy?.maxItems ?: 32,
      tags = core.tags,
      cardCore = core,
      runtimeProfile = runtimeProfile,
      interopState = interopState,
      builtIn = existingRole?.builtIn ?: false,
      archived = existingRole?.archived ?: false,
      createdAt = existingRole?.createdAt ?: now,
      updatedAt = now,
    )
  }

  fun roleCardToExportCore(role: RoleCard): RoleCardCore {
    val persistedCore = role.cardCore ?: buildFallbackCore(role)
    return persistedCore.copy(
      name = role.name.ifBlank { persistedCore.name },
      description = role.summary.ifBlank { persistedCore.description },
      personality = role.personaDescription.ifBlank { persistedCore.personality },
      scenario = role.worldSettings.ifBlank { persistedCore.scenario },
      firstMessage = role.openingLine.ifBlank { persistedCore.firstMessage },
      messageExample = role.exampleDialogues.toMessageExample().ifBlank { persistedCore.messageExample },
      systemPrompt = role.systemPrompt.ifBlank { persistedCore.systemPrompt },
      tags = role.tags.ifEmpty { persistedCore.tags },
    )
  }

  private fun mergeInteropState(
    parsedState: RoleInteropState,
    existingRole: RoleCard?,
  ): RoleInteropState {
    val existingState = existingRole?.toPersistedRoleInteropState()
    return parsedState.copy(
      importedAt = parsedState.importedAt,
      exportTargetDefault = existingState?.exportTargetDefault ?: RoleCardExportTarget.ST_V2_JSON,
      migrationNotes =
        buildList {
          existingState?.migrationNotes?.let(::addAll)
          add("Imported from ST v2 JSON and normalized into RoleCard.")
        },
      compatibilityWarnings =
        buildList {
          existingState?.compatibilityWarnings?.let(::addAll)
          if (parsedState.sourceFormat != RoleCardSourceFormat.ST_JSON) {
            add("Expected ST_JSON source during ST v2 import normalization.")
          }
        },
    )
  }

  private fun buildFallbackCore(role: RoleCard): RoleCardCore {
    return RoleCardCore(
      name = role.name,
      description = role.summary,
      personality = role.personaDescription,
      scenario = role.worldSettings,
      firstMessage = role.openingLine,
      messageExample = role.exampleDialogues.toMessageExample(),
      systemPrompt = role.systemPrompt,
      tags = role.tags,
    )
  }

  private fun String.toExampleDialogues(): List<String> {
    return split("\n\n").map(String::trim).filter(String::isNotBlank)
  }

  private fun List<String>.toMessageExample(): String {
    return map(String::trim).filter(String::isNotBlank).joinToString("\n\n")
  }
}
