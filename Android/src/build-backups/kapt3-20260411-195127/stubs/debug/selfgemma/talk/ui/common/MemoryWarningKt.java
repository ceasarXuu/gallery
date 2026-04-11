package selfgemma.talk.ui.common;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0007\u001a\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"TAG", "", "BYTES_IN_GB", "", "MemoryWarningAlert", "", "onProceeded", "Lkotlin/Function0;", "onDismissed", "isMemoryLow", "", "context", "Landroid/content/Context;", "model", "Lselfgemma/talk/data/Model;", "app_debug"})
public final class MemoryWarningKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGMemoryWarning";
    private static final float BYTES_IN_GB = 1.0737418E9F;
    
    /**
     * Composable function to display a memory warning alert dialog.
     */
    @androidx.compose.runtime.Composable()
    public static final void MemoryWarningAlert(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onProceeded, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissed) {
    }
    
    /**
     * Checks if the device's memory is lower than the required minimum for the given model.
     */
    public static final boolean isMemoryLow(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
        return false;
    }
}