package selfgemma.talk.domain.roleplay.usecase

import javax.inject.Inject
import selfgemma.talk.domain.roleplay.model.ModelContextProfile

class ContextBudgetPlanner @Inject constructor(private val tokenEstimator: TokenEstimator) {
  internal fun plan(material: PromptMaterial, contextProfile: ModelContextProfile? = null): BudgetedPromptPlan {
    val states = MutableList(material.sections.size) { PromptSectionLevel.FULL }
    val usableInputTokens = contextProfile?.usableInputTokens ?: Int.MAX_VALUE
    var rendered = render(material = material, states = states)

    if (rendered.estimatedInputTokens <= usableInputTokens) {
      return rendered.toPlan(usableInputTokens = usableInputTokens, mode = PromptBudgetMode.FULL)
    }

    while (rendered.estimatedInputTokens > usableInputTokens) {
      val changed = degradeOnce(material = material, states = states)
      if (!changed) {
        break
      }
      rendered = render(material = material, states = states)
    }

    val mode =
      when {
        states.any { it == PromptSectionLevel.DROPPED || it == PromptSectionLevel.MINIMAL } ->
          PromptBudgetMode.AGGRESSIVE
        states.any { it == PromptSectionLevel.COMPACT } -> PromptBudgetMode.COMPACT
        else -> PromptBudgetMode.FULL
      }
    return rendered.toPlan(usableInputTokens = usableInputTokens, mode = mode)
  }

  private fun degradeOnce(material: PromptMaterial, states: MutableList<PromptSectionLevel>): Boolean {
    val degradationOrder =
      listOf(
        PromptSectionId.EXAMPLE_DIALOGUE,
        PromptSectionId.SESSION_SUMMARY,
        PromptSectionId.RELEVANT_MEMORY,
        PromptSectionId.RECENT_CONVERSATION,
        PromptSectionId.PERSONA,
        PromptSectionId.WORLD,
        PromptSectionId.CHARACTER_SUMMARY,
        PromptSectionId.CORE_CHARACTER,
      )

    degradationOrder.forEach { sectionId ->
      val index = material.sections.indexOfFirst { it.id == sectionId }
      if (index != -1 && advanceSectionLevel(candidate = material.sections[index], states = states, index = index)) {
        return true
      }
    }

    for (index in material.sections.indices.reversed()) {
      if (advanceSectionLevel(candidate = material.sections[index], states = states, index = index)) {
        return true
      }
    }
    return false
  }

  private fun advanceSectionLevel(
    candidate: PromptSectionCandidate,
    states: MutableList<PromptSectionLevel>,
    index: Int,
  ): Boolean {
    val current = states[index]
    val next =
      when (current) {
        PromptSectionLevel.FULL ->
          when {
            candidate.compactBody.hasContent() && candidate.compactBody.normalized() != candidate.fullBody.normalized() ->
              PromptSectionLevel.COMPACT
            candidate.minimalBody.hasContent() && candidate.minimalBody.normalized() != candidate.fullBody.normalized() ->
              PromptSectionLevel.MINIMAL
            !candidate.required -> PromptSectionLevel.DROPPED
            else -> null
          }
        PromptSectionLevel.COMPACT ->
          when {
            candidate.minimalBody.hasContent() &&
              candidate.minimalBody.normalized() != resolveBody(candidate, PromptSectionLevel.COMPACT).normalized() ->
              PromptSectionLevel.MINIMAL
            !candidate.required -> PromptSectionLevel.DROPPED
            else -> null
          }
        PromptSectionLevel.MINIMAL -> if (!candidate.required) PromptSectionLevel.DROPPED else null
        PromptSectionLevel.DROPPED -> null
      }

    if (next == null) {
      return false
    }
    states[index] = next
    return true
  }

  private fun render(material: PromptMaterial, states: List<PromptSectionLevel>): RenderedPrompt {
    val sections =
      buildList {
        material.sections.forEachIndexed { index, section ->
          val body = resolveBody(section, states[index]).trim()
          if (body.isBlank() || states[index] == PromptSectionLevel.DROPPED) {
            return@forEachIndexed
          }
          add(
            PlannedPromptSection(
              id = section.id,
              title = section.title,
              body = body,
              level = states[index],
            )
          )
        }
      }
    val prompt =
      buildString {
        material.preambleLines.forEach(::appendLine)
        if (material.preambleLines.isNotEmpty()) {
          appendLine()
        }
        sections.forEach { section ->
          appendLine("[${section.title}]")
          appendLine(section.body)
          appendLine()
        }
        appendLine("[Response Rules]")
        material.responseRules.forEach(::appendLine)
      }
        .trim()
    return RenderedPrompt(
      prompt = prompt,
      sections = sections,
      estimatedInputTokens = tokenEstimator.estimate(prompt),
    )
  }

  private fun resolveBody(candidate: PromptSectionCandidate, level: PromptSectionLevel): String {
    return when (level) {
      PromptSectionLevel.FULL -> candidate.fullBody
      PromptSectionLevel.COMPACT -> candidate.compactBody.takeUnless { it.isNullOrBlank() } ?: candidate.fullBody
      PromptSectionLevel.MINIMAL ->
        candidate.minimalBody.takeUnless { it.isNullOrBlank() }
          ?: candidate.compactBody.takeUnless { it.isNullOrBlank() }
          ?: candidate.fullBody
      PromptSectionLevel.DROPPED -> ""
    }
  }

  private fun RenderedPrompt.toPlan(
    usableInputTokens: Int,
    mode: PromptBudgetMode,
  ): BudgetedPromptPlan {
    val droppedSectionIds =
      PromptSectionId.entries
        .filter { sectionId -> sections.none { it.id == sectionId } }
        .map { it.name }
    val compactedSectionIds =
      sections
        .filter { it.level != PromptSectionLevel.FULL }
        .map { it.id.name }
    return BudgetedPromptPlan(
      prompt = prompt,
      sections = sections,
      mode = mode,
      estimatedInputTokens = estimatedInputTokens,
      report =
        PromptBudgetReport(
          usableInputTokens = usableInputTokens,
          estimatedInputTokens = estimatedInputTokens,
          mode = mode,
          droppedSectionIds = droppedSectionIds,
          compactedSectionIds = compactedSectionIds,
        ),
    )
  }

  private fun String?.hasContent(): Boolean = !this.isNullOrBlank()

  private fun String?.normalized(): String = this.orEmpty().trim()

  private data class RenderedPrompt(
    val prompt: String,
    val sections: List<PlannedPromptSection>,
    val estimatedInputTokens: Int,
  )
}
