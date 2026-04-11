package selfgemma.talk.data.roleplay.db.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f\u00c0\u0006\u0003"}, d2 = {"Lselfgemma/talk/data/roleplay/db/dao/SessionEventDao;", "", "listBySession", "", "Lselfgemma/talk/data/roleplay/db/entity/SessionEventEntity;", "sessionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "entity", "(Lselfgemma/talk/data/roleplay/db/entity/SessionEventEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface SessionEventDao {
    
    @androidx.room.Query(value = "\n    SELECT * FROM session_events\n    WHERE sessionId = :sessionId\n    ORDER BY createdAt DESC\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object listBySession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.data.roleplay.db.entity.SessionEventEntity>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.entity.SessionEventEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}