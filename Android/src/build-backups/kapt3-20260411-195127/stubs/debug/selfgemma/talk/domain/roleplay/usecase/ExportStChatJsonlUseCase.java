package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ExportStChatJsonlUseCase;", "", "<init>", "()V", "serializer", "Lselfgemma/talk/data/roleplay/interop/stchat/StChatJsonlSerializer;", "exportToJsonl", "", "chatMetadataJson", "userName", "roleName", "messages", "", "Lselfgemma/talk/domain/roleplay/model/Message;", "app_debug"})
public final class ExportStChatJsonlUseCase {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.roleplay.interop.stchat.StChatJsonlSerializer serializer = null;
    
    @javax.inject.Inject()
    public ExportStChatJsonlUseCase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String exportToJsonl(@org.jetbrains.annotations.NotNull()
    java.lang.String chatMetadataJson, @org.jetbrains.annotations.Nullable()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String roleName, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.Message> messages) {
        return null;
    }
}