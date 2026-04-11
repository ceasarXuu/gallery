package selfgemma.talk.data.roleplay.db.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0016\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0017J6\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001b\u00a8\u0006\u001c\u00c0\u0006\u0003"}, d2 = {"Lselfgemma/talk/data/roleplay/db/dao/MemoryDao;", "", "listByRole", "", "Lselfgemma/talk/data/roleplay/db/entity/MemoryEntity;", "roleId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBySession", "sessionId", "upsert", "", "entity", "(Lselfgemma/talk/data/roleplay/db/entity/MemoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deactivate", "", "memoryId", "updatedAt", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markUsed", "memoryIds", "usedAt", "(Ljava/util/List;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchRelevant", "query", "limit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface MemoryDao {
    
    @androidx.room.Query(value = "\n    SELECT * FROM memories\n    WHERE roleId = :roleId AND active = 1\n    ORDER BY pinned DESC, updatedAt DESC\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object listByRole(@org.jetbrains.annotations.NotNull()
    java.lang.String roleId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.data.roleplay.db.entity.MemoryEntity>> $completion);
    
    @androidx.room.Query(value = "\n    SELECT * FROM memories\n    WHERE sessionId = :sessionId AND active = 1\n    ORDER BY pinned DESC, updatedAt DESC\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object listBySession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.data.roleplay.db.entity.MemoryEntity>> $completion);
    
    @androidx.room.Upsert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.entity.MemoryEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE memories SET active = 0, updatedAt = :updatedAt WHERE id = :memoryId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deactivate(@org.jetbrains.annotations.NotNull()
    java.lang.String memoryId, long updatedAt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "UPDATE memories SET lastUsedAt = :usedAt WHERE id IN (:memoryIds)")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markUsed(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> memoryIds, long usedAt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "\n    SELECT * FROM memories\n    WHERE roleId = :roleId\n      AND active = 1\n      AND (:query = \'\' OR LOWER(content) LIKE \'%\' || LOWER(:query) || \'%\')\n    ORDER BY pinned DESC,\n      CASE WHEN sessionId = :sessionId THEN 1 ELSE 0 END DESC,\n      confidence DESC,\n      updatedAt DESC\n    LIMIT :limit\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchRelevant(@org.jetbrains.annotations.NotNull()
    java.lang.String roleId, @org.jetbrains.annotations.Nullable()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    java.lang.String query, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.data.roleplay.db.entity.MemoryEntity>> $completion);
}