package selfgemma.talk.feature.roleplay.settings;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lselfgemma/talk/feature/roleplay/settings/RoleplaySettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "dataStoreRepository", "Lselfgemma/talk/data/DataStoreRepository;", "<init>", "(Lselfgemma/talk/data/DataStoreRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lselfgemma/talk/feature/roleplay/settings/RoleplaySettingsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "setMessageSoundsEnabled", "", "enabled", "", "setLiveTokenSpeedEnabled", "setStreamingOutputEnabled", "setRoleEditorAssistantModelId", "modelId", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RoleplaySettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DataStoreRepository dataStoreRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.feature.roleplay.settings.RoleplaySettingsUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.feature.roleplay.settings.RoleplaySettingsUiState> uiState = null;
    
    @javax.inject.Inject()
    public RoleplaySettingsViewModel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DataStoreRepository dataStoreRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.feature.roleplay.settings.RoleplaySettingsUiState> getUiState() {
        return null;
    }
    
    public final void setMessageSoundsEnabled(boolean enabled) {
    }
    
    public final void setLiveTokenSpeedEnabled(boolean enabled) {
    }
    
    public final void setStreamingOutputEnabled(boolean enabled) {
    }
    
    public final void setRoleEditorAssistantModelId(@org.jetbrains.annotations.Nullable()
    java.lang.String modelId) {
    }
}