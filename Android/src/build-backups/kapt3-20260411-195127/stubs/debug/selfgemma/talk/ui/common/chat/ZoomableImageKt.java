package selfgemma.talk.ui.common.chat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u00b1\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2M\b\u0002\u0010\u0011\u001aG\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012H\u0007\u001a\u001a\u0010\u0018\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u001a\u00a8\u0006\u001b"}, d2 = {"ZoomableImage", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "modifier", "Landroidx/compose/ui/Modifier;", "minScale", "", "maxScale", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "resetOnImageUpdate", "", "enabled", "twoFingerOnly", "onTransformed", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "offsetX", "offsetY", "scale", "setScrolling", "value", "(Landroidx/compose/foundation/pager/PagerState;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ZoomableImageKt {
    
    /**
     * A Composable function that displays a zoomable and pannable image.
     *
     * This function handles multi-touch gestures for zooming and panning. It's designed to be used
     * within a Pager to prevent the Pager from scrolling while the user is interacting with the image.
     */
    @androidx.compose.runtime.Composable()
    public static final void ZoomableImage(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.ImageBitmap bitmap, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, float minScale, float maxScale, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.layout.ContentScale contentScale, @org.jetbrains.annotations.Nullable()
    androidx.compose.foundation.pager.PagerState pagerState, boolean resetOnImageUpdate, boolean enabled, boolean twoFingerOnly, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super java.lang.Float, ? super java.lang.Float, ? super java.lang.Float, kotlin.Unit> onTransformed) {
    }
    
    /**
     * An extension function on [PagerState] to temporarily disable or enable scrolling.
     *
     * This function uses a [MutatePriority.PreventUserInput] scroll block to ensure that no other
     * scrolls (like the user swiping) can happen while this block is active.
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object setScrolling(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.pager.PagerState $this$setScrolling, boolean value, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}