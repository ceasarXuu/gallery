package selfgemma.talk.ui.llmchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\bH\u00c6\u0003J\t\u0010#\u001a\u00020\nH\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\bH\u00c6\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\bH\u00c6\u0001J\u0013\u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001J\t\u0010,\u001a\u00020-H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017\u00a8\u0006."}, d2 = {"Lselfgemma/talk/ui/llmchat/LlmChatContextReport;", "", "usableInputTokens", "", "reservedForCurrentTurnTokens", "availableInstructionTokens", "estimatedInstructionTokens", "currentTurnOverflowDetected", "", "mode", "Lselfgemma/talk/ui/llmchat/LlmChatContextMode;", "recentLineCount", "summaryLineCount", "droppedLineCount", "systemPromptTrimmed", "<init>", "(IIIIZLselfgemma/talk/ui/llmchat/LlmChatContextMode;IIIZ)V", "getUsableInputTokens", "()I", "getReservedForCurrentTurnTokens", "getAvailableInstructionTokens", "getEstimatedInstructionTokens", "getCurrentTurnOverflowDetected", "()Z", "getMode", "()Lselfgemma/talk/ui/llmchat/LlmChatContextMode;", "getRecentLineCount", "getSummaryLineCount", "getDroppedLineCount", "getSystemPromptTrimmed", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class LlmChatContextReport {
    private final int usableInputTokens = 0;
    private final int reservedForCurrentTurnTokens = 0;
    private final int availableInstructionTokens = 0;
    private final int estimatedInstructionTokens = 0;
    private final boolean currentTurnOverflowDetected = false;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.llmchat.LlmChatContextMode mode = null;
    private final int recentLineCount = 0;
    private final int summaryLineCount = 0;
    private final int droppedLineCount = 0;
    private final boolean systemPromptTrimmed = false;
    
    public LlmChatContextReport(int usableInputTokens, int reservedForCurrentTurnTokens, int availableInstructionTokens, int estimatedInstructionTokens, boolean currentTurnOverflowDetected, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmChatContextMode mode, int recentLineCount, int summaryLineCount, int droppedLineCount, boolean systemPromptTrimmed) {
        super();
    }
    
    public final int getUsableInputTokens() {
        return 0;
    }
    
    public final int getReservedForCurrentTurnTokens() {
        return 0;
    }
    
    public final int getAvailableInstructionTokens() {
        return 0;
    }
    
    public final int getEstimatedInstructionTokens() {
        return 0;
    }
    
    public final boolean getCurrentTurnOverflowDetected() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.llmchat.LlmChatContextMode getMode() {
        return null;
    }
    
    public final int getRecentLineCount() {
        return 0;
    }
    
    public final int getSummaryLineCount() {
        return 0;
    }
    
    public final int getDroppedLineCount() {
        return 0;
    }
    
    public final boolean getSystemPromptTrimmed() {
        return false;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.llmchat.LlmChatContextMode component6() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.llmchat.LlmChatContextReport copy(int usableInputTokens, int reservedForCurrentTurnTokens, int availableInstructionTokens, int estimatedInstructionTokens, boolean currentTurnOverflowDetected, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmChatContextMode mode, int recentLineCount, int summaryLineCount, int droppedLineCount, boolean systemPromptTrimmed) {
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