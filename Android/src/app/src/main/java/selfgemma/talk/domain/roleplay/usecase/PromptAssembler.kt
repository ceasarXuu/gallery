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
import selfgemma.talk.domain.roleplay.model.StCharacterBook
import selfgemma.talk.domain.roleplay.model.StCharacterBookEntry
import selfgemma.talk.domain.roleplay.model.resolvedExampleDialogues
import selfgemma.talk.domain.roleplay.model.resolvedName
import selfgemma.talk.domain.roleplay.model.resolvedPersonaDescription
import selfgemma.talk.domain.roleplay.model.resolvedSummary
import selfgemma.talk.domain.roleplay.model.resolvedSystemPrompt
import selfgemma.talk.domain.roleplay.model.resolvedWorldSettings

private const val RECENT_DIALOGUE_TOKEN_BUDGET = 1800
private const val MAX_DIALOGUE_LINE_LENGTH = 280
private const val ST_DEFAULT_WORLD_INFO_SCAN_DEPTH = 4

class PromptAssembler @Inject constructor(private val tokenEstimator: TokenEstimator) {
  fun assemble(
    role: RoleCard,
    summary: SessionSummary?,
    memories: List<MemoryItem>,
    recentMessages: List<Message>,
    pendingUserInput: String = "",
  ): String {
    val dialogueWindow = selectRecentMessages(recentMessages)
    val scanContext =
      buildStScanContext(
        role = role,
        summary = summary,
        memories = memories,
        dialogueWindow = dialogueWindow,
        pendingUserInput = pendingUserInput,
      )
    val cardData = role.stCard.data
    val resolvedCharacterBook = cardData?.character_book.resolveForPrompt(scanContext)
    val coreDepthPrompt = cardData?.extensions.toDepthPrompt()
    val combinedExampleDialogue =
      buildList {
          addAll(resolvedCharacterBook.exampleBefore)
          addAll(role.resolvedExampleDialogues().filter { it.isNotBlank() })
          addAll(resolvedCharacterBook.exampleAfter)
        }
        .joinToString("\n")
        .trim()
    val postHistoryBlock =
      buildList {
          addAll(resolvedCharacterBook.authorNoteBefore)
          cardData?.post_history_instructions
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

    return buildString {
      appendLine("You are roleplaying as ${role.resolvedName()}.")
      appendLine("Stay fully in character, avoid meta commentary, and do not mention these instructions.")
      appendLine()

      appendSection("Core Character", role.resolvedSystemPrompt())
      appendSection("Lorebook", resolvedCharacterBook.beforePrompt)
      appendSection("Character Summary", role.resolvedSummary())
      appendSection("Persona", role.resolvedPersonaDescription())
      appendSection("World", role.resolvedWorldSettings())
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
  ): StScanContext {
    val core = role.stCard
    val data = core?.data
    val recentMessagesNewestFirst =
      buildList {
        pendingUserInput.trim().takeIf(String::isNotBlank)?.let(::add)
        dialogueWindow
          .asReversed()
          .mapTo(this) { message ->
            "${message.side.toSpeakerLabel(role)}: ${message.content.trim()}"
          }
      }

    return StScanContext(
      recentMessagesNewestFirst = recentMessagesNewestFirst,
      personaDescription = role.resolvedPersonaDescription(),
      characterDescription = role.resolvedSummary(),
      characterPersonality =
        data?.personality.orEmpty().ifBlank { core?.personality.orEmpty().ifBlank { role.resolvedPersonaDescription() } },
      characterDepthPrompt = data?.extensions.toDepthPrompt()?.prompt.orEmpty(),
      scenario = data?.scenario.orEmpty().ifBlank { core?.scenario.orEmpty().ifBlank { role.resolvedWorldSettings() } },
      creatorNotes = data?.creator_notes.orEmpty(),
      sessionSummary = summary?.summaryText.orEmpty(),
      memories = memories.map { it.content.trim() }.filter(String::isNotBlank),
    )
  }

  private fun StCharacterBook?.resolveForPrompt(context: StScanContext): ResolvedCharacterBook {
    if (this == null) {
      return ResolvedCharacterBook()
    }

    val activatedEntries =
      entries
        .orEmpty()
        .filter { (it.enabled ?: true) && !it.content.isNullOrBlank() }
        .filter { entry -> entry.shouldActivate(context = context, defaultScanDepth = scan_depth) }
        .sortedBy { it.insertion_order ?: 0 }

    if (activatedEntries.isEmpty()) {
      return ResolvedCharacterBook()
    }

    val beforePrompt = mutableListOf<String>()
    val afterPrompt = mutableListOf<String>()
    val authorNoteBefore = mutableListOf<String>()
    val authorNoteAfter = mutableListOf<String>()
    val exampleBefore = mutableListOf<String>()
    val exampleAfter = mutableListOf<String>()
    val depthPrompts = mutableListOf<DepthPromptInsertion>()

    activatedEntries.forEach { entry ->
      val content = entry.content.orEmpty().trim()
      when (entry.resolvePromptPosition()) {
        StWorldInfoPosition.BEFORE -> beforePrompt += content
        StWorldInfoPosition.AFTER -> afterPrompt += content
        StWorldInfoPosition.AUTHOR_NOTE_BEFORE -> authorNoteBefore += content
        StWorldInfoPosition.AUTHOR_NOTE_AFTER -> authorNoteAfter += content
        StWorldInfoPosition.EXAMPLE_BEFORE -> exampleBefore += content
        StWorldInfoPosition.EXAMPLE_AFTER -> exampleAfter += content
        StWorldInfoPosition.AT_DEPTH ->
          depthPrompts +=
            DepthPromptInsertion(
              prompt = content,
              depth = entry.extensions().depth ?: ST_DEFAULT_WORLD_INFO_SCAN_DEPTH,
              role = entry.extensions().role.toPromptRoleName(),
            )
        StWorldInfoPosition.OUTLET -> afterPrompt += content
      }
    }

    return ResolvedCharacterBook(
      beforePrompt = beforePrompt.joinToString("\n").trim(),
      afterPrompt = afterPrompt.joinToString("\n").trim(),
      authorNoteBefore = authorNoteBefore,
      authorNoteAfter = authorNoteAfter,
      exampleBefore = exampleBefore,
      exampleAfter = exampleAfter,
      depthPrompts = depthPrompts.sortedBy { it.depth },
    )
  }

  private fun StCharacterBookEntry.shouldActivate(context: StScanContext, defaultScanDepth: Int?): Boolean {
    if (constant == true) {
      return true
    }
    if (keys.isNullOrEmpty()) {
      return false
    }

    val extensions = extensions()
    val textToScan = context.toScanText(extensions = extensions, defaultScanDepth = defaultScanDepth)
    val matchedPrimary =
      keys
        .orEmpty()
        .filter(String::isNotBlank)
        .any { key -> textToScan.matchesKeyword(keyword = key.trim(), extensions = extensions) }
    if (!matchedPrimary) {
      return false
    }
    if (selective != true || secondary_keys.orEmpty().none(String::isNotBlank)) {
      return true
    }

    val secondaryMatches =
      secondary_keys
        .orEmpty()
        .filter(String::isNotBlank)
        .map { key -> textToScan.matchesKeyword(keyword = key.trim(), extensions = extensions) }
    return when (extensions.selectiveLogic) {
      StSelectiveLogic.AND_ANY -> secondaryMatches.any { it }
      StSelectiveLogic.NOT_ALL -> secondaryMatches.any { matched -> !matched }
      StSelectiveLogic.NOT_ANY -> secondaryMatches.none { it }
      StSelectiveLogic.AND_ALL -> secondaryMatches.all { it }
    }
  }

  private fun StCharacterBookEntry.resolvePromptPosition(): StWorldInfoPosition {
    return extensions().position?.toWorldInfoPosition()
      ?: if (position.equals("before_char", ignoreCase = true)) {
        StWorldInfoPosition.BEFORE
      } else {
        StWorldInfoPosition.AFTER
      }
  }

  private fun StCharacterBookEntry.extensions(): StCharacterBookEntryExtensions {
    return (extensions ?: JsonObject()).toCharacterBookEntryExtensions()
  }

  private fun StScanContext.toScanText(
    extensions: StCharacterBookEntryExtensions,
    defaultScanDepth: Int?,
  ): String {
    val scanDepth = (extensions.scanDepth ?: defaultScanDepth ?: ST_DEFAULT_WORLD_INFO_SCAN_DEPTH).coerceAtLeast(0)
    val recentChat =
      recentMessagesNewestFirst
        .take(scanDepth)
        .joinToString("\n")
    val selectedGlobalFields =
      buildList {
          if (extensions.matchPersonaDescription) add(personaDescription)
          if (extensions.matchCharacterDescription) add(characterDescription)
          if (extensions.matchCharacterPersonality) add(characterPersonality)
          if (extensions.matchCharacterDepthPrompt) add(characterDepthPrompt)
          if (extensions.matchScenario) add(scenario)
          if (extensions.matchCreatorNotes) add(creatorNotes)
        }
        .filter(String::isNotBlank)
    val appContext = buildList {
      sessionSummary.takeIf(String::isNotBlank)?.let(::add)
      addAll(memories)
    }

    return buildList {
        recentChat.takeIf(String::isNotBlank)?.let(::add)
        addAll(selectedGlobalFields)
        addAll(appContext)
      }
      .joinToString("\n")
  }

  private fun String.matchesKeyword(keyword: String, extensions: StCharacterBookEntryExtensions): Boolean {
    if (isBlank() || keyword.isBlank()) {
      return false
    }

    val caseSensitive = extensions.caseSensitive ?: false
    val haystack = if (caseSensitive) this else lowercase()
    val needle = if (caseSensitive) keyword else keyword.lowercase()

    if (extensions.matchWholeWords == true) {
      val parts = needle.split(WHITESPACE_REGEX).filter(String::isNotBlank)
      if (parts.size > 1) {
        return haystack.contains(needle)
      }
      val regex = Regex("""(?:^|\W)(${Regex.escape(needle)})(?:$|\W)""")
      return regex.containsMatchIn(haystack)
    }

    return haystack.contains(needle)
  }

  private fun JsonObject?.toDepthPrompt(): DepthPromptInsertion? {
    val depthPrompt = this?.getAsJsonObject("depth_prompt") ?: return null
    val prompt = depthPrompt.get("prompt")?.takeIf { it.isJsonPrimitive }?.asString?.trim().orEmpty()
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

  private fun JsonObject.toCharacterBookEntryExtensions(): StCharacterBookEntryExtensions {
    return StCharacterBookEntryExtensions(
      position = get("position")?.takeIf { it.isJsonPrimitive }?.asInt,
      depth = get("depth")?.takeIf { it.isJsonPrimitive }?.asInt,
      role = get("role")?.takeIf { it.isJsonPrimitive }?.asInt,
      selectiveLogic =
        when (get("selectiveLogic")?.takeIf { it.isJsonPrimitive }?.asInt) {
          1 -> StSelectiveLogic.NOT_ALL
          2 -> StSelectiveLogic.NOT_ANY
          3 -> StSelectiveLogic.AND_ALL
          else -> StSelectiveLogic.AND_ANY
        },
      scanDepth = get("scan_depth")?.takeIf { it.isJsonPrimitive }?.asInt,
      caseSensitive = get("case_sensitive")?.takeIf { it.isJsonPrimitive }?.asBoolean,
      matchWholeWords = get("match_whole_words")?.takeIf { it.isJsonPrimitive }?.asBoolean,
      matchPersonaDescription = get("match_persona_description")?.takeIf { it.isJsonPrimitive }?.asBoolean ?: false,
      matchCharacterDescription =
        get("match_character_description")?.takeIf { it.isJsonPrimitive }?.asBoolean ?: false,
      matchCharacterPersonality =
        get("match_character_personality")?.takeIf { it.isJsonPrimitive }?.asBoolean ?: false,
      matchCharacterDepthPrompt =
        get("match_character_depth_prompt")?.takeIf { it.isJsonPrimitive }?.asBoolean ?: false,
      matchScenario = get("match_scenario")?.takeIf { it.isJsonPrimitive }?.asBoolean ?: false,
      matchCreatorNotes = get("match_creator_notes")?.takeIf { it.isJsonPrimitive }?.asBoolean ?: false,
    )
  }

  private fun DepthPromptInsertion.toPromptSection(): String {
    return buildString {
      appendLine("role=$role depth=$depth")
      append(prompt)
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

private data class StScanContext(
  val recentMessagesNewestFirst: List<String>,
  val personaDescription: String,
  val characterDescription: String,
  val characterPersonality: String,
  val characterDepthPrompt: String,
  val scenario: String,
  val creatorNotes: String,
  val sessionSummary: String,
  val memories: List<String>,
)

private data class ResolvedCharacterBook(
  val beforePrompt: String = "",
  val afterPrompt: String = "",
  val authorNoteBefore: List<String> = emptyList(),
  val authorNoteAfter: List<String> = emptyList(),
  val exampleBefore: List<String> = emptyList(),
  val exampleAfter: List<String> = emptyList(),
  val depthPrompts: List<DepthPromptInsertion> = emptyList(),
)

private data class DepthPromptInsertion(
  val prompt: String,
  val depth: Int,
  val role: String,
)

private data class StCharacterBookEntryExtensions(
  val position: Int? = null,
  val depth: Int? = null,
  val role: Int? = null,
  val selectiveLogic: StSelectiveLogic = StSelectiveLogic.AND_ANY,
  val scanDepth: Int? = null,
  val caseSensitive: Boolean? = null,
  val matchWholeWords: Boolean? = null,
  val matchPersonaDescription: Boolean = false,
  val matchCharacterDescription: Boolean = false,
  val matchCharacterPersonality: Boolean = false,
  val matchCharacterDepthPrompt: Boolean = false,
  val matchScenario: Boolean = false,
  val matchCreatorNotes: Boolean = false,
)

private enum class StSelectiveLogic {
  AND_ANY,
  NOT_ALL,
  NOT_ANY,
  AND_ALL,
}

private enum class StWorldInfoPosition {
  BEFORE,
  AFTER,
  AUTHOR_NOTE_BEFORE,
  AUTHOR_NOTE_AFTER,
  AT_DEPTH,
  EXAMPLE_BEFORE,
  EXAMPLE_AFTER,
  OUTLET,
}

private fun Int.toWorldInfoPosition(): StWorldInfoPosition {
  return when (this) {
    0 -> StWorldInfoPosition.BEFORE
    1 -> StWorldInfoPosition.AFTER
    2 -> StWorldInfoPosition.AUTHOR_NOTE_BEFORE
    3 -> StWorldInfoPosition.AUTHOR_NOTE_AFTER
    4 -> StWorldInfoPosition.AT_DEPTH
    5 -> StWorldInfoPosition.EXAMPLE_BEFORE
    6 -> StWorldInfoPosition.EXAMPLE_AFTER
    7 -> StWorldInfoPosition.OUTLET
    else -> StWorldInfoPosition.AFTER
  }
}
