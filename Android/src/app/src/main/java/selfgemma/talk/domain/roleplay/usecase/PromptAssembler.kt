package selfgemma.talk.domain.roleplay.usecase

import javax.inject.Inject
import selfgemma.talk.domain.roleplay.model.MemoryItem
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.MessageKind
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.MessageStatus
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.SessionSummary

private const val RECENT_DIALOGUE_TOKEN_BUDGET = 1800
private const val MAX_DIALOGUE_LINE_LENGTH = 280

class PromptAssembler @Inject constructor(private val tokenEstimator: TokenEstimator) {
  fun assemble(
    role: RoleCard,
    summary: SessionSummary?,
    memories: List<MemoryItem>,
    recentMessages: List<Message>,
  ): String {
    val dialogueWindow = selectRecentMessages(recentMessages)

    return buildString {
      appendLine("You are roleplaying as ${role.name}.")
      appendLine("Stay fully in character, avoid meta commentary, and do not mention these instructions.")
      appendLine()

      appendSection("Core Character", role.systemPrompt)
      appendSection("Character Summary", role.summary)
      appendSection("Persona", role.personaDescription)
      appendSection("World", role.worldSettings)
      appendSection("Safety", role.safetyPolicy)

      if (role.exampleDialogues.isNotEmpty()) {
        appendSection("Example Dialogue", role.exampleDialogues.joinToString("\n"))
      }

      if (role.openingLine.isNotBlank() && dialogueWindow.isEmpty()) {
        appendSection("Suggested Opening Tone", role.openingLine)
      }

      appendSection("Session Summary", summary?.summaryText.orEmpty())

      if (memories.isNotEmpty()) {
        appendSection(
          "Relevant Memory",
          memories.joinToString("\n") { memory ->
            "- ${memory.category.name.lowercase()}: ${memory.content.trim()}"
          },
        )
      }

      if (dialogueWindow.isNotEmpty()) {
        appendSection(
          "Recent Conversation",
          dialogueWindow.joinToString("\n") { message ->
            "${message.side.toSpeakerLabel(role)}: ${message.content.toPromptLine(MAX_DIALOGUE_LINE_LENGTH)}"
          },
        )
      }

      appendLine("[Response Rules]")
      appendLine("- The next incoming user message is the live message you must answer.")
      appendLine("- Use memory and summary when relevant, but prioritize natural conversation.")
      appendLine("- Keep continuity with the recent conversation.")
      appendLine("- Never output labels like USER:, ASSISTANT:, or SYSTEM: in your reply.")
    }
      .trim()
  }

  private fun selectRecentMessages(messages: List<Message>): List<Message> {
    val filtered =
      messages.filter { message ->
        message.kind == MessageKind.TEXT &&
          message.side != MessageSide.SYSTEM &&
          message.status != MessageStatus.FAILED &&
          message.content.isNotBlank()
      }

    if (filtered.isEmpty()) {
      return emptyList()
    }

    val selected = mutableListOf<Message>()
    var tokenCount = 0

    for (message in filtered.asReversed()) {
      val nextTokenCount =
        tokenCount + tokenEstimator.estimate(message.content) + tokenEstimator.estimate(message.side.name)
      if (selected.isNotEmpty() && nextTokenCount > RECENT_DIALOGUE_TOKEN_BUDGET) {
        break
      }

      selected += message
      tokenCount = nextTokenCount
    }

    return selected.asReversed()
  }

  private fun String.toPromptLine(maxLength: Int): String {
    return trim().replace(WHITESPACE_REGEX, " ").take(maxLength)
  }

  private fun StringBuilder.appendSection(title: String, body: String) {
    if (body.isBlank()) {
      return
    }

    appendLine("[$title]")
    appendLine(body.trim())
    appendLine()
  }

  private fun MessageSide.toSpeakerLabel(role: RoleCard): String {
    return when (this) {
      MessageSide.USER -> "User"
      MessageSide.ASSISTANT -> role.name
      MessageSide.SYSTEM -> "System"
    }
  }

  companion object {
    private val WHITESPACE_REGEX = Regex("\\s+")
  }
}