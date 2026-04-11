package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ImportStChatJsonlUseCase;", "", "<init>", "()V", "parser", "Lselfgemma/talk/data/roleplay/interop/stchat/StChatJsonlParser;", "importFromJsonl", "Lselfgemma/talk/data/roleplay/interop/stchat/ImportedStChatMessages;", "sessionId", "", "rawJsonl", "now", "", "app_debug"})
public final class ImportStChatJsonlUseCase {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.roleplay.interop.stchat.StChatJsonlParser parser = null;
    
    @javax.inject.Inject()
    public ImportStChatJsonlUseCase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.roleplay.interop.stchat.ImportedStChatMessages importFromJsonl(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    java.lang.String rawJsonl, long now) {
        return null;
    }
}