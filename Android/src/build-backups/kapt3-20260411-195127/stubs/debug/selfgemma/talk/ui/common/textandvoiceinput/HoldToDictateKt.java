package selfgemma.talk.ui.common.textandvoiceinput;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"TAG", "", "HoldToDictate", "", "task", "Lselfgemma/talk/data/Task;", "viewModel", "Lselfgemma/talk/ui/common/textandvoiceinput/HoldToDictateViewModel;", "onDone", "Lkotlin/Function1;", "onAmplitudeChanged", "", "enabled", "", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class HoldToDictateKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGHoldToDictate";
    
    /**
     * A Composable that provides a "Hold to Dictate" functionality.
     *
     * This composable requests RECORD_AUDIO permission and, once granted, displays a button. The user
     * can press and hold the button to start speech recognition. Releasing the button stops the
     * recognition. Moving the finger off the button while holding will cancel the recognition.
     */
    @androidx.compose.runtime.Composable()
    public static final void HoldToDictate(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.textandvoiceinput.HoldToDictateViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDone, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onAmplitudeChanged, boolean enabled, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}