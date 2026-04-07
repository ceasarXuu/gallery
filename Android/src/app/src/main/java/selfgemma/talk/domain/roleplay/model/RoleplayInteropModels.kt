package selfgemma.talk.domain.roleplay.model

enum class RoleCardSpecVersion {
  LEGACY,
  ST_V1,
  ST_V2,
  ST_V3,
}

enum class RoleCardSourceFormat {
  INTERNAL,
  ST_JSON,
  ST_PNG,
  UNKNOWN,
}

enum class RoleCardExportTarget {
  ST_V2_JSON,
  ST_PNG,
}

data class CharacterBook(
  val name: String? = null,
  val description: String? = null,
  val scanDepth: Int? = null,
  val tokenBudget: Int? = null,
  val recursiveScanning: Boolean? = null,
  val extensionsJson: String = "{}",
  val entries: List<CharacterBookEntry> = emptyList(),
)

data class CharacterBookEntry(
  val id: Int,
  val keys: List<String>,
  val secondaryKeys: List<String> = emptyList(),
  val comment: String = "",
  val content: String = "",
  val constant: Boolean = false,
  val selective: Boolean = false,
  val insertionOrder: Int = 0,
  val enabled: Boolean = true,
  val position: String = "before_char",
  val extensionsJson: String = "{}",
)

data class RoleCardCore(
  val spec: RoleCardSpecVersion = RoleCardSpecVersion.LEGACY,
  val name: String = "",
  val description: String = "",
  val personality: String = "",
  val scenario: String = "",
  val firstMessage: String = "",
  val messageExample: String = "",
  val creatorNotes: String = "",
  val systemPrompt: String = "",
  val postHistoryInstructions: String = "",
  val alternateGreetings: List<String> = emptyList(),
  val tags: List<String> = emptyList(),
  val creator: String = "",
  val characterVersion: String = "",
  val characterBook: CharacterBook? = null,
  val extensionsJson: String = "{}",
)

data class RuntimeModelParams(
  val preferredModelId: String? = null,
  val temperature: Float? = null,
  val topP: Float? = null,
  val topK: Int? = null,
  val enableThinking: Boolean = false,
)

data class MemoryPolicy(
  val enabled: Boolean = true,
  val maxItems: Int = 32,
  val summaryTurnThreshold: Int = 6,
)

data class AgentPolicy(
  val enabled: Boolean = false,
  val proactiveEnabled: Boolean = false,
)

data class RuntimeSafetyPolicy(
  val policyText: String = "",
)

data class PromptPolicy(
  val includeCharacterBook: Boolean = true,
  val includeSessionSummary: Boolean = true,
  val includePinnedMemories: Boolean = true,
)

data class CharacterUiHints(
  val preferredEditorTab: String? = null,
)

data class RoleRuntimeProfile(
  val summary: String = "",
  val modelParams: RuntimeModelParams = RuntimeModelParams(),
  val memoryPolicy: MemoryPolicy = MemoryPolicy(),
  val agentPolicy: AgentPolicy = AgentPolicy(),
  val safetyPolicy: RuntimeSafetyPolicy = RuntimeSafetyPolicy(),
  val promptPolicy: PromptPolicy = PromptPolicy(),
  val uiHints: CharacterUiHints = CharacterUiHints(),
)

data class RoleInteropState(
  val sourceFormat: RoleCardSourceFormat = RoleCardSourceFormat.INTERNAL,
  val sourceSpec: String? = null,
  val sourceSpecVersion: String? = null,
  val importedAt: Long? = null,
  val exportTargetDefault: RoleCardExportTarget = RoleCardExportTarget.ST_V2_JSON,
  val rawCardJson: String? = null,
  val rawUnknownTopLevelJson: String? = null,
  val rawUnknownDataJson: String? = null,
  val rawUnknownExtensionsJson: String? = null,
  val compatibilityWarnings: List<String> = emptyList(),
  val migrationNotes: List<String> = emptyList(),
)
