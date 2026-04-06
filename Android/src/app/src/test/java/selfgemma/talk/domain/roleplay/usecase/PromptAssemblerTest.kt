package selfgemma.talk.domain.roleplay.usecase

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import selfgemma.talk.domain.roleplay.model.MemoryCategory
import selfgemma.talk.domain.roleplay.model.MemoryItem
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.MessageStatus
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.SessionSummary

class PromptAssemblerTest {
  private val assembler = PromptAssembler(TokenEstimator())

  @Test
  fun assemble_includesSummaryMemoryAndRecentConversation() {
    val now = System.currentTimeMillis()
    val prompt =
      assembler.assemble(
        role =
          RoleCard(
            id = "role-1",
            name = "Iris Vale",
            summary = "A dry-witted investigator.",
            systemPrompt = "Always stay in character.",
            openingLine = "The case file is already open.",
            createdAt = now,
            updatedAt = now,
          ),
        summary =
          SessionSummary(
            sessionId = "session-1",
            version = 2,
            coveredUntilSeq = 5,
            summaryText = "The pair discovered a forged transit pass.",
            tokenEstimate = 12,
            updatedAt = now,
          ),
        memories =
          listOf(
            MemoryItem(
              id = "memory-1",
              roleId = "role-1",
              sessionId = "session-1",
              category = MemoryCategory.PLOT,
              content = "The suspect fled toward the lower station.",
              normalizedHash = "hash-1",
              pinned = true,
              createdAt = now,
              updatedAt = now,
            )
          ),
        recentMessages =
          listOf(
            Message(
              id = "message-1",
              sessionId = "session-1",
              seq = 1,
              side = MessageSide.USER,
              content = "We should check the lower station next.",
              status = MessageStatus.COMPLETED,
              createdAt = now,
              updatedAt = now,
            ),
            Message(
              id = "message-2",
              sessionId = "session-1",
              seq = 2,
              side = MessageSide.ASSISTANT,
              content = "Agreed. The forged pass narrows the route.",
              status = MessageStatus.COMPLETED,
              createdAt = now,
              updatedAt = now,
            ),
          ),
      )

    assertTrue(prompt.contains("[Session Summary]"))
    assertTrue(prompt.contains("The pair discovered a forged transit pass."))
    assertTrue(prompt.contains("[Relevant Memory]"))
    assertTrue(prompt.contains("plot: The suspect fled toward the lower station."))
    assertTrue(prompt.contains("User: We should check the lower station next."))
    assertTrue(prompt.contains("Iris Vale: Agreed. The forged pass narrows the route."))
    assertFalse(prompt.contains("[Suggested Opening Tone]"))
  }
}