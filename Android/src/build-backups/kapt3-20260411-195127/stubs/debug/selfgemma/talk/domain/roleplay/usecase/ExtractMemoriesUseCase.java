package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 62\u00020\u0001:\u000256B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0086B\u00a2\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0013J0\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u0019J*\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0016H\u0082@\u00a2\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002JO\u0010&\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\'\u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160 2\b\u0010)\u001a\u0004\u0018\u00010\u00112\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-H\u0002\u00a2\u0006\u0002\u0010.J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00160 2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u00100\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u00101\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u00102\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u00103\u001a\u00020+*\u00020\u00162\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00160 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ExtractMemoriesUseCase;", "", "memoryRepository", "Lselfgemma/talk/domain/roleplay/repository/MemoryRepository;", "<init>", "(Lselfgemma/talk/domain/roleplay/repository/MemoryRepository;)V", "invoke", "", "session", "Lselfgemma/talk/domain/roleplay/model/Session;", "role", "Lselfgemma/talk/domain/roleplay/model/RoleCard;", "userMessage", "Lselfgemma/talk/domain/roleplay/model/Message;", "assistantMessage", "(Lselfgemma/talk/domain/roleplay/model/Session;Lselfgemma/talk/domain/roleplay/model/RoleCard;Lselfgemma/talk/domain/roleplay/model/Message;Lselfgemma/talk/domain/roleplay/model/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pinMessage", "Lselfgemma/talk/domain/roleplay/model/MemoryItem;", "message", "(Lselfgemma/talk/domain/roleplay/model/Session;Lselfgemma/talk/domain/roleplay/model/RoleCard;Lselfgemma/talk/domain/roleplay/model/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addManualMemory", "content", "", "category", "Lselfgemma/talk/domain/roleplay/model/MemoryCategory;", "(Lselfgemma/talk/domain/roleplay/model/Session;Lselfgemma/talk/domain/roleplay/model/RoleCard;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/MemoryCategory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadExistingMemories", "", "roleId", "sessionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractFromUserMessage", "", "Lselfgemma/talk/domain/roleplay/usecase/ExtractMemoriesUseCase$MemoryCandidate;", "extractFromAssistantMessage", "inferCandidate", "side", "Lselfgemma/talk/domain/roleplay/model/MessageSide;", "buildMemory", "candidate", "sourceMessageIds", "existing", "pinned", "", "now", "", "(Lselfgemma/talk/domain/roleplay/model/Session;Lselfgemma/talk/domain/roleplay/model/RoleCard;Lselfgemma/talk/domain/roleplay/usecase/ExtractMemoriesUseCase$MemoryCandidate;Ljava/util/List;Lselfgemma/talk/domain/roleplay/model/MemoryItem;Ljava/lang/Boolean;J)Lselfgemma/talk/domain/roleplay/model/MemoryItem;", "splitIntoCandidates", "sanitizeContent", "normalizeForHash", "hashContent", "containsAny", "patterns", "MemoryCandidate", "Companion", "app_debug"})
public final class ExtractMemoriesUseCase {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.MemoryRepository memoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.text.Regex WHITESPACE_REGEX = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.text.Regex SPLIT_REGEX = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> PREFERENCE_PATTERNS = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> RELATION_PATTERNS = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> PLOT_PATTERNS = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> WORLD_PATTERNS = null;
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.domain.roleplay.usecase.ExtractMemoriesUseCase.Companion Companion = null;
    
    @javax.inject.Inject()
    public ExtractMemoriesUseCase(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.MemoryRepository memoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Session session, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleCard role, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Message userMessage, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.Message assistantMessage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object pinMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Session session, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleCard role, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Message message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.model.MemoryItem> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addManualMemory(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Session session, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleCard role, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.MemoryCategory category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.model.MemoryItem> $completion) {
        return null;
    }
    
    private final java.lang.Object loadExistingMemories(java.lang.String roleId, java.lang.String sessionId, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, selfgemma.talk.domain.roleplay.model.MemoryItem>> $completion) {
        return null;
    }
    
    private final java.util.List<selfgemma.talk.domain.roleplay.usecase.ExtractMemoriesUseCase.MemoryCandidate> extractFromUserMessage(java.lang.String content) {
        return null;
    }
    
    private final java.util.List<selfgemma.talk.domain.roleplay.usecase.ExtractMemoriesUseCase.MemoryCandidate> extractFromAssistantMessage(java.lang.String content) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.usecase.ExtractMemoriesUseCase.MemoryCandidate inferCandidate(java.lang.String content, selfgemma.talk.domain.roleplay.model.MessageSide side) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.model.MemoryItem buildMemory(selfgemma.talk.domain.roleplay.model.Session session, selfgemma.talk.domain.roleplay.model.RoleCard role, selfgemma.talk.domain.roleplay.usecase.ExtractMemoriesUseCase.MemoryCandidate candidate, java.util.List<java.lang.String> sourceMessageIds, selfgemma.talk.domain.roleplay.model.MemoryItem existing, java.lang.Boolean pinned, long now) {
        return null;
    }
    
    private final java.util.List<java.lang.String> splitIntoCandidates(java.lang.String content) {
        return null;
    }
    
    private final java.lang.String sanitizeContent(java.lang.String content) {
        return null;
    }
    
    private final java.lang.String normalizeForHash(java.lang.String content) {
        return null;
    }
    
    private final java.lang.String hashContent(java.lang.String content) {
        return null;
    }
    
    private final boolean containsAny(java.lang.String $this$containsAny, java.util.List<java.lang.String> patterns) {
        return false;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ExtractMemoriesUseCase$Companion;", "", "<init>", "()V", "WHITESPACE_REGEX", "Lkotlin/text/Regex;", "SPLIT_REGEX", "PREFERENCE_PATTERNS", "", "", "RELATION_PATTERNS", "PLOT_PATTERNS", "WORLD_PATTERNS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ExtractMemoriesUseCase$MemoryCandidate;", "", "category", "Lselfgemma/talk/domain/roleplay/model/MemoryCategory;", "content", "", "confidence", "", "<init>", "(Lselfgemma/talk/domain/roleplay/model/MemoryCategory;Ljava/lang/String;F)V", "getCategory", "()Lselfgemma/talk/domain/roleplay/model/MemoryCategory;", "getContent", "()Ljava/lang/String;", "getConfidence", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    static final class MemoryCandidate {
        @org.jetbrains.annotations.NotNull()
        private final selfgemma.talk.domain.roleplay.model.MemoryCategory category = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String content = null;
        private final float confidence = 0.0F;
        
        public MemoryCandidate(@org.jetbrains.annotations.NotNull()
        selfgemma.talk.domain.roleplay.model.MemoryCategory category, @org.jetbrains.annotations.NotNull()
        java.lang.String content, float confidence) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final selfgemma.talk.domain.roleplay.model.MemoryCategory getCategory() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getContent() {
            return null;
        }
        
        public final float getConfidence() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final selfgemma.talk.domain.roleplay.model.MemoryCategory component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        public final float component3() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final selfgemma.talk.domain.roleplay.usecase.ExtractMemoriesUseCase.MemoryCandidate copy(@org.jetbrains.annotations.NotNull()
        selfgemma.talk.domain.roleplay.model.MemoryCategory category, @org.jetbrains.annotations.NotNull()
        java.lang.String content, float confidence) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}