package selfgemma.talk.domain.roleplay.model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0006H\u00c6\u0003J\t\u0010*\u001a\u00020\bH\u00c6\u0003J\t\u0010+\u001a\u00020\bH\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0011H\u00c6\u0003J\t\u00101\u001a\u00020\u0011H\u00c6\u0003J\t\u00102\u001a\u00020\u0011H\u00c6\u0003J\u008b\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011H\u00c6\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00107\u001a\u00020\bH\u00d6\u0001J\t\u00108\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010$\u00a8\u00069"}, d2 = {"Lselfgemma/talk/domain/roleplay/model/StPersonaDescriptor;", "", "description", "", "title", "position", "Lselfgemma/talk/domain/roleplay/model/StPersonaDescriptionPosition;", "depth", "", "role", "lorebook", "connections", "", "Lselfgemma/talk/domain/roleplay/model/StPersonaConnection;", "avatarUri", "avatarEditorSourceUri", "avatarCropZoom", "", "avatarCropOffsetX", "avatarCropOffsetY", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/StPersonaDescriptionPosition;IILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;FFF)V", "getDescription", "()Ljava/lang/String;", "getTitle", "getPosition", "()Lselfgemma/talk/domain/roleplay/model/StPersonaDescriptionPosition;", "getDepth", "()I", "getRole", "getLorebook", "getConnections", "()Ljava/util/List;", "getAvatarUri", "getAvatarEditorSourceUri", "getAvatarCropZoom", "()F", "getAvatarCropOffsetX", "getAvatarCropOffsetY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class StPersonaDescriptor {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition position = null;
    private final int depth = 0;
    private final int role = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String lorebook = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.domain.roleplay.model.StPersonaConnection> connections = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String avatarUri = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String avatarEditorSourceUri = null;
    private final float avatarCropZoom = 0.0F;
    private final float avatarCropOffsetX = 0.0F;
    private final float avatarCropOffsetY = 0.0F;
    
    public StPersonaDescriptor(@org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition position, int depth, int role, @org.jetbrains.annotations.NotNull()
    java.lang.String lorebook, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.StPersonaConnection> connections, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarUri, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarEditorSourceUri, float avatarCropZoom, float avatarCropOffsetX, float avatarCropOffsetY) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition getPosition() {
        return null;
    }
    
    public final int getDepth() {
        return 0;
    }
    
    public final int getRole() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLorebook() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.domain.roleplay.model.StPersonaConnection> getConnections() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAvatarUri() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAvatarEditorSourceUri() {
        return null;
    }
    
    public final float getAvatarCropZoom() {
        return 0.0F;
    }
    
    public final float getAvatarCropOffsetX() {
        return 0.0F;
    }
    
    public final float getAvatarCropOffsetY() {
        return 0.0F;
    }
    
    public StPersonaDescriptor() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final float component10() {
        return 0.0F;
    }
    
    public final float component11() {
        return 0.0F;
    }
    
    public final float component12() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.domain.roleplay.model.StPersonaConnection> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StPersonaDescriptor copy(@org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition position, int depth, int role, @org.jetbrains.annotations.NotNull()
    java.lang.String lorebook, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.StPersonaConnection> connections, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarUri, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarEditorSourceUri, float avatarCropZoom, float avatarCropOffsetX, float avatarCropOffsetY) {
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