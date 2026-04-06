package selfgemma.talk.domain.roleplay.usecase

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import selfgemma.talk.domain.roleplay.model.MemoryCategory
import selfgemma.talk.domain.roleplay.model.MemoryItem
import selfgemma.talk.domain.roleplay.model.RoleCard
import selfgemma.talk.domain.roleplay.model.Session
import selfgemma.talk.domain.roleplay.repository.MemoryRepository

class ExtractMemoriesUseCaseTest {
  @Test
  fun addManualMemory_createsPinnedMemoryAndDeduplicatesByHash() =
    runBlocking {
      val memoryRepository = FakeMemoryRepository()
      val useCase = ExtractMemoriesUseCase(memoryRepository)
      val session = testSession()
      val role = testRole()

      val first =
        useCase.addManualMemory(
          session = session,
          role = role,
          content = "  We already promised to reach the observatory before dawn.  ",
          category = MemoryCategory.PLOT,
        )
      val second =
        useCase.addManualMemory(
          session = session,
          role = role,
          content = "We already promised to reach the observatory before dawn.",
          category = MemoryCategory.PLOT,
        )

      assertNotNull(first)
      assertNotNull(second)
      assertEquals(first?.id, second?.id)
      assertEquals(1, memoryRepository.memories.size)
      assertTrue(memoryRepository.memories.values.single().pinned)
      assertEquals(
        "We already promised to reach the observatory before dawn.",
        memoryRepository.memories.values.single().content,
      )
    }

  private fun testRole(): RoleCard {
    val now = System.currentTimeMillis()
    return RoleCard(
      id = "role-1",
      name = "Captain Astra",
      summary = "A disciplined starship captain.",
      systemPrompt = "Remain calm and strategic.",
      createdAt = now,
      updatedAt = now,
    )
  }

  private fun testSession(): Session {
    val now = System.currentTimeMillis()
    return Session(
      id = "session-1",
      roleId = "role-1",
      title = "Bridge Briefing",
      activeModelId = "gemma-3n",
      createdAt = now,
      updatedAt = now,
      lastMessageAt = now,
    )
  }
}

private class FakeMemoryRepository : MemoryRepository {
  val memories = linkedMapOf<String, MemoryItem>()

  override suspend fun listRoleMemories(roleId: String): List<MemoryItem> {
    return memories.values.filter { it.roleId == roleId && it.sessionId == null }
  }

  override suspend fun listSessionMemories(sessionId: String): List<MemoryItem> {
    return memories.values.filter { it.sessionId == sessionId }
  }

  override suspend fun upsert(memory: MemoryItem) {
    memories[memory.id] = memory
  }

  override suspend fun deactivate(memoryId: String) {
    val current = memories[memoryId] ?: return
    memories[memoryId] = current.copy(active = false)
  }

  override suspend fun markUsed(memoryIds: List<String>, usedAt: Long) {
    memoryIds.forEach { id ->
      val current = memories[id] ?: return@forEach
      memories[id] = current.copy(lastUsedAt = usedAt)
    }
  }

  override suspend fun searchRelevant(
    roleId: String,
    sessionId: String?,
    query: String,
    limit: Int,
  ): List<MemoryItem> {
    return memories.values.take(limit)
  }
}