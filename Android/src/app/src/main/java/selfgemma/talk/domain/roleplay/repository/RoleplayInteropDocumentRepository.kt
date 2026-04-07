package selfgemma.talk.domain.roleplay.repository

interface RoleplayInteropDocumentRepository {
  suspend fun readText(uri: String): String

  suspend fun writeText(uri: String, content: String)
}
