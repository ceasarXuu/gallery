package selfgemma.talk.data.roleplay.interop.stcard

import com.google.gson.JsonElement

internal data class StV2CardDto(
  val spec: String? = null,
  val spec_version: String? = null,
  val name: String? = null,
  val description: String? = null,
  val personality: String? = null,
  val scenario: String? = null,
  val first_mes: String? = null,
  val mes_example: String? = null,
  val data: StV2CardDataDto? = null,
)

internal data class StV2CardDataDto(
  val name: String? = null,
  val description: String? = null,
  val personality: String? = null,
  val scenario: String? = null,
  val first_mes: String? = null,
  val mes_example: String? = null,
  val creator_notes: String? = null,
  val system_prompt: String? = null,
  val post_history_instructions: String? = null,
  val alternate_greetings: JsonElement? = null,
  val tags: List<String>? = null,
  val creator: String? = null,
  val character_version: String? = null,
  val character_book: StCharacterBookDto? = null,
  val extensions: JsonElement? = null,
)

internal data class StCharacterBookDto(
  val name: String? = null,
  val description: String? = null,
  val scan_depth: Int? = null,
  val token_budget: Int? = null,
  val recursive_scanning: Boolean? = null,
  val extensions: JsonElement? = null,
  val entries: List<StCharacterBookEntryDto>? = null,
)

internal data class StCharacterBookEntryDto(
  val id: Int? = null,
  val keys: List<String>? = null,
  val secondary_keys: List<String>? = null,
  val comment: String? = null,
  val content: String? = null,
  val constant: Boolean? = null,
  val selective: Boolean? = null,
  val insertion_order: Int? = null,
  val enabled: Boolean? = null,
  val position: String? = null,
  val extensions: JsonElement? = null,
)

data class ParsedStCardV2(
  val core: selfgemma.talk.domain.roleplay.model.RoleCardCore,
  val interopState: selfgemma.talk.domain.roleplay.model.RoleInteropState,
)
