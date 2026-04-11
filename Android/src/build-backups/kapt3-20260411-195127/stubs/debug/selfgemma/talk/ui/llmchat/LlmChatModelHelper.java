package selfgemma.talk.ui.llmchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003Jf\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J@\u0010\u001c\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u001e\u0010\u001d\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u00dc\u0001\u0010\u001f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00062Q\u0010!\u001aM\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(\'\u0012\u0004\u0012\u00020\b0\"j\u0002`(2\u0010\u0010)\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\b0\u00132\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00172\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u000101H\u0016J\f\u00102\u001a\u00020/*\u00020-H\u0002J \u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u00107\u001a\u000208H\u0002R$\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lselfgemma/talk/ui/llmchat/LlmChatModelHelper;", "Lselfgemma/talk/runtime/LlmModelHelper;", "<init>", "()V", "cleanUpListeners", "", "", "Lkotlin/Function0;", "", "Lselfgemma/talk/runtime/CleanUpListener;", "initialize", "context", "Landroid/content/Context;", "model", "Lselfgemma/talk/data/Model;", "supportImage", "", "supportAudio", "onDone", "Lkotlin/Function1;", "systemInstruction", "Lcom/google/ai/edge/litertlm/Contents;", "tools", "", "Lcom/google/ai/edge/litertlm/ToolProvider;", "enableConversationConstrainedDecoding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "resetConversation", "cleanUp", "stopResponse", "runInference", "input", "resultListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "partialResult", "done", "partialThinkingResult", "Lselfgemma/talk/runtime/ResultListener;", "cleanUpListener", "onError", "message", "images", "Landroid/graphics/Bitmap;", "audioClips", "", "extraContext", "", "toPngByteArray", "createConversation", "Lcom/google/ai/edge/litertlm/Conversation;", "engine", "Lcom/google/ai/edge/litertlm/Engine;", "config", "Lcom/google/ai/edge/litertlm/ConversationConfig;", "app_debug"})
public final class LlmChatModelHelper implements selfgemma.talk.runtime.LlmModelHelper {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<java.lang.String, kotlin.jvm.functions.Function0<kotlin.Unit>> cleanUpListeners = null;
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.ui.llmchat.LlmChatModelHelper INSTANCE = null;
    
    private LlmChatModelHelper() {
        super();
    }
    
    @java.lang.Override()
    @kotlin.OptIn(markerClass = {com.google.ai.edge.litertlm.ExperimentalApi.class})
    public void initialize(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, boolean supportImage, boolean supportAudio, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDone, @org.jetbrains.annotations.Nullable()
    com.google.ai.edge.litertlm.Contents systemInstruction, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.ai.edge.litertlm.ToolProvider> tools, boolean enableConversationConstrainedDecoding, @org.jetbrains.annotations.Nullable()
    kotlinx.coroutines.CoroutineScope coroutineScope) {
    }
    
    @java.lang.Override()
    @kotlin.OptIn(markerClass = {com.google.ai.edge.litertlm.ExperimentalApi.class})
    public void resetConversation(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, boolean supportImage, boolean supportAudio, @org.jetbrains.annotations.Nullable()
    com.google.ai.edge.litertlm.Contents systemInstruction, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.ai.edge.litertlm.ToolProvider> tools, boolean enableConversationConstrainedDecoding) {
    }
    
    @java.lang.Override()
    public void cleanUp(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    @java.lang.Override()
    public void stopResponse(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
    }
    
    @java.lang.Override()
    public void runInference(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String input, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> resultListener, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> cleanUpListener, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError, @org.jetbrains.annotations.NotNull()
    java.util.List<android.graphics.Bitmap> images, @org.jetbrains.annotations.NotNull()
    java.util.List<byte[]> audioClips, @org.jetbrains.annotations.Nullable()
    kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, java.lang.String> extraContext) {
    }
    
    private final byte[] toPngByteArray(android.graphics.Bitmap $this$toPngByteArray) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {com.google.ai.edge.litertlm.ExperimentalApi.class})
    private final com.google.ai.edge.litertlm.Conversation createConversation(com.google.ai.edge.litertlm.Engine engine, boolean enableConversationConstrainedDecoding, com.google.ai.edge.litertlm.ConversationConfig config) {
        return null;
    }
}