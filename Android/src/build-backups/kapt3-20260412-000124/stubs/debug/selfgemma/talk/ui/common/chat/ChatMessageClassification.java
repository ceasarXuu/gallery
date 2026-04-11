package selfgemma.talk.ui.common.chat;

/**
 * Chat message for showing classification result.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lselfgemma/talk/ui/common/chat/ChatMessageClassification;", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "classifications", "", "Lselfgemma/talk/common/Classification;", "latencyMs", "", "maxBarWidth", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Ljava/util/List;FLandroidx/compose/ui/unit/Dp;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getClassifications", "()Ljava/util/List;", "getLatencyMs", "()F", "getMaxBarWidth-lTKBWiU", "()Landroidx/compose/ui/unit/Dp;", "app_debug"})
public final class ChatMessageClassification extends selfgemma.talk.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.common.Classification> classifications = null;
    private final float latencyMs = 0.0F;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.ui.unit.Dp maxBarWidth = null;
    
    private ChatMessageClassification(java.util.List<selfgemma.talk.common.Classification> classifications, float latencyMs, androidx.compose.ui.unit.Dp maxBarWidth) {
        super(null, null, 0.0F, null, false, false);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.common.Classification> getClassifications() {
        return null;
    }
    
    @java.lang.Override()
    public float getLatencyMs() {
        return 0.0F;
    }
}