package selfgemma.talk.feature.roleplay.settings;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u001aT\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a^\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0003\u001a2\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0018H\u0003\u001a&\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0003\u001a4\u0010!\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\n2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\u0018H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"TAG", "", "RoleplaySettingsScreen", "", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "navigateUp", "Lkotlin/Function0;", "onOpenModelLibrary", "showNavigateUp", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "viewModel", "Lselfgemma/talk/feature/roleplay/settings/RoleplaySettingsViewModel;", "AssistantModelSelectionDialog", "downloadedModels", "", "Lselfgemma/talk/data/Model;", "currentModelId", "onDismiss", "onModelSelected", "Lkotlin/Function1;", "onResetToDefault", "LanguageSelectionDialog", "currentLocaleTag", "onLanguageSelected", "SettingsCard", "title", "summary", "onClick", "ToggleSettingsCard", "checked", "onCheckedChange", "app_debug"})
public final class RoleplaySettingsScreenKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "RoleplaySettingsScreen";
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void RoleplaySettingsScreen(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onOpenModelLibrary, boolean showNavigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.PaddingValues contentPadding, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.feature.roleplay.settings.RoleplaySettingsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void AssistantModelSelectionDialog(java.util.List<selfgemma.talk.data.Model> downloadedModels, java.lang.String currentModelId, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, kotlin.jvm.functions.Function0<kotlin.Unit> onOpenModelLibrary, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onModelSelected, kotlin.jvm.functions.Function0<kotlin.Unit> onResetToDefault) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void LanguageSelectionDialog(java.lang.String currentLocaleTag, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onLanguageSelected) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SettingsCard(java.lang.String title, java.lang.String summary, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ToggleSettingsCard(java.lang.String title, java.lang.String summary, boolean checked, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onCheckedChange) {
    }
}