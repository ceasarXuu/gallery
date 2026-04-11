package selfgemma.talk.ui.common.chat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0004H\u0003\u00a8\u0006\t"}, d2 = {"LogsViewer", "", "logs", "", "Lselfgemma/talk/ui/common/chat/LogMessage;", "onDismissRequest", "Lkotlin/Function0;", "LogItem", "log", "app_debug"})
public final class LogsViewerKt {
    
    /**
     * A Composable function to display console logs within a ModalBottomSheet.
     *
     * @param logs The list of [LogMessage] to display.
     * @param onDismissRequest Callback to be invoked when the sheet is dismissed.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void LogsViewer(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.ui.common.chat.LogMessage> logs, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissRequest) {
    }
    
    /**
     * Composable to display a single [LogMessage].
     *
     * @param log The [LogMessage] to display.
     */
    @androidx.compose.runtime.Composable()
    private static final void LogItem(selfgemma.talk.ui.common.chat.LogMessage log) {
    }
}