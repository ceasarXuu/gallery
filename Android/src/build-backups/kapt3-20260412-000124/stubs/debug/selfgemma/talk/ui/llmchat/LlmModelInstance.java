package selfgemma.talk.ui.llmchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lselfgemma/talk/ui/llmchat/LlmModelInstance;", "", "engine", "Lcom/google/ai/edge/litertlm/Engine;", "conversation", "Lcom/google/ai/edge/litertlm/Conversation;", "sessionConfig", "Lselfgemma/talk/ui/llmchat/LlmConversationSessionConfig;", "<init>", "(Lcom/google/ai/edge/litertlm/Engine;Lcom/google/ai/edge/litertlm/Conversation;Lselfgemma/talk/ui/llmchat/LlmConversationSessionConfig;)V", "getEngine", "()Lcom/google/ai/edge/litertlm/Engine;", "getConversation", "()Lcom/google/ai/edge/litertlm/Conversation;", "setConversation", "(Lcom/google/ai/edge/litertlm/Conversation;)V", "getSessionConfig", "()Lselfgemma/talk/ui/llmchat/LlmConversationSessionConfig;", "setSessionConfig", "(Lselfgemma/talk/ui/llmchat/LlmConversationSessionConfig;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class LlmModelInstance {
    @org.jetbrains.annotations.NotNull()
    private final com.google.ai.edge.litertlm.Engine engine = null;
    @org.jetbrains.annotations.NotNull()
    private com.google.ai.edge.litertlm.Conversation conversation;
    @org.jetbrains.annotations.NotNull()
    private selfgemma.talk.ui.llmchat.LlmConversationSessionConfig sessionConfig;
    
    public LlmModelInstance(@org.jetbrains.annotations.NotNull()
    com.google.ai.edge.litertlm.Engine engine, @org.jetbrains.annotations.NotNull()
    com.google.ai.edge.litertlm.Conversation conversation, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmConversationSessionConfig sessionConfig) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.ai.edge.litertlm.Engine getEngine() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.ai.edge.litertlm.Conversation getConversation() {
        return null;
    }
    
    public final void setConversation(@org.jetbrains.annotations.NotNull()
    com.google.ai.edge.litertlm.Conversation p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.llmchat.LlmConversationSessionConfig getSessionConfig() {
        return null;
    }
    
    public final void setSessionConfig(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmConversationSessionConfig p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.ai.edge.litertlm.Engine component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.ai.edge.litertlm.Conversation component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.llmchat.LlmConversationSessionConfig component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.llmchat.LlmModelInstance copy(@org.jetbrains.annotations.NotNull()
    com.google.ai.edge.litertlm.Engine engine, @org.jetbrains.annotations.NotNull()
    com.google.ai.edge.litertlm.Conversation conversation, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmConversationSessionConfig sessionConfig) {
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