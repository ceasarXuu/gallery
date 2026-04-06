package selfgemma.talk.domain.roleplay.usecase

import java.security.MessageDigest
import java.util.UUID
import javax.inject.Inject
import selfgemma.talk.domain.roleplay.model.MemoryCategory
import selfgemma.talk.domain.roleplay.model.MemoryItem
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.Session
import selfgemma.talk.domain.roleplay.repository.MemoryRepository

private const val MAX_AUTOMATIC_MEMORY_ITEMS = 3
private const val MAX_MEMORY_LENGTH = 180

class ExtractMemoriesUseCase @Inject constructor(private val memoryRepository: MemoryRepository) {
  suspend operator fun invoke(
    session: Session,
    role: RoleCard,
    userMessage: Message,
    assistantMessage: Message?,
  ) {
    if (!role.memoryEnabled || role.memoryMaxItems <= 0) {
      return
    }

    val existingByHash = loadExistingMemories(role.id, session.id)
    val candidates =
      buildList {
          addAll(extractFromUserMessage(userMessage.content))
          if (assistantMessage != null) {
            addAll(extractFromAssistantMessage(assistantMessage.content))
          }
        }
        .distinctBy { normalizeForHash(it.content) }
        .take(minOf(role.memoryMaxItems, MAX_AUTOMATIC_MEMORY_ITEMS))

    if (candidates.isEmpty()) {
      return
    }

    val sourceMessageIds = listOfNotNull(userMessage.id, assistantMessage?.id)
    val now = System.currentTimeMillis()

    candidates.forEach { candidate ->
      val memory =
        buildMemory(
          session = session,
          role = role,
          candidate = candidate,
          sourceMessageIds = sourceMessageIds,
          existing = existingByHash[hashContent(candidate.content)],
          pinned = null,
          now = now,
        )
      memoryRepository.upsert(memory)
    }
  }

  suspend fun pinMessage(session: Session, role: RoleCard, message: Message): MemoryItem? {
    if (message.content.isBlank()) {
      return null
    }

    val candidate =
      inferCandidate(message.content, message.side)
        ?: MemoryCandidate(
          category = if (message.side == MessageSide.USER) MemoryCategory.PREFERENCE else MemoryCategory.PLOT,
          content = sanitizeContent(message.content),
          confidence = 0.95f,
        )

    if (candidate.content.isBlank()) {
      return null
    }

    val existingByHash = loadExistingMemories(role.id, session.id)
    val now = System.currentTimeMillis()
    val memory =
      buildMemory(
        session = session,
        role = role,
        candidate = candidate,
        sourceMessageIds = listOf(message.id),
        existing = existingByHash[hashContent(candidate.content)],
        pinned = true,
        now = now,
      )
    memoryRepository.upsert(memory)
    return memory
  }

  suspend fun addManualMemory(
    session: Session,
    role: RoleCard,
    content: String,
    category: MemoryCategory,
  ): MemoryItem? {
    val sanitized = sanitizeContent(content)
    if (sanitized.length < 3) {
      return null
    }

    val existingByHash = loadExistingMemories(role.id, session.id)
    val now = System.currentTimeMillis()
    val memory =
      buildMemory(
        session = session,
        role = role,
        candidate = MemoryCandidate(category = category, content = sanitized, confidence = 1.0f),
        sourceMessageIds = emptyList(),
        existing = existingByHash[hashContent(sanitized)],
        pinned = true,
        now = now,
      )
    memoryRepository.upsert(memory)
    return memory
  }

  private suspend fun loadExistingMemories(roleId: String, sessionId: String): Map<String, MemoryItem> {
    return (memoryRepository.listRoleMemories(roleId) + memoryRepository.listSessionMemories(sessionId))
      .associateBy { it.normalizedHash }
  }

  private fun extractFromUserMessage(content: String): List<MemoryCandidate> {
    return splitIntoCandidates(content).mapNotNull { line -> inferCandidate(line, MessageSide.USER) }
  }

