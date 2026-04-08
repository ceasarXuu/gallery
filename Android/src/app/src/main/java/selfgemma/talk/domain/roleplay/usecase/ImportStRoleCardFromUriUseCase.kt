package selfgemma.talk.domain.roleplay.usecase

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.util.UUID
import selfgemma.talk.data.roleplay.interop.stcardpng.StPngRoleCardCodec
import javax.inject.Inject
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.RoleCardExportTarget
import selfgemma.talk.domain.roleplay.model.RoleCardSourceFormat
import selfgemma.talk.domain.roleplay.model.RoleMediaAsset
import selfgemma.talk.domain.roleplay.model.RoleMediaImportState
import selfgemma.talk.domain.roleplay.model.RoleMediaKind
import selfgemma.talk.domain.roleplay.model.RoleMediaProfile
import selfgemma.talk.domain.roleplay.model.RoleMediaSource
import selfgemma.talk.domain.roleplay.repository.RoleplayInteropDocumentRepository

class ImportStRoleCardFromUriUseCase
@Inject
constructor(
  private val documentRepository: RoleplayInteropDocumentRepository,
  private val importStV2RoleCardUseCase: ImportStV2RoleCardUseCase,
) {
  suspend fun importFromUri(
    uri: String,
    existingRole: RoleCard? = null,
    now: Long = System.currentTimeMillis(),
  ): RoleCard {
    val metadata = documentRepository.getMetadata(uri)
    val isPng = metadata.mimeType == "image/png" || metadata.displayName?.endsWith(".png", ignoreCase = true) == true
    val rawJson =
      if (isPng) {
        StPngRoleCardCodec.extractCardJson(documentRepository.readBytes(uri))
      } else {
        documentRepository.readText(uri)
      }
    val normalizedJson = normalizeSupportedSpec(rawJson)

    val imported =
      importStV2RoleCardUseCase.importFromJson(
        rawJson = normalizedJson,
        existingRole = existingRole,
        now = now,
      )

    if (!isPng) {
      return imported
    }

    return imported.copy(
      avatarUri = uri,
      mediaProfile =
        (imported.mediaProfile ?: RoleMediaProfile()).copy(
          primaryAvatar =
            RoleMediaAsset(
              id = UUID.nameUUIDFromBytes("st-avatar:$uri".toByteArray()).toString(),
              kind = RoleMediaKind.PRIMARY_AVATAR,
              uri = uri,
              source = RoleMediaSource.ST_PNG_IMPORT,
              createdAt = imported.createdAt,
              updatedAt = imported.updatedAt,
            ),
          importState =
            RoleMediaImportState(
              lastImportedPrimaryAvatarSource = uri,
              importedFromStPng = true,
              lastImportHadEmbeddedImage = true,
            ),
        ),
      interopState =
        imported.interopState?.copy(
          sourceFormat = RoleCardSourceFormat.ST_PNG,
          exportTargetDefault = RoleCardExportTarget.ST_PNG,
        )
    )
  }

  private fun normalizeSupportedSpec(rawJson: String): String {
    return runCatching {
      val jsonObject = JsonParser.parseString(rawJson).asJsonObject
      when (jsonObject.get("spec")?.asString) {
        "chara_card_v3" -> {
          jsonObject.addProperty("spec", "chara_card_v2")
          jsonObject.addProperty("spec_version", "2.0")
          jsonObject.toString()
        }
        "chara_card_v2" -> rawJson
        else -> normalizeLegacyCard(jsonObject)?.toString() ?: rawJson
      }
    }.getOrDefault(rawJson)
  }

  private fun normalizeLegacyCard(jsonObject: JsonObject): JsonObject? {
    val requiredLegacyFields = listOf("name", "description", "personality", "scenario", "first_mes", "mes_example")
    if (requiredLegacyFields.any { field -> !jsonObject.has(field) }) {
      return null
    }

    return JsonObject().apply {
      addProperty("spec", "chara_card_v2")
      addProperty("spec_version", "2.0")
      addProperty("name", jsonObject.stringValue("name"))
      addProperty("description", jsonObject.stringValue("description"))
      addProperty("personality", jsonObject.stringValue("personality"))
      addProperty("scenario", jsonObject.stringValue("scenario"))
      addProperty("first_mes", jsonObject.stringValue("first_mes"))
      addProperty("mes_example", jsonObject.stringValue("mes_example"))
      add(
        "data",
        JsonObject().apply {
          addProperty("name", jsonObject.stringValue("name"))
          addProperty("description", jsonObject.stringValue("description"))
          addProperty("personality", jsonObject.stringValue("personality"))
          addProperty("scenario", jsonObject.stringValue("scenario"))
          addProperty("first_mes", jsonObject.stringValue("first_mes"))
          addProperty("mes_example", jsonObject.stringValue("mes_example"))
          addProperty(
            "creator_notes",
            jsonObject.firstStringValue("creatorcomment", "creator_notes"),
          )
          addProperty("system_prompt", "")
          addProperty("post_history_instructions", "")
          add("alternate_greetings", JsonArray())
          add("tags", jsonObject.toTagArray())
          addProperty("creator", jsonObject.stringValue("creator"))
          addProperty("character_version", jsonObject.stringValue("character_version"))
          add(
            "extensions",
            JsonObject().apply {
              addProperty("talkativeness", jsonObject.doubleValue("talkativeness") ?: 0.5)
              addProperty("fav", jsonObject.booleanValue("fav") ?: false)
              addProperty("world", jsonObject.stringValue("world"))
            },
          )
        },
      )
    }
  }

  private fun JsonObject.stringValue(key: String): String {
    val value = get(key) ?: return ""
    return if (value.isJsonNull) "" else value.asString
  }

  private fun JsonObject.firstStringValue(vararg keys: String): String {
    return keys.firstNotNullOfOrNull { key ->
      get(key)?.takeUnless { it.isJsonNull }?.asString
    }.orEmpty()
  }

  private fun JsonObject.doubleValue(key: String): Double? {
    val value = get(key) ?: return null
    if (value.isJsonNull) {
      return null
    }
    return value.asString.toDoubleOrNull()
  }

  private fun JsonObject.booleanValue(key: String): Boolean? {
    val value = get(key) ?: return null
    if (value.isJsonNull) {
      return null
    }
    return when {
      value.isJsonPrimitive && value.asJsonPrimitive.isBoolean -> value.asBoolean
      value.isJsonPrimitive && value.asJsonPrimitive.isString -> {
        when (value.asString.lowercase()) {
          "true" -> true
          "false" -> false
          else -> null
        }
      }
      else -> null
    }
  }

  private fun JsonObject.toTagArray(): JsonArray {
    val tags = get("tags") ?: return JsonArray()
    return when {
      tags.isJsonArray -> tags.asJsonArray.deepCopy()
      tags.isJsonPrimitive && tags.asJsonPrimitive.isString -> {
        JsonArray().apply {
          tags.asString
            .split(",")
            .map(String::trim)
            .filter(String::isNotBlank)
            .forEach(::add)
        }
      }
      else -> JsonArray()
    }
  }
}
