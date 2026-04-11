package selfgemma.talk.customtasks.mobileactions;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010\"\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0010JU\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u001b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130-2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00130/J\u001e\u00103\u001a\u0004\u0018\u00010\u001b2\u0006\u0010&\u001a\u00020\'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*JO\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u00106\u001a\u0002072!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00130/J\u0016\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020:2\u0006\u00105\u001a\u00020\u0003J\u0018\u0010;\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u0010H\u0002J0\u0010=\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u001bH\u0002J(\u0010B\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u001bH\u0002J\u0018\u0010F\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u001bH\u0002J\u0010\u0010H\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u0003H\u0002J \u0010I\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lselfgemma/talk/customtasks/mobileactions/MobileActionsViewModel;", "Landroidx/lifecycle/ViewModel;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lselfgemma/talk/customtasks/mobileactions/MobileActionsUiState;", "get_uiState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_isResettingConversation", "", "isResettingConversation", "reset", "", "cleanUp", "setShowWelcomeMessage", "showWelcomeMessage", "setProcessing", "processing", "setUserPrompt", "prompt", "", "setModelResponse", "response", "appendModelResponse", "partialResponse", "addFunctionCallDetails", "details", "clearFunctionCallDetails", "setNoFunctionRecognized", "value", "processUserPrompt", "model", "Lselfgemma/talk/data/Model;", "userPrompt", "tools", "", "Lcom/google/ai/edge/litertlm/ToolProvider;", "onProcessDone", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "error", "resetConversation", "resetEngine", "context", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "performAction", "action", "Lselfgemma/talk/customtasks/mobileactions/Action;", "setFlashlight", "isEnabled", "createContact", "firstName", "lastName", "phoneNumber", "email", "sendEmail", "to", "subject", "body", "showLocationOnMap", "location", "openWifiSettings", "createCalendarEvent", "datetime", "title", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MobileActionsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.customtasks.mobileactions.MobileActionsUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.customtasks.mobileactions.MobileActionsUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isResettingConversation = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isResettingConversation = null;
    
    @javax.inject.Inject()
    public MobileActionsViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context appContext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.customtasks.mobileactions.MobileActionsUiState> get_uiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.customtasks.mobileactions.MobileActionsUiState> getUiState() {
        return null;
    }
    
    public final void reset() {
    }
    
    public final void cleanUp() {
    }
    
    public final void setShowWelcomeMessage(boolean showWelcomeMessage) {
    }
    
    public final void setProcessing(boolean processing) {
    }
    
    public final void setUserPrompt(@org.jetbrains.annotations.NotNull()
    java.lang.String prompt) {
    }
    
    public final void setModelResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    public final void appendModelResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String partialResponse) {
    }
    
    public final void addFunctionCallDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String details) {
    }
    
    public final void clearFunctionCallDetails() {
    }
    
    public final void setNoFunctionRecognized(boolean value) {
    }
    
    public final void processUserPrompt(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String userPrompt, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.ai.edge.litertlm.ToolProvider> tools, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onProcessDone, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String resetConversation(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.ai.edge.litertlm.ToolProvider> tools) {
        return null;
    }
    
    public final void resetEngine(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.ai.edge.litertlm.ToolProvider> tools, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String performAction(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.customtasks.mobileactions.Action action, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    private final java.lang.String setFlashlight(android.content.Context context, boolean isEnabled) {
        return null;
    }
    
    private final java.lang.String createContact(android.content.Context context, java.lang.String firstName, java.lang.String lastName, java.lang.String phoneNumber, java.lang.String email) {
        return null;
    }
    
    private final java.lang.String sendEmail(android.content.Context context, java.lang.String to, java.lang.String subject, java.lang.String body) {
        return null;
    }
    
    private final java.lang.String showLocationOnMap(android.content.Context context, java.lang.String location) {
        return null;
    }
    
    private final java.lang.String openWifiSettings(android.content.Context context) {
        return null;
    }
    
    private final java.lang.String createCalendarEvent(android.content.Context context, java.lang.String datetime, java.lang.String title) {
        return null;
    }
}