  private fun extractFromAssistantMessage(content: String): List<MemoryCandidate> {
    return splitIntoCandidates(content).mapNotNull { line -> inferCandidate(line, MessageSide.ASSISTANT) }
  }

  private fun inferCandidate(content: String, side: MessageSide): MemoryCandidate? {
    val sanitized = sanitizeContent(content)
    if (sanitized.length < 12) {
      return null
    }

    val normalized = sanitized.lowercase()

    val category =
      when {
        normalized.containsAny(PREFERENCE_PATTERNS) -> MemoryCategory.PREFERENCE
        normalized.containsAny(RELATION_PATTERNS) -> MemoryCategory.RELATION
        normalized.containsAny(PLOT_PATTERNS) -> MemoryCategory.PLOT
        normalized.containsAny(WORLD_PATTERNS) -> MemoryCategory.WORLD
        side == MessageSide.USER && normalized.startsWith("remember") -> MemoryCategory.TODO
        else -> null
      }
        ?: return null

    val confidence = if (side == MessageSide.USER) 0.78f else 0.62f
    return MemoryCandidate(category = category, content = sanitized, confidence = confidence)
  }

  private fun buildMemory(
    session: Session,
    role: RoleCard,
    candidate: MemoryCandidate,
    sourceMessageIds: List<String>,
    existing: MemoryItem?,
    pinned: Boolean?,
    now: Long,
  ): MemoryItem {
    val hash = hashContent(candidate.content)

    return MemoryItem(
      id = existing?.id ?: UUID.randomUUID().toString(),
      roleId = role.id,
      sessionId = session.id,
      category = existing?.category ?: candidate.category,
      content = candidate.content,
      normalizedHash = hash,
      confidence = maxOf(existing?.confidence ?: 0f, candidate.confidence),
      pinned = pinned ?: existing?.pinned ?: false,
      active = true,
      sourceMessageIds = (existing?.sourceMessageIds.orEmpty() + sourceMessageIds).distinct(),
      createdAt = existing?.createdAt ?: now,
      updatedAt = now,
      lastUsedAt = existing?.lastUsedAt,
    )
  }

  private fun splitIntoCandidates(content: String): List<String> {
    return content
      .split(SPLIT_REGEX)
      .map(::sanitizeContent)
      .filter { it.length in 12..MAX_MEMORY_LENGTH }
  }

  private fun sanitizeContent(content: String): String {
    return content.trim().replace(WHITESPACE_REGEX, " ").take(MAX_MEMORY_LENGTH)
  }

  private fun normalizeForHash(content: String): String {
    return sanitizeContent(content).lowercase()
  }

  private fun hashContent(content: String): String {
    val digest = MessageDigest.getInstance("SHA-256")
    return digest.digest(normalizeForHash(content).toByteArray()).joinToString(separator = "") { byte ->
      "%02x".format(byte)
    }
  }

  private fun String.containsAny(patterns: List<String>): Boolean {
    return patterns.any(::contains)
  }

  private data class MemoryCandidate(
    val category: MemoryCategory,
    val content: String,
    val confidence: Float,
  )

  companion object {
    private val WHITESPACE_REGEX = Regex("\\s+")
    private val SPLIT_REGEX = Regex("[\\n.!?]")
    private val PREFERENCE_PATTERNS =
      listOf("i like", "i love", "i enjoy", "i prefer", "my favorite", "i hate", "i dislike")
    private val RELATION_PATTERNS =
      listOf("we are", "we're", "you promised", "our bond", "our relationship", "trust me")
    private val PLOT_PATTERNS =
      listOf("we need to", "our mission", "the plan is", "remember that", "the goal is")
    private val WORLD_PATTERNS =
      listOf("my name is", "call me", "i live", "i work", "i study", "i am from", "i'm from")
  }
}