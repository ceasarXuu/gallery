package selfgemma.talk.domain.roleplay.model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\bH\b\u0086\b\u0018\u00002\u00020\u0001B\u00d9\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 B\u00b7\u0002\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00030(\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030(\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010+J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\t\u0010W\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u00105J\u0010\u0010]\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u00105J\u0010\u0010^\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u00109J\t\u0010_\u001a\u00020\u0010H\u00c6\u0003J\t\u0010`\u001a\u00020\u000eH\u00c6\u0003J\t\u0010a\u001a\u00020\u0010H\u00c6\u0003J\t\u0010b\u001a\u00020\u000eH\u00c6\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0019H\u00c6\u0003J\t\u0010f\u001a\u00020\u0010H\u00c6\u0003J\t\u0010g\u001a\u00020\u0010H\u00c6\u0003J\t\u0010h\u001a\u00020\u001dH\u00c6\u0003J\t\u0010i\u001a\u00020\u001dH\u00c6\u0003J\u00e8\u0001\u0010j\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u00c6\u0001\u00a2\u0006\u0002\u0010kJ\u0013\u0010l\u001a\u00020\u00102\b\u0010m\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010n\u001a\u00020\u000eH\u00d6\u0001J\t\u0010o\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010-R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010-R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u00106\u001a\u0004\b7\u00105R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010<R\u0011\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010>R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010\u001a\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010<R\u0011\u0010\u001b\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010<R\u0011\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010JR\u0011\u0010!\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bL\u0010-R\u0011\u0010\"\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bM\u0010-R\u0011\u0010#\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bN\u0010-R\u0011\u0010$\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bO\u0010-R\u0011\u0010%\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bP\u0010-R\u0011\u0010&\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bQ\u0010-R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00030(8F\u00a2\u0006\u0006\u001a\u0004\bR\u0010SR\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030(8F\u00a2\u0006\u0006\u001a\u0004\bT\u0010SR\u0011\u0010*\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\bU\u0010/\u00a8\u0006p"}, d2 = {"Lselfgemma/talk/domain/roleplay/model/RoleCard;", "", "id", "", "stCard", "Lselfgemma/talk/domain/roleplay/model/StCharacterCard;", "avatarUri", "coverUri", "safetyPolicy", "defaultModelId", "defaultTemperature", "", "defaultTopP", "defaultTopK", "", "enableThinking", "", "summaryTurnThreshold", "memoryEnabled", "memoryMaxItems", "runtimeProfile", "Lselfgemma/talk/domain/roleplay/model/RoleRuntimeProfile;", "mediaProfile", "Lselfgemma/talk/domain/roleplay/model/RoleMediaProfile;", "interopState", "Lselfgemma/talk/domain/roleplay/model/RoleInteropState;", "builtIn", "archived", "createdAt", "", "updatedAt", "<init>", "(Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/StCharacterCard;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;ZIZILselfgemma/talk/domain/roleplay/model/RoleRuntimeProfile;Lselfgemma/talk/domain/roleplay/model/RoleMediaProfile;Lselfgemma/talk/domain/roleplay/model/RoleInteropState;ZZJJ)V", "name", "summary", "systemPrompt", "personaDescription", "worldSettings", "openingLine", "exampleDialogues", "", "tags", "cardCore", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;ZIZILjava/util/List;Lselfgemma/talk/domain/roleplay/model/StCharacterCard;Lselfgemma/talk/domain/roleplay/model/RoleRuntimeProfile;Lselfgemma/talk/domain/roleplay/model/RoleMediaProfile;Lselfgemma/talk/domain/roleplay/model/RoleInteropState;ZZJJ)V", "getId", "()Ljava/lang/String;", "getStCard", "()Lselfgemma/talk/domain/roleplay/model/StCharacterCard;", "getAvatarUri", "getCoverUri", "getSafetyPolicy", "getDefaultModelId", "getDefaultTemperature", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getDefaultTopP", "getDefaultTopK", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableThinking", "()Z", "getSummaryTurnThreshold", "()I", "getMemoryEnabled", "getMemoryMaxItems", "getRuntimeProfile", "()Lselfgemma/talk/domain/roleplay/model/RoleRuntimeProfile;", "getMediaProfile", "()Lselfgemma/talk/domain/roleplay/model/RoleMediaProfile;", "getInteropState", "()Lselfgemma/talk/domain/roleplay/model/RoleInteropState;", "getBuiltIn", "getArchived", "getCreatedAt", "()J", "getUpdatedAt", "getName", "getSummary", "getSystemPrompt", "getPersonaDescription", "getWorldSettings", "getOpeningLine", "getExampleDialogues", "()Ljava/util/List;", "getTags", "getCardCore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/StCharacterCard;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;ZIZILselfgemma/talk/domain/roleplay/model/RoleRuntimeProfile;Lselfgemma/talk/domain/roleplay/model/RoleMediaProfile;Lselfgemma/talk/domain/roleplay/model/RoleInteropState;ZZJJ)Lselfgemma/talk/domain/roleplay/model/RoleCard;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class RoleCard {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.StCharacterCard stCard = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String avatarUri = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String coverUri = null;
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
    @org.jetbrains.annotations.Nullable()
    private final selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile runtimeProfile = null;
    @org.jetbrains.annotations.Nullable()
    private final selfgemma.talk.domain.roleplay.model.RoleMediaProfile mediaProfile = null;
    @org.jetbrains.annotations.Nullable()
    private final selfgemma.talk.domain.roleplay.model.RoleInteropState interopState = null;
    private final boolean builtIn = false;
    private final boolean archived = false;
    private final long createdAt = 0L;
    private final long updatedAt = 0L;
    
    public RoleCard(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StCharacterCard stCard, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarUri, @org.jetbrains.annotations.Nullable()
    java.lang.String coverUri, @org.jetbrains.annotations.NotNull()
    java.lang.String safetyPolicy, @org.jetbrains.annotations.Nullable()
    java.lang.String defaultModelId, @org.jetbrains.annotations.Nullable()
    java.lang.Float defaultTemperature, @org.jetbrains.annotations.Nullable()
    java.lang.Float defaultTopP, @org.jetbrains.annotations.Nullable()
    java.lang.Integer defaultTopK, boolean enableThinking, int summaryTurnThreshold, boolean memoryEnabled, int memoryMaxItems, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile runtimeProfile, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleMediaProfile mediaProfile, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleInteropState interopState, boolean builtIn, boolean archived, long createdAt, long updatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StCharacterCard getStCard() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile getRuntimeProfile() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.domain.roleplay.model.RoleMediaProfile getMediaProfile() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.domain.roleplay.model.RoleInteropState getInteropState() {
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
    
    public RoleCard(@org.jetbrains.annotations.NotNull()
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
    selfgemma.talk.domain.roleplay.model.StCharacterCard cardCore, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile runtimeProfile, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleMediaProfile mediaProfile, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleInteropState interopState, boolean builtIn, boolean archived, long createdAt, long updatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
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
    public final java.util.List<java.lang.String> getTags() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StCharacterCard getCardCore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final int component13() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.domain.roleplay.model.RoleMediaProfile component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.domain.roleplay.model.RoleInteropState component16() {
        return null;
    }
    
    public final boolean component17() {
        return false;
    }
    
    public final boolean component18() {
        return false;
    }
    
    public final long component19() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StCharacterCard component2() {
        return null;
    }
    
    public final long component20() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RoleCard copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StCharacterCard stCard, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarUri, @org.jetbrains.annotations.Nullable()
    java.lang.String coverUri, @org.jetbrains.annotations.NotNull()
    java.lang.String safetyPolicy, @org.jetbrains.annotations.Nullable()
    java.lang.String defaultModelId, @org.jetbrains.annotations.Nullable()
    java.lang.Float defaultTemperature, @org.jetbrains.annotations.Nullable()
    java.lang.Float defaultTopP, @org.jetbrains.annotations.Nullable()
    java.lang.Integer defaultTopK, boolean enableThinking, int summaryTurnThreshold, boolean memoryEnabled, int memoryMaxItems, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile runtimeProfile, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleMediaProfile mediaProfile, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleInteropState interopState, boolean builtIn, boolean archived, long createdAt, long updatedAt) {
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