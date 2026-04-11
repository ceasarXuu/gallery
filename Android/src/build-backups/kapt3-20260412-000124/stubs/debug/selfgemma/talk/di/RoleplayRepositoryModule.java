package selfgemma.talk.di;

@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\rH\'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0010H\'\u00a8\u0006\u0011"}, d2 = {"Lselfgemma/talk/di/RoleplayRepositoryModule;", "", "<init>", "()V", "bindConversationRepository", "Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;", "implementation", "Lselfgemma/talk/data/roleplay/repository/RoomConversationRepository;", "bindRoleRepository", "Lselfgemma/talk/domain/roleplay/repository/RoleRepository;", "Lselfgemma/talk/data/roleplay/repository/RoomRoleRepository;", "bindMemoryRepository", "Lselfgemma/talk/domain/roleplay/repository/MemoryRepository;", "Lselfgemma/talk/data/roleplay/repository/RoomMemoryRepository;", "bindRoleplayInteropDocumentRepository", "Lselfgemma/talk/domain/roleplay/repository/RoleplayInteropDocumentRepository;", "Lselfgemma/talk/data/roleplay/repository/AndroidRoleplayInteropDocumentRepository;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RoleplayRepositoryModule {
    
    public RoleplayRepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract selfgemma.talk.domain.roleplay.repository.ConversationRepository bindConversationRepository(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.repository.RoomConversationRepository implementation);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract selfgemma.talk.domain.roleplay.repository.RoleRepository bindRoleRepository(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.repository.RoomRoleRepository implementation);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract selfgemma.talk.domain.roleplay.repository.MemoryRepository bindMemoryRepository(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.repository.RoomMemoryRepository implementation);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract selfgemma.talk.domain.roleplay.repository.RoleplayInteropDocumentRepository bindRoleplayInteropDocumentRepository(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.repository.AndroidRoleplayInteropDocumentRepository implementation);
}