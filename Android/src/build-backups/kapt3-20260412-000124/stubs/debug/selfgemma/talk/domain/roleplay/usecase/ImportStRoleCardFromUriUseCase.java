package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0014\u0010\u001b\u001a\u00020\r*\u00020\u00192\u0006\u0010\u001c\u001a\u00020\rH\u0002J%\u0010\u001d\u001a\u00020\r*\u00020\u00192\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u001f\"\u00020\rH\u0002\u00a2\u0006\u0002\u0010 J\u001b\u0010!\u001a\u0004\u0018\u00010\"*\u00020\u00192\u0006\u0010\u001c\u001a\u00020\rH\u0002\u00a2\u0006\u0002\u0010#J\u001b\u0010$\u001a\u0004\u0018\u00010%*\u00020\u00192\u0006\u0010\u001c\u001a\u00020\rH\u0002\u00a2\u0006\u0002\u0010&J\f\u0010\'\u001a\u00020(*\u00020\u0019H\u0002J\u0014\u0010)\u001a\u00020(*\u00020\u00192\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0016\u0010*\u001a\u0004\u0018\u00010\u0019*\u00020\u00192\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0012\u0010+\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/ImportStRoleCardFromUriUseCase;", "", "appContext", "Landroid/content/Context;", "documentRepository", "Lselfgemma/talk/domain/roleplay/repository/RoleplayInteropDocumentRepository;", "importStV2RoleCardUseCase", "Lselfgemma/talk/domain/roleplay/usecase/ImportStV2RoleCardUseCase;", "<init>", "(Landroid/content/Context;Lselfgemma/talk/domain/roleplay/repository/RoleplayInteropDocumentRepository;Lselfgemma/talk/domain/roleplay/usecase/ImportStV2RoleCardUseCase;)V", "importFromUri", "Lselfgemma/talk/domain/roleplay/model/RoleCard;", "uri", "", "existingRole", "now", "", "(Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/RoleCard;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistImportedPngAvatar", "roleId", "pngBytes", "", "normalizeSupportedSpec", "rawJson", "normalizeLegacyCard", "Lcom/google/gson/JsonObject;", "jsonObject", "stringValue", "key", "firstStringValue", "keys", "", "(Lcom/google/gson/JsonObject;[Ljava/lang/String;)Ljava/lang/String;", "doubleValue", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Double;", "booleanValue", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "toTagArray", "Lcom/google/gson/JsonArray;", "toJsonStringArray", "objectValue", "humanizedDateTime", "timestamp", "app_debug"})
public final class ImportStRoleCardFromUriUseCase {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.repository.RoleplayInteropDocumentRepository documentRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.ImportStV2RoleCardUseCase importStV2RoleCardUseCase = null;
    
    @javax.inject.Inject()
    public ImportStRoleCardFromUriUseCase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.repository.RoleplayInteropDocumentRepository documentRepository, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.ImportStV2RoleCardUseCase importStV2RoleCardUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object importFromUri(@org.jetbrains.annotations.NotNull()
    java.lang.String uri, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleCard existingRole, long now, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.model.RoleCard> $completion) {
        return null;
    }
    
    private final java.lang.String persistImportedPngAvatar(java.lang.String roleId, byte[] pngBytes) {
        return null;
    }
    
    private final java.lang.String normalizeSupportedSpec(java.lang.String rawJson) {
        return null;
    }
    
    private final com.google.gson.JsonObject normalizeLegacyCard(com.google.gson.JsonObject jsonObject) {
        return null;
    }
    
    private final java.lang.String stringValue(com.google.gson.JsonObject $this$stringValue, java.lang.String key) {
        return null;
    }
    
    private final java.lang.String firstStringValue(com.google.gson.JsonObject $this$firstStringValue, java.lang.String... keys) {
        return null;
    }
    
    private final java.lang.Double doubleValue(com.google.gson.JsonObject $this$doubleValue, java.lang.String key) {
        return null;
    }
    
    private final java.lang.Boolean booleanValue(com.google.gson.JsonObject $this$booleanValue, java.lang.String key) {
        return null;
    }
    
    private final com.google.gson.JsonArray toTagArray(com.google.gson.JsonObject $this$toTagArray) {
        return null;
    }
    
    private final com.google.gson.JsonArray toJsonStringArray(com.google.gson.JsonObject $this$toJsonStringArray, java.lang.String key) {
        return null;
    }
    
    private final com.google.gson.JsonObject objectValue(com.google.gson.JsonObject $this$objectValue, java.lang.String key) {
        return null;
    }
    
    private final java.lang.String humanizedDateTime(long timestamp) {
        return null;
    }
}