package selfgemma.talk.ui.common.chat;

/**
 * Chat message for showing LLM benchmark result.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\f\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lselfgemma/talk/ui/common/chat/ChatMessageBenchmarkLlmResult;", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "orderedStats", "", "Lselfgemma/talk/ui/common/chat/Stat;", "statValues", "", "", "", "running", "", "latencyMs", "accelerator", "<init>", "(Ljava/util/List;Ljava/util/Map;ZFLjava/lang/String;)V", "getOrderedStats", "()Ljava/util/List;", "getStatValues", "()Ljava/util/Map;", "getRunning", "()Z", "getLatencyMs", "()F", "getAccelerator", "()Ljava/lang/String;", "app_debug"})
public final class ChatMessageBenchmarkLlmResult extends selfgemma.talk.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.ui.common.chat.Stat> orderedStats = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Float> statValues = null;
    private final boolean running = false;
    private final float latencyMs = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String accelerator = null;
    
    public ChatMessageBenchmarkLlmResult(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.ui.common.chat.Stat> orderedStats, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Float> statValues, boolean running, float latencyMs, @org.jetbrains.annotations.NotNull()
    java.lang.String accelerator) {
        super(null, null, 0.0F, null, false, false);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.ui.common.chat.Stat> getOrderedStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Float> getStatValues() {
        return null;
    }
    
    public final boolean getRunning() {
        return false;
    }
    
    @java.lang.Override()
    public float getLatencyMs() {
        return 0.0F;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getAccelerator() {
        return null;
    }
}