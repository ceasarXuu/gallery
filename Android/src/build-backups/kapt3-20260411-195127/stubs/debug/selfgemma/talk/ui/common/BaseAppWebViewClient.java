package selfgemma.talk.ui.common;

/**
 * A base [WebViewClient] for [AppWebView] that handles local asset loading and logs page
 * finishing.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u00070\u0007\u00a2\u0006\u0002\b\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lselfgemma/talk/ui/common/BaseAppWebViewClient;", "Landroid/webkit/WebViewClient;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "localFileAssetsLoader", "Landroidx/webkit/WebViewAssetLoader;", "Lorg/jspecify/annotations/NonNull;", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "view", "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "app_debug"})
public class BaseAppWebViewClient extends android.webkit.WebViewClient {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.webkit.WebViewAssetLoader localFileAssetsLoader = null;
    
    public BaseAppWebViewClient(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.webkit.WebResourceResponse shouldInterceptRequest(@org.jetbrains.annotations.Nullable()
    android.webkit.WebView view, @org.jetbrains.annotations.Nullable()
    android.webkit.WebResourceRequest request) {
        return null;
    }
}