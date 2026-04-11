package selfgemma.talk.performance;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000ej\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u000ej\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0011`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lselfgemma/talk/performance/FrontendPerformanceMonitor;", "", "<init>", "()V", "lock", "foregroundSessionActive", "", "foregroundSessionReason", "", "foregroundSessionStartedAtMs", "", "overallFrames", "Lselfgemma/talk/performance/FrameAccumulator;", "framesByScope", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "interactionsByName", "Lselfgemma/talk/performance/InteractionAccumulator;", "startForegroundSession", "", "reason", "endForegroundSession", "recordFrame", "frameData", "Landroidx/metrics/performance/FrameData;", "recordInteraction", "name", "durationMs", "buildSummaryLocked", "resetSamplesLocked", "app_debug"})
public final class FrontendPerformanceMonitor {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.Object lock = null;
    private static boolean foregroundSessionActive = false;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String foregroundSessionReason = "inactive";
    private static long foregroundSessionStartedAtMs = 0L;
    @org.jetbrains.annotations.NotNull()
    private static selfgemma.talk.performance.FrameAccumulator overallFrames;
    @org.jetbrains.annotations.NotNull()
    private static java.util.LinkedHashMap<java.lang.String, selfgemma.talk.performance.FrameAccumulator> framesByScope;
    @org.jetbrains.annotations.NotNull()
    private static java.util.LinkedHashMap<java.lang.String, selfgemma.talk.performance.InteractionAccumulator> interactionsByName;
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.performance.FrontendPerformanceMonitor INSTANCE = null;
    
    private FrontendPerformanceMonitor() {
        super();
    }
    
    public final void startForegroundSession(@org.jetbrains.annotations.NotNull()
    java.lang.String reason) {
    }
    
    public final void endForegroundSession(@org.jetbrains.annotations.NotNull()
    java.lang.String reason) {
    }
    
    public final void recordFrame(@org.jetbrains.annotations.NotNull()
    androidx.metrics.performance.FrameData frameData) {
    }
    
    public final void recordInteraction(@org.jetbrains.annotations.NotNull()
    java.lang.String name, long durationMs) {
    }
    
    private final java.lang.String buildSummaryLocked(java.lang.String reason) {
        return null;
    }
    
    private final void resetSamplesLocked() {
    }
}