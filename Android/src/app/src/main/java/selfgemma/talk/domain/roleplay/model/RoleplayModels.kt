package selfgemma.talk.domain.roleplay.model

enum class MessageSide {
  USER,
  ASSISTANT,
  SYSTEM,
}

enum class MessageKind {
  TEXT,
  EVENT,
  IMAGE,
  AUDIO,
  WEBVIEW,
}

enum class MessageStatus {
  PENDING,
  STREAMING,
  COMPLETED,
  FAILED,
  INTERRUPTED,
}

enum class MemoryCategory {
  PREFERENCE,
  RELATION,
  WORLD,
  PLOT,
  TODO,
  RULE,
}

enum class SessionEventType {
  MODEL_SWITCH,
  SUMMARY_UPDATE,
  MEMORY_UPSERT,
  RESET,
  EXPORT,
}

data class RoleCard(
  val id: String,
  val name: String,
  val avatarUri: String? = null,
  val coverUri: String? = null,
  val summary: String = "",
  val systemPrompt: String,
  val personaDescription: String = "",
  val worldSettings: String = "",
  val openingLine: String = "",
  val exampleDialogues: List<String> = emptyList(),
  val safetyPolicy: String = "",
  val defaultModelId: String? = null,
  val defaultTemperature: Float? = null,
  val defaultTopP: Float? = null,
  val defaultTopK: Int? = null,
  val enableThinking: Boolean = false,
  val summaryTurnThreshold: Int = 6,
  val memoryEnabled: Boolean = true,
  val memoryMaxItems: Int = 32,
  val tags: List<String> = emptyList(),
  val builtIn: Boolean = false,
  val archived: Boolean = false,
  val createdAt: Long,
  val updatedAt: Long,
)

data class Session(
  val id: String,
  val roleId: String,
  val title: String,
  val activeModelId: String,
  val pinned: Boolean = false,
  val archived: Boolean = false,
  val createdAt: Long,
  val updatedAt: Long,
  val lastMessageAt: Long,
  val lastSummary: String? = null,
  val lastUserMessageExcerpt: String? = null,
  val lastAssistantMessageExcerpt: String? = null,
  val turnCount: Int = 0,
  val summaryVersion: Int = 0,
  val draftInput: String = "",
)

data class Message(
  val id: String,
  val sessionId: String,
  val seq: Int,
  val side: MessageSide,
  val kind: MessageKind = MessageKind.TEXT,
  val status: MessageStatus = MessageStatus.PENDING,
  val content: String = "",
  val isMarkdown: Boolean = false,
  val errorMessage: String? = null,
  val latencyMs: Double? = null,
  val accelerator: String? = null,
  val parentMessageId: String? = null,
  val regenerateGroupId: String? = null,
  val metadataJson: String? = null,
  val createdAt: Long,
  val updatedAt: Long,
)

data class SessionSummary(
  val sessionId: String,
  val version: Int,
  val coveredUntilSeq: Int,
  val summaryText: String,
  val tokenEstimate: Int,
  val updatedAt: Long,
)

data class MemoryItem(
  val id: String,
  val roleId: String,
  val sessionId: String? = null,
  val category: MemoryCategory,
  val content: String,
  val normalizedHash: String,
  val confidence: Float = 0f,
  val pinned: Boolean = false,
  val active: Boolean = true,
  val sourceMessageIds: List<String> = emptyList(),
  val createdAt: Long,
  val updatedAt: Long,
  val lastUsedAt: Long? = null,
)

data class SessionEvent(
  val id: String,
  val sessionId: String,
  val eventType: SessionEventType,
  val payloadJson: String = "{}",
  val createdAt: Long,
)