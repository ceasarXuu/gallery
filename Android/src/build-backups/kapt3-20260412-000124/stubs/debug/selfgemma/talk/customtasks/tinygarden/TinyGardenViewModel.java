package selfgemma.talk.customtasks.tinygarden;

/**
 * The ViewModel of the task screen.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J>\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00170\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00170\u001dJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0017J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0014J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0014J\u0006\u0010\'\u001a\u00020\u0017J\u0006\u0010(\u001a\u00020\u0017JG\u0010)\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00170\u001dJL\u00100\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001b2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lselfgemma/talk/customtasks/tinygarden/TinyGardenViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "dataStoreRepository", "Lselfgemma/talk/data/DataStoreRepository;", "<init>", "(Landroid/content/Context;Lselfgemma/talk/data/DataStoreRepository;)V", "getDataStoreRepository", "()Lselfgemma/talk/data/DataStoreRepository;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lselfgemma/talk/customtasks/tinygarden/TinyGardenUiState;", "get_uiState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_isResettingConversation", "", "isResettingConversation", "getCommand", "", "model", "Lselfgemma/talk/data/Model;", "instructionText", "", "onDone", "Lkotlin/Function1;", "onError", "addMessage", "message", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "clearMessages", "setProcessing", "processing", "setResettingEngine", "resetting", "incrementNumTurns", "resetNumTurns", "resetEngine", "tools", "", "Lcom/google/ai/edge/litertlm/ToolProvider;", "Lkotlin/ParameterName;", "name", "error", "resetConversation", "prevSeed", "prevPlots", "prevAction", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class TinyGardenViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DataStoreRepository dataStoreRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.customtasks.tinygarden.TinyGardenUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.customtasks.tinygarden.TinyGardenUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isResettingConversation = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isResettingConversation = null;
    
    @javax.inject.Inject()
    public TinyGardenViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DataStoreRepository dataStoreRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.DataStoreRepository getDataStoreRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.customtasks.tinygarden.TinyGardenUiState> get_uiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.customtasks.tinygarden.TinyGardenUiState> getUiState() {
        return null;
    }
    
    /**
     * Sends the user instruction to the model and processes the response.
     *
     * The tools defined in [TinyGardenTools] will be invoked during the process.
     */
    public final void getCommand(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String instructionText, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDone, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    public final void addMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessage message) {
    }
    
    public final void clearMessages() {
    }
    
    public final void setProcessing(boolean processing) {
    }
    
    public final void setResettingEngine(boolean resetting) {
    }
    
    public final void incrementNumTurns() {
    }
    
    public final void resetNumTurns() {
    }
    
    public final void resetEngine(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.ai.edge.litertlm.ToolProvider> tools, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    public final void resetConversation(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.ai.edge.litertlm.ToolProvider> tools, @org.jetbrains.annotations.NotNull()
    java.lang.String prevSeed, @org.jetbrains.annotations.NotNull()
    java.lang.String prevPlots, @org.jetbrains.annotations.NotNull()
    java.lang.String prevAction, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
}