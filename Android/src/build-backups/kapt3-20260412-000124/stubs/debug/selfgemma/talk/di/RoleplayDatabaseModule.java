package selfgemma.talk.di;

@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0005H\u0007\u00a8\u0006\u0015"}, d2 = {"Lselfgemma/talk/di/RoleplayDatabaseModule;", "", "<init>", "()V", "provideRoleplayDatabase", "Lselfgemma/talk/data/roleplay/db/RoleplayDatabase;", "context", "Landroid/content/Context;", "provideRoleDao", "Lselfgemma/talk/data/roleplay/db/dao/RoleDao;", "database", "provideSessionDao", "Lselfgemma/talk/data/roleplay/db/dao/SessionDao;", "provideMessageDao", "Lselfgemma/talk/data/roleplay/db/dao/MessageDao;", "provideSessionSummaryDao", "Lselfgemma/talk/data/roleplay/db/dao/SessionSummaryDao;", "provideMemoryDao", "Lselfgemma/talk/data/roleplay/db/dao/MemoryDao;", "provideSessionEventDao", "Lselfgemma/talk/data/roleplay/db/dao/SessionEventDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class RoleplayDatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.di.RoleplayDatabaseModule INSTANCE = null;
    
    private RoleplayDatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.roleplay.db.RoleplayDatabase provideRoleplayDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.roleplay.db.dao.RoleDao provideRoleDao(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.RoleplayDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.roleplay.db.dao.SessionDao provideSessionDao(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.RoleplayDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.roleplay.db.dao.MessageDao provideMessageDao(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.RoleplayDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.roleplay.db.dao.SessionSummaryDao provideSessionSummaryDao(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.RoleplayDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.roleplay.db.dao.MemoryDao provideMemoryDao(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.RoleplayDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.roleplay.db.dao.SessionEventDao provideSessionEventDao(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.RoleplayDatabase database) {
        return null;
    }
}