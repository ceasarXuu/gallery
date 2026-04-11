package selfgemma.talk.ui.modelmanager;

/**
 * ViewModel responsible for managing models, their download status, and initialization.
 *
 * This ViewModel handles model-related operations such as downloading, deleting, initializing, and
 * cleaning up models. It also manages the UI state for model management, including the list of
 * tasks, models, download statuses, and initialization statuses.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u00fc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B>\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0011\u0010\b\u001a\r\u0012\t\u0012\u00070\n\u00a2\u0006\u0002\b\u000b0\t\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\'\u001a\u00020(H\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\"J\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020*0-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0\tJ\u0010\u0010/\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020\"J\f\u00100\u001a\b\u0012\u0004\u0012\u00020\n0-J\b\u00101\u001a\u0004\u0018\u000102J\u0010\u00103\u001a\u0004\u0018\u0001022\u0006\u00104\u001a\u00020\"J\f\u00105\u001a\b\u0012\u0004\u0012\u0002020-J\f\u00106\u001a\b\u0012\u0004\u0012\u0002020-J\u0006\u00107\u001a\u00020(J\u0006\u00108\u001a\u00020(J\u0006\u00109\u001a\u00020(J\u000e\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u000202J\u0018\u0010<\u001a\u00020(2\b\u0010=\u001a\u0004\u0018\u00010*2\u0006\u0010;\u001a\u000202J\u000e\u0010>\u001a\u00020(2\u0006\u0010;\u001a\u000202J\u000e\u0010?\u001a\u00020(2\u0006\u0010;\u001a\u000202J8\u0010@\u001a\u00020(2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010=\u001a\u00020*2\u0006\u0010;\u001a\u0002022\b\b\u0002\u0010A\u001a\u00020B2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020(0DJ:\u0010E\u001a\u00020(2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010=\u001a\u00020*2\u0006\u0010;\u001a\u0002022\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020(0DJ\u0016\u0010H\u001a\u00020(2\u0006\u0010I\u001a\u0002022\u0006\u0010J\u001a\u00020KJ\u0016\u0010L\u001a\u00020(2\u0006\u0010;\u001a\u0002022\u0006\u0010J\u001a\u00020MJ\u000e\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020\"J\u000e\u0010P\u001a\u00020(2\u0006\u0010O\u001a\u00020\"J\u000e\u0010Q\u001a\u00020(2\u0006\u0010O\u001a\u00020\"J\u0006\u0010R\u001a\u00020(J\u0006\u0010S\u001a\u00020TJ\u000e\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020TJ\u000e\u0010W\u001a\u00020(2\u0006\u0010X\u001a\u00020BJ\u0006\u0010Y\u001a\u00020BJ\u000e\u0010Z\u001a\u00020(2\u0006\u0010X\u001a\u00020BJ\u0006\u0010[\u001a\u00020BJ\u001a\u0010\\\u001a\u00020]2\u0006\u0010;\u001a\u0002022\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\"J\u000e\u0010_\u001a\u00020(2\u0006\u0010`\u001a\u00020aJ\u0006\u0010b\u001a\u00020cJ\u0006\u0010d\u001a\u00020eJ\"\u0010f\u001a\u00020(2\u0006\u0010g\u001a\u00020h2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020(0jJ\u001e\u0010l\u001a\u00020(2\u0006\u0010^\u001a\u00020\"2\u0006\u0010m\u001a\u00020\"2\u0006\u0010n\u001a\u00020oJ\u0006\u0010p\u001a\u00020(J\b\u0010q\u001a\u00020(H\u0002J\u0006\u0010r\u001a\u00020(J\u0006\u0010s\u001a\u00020(J\u000e\u0010t\u001a\u00020(2\u0006\u0010u\u001a\u00020BJ\u0010\u0010v\u001a\u00020(2\u0006\u0010w\u001a\u00020\"H\u0002J\u0014\u0010x\u001a\u0004\u0018\u00010y2\b\b\u0002\u0010z\u001a\u00020\"H\u0002J\u0010\u0010{\u001a\u00020B2\u0006\u0010;\u001a\u000202H\u0002J\b\u0010|\u001a\u00020\u0016H\u0002J\b\u0010}\u001a\u00020\u0016H\u0002J\u0010\u0010~\u001a\u0002022\u0006\u0010`\u001a\u00020aH\u0002J\u001b\u0010\u007f\u001a\u0015\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0-0\u0080\u0001H\u0002J\t\u0010\u0081\u0001\u001a\u00020(H\u0002J\u001b\u0010\u0082\u0001\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u0011\u0010\u0085\u0001\u001a\u00020K2\u0006\u0010;\u001a\u000202H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020B2\u0006\u0010z\u001a\u00020\"H\u0002J\u0011\u0010\u0087\u0001\u001a\u00020B2\u0006\u0010z\u001a\u00020\"H\u0002J\u0011\u0010\u0088\u0001\u001a\u00020(2\u0006\u0010z\u001a\u00020\"H\u0002J\u0011\u0010\u0089\u0001\u001a\u00020(2\u0006\u0010z\u001a\u00020\"H\u0002J\u0012\u0010\u008a\u0001\u001a\u00020(2\u0007\u0010\u008b\u0001\u001a\u00020\"H\u0002J%\u0010\u008c\u0001\u001a\u00020(2\u0006\u0010;\u001a\u0002022\u0007\u0010J\u001a\u00030\u008d\u00012\t\b\u0002\u0010\u008e\u0001\u001a\u00020\"H\u0002J\u0011\u0010\u008f\u0001\u001a\u00020B2\u0006\u0010;\u001a\u000202H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\r\u0012\t\u0012\u00070\n\u00a2\u0006\u0002\b\u000b0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006\u0090\u0001"}, d2 = {"Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "Landroidx/lifecycle/ViewModel;", "downloadRepository", "Lselfgemma/talk/data/DownloadRepository;", "dataStoreRepository", "Lselfgemma/talk/data/DataStoreRepository;", "lifecycleProvider", "Lselfgemma/talk/AppLifecycleProvider;", "customTasks", "", "Lselfgemma/talk/customtasks/common/CustomTask;", "Lkotlin/jvm/JvmSuppressWildcards;", "context", "Landroid/content/Context;", "<init>", "(Lselfgemma/talk/data/DownloadRepository;Lselfgemma/talk/data/DataStoreRepository;Lselfgemma/talk/AppLifecycleProvider;Ljava/util/Set;Landroid/content/Context;)V", "getDataStoreRepository", "()Lselfgemma/talk/data/DataStoreRepository;", "externalFilesDir", "Ljava/io/File;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lselfgemma/talk/ui/modelmanager/ModelManagerUiState;", "get_uiState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "authService", "Lnet/openid/appauth/AuthorizationService;", "getAuthService", "()Lnet/openid/appauth/AuthorizationService;", "curAccessToken", "", "getCurAccessToken", "()Ljava/lang/String;", "setCurAccessToken", "(Ljava/lang/String;)V", "onCleared", "", "getTaskById", "Lselfgemma/talk/data/Task;", "id", "getTasksByIds", "", "ids", "getCustomTaskByTaskId", "getActiveCustomTasks", "getSelectedModel", "Lselfgemma/talk/data/Model;", "getModelByName", "name", "getAllModels", "getAllDownloadedModels", "processTasks", "updateConfigValuesUpdateTrigger", "updateSettingsUpdateTrigger", "selectModel", "model", "downloadModel", "task", "cancelDownloadModel", "deleteModel", "initializeModel", "force", "", "onDone", "Lkotlin/Function0;", "cleanupModel", "instanceToCleanUp", "", "setDownloadStatus", "curModel", "status", "Lselfgemma/talk/data/ModelDownloadStatus;", "setInitializationStatus", "Lselfgemma/talk/ui/modelmanager/ModelInitializationStatus;", "addTextInputHistory", "text", "promoteTextInputHistoryItem", "deleteTextInputHistory", "clearTextInputHistory", "readThemeOverride", "Lselfgemma/talk/proto/Theme;", "saveThemeOverride", "theme", "setLiveTokenSpeedEnabled", "enabled", "isLiveTokenSpeedEnabled", "setStreamingOutputEnabled", "isStreamingOutputEnabled", "getModelUrlResponse", "", "accessToken", "addImportedLlmModel", "info", "Lselfgemma/talk/proto/ImportedModel;", "getTokenStatusAndData", "Lselfgemma/talk/ui/modelmanager/TokenStatusAndData;", "getAuthorizationRequest", "Lnet/openid/appauth/AuthorizationRequest;", "handleAuthResult", "result", "Landroidx/activity/result/ActivityResult;", "onTokenRequested", "Lkotlin/Function1;", "Lselfgemma/talk/ui/modelmanager/TokenRequestResult;", "saveAccessToken", "refreshToken", "expiresAt", "", "clearAccessToken", "processPendingDownloads", "loadModelAllowlist", "clearLoadModelAllowlistError", "setAppInForeground", "foreground", "saveModelAllowlistToDisk", "modelAllowlistContent", "readModelAllowlistFromDisk", "Lselfgemma/talk/data/ModelAllowlist;", "fileName", "isModelPartiallyDownloaded", "createEmptyUiState", "createUiState", "createModelFromImportedModelInfo", "groupTasksByCategory", "", "preloadLastUsedLlmModel", "getCategoryLabel", "category", "Lselfgemma/talk/data/CategoryInfo;", "getModelDownloadStatus", "isFileInExternalFilesDir", "isFileInDataLocalTmpDir", "deleteFileFromExternalFilesDir", "deleteFilesFromImportDir", "deleteDirFromExternalFilesDir", "dir", "updateModelInitializationStatus", "Lselfgemma/talk/ui/modelmanager/ModelInitializationStatusType;", "error", "isModelDownloaded", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public class ModelManagerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DownloadRepository downloadRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DataStoreRepository dataStoreRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.AppLifecycleProvider lifecycleProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<selfgemma.talk.customtasks.common.CustomTask> customTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private final java.io.File externalFilesDir = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.ui.modelmanager.ModelManagerUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.ui.modelmanager.ModelManagerUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final net.openid.appauth.AuthorizationService authService = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String curAccessToken = "";
    
    @javax.inject.Inject()
    public ModelManagerViewModel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DownloadRepository downloadRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DataStoreRepository dataStoreRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.AppLifecycleProvider lifecycleProvider, @org.jetbrains.annotations.NotNull()
    java.util.Set<selfgemma.talk.customtasks.common.CustomTask> customTasks, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.DataStoreRepository getDataStoreRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.ui.modelmanager.ModelManagerUiState> get_uiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.ui.modelmanager.ModelManagerUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.openid.appauth.AuthorizationService getAuthService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurAccessToken() {
        return null;
    }
    
    public final void setCurAccessToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.data.Task getTaskById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.Task> getTasksByIds(@org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> ids) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.customtasks.common.CustomTask getCustomTaskByTaskId(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.customtasks.common.CustomTask> getActiveCustomTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.data.Model getSelectedModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.data.Model getModelByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.Model> getAllModels() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.Model> getAllDownloadedModels() {
        return null;
    }
    
    public final void processTasks() {
    }
    
    public final void updateConfigValuesUpdateTrigger() {
    }
    
    public final void updateSettingsUpdateTrigger() {
    }
    
    public final void selectModel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
    }
    
    public final void downloadModel(@org.jetbrains.annotations.Nullable()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
    }
    
    public final void cancelDownloadModel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
    }
    
    public final void deleteModel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
    }
    
    public final void initializeModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, boolean force, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    public final void cleanupModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.Nullable()
    java.lang.Object instanceToCleanUp, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    public final void setDownloadStatus(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model curModel, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.ModelDownloadStatus status) {
    }
    
    public final void setInitializationStatus(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelInitializationStatus status) {
    }
    
    public final void addTextInputHistory(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void promoteTextInputHistoryItem(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void deleteTextInputHistory(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void clearTextInputHistory() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.proto.Theme readThemeOverride() {
        return null;
    }
    
    public final void saveThemeOverride(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.Theme theme) {
    }
    
    public final void setLiveTokenSpeedEnabled(boolean enabled) {
    }
    
    public final boolean isLiveTokenSpeedEnabled() {
        return false;
    }
    
    public final void setStreamingOutputEnabled(boolean enabled) {
    }
    
    public final boolean isStreamingOutputEnabled() {
        return false;
    }
    
    public final int getModelUrlResponse(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.Nullable()
    java.lang.String accessToken) {
        return 0;
    }
    
    public final void addImportedLlmModel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.ImportedModel info) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.modelmanager.TokenStatusAndData getTokenStatusAndData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.openid.appauth.AuthorizationRequest getAuthorizationRequest() {
        return null;
    }
    
    public final void handleAuthResult(@org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResult result, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.ui.modelmanager.TokenRequestResult, kotlin.Unit> onTokenRequested) {
    }
    
    public final void saveAccessToken(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    java.lang.String refreshToken, long expiresAt) {
    }
    
    public final void clearAccessToken() {
    }
    
    private final void processPendingDownloads() {
    }
    
    public final void loadModelAllowlist() {
    }
    
    public final void clearLoadModelAllowlistError() {
    }
    
    public final void setAppInForeground(boolean foreground) {
    }
    
    private final void saveModelAllowlistToDisk(java.lang.String modelAllowlistContent) {
    }
    
    private final selfgemma.talk.data.ModelAllowlist readModelAllowlistFromDisk(java.lang.String fileName) {
        return null;
    }
    
    private final boolean isModelPartiallyDownloaded(selfgemma.talk.data.Model model) {
        return false;
    }
    
    private final selfgemma.talk.ui.modelmanager.ModelManagerUiState createEmptyUiState() {
        return null;
    }
    
    private final selfgemma.talk.ui.modelmanager.ModelManagerUiState createUiState() {
        return null;
    }
    
    private final selfgemma.talk.data.Model createModelFromImportedModelInfo(selfgemma.talk.proto.ImportedModel info) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, java.util.List<selfgemma.talk.data.Task>> groupTasksByCategory() {
        return null;
    }
    
    private final void preloadLastUsedLlmModel() {
    }
    
    private final java.lang.String getCategoryLabel(android.content.Context context, selfgemma.talk.data.CategoryInfo category) {
        return null;
    }
    
    /**
     * Retrieves the download status of a model.
     *
     * This function determines the download status of a given model by checking if it's fully
     * downloaded, partially downloaded, or not downloaded at all. It also retrieves the received and
     * total bytes for partially downloaded models.
     */
    private final selfgemma.talk.data.ModelDownloadStatus getModelDownloadStatus(selfgemma.talk.data.Model model) {
        return null;
    }
    
    private final boolean isFileInExternalFilesDir(java.lang.String fileName) {
        return false;
    }
    
    private final boolean isFileInDataLocalTmpDir(java.lang.String fileName) {
        return false;
    }
    
    private final void deleteFileFromExternalFilesDir(java.lang.String fileName) {
    }
    
    /**
     * Deletes files from the the model imports directory whose absolute paths start with a given
     * prefix.
     */
    private final void deleteFilesFromImportDir(java.lang.String fileName) {
    }
    
    private final void deleteDirFromExternalFilesDir(java.lang.String dir) {
    }
    
    private final void updateModelInitializationStatus(selfgemma.talk.data.Model model, selfgemma.talk.ui.modelmanager.ModelInitializationStatusType status, java.lang.String error) {
    }
    
    private final boolean isModelDownloaded(selfgemma.talk.data.Model model) {
        return false;
    }
}