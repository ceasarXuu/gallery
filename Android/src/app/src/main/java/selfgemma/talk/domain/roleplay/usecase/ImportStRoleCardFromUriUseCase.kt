package selfgemma.talk.domain.roleplay.usecase

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
      val spec = jsonObject.get("spec")?.asString
      if (spec == "chara_card_v3") {
        jsonObject.addProperty("spec", "chara_card_v2")
        jsonObject.addProperty("spec_version", "2.0")
        jsonObject.toString()
      } else {
        rawJson
      }
    }.getOrDefault(rawJson)
  }
}
