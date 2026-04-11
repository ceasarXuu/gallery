package selfgemma.talk.common;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a!\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\b\"\u0006\b\u0000\u0010\t\u0018\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0086\b\u001a \u0010\u000b\u001a\u0004\u0018\u0001H\t\"\u0006\b\u0000\u0010\t\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0086\b\u00a2\u0006\u0002\u0010\f\u001a\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u001a\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002\u001a(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0002\u001a\u0016\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0014\u001a(\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0014\u001a\u0016\u0010&\u001a\u00020\"2\u0006\u0010\'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0014\u001a \u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0014H\u0002\u001a\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/\u001a\u0006\u00100\u001a\u000201\u001a\n\u00102\u001a\u000203*\u000203\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"TAG", "", "LOCAL_URL_BASE", "cleanUpMediapipeTaskErrorMessage", "message", "processLlmResponse", "response", "getJsonResponse", "Lselfgemma/talk/common/JsonObjAndTextContent;", "T", "url", "parseJson", "(Ljava/lang/String;)Ljava/lang/Object;", "convertWavToMonoWithMaxSeconds", "Lselfgemma/talk/common/AudioClip;", "context", "Landroid/content/Context;", "stereoUri", "Landroid/net/Uri;", "maxSeconds", "", "convert8BitTo16Bit", "", "eightBitData", "resample", "", "inputSamples", "originalSampleRate", "targetSampleRate", "channels", "calculatePeakAmplitude", "buffer", "bytesRead", "decodeSampledBitmapFromUri", "Landroid/graphics/Bitmap;", "uri", "reqWidth", "reqHeight", "rotateBitmap", "bitmap", "orientation", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "readFileToByteBuffer", "Ljava/nio/ByteBuffer;", "file", "Ljava/io/File;", "isPixel10", "", "clearFocusOnKeyboardDismiss", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class UtilsKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGUtils";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LOCAL_URL_BASE = "https://appassets.androidplatform.net";
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String cleanUpMediapipeTaskErrorMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String processLlmResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final selfgemma.talk.common.AudioClip convertWavToMonoWithMaxSeconds(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri stereoUri, int maxSeconds) {
        return null;
    }
    
    /**
     * Converts 8-bit unsigned PCM audio data to 16-bit signed PCM.
     */
    private static final byte[] convert8BitTo16Bit(byte[] eightBitData) {
        return null;
    }
    
    /**
     * Resamples PCM audio data from an original sample rate to a target sample rate.
     */
    private static final short[] resample(short[] inputSamples, int originalSampleRate, int targetSampleRate, int channels) {
        return null;
    }
    
    public static final int calculatePeakAmplitude(@org.jetbrains.annotations.NotNull()
    byte[] buffer, int bytesRead) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.Bitmap decodeSampledBitmapFromUri(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri, int reqWidth, int reqHeight) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.graphics.Bitmap rotateBitmap(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, int orientation) {
        return null;
    }
    
    private static final int calculateInSampleSize(android.graphics.BitmapFactory.Options options, int reqWidth, int reqHeight) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.nio.ByteBuffer readFileToByteBuffer(@org.jetbrains.annotations.NotNull()
    java.io.File file) {
        return null;
    }
    
    public static final boolean isPixel10() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.ui.Modifier clearFocusOnKeyboardDismiss(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier $this$clearFocusOnKeyboardDismiss) {
        return null;
    }
}