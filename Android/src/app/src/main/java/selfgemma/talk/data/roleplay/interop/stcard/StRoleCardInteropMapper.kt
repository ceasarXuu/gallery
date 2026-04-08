package selfgemma.talk.data.roleplay.interop.stcard

import com.google.gson.JsonObject
import java.util.UUID
import selfgemma.talk.data.roleplay.mapper.toPersistedRoleInteropState
import selfgemma.talk.data.roleplay.mapper.toPersistedRoleMediaProfile
import selfgemma.talk.data.roleplay.mapper.toPersistedRoleRuntimeProfile
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.RoleCardExportTarget
import selfgemma.talk.domain.roleplay.model.RoleCardSourceFormat
import selfgemma.talk.domain.roleplay.model.RoleInteropState
import selfgemma.talk.domain.roleplay.model.StCharacterCard
import selfgemma.talk.domain.roleplay.model.StCharacterCardData
import selfgemma.talk.domain.roleplay.model.resolvedDescription
import selfgemma.talk.domain.roleplay.model.resolvedFirstMessage
import selfgemma.talk.domain.roleplay.model.resolvedMessageExample
import selfgemma.talk.domain.roleplay.model.resolvedName
import selfgemma.talk.domain.roleplay.model.resolvedPersonality
import selfgemma.talk.domain.roleplay.model.resolvedScenario

internal object StRoleCardInteropMapper {
  fun importedV2ToRoleCard(
    parsed: ParsedStCardV2,
    now: Long,
    existingRole: RoleCard? = null,
    roleId: String = existingRole?.id ?: UUID.randomUUID().toString(),
  ): RoleCard {
    val card = parsed.card
    val data = card.data ?: StCharacterCardData()
    val runtimeProfile = existingRole?.toPersistedRoleRuntimeProfile()
    val interopState = mergeInteropState(parsed.interopState, existingRole)

    return RoleCard(
      id = roleId,
      name = card.resolvedName(),
      avatarUri = existingRole?.avatarUri,
      coverUri = existingRole?.coverUri,
      summary = card.resolvedDescription(),
      systemPrompt = data.system_prompt.orEmpty(),
      personaDescription = card.resolvedPersonality(),
      worldSettings = card.resolvedScenario(),
      openingLine = card.resolvedFirstMessage(),
      exampleDialogues = card.resolvedMessageExample().toExampleDialogues(),
      safetyPolicy = runtimeProfile?.safetyPolicy?.policyText.orEmpty(),
      defaultModelId = runtimeProfile?.modelParams?.preferredModelId,
      defaultTemperature = runtimeProfile?.modelParams?.temperature,
      defaultTopP = runtimeProfile?.modelParams?.topP,
      defaultTopK = runtimeProfile?.modelParams?.topK,
      enableThinking = runtimeProfile?.modelParams?.enableThinking ?: false,
      summaryTurnThreshold = runtimeProfile?.memoryPolicy?.summaryTurnThreshold ?: 6,
      memoryEnabled = runtimeProfile?.memoryPolicy?.enabled ?: true,
      memoryMaxItems = runtimeProfile?.memoryPolicy?.maxItems ?: 32,
      tags = data.tags ?: card.tags.orEmpty(),
      cardCore = card,
      runtimeProfile = runtimeProfile,
      mediaProfile = existingRole?.toPersistedRoleMediaProfile(),
      interopState = interopState,
      builtIn = existingRole?.builtIn ?: false,
      archived = existingRole?.archived ?: false,
      createdAt = existingRole?.createdAt ?: now,
      updatedAt = now,
    )
  }

  fun roleCardToExportCore(role: RoleCard): StCharacterCard {
    val persistedCore = role.cardCore ?: buildFallbackCard(role)
    val existingData = persistedCore.data ?: StCharacterCardData()
    val roleTags = role.tags.ifEmpty { existingData.tags ?: persistedCore.tags.orEmpty() }
    val roleExtensions =
      existingData.extensions?.deepCopy() ?: JsonObject().apply {
        if (persistedCore.talkativeness != null) {
          addProperty("talkativeness", persistedCore.talkativeness)
        }
        if (persistedCore.fav != null) {
          addProperty("fav", persistedCore.fav)
        }
      }

    return persistedCore.copy(
      spec = persistedCore.spec ?: StV2CardParser.ST_V2_SPEC,
      spec_version = persistedCore.spec_version ?: StV2CardParser.ST_V2_SPEC_VERSION,
      name = role.name.ifBlank { persistedCore.name.orEmpty() },
      description = role.summary.ifBlank { persistedCore.description.orEmpty() },
      personality = role.personaDescription.ifBlank { persistedCore.personality.orEmpty() },
      scenario = role.worldSettings.ifBlank { persistedCore.scenario.orEmpty() },
      first_mes = role.openingLine.ifBlank { persistedCore.first_mes.orEmpty() },
      mes_example = role.exampleDialogues.toMessageExample().ifBlank { persistedCore.mes_example.orEmpty() },
      tags = roleTags,
      data =
        existingData.copy(
          name = role.name.ifBlank { existingData.name.orEmpty().ifBlank { persistedCore.name.orEmpty() } },
          description = role.summary.ifBlank { existingData.description.orEmpty().ifBlank { persistedCore.description.orEmpty() } },
          personality = role.personaDescription.ifBlank { existingData.personality.orEmpty().ifBlank { persistedCore.personality.orEmpty() } },
          scenario = role.worldSettings.ifBlank { existingData.scenario.orEmpty().ifBlank { persistedCore.scenario.orEmpty() } },
          first_mes = role.openingLine.ifBlank { existingData.first_mes.orEmpty().ifBlank { persistedCore.first_mes.orEmpty() } },
          mes_example =
            role.exampleDialogues
              .toMessageExample()
              .ifBlank { existingData.mes_example.orEmpty().ifBlank { persistedCore.mes_example.orEmpty() } },
          system_prompt = role.systemPrompt.ifBlank { existingData.system_prompt.orEmpty() },
          tags = roleTags,
          extensions = roleExtensions,
        ),
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
          add("Imported from ST card and stored as canonical ST schema.")
        },
      compatibilityWarnings =
        buildList {
          existingState?.compatibilityWarnings?.let(::addAll)
          if (parsedState.sourceFormat != RoleCardSourceFormat.ST_JSON) {
            add("Expected ST_JSON source during ST import normalization.")
          }
        },
    )
  }

  private fun buildFallbackCard(role: RoleCard): StCharacterCard {
    val tags = role.tags
    val data =
      StCharacterCardData(
        name = role.name,
        description = role.summary,
        personality = role.personaDescription,
        scenario = role.worldSettings,
        first_mes = role.openingLine,
        mes_example = role.exampleDialogues.toMessageExample(),
        system_prompt = role.systemPrompt,
        tags = tags,
      )
    return StCharacterCard(
      spec = StV2CardParser.ST_V2_SPEC,
      spec_version = StV2CardParser.ST_V2_SPEC_VERSION,
      name = role.name,
      description = role.summary,
      personality = role.personaDescription,
      scenario = role.worldSettings,
      first_mes = role.openingLine,
      mes_example = role.exampleDialogues.toMessageExample(),
      tags = tags,
      data = data,
    )
  }

  private fun String.toExampleDialogues(): List<String> {
    return split("\n\n").map(String::trim).filter(String::isNotBlank)
  }

  private fun List<String>.toMessageExample(): String {
    return map(String::trim).filter(String::isNotBlank).joinToString("\n\n")
  }
}
