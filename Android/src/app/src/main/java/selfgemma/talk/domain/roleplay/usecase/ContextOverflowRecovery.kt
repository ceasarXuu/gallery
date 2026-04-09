package selfgemma.talk.domain.roleplay.usecase

private const val ERROR_CODE_3 = "error code 3"

internal object ContextOverflowRecovery {
  const val MAX_OVERFLOW_RETRIES = 1

  fun shouldUseAggressiveModePreflight(report: PromptBudgetReport?): Boolean {
    return report != null && report.estimatedInputTokens > report.usableInputTokens && report.mode != PromptBudgetMode.AGGRESSIVE
  }

  fun isContextOverflow(message: String?): Boolean {
    val normalized = message.orEmpty().lowercase()
    if (normalized.isBlank()) {
      return false
    }
    return normalized.contains(ERROR_CODE_3) ||
      normalized.contains("input token") ||
      normalized.contains("tokens exceed") ||
      normalized.contains("token exceeds") ||
      normalized.contains("context window") ||
      (normalized.contains("token") && normalized.contains("limit")) ||
      (normalized.contains("input") && normalized.contains("exceed"))
  }
}
