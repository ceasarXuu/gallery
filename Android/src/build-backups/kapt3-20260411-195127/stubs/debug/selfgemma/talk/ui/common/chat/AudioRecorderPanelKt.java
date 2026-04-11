package selfgemma.talk.ui.common.chat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aP\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007\u001aX\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0083@\u00a2\u0006\u0002\u0010\u001e\u001a \u0010\u001f\u001a\u00020\u000e2\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"TAG", "", "CHANNEL_CONFIG", "", "AUDIO_FORMAT", "PANEL_ALPHA", "", "AudioRecorderPanel", "", "task", "Lselfgemma/talk/data/Task;", "onAmplitudeChanged", "Lkotlin/Function1;", "onSendAudioClip", "", "onClose", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "startRecording", "context", "Landroid/content/Context;", "audioRecordState", "Landroidx/compose/runtime/MutableState;", "Landroid/media/AudioRecord;", "audioStream", "Ljava/io/ByteArrayOutputStream;", "elapsedMs", "Landroidx/compose/runtime/MutableLongState;", "onMaxDurationReached", "(Landroid/content/Context;Landroidx/compose/runtime/MutableState;Ljava/io/ByteArrayOutputStream;Landroidx/compose/runtime/MutableLongState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopRecording", "app_debug"})
public final class AudioRecorderPanelKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGAudioRecorderPanel";
    private static final int CHANNEL_CONFIG = android.media.AudioFormat.CHANNEL_IN_MONO;
    private static final int AUDIO_FORMAT = android.media.AudioFormat.ENCODING_PCM_16BIT;
    private static final float PANEL_ALPHA = 0.7F;
    
    /**
     * This composable function creates a UI panel for audio recording. It handles the UI state (e.g.,
     * recording vs. idle) and manages the audio recording lifecycle.
     *
     * The panel displays different content based on the recording state:
     * - When idle, it shows a "Tap to record" message and a microphone icon.
     * - When recording, it shows a red indicator, elapsed time, and an "up arrow" icon button to send
     *  the clip.
     *
     * Tapping the record button starts a coroutine to handle audio capture on a background thread.
     * Tapping the "up arrow" button stops the recording, passes the audio data via the onSendAudioClip
     * callback, and resets the state.
     *
     * A DisposableEffect is used to ensure the AudioRecord resource is properly released when the
     * composable is removed from the UI hierarchy.
     */
    @androidx.compose.runtime.Composable()
    public static final void AudioRecorderPanel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onAmplitudeChanged, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super byte[], kotlin.Unit> onSendAudioClip, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClose, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private static final java.lang.Object startRecording(android.content.Context context, androidx.compose.runtime.MutableState<android.media.AudioRecord> audioRecordState, java.io.ByteArrayOutputStream audioStream, androidx.compose.runtime.MutableLongState elapsedMs, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onAmplitudeChanged, kotlin.jvm.functions.Function0<kotlin.Unit> onMaxDurationReached, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private static final byte[] stopRecording(androidx.compose.runtime.MutableState<android.media.AudioRecord> audioRecordState, java.io.ByteArrayOutputStream audioStream) {
        return null;
    }
}