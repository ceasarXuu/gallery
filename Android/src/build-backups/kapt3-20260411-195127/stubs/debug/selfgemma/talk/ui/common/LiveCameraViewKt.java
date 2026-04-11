package selfgemma.talk.ui.common;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001aP\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0082@\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"LiveCameraView", "", "onBitmap", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "Landroidx/camera/core/ImageProxy;", "modifier", "Landroidx/compose/ui/Modifier;", "preferredSize", "", "outputImageFormat", "renderPreview", "", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "startCamera", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function2;IILandroidx/camera/core/CameraSelector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class LiveCameraViewKt {
    
    @androidx.compose.runtime.Composable()
    public static final void LiveCameraView(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super android.graphics.Bitmap, ? super androidx.camera.core.ImageProxy, kotlin.Unit> onBitmap, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, int preferredSize, @androidx.camera.core.ImageAnalysis.OutputImageFormat()
    int outputImageFormat, boolean renderPreview, @org.jetbrains.annotations.NotNull()
    androidx.camera.core.CameraSelector cameraSelector) {
    }
    
    /**
     * Asynchronously initializes and starts the camera for image capture and analysis.
     */
    private static final java.lang.Object startCamera(android.content.Context context, androidx.lifecycle.LifecycleOwner lifecycleOwner, kotlin.jvm.functions.Function2<? super android.graphics.Bitmap, ? super androidx.camera.core.ImageProxy, kotlin.Unit> onBitmap, int preferredSize, @androidx.camera.core.ImageAnalysis.OutputImageFormat()
    int outputImageFormat, androidx.camera.core.CameraSelector cameraSelector, kotlin.coroutines.Continuation<? super androidx.camera.lifecycle.ProcessCameraProvider> $completion) {
        return null;
    }
}