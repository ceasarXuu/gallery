package selfgemma.talk.data.roleplay.mapper

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import selfgemma.talk.domain.roleplay.model.RoleCardCore
import selfgemma.talk.domain.roleplay.model.RoleInteropState
import selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile

object RoleplayInteropJsonCodec {
  private val gson: Gson = GsonBuilder().create()

  fun encodeRoleCardCore(value: RoleCardCore?): String? {
    return value?.let(gson::toJson)
  }

  fun decodeRoleCardCore(value: String?): RoleCardCore? {
    if (value.isNullOrBlank()) {
      return null
    }
    return gson.fromJson(value, RoleCardCore::class.java)
  }

  fun encodeRoleRuntimeProfile(value: RoleRuntimeProfile?): String? {
    return value?.let(gson::toJson)
  }

  fun decodeRoleRuntimeProfile(value: String?): RoleRuntimeProfile? {
    if (value.isNullOrBlank()) {
      return null
    }
    return gson.fromJson(value, RoleRuntimeProfile::class.java)
  }

  fun encodeRoleInteropState(value: RoleInteropState?): String? {
    return value?.let(gson::toJson)
  }

  fun decodeRoleInteropState(value: String?): RoleInteropState? {
    if (value.isNullOrBlank()) {
      return null
    }
    return gson.fromJson(value, RoleInteropState::class.java)
  }
}
