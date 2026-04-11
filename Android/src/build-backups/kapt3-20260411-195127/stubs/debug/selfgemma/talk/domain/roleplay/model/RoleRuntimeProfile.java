package selfgemma.talk.domain.roleplay.model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b>\b\u0086\b\u0018\u00002\u00020\u0001B\u00db\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b!\u0010\"J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0005H\u00c6\u0003J\t\u0010E\u001a\u00020\u0007H\u00c6\u0003J\t\u0010F\u001a\u00020\tH\u00c6\u0003J\t\u0010G\u001a\u00020\u000bH\u00c6\u0003J\t\u0010H\u001a\u00020\rH\u00c6\u0003J\t\u0010I\u001a\u00020\u000fH\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\u0003H\u00c6\u0003J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\t\u0010N\u001a\u00020\u0003H\u00c6\u0003J\t\u0010O\u001a\u00020\u0016H\u00c6\u0003J\t\u0010P\u001a\u00020\u0016H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0016H\u00c6\u0003J\t\u0010R\u001a\u00020\u0016H\u00c6\u0003J\t\u0010S\u001a\u00020\u0016H\u00c6\u0003J\t\u0010T\u001a\u00020\u0016H\u00c6\u0003J\t\u0010U\u001a\u00020\u001dH\u00c6\u0003J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010 H\u00c6\u0003\u00a2\u0006\u0002\u0010AJ\u00e2\u0001\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u00c6\u0001\u00a2\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020\u001d2\b\u0010[\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\\\u001a\u00020\u0016H\u00d6\u0001J\t\u0010]\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00107R\u0011\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00107R\u0011\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u00107R\u0011\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u00107R\u0011\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u00107R\u0011\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u001e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010$R\u0015\u0010\u001f\u001a\u0004\u0018\u00010 \u00a2\u0006\n\n\u0002\u0010B\u001a\u0004\b@\u0010A\u00a8\u0006^"}, d2 = {"Lselfgemma/talk/domain/roleplay/model/RoleRuntimeProfile;", "", "summary", "", "modelParams", "Lselfgemma/talk/domain/roleplay/model/RuntimeModelParams;", "memoryPolicy", "Lselfgemma/talk/domain/roleplay/model/MemoryPolicy;", "agentPolicy", "Lselfgemma/talk/domain/roleplay/model/AgentPolicy;", "safetyPolicy", "Lselfgemma/talk/domain/roleplay/model/RuntimeSafetyPolicy;", "promptPolicy", "Lselfgemma/talk/domain/roleplay/model/PromptPolicy;", "uiHints", "Lselfgemma/talk/domain/roleplay/model/CharacterUiHints;", "compiledCorePrompt", "compiledPersonaPrompt", "compiledWorldPrompt", "compiledStylePrompt", "compiledExampleDigest", "corePromptTokenEstimate", "", "personaPromptTokenEstimate", "worldPromptTokenEstimate", "stylePromptTokenEstimate", "exampleDigestTokenEstimate", "compiledTotalTokenEstimate", "oversizeWarning", "", "sourceFingerprint", "compiledAt", "", "<init>", "(Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/RuntimeModelParams;Lselfgemma/talk/domain/roleplay/model/MemoryPolicy;Lselfgemma/talk/domain/roleplay/model/AgentPolicy;Lselfgemma/talk/domain/roleplay/model/RuntimeSafetyPolicy;Lselfgemma/talk/domain/roleplay/model/PromptPolicy;Lselfgemma/talk/domain/roleplay/model/CharacterUiHints;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIIZLjava/lang/String;Ljava/lang/Long;)V", "getSummary", "()Ljava/lang/String;", "getModelParams", "()Lselfgemma/talk/domain/roleplay/model/RuntimeModelParams;", "getMemoryPolicy", "()Lselfgemma/talk/domain/roleplay/model/MemoryPolicy;", "getAgentPolicy", "()Lselfgemma/talk/domain/roleplay/model/AgentPolicy;", "getSafetyPolicy", "()Lselfgemma/talk/domain/roleplay/model/RuntimeSafetyPolicy;", "getPromptPolicy", "()Lselfgemma/talk/domain/roleplay/model/PromptPolicy;", "getUiHints", "()Lselfgemma/talk/domain/roleplay/model/CharacterUiHints;", "getCompiledCorePrompt", "getCompiledPersonaPrompt", "getCompiledWorldPrompt", "getCompiledStylePrompt", "getCompiledExampleDigest", "getCorePromptTokenEstimate", "()I", "getPersonaPromptTokenEstimate", "getWorldPromptTokenEstimate", "getStylePromptTokenEstimate", "getExampleDigestTokenEstimate", "getCompiledTotalTokenEstimate", "getOversizeWarning", "()Z", "getSourceFingerprint", "getCompiledAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/RuntimeModelParams;Lselfgemma/talk/domain/roleplay/model/MemoryPolicy;Lselfgemma/talk/domain/roleplay/model/AgentPolicy;Lselfgemma/talk/domain/roleplay/model/RuntimeSafetyPolicy;Lselfgemma/talk/domain/roleplay/model/PromptPolicy;Lselfgemma/talk/domain/roleplay/model/CharacterUiHints;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIIZLjava/lang/String;Ljava/lang/Long;)Lselfgemma/talk/domain/roleplay/model/RoleRuntimeProfile;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class RoleRuntimeProfile {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String summary = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.RuntimeModelParams modelParams = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.MemoryPolicy memoryPolicy = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.AgentPolicy agentPolicy = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.RuntimeSafetyPolicy safetyPolicy = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.PromptPolicy promptPolicy = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.CharacterUiHints uiHints = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String compiledCorePrompt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String compiledPersonaPrompt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String compiledWorldPrompt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String compiledStylePrompt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String compiledExampleDigest = null;
    private final int corePromptTokenEstimate = 0;
    private final int personaPromptTokenEstimate = 0;
    private final int worldPromptTokenEstimate = 0;
    private final int stylePromptTokenEstimate = 0;
    private final int exampleDigestTokenEstimate = 0;
    private final int compiledTotalTokenEstimate = 0;
    private final boolean oversizeWarning = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String sourceFingerprint = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long compiledAt = null;
    
    public RoleRuntimeProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String summary, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RuntimeModelParams modelParams, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.MemoryPolicy memoryPolicy, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.AgentPolicy agentPolicy, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RuntimeSafetyPolicy safetyPolicy, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.PromptPolicy promptPolicy, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.CharacterUiHints uiHints, @org.jetbrains.annotations.NotNull()
    java.lang.String compiledCorePrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String compiledPersonaPrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String compiledWorldPrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String compiledStylePrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String compiledExampleDigest, int corePromptTokenEstimate, int personaPromptTokenEstimate, int worldPromptTokenEstimate, int stylePromptTokenEstimate, int exampleDigestTokenEstimate, int compiledTotalTokenEstimate, boolean oversizeWarning, @org.jetbrains.annotations.NotNull()
    java.lang.String sourceFingerprint, @org.jetbrains.annotations.Nullable()
    java.lang.Long compiledAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSummary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RuntimeModelParams getModelParams() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.MemoryPolicy getMemoryPolicy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.AgentPolicy getAgentPolicy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RuntimeSafetyPolicy getSafetyPolicy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.PromptPolicy getPromptPolicy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.CharacterUiHints getUiHints() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompiledCorePrompt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompiledPersonaPrompt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompiledWorldPrompt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompiledStylePrompt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompiledExampleDigest() {
        return null;
    }
    
    public final int getCorePromptTokenEstimate() {
        return 0;
    }
    
    public final int getPersonaPromptTokenEstimate() {
        return 0;
    }
    
    public final int getWorldPromptTokenEstimate() {
        return 0;
    }
    
    public final int getStylePromptTokenEstimate() {
        return 0;
    }
    
    public final int getExampleDigestTokenEstimate() {
        return 0;
    }
    
    public final int getCompiledTotalTokenEstimate() {
        return 0;
    }
    
    public final boolean getOversizeWarning() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSourceFingerprint() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getCompiledAt() {
        return null;
    }
    
    public RoleRuntimeProfile() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    public final int component13() {
        return 0;
    }
    
    public final int component14() {
        return 0;
    }
    
    public final int component15() {
        return 0;
    }
    
    public final int component16() {
        return 0;
    }
    
    public final int component17() {
        return 0;
    }
    
    public final int component18() {
        return 0;
    }
    
    public final boolean component19() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RuntimeModelParams component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.MemoryPolicy component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.AgentPolicy component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RuntimeSafetyPolicy component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.PromptPolicy component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.CharacterUiHints component7() {
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
    public final selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile copy(@org.jetbrains.annotations.NotNull()
    java.lang.String summary, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RuntimeModelParams modelParams, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.MemoryPolicy memoryPolicy, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.AgentPolicy agentPolicy, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RuntimeSafetyPolicy safetyPolicy, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.PromptPolicy promptPolicy, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.CharacterUiHints uiHints, @org.jetbrains.annotations.NotNull()
    java.lang.String compiledCorePrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String compiledPersonaPrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String compiledWorldPrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String compiledStylePrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String compiledExampleDigest, int corePromptTokenEstimate, int personaPromptTokenEstimate, int worldPromptTokenEstimate, int stylePromptTokenEstimate, int exampleDigestTokenEstimate, int compiledTotalTokenEstimate, boolean oversizeWarning, @org.jetbrains.annotations.NotNull()
    java.lang.String sourceFingerprint, @org.jetbrains.annotations.Nullable()
    java.lang.Long compiledAt) {
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