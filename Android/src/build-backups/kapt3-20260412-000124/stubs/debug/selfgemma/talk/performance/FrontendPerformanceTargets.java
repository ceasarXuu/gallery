package selfgemma.talk.performance;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lselfgemma/talk/performance/FrontendPerformanceTargets;", "", "<init>", "()V", "slowFrameBudgetMs", "", "frozenFrameBudgetMs", "maxForegroundJankRate", "", "maxForegroundSlowFrameRate", "maxForegroundP95FrameMs", "maxForegroundP99FrameMs", "maxForegroundFrozenFrames", "", "maxScrollableJankRate", "maxInteractionP95Ms", "maxInteractionP99Ms", "coldStartupP50Ms", "coldStartupP95Ms", "warmStartupP50Ms", "warmStartupP95Ms", "app_debug"})
public final class FrontendPerformanceTargets {
    public static final int slowFrameBudgetMs = 16;
    public static final int frozenFrameBudgetMs = 700;
    public static final double maxForegroundJankRate = 0.05;
    public static final double maxForegroundSlowFrameRate = 0.1;
    public static final int maxForegroundP95FrameMs = 16;
    public static final int maxForegroundP99FrameMs = 32;
    public static final long maxForegroundFrozenFrames = 0L;
    public static final double maxScrollableJankRate = 0.03;
    public static final int maxInteractionP95Ms = 150;
    public static final int maxInteractionP99Ms = 220;
    public static final int coldStartupP50Ms = 900;
    public static final int coldStartupP95Ms = 1200;
    public static final int warmStartupP50Ms = 450;
    public static final int warmStartupP95Ms = 650;
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.performance.FrontendPerformanceTargets INSTANCE = null;
    
    private FrontendPerformanceTargets() {
        super();
    }
}