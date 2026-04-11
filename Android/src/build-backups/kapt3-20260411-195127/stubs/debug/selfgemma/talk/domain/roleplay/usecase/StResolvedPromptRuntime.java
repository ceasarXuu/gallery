package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u00c6\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u00c6\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u00c6\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u00c6\u0003J\u001b\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\rH\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0095\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020+H\u00d6\u0001J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012\u00a8\u0006-"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/StResolvedPromptRuntime;", "", "beforePrompt", "", "afterPrompt", "authorNoteBefore", "", "authorNoteAfter", "exampleBefore", "exampleAfter", "depthPrompts", "Lselfgemma/talk/domain/roleplay/usecase/StRuntimeDepthPromptInsertion;", "outletEntries", "", "updatedChatMetadataJson", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getBeforePrompt", "()Ljava/lang/String;", "getAfterPrompt", "getAuthorNoteBefore", "()Ljava/util/List;", "getAuthorNoteAfter", "getExampleBefore", "getExampleAfter", "getDepthPrompts", "getOutletEntries", "()Ljava/util/Map;", "getUpdatedChatMetadataJson", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class StResolvedPromptRuntime {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String beforePrompt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String afterPrompt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> authorNoteBefore = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> authorNoteAfter = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> exampleBefore = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> exampleAfter = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.domain.roleplay.usecase.StRuntimeDepthPromptInsertion> depthPrompts = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.util.List<java.lang.String>> outletEntries = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String updatedChatMetadataJson = null;
    
    public StResolvedPromptRuntime(@org.jetbrains.annotations.NotNull()
    java.lang.String beforePrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String afterPrompt, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> authorNoteBefore, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> authorNoteAfter, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> exampleBefore, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> exampleAfter, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.usecase.StRuntimeDepthPromptInsertion> depthPrompts, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> outletEntries, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedChatMetadataJson) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBeforePrompt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAfterPrompt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getAuthorNoteBefore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getAuthorNoteAfter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getExampleBefore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getExampleAfter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.domain.roleplay.usecase.StRuntimeDepthPromptInsertion> getDepthPrompts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> getOutletEntries() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUpdatedChatMetadataJson() {
        return null;
    }
    
    public StResolvedPromptRuntime() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.domain.roleplay.usecase.StRuntimeDepthPromptInsertion> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.StResolvedPromptRuntime copy(@org.jetbrains.annotations.NotNull()
    java.lang.String beforePrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String afterPrompt, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> authorNoteBefore, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> authorNoteAfter, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> exampleBefore, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> exampleAfter, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.usecase.StRuntimeDepthPromptInsertion> depthPrompts, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> outletEntries, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedChatMetadataJson) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}