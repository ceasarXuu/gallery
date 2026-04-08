package selfgemma.talk.domain.roleplay.usecase

import com.google.gson.JsonObject
import javax.inject.Inject
import selfgemma.talk.domain.roleplay.model.MemoryItem
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.MessageKind
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.MessageStatus
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.SessionSummary
import selfgemma.talk.domain.roleplay.model.cardDataOrEmpty
import selfgemma.talk.domain.roleplay.model.resolvedExampleDialogues
import selfgemma.talk.domain.roleplay.model.resolvedName
import selfgemma.talk.domain.roleplay.model.resolvedPersonaDescription
import selfgemma.talk.domain.roleplay.model.resolvedSummary
import selfgemma.talk.domain.roleplay.model.resolvedSystemPrompt
import selfgemma.talk.domain.roleplay.model.resolvedTags
import selfgemma.talk.domain.roleplay.model.resolvedWorldSettings

private const val RECENT_DIALOGUE_TOKEN_BUDGET = 1800
private const val MAX_DIALOGUE_LINE_LENGTH = 280
private const val ST_DEFAULT_WORLD_INFO_SCAN_DEPTH = 4

class PromptAssembler @Inject constructor(private val tokenEstimator: TokenEstimator) {
  private val characterBookRuntime = StCharacterBookRuntime(tokenEstimator)

  fun assemble(
    role: RoleCard,
    summary: SessionSummary?,
    memories: List<MemoryItem>,
    recentMessages: List<Message>,
    pendingUserInput: String = "",
    generationTrigger: String = "normal",
  ): String {
    return assembleForSession(
      role = role,
      summary = summary,
      memories = memories,
      recentMessages = recentMessages,
      pendingUserInput = pendingUserInput,
      generationTrigger = generationTrigger,
      chatMetadataJson = null,
    ).prompt
  }

