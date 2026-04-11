package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086B\u00a2\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u0014\u0010\u0015\u001a\u00020\r*\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\u0018\u001a\u00020\r*\u00020\u00192\u0006\u0010\u0014\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/SummarizeSessionUseCase;", "", "dataStoreRepository", "Lselfgemma/talk/data/DataStoreRepository;", "conversationRepository", "Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;", "tokenEstimator", "Lselfgemma/talk/domain/roleplay/usecase/TokenEstimator;", "<init>", "(Lselfgemma/talk/data/DataStoreRepository;Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;Lselfgemma/talk/domain/roleplay/usecase/TokenEstimator;)V", "invoke", "", "sessionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildSummary", "previousSummary", "recentMessages", "", "Lselfgemma/talk/domain/roleplay/model/Message;", "userName", "toSummaryLine", "maxLength", "", "toSpeakerLabel", "Lselfgemma/talk/domain/roleplay/model/MessageSide;", "Companion", "app_debug"})
public final class SummarizeSessionUseCase {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DataStoreRepository dataStoreRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.ConversationRepository conversationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.TokenEstimator tokenEstimator = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.text.Regex WHITESPACE_REGEX = null;
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.domain.roleplay.usecase.SummarizeSessionUseCase.Companion Companion = null;
    
    @javax.inject.Inject()
    public SummarizeSessionUseCase(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DataStoreRepository dataStoreRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.ConversationRepository conversationRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.TokenEstimator tokenEstimator) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.String buildSummary(java.lang.String previousSummary, java.util.List<selfgemma.talk.domain.roleplay.model.Message> recentMessages, java.lang.String userName) {
        return null;
    }
    
    private final java.lang.String toSummaryLine(java.lang.String $this$toSummaryLine, int maxLength) {
        return null;
    }
    
    private final java.lang.String toSpeakerLabel(selfgemma.talk.domain.roleplay.model.MessageSide $this$toSpeakerLabel, java.lang.String userName) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/SummarizeSessionUseCase$Companion;", "", "<init>", "()V", "WHITESPACE_REGEX", "Lkotlin/text/Regex;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}