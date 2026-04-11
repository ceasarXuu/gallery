package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u00e6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ^2\u00020\u0001:\u0001^BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011JJ\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001eH\u0086B\u00a2\u0006\u0002\u0010\u001fJ0\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150#H\u0086@\u00a2\u0006\u0002\u0010$J6\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001eH\u0086@\u00a2\u0006\u0002\u0010\'Jd\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\f\u00103\u001a\b\u0012\u0004\u0012\u000204012\u0006\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0082@\u00a2\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020)H\u0082@\u00a2\u0006\u0002\u0010BJ \u0010C\u001a\u00020>2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010D\u001a\u0004\u0018\u00010EH\u0082@\u00a2\u0006\u0002\u0010FJ0\u0010G\u001a\u00020>2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010H\u001a\u00020\u00152\u0006\u0010I\u001a\u00020J2\b\u0010D\u001a\u0004\u0018\u00010EH\u0082@\u00a2\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u0002042\u0006\u0010M\u001a\u000204H\u0002JT\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u0002042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010A\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u00152\f\u00103\u001a\b\u0012\u0004\u0012\u000204012\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0006\u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00020SH\u0002JT\u0010T\u001a\u00020U2\u0006\u0010P\u001a\u0002042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010V\u001a\u00020\u00152\u0006\u00106\u001a\u0002072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010R\u001a\u00020S2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001eH\u0082@\u00a2\u0006\u0002\u0010WJ$\u0010X\u001a\u00020Y2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001eH\u0082@\u00a2\u0006\u0002\u0010ZJ,\u0010[\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001501H\u0082@\u00a2\u0006\u0002\u0010]R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006_"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/SendRoleplayMessageUseCase;", "", "dataStoreRepository", "Lselfgemma/talk/data/DataStoreRepository;", "conversationRepository", "Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;", "roleRepository", "Lselfgemma/talk/domain/roleplay/repository/RoleRepository;", "memoryRepository", "Lselfgemma/talk/domain/roleplay/repository/MemoryRepository;", "promptAssembler", "Lselfgemma/talk/domain/roleplay/usecase/PromptAssembler;", "summarizeSessionUseCase", "Lselfgemma/talk/domain/roleplay/usecase/SummarizeSessionUseCase;", "extractMemoriesUseCase", "Lselfgemma/talk/domain/roleplay/usecase/ExtractMemoriesUseCase;", "<init>", "(Lselfgemma/talk/data/DataStoreRepository;Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;Lselfgemma/talk/domain/roleplay/repository/RoleRepository;Lselfgemma/talk/domain/roleplay/repository/MemoryRepository;Lselfgemma/talk/domain/roleplay/usecase/PromptAssembler;Lselfgemma/talk/domain/roleplay/usecase/SummarizeSessionUseCase;Lselfgemma/talk/domain/roleplay/usecase/ExtractMemoriesUseCase;)V", "invoke", "Lselfgemma/talk/domain/roleplay/usecase/SendRoleplayMessageResult;", "sessionId", "", "model", "Lselfgemma/talk/data/Model;", "userInput", "stagedTurn", "Lselfgemma/talk/domain/roleplay/usecase/StagedRoleplayTurn;", "enableStreamingOutput", "", "isStopRequested", "Lkotlin/Function0;", "(Ljava/lang/String;Lselfgemma/talk/data/Model;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/usecase/StagedRoleplayTurn;ZLkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueuePendingMessage", "Lselfgemma/talk/domain/roleplay/usecase/PendingRoleplayMessage;", "persistedUserMessageIds", "", "(Ljava/lang/String;Lselfgemma/talk/domain/roleplay/usecase/StagedRoleplayTurn;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completePendingMessage", "pendingMessage", "(Lselfgemma/talk/domain/roleplay/usecase/PendingRoleplayMessage;Lselfgemma/talk/data/Model;ZLkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assemblePrompt", "Lselfgemma/talk/domain/roleplay/usecase/PromptAssemblyResult;", "runtimeRole", "Lselfgemma/talk/domain/roleplay/model/StChatRuntimeRole;", "runtimeSession", "Lselfgemma/talk/domain/roleplay/model/StChatRuntimeSession;", "summary", "Lselfgemma/talk/domain/roleplay/model/SessionSummary;", "relevantMemories", "", "Lselfgemma/talk/domain/roleplay/model/MemoryItem;", "recentMessages", "Lselfgemma/talk/domain/roleplay/model/Message;", "trimmedInput", "role", "Lselfgemma/talk/domain/roleplay/model/RoleCard;", "contextProfile", "Lselfgemma/talk/domain/roleplay/model/ModelContextProfile;", "budgetMode", "Lselfgemma/talk/domain/roleplay/usecase/PromptBudgetMode;", "(Lselfgemma/talk/domain/roleplay/model/StChatRuntimeRole;Lselfgemma/talk/domain/roleplay/model/StChatRuntimeSession;Lselfgemma/talk/domain/roleplay/model/SessionSummary;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/RoleCard;Lselfgemma/talk/domain/roleplay/model/ModelContextProfile;Lselfgemma/talk/domain/roleplay/usecase/PromptBudgetMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyUpdatedChatMetadata", "", "session", "Lselfgemma/talk/domain/roleplay/model/Session;", "promptAssembly", "(Lselfgemma/talk/domain/roleplay/model/Session;Lselfgemma/talk/domain/roleplay/usecase/PromptAssemblyResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appendBudgetEventIfNeeded", "report", "Lselfgemma/talk/domain/roleplay/usecase/PromptBudgetReport;", "(Ljava/lang/String;Lselfgemma/talk/domain/roleplay/usecase/PromptBudgetReport;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appendOverflowRecoveryEvent", "stage", "retry", "", "(Ljava/lang/String;Ljava/lang/String;ILselfgemma/talk/domain/roleplay/usecase/PromptBudgetReport;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalizeFinalMessage", "message", "prepareConversation", "Lselfgemma/talk/domain/roleplay/usecase/ConversationPreparationResult;", "assistantSeed", "trigger", "startTime", "", "runInferenceAttempt", "Lselfgemma/talk/domain/roleplay/usecase/InferenceAttemptResult;", "input", "(Lselfgemma/talk/domain/roleplay/model/Message;Lselfgemma/talk/data/Model;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/RoleCard;Ljava/lang/String;JZLkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitModelReady", "Lselfgemma/talk/domain/roleplay/usecase/ModelReadinessResult;", "(Lselfgemma/talk/data/Model;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createStagedTurn", "userInputs", "(Ljava/lang/String;Lselfgemma/talk/data/Model;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class SendRoleplayMessageUseCase {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DataStoreRepository dataStoreRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.ConversationRepository conversationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.RoleRepository roleRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.MemoryRepository memoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.PromptAssembler promptAssembler = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.SummarizeSessionUseCase summarizeSessionUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.ExtractMemoriesUseCase extractMemoriesUseCase = null;
    private static final long MODEL_READY_TIMEOUT_MS = 60000L;
    private static final long MODEL_READY_POLL_INTERVAL_MS = 50L;
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.domain.roleplay.usecase.SendRoleplayMessageUseCase.Companion Companion = null;
    
    @javax.inject.Inject()
    public SendRoleplayMessageUseCase(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DataStoreRepository dataStoreRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.ConversationRepository conversationRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.RoleRepository roleRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.MemoryRepository memoryRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.PromptAssembler promptAssembler, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.SummarizeSessionUseCase summarizeSessionUseCase, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.ExtractMemoriesUseCase extractMemoriesUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String userInput, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.usecase.StagedRoleplayTurn stagedTurn, boolean enableStreamingOutput, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> isStopRequested, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.usecase.SendRoleplayMessageResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object enqueuePendingMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.StagedRoleplayTurn stagedTurn, @org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> persistedUserMessageIds, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.usecase.PendingRoleplayMessage> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object completePendingMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.PendingRoleplayMessage pendingMessage, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, boolean enableStreamingOutput, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> isStopRequested, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.usecase.SendRoleplayMessageResult> $completion) {
        return null;
    }
    
    private final java.lang.Object assemblePrompt(selfgemma.talk.domain.roleplay.model.StChatRuntimeRole runtimeRole, selfgemma.talk.domain.roleplay.model.StChatRuntimeSession runtimeSession, selfgemma.talk.domain.roleplay.model.SessionSummary summary, java.util.List<selfgemma.talk.domain.roleplay.model.MemoryItem> relevantMemories, java.util.List<selfgemma.talk.domain.roleplay.model.Message> recentMessages, java.lang.String trimmedInput, selfgemma.talk.domain.roleplay.model.RoleCard role, selfgemma.talk.domain.roleplay.model.ModelContextProfile contextProfile, selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode budgetMode, kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.usecase.PromptAssemblyResult> $completion) {
        return null;
    }
    
    private final java.lang.Object applyUpdatedChatMetadata(selfgemma.talk.domain.roleplay.model.Session session, selfgemma.talk.domain.roleplay.usecase.PromptAssemblyResult promptAssembly, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object appendBudgetEventIfNeeded(java.lang.String sessionId, selfgemma.talk.domain.roleplay.usecase.PromptBudgetReport report, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object appendOverflowRecoveryEvent(java.lang.String sessionId, java.lang.String stage, int retry, selfgemma.talk.domain.roleplay.usecase.PromptBudgetReport report, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.model.Message normalizeFinalMessage(selfgemma.talk.domain.roleplay.model.Message message) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.usecase.ConversationPreparationResult prepareConversation(selfgemma.talk.domain.roleplay.model.Message assistantSeed, selfgemma.talk.data.Model model, selfgemma.talk.domain.roleplay.usecase.PromptAssemblyResult promptAssembly, java.lang.String sessionId, java.util.List<selfgemma.talk.domain.roleplay.model.Message> recentMessages, java.util.List<selfgemma.talk.domain.roleplay.model.MemoryItem> relevantMemories, java.lang.String trigger, long startTime) {
        return null;
    }
    
    private final java.lang.Object runInferenceAttempt(selfgemma.talk.domain.roleplay.model.Message assistantSeed, selfgemma.talk.data.Model model, java.lang.String input, selfgemma.talk.domain.roleplay.model.RoleCard role, java.lang.String sessionId, long startTime, boolean enableStreamingOutput, kotlin.jvm.functions.Function0<java.lang.Boolean> isStopRequested, kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.usecase.InferenceAttemptResult> $completion) {
        return null;
    }
    
    private final java.lang.Object awaitModelReady(selfgemma.talk.data.Model model, kotlin.jvm.functions.Function0<java.lang.Boolean> isStopRequested, kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.usecase.ModelReadinessResult> $completion) {
        return null;
    }
    
    private final java.lang.Object createStagedTurn(java.lang.String sessionId, selfgemma.talk.data.Model model, java.util.List<java.lang.String> userInputs, kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.usecase.StagedRoleplayTurn> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/SendRoleplayMessageUseCase$Companion;", "", "<init>", "()V", "MODEL_READY_TIMEOUT_MS", "", "MODEL_READY_POLL_INTERVAL_MS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}