package selfgemma.talk.ui.modelmanager;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aZ\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r0\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r0\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"TAG", "", "CONTENT_ANIMATION_OFFSET", "Landroidx/compose/ui/unit/Dp;", "F", "ANIMATION_INIT_DELAY", "", "TASK_DESCRIPTION_SECTION_ANIMATION_START", "", "MODEL_LIST_ANIMATION_START", "DEFAULT_ANIMATION_DURATION", "TASK_ICON_ANIMATION_DURATION", "ModelList", "", "task", "Lselfgemma/talk/data/Task;", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "enableAnimation", "", "onModelClicked", "Lkotlin/Function1;", "Lselfgemma/talk/data/Model;", "onBenchmarkClicked", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class ModelListKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGModelList";
    private static final float CONTENT_ANIMATION_OFFSET = 0.0F;
    private static final long ANIMATION_INIT_DELAY = 80L;
    private static final int TASK_DESCRIPTION_SECTION_ANIMATION_START = 400;
    private static final int MODEL_LIST_ANIMATION_START = 550;
    private static final int DEFAULT_ANIMATION_DURATION = 700;
    private static final int TASK_ICON_ANIMATION_DURATION = 1100;
    
    /**
     * The list of models in the model manager.
     */
    @androidx.compose.runtime.Composable()
    public static final void ModelList(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.PaddingValues contentPadding, boolean enableAnimation, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.data.Model, kotlin.Unit> onModelClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.data.Model, kotlin.Unit> onBenchmarkClicked, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}