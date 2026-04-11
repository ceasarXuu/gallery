package selfgemma.talk.domain.roleplay.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.MessageStatus
import selfgemma.talk.domain.roleplay.model.Session
import selfgemma.talk.domain.roleplay.model.SessionEvent
import selfgemma.talk.domain.roleplay.model.SessionSummary
import selfgemma.talk.domain.roleplay.model.StUserProfile
import selfgemma.talk.domain.roleplay.model.snapshotSelectedPersona
import selfgemma.talk.domain.roleplay.repository.ConversationRepository
import selfgemma.talk.testing.FakeDataStoreRepository

class SummarizeSessionUseCaseTest {
  @Test
  fun invoke_writesSummaryAndSummaryUpdateEvent() =
    runBlocking {
      val now = System.currentTimeMillis()
      val conversationRepository =
        FakeConversationRepository(
          session =
            Session(
              id = "session-1",
              roleId = "role-1",
              title = "Docking Bay",
              activeModelId = "gemma-3n",
              createdAt = now,
              updatedAt = now,
              lastMessageAt = now,
              sessionUserProfile =
                StUserProfile(
                  personas = mapOf("captain" to "Captain Mae"),
                ).snapshotSelectedPersona("captain"),
            ),
          messages =
            listOf(
              Message(
                id = "message-1",
                sessionId = "session-1",
                seq = 1,
                side = MessageSide.USER,
                content = "We need a clean exit route.",
                status = MessageStatus.COMPLETED,
                createdAt = now,
                updatedAt = now,
              ),
              Message(
                id = "message-2",
                sessionId = "session-1",
                seq = 2,
                side = MessageSide.ASSISTANT,
                content = "The cargo elevator still works if we move now.",
                status = MessageStatus.INTERRUPTED,
                createdAt = now,
                updatedAt = now,
              ),
            ),
        )

      SummarizeSessionUseCase(FakeDataStoreRepository(), conversationRepository, TokenEstimator())("session-1")

      val summary = conversationRepository.savedSummary
      assertNotNull(summary)
      assertTrue(summary!!.summaryText.contains("Recent developments:"))
      assertTrue(summary.summaryText.contains("Captain Mae: We need a clean exit route."))
      assertTrue(summary.summaryText.contains("Assistant: The cargo elevator still works if we move now."))
      assertEquals(1, summary.version)
      assertEquals(1, conversationRepository.events.size)
      assertEquals("session-1", conversationRepository.events.single().sessionId)
    }
}

private class FakeConversationRepository(
  private val session: Session,
  private val messages: List<Message>,
) : ConversationRepository {
  var savedSummary: SessionSummary? = null
  val events = mutableListOf<SessionEvent>()

  override fun observeSessions(): Flow<List<Session>> {
    return flowOf(listOf(session))
  }

  override fun observeMessages(sessionId: String): Flow<List<Message>> {
    return flowOf(messages.filter { it.sessionId == sessionId })
  }

  override suspend fun listMessages(sessionId: String): List<Message> {
    return messages.filter { it.sessionId == sessionId }
  }

  override suspend fun getSession(sessionId: String): Session? {
    return session.takeIf { it.id == sessionId }
  }

  override suspend fun createSession(roleId: String, modelId: String, userProfile: StUserProfile?): Session {
    error("Not needed in this test")
  }

  override suspend fun updateSession(session: Session) {
    error("Not needed in this test")
  }

  override suspend fun archiveSession(sessionId: String) {
    error("Not needed in this test")
  }

  override suspend fun deleteSession(sessionId: String) {
    error("Not needed in this test")
  }

  override suspend fun appendMessage(message: Message) {
    error("Not needed in this test")
  }

  override suspend fun updateMessage(message: Message) {
    error("Not needed in this test")
  }

  override suspend fun replaceMessages(sessionId: String, messages: List<Message>) {
    error("Not needed in this test")
  }

  override suspend fun nextMessageSeq(sessionId: String): Int {
    error("Not needed in this test")
  }

  override suspend fun getSummary(sessionId: String): SessionSummary? {
    return savedSummary?.takeIf { it.sessionId == sessionId }
  }

  override suspend fun upsertSummary(summary: SessionSummary) {
    savedSummary = summary
  }

  override suspend fun listEvents(sessionId: String): List<SessionEvent> {
    return events.filter { it.sessionId == sessionId }
  }

  override suspend fun appendEvent(event: SessionEvent) {
    events += event
  }
}
