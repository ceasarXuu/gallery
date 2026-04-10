package selfgemma.talk.domain.roleplay.usecase

import java.util.UUID
import javax.inject.Inject
import kotlinx.coroutines.flow.first
import selfgemma.talk.data.DataStoreRepository
import selfgemma.talk.domain.roleplay.model.MessageKind
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.MessageStatus
import selfgemma.talk.domain.roleplay.model.SessionEvent
import selfgemma.talk.domain.roleplay.model.SessionEventType
import selfgemma.talk.domain.roleplay.model.SessionSummary
import selfgemma.talk.domain.roleplay.repository.ConversationRepository

private const val SUMMARY_RECENT_MESSAGE_COUNT = 8
private const val SUMMARY_PREVIOUS_SUMMARY_LENGTH = 320
private const val SUMMARY_MESSAGE_LINE_LENGTH = 180

class SummarizeSessionUseCase
@Inject
constructor(
  private val dataStoreRepository: DataStoreRepository,
  private val conversationRepository: ConversationRepository,
  private val tokenEstimator: TokenEstimator,
) {
  suspend operator fun invoke(sessionId: String) {
    val existingSummary = conversationRepository.getSummary(sessionId)
    val relevantMessages =
      conversationRepository.observeMessages(sessionId).first().filter { message ->
        message.kind == MessageKind.TEXT &&
          message.side != MessageSide.SYSTEM &&
          message.content.isNotBlank() &&
          (message.status == MessageStatus.COMPLETED || message.status == MessageStatus.INTERRUPTED)
      }

    if (relevantMessages.isEmpty()) {
      return
    }

    val recentMessages = relevantMessages.takeLast(SUMMARY_RECENT_MESSAGE_COUNT)
    val now = System.currentTimeMillis()
    val summaryText = buildSummary(existingSummary?.summaryText, recentMessages)
    val summary =
      SessionSummary(
        sessionId = sessionId,
        version = (existingSummary?.version ?: 0) + 1,
        coveredUntilSeq = recentMessages.maxOf { it.seq },
        summaryText = summaryText,
        tokenEstimate = tokenEstimator.estimate(summaryText),
        updatedAt = now,
      )

    conversationRepository.upsertSummary(summary)
    conversationRepository.appendEvent(
      SessionEvent(
        id = UUID.randomUUID().toString(),
        sessionId = sessionId,
        eventType = SessionEventType.SUMMARY_UPDATE,
        payloadJson =
          """{"version":${summary.version},"coveredUntilSeq":${summary.coveredUntilSeq}}""",
        createdAt = now,
      )
    )
  }

  private fun buildSummary(previousSummary: String?, recentMessages: List<selfgemma.talk.domain.roleplay.model.Message>): String {
    return buildString {
      if (!previousSummary.isNullOrBlank()) {
        appendLine("Earlier summary:")
        appendLine(previousSummary.toSummaryLine(SUMMARY_PREVIOUS_SUMMARY_LENGTH))
        appendLine()
      }

      appendLine("Recent developments:")
      recentMessages.forEach { message ->
        appendLine(
          "- ${message.side.toSpeakerLabel()}: ${message.content.toSummaryLine(SUMMARY_MESSAGE_LINE_LENGTH)}"
        )
      }
    }
      .trim()
  }

  private fun String.toSummaryLine(maxLength: Int): String {
    return trim().replace(WHITESPACE_REGEX, " ").take(maxLength)
  }

  private fun MessageSide.toSpeakerLabel(): String {
    val userName = dataStoreRepository.getStUserProfile().userName
    return when (this) {
      MessageSide.USER -> userName
      MessageSide.ASSISTANT -> "Assistant"
      MessageSide.SYSTEM -> "System"
    }
  }

  companion object {
    private val WHITESPACE_REGEX = Regex("\\s+")
  }
}
