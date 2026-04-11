package selfgemma.talk.data.roleplay.interop.stchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ,\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\tJ \u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lselfgemma/talk/data/roleplay/interop/stchat/StChatInteropMapper;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "importedToMessages", "Lselfgemma/talk/data/roleplay/interop/stchat/ImportedStChatMessages;", "sessionId", "", "parsed", "Lselfgemma/talk/data/roleplay/interop/stchat/ParsedStChatJsonl;", "now", "", "messagesToExport", "", "Lselfgemma/talk/data/roleplay/interop/stchat/StChatMessage;", "messages", "Lselfgemma/talk/domain/roleplay/model/Message;", "roleName", "userName", "defaultNameForMessage", "message", "encodeInteropMetadata", "decodeInteropMetadata", "metadataJson", "KEY_ST_NAME", "KEY_ST_IS_USER", "KEY_ST_IS_SYSTEM", "KEY_ST_SEND_DATE", "KEY_ST_EXTRA_JSON", "KEY_ST_SWIPES_JSON", "KEY_ST_SWIPE_ID", "KEY_ST_SWIPE_INFO_JSON", "KEY_ST_FORCE_AVATAR", "KEY_ST_ORIGINAL_AVATAR", "KEY_ST_GEN_STARTED", "KEY_ST_GEN_FINISHED", "DEFAULT_USER_NAME", "app_debug"})
public final class StChatInteropMapper {
    @org.jetbrains.annotations.NotNull()
    private static final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ST_NAME = "st_name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ST_IS_USER = "st_is_user";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ST_IS_SYSTEM = "st_is_system";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ST_SEND_DATE = "st_send_date";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ST_EXTRA_JSON = "st_extra_json";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ST_SWIPES_JSON = "st_swipes_json";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ST_SWIPE_ID = "st_swipe_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ST_SWIPE_INFO_JSON = "st_swipe_info_json";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ST_FORCE_AVATAR = "st_force_avatar";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ST_ORIGINAL_AVATAR = "st_original_avatar";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ST_GEN_STARTED = "st_gen_started";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ST_GEN_FINISHED = "st_gen_finished";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_USER_NAME = "User";
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.data.roleplay.interop.stchat.StChatInteropMapper INSTANCE = null;
    
    private StChatInteropMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.roleplay.interop.stchat.ImportedStChatMessages importedToMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.interop.stchat.ParsedStChatJsonl parsed, long now) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.roleplay.interop.stchat.StChatMessage> messagesToExport(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.Message> messages, @org.jetbrains.annotations.NotNull()
    java.lang.String roleName, @org.jetbrains.annotations.NotNull()
    java.lang.String userName) {
        return null;
    }
    
    private final java.lang.String defaultNameForMessage(selfgemma.talk.domain.roleplay.model.Message message, java.lang.String roleName, java.lang.String userName) {
        return null;
    }
    
    private final java.lang.String encodeInteropMetadata(selfgemma.talk.data.roleplay.interop.stchat.StChatMessage message) {
        return null;
    }
    
    private final selfgemma.talk.data.roleplay.interop.stchat.StChatMessage decodeInteropMetadata(java.lang.String metadataJson) {
        return null;
    }
}