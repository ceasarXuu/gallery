package selfgemma.talk.ui.common.modelitem;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0099\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\tH\u0007\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"ModelItem", "", "model", "Lselfgemma/talk/data/Model;", "task", "Lselfgemma/talk/data/Task;", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "onModelClicked", "Lkotlin/Function1;", "onBenchmarkClicked", "modifier", "Landroidx/compose/ui/Modifier;", "expanded", "", "showDeleteButton", "canExpand", "showBenchmarkButton", "onExpanded", "(Lselfgemma/talk/data/Model;Lselfgemma/talk/data/Task;Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ljava/lang/Boolean;ZZZLkotlin/jvm/functions/Function1;)V", "app_debug"})
public final class ModelItemKt {
    
    /**
     * Composable function to display a model item in the model manager list.
     *
     * This function renders a card representing a model, displaying its task icon, name, download
     * status, and providing action buttons. It supports expanding to show a model description and
     * buttons for learning more (opening a URL) and downloading/trying the model.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalSharedTransitionApi.class})
    @androidx.compose.runtime.Composable()
    public static final void ModelItem(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.data.Model, kotlin.Unit> onModelClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.data.Model, kotlin.Unit> onBenchmarkClicked, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean expanded, boolean showDeleteButton, boolean canExpand, boolean showBenchmarkButton, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onExpanded) {
    }
}