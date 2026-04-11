package selfgemma.talk.domain.roleplay.model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010%\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010\'\u001a\u00020\u0000JX\u0010(\u001a\u00020\u00002\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020\u001c2\b\b\u0002\u0010.\u001a\u00020\u001c2\b\b\u0002\u0010/\u001a\u00020\u00032\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006H\u00c6\u0003J\u0015\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0006H\u00c6\u0003JK\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0006H\u00c6\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00109\u001a\u00020\u001cH\u00d6\u0001J\t\u0010:\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0017\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0011\u0010!\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\fR\u0013\u0010#\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\f\u00a8\u0006;"}, d2 = {"Lselfgemma/talk/domain/roleplay/model/StUserProfile;", "", "userAvatarId", "", "defaultPersonaId", "personas", "", "personaDescriptions", "Lselfgemma/talk/domain/roleplay/model/StPersonaDescriptor;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getUserAvatarId", "()Ljava/lang/String;", "getDefaultPersonaId", "getPersonas", "()Ljava/util/Map;", "getPersonaDescriptions", "userName", "getUserName", "personaDescription", "getPersonaDescription", "personaTitle", "getPersonaTitle", "personaDescriptionPosition", "Lselfgemma/talk/domain/roleplay/model/StPersonaDescriptionPosition;", "getPersonaDescriptionPosition", "()Lselfgemma/talk/domain/roleplay/model/StPersonaDescriptionPosition;", "personaDescriptionDepth", "", "getPersonaDescriptionDepth", "()I", "personaDescriptionRole", "getPersonaDescriptionRole", "personaDescriptionLorebook", "getPersonaDescriptionLorebook", "activeAvatarUri", "getActiveAvatarUri", "activePersonaDescriptor", "resolvedUserAvatarId", "ensureDefaults", "withActivePersona", "name", "title", "description", "position", "depth", "role", "lorebook", "avatarUri", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class StUserProfile {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userAvatarId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String defaultPersonaId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> personas = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, selfgemma.talk.domain.roleplay.model.StPersonaDescriptor> personaDescriptions = null;
    
    public StUserProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String userAvatarId, @org.jetbrains.annotations.Nullable()
    java.lang.String defaultPersonaId, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> personas, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, selfgemma.talk.domain.roleplay.model.StPersonaDescriptor> personaDescriptions) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserAvatarId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDefaultPersonaId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> getPersonas() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, selfgemma.talk.domain.roleplay.model.StPersonaDescriptor> getPersonaDescriptions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPersonaDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPersonaTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition getPersonaDescriptionPosition() {
        return null;
    }
    
    public final int getPersonaDescriptionDepth() {
        return 0;
    }
    
    public final int getPersonaDescriptionRole() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPersonaDescriptionLorebook() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getActiveAvatarUri() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StPersonaDescriptor activePersonaDescriptor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String resolvedUserAvatarId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StUserProfile ensureDefaults() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StUserProfile withActivePersona(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition position, int depth, int role, @org.jetbrains.annotations.NotNull()
    java.lang.String lorebook, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarUri) {
        return null;
    }
    
    public StUserProfile() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, selfgemma.talk.domain.roleplay.model.StPersonaDescriptor> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StUserProfile copy(@org.jetbrains.annotations.NotNull()
    java.lang.String userAvatarId, @org.jetbrains.annotations.Nullable()
    java.lang.String defaultPersonaId, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> personas, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, selfgemma.talk.domain.roleplay.model.StPersonaDescriptor> personaDescriptions) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}