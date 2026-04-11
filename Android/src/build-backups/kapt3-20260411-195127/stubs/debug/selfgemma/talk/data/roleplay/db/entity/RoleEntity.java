package selfgemma.talk.data.roleplay.db.entity;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\bK\b\u0087\b\u0018\u00002\u00020\u0001B\u00b5\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0014\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0016\u0012\b\b\u0002\u0010 \u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\"\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\t\u0010P\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u00c6\u0003J\t\u0010U\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0002\u00105J\u0010\u0010X\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0002\u00105J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003\u00a2\u0006\u0002\u00109J\t\u0010Z\u001a\u00020\u0016H\u00c6\u0003J\t\u0010[\u001a\u00020\u0014H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0016H\u00c6\u0003J\t\u0010]\u001a\u00020\u0014H\u00c6\u0003J\u000f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u00c6\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010c\u001a\u00020\u0016H\u00c6\u0003J\t\u0010d\u001a\u00020\u0016H\u00c6\u0003J\t\u0010e\u001a\u00020\"H\u00c6\u0003J\t\u0010f\u001a\u00020\"H\u00c6\u0003J\u00c6\u0002\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00142\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"H\u00c6\u0001\u00a2\u0006\u0002\u0010hJ\u0013\u0010i\u001a\u00020\u00162\b\u0010j\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010k\u001a\u00020\u0014H\u00d6\u0001J\t\u0010l\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\'R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\'R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\'R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\'R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\'R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\'R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\'R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\'R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\n\n\u0002\u00106\u001a\u0004\b7\u00105R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010<R\u0011\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010>R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u00101R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010\'R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010\'R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010\'R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010\'R\u0011\u0010\u001f\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010<R\u0011\u0010 \u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010<R\u0011\u0010!\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010#\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010I\u00a8\u0006m"}, d2 = {"Lselfgemma/talk/data/roleplay/db/entity/RoleEntity;", "", "id", "", "name", "avatarUri", "coverUri", "summary", "systemPrompt", "personaDescription", "worldSettings", "openingLine", "exampleDialogues", "", "safetyPolicy", "defaultModelId", "defaultTemperature", "", "defaultTopP", "defaultTopK", "", "enableThinking", "", "summaryTurnThreshold", "memoryEnabled", "memoryMaxItems", "tags", "cardCoreJson", "runtimeProfileJson", "mediaProfileJson", "interopStateJson", "builtIn", "archived", "createdAt", "", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;ZIZILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJJ)V", "getId", "()Ljava/lang/String;", "getName", "getAvatarUri", "getCoverUri", "getSummary", "getSystemPrompt", "getPersonaDescription", "getWorldSettings", "getOpeningLine", "getExampleDialogues", "()Ljava/util/List;", "getSafetyPolicy", "getDefaultModelId", "getDefaultTemperature", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getDefaultTopP", "getDefaultTopK", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableThinking", "()Z", "getSummaryTurnThreshold", "()I", "getMemoryEnabled", "getMemoryMaxItems", "getTags", "getCardCoreJson", "getRuntimeProfileJson", "getMediaProfileJson", "getInteropStateJson", "getBuiltIn", "getArchived", "getCreatedAt", "()J", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;ZIZILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJJ)Lselfgemma/talk/data/roleplay/db/entity/RoleEntity;", "equals", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "roles", indices = {@androidx.room.Index(value = {"name"}), @androidx.room.Index(value = {"builtIn"}), @androidx.room.Index(value = {"archived"}), @androidx.room.Index(value = {"updatedAt"})})
public final class RoleEntity {
    @androidx.room.PrimaryKey()
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String avatarUri = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String coverUri = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String summary = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String systemPrompt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String personaDescription = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String worldSettings = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String openingLine = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> exampleDialogues = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String safetyPolicy = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String defaultModelId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float defaultTemperature = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float defaultTopP = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer defaultTopK = null;
    private final boolean enableThinking = false;
    private final int summaryTurnThreshold = 0;
    private final boolean memoryEnabled = false;
    private final int memoryMaxItems = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> tags = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String cardCoreJson = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String runtimeProfileJson = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String mediaProfileJson = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String interopStateJson = null;
    private final boolean builtIn = false;
    private final boolean archived = false;
    private final long createdAt = 0L;
    private final long updatedAt = 0L;
    
