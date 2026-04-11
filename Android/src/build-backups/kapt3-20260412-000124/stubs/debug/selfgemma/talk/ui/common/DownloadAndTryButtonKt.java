package selfgemma.talk.ui.common;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001at\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\rH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"TAG", "", "SYSTEM_RESERVED_MEMORY_IN_BYTES", "", "MODEL_NAMES_TO_SHOW_GEMMA_LICENSES", "", "DownloadAndTryButton", "", "task", "Lselfgemma/talk/data/Task;", "model", "Lselfgemma/talk/data/Model;", "enabled", "", "downloadStatus", "Lselfgemma/talk/data/ModelDownloadStatus;", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "onClicked", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "tosViewModel", "Lselfgemma/talk/ui/common/tos/TosViewModel;", "modifierWhenExpanded", "compact", "canShowTryIt", "app_debug"})
public final class DownloadAndTryButtonKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGDownloadAndTryButton";
    private static final long SYSTEM_RESERVED_MEMORY_IN_BYTES = 3221225472L;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Set<java.lang.String> MODEL_NAMES_TO_SHOW_GEMMA_LICENSES = null;
    
    /**
     * Handles the "Download & Try it" button click, managing the model download process based on
     * various conditions.
     *
     * If the button is enabled and not currently checking the token, it initiates a coroutine to handle
     * the download logic.
     *
     * For models requiring download first, it specifically addresses HuggingFace URLs by first checking
     * if authentication is necessary. If no authentication is needed, the download starts directly.
     * Otherwise, it checks the current token status; if the token is invalid or expired, a token
     * exchange flow is initiated. If a valid token exists, it attempts to access the download URL. If
     * access is granted, the download begins; if not, a new token is requested.
     *
     * For non-HuggingFace URLs that need downloading, the download starts directly.
     *
     * If the model doesn't need to be downloaded first, the provided `onClicked` callback is executed.
     *
     * Additionally, for gated HuggingFace models, if accessing the model after token exchange results
     * in a forbidden error, a modal bottom sheet is displayed, prompting the user to acknowledge the
     * user agreement by opening it in a custom tab. Upon closing the tab, the download process is
     * retried.
     *
     * The composable also manages UI states for indicating token checking and displaying the agreement
     * acknowledgement sheet, and it handles requesting notification permissions before initiating the
     * actual download.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void DownloadAndTryButton(@org.jetbrains.annotations.Nullable()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, boolean enabled, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.data.ModelDownloadStatus downloadStatus, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClicked, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.tos.TosViewModel tosViewModel, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifierWhenExpanded, boolean compact, boolean canShowTryIt) {
    }
}