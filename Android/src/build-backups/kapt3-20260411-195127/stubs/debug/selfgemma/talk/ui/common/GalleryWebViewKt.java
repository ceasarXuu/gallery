package selfgemma.talk.ui.common;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0094\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"TAG", "", "iframeWrapper", "AppWebView", "", "modifier", "Landroidx/compose/ui/Modifier;", "initialUrl", "useIframeWrapper", "", "preventParentScrolling", "allowRequestPermission", "onWebViewCreated", "Lkotlin/Function1;", "Landroid/webkit/WebView;", "onConsoleMessage", "Landroid/webkit/ConsoleMessage;", "onPermissionRequest", "Landroid/webkit/PermissionRequest;", "customWebViewClient", "Landroid/webkit/WebViewClient;", "app_debug"})
public final class GalleryWebViewKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGAppWebView";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String iframeWrapper = null;
    
    /**
     * A reusable Composable that wraps an Android WebView, providing common configurations and handling
     * for permissions, local asset loading, and JavaScript interfaces.
     */
    @androidx.compose.runtime.Composable()
    public static final void AppWebView(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.Nullable()
    java.lang.String initialUrl, boolean useIframeWrapper, boolean preventParentScrolling, boolean allowRequestPermission, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.webkit.WebView, kotlin.Unit> onWebViewCreated, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.webkit.ConsoleMessage, kotlin.Unit> onConsoleMessage, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.webkit.PermissionRequest, kotlin.Unit> onPermissionRequest, @org.jetbrains.annotations.Nullable()
    android.webkit.WebViewClient customWebViewClient) {
    }
}