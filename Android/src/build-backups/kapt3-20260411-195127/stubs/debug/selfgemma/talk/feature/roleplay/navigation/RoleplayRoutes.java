package selfgemma.talk.feature.roleplay.navigation;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0012\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lselfgemma/talk/feature/roleplay/navigation/RoleplayRoutes;", "", "<init>", "()V", "SESSIONS", "", "ROLE_CATALOG", "ROLE_EDITOR", "SETTINGS", "CHAT", "chat", "sessionId", "roleEditor", "roleId", "app_debug"})
public final class RoleplayRoutes {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SESSIONS = "roleplay_sessions";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ROLE_CATALOG = "roleplay_roles";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ROLE_EDITOR = "roleplay_role_editor?roleId={roleId}";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTINGS = "roleplay_settings";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHAT = "roleplay_chat/{sessionId}";
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.feature.roleplay.navigation.RoleplayRoutes INSTANCE = null;
    
    private RoleplayRoutes() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String chat(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String roleEditor(@org.jetbrains.annotations.Nullable()
    java.lang.String roleId) {
        return null;
    }
}