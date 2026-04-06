package selfgemma.talk.feature.roleplay.navigation

object RoleplayRoutes {
  const val SESSIONS = "roleplay_sessions"
  const val ROLE_CATALOG = "roleplay_roles"
  const val ROLE_EDITOR = "roleplay_role_editor?roleId={roleId}"
  const val SETTINGS = "roleplay_settings"
  const val CHAT = "roleplay_chat/{sessionId}"

  fun chat(sessionId: String): String {
    return "roleplay_chat/$sessionId"
  }

  fun roleEditor(roleId: String? = null): String {
    return if (roleId.isNullOrBlank()) {
      "roleplay_role_editor"
    } else {
      "roleplay_role_editor?roleId=$roleId"
    }
  }
}