package selfgemma.talk.ui.common.chat;

/**
 * Chat message for showing a WebView.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0016\u001a\u00020\u0000H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lselfgemma/talk/ui/common/chat/ChatMessageWebView;", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "url", "", "iframe", "", "aspectRatio", "", "side", "Lselfgemma/talk/ui/common/chat/ChatSide;", "hideSenderLabel", "<init>", "(Ljava/lang/String;ZFLselfgemma/talk/ui/common/chat/ChatSide;Z)V", "getUrl", "()Ljava/lang/String;", "getIframe", "()Z", "getAspectRatio", "()F", "getSide", "()Lselfgemma/talk/ui/common/chat/ChatSide;", "getHideSenderLabel", "clone", "app_debug"})
public final class ChatMessageWebView extends selfgemma.talk.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String url = null;
    private final boolean iframe = false;
    private final float aspectRatio = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.common.chat.ChatSide side = null;
    private final boolean hideSenderLabel = false;
    
    public ChatMessageWebView(@org.jetbrains.annotations.NotNull()
    java.lang.String url, boolean iframe, float aspectRatio, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatSide side, boolean hideSenderLabel) {
        super(null, null, 0.0F, null, false, false);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    public final boolean getIframe() {
        return false;
    }
    
    public final float getAspectRatio() {
        return 0.0F;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.ui.common.chat.ChatSide getSide() {
        return null;
    }
    
    @java.lang.Override()
    public boolean getHideSenderLabel() {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.ui.common.chat.ChatMessageWebView clone() {
        return null;
    }
}