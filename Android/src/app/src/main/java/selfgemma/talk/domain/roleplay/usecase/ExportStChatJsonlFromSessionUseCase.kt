package selfgemma.talk.domain.roleplay.usecase

import javax.inject.Inject
import selfgemma.talk.domain.roleplay.repository.ConversationRepository
import selfgemma.talk.domain.roleplay.repository.RoleRepository

class ExportStChatJsonlFromSessionUseCase
@Inject
constructor(
  private val conversationRepository: ConversationRepository,
  private val roleRepository: RoleRepository,
  private val exportStChatJsonlToUriUseCase: ExportStChatJsonlToUriUseCase,
) {
  suspend fun exportFromSession(sessionId: String, uri: String) {
    val session = conversationRepository.getSession(sessionId) ?: error("Session not found.")
    val role = roleRepository.getRole(session.roleId) ?: error("Role not found.")
    val messages = conversationRepository.listMessages(sessionId)

    exportStChatJsonlToUriUseCase.exportToUri(
      uri = uri,
      chatMetadataJson = session.interopChatMetadataJson ?: "{}",
      userName = null,
      roleName = role.name,
      messages = messages,
    )
  }
}
