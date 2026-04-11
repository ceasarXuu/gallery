package selfgemma.talk.customtasks.agentchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001aL\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0003\u00a8\u0006\u0013"}, d2 = {"AddSkillFromFeatureListBottomSheet", "", "skillManagerViewModel", "Lselfgemma/talk/customtasks/agentchat/SkillManagerViewModel;", "onDismiss", "Lkotlin/Function0;", "onSkillAdded", "FeaturedSkillItem", "skill", "Lselfgemma/talk/data/AllowedSkill;", "uriHandler", "Landroidx/compose/ui/platform/UriHandler;", "onAddClick", "Lkotlin/Function1;", "validationError", "", "isAdding", "", "isSkillAdded", "app_debug"})
public final class AddSkillFromFeaturedListBottomSheetKt {
    
    /**
     * A ModalBottomSheet Composable for displaying and adding skills from a featured list.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void AddSkillFromFeatureListBottomSheet(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.customtasks.agentchat.SkillManagerViewModel skillManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSkillAdded) {
    }
    
    /**
     * Composable for displaying a single featured skill item in the list.
     */
    @androidx.compose.runtime.Composable()
    private static final void FeaturedSkillItem(selfgemma.talk.data.AllowedSkill skill, androidx.compose.ui.platform.UriHandler uriHandler, kotlin.jvm.functions.Function1<? super selfgemma.talk.data.AllowedSkill, kotlin.Unit> onAddClick, java.lang.String validationError, boolean isAdding, boolean isSkillAdded) {
    }
}