package selfgemma.talk.customtasks.agentchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0006H\u0007R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lselfgemma/talk/customtasks/agentchat/ChatWebViewJavascriptInterface;", "", "<init>", "()V", "onResultListener", "Lkotlin/Function1;", "", "", "getOnResultListener", "()Lkotlin/jvm/functions/Function1;", "setOnResultListener", "(Lkotlin/jvm/functions/Function1;)V", "onResultReady", "result", "app_debug"})
public final class ChatWebViewJavascriptInterface {
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onResultListener;
    
    public ChatWebViewJavascriptInterface() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnResultListener() {
        return null;
    }
    
    public final void setOnResultListener(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @android.webkit.JavascriptInterface()
    public final void onResultReady(@org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
}