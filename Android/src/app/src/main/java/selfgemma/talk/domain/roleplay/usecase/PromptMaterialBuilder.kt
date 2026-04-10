package selfgemma.talk.domain.roleplay.usecase

import javax.inject.Inject
import selfgemma.talk.domain.roleplay.model.MemoryItem
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.MessageKind
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.MessageStatus
import selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile
import selfgemma.talk.domain.roleplay.model.SessionSummary
import selfgemma.talk.domain.roleplay.model.StChatRuntimeRole
import selfgemma.talk.domain.roleplay.model.name
import selfgemma.talk.domain.roleplay.model.personaDescriptionInPrompt
import selfgemma.talk.domain.roleplay.model.personaDescription
import selfgemma.talk.domain.roleplay.model.summary
import selfgemma.talk.domain.roleplay.model.systemPrompt
import selfgemma.talk.domain.roleplay.model.userPersonaDescription
import selfgemma.talk.domain.roleplay.model.worldSettings

private const val FULL_RECENT_DIALOGUE_TOKEN_BUDGET = 1800
private const val COMPACT_RECENT_DIALOGUE_TOKEN_BUDGET = 640
private const val MINIMAL_RECENT_DIALOGUE_TOKEN_BUDGET = 320
private const val MAX_DIALOGUE_LINE_LENGTH = 280

