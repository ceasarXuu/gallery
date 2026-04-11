package selfgemma.talk.ui.common.textandvoiceinput;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J.\u0010\u001a\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\u0015J\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\u0017J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0016J\u0012\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\u0010\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0017H\u0016J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0019H\u0016J\u0012\u00100\u001a\u00020\u00172\b\u00101\u001a\u0004\u0018\u00010%H\u0016J\u0012\u00102\u001a\u00020\u00172\b\u00103\u001a\u0004\u0018\u00010%H\u0016J\u001a\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lselfgemma/talk/ui/common/textandvoiceinput/HoldToDictateViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroid/speech/RecognitionListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lselfgemma/talk/ui/common/textandvoiceinput/HoldToDictateUiState;", "get_uiState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "speechRecognizer", "Landroid/speech/SpeechRecognizer;", "recognizerIntent", "Landroid/content/Intent;", "onRecognitionDone", "Lkotlin/Function1;", "", "", "onAmplitudeChanged", "", "startSpeechRecognition", "onDone", "stopSpeechRecognition", "cancelSpeechRecognition", "setRecognizing", "recognizing", "", "setRecognizedText", "text", "onReadyForSpeech", "params", "Landroid/os/Bundle;", "onBeginningOfSpeech", "onRmsChanged", "rmsdB", "", "onBufferReceived", "buffer", "", "onEndOfSpeech", "onError", "error", "onResults", "results", "onPartialResults", "partialResults", "onEvent", "eventType", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HoldToDictateViewModel extends androidx.lifecycle.ViewModel implements android.speech.RecognitionListener {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.ui.common.textandvoiceinput.HoldToDictateUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.ui.common.textandvoiceinput.HoldToDictateUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final android.speech.SpeechRecognizer speechRecognizer = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Intent recognizerIntent = null;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onRecognitionDone;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onAmplitudeChanged;
    
    @javax.inject.Inject()
    public HoldToDictateViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.ui.common.textandvoiceinput.HoldToDictateUiState> get_uiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.ui.common.textandvoiceinput.HoldToDictateUiState> getUiState() {
        return null;
    }
    
    public final void startSpeechRecognition(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDone, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onAmplitudeChanged) {
    }
    
    public final void stopSpeechRecognition() {
    }
    
    public final void cancelSpeechRecognition() {
    }
    
    public final void setRecognizing(boolean recognizing) {
    }
    
    public final void setRecognizedText(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    @java.lang.Override()
    public void onReadyForSpeech(@org.jetbrains.annotations.Nullable()
    android.os.Bundle params) {
    }
    
    @java.lang.Override()
    public void onBeginningOfSpeech() {
    }
    
    @java.lang.Override()
    public void onRmsChanged(float rmsdB) {
    }
    
    @java.lang.Override()
    public void onBufferReceived(@org.jetbrains.annotations.Nullable()
    byte[] buffer) {
    }
    
    @java.lang.Override()
    public void onEndOfSpeech() {
    }
    
    @java.lang.Override()
    public void onError(int error) {
    }
    
    @java.lang.Override()
    public void onResults(@org.jetbrains.annotations.Nullable()
    android.os.Bundle results) {
    }
    
    @java.lang.Override()
    public void onPartialResults(@org.jetbrains.annotations.Nullable()
    android.os.Bundle partialResults) {
    }
    
    @java.lang.Override()
    public void onEvent(int eventType, @org.jetbrains.annotations.Nullable()
    android.os.Bundle params) {
    }
}