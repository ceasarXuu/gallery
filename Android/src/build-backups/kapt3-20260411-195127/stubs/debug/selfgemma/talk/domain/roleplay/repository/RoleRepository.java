package selfgemma.talk.domain.roleplay.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\u000f\u00c0\u0006\u0003"}, d2 = {"Lselfgemma/talk/domain/roleplay/repository/RoleRepository;", "", "observeRoles", "Lkotlinx/coroutines/flow/Flow;", "", "Lselfgemma/talk/domain/roleplay/model/RoleCard;", "getRole", "roleId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveRole", "", "role", "(Lselfgemma/talk/domain/roleplay/model/RoleCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRole", "app_debug"})
public abstract interface RoleRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<selfgemma.talk.domain.roleplay.model.RoleCard>> observeRoles();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRole(@org.jetbrains.annotations.NotNull()
    java.lang.String roleId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.model.RoleCard> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveRole(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleCard role, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteRole(@org.jetbrains.annotations.NotNull()
    java.lang.String roleId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}