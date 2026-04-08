package selfgemma.talk.domain.roleplay.usecase

import java.util.UUID
import javax.inject.Inject
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.MessageStatus
import selfgemma.talk.domain.roleplay.model.Session
import selfgemma.talk.domain.roleplay.model.resolvedOpeningLine
import selfgemma.talk.domain.roleplay.repository.ConversationRepository
import selfgemma.talk.domain.roleplay.repository.RoleRepository

class CreateRoleplaySessionUseCase
@Inject
constructor(
  private val conversationRepository: ConversationRepository,
  private val roleRepository: RoleRepository,
) {
  suspend operator fun invoke(roleId: String, modelId: String): Session {
    val session = conversationRepository.createSession(roleId = roleId, modelId = modelId)
    val role = roleRepository.getRole(roleId) ?: return session
    val cardData = role.stCard.data
    val openingMessage =
      cardData?.first_mes
        ?.ifBlank { cardData.alternate_greetings.orEmpty().firstOrNull().orEmpty() }
        ?.ifBlank { role.resolvedOpeningLine() }
        ?: role.resolvedOpeningLine()
    if (openingMessage.isBlank()) {
      return session
    }

    val now = session.createdAt
    conversationRepository.appendMessage(
      Message(
        id = UUID.randomUUID().toString(),
        sessionId = session.id,
        seq = conversationRepository.nextMessageSeq(session.id),
        side = MessageSide.ASSISTANT,
        status = MessageStatus.COMPLETED,
        content = openingMessage,
        createdAt = now,
        updatedAt = now,
      )
    )
    return conversationRepository.getSession(session.id) ?: session
  }
}
