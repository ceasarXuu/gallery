package selfgemma.talk.ui.common.chat;

/**
 * Chat message for images with history.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001BG\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001c\u001a\u00020\u001dR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lselfgemma/talk/ui/common/chat/ChatMessageImageWithHistory;", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "bitmaps", "", "Landroid/graphics/Bitmap;", "imageBitMaps", "Landroidx/compose/ui/graphics/ImageBitmap;", "totalIterations", "", "side", "Lselfgemma/talk/ui/common/chat/ChatSide;", "latencyMs", "", "curIteration", "<init>", "(Ljava/util/List;Ljava/util/List;ILselfgemma/talk/ui/common/chat/ChatSide;FI)V", "getBitmaps", "()Ljava/util/List;", "getImageBitMaps", "getTotalIterations", "()I", "getSide", "()Lselfgemma/talk/ui/common/chat/ChatSide;", "getLatencyMs", "()F", "getCurIteration", "setCurIteration", "(I)V", "isRunning", "", "app_debug"})
public final class ChatMessageImageWithHistory extends selfgemma.talk.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<android.graphics.Bitmap> bitmaps = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<androidx.compose.ui.graphics.ImageBitmap> imageBitMaps = null;
    private final int totalIterations = 0;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.common.chat.ChatSide side = null;
    private final float latencyMs = 0.0F;
    private int curIteration;
    
    public ChatMessageImageWithHistory(@org.jetbrains.annotations.NotNull()
    java.util.List<android.graphics.Bitmap> bitmaps, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends androidx.compose.ui.graphics.ImageBitmap> imageBitMaps, int totalIterations, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatSide side, float latencyMs, int curIteration) {
        super(null, null, 0.0F, null, false, false);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<android.graphics.Bitmap> getBitmaps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.compose.ui.graphics.ImageBitmap> getImageBitMaps() {
        return null;
    }
    
    public final int getTotalIterations() {
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
    
    public final int getCurIteration() {
        return 0;
    }
    
    public final void setCurIteration(int p0) {
    }
    
    public final boolean isRunning() {
        return false;
    }
}