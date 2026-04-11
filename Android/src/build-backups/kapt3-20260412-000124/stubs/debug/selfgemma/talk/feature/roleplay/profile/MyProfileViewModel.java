package selfgemma.talk.feature.roleplay.profile;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J2\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0013J\u000e\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\u0011J\u0016\u0010\'\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0013J\u0006\u0010+\u001a\u00020\u0011J\u001c\u0010,\u001a\u00020\u00112\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0.H\u0002J\u0010\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u00061"}, d2 = {"Lselfgemma/talk/feature/roleplay/profile/MyProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "dataStoreRepository", "Lselfgemma/talk/data/DataStoreRepository;", "<init>", "(Lselfgemma/talk/data/DataStoreRepository;)V", "savedProfile", "Lselfgemma/talk/domain/roleplay/model/StUserProfile;", "workingProfile", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lselfgemma/talk/feature/roleplay/profile/MyProfileUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "updatePersonaName", "", "value", "", "updatePersonaTitle", "updatePersonaDescription", "updatePersonaPosition", "Lselfgemma/talk/domain/roleplay/model/StPersonaDescriptionPosition;", "updatePersonaDepth", "updatePersonaRole", "", "updateAvatarUri", "updateAvatarEditState", "avatarUri", "avatarEditorSourceUri", "avatarCropZoom", "", "avatarCropOffsetX", "avatarCropOffsetY", "selectAvatarSlot", "slotId", "createAvatarSlot", "saveProfile", "setDefaultPersona", "enabled", "", "deleteAvatarSlot", "resetProfile", "updateUiState", "transform", "Lkotlin/Function1;", "buildProfileFromUiState", "state", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MyProfileViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DataStoreRepository dataStoreRepository = null;
    @org.jetbrains.annotations.NotNull()
    private selfgemma.talk.domain.roleplay.model.StUserProfile savedProfile;
    @org.jetbrains.annotations.NotNull()
    private selfgemma.talk.domain.roleplay.model.StUserProfile workingProfile;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.feature.roleplay.profile.MyProfileUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.feature.roleplay.profile.MyProfileUiState> uiState = null;
    
    @javax.inject.Inject()
    public MyProfileViewModel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DataStoreRepository dataStoreRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.feature.roleplay.profile.MyProfileUiState> getUiState() {
        return null;
    }
    
    public final void updatePersonaName(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void updatePersonaTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void updatePersonaDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void updatePersonaPosition(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition value) {
    }
    
    public final void updatePersonaDepth(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void updatePersonaRole(int value) {
    }
    
    public final void updateAvatarUri(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    public final void updateAvatarEditState(@org.jetbrains.annotations.Nullable()
    java.lang.String avatarUri, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarEditorSourceUri, float avatarCropZoom, float avatarCropOffsetX, float avatarCropOffsetY) {
    }
    
    public final void selectAvatarSlot(@org.jetbrains.annotations.NotNull()
    java.lang.String slotId) {
    }
    
    public final void createAvatarSlot(@org.jetbrains.annotations.NotNull()
    java.lang.String slotId) {
    }
    
    public final void saveProfile() {
    }
    
    public final void setDefaultPersona(@org.jetbrains.annotations.NotNull()
    java.lang.String slotId, boolean enabled) {
    }
    
    public final void deleteAvatarSlot(@org.jetbrains.annotations.NotNull()
    java.lang.String slotId) {
    }
    
    public final void resetProfile() {
    }
    
    private final void updateUiState(kotlin.jvm.functions.Function1<? super selfgemma.talk.feature.roleplay.profile.MyProfileUiState, selfgemma.talk.feature.roleplay.profile.MyProfileUiState> transform) {
    }
    
    private final selfgemma.talk.domain.roleplay.model.StUserProfile buildProfileFromUiState(selfgemma.talk.feature.roleplay.profile.MyProfileUiState state) {
        return null;
    }
}