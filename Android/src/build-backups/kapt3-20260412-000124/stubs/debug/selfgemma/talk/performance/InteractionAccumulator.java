package selfgemma.talk.performance;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lselfgemma/talk/performance/InteractionAccumulator;", "", "<init>", "()V", "histogram", "", "totalCount", "", "value", "", "maxDurationMs", "getMaxDurationMs", "()I", "p50", "getP50", "p95", "getP95", "p99", "getP99", "record", "", "durationMs", "summary", "", "percentile", "", "app_debug"})
final class InteractionAccumulator {
    @org.jetbrains.annotations.NotNull()
    private final int[] histogram = null;
    private long totalCount = 0L;
    private int maxDurationMs = 0;
    
    public InteractionAccumulator() {
        super();
    }
    
    public final int getMaxDurationMs() {
        return 0;
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
    
    public final void record(int durationMs) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String summary() {
        return null;
    }
    
    private final int percentile(double percentile) {
        return 0;
    }
}