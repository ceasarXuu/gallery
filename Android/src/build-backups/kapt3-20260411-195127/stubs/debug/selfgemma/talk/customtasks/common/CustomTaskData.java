package selfgemma.talk.customtasks.common;

/**
 * Data class to hold information passed to the `MainScreen` composable of a custom task.
 *
 * @param modelManagerViewModel The ViewModel providing access to the state of models and their
 *  management.
 * @param bottomPadding The bottom padding of the Scaffold's `innerPadding`. By default, your
 *  `MainScreen` will extend to the bottom edge. Use this value if you need to apply padding to the
 *  bottom of your screen's content to account for elements like a bottom navigation bar.
 * @param setAppBarControlsDisabled A callback function that the custom task screen can call to
 *  enable and disable controls (e.g. back button, configs, etc) in the app bar.
 * @param setTopBarVisible A callback function that the custom task screen can call to show and hide
 *  the top bar.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u0012J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u00c6\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u00c6\u0003J\u001d\u0010\u001d\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\u0004\u0012\u00020\t0\u0007H\u00c6\u0003Jn\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\u0004\u0012\u00020\t0\u0007H\u00c6\u0001\u00a2\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020&H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R%\u0010\u000b\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015\u00a8\u0006\'"}, d2 = {"Lselfgemma/talk/customtasks/common/CustomTaskData;", "", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "bottomPadding", "Landroidx/compose/ui/unit/Dp;", "setAppBarControlsDisabled", "Lkotlin/Function1;", "", "", "setTopBarVisible", "setCustomNavigateUpCallback", "Lkotlin/Function0;", "<init>", "(Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getModelManagerViewModel", "()Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "getBottomPadding-D9Ej5fM", "()F", "F", "getSetAppBarControlsDisabled", "()Lkotlin/jvm/functions/Function1;", "getSetTopBarVisible", "getSetCustomNavigateUpCallback", "component1", "component2", "component2-D9Ej5fM", "component3", "component4", "component5", "copy", "copy-rAjV9yQ", "(Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lselfgemma/talk/customtasks/common/CustomTaskData;", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class CustomTaskData {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel = null;
    private final float bottomPadding = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> setAppBarControlsDisabled = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> setTopBarVisible = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> setCustomNavigateUpCallback = null;
    
    private CustomTaskData(selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, float bottomPadding, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> setAppBarControlsDisabled, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> setTopBarVisible, kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> setCustomNavigateUpCallback) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.modelmanager.ModelManagerViewModel getModelManagerViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> getSetAppBarControlsDisabled() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> getSetTopBarVisible() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> getSetCustomNavigateUpCallback() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.modelmanager.ModelManagerViewModel component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> component5() {
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