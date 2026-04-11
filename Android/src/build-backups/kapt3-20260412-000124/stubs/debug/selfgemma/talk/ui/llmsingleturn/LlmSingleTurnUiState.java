package selfgemma.talk.ui.llmsingleturn;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J!\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003JI\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032 \b\u0002\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR)\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lselfgemma/talk/ui/llmsingleturn/LlmSingleTurnUiState;", "", "inProgress", "", "preparing", "responsesByModel", "", "", "selectedPromptTemplateType", "Lselfgemma/talk/ui/llmsingleturn/PromptTemplateType;", "<init>", "(ZZLjava/util/Map;Lselfgemma/talk/ui/llmsingleturn/PromptTemplateType;)V", "getInProgress", "()Z", "getPreparing", "getResponsesByModel", "()Ljava/util/Map;", "getSelectedPromptTemplateType", "()Lselfgemma/talk/ui/llmsingleturn/PromptTemplateType;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class LlmSingleTurnUiState {
    
    /**
     * Indicates whether the runtime is currently processing a message.
     */
    private final boolean inProgress = false;
    
    /**
     * Indicates whether the model is preparing (before outputting any result and after initializing).
     */
    private final boolean preparing = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> responsesByModel = null;
    
    /**
     * Selected prompt template type.
     */
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.llmsingleturn.PromptTemplateType selectedPromptTemplateType = null;
    
    public LlmSingleTurnUiState(boolean inProgress, boolean preparing, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.String, java.lang.String>> responsesByModel, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmsingleturn.PromptTemplateType selectedPromptTemplateType) {
        super();
    }
    
    /**
     * Indicates whether the runtime is currently processing a message.
     */
    public final boolean getInProgress() {
        return false;
    }
    
    /**
     * Indicates whether the model is preparing (before outputting any result and after initializing).
     */
    public final boolean getPreparing() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> getResponsesByModel() {
        return null;
    }
    
    /**
     * Selected prompt template type.
     */
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.llmsingleturn.PromptTemplateType getSelectedPromptTemplateType() {
        return null;
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.llmsingleturn.PromptTemplateType component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.llmsingleturn.LlmSingleTurnUiState copy(boolean inProgress, boolean preparing, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.String, java.lang.String>> responsesByModel, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmsingleturn.PromptTemplateType selectedPromptTemplateType) {
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