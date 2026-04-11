package selfgemma.talk.ui.common.chat;

/**
 * Chat message for audio clip.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0000H\u0016J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lselfgemma/talk/ui/common/chat/ChatMessageAudioClip;", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "audioData", "", "sampleRate", "", "side", "Lselfgemma/talk/ui/common/chat/ChatSide;", "latencyMs", "", "<init>", "([BILselfgemma/talk/ui/common/chat/ChatSide;F)V", "getAudioData", "()[B", "getSampleRate", "()I", "getSide", "()Lselfgemma/talk/ui/common/chat/ChatSide;", "getLatencyMs", "()F", "clone", "genByteArrayForWav", "getDurationInSeconds", "app_debug"})
public final class ChatMessageAudioClip extends selfgemma.talk.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final byte[] audioData = null;
    private final int sampleRate = 0;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.common.chat.ChatSide side = null;
    private final float latencyMs = 0.0F;
    
    public ChatMessageAudioClip(@org.jetbrains.annotations.NotNull()
    byte[] audioData, int sampleRate, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatSide side, float latencyMs) {
        super(null, null, 0.0F, null, false, false);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getAudioData() {
        return null;
    }
    
    public final int getSampleRate() {
        return 0;
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
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.ui.common.chat.ChatMessageAudioClip clone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] genByteArrayForWav() {
        return null;
    }
    
    public final float getDurationInSeconds() {
        return 0.0F;
    }
}