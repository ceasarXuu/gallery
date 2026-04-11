package selfgemma.talk.data.roleplay.interop.stcard;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0012\u0010\u0014\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\f0\u0015H\u0002\u00a8\u0006\u0016"}, d2 = {"Lselfgemma/talk/data/roleplay/interop/stcard/StRoleCardInteropMapper;", "", "<init>", "()V", "importedV2ToRoleCard", "Lselfgemma/talk/domain/roleplay/model/RoleCard;", "parsed", "Lselfgemma/talk/data/roleplay/interop/stcard/ParsedStCardV2;", "now", "", "existingRole", "roleId", "", "roleCardToExportCore", "Lselfgemma/talk/domain/roleplay/model/StCharacterCard;", "role", "mergeInteropState", "Lselfgemma/talk/domain/roleplay/model/RoleInteropState;", "parsedState", "buildFallbackCard", "toMessageExample", "", "app_debug"})
public final class StRoleCardInteropMapper {
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.data.roleplay.interop.stcard.StRoleCardInteropMapper INSTANCE = null;
    
    private StRoleCardInteropMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RoleCard importedV2ToRoleCard(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.interop.stcard.ParsedStCardV2 parsed, long now, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleCard existingRole, @org.jetbrains.annotations.NotNull()
    java.lang.String roleId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.StCharacterCard roleCardToExportCore(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleCard role) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.model.RoleInteropState mergeInteropState(selfgemma.talk.domain.roleplay.model.RoleInteropState parsedState, selfgemma.talk.domain.roleplay.model.RoleCard existingRole) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.model.StCharacterCard buildFallbackCard(selfgemma.talk.domain.roleplay.model.RoleCard role) {
        return null;
    }
    
    private final java.lang.String toMessageExample(java.util.List<java.lang.String> $this$toMessageExample) {
        return null;
    }
}