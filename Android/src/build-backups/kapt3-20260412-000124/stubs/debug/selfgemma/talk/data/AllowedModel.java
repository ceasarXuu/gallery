package selfgemma.talk.data;

/**
 * A model in the model allowlist.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B\u00ef\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010?\u001a\u00020@J\b\u0010A\u001a\u00020\u0003H\u0016J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\tH\u00c6\u0003J\t\u0010H\u001a\u00020\u000bH\u00c6\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u00c6\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010.J\u0010\u0010K\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010.J\u0010\u0010L\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010.J\u0010\u0010M\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010.J\u0010\u0010N\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010.J\u0010\u0010O\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010.J\u0010\u0010P\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003\u00a2\u0006\u0002\u00106J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0017\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u00c6\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u001eH\u00c6\u0003J\u0086\u0002\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u00c6\u0001\u00a2\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u000f2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010Z\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010/\u001a\u0004\b0\u0010.R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010/\u001a\u0004\b1\u0010.R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010/\u001a\u0004\b2\u0010.R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010/\u001a\u0004\b3\u0010.R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010/\u001a\u0004\b4\u0010.R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010,R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\"R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\"R\u001f\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>\u00a8\u0006["}, d2 = {"Lselfgemma/talk/data/AllowedModel;", "", "name", "", "modelId", "modelFile", "commitHash", "description", "sizeInBytes", "", "defaultConfig", "Lselfgemma/talk/data/DefaultConfig;", "taskTypes", "", "disabled", "", "llmSupportImage", "llmSupportAudio", "llmSupportTinyGarden", "llmSupportMobileActions", "llmSupportThinking", "minDeviceMemoryInGb", "", "bestForTaskTypes", "localModelFilePathOverride", "url", "socToModelFiles", "", "Lselfgemma/talk/data/SocModelFile;", "runtimeType", "Lselfgemma/talk/data/RuntimeType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLselfgemma/talk/data/DefaultConfig;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lselfgemma/talk/data/RuntimeType;)V", "getName", "()Ljava/lang/String;", "getModelId", "getModelFile", "getCommitHash", "getDescription", "getSizeInBytes", "()J", "getDefaultConfig", "()Lselfgemma/talk/data/DefaultConfig;", "getTaskTypes", "()Ljava/util/List;", "getDisabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLlmSupportImage", "getLlmSupportAudio", "getLlmSupportTinyGarden", "getLlmSupportMobileActions", "getLlmSupportThinking", "getMinDeviceMemoryInGb", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBestForTaskTypes", "getLocalModelFilePathOverride", "getUrl", "getSocToModelFiles", "()Ljava/util/Map;", "getRuntimeType", "()Lselfgemma/talk/data/RuntimeType;", "toModel", "Lselfgemma/talk/data/Model;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLselfgemma/talk/data/DefaultConfig;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lselfgemma/talk/data/RuntimeType;)Lselfgemma/talk/data/AllowedModel;", "equals", "other", "hashCode", "app_debug"})
public final class AllowedModel {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String modelId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String modelFile = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String commitHash = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    private final long sizeInBytes = 0L;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DefaultConfig defaultConfig = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> taskTypes = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean disabled = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean llmSupportImage = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean llmSupportAudio = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean llmSupportTinyGarden = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean llmSupportMobileActions = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean llmSupportThinking = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer minDeviceMemoryInGb = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> bestForTaskTypes = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String localModelFilePathOverride = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String url = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.Map<java.lang.String, selfgemma.talk.data.SocModelFile> socToModelFiles = null;
    @org.jetbrains.annotations.Nullable()
    private final selfgemma.talk.data.RuntimeType runtimeType = null;
    
    public AllowedModel(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String modelId, @org.jetbrains.annotations.NotNull()
    java.lang.String modelFile, @org.jetbrains.annotations.NotNull()
    java.lang.String commitHash, @org.jetbrains.annotations.NotNull()
    java.lang.String description, long sizeInBytes, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DefaultConfig defaultConfig, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> taskTypes, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean disabled, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean llmSupportImage, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean llmSupportAudio, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean llmSupportTinyGarden, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean llmSupportMobileActions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean llmSupportThinking, @org.jetbrains.annotations.Nullable()
    java.lang.Integer minDeviceMemoryInGb, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> bestForTaskTypes, @org.jetbrains.annotations.Nullable()
    java.lang.String localModelFilePathOverride, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, selfgemma.talk.data.SocModelFile> socToModelFiles, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.data.RuntimeType runtimeType) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModelId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModelFile() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCommitHash() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final long getSizeInBytes() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.DefaultConfig getDefaultConfig() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTaskTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getDisabled() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getLlmSupportImage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getLlmSupportAudio() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getLlmSupportTinyGarden() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getLlmSupportMobileActions() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getLlmSupportThinking() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMinDeviceMemoryInGb() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getBestForTaskTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLocalModelFilePathOverride() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Map<java.lang.String, selfgemma.talk.data.SocModelFile> getSocToModelFiles() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.data.RuntimeType getRuntimeType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.Model toModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Map<java.lang.String, selfgemma.talk.data.SocModelFile> component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.data.RuntimeType component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    public final long component6() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.DefaultConfig component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.AllowedModel copy(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String modelId, @org.jetbrains.annotations.NotNull()
    java.lang.String modelFile, @org.jetbrains.annotations.NotNull()
    java.lang.String commitHash, @org.jetbrains.annotations.NotNull()
    java.lang.String description, long sizeInBytes, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DefaultConfig defaultConfig, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> taskTypes, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean disabled, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean llmSupportImage, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean llmSupportAudio, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean llmSupportTinyGarden, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean llmSupportMobileActions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean llmSupportThinking, @org.jetbrains.annotations.Nullable()
    java.lang.Integer minDeviceMemoryInGb, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> bestForTaskTypes, @org.jetbrains.annotations.Nullable()
    java.lang.String localModelFilePathOverride, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, selfgemma.talk.data.SocModelFile> socToModelFiles, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.data.RuntimeType runtimeType) {
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
}