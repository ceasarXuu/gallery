package selfgemma.talk.data.roleplay.mapper

import selfgemma.talk.data.roleplay.db.entity.MemoryEntity
import selfgemma.talk.data.roleplay.db.entity.MessageEntity
import selfgemma.talk.data.roleplay.db.entity.RoleEntity
import selfgemma.talk.data.roleplay.db.entity.SessionEntity
import selfgemma.talk.data.roleplay.db.entity.SessionEventEntity
import selfgemma.talk.data.roleplay.db.entity.SessionSummaryEntity
import selfgemma.talk.domain.roleplay.model.MemoryItem
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.Session
import selfgemma.talk.domain.roleplay.model.SessionEvent
import selfgemma.talk.domain.roleplay.model.SessionSummary

fun RoleEntity.toDomain(): RoleCard {
  val cardCore = toRoleCardCoreOrLegacy()
  val runtimeProfile = toRoleRuntimeProfileOrLegacy()
  val interopState = toRoleInteropStateOrDefault()
  return RoleCard(
    id = id,
    name = name,
    avatarUri = avatarUri,
    coverUri = coverUri,
    summary = summary,
    systemPrompt = systemPrompt,
    personaDescription = personaDescription,
    worldSettings = worldSettings,
    openingLine = openingLine,
    exampleDialogues = exampleDialogues,
    safetyPolicy = safetyPolicy,
    defaultModelId = defaultModelId,
    defaultTemperature = defaultTemperature,
    defaultTopP = defaultTopP,
    defaultTopK = defaultTopK,
    enableThinking = enableThinking,
    summaryTurnThreshold = summaryTurnThreshold,
    memoryEnabled = memoryEnabled,
    memoryMaxItems = memoryMaxItems,
    tags = tags,
    cardCore = cardCore,
    runtimeProfile = runtimeProfile,
    interopState = interopState,
    builtIn = builtIn,
    archived = archived,
    createdAt = createdAt,
    updatedAt = updatedAt,
  )
}

fun RoleCard.toEntity(): RoleEntity {
  val cardCore = toPersistedRoleCardCore()
  val runtimeProfile = toPersistedRoleRuntimeProfile()
  val interopState = toPersistedRoleInteropState()
  return RoleEntity(
    id = id,
    name = name,
    avatarUri = avatarUri,
    coverUri = coverUri,
    summary = summary,
    systemPrompt = systemPrompt,
    personaDescription = personaDescription,
    worldSettings = worldSettings,
    openingLine = openingLine,
    exampleDialogues = exampleDialogues,
    safetyPolicy = safetyPolicy,
    defaultModelId = defaultModelId,
    defaultTemperature = defaultTemperature,
    defaultTopP = defaultTopP,
    defaultTopK = defaultTopK,
    enableThinking = enableThinking,
    summaryTurnThreshold = summaryTurnThreshold,
    memoryEnabled = memoryEnabled,
    memoryMaxItems = memoryMaxItems,
    tags = tags,
    cardCoreJson = RoleplayInteropJsonCodec.encodeRoleCardCore(cardCore),
    runtimeProfileJson = RoleplayInteropJsonCodec.encodeRoleRuntimeProfile(runtimeProfile),
    interopStateJson = RoleplayInteropJsonCodec.encodeRoleInteropState(interopState),
    builtIn = builtIn,
    archived = archived,
    createdAt = createdAt,
    updatedAt = updatedAt,
  )
}

fun SessionEntity.toDomain(): Session {
  return Session(
    id = id,
    roleId = roleId,
    title = title,
    activeModelId = activeModelId,
    pinned = pinned,
    archived = archived,
    createdAt = createdAt,
    updatedAt = updatedAt,
    lastMessageAt = lastMessageAt,
    lastSummary = lastSummary,
    lastUserMessageExcerpt = lastUserMessageExcerpt,
    lastAssistantMessageExcerpt = lastAssistantMessageExcerpt,
    turnCount = turnCount,
    summaryVersion = summaryVersion,
    draftInput = draftInput,
  )
}

