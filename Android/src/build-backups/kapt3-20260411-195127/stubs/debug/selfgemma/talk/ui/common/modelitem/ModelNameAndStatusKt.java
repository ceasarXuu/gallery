package selfgemma.talk.ui.common.modelitem;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u00a8\u0006\f"}, d2 = {"ModelNameAndStatus", "", "model", "Lselfgemma/talk/data/Model;", "task", "Lselfgemma/talk/data/Task;", "downloadStatus", "Lselfgemma/talk/data/ModelDownloadStatus;", "isExpanded", "", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class ModelNameAndStatusKt {
    
    /**
     * Composable function to display the model name and its download status information.
     *
     * This function renders the model's name and its current download status, including:
     * - Model name.
     * - Failure message (if download failed).
     * - "Unzipping..." status for unzipping processes.
     * - Model size for successful downloads.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalSharedTransitionApi.class})
    @androidx.compose.runtime.Composable()
    public static final void ModelNameAndStatus(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.data.ModelDownloadStatus downloadStatus, boolean isExpanded, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}