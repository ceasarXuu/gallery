package selfgemma.talk.data.roleplay.db;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u001a0\u0018H\u0014J\u0016\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u00190\u001cH\u0016J*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001a2\u001a\u0010 \u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u0019\u0012\u0004\u0012\u00020\u001d0\u0018H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lselfgemma/talk/data/roleplay/db/RoleplayDatabase_Impl;", "Lselfgemma/talk/data/roleplay/db/RoleplayDatabase;", "<init>", "()V", "_roleDao", "Lkotlin/Lazy;", "Lselfgemma/talk/data/roleplay/db/dao/RoleDao;", "_sessionDao", "Lselfgemma/talk/data/roleplay/db/dao/SessionDao;", "_messageDao", "Lselfgemma/talk/data/roleplay/db/dao/MessageDao;", "_sessionSummaryDao", "Lselfgemma/talk/data/roleplay/db/dao/SessionSummaryDao;", "_memoryDao", "Lselfgemma/talk/data/roleplay/db/dao/MemoryDao;", "_sessionEventDao", "Lselfgemma/talk/data/roleplay/db/dao/SessionEventDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "roleDao", "sessionDao", "messageDao", "sessionSummaryDao", "memoryDao", "sessionEventDao", "app_debug"})
@javax.annotation.processing.Generated(value = {"androidx.room.RoomProcessor"})
@kotlin.Suppress(names = {"UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"})
public final class RoleplayDatabase_Impl extends selfgemma.talk.data.roleplay.db.RoleplayDatabase {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy<selfgemma.talk.data.roleplay.db.dao.RoleDao> _roleDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy<selfgemma.talk.data.roleplay.db.dao.SessionDao> _sessionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy<selfgemma.talk.data.roleplay.db.dao.MessageDao> _messageDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy<selfgemma.talk.data.roleplay.db.dao.SessionSummaryDao> _sessionSummaryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy<selfgemma.talk.data.roleplay.db.dao.MemoryDao> _memoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy<selfgemma.talk.data.roleplay.db.dao.SessionEventDao> _sessionEventDao = null;
    
    public RoleplayDatabase_Impl() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected androidx.room.RoomOpenDelegate createOpenDelegate() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected androidx.room.InvalidationTracker createInvalidationTracker() {
        return null;
    }
    
    @java.lang.Override()
    public void clearAllTables() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected java.util.Map<kotlin.reflect.KClass<?>, java.util.List<kotlin.reflect.KClass<?>>> getRequiredTypeConverterClasses() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<kotlin.reflect.KClass<? extends androidx.room.migration.AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<androidx.room.migration.Migration> createAutoMigrations(@org.jetbrains.annotations.NotNull()
    java.util.Map<kotlin.reflect.KClass<? extends androidx.room.migration.AutoMigrationSpec>, ? extends androidx.room.migration.AutoMigrationSpec> autoMigrationSpecs) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.data.roleplay.db.dao.RoleDao roleDao() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.data.roleplay.db.dao.SessionDao sessionDao() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.data.roleplay.db.dao.MessageDao messageDao() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.data.roleplay.db.dao.SessionSummaryDao sessionSummaryDao() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.data.roleplay.db.dao.MemoryDao memoryDao() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.data.roleplay.db.dao.SessionEventDao sessionEventDao() {
        return null;
    }
}