package selfgemma.talk.data.roleplay.mapper

import selfgemma.talk.data.roleplay.db.entity.RoleEntity
import selfgemma.talk.domain.roleplay.model.MemoryPolicy
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.RoleCardCore
import selfgemma.talk.domain.roleplay.model.RoleCardExportTarget
import selfgemma.talk.domain.roleplay.model.RoleCardSourceFormat
import selfgemma.talk.domain.roleplay.model.RoleCardSpecVersion
import selfgemma.talk.domain.roleplay.model.RoleInteropState
import selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile
import selfgemma.talk.domain.roleplay.model.RuntimeModelParams
import selfgemma.talk.domain.roleplay.model.RuntimeSafetyPolicy

internal fun RoleEntity.toRoleCardCoreOrLegacy(): RoleCardCore {
  return cardCoreJson
    ?.takeIf { it.isNotBlank() }
    ?.let(RoleplayInteropJsonCodec::decodeRoleCardCore)
    ?: RoleCardCore(
      spec = RoleCardSpecVersion.LEGACY,
      name = name,
      description = summary,
      personality = personaDescription,
      scenario = worldSettings,
      firstMessage = openingLine,
      messageExample = exampleDialogues.joinToString("\n\n"),
      systemPrompt = systemPrompt,
      tags = tags,
    )
}

internal fun RoleEntity.toRoleRuntimeProfileOrLegacy(): RoleRuntimeProfile {
  return runtimeProfileJson
    ?.takeIf { it.isNotBlank() }
    ?.let(RoleplayInteropJsonCodec::decodeRoleRuntimeProfile)
    ?: RoleRuntimeProfile(
      summary = summary,
      modelParams =
        RuntimeModelParams(
          preferredModelId = defaultModelId,
          temperature = defaultTemperature,
          topP = defaultTopP,
          topK = defaultTopK,
          enableThinking = enableThinking,
        ),
      memoryPolicy =
        MemoryPolicy(
          enabled = memoryEnabled,
          maxItems = memoryMaxItems,
          summaryTurnThreshold = summaryTurnThreshold,
        ),
      safetyPolicy = RuntimeSafetyPolicy(policyText = safetyPolicy),
    )
}

internal fun RoleEntity.toRoleInteropStateOrDefault(): RoleInteropState {
  return interopStateJson
    ?.takeIf { it.isNotBlank() }
    ?.let(RoleplayInteropJsonCodec::decodeRoleInteropState)
    ?: RoleInteropState(
      sourceFormat = RoleCardSourceFormat.INTERNAL,
      sourceSpec = null,
      sourceSpecVersion = null,
      exportTargetDefault = RoleCardExportTarget.ST_V2_JSON,
    )
}

internal fun RoleCard.toPersistedRoleCardCore(): RoleCardCore {
  return cardCore
    ?: RoleCardCore(
      spec = RoleCardSpecVersion.LEGACY,
      name = name,
      description = summary,
      personality = personaDescription,
      scenario = worldSettings,
      firstMessage = openingLine,
      messageExample = exampleDialogues.joinToString("\n\n"),
      systemPrompt = systemPrompt,
      tags = tags,
    )
}

internal fun RoleCard.toPersistedRoleRuntimeProfile(): RoleRuntimeProfile {
  return runtimeProfile
    ?: RoleRuntimeProfile(
      summary = summary,
      modelParams =
        RuntimeModelParams(
          preferredModelId = defaultModelId,
          temperature = defaultTemperature,
          topP = defaultTopP,
          topK = defaultTopK,
          enableThinking = enableThinking,
        ),
      memoryPolicy =
        MemoryPolicy(
          enabled = memoryEnabled,
          maxItems = memoryMaxItems,
          summaryTurnThreshold = summaryTurnThreshold,
        ),
      safetyPolicy = RuntimeSafetyPolicy(policyText = safetyPolicy),
    )
}

internal fun RoleCard.toPersistedRoleInteropState(): RoleInteropState {
  return interopState
    ?: RoleInteropState(
      sourceFormat = RoleCardSourceFormat.INTERNAL,
      exportTargetDefault = RoleCardExportTarget.ST_V2_JSON,
      migrationNotes = listOf("Role created before ST interop fields were introduced."),
    )
}