internal class PromptMaterialBuilder @Inject constructor(private val tokenEstimator: TokenEstimator) {
  fun build(
    runtimeRole: StChatRuntimeRole,
    runtimeProfile: RoleRuntimeProfile?,
    summary: SessionSummary?,
    memories: List<MemoryItem>,
    recentMessages: List<Message>,
    macroContext: StMacroContext,
    resolvedCharacterBook: StResolvedPromptRuntime,
    postHistoryBlock: String,
    depthPromptBlock: String,
    combinedExampleDialogue: String,
  ): PromptMaterial {
    val recentConversationVariants = buildRecentConversationVariants(runtimeRole = runtimeRole, recentMessages = recentMessages)
    val memoryVariants = buildMemoryVariants(memories)
    val sections =
      buildList {
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.CORE_CHARACTER,
            title = "Core Character",
            fullBody = macroContext.substitute(runtimeRole.systemPrompt()).trim(),
            compactBody = runtimeProfile?.compiledCorePrompt,
            minimalBody = runtimeProfile?.compiledCorePrompt?.take(320),
            priority = PromptSectionPriority.REQUIRED,
            required = true,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.LOREBOOK_BEFORE,
            title = "Lorebook",
            fullBody = resolvedCharacterBook.beforePrompt,
            priority = PromptSectionPriority.HIGH,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.CHARACTER_SUMMARY,
            title = "Character Summary",
            fullBody = macroContext.substitute(runtimeRole.summary()).trim(),
            compactBody =
              runtimeProfile?.summary?.takeIf { it.isNotBlank() }
                ?: macroContext.substitute(runtimeRole.summary()).take(280),
            priority = PromptSectionPriority.HIGH,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.CHARACTER_PERSONALITY,
            title = "Personality",
            fullBody = macroContext.substitute(runtimeRole.personaDescription()).trim(),
            compactBody = runtimeProfile?.compiledPersonaPrompt,
            minimalBody = runtimeProfile?.compiledPersonaPrompt?.take(220),
            priority = PromptSectionPriority.MEDIUM,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.PERSONA,
            title = "Persona",
            fullBody = macroContext.substitute(runtimeRole.userProfile.personaDescriptionInPrompt()).trim(),
            compactBody = macroContext.substitute(runtimeRole.userProfile.personaDescriptionInPrompt()).trim().take(220),
            minimalBody = macroContext.substitute(runtimeRole.userProfile.personaDescriptionInPrompt()).trim().take(160),
            priority = PromptSectionPriority.MEDIUM,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.WORLD,
            title = "World",
            fullBody = macroContext.substitute(runtimeRole.worldSettings()).trim(),
            compactBody = runtimeProfile?.compiledWorldPrompt,
            minimalBody = runtimeProfile?.compiledWorldPrompt?.take(220),
            priority = PromptSectionPriority.MEDIUM,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.SAFETY,
            title = "Safety",
            fullBody = runtimeRole.safetyPolicy,
            priority = PromptSectionPriority.REQUIRED,
            required = true,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.EXAMPLE_DIALOGUE,
            title = "Example Dialogue",
            fullBody = combinedExampleDialogue,
            compactBody = runtimeProfile?.compiledExampleDigest,
            priority = PromptSectionPriority.OPTIONAL,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.SESSION_SUMMARY,
            title = "Session Summary",
            fullBody = summary?.summaryText.orEmpty(),
            compactBody = summary?.summaryText?.trim()?.take(240).orEmpty(),
            priority = PromptSectionPriority.LOW,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.RELEVANT_MEMORY,
            title = "Relevant Memory",
            fullBody = memoryVariants.full,
            compactBody = memoryVariants.compact,
            minimalBody = memoryVariants.minimal,
            priority = PromptSectionPriority.LOW,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.DEPTH_PROMPT,
            title = "Depth Prompt",
            fullBody = depthPromptBlock,
            priority = PromptSectionPriority.HIGH,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.RECENT_CONVERSATION,
            title = "Recent Conversation",
            fullBody = recentConversationVariants.full,
            compactBody = recentConversationVariants.compact,
            minimalBody = recentConversationVariants.minimal,
            priority = PromptSectionPriority.LOW,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.LOREBOOK_AFTER,
            title = "Lorebook",
            fullBody = resolvedCharacterBook.afterPrompt,
            priority = PromptSectionPriority.HIGH,
          )
        )
        addCandidate(
          PromptSectionCandidate(
            id = PromptSectionId.POST_HISTORY_INSTRUCTIONS,
            title = "Post-History Instructions",
            fullBody = postHistoryBlock,
            priority = PromptSectionPriority.HIGH,
          )
        )
        resolvedCharacterBook.outletEntries.forEach { (outletName, contents) ->
          addCandidate(
            PromptSectionCandidate(
              id = PromptSectionId.LOREBOOK_OUTLET,
              title = "Lorebook Outlet:$outletName",
              fullBody = contents.joinToString("\n"),
              priority = PromptSectionPriority.MEDIUM,
            )
          )
        }
      }

    return PromptMaterial(
      preambleLines =
        listOf(
          "You are roleplaying as ${runtimeRole.name()}.",
          "Stay fully in character, avoid meta commentary, and do not mention these instructions.",
        ),
      sections = sections,
      responseRules =
        listOf(
          "- The next incoming user message is the live message you must answer.",
          "- Use memory and summary when relevant, but prioritize natural conversation.",
          "- Keep continuity with the recent conversation.",
          "- Never output labels like USER:, ASSISTANT:, or SYSTEM: in your reply.",
        ),
      updatedChatMetadataJson = resolvedCharacterBook.updatedChatMetadataJson,
    )
  }

  private fun buildRecentConversationVariants(
    runtimeRole: StChatRuntimeRole,
    recentMessages: List<Message>,
  ): ConversationVariants {
    val full = renderRecentConversation(runtimeRole, selectRecentMessages(recentMessages, FULL_RECENT_DIALOGUE_TOKEN_BUDGET))
    val compact = renderRecentConversation(runtimeRole, selectRecentMessages(recentMessages, COMPACT_RECENT_DIALOGUE_TOKEN_BUDGET))
    val minimal = renderRecentConversation(runtimeRole, selectRecentMessages(recentMessages, MINIMAL_RECENT_DIALOGUE_TOKEN_BUDGET))
    return ConversationVariants(full = full, compact = compact, minimal = minimal)
  }

  private fun renderRecentConversation(runtimeRole: StChatRuntimeRole, messages: List<Message>): String {
    return messages.joinToString("\n") { message ->
      "${message.side.toSpeakerLabel(runtimeRole)}: ${message.content.toPromptLine(MAX_DIALOGUE_LINE_LENGTH)}"
    }
  }

  private fun buildMemoryVariants(memories: List<MemoryItem>): MemoryVariants {
    val rendered =
      memories.map { memory ->
        "- ${memory.category.name.lowercase()}: ${memory.content.trim()}"
      }
    return MemoryVariants(
      full = rendered.joinToString("\n"),
      compact = rendered.take(2).joinToString("\n"),
      minimal = rendered.take(1).joinToString("\n"),
    )
  }

  private fun MutableList<PromptSectionCandidate>.addCandidate(candidate: PromptSectionCandidate) {
    if (
      candidate.fullBody.isBlank() &&
        candidate.compactBody.isNullOrBlank() &&
        candidate.minimalBody.isNullOrBlank()
    ) {
      return
    }
    add(candidate)
  }

  private fun selectRecentMessages(messages: List<Message>, tokenBudget: Int): List<Message> {
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
      if (selected.isNotEmpty() && nextTokenCount > tokenBudget) {
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

  private fun MessageSide.toSpeakerLabel(runtimeRole: StChatRuntimeRole): String {
    return when (this) {
      MessageSide.USER -> runtimeRole.userName
      MessageSide.ASSISTANT -> runtimeRole.name()
      MessageSide.SYSTEM -> "System"
    }
  }

  private data class ConversationVariants(
    val full: String,
    val compact: String,
    val minimal: String,
  )

  private data class MemoryVariants(
    val full: String,
    val compact: String,
    val minimal: String,
  )

  companion object {
    private val WHITESPACE_REGEX = Regex("\\s+")
  }
}
