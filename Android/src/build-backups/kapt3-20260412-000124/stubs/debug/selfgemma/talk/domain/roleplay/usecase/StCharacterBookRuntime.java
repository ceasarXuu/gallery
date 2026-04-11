package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J#\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002\u00a2\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\u00020\u0017*\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J8\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130 2\u0006\u0010!\u001a\u00020\"H\u0002J$\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001b2\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010%\u001a\u00020\u001e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/StCharacterBookRuntime;", "", "tokenEstimator", "Lselfgemma/talk/domain/roleplay/usecase/TokenEstimator;", "<init>", "(Lselfgemma/talk/domain/roleplay/usecase/TokenEstimator;)V", "resolve", "Lselfgemma/talk/domain/roleplay/usecase/StResolvedPromptRuntime;", "book", "Lselfgemma/talk/domain/roleplay/model/StCharacterBook;", "context", "Lselfgemma/talk/domain/roleplay/usecase/StWorldScanContext;", "macroContext", "Lselfgemma/talk/domain/roleplay/usecase/StMacroContext;", "chatMetadataJson", "", "chatLength", "", "matchScore", "Lselfgemma/talk/domain/roleplay/usecase/RuntimeEntry;", "textToScan", "(Lselfgemma/talk/domain/roleplay/usecase/RuntimeEntry;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/usecase/StMacroContext;)Ljava/lang/Integer;", "passesProbability", "", "metadata", "Lcom/google/gson/JsonObject;", "allEntries", "", "filterGroupedCandidates", "candidates", "Lselfgemma/talk/domain/roleplay/usecase/RuntimeCandidate;", "activated", "", "runtimeSettings", "Lselfgemma/talk/domain/roleplay/usecase/StWorldRuntimeSettings;", "filterGroupByScore", "entries", "weightedPick", "app_debug"})
public final class StCharacterBookRuntime {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.TokenEstimator tokenEstimator = null;
    
    public StCharacterBookRuntime(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.TokenEstimator tokenEstimator) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.StResolvedPromptRuntime resolve(@org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.StCharacterBook book, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.StWorldScanContext context, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.StMacroContext macroContext, @org.jetbrains.annotations.Nullable()
    java.lang.String chatMetadataJson, int chatLength) {
        return null;
    }
    
    private final java.lang.Integer matchScore(selfgemma.talk.domain.roleplay.usecase.RuntimeEntry $this$matchScore, java.lang.String textToScan, selfgemma.talk.domain.roleplay.usecase.StMacroContext macroContext) {
        return null;
    }
    
    private final boolean passesProbability(selfgemma.talk.domain.roleplay.usecase.RuntimeEntry $this$passesProbability, com.google.gson.JsonObject metadata, java.util.List<selfgemma.talk.domain.roleplay.usecase.RuntimeEntry> allEntries, int chatLength) {
        return false;
    }
    
    private final java.util.List<selfgemma.talk.domain.roleplay.usecase.RuntimeEntry> filterGroupedCandidates(java.util.List<selfgemma.talk.domain.roleplay.usecase.RuntimeCandidate> candidates, java.util.Map<java.lang.String, selfgemma.talk.domain.roleplay.usecase.RuntimeEntry> activated, selfgemma.talk.domain.roleplay.usecase.StWorldRuntimeSettings runtimeSettings) {
        return null;
    }
    
    private final java.util.List<selfgemma.talk.domain.roleplay.usecase.RuntimeCandidate> filterGroupByScore(java.util.List<selfgemma.talk.domain.roleplay.usecase.RuntimeCandidate> entries, selfgemma.talk.domain.roleplay.usecase.StWorldRuntimeSettings runtimeSettings) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.usecase.RuntimeCandidate weightedPick(java.util.List<selfgemma.talk.domain.roleplay.usecase.RuntimeCandidate> entries) {
        return null;
    }
}