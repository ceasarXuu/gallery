package selfgemma.talk.ui.llmchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lselfgemma/talk/ui/llmchat/LlmChatOverflowRecovery;", "", "<init>", "()V", "MAX_OVERFLOW_RETRIES", "", "shouldUseAggressiveModePreflight", "", "report", "Lselfgemma/talk/ui/llmchat/LlmChatContextReport;", "isContextOverflow", "message", "", "toUserMessage", "app_debug"})
public final class LlmChatOverflowRecovery {
    public static final int MAX_OVERFLOW_RETRIES = 1;
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.ui.llmchat.LlmChatOverflowRecovery INSTANCE = null;
    
    private LlmChatOverflowRecovery() {
        super();
    }
    
    public final boolean shouldUseAggressiveModePreflight(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmChatContextReport report) {
        return false;
    }
    
    public final boolean isContextOverflow(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String toUserMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return null;
    }
}