package selfgemma.talk.ui.common.chat;

/**
 * Chat message for showing benchmark result.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bs\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010%\u001a\u00020&J\u0006\u0010\'\u001a\u00020&R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0014\u0010\u0011\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lselfgemma/talk/ui/common/chat/ChatMessageBenchmarkResult;", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "orderedStats", "", "Lselfgemma/talk/ui/common/chat/Stat;", "statValues", "", "", "", "values", "histogram", "Lselfgemma/talk/ui/common/chat/Histogram;", "warmupCurrent", "", "warmupTotal", "iterationCurrent", "iterationTotal", "latencyMs", "highlightStat", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lselfgemma/talk/ui/common/chat/Histogram;IIIIFLjava/lang/String;)V", "getOrderedStats", "()Ljava/util/List;", "getStatValues", "()Ljava/util/Map;", "getValues", "getHistogram", "()Lselfgemma/talk/ui/common/chat/Histogram;", "getWarmupCurrent", "()I", "getWarmupTotal", "getIterationCurrent", "getIterationTotal", "getLatencyMs", "()F", "getHighlightStat", "()Ljava/lang/String;", "isWarmingUp", "", "isRunning", "app_debug"})
public final class ChatMessageBenchmarkResult extends selfgemma.talk.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.ui.common.chat.Stat> orderedStats = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Float> statValues = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Float> values = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.common.chat.Histogram histogram = null;
    private final int warmupCurrent = 0;
    private final int warmupTotal = 0;
    private final int iterationCurrent = 0;
    private final int iterationTotal = 0;
    private final float latencyMs = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String highlightStat = null;
    
    public ChatMessageBenchmarkResult(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.ui.common.chat.Stat> orderedStats, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Float> statValues, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Float> values, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.Histogram histogram, int warmupCurrent, int warmupTotal, int iterationCurrent, int iterationTotal, float latencyMs, @org.jetbrains.annotations.NotNull()
    java.lang.String highlightStat) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Float> getValues() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.common.chat.Histogram getHistogram() {
        return null;
    }
    
    public final int getWarmupCurrent() {
        return 0;
    }
    
    public final int getWarmupTotal() {
        return 0;
    }
    
    public final int getIterationCurrent() {
        return 0;
    }
    
    public final int getIterationTotal() {
        return 0;
    }
    
    @java.lang.Override()
    public float getLatencyMs() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHighlightStat() {
        return null;
    }
    
    public final boolean isWarmingUp() {
        return false;
    }
    
    public final boolean isRunning() {
        return false;
    }
}