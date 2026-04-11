package selfgemma.talk.data.roleplay.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ$\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@\u00a2\u0006\u0002\u0010\u0018J6\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@\u00a2\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lselfgemma/talk/data/roleplay/repository/RoomMemoryRepository;", "Lselfgemma/talk/domain/roleplay/repository/MemoryRepository;", "memoryDao", "Lselfgemma/talk/data/roleplay/db/dao/MemoryDao;", "<init>", "(Lselfgemma/talk/data/roleplay/db/dao/MemoryDao;)V", "listRoleMemories", "", "Lselfgemma/talk/domain/roleplay/model/MemoryItem;", "roleId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listSessionMemories", "sessionId", "upsert", "", "memory", "(Lselfgemma/talk/domain/roleplay/model/MemoryItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deactivate", "memoryId", "markUsed", "memoryIds", "usedAt", "", "(Ljava/util/List;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchRelevant", "query", "limit", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RoomMemoryRepository implements selfgemma.talk.domain.roleplay.repository.MemoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.roleplay.db.dao.MemoryDao memoryDao = null;
    
    @javax.inject.Inject()
    public RoomMemoryRepository(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.dao.MemoryDao memoryDao) {
        super();
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