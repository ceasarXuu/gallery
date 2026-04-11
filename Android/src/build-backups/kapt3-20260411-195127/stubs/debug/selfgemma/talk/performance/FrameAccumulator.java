package selfgemma.talk.performance;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\"J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000e@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001a\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u001c\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011\u00a8\u0006\'"}, d2 = {"Lselfgemma/talk/performance/FrameAccumulator;", "", "<init>", "()V", "histogram", "", "value", "", "totalFrames", "getTotalFrames", "()J", "jankFrames", "slowFrames", "frozenFrames", "", "maxFrameMs", "getMaxFrameMs", "()I", "jankRate", "", "getJankRate", "()D", "slowRate", "getSlowRate", "p50", "getP50", "p95", "getP95", "p99", "getP99", "record", "", "durationMs", "isJank", "", "summary", "", "isScrollableScope", "percentile", "app_debug"})
final class FrameAccumulator {
    @org.jetbrains.annotations.NotNull()
    private final int[] histogram = null;
    private long totalFrames = 0L;
    private long jankFrames = 0L;
    private long slowFrames = 0L;
    private long frozenFrames = 0L;
    private int maxFrameMs = 0;
    
    public FrameAccumulator() {
        super();
    }
    
    public final long getTotalFrames() {
        return 0L;
    }
    
    public final int getMaxFrameMs() {
        return 0;
    }
    
    public final double getJankRate() {
        return 0.0;
    }
    
    public final double getSlowRate() {
        return 0.0;
    }
    
    public final int getP50() {
        return 0;
    }
    
    public final int getP95() {
        return 0;
    }
    
    public final int getP99() {
        return 0;
    }
    
    public final void record(int durationMs, boolean isJank) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String summary(boolean isScrollableScope) {
        return null;
    }
    
    private final int percentile(double percentile) {
        return 0;
    }
}