package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0007H\u0016J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/SampleSessionSeedRoleRepository;", "Lselfgemma/talk/domain/roleplay/repository/RoleRepository;", "role", "Lselfgemma/talk/domain/roleplay/model/RoleCard;", "<init>", "(Lselfgemma/talk/domain/roleplay/model/RoleCard;)V", "observeRoles", "Lkotlinx/coroutines/flow/Flow;", "", "getRole", "roleId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveRole", "", "(Lselfgemma/talk/domain/roleplay/model/RoleCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRole", "app_debugUnitTest"})
final class SampleSessionSeedRoleRepository implements selfgemma.talk.domain.roleplay.repository.RoleRepository {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.RoleCard role = null;
    
    public SampleSessionSeedRoleRepository(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleCard role) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<selfgemma.talk.domain.roleplay.model.RoleCard>> observeRoles() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getRole(@org.jetbrains.annotations.NotNull()
    java.lang.String roleId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.model.RoleCard> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveRole(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleCard role, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteRole(@org.jetbrains.annotations.NotNull()
    java.lang.String roleId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}