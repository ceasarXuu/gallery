package selfgemma.talk.customtasks.agentchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0010H\u0007\u001a\u0088\u0001\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\u0006\u0010!\u001a\u00020\"H\u0003\u001a\u0018\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0002\u001a*\u0010(\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0010H\u0003\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"ADD_SKILL_OPTIONS", "", "Lselfgemma/talk/customtasks/agentchat/AddSkillOption;", "BUTTON_CONTENT_PADDING", "Landroidx/compose/foundation/layout/PaddingValues;", "getBUTTON_CONTENT_PADDING", "()Landroidx/compose/foundation/layout/PaddingValues;", "TAG", "", "SkillManagerBottomSheet", "", "agentTools", "Lselfgemma/talk/customtasks/agentchat/AgentTools;", "skillManagerViewModel", "Lselfgemma/talk/customtasks/agentchat/SkillManagerViewModel;", "onDismiss", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "selectedSkillsChanged", "SkillItemRow", "skillState", "Lselfgemma/talk/customtasks/agentchat/SkillState;", "inMultiSelectMode", "isSelectedForDeletion", "onSelectionCheckedChange", "onLongClick", "Lkotlin/Function0;", "onSkillEnabledChange", "onViewClick", "onSecretClick", "onDeleteClick", "uriHandler", "Landroidx/compose/ui/platform/UriHandler;", "scrollToBottomOfList", "scope", "Lkotlinx/coroutines/CoroutineScope;", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "AddSkillOptionsBottomSheet", "onOptionSelected", "app_debug"})
public final class SkillManagerBottomSheetKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<selfgemma.talk.customtasks.agentchat.AddSkillOption> ADD_SKILL_OPTIONS = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.compose.foundation.layout.PaddingValues BUTTON_CONTENT_PADDING = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGSkillManagerBottomSheet";
    
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.foundation.layout.PaddingValues getBUTTON_CONTENT_PADDING() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class, androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable()
    public static final void SkillManagerBottomSheet(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.customtasks.agentchat.AgentTools agentTools, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.customtasks.agentchat.SkillManagerViewModel skillManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onDismiss) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable()
    private static final void SkillItemRow(selfgemma.talk.customtasks.agentchat.SkillState skillState, boolean inMultiSelectMode, boolean isSelectedForDeletion, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onSelectionCheckedChange, kotlin.jvm.functions.Function0<kotlin.Unit> onLongClick, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onSkillEnabledChange, kotlin.jvm.functions.Function0<kotlin.Unit> onViewClick, kotlin.jvm.functions.Function0<kotlin.Unit> onSecretClick, kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteClick, androidx.compose.ui.platform.UriHandler uriHandler) {
    }
    
    private static final void scrollToBottomOfList(kotlinx.coroutines.CoroutineScope scope, androidx.compose.foundation.lazy.LazyListState listState) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    private static final void AddSkillOptionsBottomSheet(kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, kotlin.jvm.functions.Function1<? super selfgemma.talk.customtasks.agentchat.AddSkillOption, kotlin.Unit> onOptionSelected) {
    }
}