    public RoleEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarUri, @org.jetbrains.annotations.Nullable()
    java.lang.String coverUri, @org.jetbrains.annotations.NotNull()
    java.lang.String summary, @org.jetbrains.annotations.NotNull()
    java.lang.String systemPrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String personaDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String worldSettings, @org.jetbrains.annotations.NotNull()
    java.lang.String openingLine, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> exampleDialogues, @org.jetbrains.annotations.NotNull()
    java.lang.String safetyPolicy, @org.jetbrains.annotations.Nullable()
    java.lang.String defaultModelId, @org.jetbrains.annotations.Nullable()
    java.lang.Float defaultTemperature, @org.jetbrains.annotations.Nullable()
    java.lang.Float defaultTopP, @org.jetbrains.annotations.Nullable()
    java.lang.Integer defaultTopK, boolean enableThinking, int summaryTurnThreshold, boolean memoryEnabled, int memoryMaxItems, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.Nullable()
    java.lang.String cardCoreJson, @org.jetbrains.annotations.Nullable()
    java.lang.String runtimeProfileJson, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaProfileJson, @org.jetbrains.annotations.Nullable()
    java.lang.String interopStateJson, boolean builtIn, boolean archived, long createdAt, long updatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAvatarUri() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCoverUri() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSummary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSystemPrompt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPersonaDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWorldSettings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOpeningLine() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getExampleDialogues() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSafetyPolicy() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDefaultModelId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getDefaultTemperature() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getDefaultTopP() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getDefaultTopK() {
        return null;
    }
    
    public final boolean getEnableThinking() {
        return false;
    }
    
    public final int getSummaryTurnThreshold() {
        return 0;
    }
    
    public final boolean getMemoryEnabled() {
        return false;
    }
    
    public final int getMemoryMaxItems() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTags() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCardCoreJson() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRuntimeProfileJson() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMediaProfileJson() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getInteropStateJson() {
        return null;
    }
    
    public final boolean getBuiltIn() {
        return false;
    }
    
    public final boolean getArchived() {
        return false;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component15() {
        return null;
    }
    
    public final boolean component16() {
        return false;
    }
    
    public final int component17() {
        return 0;
    }
    
    public final boolean component18() {
        return false;
    }
    
    public final int component19() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component24() {
        return null;
    }
    
    public final boolean component25() {
        return false;
    }
    
    public final boolean component26() {
        return false;
    }
    
    public final long component27() {
        return 0L;
    }
    
    public final long component28() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.roleplay.db.entity.RoleEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarUri, @org.jetbrains.annotations.Nullable()
    java.lang.String coverUri, @org.jetbrains.annotations.NotNull()
    java.lang.String summary, @org.jetbrains.annotations.NotNull()
    java.lang.String systemPrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String personaDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String worldSettings, @org.jetbrains.annotations.NotNull()
    java.lang.String openingLine, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> exampleDialogues, @org.jetbrains.annotations.NotNull()
    java.lang.String safetyPolicy, @org.jetbrains.annotations.Nullable()
    java.lang.String defaultModelId, @org.jetbrains.annotations.Nullable()
    java.lang.Float defaultTemperature, @org.jetbrains.annotations.Nullable()
    java.lang.Float defaultTopP, @org.jetbrains.annotations.Nullable()
    java.lang.Integer defaultTopK, boolean enableThinking, int summaryTurnThreshold, boolean memoryEnabled, int memoryMaxItems, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.Nullable()
    java.lang.String cardCoreJson, @org.jetbrains.annotations.Nullable()
    java.lang.String runtimeProfileJson, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaProfileJson, @org.jetbrains.annotations.Nullable()
    java.lang.String interopStateJson, boolean builtIn, boolean archived, long createdAt, long updatedAt) {
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