fun Session.toEntity(): SessionEntity {
  return SessionEntity(
    id = id,
    roleId = roleId,
    title = title,
    activeModelId = activeModelId,
    pinned = pinned,
    archived = archived,
    createdAt = createdAt,
    updatedAt = updatedAt,
    lastMessageAt = lastMessageAt,
    lastSummary = lastSummary,
    lastUserMessageExcerpt = lastUserMessageExcerpt,
    lastAssistantMessageExcerpt = lastAssistantMessageExcerpt,
    turnCount = turnCount,
    summaryVersion = summaryVersion,
    draftInput = draftInput,
  )
}

fun MessageEntity.toDomain(): Message {
  return Message(
    id = id,
    sessionId = sessionId,
    seq = seq,
    side = side,
    kind = kind,
    status = status,
    content = content,
    isMarkdown = isMarkdown,
    errorMessage = errorMessage,
    latencyMs = latencyMs,
    accelerator = accelerator,
    parentMessageId = parentMessageId,
    regenerateGroupId = regenerateGroupId,
    metadataJson = metadataJson,
    createdAt = createdAt,
    updatedAt = updatedAt,
  )
}

fun Message.toEntity(): MessageEntity {
  return MessageEntity(
    id = id,
    sessionId = sessionId,
    seq = seq,
    side = side,
    kind = kind,
    status = status,
    content = content,
    isMarkdown = isMarkdown,
    errorMessage = errorMessage,
    latencyMs = latencyMs,
    accelerator = accelerator,
    parentMessageId = parentMessageId,
    regenerateGroupId = regenerateGroupId,
    metadataJson = metadataJson,
    createdAt = createdAt,
    updatedAt = updatedAt,
  )
}

fun SessionSummaryEntity.toDomain(): SessionSummary {
  return SessionSummary(
    sessionId = sessionId,
    version = version,
    coveredUntilSeq = coveredUntilSeq,
    summaryText = summaryText,
    tokenEstimate = tokenEstimate,
    updatedAt = updatedAt,
  )
}

fun SessionSummary.toEntity(): SessionSummaryEntity {
  return SessionSummaryEntity(
    sessionId = sessionId,
    version = version,
    coveredUntilSeq = coveredUntilSeq,
    summaryText = summaryText,
    tokenEstimate = tokenEstimate,
    updatedAt = updatedAt,
  )
}

fun MemoryEntity.toDomain(): MemoryItem {
  return MemoryItem(
    id = id,
    roleId = roleId,
    sessionId = sessionId,
    category = category,
    content = content,
    normalizedHash = normalizedHash,
    confidence = confidence,
    pinned = pinned,
    active = active,
    sourceMessageIds = sourceMessageIds,
    createdAt = createdAt,
    updatedAt = updatedAt,
    lastUsedAt = lastUsedAt,
  )
}

fun MemoryItem.toEntity(): MemoryEntity {
  return MemoryEntity(
    id = id,
    roleId = roleId,
    sessionId = sessionId,
    category = category,
    content = content,
    normalizedHash = normalizedHash,
    confidence = confidence,
    pinned = pinned,
    active = active,
    sourceMessageIds = sourceMessageIds,
    createdAt = createdAt,
    updatedAt = updatedAt,
    lastUsedAt = lastUsedAt,
  )
}

fun SessionEventEntity.toDomain(): SessionEvent {
  return SessionEvent(
    id = id,
    sessionId = sessionId,
    eventType = eventType,
    payloadJson = payloadJson,
    createdAt = createdAt,
  )
}

fun SessionEvent.toEntity(): SessionEventEntity {
  return SessionEventEntity(
    id = id,
    sessionId = sessionId,
    eventType = eventType,
    payloadJson = payloadJson,
    createdAt = createdAt,
  )
}
