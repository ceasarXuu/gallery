package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ImportStV2RoleCardUseCase;", "", "<init>", "()V", "parser", "Lselfgemma/talk/data/roleplay/interop/stcard/StV2CardParser;", "importFromJson", "Lselfgemma/talk/domain/roleplay/model/RoleCard;", "rawJson", "", "now", "", "existingRole", "app_debug"})
public final class ImportStV2RoleCardUseCase {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.roleplay.interop.stcard.StV2CardParser parser = null;
    
    @javax.inject.Inject()
    public ImportStV2RoleCardUseCase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.RoleCard importFromJson(@org.jetbrains.annotations.NotNull()
    java.lang.String rawJson, long now, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleCard existingRole) {
        return null;
    }
}