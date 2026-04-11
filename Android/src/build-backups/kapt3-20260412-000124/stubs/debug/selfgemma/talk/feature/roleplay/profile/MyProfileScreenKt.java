package selfgemma.talk.feature.roleplay.profile;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002\u001a>\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007\u001aZ\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u001a2\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u001dH\u0003\u001aH\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u001a2\u0006\u0010#\u001a\u00020\u000fH\u0003\u001a,\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0003\u001a\u00ac\u0001\u0010(\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u001a2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u001a2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b0\u001a2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u001a2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u001a2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\u001aH\u0003\u001a@\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u00012\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0003\u001a8\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020.2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b0\u001a2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\u001aH\u0003\u001a8\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u00032\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u001a2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\u001aH\u0003\u001a&\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u000f2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0003\u001aG\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u00012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a2\u0011\u0010A\u001a\r\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\u0002\bBH\u0003\u001a6\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u00012\b\u0010E\u001a\u0004\u0018\u00010\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0003\u001a4\u0010G\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u00012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001aH\u0003\u001a\u001e\u0010H\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0003\u001aX\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u00012\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u001a2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010L\u001a\u00020\u00032\b\b\u0002\u0010M\u001a\u00020\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010N\u001a\u00020OH\u0003\u001a\u0018\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0002\u001a.\u0010U\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010V\u001a\u00020\u000f2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u001aH\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006X"}, d2 = {"TAG", "", "PERSONA_NAME_MAX_CHARS", "", "PERSONA_DESCRIPTION_MAX_CHARS", "PERSONA_DEPTH_MAX_CHARS", "personaTextFieldSpec", "Lselfgemma/talk/feature/roleplay/profile/PersonaTextFieldSpec;", "topic", "Lselfgemma/talk/feature/roleplay/profile/PersonaHelpTopic;", "MyProfileScreen", "", "navigateUp", "Lkotlin/Function0;", "showNavigateUp", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "viewModel", "Lselfgemma/talk/feature/roleplay/profile/MyProfileViewModel;", "MyProfileListContent", "uiState", "Lselfgemma/talk/feature/roleplay/profile/MyProfileUiState;", "onEditSlot", "Lkotlin/Function1;", "onDeleteSlot", "onDefaultPersonaChange", "Lkotlin/Function2;", "PersonaCardItem", "persona", "Lselfgemma/talk/feature/roleplay/profile/PersonaSlotCardUiState;", "onEdit", "onDelete", "deleteEnabled", "ConfirmDeletePersonaDialog", "personaName", "onDismiss", "onConfirm", "MyProfileEditorContent", "onPersonaNameChange", "onPersonaDescriptionChange", "onAvatarClick", "onAvatarClear", "onPersonaPositionChange", "Lselfgemma/talk/domain/roleplay/model/StPersonaDescriptionPosition;", "onPersonaDepthChange", "onPersonaRoleChange", "onShowHelp", "CreatePersonaSlotDialog", "slotId", "onSlotIdChange", "onCreate", "PersonaPositionCard", "selected", "onSelected", "PersonaRoleCard", "selectedRole", "PositionOptionRow", "label", "onClick", "EditorCard", "title", "helpTopic", "content", "Landroidx/compose/runtime/Composable;", "PersonaAvatarCard", "name", "avatarUri", "onClearAvatar", "PersonaFieldHeader", "PersonaHelpDialog", "PersonaOutlinedTextField", "value", "onValueChange", "minLines", "maxLines", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "takeReadPermission", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "DefaultPersonaAction", "checked", "onCheckedChange", "app_debug"})
public final class MyProfileScreenKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "MyProfileScreen";
    private static final int PERSONA_NAME_MAX_CHARS = 120;
    private static final int PERSONA_DESCRIPTION_MAX_CHARS = 600;
    private static final int PERSONA_DEPTH_MAX_CHARS = 4;
    
    private static final selfgemma.talk.feature.roleplay.profile.PersonaTextFieldSpec personaTextFieldSpec(selfgemma.talk.feature.roleplay.profile.PersonaHelpTopic topic) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void MyProfileScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, boolean showNavigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.PaddingValues contentPadding, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.feature.roleplay.profile.MyProfileViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void MyProfileListContent(selfgemma.talk.feature.roleplay.profile.MyProfileUiState uiState, androidx.compose.foundation.layout.PaddingValues contentPadding, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onEditSlot, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDeleteSlot, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> onDefaultPersonaChange) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PersonaCardItem(selfgemma.talk.feature.roleplay.profile.PersonaSlotCardUiState persona, kotlin.jvm.functions.Function0<kotlin.Unit> onEdit, kotlin.jvm.functions.Function0<kotlin.Unit> onDelete, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onDefaultPersonaChange, boolean deleteEnabled) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ConfirmDeletePersonaDialog(java.lang.String personaName, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, kotlin.jvm.functions.Function0<kotlin.Unit> onConfirm) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void MyProfileEditorContent(selfgemma.talk.feature.roleplay.profile.MyProfileUiState uiState, androidx.compose.foundation.layout.PaddingValues contentPadding, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onPersonaNameChange, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onPersonaDescriptionChange, kotlin.jvm.functions.Function0<kotlin.Unit> onAvatarClick, kotlin.jvm.functions.Function0<kotlin.Unit> onAvatarClear, kotlin.jvm.functions.Function1<? super selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition, kotlin.Unit> onPersonaPositionChange, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onPersonaDepthChange, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onPersonaRoleChange, kotlin.jvm.functions.Function1<? super selfgemma.talk.feature.roleplay.profile.PersonaHelpTopic, kotlin.Unit> onShowHelp) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CreatePersonaSlotDialog(java.lang.String slotId, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSlotIdChange, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, kotlin.jvm.functions.Function0<kotlin.Unit> onCreate) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PersonaPositionCard(selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition selected, kotlin.jvm.functions.Function1<? super selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition, kotlin.Unit> onSelected, kotlin.jvm.functions.Function1<? super selfgemma.talk.feature.roleplay.profile.PersonaHelpTopic, kotlin.Unit> onShowHelp) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PersonaRoleCard(int selectedRole, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onSelected, kotlin.jvm.functions.Function1<? super selfgemma.talk.feature.roleplay.profile.PersonaHelpTopic, kotlin.Unit> onShowHelp) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PositionOptionRow(java.lang.String label, boolean selected, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void EditorCard(java.lang.String title, selfgemma.talk.feature.roleplay.profile.PersonaHelpTopic helpTopic, kotlin.jvm.functions.Function1<? super selfgemma.talk.feature.roleplay.profile.PersonaHelpTopic, kotlin.Unit> onShowHelp, androidx.compose.runtime.internal.ComposableFunction0<kotlin.Unit> content) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PersonaAvatarCard(java.lang.String name, java.lang.String avatarUri, kotlin.jvm.functions.Function0<kotlin.Unit> onAvatarClick, kotlin.jvm.functions.Function0<kotlin.Unit> onClearAvatar) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PersonaFieldHeader(java.lang.String title, selfgemma.talk.feature.roleplay.profile.PersonaHelpTopic helpTopic, kotlin.jvm.functions.Function1<? super selfgemma.talk.feature.roleplay.profile.PersonaHelpTopic, kotlin.Unit> onShowHelp) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PersonaHelpDialog(selfgemma.talk.feature.roleplay.profile.PersonaHelpTopic topic, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PersonaOutlinedTextField(java.lang.String value, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChange, androidx.compose.ui.Modifier modifier, int minLines, int maxLines, selfgemma.talk.feature.roleplay.profile.PersonaHelpTopic helpTopic, androidx.compose.foundation.text.KeyboardOptions keyboardOptions) {
    }
    
    private static final void takeReadPermission(android.content.Context context, android.net.Uri uri) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DefaultPersonaAction(androidx.compose.ui.Modifier modifier, boolean checked, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onCheckedChange) {
    }
}