package selfgemma.talk.runtime;

/**
 * Base interface for all LLM runtimes. It defines the foundational operations needed to initialize,
 * manage conversations, execute inferences, and clean up resources for different Large Language
 * Model backends.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jn\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&JJ\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\tH&J\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H&J\u00e6\u0001\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\r2Q\u0010\u001b\u001aM\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00030\u001cj\u0002`\"2\u0010\u0010#\u001a\f\u0012\u0004\u0012\u00020\u00030\u0018j\u0002`$2#\b\u0002\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00030\f2\u000e\b\u0002\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\u00112\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010,H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006.\u00c0\u0006\u0003"}, d2 = {"Lselfgemma/talk/runtime/LlmModelHelper;", "", "initialize", "", "context", "Landroid/content/Context;", "model", "Lselfgemma/talk/data/Model;", "supportImage", "", "supportAudio", "onDone", "Lkotlin/Function1;", "", "systemInstruction", "Lcom/google/ai/edge/litertlm/Contents;", "tools", "", "Lcom/google/ai/edge/litertlm/ToolProvider;", "enableConversationConstrainedDecoding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "resetConversation", "cleanUp", "Lkotlin/Function0;", "runInference", "input", "resultListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "partialResult", "done", "partialThinkingResult", "Lselfgemma/talk/runtime/ResultListener;", "cleanUpListener", "Lselfgemma/talk/runtime/CleanUpListener;", "onError", "message", "images", "Landroid/graphics/Bitmap;", "audioClips", "", "extraContext", "", "stopResponse", "app_debug"})
public abstract interface LlmModelHelper {
    
    /**
     * Initializes the LLM runtime with the specified configuration.
     *
     * @param context the application context.
     * @param model the model to be initialized.
     * @param supportImage whether to support image input.
     * @param supportAudio whether to support audio input.
     * @param onDone callback invoked when initialization is completed successfully.
     * @param systemInstruction instruction provided to guide the model's behavior.
     * @param tools tools available for the model to use.
     * @param enableConversationConstrainedDecoding whether to enable constrained decoding for
     *  conversations.
     * @param coroutineScope optional coroutine scope for async execution.
     */
    public abstract void initialize(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, boolean supportImage, boolean supportAudio, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDone, @org.jetbrains.annotations.Nullable()
    com.google.ai.edge.litertlm.Contents systemInstruction, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.ai.edge.litertlm.ToolProvider> tools, boolean enableConversationConstrainedDecoding, @org.jetbrains.annotations.Nullable()
    kotlinx.coroutines.CoroutineScope coroutineScope);
    
    /**
     * Resets the conversation context for the specified model.
     *
     * @param model the model whose conversation context needs to be reset.
     * @param supportImage whether to preserve support for image input.
     * @param supportAudio whether to preserve support for audio input.
     * @param systemInstruction new system instruction to guide the model's behavior after reset.
     * @param tools new or updated tools available for the model.
     * @param enableConversationConstrainedDecoding whether to enable constrained decoding.
     */
    public abstract void resetConversation(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, boolean supportImage, boolean supportAudio, @org.jetbrains.annotations.Nullable()
    com.google.ai.edge.litertlm.Contents systemInstruction, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.ai.edge.litertlm.ToolProvider> tools, boolean enableConversationConstrainedDecoding);
    
    /**
     * Cleans up resources occupied by the model.
     *
     * @param model the model whose resources should be cleaned up.
     * @param onDone callback invoked when clean up completes.
     */
    public abstract void cleanUp(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone);
    
    /**
     * Runs an inference pass on the specified model.
     *
     * @param model the model to run inference on.
     * @param input the input text for inference.
     * @param resultListener callback invoked with partial inference results.
     * @param cleanUpListener callback invoked to trigger necessary cleanup.
     * @param onError callback invoked if an error occurs during inference.
     * @param images optional list of images provided as input context.
     * @param audioClips optional list of audio clips provided as input context.
     * @param coroutineScope optional coroutine scope for async inference execution.
     * @param extraContext optional extra context for inference.
     */
    public abstract void runInference(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String input, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> resultListener, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> cleanUpListener, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError, @org.jetbrains.annotations.NotNull()
    java.util.List<android.graphics.Bitmap> images, @org.jetbrains.annotations.NotNull()
    java.util.List<byte[]> audioClips, @org.jetbrains.annotations.Nullable()
    kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, java.lang.String> extraContext);
    
    /**
     * Stops the ongoing response generation for the model.
     *
     * @param model the ongoing model response to be stopped.
     */
    public abstract void stopResponse(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model);
    
    /**
     * Base interface for all LLM runtimes. It defines the foundational operations needed to initialize,
     * manage conversations, execute inferences, and clean up resources for different Large Language
     * Model backends.
     */
    @kotlin.Metadata(mv = {2, 2, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}