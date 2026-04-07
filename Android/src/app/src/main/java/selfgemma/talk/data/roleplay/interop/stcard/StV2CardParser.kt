package selfgemma.talk.data.roleplay.interop.stcard

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import selfgemma.talk.domain.roleplay.model.CharacterBook
import selfgemma.talk.domain.roleplay.model.CharacterBookEntry
import selfgemma.talk.domain.roleplay.model.RoleCardCore
import selfgemma.talk.domain.roleplay.model.RoleCardSourceFormat
import selfgemma.talk.domain.roleplay.model.RoleCardSpecVersion
import selfgemma.talk.domain.roleplay.model.RoleInteropState

class StV2CardParser {
  private val gson: Gson = GsonBuilder().create()

  fun parse(rawJson: String): ParsedStCardV2 {
    val dto = gson.fromJson(rawJson, StV2CardDto::class.java)
    require(dto.spec == ST_V2_SPEC) { "Unsupported ST card spec: ${dto.spec}" }
    require(dto.spec_version == ST_V2_SPEC_VERSION) {
      "Unsupported ST card spec_version: ${dto.spec_version}"
    }

    val data = requireNotNull(dto.data) { "ST v2 card is missing data payload." }
    val core =
      RoleCardCore(
        spec = RoleCardSpecVersion.ST_V2,
        name = data.name.orEmpty().ifBlank { dto.name.orEmpty() },
        description = data.description.orEmpty().ifBlank { dto.description.orEmpty() },
        personality = data.personality.orEmpty().ifBlank { dto.personality.orEmpty() },
        scenario = data.scenario.orEmpty().ifBlank { dto.scenario.orEmpty() },
        firstMessage = data.first_mes.orEmpty().ifBlank { dto.first_mes.orEmpty() },
        messageExample = data.mes_example.orEmpty().ifBlank { dto.mes_example.orEmpty() },
        creatorNotes = data.creator_notes.orEmpty(),
        systemPrompt = data.system_prompt.orEmpty(),
        postHistoryInstructions = data.post_history_instructions.orEmpty(),
        alternateGreetings = parseAlternateGreetings(data.alternate_greetings),
        tags = data.tags.orEmpty(),
        creator = data.creator.orEmpty(),
        characterVersion = data.character_version.orEmpty(),
        characterBook = data.character_book?.toDomain(),
        extensionsJson = data.extensions.toJsonString(),
      )

    require(core.name.isNotBlank()) { "ST v2 card name is blank." }

    return ParsedStCardV2(
      core = core,
      interopState =
        RoleInteropState(
          sourceFormat = RoleCardSourceFormat.ST_JSON,
          sourceSpec = dto.spec,
          sourceSpecVersion = dto.spec_version,
          rawCardJson = rawJson,
        ),
    )
  }

  private fun parseAlternateGreetings(element: JsonElement?): List<String> {
    if (element == null || element.isJsonNull) {
      return emptyList()
    }
    if (element.isJsonArray) {
      return element.asJsonArray.mapNotNull { item ->
        item.takeIf { it.isJsonPrimitive && it.asJsonPrimitive.isString }?.asString?.trim()
      }.filter(String::isNotBlank)
    }
    if (element.isJsonPrimitive && element.asJsonPrimitive.isString) {
      return listOf(element.asString.trim()).filter(String::isNotBlank)
    }
    return emptyList()
  }

  private fun StCharacterBookDto.toDomain(): CharacterBook {
    return CharacterBook(
      name = name,
      description = description,
      scanDepth = scan_depth,
      tokenBudget = token_budget,
      recursiveScanning = recursive_scanning,
      extensionsJson = extensions.toJsonString(),
      entries = entries.orEmpty().mapNotNull { it.toDomain() },
    )
  }

  private fun StCharacterBookEntryDto.toDomain(): CharacterBookEntry? {
    val resolvedId = id ?: return null
    return CharacterBookEntry(
      id = resolvedId,
      keys = keys.orEmpty(),
      secondaryKeys = secondary_keys.orEmpty(),
      comment = comment.orEmpty(),
      content = content.orEmpty(),
      constant = constant ?: false,
      selective = selective ?: false,
      insertionOrder = insertion_order ?: 0,
      enabled = enabled ?: true,
      position = position ?: "before_char",
      extensionsJson = extensions.toJsonString(),
    )
  }

  private fun JsonElement?.toJsonString(): String {
    if (this == null || isJsonNull) {
      return "{}"
    }
    return gson.toJson(this)
  }

  companion object {
    const val ST_V2_SPEC = "chara_card_v2"
    const val ST_V2_SPEC_VERSION = "2.0"
  }
}
