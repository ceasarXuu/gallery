package selfgemma.talk.customtasks.tinygarden;

/**
 * A custom task that demonstrates how to use FunctionGemma to play a simple gardening game.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0019H\u0016J.\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J\b\u0010 \u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006!"}, d2 = {"Lselfgemma/talk/customtasks/tinygarden/TinyGardenTask;", "Lselfgemma/talk/customtasks/common/CustomTask;", "<init>", "()V", "_updateChannel", "Lkotlinx/coroutines/channels/Channel;", "Lselfgemma/talk/customtasks/tinygarden/TinyGardenCommand;", "commandFlow", "Lkotlinx/coroutines/flow/Flow;", "tools", "", "Lcom/google/ai/edge/litertlm/ToolProvider;", "task", "Lselfgemma/talk/data/Task;", "getTask", "()Lselfgemma/talk/data/Task;", "initializeModelFn", "", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "model", "Lselfgemma/talk/data/Model;", "onDone", "Lkotlin/Function1;", "", "cleanUpModelFn", "Lkotlin/Function0;", "MainScreen", "data", "", "clearQueue", "app_debug"})
public final class TinyGardenTask implements selfgemma.talk.customtasks.common.CustomTask {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<selfgemma.talk.customtasks.tinygarden.TinyGardenCommand> _updateChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<selfgemma.talk.customtasks.tinygarden.TinyGardenCommand> commandFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.google.ai.edge.litertlm.ToolProvider> tools = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.Task task = null;
    
    @javax.inject.Inject()
    public TinyGardenTask() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.data.Task getTask() {
        return null;
    }
    
    @java.lang.Override()
    public void initializeModelFn(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDone) {
    }
    
    @java.lang.Override()
    public void cleanUpModelFn(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    @java.lang.Override()
    @androidx.compose.runtime.Composable()
    public void MainScreen(@org.jetbrains.annotations.NotNull()
    java.lang.Object data) {
    }
    
    private final void clearQueue() {
    }
}