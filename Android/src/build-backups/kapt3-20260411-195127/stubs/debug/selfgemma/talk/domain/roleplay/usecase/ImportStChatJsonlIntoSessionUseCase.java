package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ImportStChatJsonlIntoSessionUseCase;", "", "conversationRepository", "Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;", "importStChatJsonlFromUriUseCase", "Lselfgemma/talk/domain/roleplay/usecase/ImportStChatJsonlFromUriUseCase;", "<init>", "(Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;Lselfgemma/talk/domain/roleplay/usecase/ImportStChatJsonlFromUriUseCase;)V", "importIntoSession", "", "sessionId", "", "uri", "now", "", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ImportStChatJsonlIntoSessionUseCase {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.ConversationRepository conversationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.ImportStChatJsonlFromUriUseCase importStChatJsonlFromUriUseCase = null;
    
    @javax.inject.Inject()
    public ImportStChatJsonlIntoSessionUseCase(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.ConversationRepository conversationRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.ImportStChatJsonlFromUriUseCase importStChatJsonlFromUriUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object importIntoSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    java.lang.String uri, long now, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}