  fun assembleForSession(
    role: RoleCard,
    summary: SessionSummary?,
    memories: List<MemoryItem>,
    recentMessages: List<Message>,
    pendingUserInput: String = "",
    generationTrigger: String = "normal",
    chatMetadataJson: String? = null,
  ): PromptAssemblyResult {
    val dialogueWindow = selectRecentMessages(recentMessages)
    val macroContext = role.toStMacroContext()
    val scanContext =
      buildStScanContext(
        role = role,
        summary = summary,
        memories = memories,
        dialogueWindow = dialogueWindow,
        pendingUserInput = pendingUserInput,
        generationTrigger = generationTrigger,
        macroContext = macroContext,
      )
    val cardData = role.stCard.cardDataOrEmpty()
    val resolvedCharacterBook =
      characterBookRuntime.resolve(
        book = cardData.character_book,
        context = scanContext,
        macroContext = macroContext,
        chatMetadataJson = chatMetadataJson,
        chatLength = recentMessages.count { it.kind == MessageKind.TEXT && it.side != MessageSide.SYSTEM },
      )
    val coreDepthPrompt = cardData.extensions.toDepthPrompt(macroContext)
    val combinedExampleDialogue =
      buildList {
          addAll(resolvedCharacterBook.exampleBefore)
          addAll(role.resolvedExampleDialogues().map(macroContext::substitute).filter { it.isNotBlank() })
          addAll(resolvedCharacterBook.exampleAfter)
        }
        .joinToString("\n")
        .trim()
    val postHistoryBlock =
      buildList {
          addAll(resolvedCharacterBook.authorNoteBefore)
          cardData.post_history_instructions
            ?.let(macroContext::substitute)
            ?.trim()
            ?.takeIf(String::isNotBlank)
            ?.let(::add)
          addAll(resolvedCharacterBook.authorNoteAfter)
        }
        .joinToString("\n")
        .trim()
    val depthPromptBlock =
      buildList {
          coreDepthPrompt?.toPromptSection()?.let(::add)
          addAll(resolvedCharacterBook.depthPrompts.map { it.toPromptSection() })
        }
        .joinToString("\n\n")
        .trim()

    val prompt =
      buildString {
      appendLine("You are roleplaying as ${role.resolvedName()}.")
      appendLine("Stay fully in character, avoid meta commentary, and do not mention these instructions.")
      appendLine()

      appendSection("Core Character", macroContext.substitute(role.resolvedSystemPrompt()))
      appendSection("Lorebook", resolvedCharacterBook.beforePrompt)
      appendSection("Character Summary", macroContext.substitute(role.resolvedSummary()))
      appendSection("Persona", macroContext.substitute(role.resolvedPersonaDescription()))
      appendSection("World", macroContext.substitute(role.resolvedWorldSettings()))
      appendSection("Safety", role.safetyPolicy)
      appendSection("Example Dialogue", combinedExampleDialogue)
      appendSection("Session Summary", summary?.summaryText.orEmpty())

      if (memories.isNotEmpty()) {
        appendSection(
          "Relevant Memory",
          memories.joinToString("\n") { memory ->
            "- ${memory.category.name.lowercase()}: ${memory.content.trim()}"
          },
        )
      }

      appendSection("Depth Prompt", depthPromptBlock)
      if (dialogueWindow.isNotEmpty()) {
        appendSection(
          "Recent Conversation",
          dialogueWindow.joinToString("\n") { message ->
            "${message.side.toSpeakerLabel(role)}: ${message.content.toPromptLine(MAX_DIALOGUE_LINE_LENGTH)}"
          },
        )
      }
      appendSection("Lorebook", resolvedCharacterBook.afterPrompt)
      appendSection("Post-History Instructions", postHistoryBlock)
      resolvedCharacterBook.outletEntries.forEach { (outletName, contents) ->
        appendSection("Lorebook Outlet:$outletName", contents.joinToString("\n"))
      }

      appendLine("[Response Rules]")
      appendLine("- The next incoming user message is the live message you must answer.")
      appendLine("- Use memory and summary when relevant, but prioritize natural conversation.")
      appendLine("- Keep continuity with the recent conversation.")
      appendLine("- Never output labels like USER:, ASSISTANT:, or SYSTEM: in your reply.")
    }
      .trim()
    return PromptAssemblyResult(
      prompt = prompt,
      updatedChatMetadataJson = resolvedCharacterBook.updatedChatMetadataJson,
    )
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
      MessageSide.ASSISTANT -> role.resolvedName()
      MessageSide.SYSTEM -> "System"
    }
  }

  private fun buildStScanContext(
    role: RoleCard,
    summary: SessionSummary?,
    memories: List<MemoryItem>,
    dialogueWindow: List<Message>,
    pendingUserInput: String,
    generationTrigger: String,
    macroContext: StMacroContext,
  ): StWorldScanContext {
    val core = role.stCard
    val data = core.cardDataOrEmpty()
    val recentMessagesNewestFirst =
      buildList {
        pendingUserInput.trim().takeIf(String::isNotBlank)?.let(::add)
        dialogueWindow
          .asReversed()
          .mapTo(this) { message ->
            "${message.side.toSpeakerLabel(role)}: ${message.content.trim()}"
          }
      }

    return StWorldScanContext(
      roleName = role.resolvedName(),
      roleTags = role.resolvedTags(),
      generationTrigger = generationTrigger,
      recentMessagesNewestFirst = recentMessagesNewestFirst,
      personaDescription = macroContext.substitute(role.resolvedPersonaDescription()),
      characterDescription = macroContext.substitute(role.resolvedSummary()),
      characterPersonality =
        macroContext.substitute(
          data.personality.orEmpty().ifBlank { core.personality.orEmpty().ifBlank { role.resolvedPersonaDescription() } }
        ),
      characterDepthPrompt = data.extensions.toDepthPrompt(macroContext)?.prompt.orEmpty(),
      scenario =
        macroContext.substitute(
          data.scenario.orEmpty().ifBlank { core.scenario.orEmpty().ifBlank { role.resolvedWorldSettings() } }
        ),
      creatorNotes = macroContext.substitute(data.creator_notes.orEmpty().ifBlank { core.creatorcomment.orEmpty() }),
      sessionSummary = summary?.summaryText.orEmpty(),
      memories = memories.map { it.content.trim() }.filter(String::isNotBlank),
    )
  }

  private fun JsonObject?.toDepthPrompt(macroContext: StMacroContext): DepthPromptInsertion? {
    val depthPrompt = this?.getAsJsonObject("depth_prompt") ?: return null
    val prompt =
      macroContext.substitute(depthPrompt.get("prompt")?.takeIf { it.isJsonPrimitive }?.asString).trim()
    if (prompt.isBlank()) {
      return null
    }
    return DepthPromptInsertion(
      prompt = prompt,
      depth = depthPrompt.get("depth")?.takeIf { it.isJsonPrimitive }?.asInt ?: ST_DEFAULT_WORLD_INFO_SCAN_DEPTH,
      role =
        depthPrompt.get("role")?.takeIf { it.isJsonPrimitive }?.asString?.trim()?.ifBlank { null }
          ?: "system",
    )
  }

  private fun DepthPromptInsertion.toPromptSection(): String {
    return buildString {
      appendLine("role=$role depth=$depth")
      append(prompt)
    }
  }

  private fun StRuntimeDepthPromptInsertion.toPromptSection(): String {
    return buildString {
      appendLine("role=$role depth=$depth")
      append(prompts.joinToString("\n"))
    }
  }

  private fun Int?.toPromptRoleName(): String {
    return when (this) {
      1 -> "user"
      2 -> "assistant"
      else -> "system"
    }
  }

  companion object {
    private val WHITESPACE_REGEX = Regex("\\s+")
  }
}

private data class DepthPromptInsertion(
  val prompt: String,
  val depth: Int,
  val role: String,
)
