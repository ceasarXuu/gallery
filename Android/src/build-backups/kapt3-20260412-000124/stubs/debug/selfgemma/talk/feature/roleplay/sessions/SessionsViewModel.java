package selfgemma.talk.feature.roleplay.sessions;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \'2\u00020\u0001:\u0001\'B;\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aJ\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aJ+\u0010 \u001a\u00020\u001a2\b\b\u0001\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0$\"\u00020%H\u0002\u00a2\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006("}, d2 = {"Lselfgemma/talk/feature/roleplay/sessions/SessionsViewModel;", "Landroidx/lifecycle/ViewModel;", "appContext", "Landroid/content/Context;", "conversationRepository", "Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;", "roleRepository", "Lselfgemma/talk/domain/roleplay/repository/RoleRepository;", "ensureRoleplaySeedData", "Lselfgemma/talk/domain/roleplay/usecase/EnsureRoleplaySeedDataUseCase;", "importStChatJsonlIntoSessionUseCase", "Lselfgemma/talk/domain/roleplay/usecase/ImportStChatJsonlIntoSessionUseCase;", "exportStChatJsonlFromSessionUseCase", "Lselfgemma/talk/domain/roleplay/usecase/ExportStChatJsonlFromSessionUseCase;", "<init>", "(Landroid/content/Context;Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;Lselfgemma/talk/domain/roleplay/repository/RoleRepository;Lselfgemma/talk/domain/roleplay/usecase/EnsureRoleplaySeedDataUseCase;Lselfgemma/talk/domain/roleplay/usecase/ImportStChatJsonlIntoSessionUseCase;Lselfgemma/talk/domain/roleplay/usecase/ExportStChatJsonlFromSessionUseCase;)V", "feedbackState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lselfgemma/talk/feature/roleplay/sessions/SessionsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "togglePin", "", "sessionId", "", "archiveSession", "deleteSession", "importChatJsonl", "uri", "exportChatJsonl", "appString", "resId", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SessionsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.ConversationRepository conversationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.ImportStChatJsonlIntoSessionUseCase importStChatJsonlIntoSessionUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.ExportStChatJsonlFromSessionUseCase exportStChatJsonlFromSessionUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "SessionsViewModel";
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.feature.roleplay.sessions.SessionsUiState> feedbackState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.feature.roleplay.sessions.SessionsUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.feature.roleplay.sessions.SessionsViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public SessionsViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.ConversationRepository conversationRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.RoleRepository roleRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.EnsureRoleplaySeedDataUseCase ensureRoleplaySeedData, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.ImportStChatJsonlIntoSessionUseCase importStChatJsonlIntoSessionUseCase, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.ExportStChatJsonlFromSessionUseCase exportStChatJsonlFromSessionUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.feature.roleplay.sessions.SessionsUiState> getUiState() {
        return null;
    }
    
    public final void togglePin(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId) {
    }
    
    public final void archiveSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId) {
    }
    
    public final void deleteSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId) {
    }
    
    public final void importChatJsonl(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    java.lang.String uri) {
    }
    
    public final void exportChatJsonl(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    java.lang.String uri) {
    }
    
    private final java.lang.String appString(@androidx.annotation.StringRes()
    int resId, java.lang.Object... args) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lselfgemma/talk/feature/roleplay/sessions/SessionsViewModel$Companion;", "", "<init>", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}