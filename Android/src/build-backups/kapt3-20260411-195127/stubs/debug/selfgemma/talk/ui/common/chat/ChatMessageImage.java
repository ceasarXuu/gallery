package selfgemma.talk.ui.common.chat;

/**
 * Chat message for images.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001BS\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010 \u001a\u00020\u0000H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006!"}, d2 = {"Lselfgemma/talk/ui/common/chat/ChatMessageImage;", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "bitmaps", "", "Landroid/graphics/Bitmap;", "imageBitMaps", "Landroidx/compose/ui/graphics/ImageBitmap;", "maxSize", "", "side", "Lselfgemma/talk/ui/common/chat/ChatSide;", "latencyMs", "", "accelerator", "", "hideSenderLabel", "", "<init>", "(Ljava/util/List;Ljava/util/List;ILselfgemma/talk/ui/common/chat/ChatSide;FLjava/lang/String;Z)V", "getBitmaps", "()Ljava/util/List;", "getImageBitMaps", "getMaxSize", "()I", "getSide", "()Lselfgemma/talk/ui/common/chat/ChatSide;", "getLatencyMs", "()F", "getAccelerator", "()Ljava/lang/String;", "getHideSenderLabel", "()Z", "clone", "app_debug"})
public final class ChatMessageImage extends selfgemma.talk.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<android.graphics.Bitmap> bitmaps = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<androidx.compose.ui.graphics.ImageBitmap> imageBitMaps = null;
    private final int maxSize = 0;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.common.chat.ChatSide side = null;
    private final float latencyMs = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String accelerator = null;
    private final boolean hideSenderLabel = false;
    
    public ChatMessageImage(@org.jetbrains.annotations.NotNull()
    java.util.List<android.graphics.Bitmap> bitmaps, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends androidx.compose.ui.graphics.ImageBitmap> imageBitMaps, int maxSize, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatSide side, float latencyMs, @org.jetbrains.annotations.NotNull()
    java.lang.String accelerator, boolean hideSenderLabel) {
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
    
    public final int getMaxSize() {
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
    public java.lang.String getAccelerator() {
        return null;
    }
    
    @java.lang.Override()
    public boolean getHideSenderLabel() {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.ui.common.chat.ChatMessageImage clone() {
        return null;
    }
}