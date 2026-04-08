package selfgemma.talk.domain.roleplay.usecase

import com.google.gson.JsonObject
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
import selfgemma.talk.domain.roleplay.model.StCharacterBook
import selfgemma.talk.domain.roleplay.model.StCharacterBookEntry
import selfgemma.talk.domain.roleplay.model.StCharacterCard
import selfgemma.talk.domain.roleplay.model.StCharacterCardData

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
              StCharacterCard(
                name = "Iris Vale",
                data =
                  StCharacterCardData(
                    name = "Iris Vale",
                    creator_notes = "The creator note mentions a sealed dossier.",
                    post_history_instructions = "Keep responses terse after the history block.",
                    extensions =
                      JsonObject().apply {
                        add(
                          "depth_prompt",
                          JsonObject().apply {
                            addProperty("prompt", "Reveal the hidden motive only after enough pressure.")
                            addProperty("depth", 3)
                            addProperty("role", "system")
                          },
                        )
                      },
                    character_book =
                      StCharacterBook(
                        entries =
                          listOf(
                            StCharacterBookEntry(
                              id = 1,
                              keys = listOf("lower station"),
                              content = "The lower station smells like coolant and wet rust.",
                              position = "before_char",
                            ),
                            StCharacterBookEntry(
                              id = 2,
                              keys = listOf("forged pass"),
                              content = "If the forged pass comes up, Iris should suspect internal sabotage.",
                              position = "after_char",
                            ),
                            StCharacterBookEntry(
                              id = 3,
                              keys = listOf("sealed dossier"),
                              content = "Treat the sealed dossier as evidence that someone inside the precinct is compromised.",
                              extensions =
                                JsonObject().apply {
                                  addProperty("match_creator_notes", true)
                                  addProperty("position", 2)
                                },
                            ),
                            StCharacterBookEntry(
                              id = 4,
                              keys = listOf("lower"),
                              secondary_keys = listOf("station"),
                              content = "Ask precise follow-up questions when the lower station is discussed.",
                              selective = true,
                              extensions =
                                JsonObject().apply {
                                  addProperty("selectiveLogic", 3)
                                  addProperty("position", 4)
                                  addProperty("depth", 2)
                                  addProperty("role", 2)
                                },
                            ),
                          )
                      ),
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
              StCharacterCard(
                name = "Casey",
                data =
                  StCharacterCardData(
                    character_book =
                      StCharacterBook(
                        entries =
                          listOf(
                            StCharacterBookEntry(
                              id = 1,
                              keys = listOf("Key"),
                              content = "Case-sensitive match should trigger.",
                              extensions = JsonObject().apply { addProperty("case_sensitive", true) },
                            ),
                            StCharacterBookEntry(
                              id = 2,
                              keys = listOf("cat"),
                              content = "Whole-word match should not trigger for scatter.",
                              extensions = JsonObject().apply { addProperty("match_whole_words", true) },
                            ),
                          )
                      ),
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

  @Test
  fun assemble_prefersCanonicalStCardProjectionOverLegacyFields() {
    val now = System.currentTimeMillis()
    val prompt =
      assembler.assemble(
        role =
          RoleCard(
            id = "role-3",
            name = "Legacy Name",
            summary = "Legacy summary",
            systemPrompt = "Legacy prompt",
            personaDescription = "Legacy persona",
            worldSettings = "Legacy world",
            exampleDialogues = listOf("Legacy example"),
            cardCore =
              StCharacterCard(
                name = "Canonical Name",
                data =
                  StCharacterCardData(
                    name = "Canonical Name",
                    description = "Canonical summary",
                    personality = "Canonical persona",
                    scenario = "Canonical world",
                    mes_example = "Canonical example",
                    system_prompt = "Canonical prompt",
                  ),
              ),
            createdAt = now,
            updatedAt = now,
          ),
        summary = null,
        memories = emptyList(),
        recentMessages = emptyList(),
        pendingUserInput = "",
      )

    assertTrue(prompt.contains("You are roleplaying as Canonical Name."))
    assertTrue(prompt.contains("[Core Character]\nCanonical prompt"))
    assertTrue(prompt.contains("[Character Summary]\nCanonical summary"))
    assertTrue(prompt.contains("[Persona]\nCanonical persona"))
    assertTrue(prompt.contains("[World]\nCanonical world"))
    assertTrue(prompt.contains("[Example Dialogue]\nCanonical example"))
    assertFalse(prompt.contains("Legacy summary"))
    assertFalse(prompt.contains("Legacy prompt"))
  }

  @Test
  fun assemble_substitutesStMacrosAcrossPromptAndLorebook() {
    val now = System.currentTimeMillis()
    val prompt =
      assembler.assemble(
        role =
          RoleCard(
            id = "role-4",
            name = "Catty",
            summary = "{{user}} adopted {{char}}.",
            systemPrompt = "Protect {{user}} and remember {{creatorNotes}}.",
            personaDescription = "{{char}} is playful.",
            worldSettings = "{{scenario}}",
            cardCore =
              StCharacterCard(
                name = "Catty",
                scenario = "legacy world",
                data =
                  StCharacterCardData(
                    scenario = "{{user}} and {{char}} share an apartment.",
                    creator_notes = "{{user}} rescued {{char}} from a shelter.",
                    mes_example = "{{user}}: Hi\n{{char}}: Hey.",
                    character_book =
                      StCharacterBook(
                        entries =
                          listOf(
                            StCharacterBookEntry(
                              id = 1,
                              keys = listOf("Catty"),
                              content = "{{char}} trusts {{user}}.",
                              position = "before_char",
                            )
                          ),
                      ),
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
              id = "message-4",
              sessionId = "session-4",
              seq = 1,
              side = MessageSide.USER,
              content = "Catty is here.",
              status = MessageStatus.COMPLETED,
              createdAt = now,
              updatedAt = now,
            )
          ),
        pendingUserInput = "",
      )

    assertTrue(prompt.contains("Protect User and remember User rescued Catty from a shelter.."))
    assertTrue(prompt.contains("[Character Summary]\nUser adopted Catty."))
    assertTrue(prompt.contains("[Persona]\nCatty is playful."))
    assertTrue(prompt.contains("[World]\nUser and Catty share an apartment."))
    assertTrue(prompt.contains("[Example Dialogue]\nUser: Hi\nCatty: Hey."))
    assertTrue(prompt.contains("Catty trusts User."))
    assertFalse(prompt.contains("{{char}}"))
    assertFalse(prompt.contains("{{user}}"))
    assertFalse(prompt.contains("<USER>"))
  }
}
