package selfgemma.talk.domain.roleplay.usecase

import java.util.Base64
import javax.inject.Inject
import selfgemma.talk.data.roleplay.interop.stcardpng.StPngRoleCardCodec
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.repository.RoleplayInteropDocumentRepository

class ExportStRoleCardToUriUseCase
@Inject
constructor(
  private val documentRepository: RoleplayInteropDocumentRepository,
  private val exportStV2RoleCardUseCase: ExportStV2RoleCardUseCase,
) {
  suspend fun exportToUri(uri: String, role: RoleCard) {
    val metadata = documentRepository.getMetadata(uri)
    val isPng = metadata.mimeType == "image/png" || metadata.displayName?.endsWith(".png", ignoreCase = true) == true
    val rawJson = exportStV2RoleCardUseCase.exportToJson(role)
    if (!isPng) {
      documentRepository.writeText(uri, rawJson)
      return
    }

    val basePngBytes =
      role.avatarUri?.let { avatarUri ->
        runCatching { documentRepository.readBytes(avatarUri) }.getOrNull()
      } ?: DEFAULT_TRANSPARENT_PNG

    documentRepository.writeBytes(uri, StPngRoleCardCodec.embedCardJson(basePngBytes = basePngBytes, json = rawJson))
  }

  private companion object {
    val DEFAULT_TRANSPARENT_PNG: ByteArray =
      Base64.getDecoder().decode(
        "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mP8/x8AAwMCAO8BzZQAAAAASUVORK5CYII="
      )
  }
}
