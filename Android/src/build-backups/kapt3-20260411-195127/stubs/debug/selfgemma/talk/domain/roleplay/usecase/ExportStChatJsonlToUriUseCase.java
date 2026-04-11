package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J>\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ExportStChatJsonlToUriUseCase;", "", "documentRepository", "Lselfgemma/talk/domain/roleplay/repository/RoleplayInteropDocumentRepository;", "exportStChatJsonlUseCase", "Lselfgemma/talk/domain/roleplay/usecase/ExportStChatJsonlUseCase;", "<init>", "(Lselfgemma/talk/domain/roleplay/repository/RoleplayInteropDocumentRepository;Lselfgemma/talk/domain/roleplay/usecase/ExportStChatJsonlUseCase;)V", "exportToUri", "", "uri", "", "chatMetadataJson", "userName", "roleName", "messages", "", "Lselfgemma/talk/domain/roleplay/model/Message;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ExportStChatJsonlToUriUseCase {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.RoleplayInteropDocumentRepository documentRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.ExportStChatJsonlUseCase exportStChatJsonlUseCase = null;
    
    @javax.inject.Inject()
    public ExportStChatJsonlToUriUseCase(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.RoleplayInteropDocumentRepository documentRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.ExportStChatJsonlUseCase exportStChatJsonlUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object exportToUri(@org.jetbrains.annotations.NotNull()
    java.lang.String uri, @org.jetbrains.annotations.NotNull()
    java.lang.String chatMetadataJson, @org.jetbrains.annotations.Nullable()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String roleName, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.Message> messages, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}