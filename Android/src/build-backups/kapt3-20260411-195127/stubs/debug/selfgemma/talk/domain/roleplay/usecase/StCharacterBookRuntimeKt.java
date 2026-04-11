package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000v\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\f\u0010\n\u001a\u00020\t*\u00020\u000bH\u0002\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002\u001aI\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0002\u00a2\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0007H\u0002\u001a\f\u0010\u001b\u001a\u00020\u0015*\u00020\u0001H\u0002\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0015H\u0002\u001a\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020 H\u0002\u001a2\u0010$\u001a\u00020\u0015*\u00020 2\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u000e2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00172\u0006\u0010(\u001a\u00020\u0004H\u0002\u001a\"\u0010)\u001a\u00020**\u00020 2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00172\u0006\u0010(\u001a\u00020\u0004H\u0002\u001a\u0014\u0010,\u001a\u00020 *\u00020 2\u0006\u0010-\u001a\u00020\u0001H\u0002\u001a\u001b\u0010.\u001a\u0004\u0018\u00010\u0004*\u00020 2\u0006\u0010-\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u0010/\u001a\u001b\u00100\u001a\u0004\u0018\u000101*\u00020 2\u0006\u0010-\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u00102\u001a\u001b\u00103\u001a\u0004\u0018\u00010\u0015*\u00020 2\u0006\u0010-\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u00104\u001a\u0016\u00105\u001a\u0004\u0018\u00010\u0001*\u00020 2\u0006\u0010-\u001a\u00020\u0001H\u0002\u001a\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017*\u00020 2\u0006\u0010-\u001a\u00020\u0001H\u0002\u001a\u0013\u00107\u001a\u00020\u0001*\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0002\u00108\u001a\f\u00109\u001a\u00020\r*\u00020\u0004H\u0000\u001a\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0001H\u0002\u001a\u0010\u0010=\u001a\u0004\u0018\u00010>*\u0004\u0018\u00010 H\u0002\u001a\u0014\u0010?\u001a\u00020\u0015*\u00020\u000e2\u0006\u0010@\u001a\u00020\u0010H\u0002\u001a\f\u0010A\u001a\u00020\u0001*\u00020\u000eH\u0002\u00a8\u0006B"}, d2 = {"stableKey", "", "Lselfgemma/talk/domain/roleplay/model/StCharacterBookEntry;", "index", "", "normalizedContent", "toRuntimeExtensions", "Lselfgemma/talk/domain/roleplay/usecase/StBookEntryRuntimeExtensions;", "runtimeSettings", "Lselfgemma/talk/domain/roleplay/usecase/StWorldRuntimeSettings;", "toRuntimeSettings", "Lselfgemma/talk/domain/roleplay/model/StCharacterBook;", "resolvePromptPosition", "Lselfgemma/talk/domain/roleplay/usecase/StWorldInfoPosition;", "Lselfgemma/talk/domain/roleplay/usecase/RuntimeEntry;", "toScanText", "Lselfgemma/talk/domain/roleplay/usecase/StWorldScanContext;", "extensions", "defaultScanDepth", "scanDepthSkew", "includeRecursionBuffer", "", "recursionBuffer", "", "(Lselfgemma/talk/domain/roleplay/usecase/StWorldScanContext;Lselfgemma/talk/domain/roleplay/usecase/StBookEntryRuntimeExtensions;Lselfgemma/talk/domain/roleplay/usecase/StWorldRuntimeSettings;Ljava/lang/Integer;IZLjava/util/List;)Ljava/lang/String;", "matchesKeyword", "keyword", "isRegexPattern", "toRegexOrNull", "Lkotlin/text/Regex;", "caseSensitive", "parseChatMetadata", "Lcom/google/gson/JsonObject;", "chatMetadataJson", "serializeChatMetadata", "metadata", "isTimedEffectActive", "type", "entry", "allEntries", "chatLength", "setTimedEffects", "", "entries", "getOrCreateObject", "key", "intOrNull", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "doubleOrNull", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Double;", "booleanOrNull", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "stringOrNull", "stringListOrEmpty", "toPromptRoleName", "(Ljava/lang/Integer;)Ljava/lang/String;", "toWorldInfoPosition", "parseDecorators", "Lselfgemma/talk/domain/roleplay/usecase/ParsedDecorators;", "content", "toCharacterFilter", "Lselfgemma/talk/domain/roleplay/usecase/StCharacterFilter;", "isFilteredOut", "context", "timedEffectKey", "app_debug"})
public final class StCharacterBookRuntimeKt {
    
    private static final java.lang.String stableKey(selfgemma.talk.domain.roleplay.model.StCharacterBookEntry $this$stableKey, int index) {
        return null;
    }
    
    private static final java.lang.String stableKey(selfgemma.talk.domain.roleplay.model.StCharacterBookEntry $this$stableKey, int index, java.lang.String normalizedContent) {
        return null;
    }
    
    private static final selfgemma.talk.domain.roleplay.usecase.StBookEntryRuntimeExtensions toRuntimeExtensions(selfgemma.talk.domain.roleplay.model.StCharacterBookEntry $this$toRuntimeExtensions, selfgemma.talk.domain.roleplay.usecase.StWorldRuntimeSettings runtimeSettings) {
        return null;
    }
    
    private static final selfgemma.talk.domain.roleplay.usecase.StWorldRuntimeSettings toRuntimeSettings(selfgemma.talk.domain.roleplay.model.StCharacterBook $this$toRuntimeSettings) {
        return null;
    }
    
    private static final selfgemma.talk.domain.roleplay.usecase.StWorldInfoPosition resolvePromptPosition(selfgemma.talk.domain.roleplay.usecase.RuntimeEntry $this$resolvePromptPosition) {
        return null;
    }
    
    private static final java.lang.String toScanText(selfgemma.talk.domain.roleplay.usecase.StWorldScanContext $this$toScanText, selfgemma.talk.domain.roleplay.usecase.StBookEntryRuntimeExtensions extensions, selfgemma.talk.domain.roleplay.usecase.StWorldRuntimeSettings runtimeSettings, java.lang.Integer defaultScanDepth, int scanDepthSkew, boolean includeRecursionBuffer, java.util.List<java.lang.String> recursionBuffer) {
        return null;
    }
    
    private static final boolean matchesKeyword(java.lang.String $this$matchesKeyword, java.lang.String keyword, selfgemma.talk.domain.roleplay.usecase.StBookEntryRuntimeExtensions extensions) {
        return false;
    }
    
    private static final boolean isRegexPattern(java.lang.String $this$isRegexPattern) {
        return false;
    }
    
    private static final kotlin.text.Regex toRegexOrNull(java.lang.String $this$toRegexOrNull, boolean caseSensitive) {
        return null;
    }
    
    private static final com.google.gson.JsonObject parseChatMetadata(java.lang.String chatMetadataJson) {
        return null;
    }
    
    private static final java.lang.String serializeChatMetadata(com.google.gson.JsonObject metadata) {
        return null;
    }
    
    private static final boolean isTimedEffectActive(com.google.gson.JsonObject $this$isTimedEffectActive, java.lang.String type, selfgemma.talk.domain.roleplay.usecase.RuntimeEntry entry, java.util.List<selfgemma.talk.domain.roleplay.usecase.RuntimeEntry> allEntries, int chatLength) {
        return false;
    }
    
    private static final void setTimedEffects(com.google.gson.JsonObject $this$setTimedEffects, java.util.List<selfgemma.talk.domain.roleplay.usecase.RuntimeEntry> entries, int chatLength) {
    }
    
    private static final com.google.gson.JsonObject getOrCreateObject(com.google.gson.JsonObject $this$getOrCreateObject, java.lang.String key) {
        return null;
    }
    
    private static final java.lang.Integer intOrNull(com.google.gson.JsonObject $this$intOrNull, java.lang.String key) {
        return null;
    }
    
    private static final java.lang.Double doubleOrNull(com.google.gson.JsonObject $this$doubleOrNull, java.lang.String key) {
        return null;
    }
    
    private static final java.lang.Boolean booleanOrNull(com.google.gson.JsonObject $this$booleanOrNull, java.lang.String key) {
        return null;
    }
    
    private static final java.lang.String stringOrNull(com.google.gson.JsonObject $this$stringOrNull, java.lang.String key) {
        return null;
    }
    
    private static final java.util.List<java.lang.String> stringListOrEmpty(com.google.gson.JsonObject $this$stringListOrEmpty, java.lang.String key) {
        return null;
    }
    
    private static final java.lang.String toPromptRoleName(java.lang.Integer $this$toPromptRoleName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.domain.roleplay.usecase.StWorldInfoPosition toWorldInfoPosition(int $this$toWorldInfoPosition) {
        return null;
    }
    
    private static final selfgemma.talk.domain.roleplay.usecase.ParsedDecorators parseDecorators(java.lang.String content) {
        return null;
    }
    
    private static final selfgemma.talk.domain.roleplay.usecase.StCharacterFilter toCharacterFilter(com.google.gson.JsonObject $this$toCharacterFilter) {
        return null;
    }
    
    private static final boolean isFilteredOut(selfgemma.talk.domain.roleplay.usecase.RuntimeEntry $this$isFilteredOut, selfgemma.talk.domain.roleplay.usecase.StWorldScanContext context) {
        return false;
    }
    
    private static final java.lang.String timedEffectKey(selfgemma.talk.domain.roleplay.usecase.RuntimeEntry $this$timedEffectKey) {
        return null;
    }
}