package selfgemma.talk.ui.common.chat;

/**
 * Chat message for showcasing a thought process.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0000H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lselfgemma/talk/ui/common/chat/ChatMessageThinking;", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "content", "", "inProgress", "", "side", "Lselfgemma/talk/ui/common/chat/ChatSide;", "hideSenderLabel", "accelerator", "<init>", "(Ljava/lang/String;ZLselfgemma/talk/ui/common/chat/ChatSide;ZLjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getInProgress", "()Z", "getSide", "()Lselfgemma/talk/ui/common/chat/ChatSide;", "getHideSenderLabel", "getAccelerator", "clone", "app_debug"})
public final class ChatMessageThinking extends selfgemma.talk.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String content = null;
    private final boolean inProgress = false;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.common.chat.ChatSide side = null;
    private final boolean hideSenderLabel = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String accelerator = null;
    
    public ChatMessageThinking(@org.jetbrains.annotations.NotNull()
    java.lang.String content, boolean inProgress, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatSide side, boolean hideSenderLabel, @org.jetbrains.annotations.NotNull()
    java.lang.String accelerator) {
        super(null, null, 0.0F, null, false, false);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    public final boolean getInProgress() {
        return false;
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
    public java.lang.String getAccelerator() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.ui.common.chat.ChatMessageThinking clone() {
        return null;
    }
}