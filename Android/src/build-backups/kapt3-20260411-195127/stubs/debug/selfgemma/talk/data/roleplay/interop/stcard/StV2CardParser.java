package selfgemma.talk.data.roleplay.interop.stcard;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lselfgemma/talk/data/roleplay/interop/stcard/StV2CardParser;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "parse", "Lselfgemma/talk/data/roleplay/interop/stcard/ParsedStCardV2;", "rawJson", "", "extractUnknownTopLevel", "Lcom/google/gson/JsonObject;", "rawObject", "extractUnknownData", "extractUnknownExtensions", "readFromV2", "Lselfgemma/talk/domain/roleplay/model/StCharacterCard;", "card", "humanizedDateTime", "timestamp", "", "Companion", "app_debug"})
public final class StV2CardParser {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ST_V2_SPEC = "chara_card_v2";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ST_V2_SPEC_VERSION = "2.0";
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.data.roleplay.interop.stcard.StV2CardParser.Companion Companion = null;
    
    public StV2CardParser() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.roleplay.interop.stcard.ParsedStCardV2 parse(@org.jetbrains.annotations.NotNull()
    java.lang.String rawJson) {
        return null;
    }
    
    private final com.google.gson.JsonObject extractUnknownTopLevel(com.google.gson.JsonObject rawObject) {
        return null;
    }
    
    private final com.google.gson.JsonObject extractUnknownData(com.google.gson.JsonObject rawObject) {
        return null;
    }
    
    private final com.google.gson.JsonObject extractUnknownExtensions(com.google.gson.JsonObject rawObject) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.model.StCharacterCard readFromV2(selfgemma.talk.domain.roleplay.model.StCharacterCard card) {
        return null;
    }
    
    private final java.lang.String humanizedDateTime(long timestamp) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lselfgemma/talk/data/roleplay/interop/stcard/StV2CardParser$Companion;", "", "<init>", "()V", "ST_V2_SPEC", "", "ST_V2_SPEC_VERSION", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}