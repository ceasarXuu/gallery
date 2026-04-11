package selfgemma.talk.performance;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0016\u0010\b\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"TAG", "", "MAX_FRAME_BUCKET_MS", "", "MAX_INTERACTION_BUCKET_MS", "nanosToRoundedMillis", "nanos", "", "extractScope", "states", "", "Landroidx/metrics/performance/StateInfo;", "formatRate", "numerator", "denominator", "rateOf", "", "app_debug"})
public final class FrontendPerformanceMonitorKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "FrontendPerf";
    private static final int MAX_FRAME_BUCKET_MS = 2000;
    private static final int MAX_INTERACTION_BUCKET_MS = 5000;
    
    private static final int nanosToRoundedMillis(long nanos) {
        return 0;
    }
    
    private static final java.lang.String extractScope(java.util.List<androidx.metrics.performance.StateInfo> states) {
        return null;
    }
    
    private static final java.lang.String formatRate(long numerator, long denominator) {
        return null;
    }
    
    private static final double rateOf(long numerator, long denominator) {
        return 0.0;
    }
}