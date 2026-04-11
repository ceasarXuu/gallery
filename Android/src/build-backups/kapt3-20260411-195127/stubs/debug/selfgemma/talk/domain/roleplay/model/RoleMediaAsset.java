package selfgemma.talk.domain.roleplay.model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u000bH\u00c6\u0003J\t\u00106\u001a\u00020\rH\u00c6\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010%J\u0010\u00108\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010%J\u0010\u00109\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\t\u0010:\u001a\u00020\u0012H\u00c6\u0003J\t\u0010;\u001a\u00020\u0012H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\u00a6\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010B\u001a\u00020\u000fH\u00d6\u0001J\t\u0010C\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010&\u001a\u0004\b\'\u0010%R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0011\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019\u00a8\u0006D"}, d2 = {"Lselfgemma/talk/domain/roleplay/model/RoleMediaAsset;", "", "id", "", "kind", "Lselfgemma/talk/domain/roleplay/model/RoleMediaKind;", "uri", "previewUri", "displayName", "mimeType", "source", "Lselfgemma/talk/domain/roleplay/model/RoleMediaSource;", "usage", "Lselfgemma/talk/domain/roleplay/model/RoleMediaUsage;", "width", "", "height", "fileSizeBytes", "", "createdAt", "updatedAt", "extraJson", "<init>", "(Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/RoleMediaKind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/RoleMediaSource;Lselfgemma/talk/domain/roleplay/model/RoleMediaUsage;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;JJLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getKind", "()Lselfgemma/talk/domain/roleplay/model/RoleMediaKind;", "getUri", "getPreviewUri", "getDisplayName", "getMimeType", "getSource", "()Lselfgemma/talk/domain/roleplay/model/RoleMediaSource;", "getUsage", "()Lselfgemma/talk/domain/roleplay/model/RoleMediaUsage;", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getFileSizeBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreatedAt", "()J", "getUpdatedAt", "getExtraJson", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/RoleMediaKind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/RoleMediaSource;Lselfgemma/talk/domain/roleplay/model/RoleMediaUsage;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;JJLjava/lang/String;)Lselfgemma/talk/domain/roleplay/model/RoleMediaAsset;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class RoleMediaAsset {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.RoleMediaKind kind = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String uri = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String previewUri = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String displayName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String mimeType = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.RoleMediaSource source = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.RoleMediaUsage usage = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer width = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer height = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long fileSizeBytes = null;
    private final long createdAt = 0L;
    private final long updatedAt = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String extraJson = null;
    
    public RoleMediaAsset(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleMediaKind kind, @org.jetbrains.annotations.NotNull()
    java.lang.String uri, @org.jetbrains.annotations.Nullable()
    java.lang.String previewUri, @org.jetbrains.annotations.Nullable()
    java.lang.String displayName, @org.jetbrains.annotations.Nullable()
    java.lang.String mimeType, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleMediaSource source, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleMediaUsage usage, @org.jetbrains.annotations.Nullable()
    java.lang.Integer width, @org.jetbrains.annotations.Nullable()
    java.lang.Integer height, @org.jetbrains.annotations.Nullable()
    java.lang.Long fileSizeBytes, long createdAt, long updatedAt, @org.jetbrains.annotations.NotNull()
    java.lang.String extraJson) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RoleMediaKind getKind() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUri() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPreviewUri() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMimeType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RoleMediaSource getSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RoleMediaUsage getUsage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getWidth() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getHeight() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getFileSizeBytes() {
        return null;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExtraJson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component11() {
        return null;
    }
    
    public final long component12() {
        return 0L;
    }
    
    public final long component13() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RoleMediaKind component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RoleMediaSource component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RoleMediaUsage component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RoleMediaAsset copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleMediaKind kind, @org.jetbrains.annotations.NotNull()
    java.lang.String uri, @org.jetbrains.annotations.Nullable()
    java.lang.String previewUri, @org.jetbrains.annotations.Nullable()
    java.lang.String displayName, @org.jetbrains.annotations.Nullable()
    java.lang.String mimeType, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleMediaSource source, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleMediaUsage usage, @org.jetbrains.annotations.Nullable()
    java.lang.Integer width, @org.jetbrains.annotations.Nullable()
    java.lang.Integer height, @org.jetbrains.annotations.Nullable()
    java.lang.Long fileSizeBytes, long createdAt, long updatedAt, @org.jetbrains.annotations.NotNull()
    java.lang.String extraJson) {
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