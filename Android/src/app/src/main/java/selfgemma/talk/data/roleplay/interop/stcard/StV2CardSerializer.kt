package selfgemma.talk.data.roleplay.interop.stcard

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import selfgemma.talk.domain.roleplay.model.CharacterBook
import selfgemma.talk.domain.roleplay.model.CharacterBookEntry
import selfgemma.talk.domain.roleplay.model.RoleCardCore

class StV2CardSerializer {
  private val gson: Gson = GsonBuilder().setPrettyPrinting().create()

  fun serialize(core: RoleCardCore): String {
    val dto =
      StV2CardDto(
        spec = StV2CardParser.ST_V2_SPEC,
        spec_version = StV2CardParser.ST_V2_SPEC_VERSION,
        name = core.name,
        description = core.description,
        personality = core.personality,
        scenario = core.scenario,
        first_mes = core.firstMessage,
        mes_example = core.messageExample,
        data =
          StV2CardDataDto(
            name = core.name,
            description = core.description,
            personality = core.personality,
            scenario = core.scenario,
            first_mes = core.firstMessage,
            mes_example = core.messageExample,
            creator_notes = core.creatorNotes,
            system_prompt = core.systemPrompt,
            post_history_instructions = core.postHistoryInstructions,
            alternate_greetings = gson.toJsonTree(core.alternateGreetings),
            tags = core.tags,
            creator = core.creator,
            character_version = core.characterVersion,
            character_book = core.characterBook?.toDto(),
            extensions = core.extensionsJson.toJsonElement(),
          ),
      )

    return gson.toJson(dto)
  }

  private fun CharacterBook.toDto(): StCharacterBookDto {
    return StCharacterBookDto(
      name = name,
      description = description,
      scan_depth = scanDepth,
      token_budget = tokenBudget,
      recursive_scanning = recursiveScanning,
      extensions = extensionsJson.toJsonElement(),
      entries = entries.map { entry -> entry.toDto() },
    )
  }

  private fun CharacterBookEntry.toDto(): StCharacterBookEntryDto {
    return StCharacterBookEntryDto(
      id = id,
      keys = keys,
      secondary_keys = secondaryKeys,
      comment = comment,
      content = content,
      constant = constant,
      selective = selective,
      insertion_order = insertionOrder,
      enabled = enabled,
      position = position,
      extensions = extensionsJson.toJsonElement(),
    )
  }

  private fun String.toJsonElement(): JsonElement {
    if (isBlank()) {
      return JsonObject()
    }
    return runCatching { JsonParser.parseString(this) }.getOrElse { JsonObject() }
  }
}
