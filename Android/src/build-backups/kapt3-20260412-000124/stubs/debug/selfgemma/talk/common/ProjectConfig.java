package selfgemma.talk.common;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lselfgemma/talk/common/ProjectConfig;", "", "<init>", "()V", "clientId", "", "redirectUri", "authEndpoint", "tokenEndpoint", "authServiceConfig", "Lnet/openid/appauth/AuthorizationServiceConfiguration;", "getAuthServiceConfig", "()Lnet/openid/appauth/AuthorizationServiceConfiguration;", "app_debug"})
public final class ProjectConfig {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String clientId = "REPLACE_WITH_YOUR_CLIENT_ID_IN_HUGGINGFACE_APP";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String redirectUri = "REPLACE_WITH_YOUR_REDIRECT_URI_IN_HUGGINGFACE_APP";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String authEndpoint = "https://huggingface.co/oauth/authorize";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String tokenEndpoint = "https://huggingface.co/oauth/token";
    @org.jetbrains.annotations.NotNull()
    private static final net.openid.appauth.AuthorizationServiceConfiguration authServiceConfig = null;
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.common.ProjectConfig INSTANCE = null;
    
    private ProjectConfig() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.openid.appauth.AuthorizationServiceConfiguration getAuthServiceConfig() {
        return null;
    }
}