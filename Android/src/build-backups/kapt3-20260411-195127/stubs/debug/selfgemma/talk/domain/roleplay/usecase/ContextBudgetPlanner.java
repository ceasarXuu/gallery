package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001(B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0000\u00a2\u0006\u0002\b\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018H\u0002J&\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0010H\u0002J*\u0010!\u001a\u00020\u0007*\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00152\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\rH\u0002J\u000e\u0010&\u001a\u00020\u0017*\u0004\u0018\u00010\u001fH\u0002J\u000e\u0010\'\u001a\u00020\u001f*\u0004\u0018\u00010\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ContextBudgetPlanner;", "", "tokenEstimator", "Lselfgemma/talk/domain/roleplay/usecase/TokenEstimator;", "<init>", "(Lselfgemma/talk/domain/roleplay/usecase/TokenEstimator;)V", "plan", "Lselfgemma/talk/domain/roleplay/usecase/BudgetedPromptPlan;", "material", "Lselfgemma/talk/domain/roleplay/usecase/PromptMaterial;", "contextProfile", "Lselfgemma/talk/domain/roleplay/model/ModelContextProfile;", "preferredMode", "Lselfgemma/talk/domain/roleplay/usecase/PromptBudgetMode;", "plan$app_debug", "initialLevelFor", "Lselfgemma/talk/domain/roleplay/usecase/PromptSectionLevel;", "candidate", "Lselfgemma/talk/domain/roleplay/usecase/PromptSectionCandidate;", "resolveMode", "states", "", "degradeOnce", "", "", "advanceSectionLevel", "index", "", "render", "Lselfgemma/talk/domain/roleplay/usecase/ContextBudgetPlanner$RenderedPrompt;", "resolveBody", "", "level", "toPlan", "candidateSectionIds", "Lselfgemma/talk/domain/roleplay/usecase/PromptSectionId;", "usableInputTokens", "mode", "hasContent", "normalized", "RenderedPrompt", "app_debug"})
public final class ContextBudgetPlanner {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.TokenEstimator tokenEstimator = null;
    
    @javax.inject.Inject()
    public ContextBudgetPlanner(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.TokenEstimator tokenEstimator) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.BudgetedPromptPlan plan$app_debug(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.PromptMaterial material, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.ModelContextProfile contextProfile, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode preferredMode) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.usecase.PromptSectionLevel initialLevelFor(selfgemma.talk.domain.roleplay.usecase.PromptSectionCandidate candidate, selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode preferredMode) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode resolveMode(java.util.List<? extends selfgemma.talk.domain.roleplay.usecase.PromptSectionLevel> states) {
        return null;
    }
    
    private final boolean degradeOnce(selfgemma.talk.domain.roleplay.usecase.PromptMaterial material, java.util.List<selfgemma.talk.domain.roleplay.usecase.PromptSectionLevel> states) {
        return false;
    }
    
    private final boolean advanceSectionLevel(selfgemma.talk.domain.roleplay.usecase.PromptSectionCandidate candidate, java.util.List<selfgemma.talk.domain.roleplay.usecase.PromptSectionLevel> states, int index) {
        return false;
    }
    
    private final selfgemma.talk.domain.roleplay.usecase.ContextBudgetPlanner.RenderedPrompt render(selfgemma.talk.domain.roleplay.usecase.PromptMaterial material, java.util.List<? extends selfgemma.talk.domain.roleplay.usecase.PromptSectionLevel> states) {
        return null;
    }
    
    private final java.lang.String resolveBody(selfgemma.talk.domain.roleplay.usecase.PromptSectionCandidate candidate, selfgemma.talk.domain.roleplay.usecase.PromptSectionLevel level) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.usecase.BudgetedPromptPlan toPlan(selfgemma.talk.domain.roleplay.usecase.ContextBudgetPlanner.RenderedPrompt $this$toPlan, java.util.List<? extends selfgemma.talk.domain.roleplay.usecase.PromptSectionId> candidateSectionIds, int usableInputTokens, selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode mode) {
        return null;
    }
    
    private final boolean hasContent(java.lang.String $this$hasContent) {
        return false;
    }
    
    private final java.lang.String normalized(java.lang.String $this$normalized) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\bH\u00c6\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ContextBudgetPlanner$RenderedPrompt;", "", "prompt", "", "sections", "", "Lselfgemma/talk/domain/roleplay/usecase/PlannedPromptSection;", "estimatedInputTokens", "", "<init>", "(Ljava/lang/String;Ljava/util/List;I)V", "getPrompt", "()Ljava/lang/String;", "getSections", "()Ljava/util/List;", "getEstimatedInputTokens", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    static final class RenderedPrompt {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String prompt = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<selfgemma.talk.domain.roleplay.usecase.PlannedPromptSection> sections = null;
        private final int estimatedInputTokens = 0;
        
        public RenderedPrompt(@org.jetbrains.annotations.NotNull()
        java.lang.String prompt, @org.jetbrains.annotations.NotNull()
        java.util.List<selfgemma.talk.domain.roleplay.usecase.PlannedPromptSection> sections, int estimatedInputTokens) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPrompt() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<selfgemma.talk.domain.roleplay.usecase.PlannedPromptSection> getSections() {
            return null;
        }
        
        public final int getEstimatedInputTokens() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<selfgemma.talk.domain.roleplay.usecase.PlannedPromptSection> component2() {
            return null;
        }
        
        public final int component3() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final selfgemma.talk.domain.roleplay.usecase.ContextBudgetPlanner.RenderedPrompt copy(@org.jetbrains.annotations.NotNull()
        java.lang.String prompt, @org.jetbrains.annotations.NotNull()
        java.util.List<selfgemma.talk.domain.roleplay.usecase.PlannedPromptSection> sections, int estimatedInputTokens) {
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
}