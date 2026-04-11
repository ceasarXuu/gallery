package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ExportStRoleCardToUriUseCase;", "", "documentRepository", "Lselfgemma/talk/domain/roleplay/repository/RoleplayInteropDocumentRepository;", "exportStV2RoleCardUseCase", "Lselfgemma/talk/domain/roleplay/usecase/ExportStV2RoleCardUseCase;", "<init>", "(Lselfgemma/talk/domain/roleplay/repository/RoleplayInteropDocumentRepository;Lselfgemma/talk/domain/roleplay/usecase/ExportStV2RoleCardUseCase;)V", "exportToUri", "", "uri", "", "role", "Lselfgemma/talk/domain/roleplay/model/RoleCard;", "(Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/RoleCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class ExportStRoleCardToUriUseCase {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.RoleplayInteropDocumentRepository documentRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.ExportStV2RoleCardUseCase exportStV2RoleCardUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy<byte[]> DEFAULT_PLACEHOLDER_PNG$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final selfgemma.talk.domain.roleplay.usecase.ExportStRoleCardToUriUseCase.Companion Companion = null;
    
    @javax.inject.Inject()
    public ExportStRoleCardToUriUseCase(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.RoleplayInteropDocumentRepository documentRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.ExportStV2RoleCardUseCase exportStV2RoleCardUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object exportToUri(@org.jetbrains.annotations.NotNull()
    java.lang.String uri, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleCard role, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ExportStRoleCardToUriUseCase$Companion;", "", "<init>", "()V", "DEFAULT_PLACEHOLDER_PNG", "", "getDEFAULT_PLACEHOLDER_PNG", "()[B", "DEFAULT_PLACEHOLDER_PNG$delegate", "Lkotlin/Lazy;", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final byte[] getDEFAULT_PLACEHOLDER_PNG() {
            return null;
        }
    }
}