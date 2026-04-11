package selfgemma.talk.runtime;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"ERROR_CODE_3", "", "DEFAULT_CONTEXT_OVERFLOW_MESSAGE", "isContextOverflowError", "", "message", "toUserFacingContextOverflowMessage", "app_debug"})
public final class ContextOverflowSupportKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ERROR_CODE_3 = "error code 3";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_CONTEXT_OVERFLOW_MESSAGE = "Input exceeds the model context window. Shorten the message, reset the session, or use a shorter prompt.";
    
    public static final boolean isContextOverflowError(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String toUserFacingContextOverflowMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return null;
    }
}