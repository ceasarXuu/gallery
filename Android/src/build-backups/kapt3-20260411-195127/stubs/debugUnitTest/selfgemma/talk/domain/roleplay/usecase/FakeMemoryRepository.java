package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\u000eJ$\u0010\u0017\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@\u00a2\u0006\u0002\u0010\u001bJ6\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@\u00a2\u0006\u0002\u0010 R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006!"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/FakeMemoryRepository;", "Lselfgemma/talk/domain/roleplay/repository/MemoryRepository;", "<init>", "()V", "memories", "Ljava/util/LinkedHashMap;", "", "Lselfgemma/talk/domain/roleplay/model/MemoryItem;", "Lkotlin/collections/LinkedHashMap;", "getMemories", "()Ljava/util/LinkedHashMap;", "listRoleMemories", "", "roleId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listSessionMemories", "sessionId", "upsert", "", "memory", "(Lselfgemma/talk/domain/roleplay/model/MemoryItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deactivate", "memoryId", "markUsed", "memoryIds", "usedAt", "", "(Ljava/util/List;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchRelevant", "query", "limit", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debugUnitTest"})
final class FakeMemoryRepository implements selfgemma.talk.domain.roleplay.repository.MemoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final java.util.LinkedHashMap<java.lang.String, selfgemma.talk.domain.roleplay.model.MemoryItem> memories = null;
    
    public FakeMemoryRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.LinkedHashMap<java.lang.String, selfgemma.talk.domain.roleplay.model.MemoryItem> getMemories() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object listRoleMemories(@org.jetbrains.annotations.NotNull()
    java.lang.String roleId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.domain.roleplay.model.MemoryItem>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object listSessionMemories(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.domain.roleplay.model.MemoryItem>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.MemoryItem memory, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deactivate(@org.jetbrains.annotations.NotNull()
    java.lang.String memoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object markUsed(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> memoryIds, long usedAt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object searchRelevant(@org.jetbrains.annotations.NotNull()
    java.lang.String roleId, @org.jetbrains.annotations.Nullable()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    java.lang.String query, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.domain.roleplay.model.MemoryItem>> $completion) {
        return null;
    }
}