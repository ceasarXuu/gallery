package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\fH\u00c6\u0003JA\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\nH\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006$"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/BudgetedPromptPlan;", "", "prompt", "", "sections", "", "Lselfgemma/talk/domain/roleplay/usecase/PlannedPromptSection;", "mode", "Lselfgemma/talk/domain/roleplay/usecase/PromptBudgetMode;", "estimatedInputTokens", "", "report", "Lselfgemma/talk/domain/roleplay/usecase/PromptBudgetReport;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lselfgemma/talk/domain/roleplay/usecase/PromptBudgetMode;ILselfgemma/talk/domain/roleplay/usecase/PromptBudgetReport;)V", "getPrompt", "()Ljava/lang/String;", "getSections", "()Ljava/util/List;", "getMode", "()Lselfgemma/talk/domain/roleplay/usecase/PromptBudgetMode;", "getEstimatedInputTokens", "()I", "getReport", "()Lselfgemma/talk/domain/roleplay/usecase/PromptBudgetReport;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class BudgetedPromptPlan {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String prompt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.domain.roleplay.usecase.PlannedPromptSection> sections = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode mode = null;
    private final int estimatedInputTokens = 0;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.PromptBudgetReport report = null;
    
    public BudgetedPromptPlan(@org.jetbrains.annotations.NotNull()
    java.lang.String prompt, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.usecase.PlannedPromptSection> sections, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode mode, int estimatedInputTokens, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.PromptBudgetReport report) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode getMode() {
        return null;
    }
    
    public final int getEstimatedInputTokens() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.PromptBudgetReport getReport() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.domain.roleplay.usecase.PlannedPromptSection> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.PromptBudgetReport component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.BudgetedPromptPlan copy(@org.jetbrains.annotations.NotNull()
    java.lang.String prompt, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.usecase.PlannedPromptSection> sections, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode mode, int estimatedInputTokens, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.PromptBudgetReport report) {
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