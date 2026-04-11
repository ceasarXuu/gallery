package selfgemma.talk.data;

/**
 * Repository for managing model downloads using WorkManager.
 *
 * This class provides methods to initiate model downloads, cancel downloads, observe download
 * progress, and retrieve information about enqueued or running download tasks. It utilizes
 * WorkManager to handle background download operations.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007JR\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e0\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u001a\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0016JZ\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e0\u0014H\u0016J(\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lselfgemma/talk/data/DefaultDownloadRepository;", "Lselfgemma/talk/data/DownloadRepository;", "context", "Landroid/content/Context;", "lifecycleProvider", "Lselfgemma/talk/AppLifecycleProvider;", "<init>", "(Landroid/content/Context;Lselfgemma/talk/AppLifecycleProvider;)V", "workManager", "Landroidx/work/WorkManager;", "downloadStartTimeSharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "downloadModel", "", "task", "Lselfgemma/talk/data/Task;", "model", "Lselfgemma/talk/data/Model;", "onStatusUpdated", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lselfgemma/talk/data/ModelDownloadStatus;", "status", "cancelDownloadModel", "cancelAll", "onComplete", "Lkotlin/Function0;", "observerWorkerProgress", "workerId", "Ljava/util/UUID;", "sendNotification", "title", "", "text", "taskId", "modelName", "app_debug"})
public final class DefaultDownloadRepository implements selfgemma.talk.data.DownloadRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.AppLifecycleProvider lifecycleProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.work.WorkManager workManager = null;
    
    /**
     * Stores the start time of a model download.
     *
     * We use SharedPreferences to persist the download start times. This ensures that the data is
     * still available after the app restarts. The key is the model name and the value is the download
     * start time in milliseconds.
     */
    private final android.content.SharedPreferences downloadStartTimeSharedPreferences = null;
    
    public DefaultDownloadRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.AppLifecycleProvider lifecycleProvider) {
        super();
    }
    
    @java.lang.Override()
    public void downloadModel(@org.jetbrains.annotations.Nullable()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super selfgemma.talk.data.Model, ? super selfgemma.talk.data.ModelDownloadStatus, kotlin.Unit> onStatusUpdated) {
    }
    
    @java.lang.Override()
    public void cancelDownloadModel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
    }
    
    @java.lang.Override()
    public void cancelAll(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onComplete) {
    }
    
    @java.lang.Override()
    public void observerWorkerProgress(@org.jetbrains.annotations.NotNull()
    java.util.UUID workerId, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super selfgemma.talk.data.Model, ? super selfgemma.talk.data.ModelDownloadStatus, kotlin.Unit> onStatusUpdated) {
    }
    
    private final void sendNotification(java.lang.String title, java.lang.String text, java.lang.String taskId, java.lang.String modelName) {
    }
}