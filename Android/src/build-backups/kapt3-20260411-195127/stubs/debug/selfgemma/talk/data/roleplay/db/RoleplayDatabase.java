package selfgemma.talk.data.roleplay.db;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&\u00a8\u0006\u0010"}, d2 = {"Lselfgemma/talk/data/roleplay/db/RoleplayDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "roleDao", "Lselfgemma/talk/data/roleplay/db/dao/RoleDao;", "sessionDao", "Lselfgemma/talk/data/roleplay/db/dao/SessionDao;", "messageDao", "Lselfgemma/talk/data/roleplay/db/dao/MessageDao;", "sessionSummaryDao", "Lselfgemma/talk/data/roleplay/db/dao/SessionSummaryDao;", "memoryDao", "Lselfgemma/talk/data/roleplay/db/dao/MemoryDao;", "sessionEventDao", "Lselfgemma/talk/data/roleplay/db/dao/SessionEventDao;", "app_debug"})
@androidx.room.Database(entities = {selfgemma.talk.data.roleplay.db.entity.RoleEntity.class, selfgemma.talk.data.roleplay.db.entity.SessionEntity.class, selfgemma.talk.data.roleplay.db.entity.MessageEntity.class, selfgemma.talk.data.roleplay.db.entity.SessionSummaryEntity.class, selfgemma.talk.data.roleplay.db.entity.MemoryEntity.class, selfgemma.talk.data.roleplay.db.entity.SessionEventEntity.class}, version = 5, exportSchema = true)
@androidx.room.TypeConverters(value = {selfgemma.talk.data.roleplay.db.converter.RoleplayConverters.class})
public abstract class RoleplayDatabase extends androidx.room.RoomDatabase {
    
    public RoleplayDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract selfgemma.talk.data.roleplay.db.dao.RoleDao roleDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract selfgemma.talk.data.roleplay.db.dao.SessionDao sessionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract selfgemma.talk.data.roleplay.db.dao.MessageDao messageDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract selfgemma.talk.data.roleplay.db.dao.SessionSummaryDao sessionSummaryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract selfgemma.talk.data.roleplay.db.dao.MemoryDao memoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract selfgemma.talk.data.roleplay.db.dao.SessionEventDao sessionEventDao();
}