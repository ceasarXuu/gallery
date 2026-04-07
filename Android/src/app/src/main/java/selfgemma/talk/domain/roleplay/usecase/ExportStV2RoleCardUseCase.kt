package selfgemma.talk.domain.roleplay.usecase

import javax.inject.Inject
import selfgemma.talk.data.roleplay.interop.stcard.StRoleCardInteropMapper
import selfgemma.talk.data.roleplay.interop.stcard.StV2CardSerializer
import selfgemma.talk.domain.roleplay.model.RoleCard

class ExportStV2RoleCardUseCase @Inject constructor() {
  private val serializer = StV2CardSerializer()

  fun exportToJson(role: RoleCard): String {
    val core = StRoleCardInteropMapper.roleCardToExportCore(role)
    return serializer.serialize(core)
  }
}
