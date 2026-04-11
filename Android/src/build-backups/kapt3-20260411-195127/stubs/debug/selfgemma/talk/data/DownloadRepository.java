package selfgemma.talk.data;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u000726\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\tH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H&JZ\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u000726\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\tH&\u00a8\u0006\u0015\u00c0\u0006\u0003"}, d2 = {"Lselfgemma/talk/data/DownloadRepository;", "", "downloadModel", "", "task", "Lselfgemma/talk/data/Task;", "model", "Lselfgemma/talk/data/Model;", "onStatusUpdated", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lselfgemma/talk/data/ModelDownloadStatus;", "status", "cancelDownloadModel", "cancelAll", "onComplete", "Lkotlin/Function0;", "observerWorkerProgress", "workerId", "Ljava/util/UUID;", "app_debug"})
public abstract interface DownloadRepository {
    
    public abstract void downloadModel(@org.jetbrains.annotations.Nullable()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super selfgemma.talk.data.Model, ? super selfgemma.talk.data.ModelDownloadStatus, kotlin.Unit> onStatusUpdated);
    
    public abstract void cancelDownloadModel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model);
    
    public abstract void cancelAll(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onComplete);
    
    public abstract void observerWorkerProgress(@org.jetbrains.annotations.NotNull()
    java.util.UUID workerId, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super selfgemma.talk.data.Model, ? super selfgemma.talk.data.ModelDownloadStatus, kotlin.Unit> onStatusUpdated);
}