package selfgemma.talk.feature.roleplay.sessions;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001an\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0080\u0001\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0003\u001a\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a,\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0003\u00a8\u0006#"}, d2 = {"SessionsScreen", "", "onOpenSession", "Lkotlin/Function1;", "", "onOpenRoleCatalog", "Lkotlin/Function0;", "onOpenSettings", "onOpenModelLibrary", "modifier", "Landroidx/compose/ui/Modifier;", "showFab", "", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "viewModel", "Lselfgemma/talk/feature/roleplay/sessions/SessionsViewModel;", "SessionCard", "session", "Lselfgemma/talk/feature/roleplay/sessions/SessionListItemUiState;", "isExpanded", "onExpandChange", "onOpen", "onImportChat", "onExportChat", "onTogglePin", "onArchive", "onDelete", "formatTime", "timestamp", "", "context", "Landroid/content/Context;", "EmptySessionsState", "title", "app_debug"})
public final class SessionsScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void SessionsScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onOpenSession, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onOpenRoleCatalog, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onOpenSettings, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onOpenModelLibrary, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, boolean showFab, @org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.PaddingValues contentPadding, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.feature.roleplay.sessions.SessionsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SessionCard(selfgemma.talk.feature.roleplay.sessions.SessionListItemUiState session, boolean isExpanded, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onExpandChange, kotlin.jvm.functions.Function0<kotlin.Unit> onOpen, kotlin.jvm.functions.Function0<kotlin.Unit> onImportChat, kotlin.jvm.functions.Function0<kotlin.Unit> onExportChat, kotlin.jvm.functions.Function0<kotlin.Unit> onTogglePin, kotlin.jvm.functions.Function0<kotlin.Unit> onArchive, kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    private static final java.lang.String formatTime(long timestamp, android.content.Context context) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    private static final void EmptySessionsState(java.lang.String title, kotlin.jvm.functions.Function0<kotlin.Unit> onOpenRoleCatalog, kotlin.jvm.functions.Function0<kotlin.Unit> onOpenModelLibrary) {
    }
}