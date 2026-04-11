package selfgemma.talk.ui.modelmanager;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aH\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000e2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0007\u001a:\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000eH\u0007\u001af\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b0\u000e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u000eH\u0002\u001a$\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"TAG", "", "SUPPORTED_ACCELERATORS", "", "Lselfgemma/talk/data/Accelerator;", "IMPORT_CONFIGS_LLM", "Lselfgemma/talk/data/Config;", "ModelImportDialog", "", "uri", "Landroid/net/Uri;", "onDismiss", "Lkotlin/Function0;", "onDone", "Lkotlin/Function1;", "Lselfgemma/talk/proto/ImportedModel;", "defaultValues", "", "Lselfgemma/talk/data/ConfigKey;", "", "ModelImportingDialog", "info", "importModel", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fileName", "fileSize", "", "onProgress", "", "onError", "getFileSizeAndDisplayNameFromUri", "Lkotlin/Pair;", "app_debug"})
public final class ModelImportDialogKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGModelImportDialog";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<selfgemma.talk.data.Accelerator> SUPPORTED_ACCELERATORS = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<selfgemma.talk.data.Config> IMPORT_CONFIGS_LLM = null;
    
    @androidx.compose.runtime.Composable()
    public static final void ModelImportDialog(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.proto.ImportedModel, kotlin.Unit> onDone, @org.jetbrains.annotations.NotNull()
    java.util.Map<selfgemma.talk.data.ConfigKey, ? extends java.lang.Object> defaultValues) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModelImportingDialog(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.ImportedModel info, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.proto.ImportedModel, kotlin.Unit> onDone) {
    }
    
    private static final void importModel(android.content.Context context, kotlinx.coroutines.CoroutineScope coroutineScope, java.lang.String fileName, long fileSize, android.net.Uri uri, kotlin.jvm.functions.Function0<kotlin.Unit> onDone, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onProgress, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    private static final kotlin.Pair<java.lang.Long, java.lang.String> getFileSizeAndDisplayNameFromUri(android.content.Context context, android.net.Uri uri) {
        return null;
    }
}