package selfgemma.talk.domain.roleplay.usecase

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import selfgemma.talk.domain.roleplay.model.CharacterBook
import selfgemma.talk.domain.roleplay.model.CharacterBookEntry
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
            cardCore =
              selfgemma.talk.domain.roleplay.model.RoleCardCore(
                name = "Iris Vale",
                postHistoryInstructions = "Keep responses terse after the history block.",
                creatorNotes = "The creator note mentions a sealed dossier.",
                extensionsJson = """{"depth_prompt":{"prompt":"Reveal the hidden motive only after enough pressure.","depth":3,"role":"system"}}""",
                characterBook =
                  CharacterBook(
                    entries =
                      listOf(
                        CharacterBookEntry(
                          id = 1,
                          keys = listOf("lower station"),
                          content = "The lower station smells like coolant and wet rust.",
                          position = "before_char",
                        ),
                        CharacterBookEntry(
                          id = 2,
                          keys = listOf("forged pass"),
                          content = "If the forged pass comes up, Iris should suspect internal sabotage.",
                          position = "after_char",
                        ),
                        CharacterBookEntry(
                          id = 3,
                          keys = listOf("sealed dossier"),
                          content = "Treat the sealed dossier as evidence that someone inside the precinct is compromised.",
                          extensionsJson = """{"match_creator_notes":true,"position":2}""",
                        ),
                        CharacterBookEntry(
                          id = 4,
                          keys = listOf("lower"),
                          secondaryKeys = listOf("station"),
                          content = "Ask precise follow-up questions when the lower station is discussed.",
                          selective = true,
                          extensionsJson = """{"selectiveLogic":3,"position":4,"depth":2,"role":2}""",
                        ),
                      )
                  ),
              ),
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
        pendingUserInput = "Could the forged pass point to someone inside the lower station?",
      )

    assertTrue(prompt.contains("[Lorebook]"))
    assertTrue(prompt.contains("The lower station smells like coolant and wet rust."))
    assertTrue(prompt.contains("If the forged pass comes up, Iris should suspect internal sabotage."))
    assertTrue(prompt.contains("Treat the sealed dossier as evidence that someone inside the precinct is compromised."))
    assertTrue(prompt.contains("[Post-History Instructions]"))
    assertTrue(prompt.contains("Keep responses terse after the history block."))
    assertTrue(prompt.contains("[Depth Prompt]"))
    assertTrue(prompt.contains("Reveal the hidden motive only after enough pressure."))
    assertTrue(prompt.contains("role=assistant depth=2"))
    assertTrue(prompt.contains("Ask precise follow-up questions when the lower station is discussed."))
    assertTrue(prompt.contains("[Session Summary]"))
    assertTrue(prompt.contains("The pair discovered a forged transit pass."))
    assertTrue(prompt.contains("[Relevant Memory]"))
    assertTrue(prompt.contains("plot: The suspect fled toward the lower station."))
    assertTrue(prompt.contains("User: We should check the lower station next."))
    assertTrue(prompt.contains("Iris Vale: Agreed. The forged pass narrows the route."))
    assertFalse(prompt.contains("[Suggested Opening Tone]"))
    assertFalse(prompt.contains("The case file is already open."))
  }

  @Test
  fun assemble_respects_case_sensitive_and_whole_word_matching() {
    val now = System.currentTimeMillis()
    val prompt =
      assembler.assemble(
        role =
          RoleCard(
            id = "role-2",
            name = "Casey",
            summary = "A test role.",
            systemPrompt = "",
            cardCore =
              selfgemma.talk.domain.roleplay.model.RoleCardCore(
                name = "Casey",
                characterBook =
                  CharacterBook(
                    entries =
                      listOf(
                        CharacterBookEntry(
                          id = 1,
                          keys = listOf("Key"),
                          content = "Case-sensitive match should trigger.",
                          extensionsJson = """{"case_sensitive":true}""",
                        ),
                        CharacterBookEntry(
                          id = 2,
                          keys = listOf("cat"),
                          content = "Whole-word match should not trigger for scatter.",
                          extensionsJson = """{"match_whole_words":true}""",
                        ),
                      )
                  ),
              ),
            createdAt = now,
            updatedAt = now,
          ),
        summary = null,
        memories = emptyList(),
        recentMessages =
          listOf(
            Message(
              id = "message-3",
              sessionId = "session-2",
              seq = 1,
              side = MessageSide.USER,
              content = "The Key is here, but the scatter is unrelated.",
              status = MessageStatus.COMPLETED,
              createdAt = now,
              updatedAt = now,
            )
          ),
        pendingUserInput = "",
      )

    assertTrue(prompt.contains("Case-sensitive match should trigger."))
    assertFalse(prompt.contains("Whole-word match should not trigger for scatter."))
  }
}
