package selfgemma.talk.ui.modelmanager;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\'\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00a3\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0010J\u000e\u0010+\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0010J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u001b\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006H\u00c6\u0003J\u0015\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0006H\u00c6\u0003J\u0015\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u0006H\u00c6\u0003J\t\u00100\u001a\u00020\rH\u00c6\u0003J\t\u00101\u001a\u00020\u0007H\u00c6\u0003J\t\u00102\u001a\u00020\u0010H\u00c6\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0013H\u00c6\u0003J\t\u00105\u001a\u00020\u0013H\u00c6\u0003J\t\u00106\u001a\u00020\u0013H\u00c6\u0003J\u00ad\u0001\u00107\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00062\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013H\u00c6\u0001J\u0013\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010:\u001a\u00020;H\u00d6\u0001J\t\u0010<\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010&R\u0011\u0010\u0015\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010&\u00a8\u0006="}, d2 = {"Lselfgemma/talk/ui/modelmanager/ModelManagerUiState;", "", "tasks", "", "Lselfgemma/talk/data/Task;", "tasksByCategory", "", "", "modelDownloadStatus", "Lselfgemma/talk/data/ModelDownloadStatus;", "modelInitializationStatus", "Lselfgemma/talk/ui/modelmanager/ModelInitializationStatus;", "loadingModelAllowlist", "", "loadingModelAllowlistError", "selectedModel", "Lselfgemma/talk/data/Model;", "textInputHistory", "settingsUpdateTrigger", "", "configValuesUpdateTrigger", "modelImportingUpdateTrigger", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;ZLjava/lang/String;Lselfgemma/talk/data/Model;Ljava/util/List;JJJ)V", "getTasks", "()Ljava/util/List;", "getTasksByCategory", "()Ljava/util/Map;", "getModelDownloadStatus", "getModelInitializationStatus", "getLoadingModelAllowlist", "()Z", "getLoadingModelAllowlistError", "()Ljava/lang/String;", "getSelectedModel", "()Lselfgemma/talk/data/Model;", "getTextInputHistory", "getSettingsUpdateTrigger", "()J", "getConfigValuesUpdateTrigger", "getModelImportingUpdateTrigger", "isModelInitialized", "model", "isModelInitializing", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class ModelManagerUiState {
    
    /**
     * A list of tasks available in the application.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.data.Task> tasks = null;
    
    /**
     * Tasks grouped by category.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.util.List<selfgemma.talk.data.Task>> tasksByCategory = null;
    
    /**
     * A map that tracks the download status of each model, indexed by model name.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, selfgemma.talk.data.ModelDownloadStatus> modelDownloadStatus = null;
    
    /**
     * A map that tracks the initialization status of each model, indexed by model name.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, selfgemma.talk.ui.modelmanager.ModelInitializationStatus> modelInitializationStatus = null;
    
    /**
     * Whether the app is loading and processing the model allowlist.
     */
    private final boolean loadingModelAllowlist = false;
    
    /**
     * The error message when loading the model allowlist.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String loadingModelAllowlistError = null;
    
    /**
     * The currently selected model.
     */
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.Model selectedModel = null;
    
    /**
     * The history of text inputs entered by the user.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> textInputHistory = null;
    private final long settingsUpdateTrigger = 0L;
    private final long configValuesUpdateTrigger = 0L;
    private final long modelImportingUpdateTrigger = 0L;
    
    public ModelManagerUiState(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.Task> tasks, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.util.List<selfgemma.talk.data.Task>> tasksByCategory, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, selfgemma.talk.data.ModelDownloadStatus> modelDownloadStatus, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, selfgemma.talk.ui.modelmanager.ModelInitializationStatus> modelInitializationStatus, boolean loadingModelAllowlist, @org.jetbrains.annotations.NotNull()
    java.lang.String loadingModelAllowlistError, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model selectedModel, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> textInputHistory, long settingsUpdateTrigger, long configValuesUpdateTrigger, long modelImportingUpdateTrigger) {
        super();
    }
    
    /**
     * A list of tasks available in the application.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.Task> getTasks() {
        return null;
    }
    
    /**
     * Tasks grouped by category.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.List<selfgemma.talk.data.Task>> getTasksByCategory() {
        return null;
    }
    
    /**
     * A map that tracks the download status of each model, indexed by model name.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, selfgemma.talk.data.ModelDownloadStatus> getModelDownloadStatus() {
        return null;
    }
    
    /**
     * A map that tracks the initialization status of each model, indexed by model name.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, selfgemma.talk.ui.modelmanager.ModelInitializationStatus> getModelInitializationStatus() {
        return null;
    }
    
    /**
     * Whether the app is loading and processing the model allowlist.
     */
    public final boolean getLoadingModelAllowlist() {
        return false;
    }
    
    /**
     * The error message when loading the model allowlist.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLoadingModelAllowlistError() {
        return null;
    }
    
    /**
     * The currently selected model.
     */
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.Model getSelectedModel() {
        return null;
    }
    
    /**
     * The history of text inputs entered by the user.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTextInputHistory() {
        return null;
    }
    
    public final long getSettingsUpdateTrigger() {
        return 0L;
    }
    
    public final long getConfigValuesUpdateTrigger() {
        return 0L;
    }
    
    public final long getModelImportingUpdateTrigger() {
        return 0L;
    }
    
    public final boolean isModelInitialized(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
        return false;
    }
    
    public final boolean isModelInitializing(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.Task> component1() {
        return null;
    }
    
    public final long component10() {
        return 0L;
    }
    
    public final long component11() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.List<selfgemma.talk.data.Task>> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, selfgemma.talk.data.ModelDownloadStatus> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, selfgemma.talk.ui.modelmanager.ModelInitializationStatus> component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.Model component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    public final long component9() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.modelmanager.ModelManagerUiState copy(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.Task> tasks, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.util.List<selfgemma.talk.data.Task>> tasksByCategory, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, selfgemma.talk.data.ModelDownloadStatus> modelDownloadStatus, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, selfgemma.talk.ui.modelmanager.ModelInitializationStatus> modelInitializationStatus, boolean loadingModelAllowlist, @org.jetbrains.annotations.NotNull()
    java.lang.String loadingModelAllowlistError, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model selectedModel, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> textInputHistory, long settingsUpdateTrigger, long configValuesUpdateTrigger, long modelImportingUpdateTrigger) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}