package selfgemma.talk.domain.roleplay.usecase

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.RoleCardSourceFormat
import selfgemma.talk.domain.roleplay.repository.RoleplayInteropDocumentMetadata
import selfgemma.talk.domain.roleplay.repository.RoleplayInteropDocumentRepository

class StRoleCardDocumentInteropUseCaseTest {
  @Test
  fun importFromUri_readsPngRoleCard() = runBlocking {
    val repository = FakeRoleCardDocumentRepository()
    repository.metadata["content://cards/iris.png"] =
      RoleplayInteropDocumentMetadata(displayName = "iris.png", mimeType = "image/png")
    repository.metadata["content://cards/embedded.png"] =
      RoleplayInteropDocumentMetadata(displayName = "embedded.png", mimeType = "image/png")
    repository.byteDocuments["content://cards/iris.png"] =
      ExportStRoleCardToUriUseCase(
        documentRepository = repository,
        exportStV2RoleCardUseCase = ExportStV2RoleCardUseCase(),
      ).run {
        val role =
          RoleCard(
            id = "role-1",
            name = "Iris",
            summary = "Archivist",
            systemPrompt = "Stay in character.",
            createdAt = 1L,
            updatedAt = 1L,
          )
        exportToUri("content://cards/embedded.png", role)
        repository.byteDocuments.getValue("content://cards/embedded.png")
      }

    val imported =
      ImportStRoleCardFromUriUseCase(
        documentRepository = repository,
        importStV2RoleCardUseCase = ImportStV2RoleCardUseCase(),
      ).importFromUri("content://cards/iris.png", now = 5L)

    assertEquals("Iris", imported.name)
    assertEquals(RoleCardSourceFormat.ST_PNG, imported.interopState?.sourceFormat)
  }

  @Test
  fun exportToUri_writesPngWhenTargetIsPng() = runBlocking {
    val repository = FakeRoleCardDocumentRepository().apply {
      metadata["content://cards/astra.png"] =
        RoleplayInteropDocumentMetadata(displayName = "astra.png", mimeType = "image/png")
    }
    val useCase =
      ExportStRoleCardToUriUseCase(
        documentRepository = repository,
        exportStV2RoleCardUseCase = ExportStV2RoleCardUseCase(),
      )

    useCase.exportToUri(
      uri = "content://cards/astra.png",
      role =
        RoleCard(
          id = "role-1",
          name = "Captain Astra",
          summary = "Mission-first captain",
          systemPrompt = "Stay immersive.",
          createdAt = 1L,
          updatedAt = 1L,
        ),
    )

    assertTrue(repository.byteDocuments.getValue("content://cards/astra.png").isNotEmpty())
  }
}

private class FakeRoleCardDocumentRepository : RoleplayInteropDocumentRepository {
  val documents = mutableMapOf<String, String>()
  val byteDocuments = mutableMapOf<String, ByteArray>()
  val metadata = mutableMapOf<String, RoleplayInteropDocumentMetadata>()

  override suspend fun readText(uri: String): String {
    return documents[uri] ?: byteDocuments[uri]?.decodeToString() ?: error("Missing fake document for $uri")
  }

  override suspend fun writeText(uri: String, content: String) {
    documents[uri] = content
  }

  override suspend fun readBytes(uri: String): ByteArray {
    return byteDocuments[uri] ?: documents[uri]?.toByteArray() ?: error("Missing fake bytes for $uri")
  }

  override suspend fun writeBytes(uri: String, content: ByteArray) {
    byteDocuments[uri] = content
  }

  override suspend fun getMetadata(uri: String): RoleplayInteropDocumentMetadata {
    return metadata[uri] ?: RoleplayInteropDocumentMetadata(displayName = uri.substringAfterLast('/'))
  }
}
