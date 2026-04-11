package selfgemma.talk.customtasks.agentchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J.\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001a"}, d2 = {"Lselfgemma/talk/customtasks/agentchat/AgentChatTask;", "Lselfgemma/talk/customtasks/common/CustomTask;", "<init>", "()V", "agentTools", "Lselfgemma/talk/customtasks/agentchat/AgentTools;", "task", "Lselfgemma/talk/data/Task;", "getTask", "()Lselfgemma/talk/data/Task;", "initializeModelFn", "", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "model", "Lselfgemma/talk/data/Model;", "onDone", "Lkotlin/Function1;", "", "cleanUpModelFn", "Lkotlin/Function0;", "MainScreen", "data", "", "app_debug"})
public final class AgentChatTask implements selfgemma.talk.customtasks.common.CustomTask {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.customtasks.agentchat.AgentTools agentTools = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.Task task = null;
    
    @javax.inject.Inject()
    public AgentChatTask() {
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
}