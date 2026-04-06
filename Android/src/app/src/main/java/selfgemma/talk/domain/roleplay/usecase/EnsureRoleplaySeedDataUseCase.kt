package selfgemma.talk.domain.roleplay.usecase

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import selfgemma.talk.domain.roleplay.model.RoleplaySeedData
import selfgemma.talk.domain.roleplay.repository.RoleRepository

@Singleton
class EnsureRoleplaySeedDataUseCase @Inject constructor(private val roleRepository: RoleRepository) {
  private val mutex = Mutex()

  suspend operator fun invoke(defaultModelId: String? = null) {
    mutex.withLock {
      val existingRoles = roleRepository.observeRoles().first()
      if (existingRoles.isNotEmpty()) {
        return
      }

      val now = System.currentTimeMillis()
      RoleplaySeedData.defaultRoles(now = now, defaultModelId = defaultModelId).forEach {
        roleRepository.saveRole(it)
      }
    }
  }
}