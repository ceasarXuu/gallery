package selfgemma.talk.ui.common.chat;

/**
 * Base class for a chat message.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001a\u001a\u00020\u0000H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\f\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lselfgemma/talk/ui/common/chat/ChatMessage;", "", "type", "Lselfgemma/talk/ui/common/chat/ChatMessageType;", "side", "Lselfgemma/talk/ui/common/chat/ChatSide;", "latencyMs", "", "accelerator", "", "hideSenderLabel", "", "disableBubbleShape", "<init>", "(Lselfgemma/talk/ui/common/chat/ChatMessageType;Lselfgemma/talk/ui/common/chat/ChatSide;FLjava/lang/String;ZZ)V", "getType", "()Lselfgemma/talk/ui/common/chat/ChatMessageType;", "getSide", "()Lselfgemma/talk/ui/common/chat/ChatSide;", "getLatencyMs", "()F", "getAccelerator", "()Ljava/lang/String;", "getHideSenderLabel", "()Z", "getDisableBubbleShape", "clone", "app_debug"})
public class ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.common.chat.ChatMessageType type = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.common.chat.ChatSide side = null;
    private final float latencyMs = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String accelerator = null;
    private final boolean hideSenderLabel = false;
    private final boolean disableBubbleShape = false;
    
    public ChatMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessageType type, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatSide side, float latencyMs, @org.jetbrains.annotations.NotNull()
    java.lang.String accelerator, boolean hideSenderLabel, boolean disableBubbleShape) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.ui.common.chat.ChatMessageType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.ui.common.chat.ChatSide getSide() {
        return null;
    }
    
    public float getLatencyMs() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getAccelerator() {
        return null;
    }
    
    public boolean getHideSenderLabel() {
        return false;
    }
    
    public boolean getDisableBubbleShape() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.ui.common.chat.ChatMessage clone() {
        return null;
    }
}