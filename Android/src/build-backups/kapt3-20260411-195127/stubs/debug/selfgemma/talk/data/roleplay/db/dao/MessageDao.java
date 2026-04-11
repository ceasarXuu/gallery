package selfgemma.talk.data.roleplay.db.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ&\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0018J.\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u00a7@\u00a2\u0006\u0002\u0010#\u00a8\u0006$\u00c0\u0006\u0003"}, d2 = {"Lselfgemma/talk/data/roleplay/db/dao/MessageDao;", "", "observeBySession", "Lkotlinx/coroutines/flow/Flow;", "", "Lselfgemma/talk/data/roleplay/db/entity/MessageEntity;", "sessionId", "", "listBySession", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listLatest", "limit", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMaxSeq", "countBySideAndStatus", "side", "Lselfgemma/talk/domain/roleplay/model/MessageSide;", "status", "Lselfgemma/talk/domain/roleplay/model/MessageStatus;", "(Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/MessageSide;Lselfgemma/talk/domain/roleplay/model/MessageStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "entity", "(Lselfgemma/talk/data/roleplay/db/entity/MessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "entities", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBySession", "update", "updateStreamingContent", "messageId", "content", "updatedAt", "", "(Ljava/lang/String;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/MessageStatus;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface MessageDao {
    
    @androidx.room.Query(value = "\n    SELECT * FROM messages\n    WHERE sessionId = :sessionId\n    ORDER BY seq ASC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<selfgemma.talk.data.roleplay.db.entity.MessageEntity>> observeBySession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId);
    
    @androidx.room.Query(value = "\n    SELECT * FROM messages\n    WHERE sessionId = :sessionId\n    ORDER BY seq ASC\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object listBySession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.data.roleplay.db.entity.MessageEntity>> $completion);
    
    @androidx.room.Query(value = "\n    SELECT * FROM messages\n    WHERE sessionId = :sessionId\n    ORDER BY seq DESC\n    LIMIT :limit\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object listLatest(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.data.roleplay.db.entity.MessageEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT COALESCE(MAX(seq), 0) FROM messages WHERE sessionId = :sessionId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMaxSeq(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "\n    SELECT COUNT(*) FROM messages\n    WHERE sessionId = :sessionId AND side = :side AND status = :status\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countBySideAndStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.MessageSide side, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.MessageStatus status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.entity.MessageEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.roleplay.db.entity.MessageEntity> entities, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM messages WHERE sessionId = :sessionId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteBySession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.entity.MessageEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "\n    UPDATE messages\n    SET content = :content, updatedAt = :updatedAt, status = :status\n    WHERE id = :messageId\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateStreamingContent(@org.jetbrains.annotations.NotNull()
    java.lang.String messageId, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.MessageStatus status, long updatedAt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}