package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ContextOverflowRecovery;", "", "<init>", "()V", "MAX_OVERFLOW_RETRIES", "", "shouldUseAggressiveModePreflight", "", "report", "Lselfgemma/talk/domain/roleplay/usecase/PromptBudgetReport;", "isContextOverflow", "message", "", "toUserFacingError", "app_debug"})
public final class ContextOverflowRecovery {
    public static final int MAX_OVERFLOW_RETRIES = 1;
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.domain.roleplay.usecase.ContextOverflowRecovery INSTANCE = null;
    
    private ContextOverflowRecovery() {
        super();
    }
    
    public final boolean shouldUseAggressiveModePreflight(@org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.usecase.PromptBudgetReport report) {
        return false;
    }
    
    public final boolean isContextOverflow(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String toUserFacingError(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return null;
    }
}