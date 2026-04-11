package selfgemma.talk.feature.roleplay.roles;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001bJ+\u0010$\u001a\u00020\u001b2\b\b\u0001\u0010%\u001a\u00020&2\u0012\u0010\'\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(\"\u00020)H\u0002\u00a2\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006+"}, d2 = {"Lselfgemma/talk/feature/roleplay/roles/RoleCatalogViewModel;", "Landroidx/lifecycle/ViewModel;", "appContext", "Landroid/content/Context;", "dataStoreRepository", "Lselfgemma/talk/data/DataStoreRepository;", "roleRepository", "Lselfgemma/talk/domain/roleplay/repository/RoleRepository;", "createRoleplaySessionUseCase", "Lselfgemma/talk/domain/roleplay/usecase/CreateRoleplaySessionUseCase;", "importStRoleCardFromUriUseCase", "Lselfgemma/talk/domain/roleplay/usecase/ImportStRoleCardFromUriUseCase;", "compileRuntimeRoleProfileUseCase", "Lselfgemma/talk/domain/roleplay/usecase/CompileRuntimeRoleProfileUseCase;", "<init>", "(Landroid/content/Context;Lselfgemma/talk/data/DataStoreRepository;Lselfgemma/talk/domain/roleplay/repository/RoleRepository;Lselfgemma/talk/domain/roleplay/usecase/CreateRoleplaySessionUseCase;Lselfgemma/talk/domain/roleplay/usecase/ImportStRoleCardFromUriUseCase;Lselfgemma/talk/domain/roleplay/usecase/CompileRuntimeRoleProfileUseCase;)V", "feedbackState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lselfgemma/talk/feature/roleplay/roles/RoleCatalogUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "getSessionPersonaOptions", "", "Lselfgemma/talk/feature/roleplay/roles/SessionPersonaOptionUiState;", "createSession", "", "roleId", "modelId", "personaSlotId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRole", "", "importStRoleCard", "uri", "appString", "resId", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RoleCatalogViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DataStoreRepository dataStoreRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.RoleRepository roleRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.CreateRoleplaySessionUseCase createRoleplaySessionUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.ImportStRoleCardFromUriUseCase importStRoleCardFromUriUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.CompileRuntimeRoleProfileUseCase compileRuntimeRoleProfileUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.feature.roleplay.roles.RoleCatalogUiState> feedbackState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.feature.roleplay.roles.RoleCatalogUiState> uiState = null;
    
    @javax.inject.Inject()
    public RoleCatalogViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DataStoreRepository dataStoreRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.RoleRepository roleRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.CreateRoleplaySessionUseCase createRoleplaySessionUseCase, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.ImportStRoleCardFromUriUseCase importStRoleCardFromUriUseCase, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.CompileRuntimeRoleProfileUseCase compileRuntimeRoleProfileUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.feature.roleplay.roles.RoleCatalogUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.feature.roleplay.roles.SessionPersonaOptionUiState> getSessionPersonaOptions() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createSession(@org.jetbrains.annotations.NotNull()
    java.lang.String roleId, @org.jetbrains.annotations.NotNull()
    java.lang.String modelId, @org.jetbrains.annotations.Nullable()
    java.lang.String personaSlotId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    public final void deleteRole(@org.jetbrains.annotations.NotNull()
    java.lang.String roleId) {
    }
    
    public final void importStRoleCard(@org.jetbrains.annotations.NotNull()
    java.lang.String uri) {
    }
    
    private final java.lang.String appString(@androidx.annotation.StringRes()
    int resId, java.lang.Object... args) {
        return null;
    }
}