package selfgemma.talk.ui.common.chat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000&\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\u001aA\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007\u00a2\u0006\u0002\u0010\u000e\u001a\'\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u0010\u0013\u001a\u001f\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\fH\u0002\u00a2\u0006\u0002\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"TOKEN_SPEED_REFRESH_INTERVAL_MS", "", "TOKEN_SPEED_STALE_AFTER_MS", "TOKEN_SPEED_COMPLETION_GRACE_MS", "rememberStreamingTokenSpeed", "", "streamingText", "", "isStreaming", "", "completedText", "completedLatencyMs", "", "completedAtEpochMs", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Double;Ljava/lang/Long;)Ljava/lang/Integer;", "calculateTokenSpeed", "tokenCount", "startedAtElapsed", "nowElapsed", "(IJJ)Ljava/lang/Integer;", "calculateAverageTokenSpeed", "latencyMs", "(ID)Ljava/lang/Integer;", "app_debug"})
public final class StreamingTokenSpeedKt {
    private static final long TOKEN_SPEED_REFRESH_INTERVAL_MS = 1000L;
    private static final long TOKEN_SPEED_STALE_AFTER_MS = 1000L;
    private static final long TOKEN_SPEED_COMPLETION_GRACE_MS = 3000L;
    
    @androidx.compose.runtime.Composable()
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Integer rememberStreamingTokenSpeed(@org.jetbrains.annotations.NotNull()
    java.lang.String streamingText, boolean isStreaming, @org.jetbrains.annotations.NotNull()
    java.lang.String completedText, @org.jetbrains.annotations.Nullable()
    java.lang.Double completedLatencyMs, @org.jetbrains.annotations.Nullable()
    java.lang.Long completedAtEpochMs) {
        return null;
    }
    
    private static final java.lang.Integer calculateTokenSpeed(int tokenCount, long startedAtElapsed, long nowElapsed) {
        return null;
    }
    
    private static final java.lang.Integer calculateAverageTokenSpeed(int tokenCount, double latencyMs) {
        return null;
    }
}