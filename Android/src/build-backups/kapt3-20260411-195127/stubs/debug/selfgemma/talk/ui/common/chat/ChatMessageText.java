package selfgemma.talk.ui.common.chat;

/**
 * Chat message for plain text.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0016\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010#\u001a\u00020\u0000H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0014\u0010\r\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006$"}, d2 = {"Lselfgemma/talk/ui/common/chat/ChatMessageText;", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "content", "", "side", "Lselfgemma/talk/ui/common/chat/ChatSide;", "latencyMs", "", "isMarkdown", "", "llmBenchmarkResult", "Lselfgemma/talk/ui/common/chat/ChatMessageBenchmarkLlmResult;", "accelerator", "hideSenderLabel", "data", "", "<init>", "(Ljava/lang/String;Lselfgemma/talk/ui/common/chat/ChatSide;FZLselfgemma/talk/ui/common/chat/ChatMessageBenchmarkLlmResult;Ljava/lang/String;ZLjava/lang/Object;)V", "getContent", "()Ljava/lang/String;", "getSide", "()Lselfgemma/talk/ui/common/chat/ChatSide;", "getLatencyMs", "()F", "()Z", "getLlmBenchmarkResult", "()Lselfgemma/talk/ui/common/chat/ChatMessageBenchmarkLlmResult;", "setLlmBenchmarkResult", "(Lselfgemma/talk/ui/common/chat/ChatMessageBenchmarkLlmResult;)V", "getAccelerator", "getHideSenderLabel", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "clone", "app_debug"})
public class ChatMessageText extends selfgemma.talk.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String content = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.common.chat.ChatSide side = null;
    private final float latencyMs = 0.0F;
    private final boolean isMarkdown = false;
    @org.jetbrains.annotations.Nullable()
    private selfgemma.talk.ui.common.chat.ChatMessageBenchmarkLlmResult llmBenchmarkResult;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String accelerator = null;
    private final boolean hideSenderLabel = false;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object data;
    
    public ChatMessageText(@org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatSide side, float latencyMs, boolean isMarkdown, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.ui.common.chat.ChatMessageBenchmarkLlmResult llmBenchmarkResult, @org.jetbrains.annotations.NotNull()
    java.lang.String accelerator, boolean hideSenderLabel, @org.jetbrains.annotations.Nullable()
    java.lang.Object data) {
        super(null, null, 0.0F, null, false, false);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.ui.common.chat.ChatSide getSide() {
        return null;
    }
    
    @java.lang.Override()
    public float getLatencyMs() {
        return 0.0F;
    }
    
    public final boolean isMarkdown() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.ui.common.chat.ChatMessageBenchmarkLlmResult getLlmBenchmarkResult() {
        return null;
    }
    
    public final void setLlmBenchmarkResult(@org.jetbrains.annotations.Nullable()
    selfgemma.talk.ui.common.chat.ChatMessageBenchmarkLlmResult p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getAccelerator() {
        return null;
    }
    
    @java.lang.Override()
    public boolean getHideSenderLabel() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.ui.common.chat.ChatMessageText clone() {
        return null;
    }
}