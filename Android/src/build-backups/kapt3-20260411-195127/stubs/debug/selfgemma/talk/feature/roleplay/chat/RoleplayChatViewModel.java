package selfgemma.talk.feature.roleplay.chat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001BK\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0015J\u000e\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020!J\u000e\u00103\u001a\u00020/2\u0006\u00104\u001a\u00020\u0015J\u000e\u00105\u001a\u00020/2\u0006\u00106\u001a\u000207J\u0016\u00108\u001a\u00020/2\u0006\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020;J\u0010\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020\u0015H\u0002J\u0010\u0010>\u001a\u00020/2\u0006\u00102\u001a\u00020!H\u0002J\u0010\u0010?\u001a\u00020/2\u0006\u00102\u001a\u00020!H\u0002J\b\u0010@\u001a\u00020/H\u0002J\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010D\u001a\u00020&H\u0082@\u00a2\u0006\u0002\u0010EJ\u0010\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0015H\u0002J\u001e\u0010I\u001a\u00020J2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002070B2\u0006\u00102\u001a\u00020!H\u0002J\b\u0010L\u001a\u00020\u001fH\u0002J\u000e\u0010M\u001a\u00020/H\u0082@\u00a2\u0006\u0002\u0010NJ*\u0010O\u001a\b\u0012\u0004\u0012\u0002070B2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002070B2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020G0BH\u0002J\f\u0010R\u001a\u00020\u0015*\u00020\u0015H\u0002J\b\u0010S\u001a\u00020/H\u0002J\b\u0010T\u001a\u00020/H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-\u00a8\u0006U"}, d2 = {"Lselfgemma/talk/feature/roleplay/chat/RoleplayChatViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "appContext", "Landroid/content/Context;", "dataStoreRepository", "Lselfgemma/talk/data/DataStoreRepository;", "conversationRepository", "Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;", "roleRepository", "Lselfgemma/talk/domain/roleplay/repository/RoleRepository;", "memoryRepository", "Lselfgemma/talk/domain/roleplay/repository/MemoryRepository;", "sendRoleplayMessageUseCase", "Lselfgemma/talk/domain/roleplay/usecase/SendRoleplayMessageUseCase;", "extractMemoriesUseCase", "Lselfgemma/talk/domain/roleplay/usecase/ExtractMemoriesUseCase;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Landroid/content/Context;Lselfgemma/talk/data/DataStoreRepository;Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;Lselfgemma/talk/domain/roleplay/repository/RoleRepository;Lselfgemma/talk/domain/roleplay/repository/MemoryRepository;Lselfgemma/talk/domain/roleplay/usecase/SendRoleplayMessageUseCase;Lselfgemma/talk/domain/roleplay/usecase/ExtractMemoriesUseCase;)V", "sessionId", "", "draft", "Lkotlinx/coroutines/flow/MutableStateFlow;", "metaState", "Lselfgemma/talk/feature/roleplay/chat/RoleplayChatMetaState;", "stopRequested", "", "dispatchJob", "Lkotlinx/coroutines/Job;", "lastDraftEditAtElapsed", "", "latestQueuedModel", "Lselfgemma/talk/data/Model;", "activeAssistantMessageId", "activeDispatchSuperseded", "sessionFlow", "Lkotlinx/coroutines/flow/Flow;", "Lselfgemma/talk/domain/roleplay/model/Session;", "roleFlow", "Lselfgemma/talk/domain/roleplay/model/RoleCard;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lselfgemma/talk/feature/roleplay/chat/RoleplayChatUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateDraft", "", "value", "sendMessage", "model", "switchModel", "modelId", "pinMessage", "message", "Lselfgemma/talk/domain/roleplay/model/Message;", "addManualMemory", "content", "category", "Lselfgemma/talk/domain/roleplay/model/MemoryCategory;", "scheduleDispatch", "reason", "requestMergeAndStop", "dispatchPendingMessages", "refreshSupplementalState", "loadPinnedMemories", "", "Lselfgemma/talk/domain/roleplay/model/MemoryItem;", "session", "(Lselfgemma/talk/domain/roleplay/model/Session;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stagePendingUserMessage", "Lselfgemma/talk/feature/roleplay/chat/QueuedUserMessage;", "input", "stageDispatchTurn", "Lselfgemma/talk/domain/roleplay/usecase/StagedRoleplayTurn;", "userMessages", "remainingDispatchDelay", "retractActiveAssistantBubble", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergeMessages", "messages", "queuedMessages", "escapeJson", "playSendSound", "playReceiveSound", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RoleplayChatViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DataStoreRepository dataStoreRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.ConversationRepository conversationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.RoleRepository roleRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.MemoryRepository memoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.SendRoleplayMessageUseCase sendRoleplayMessageUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.ExtractMemoriesUseCase extractMemoriesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String sessionId = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> draft = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.feature.roleplay.chat.RoleplayChatMetaState> metaState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> stopRequested = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job dispatchJob;
    private long lastDraftEditAtElapsed = 0L;
    @org.jetbrains.annotations.Nullable()
    private selfgemma.talk.data.Model latestQueuedModel;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String activeAssistantMessageId;
    private boolean activeDispatchSuperseded = false;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<selfgemma.talk.domain.roleplay.model.Session> sessionFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<selfgemma.talk.domain.roleplay.model.RoleCard> roleFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.feature.roleplay.chat.RoleplayChatUiState> uiState = null;
    
    @javax.inject.Inject()
    public RoleplayChatViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DataStoreRepository dataStoreRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.ConversationRepository conversationRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.RoleRepository roleRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.MemoryRepository memoryRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.SendRoleplayMessageUseCase sendRoleplayMessageUseCase, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.ExtractMemoriesUseCase extractMemoriesUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.feature.roleplay.chat.RoleplayChatUiState> getUiState() {
        return null;
    }
    
    public final void updateDraft(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
    }
    
    public final void switchModel(@org.jetbrains.annotations.NotNull()
    java.lang.String modelId) {
    }
    
    public final void pinMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Message message) {
    }
    
    public final void addManualMemory(@org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.MemoryCategory category) {
    }
    
    private final void scheduleDispatch(java.lang.String reason) {
    }
    
    private final void requestMergeAndStop(selfgemma.talk.data.Model model) {
    }
    
    private final void dispatchPendingMessages(selfgemma.talk.data.Model model) {
    }
    
    private final void refreshSupplementalState() {
    }
    
    private final java.lang.Object loadPinnedMemories(selfgemma.talk.domain.roleplay.model.Session session, kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.domain.roleplay.model.MemoryItem>> $completion) {
        return null;
    }
    
    private final selfgemma.talk.feature.roleplay.chat.QueuedUserMessage stagePendingUserMessage(java.lang.String input) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.usecase.StagedRoleplayTurn stageDispatchTurn(java.util.List<selfgemma.talk.domain.roleplay.model.Message> userMessages, selfgemma.talk.data.Model model) {
        return null;
    }
    
    private final long remainingDispatchDelay() {
        return 0L;
    }
    
    private final java.lang.Object retractActiveAssistantBubble(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.util.List<selfgemma.talk.domain.roleplay.model.Message> mergeMessages(java.util.List<selfgemma.talk.domain.roleplay.model.Message> messages, java.util.List<selfgemma.talk.feature.roleplay.chat.QueuedUserMessage> queuedMessages) {
        return null;
    }
    
    private final java.lang.String escapeJson(java.lang.String $this$escapeJson) {
        return null;
    }
    
    private final void playSendSound() {
    }
    
    private final void playReceiveSound() {
    }
}