package selfgemma.talk.ui.common.chat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0007\u001a2\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0003\u001aP\u0010\u0016\u001a\u00020\b2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b0\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dH\u0082@\u00a2\u0006\u0002\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u00020\b2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0002\u001a\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"TAG", "", "BAR_SPACE", "", "BAR_WIDTH", "MIN_BAR_COUNT", "MAX_BAR_COUNT", "AudioPlaybackPanel", "", "audioData", "", "sampleRate", "isRecording", "", "modifier", "Landroidx/compose/ui/Modifier;", "onDarkBg", "AmplitudeBarGraph", "amplitudeLevels", "", "", "progress", "playAudio", "audioTrackState", "Landroidx/compose/runtime/MutableState;", "Landroid/media/AudioTrack;", "onProgress", "Lkotlin/Function1;", "onCompletion", "Lkotlin/Function0;", "(Landroidx/compose/runtime/MutableState;[BILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopPlayAudio", "generateAmplitudeLevels", "barCount", "app_debug"})
public final class AudioPlaybackPanelKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGAudioPlaybackPanel";
    private static final int BAR_SPACE = 2;
    private static final int BAR_WIDTH = 2;
    private static final int MIN_BAR_COUNT = 16;
    private static final int MAX_BAR_COUNT = 48;
    
    /**
     * A Composable that displays an audio playback panel, including play/stop controls, a waveform
     * visualization, and the duration of the audio clip.
     */
    @androidx.compose.runtime.Composable()
    public static final void AudioPlaybackPanel(@org.jetbrains.annotations.NotNull()
    byte[] audioData, int sampleRate, boolean isRecording, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, boolean onDarkBg) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void AmplitudeBarGraph(java.util.List<java.lang.Float> amplitudeLevels, float progress, androidx.compose.ui.Modifier modifier, boolean onDarkBg) {
    }
    
    private static final java.lang.Object playAudio(androidx.compose.runtime.MutableState<android.media.AudioTrack> audioTrackState, byte[] audioData, int sampleRate, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onProgress, kotlin.jvm.functions.Function0<kotlin.Unit> onCompletion, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private static final void stopPlayAudio(androidx.compose.runtime.MutableState<android.media.AudioTrack> audioTrackState) {
    }
    
    /**
     * Processes a raw PCM 16-bit audio byte array to generate a list of normalized amplitude levels for
     * visualization.
     */
    private static final java.util.List<java.lang.Float> generateAmplitudeLevels(byte[] audioData, int barCount) {
        return null;
    }
}