package selfgemma.talk.ui.llmchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u001a(\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\u001a \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a*\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002\u001a$\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\nH\u0002\u001a \u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0019H\u0002\u001a\u000e\u0010#\u001a\u0004\u0018\u00010\f*\u00020\nH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006$"}, d2 = {"TAG", "", "withConversationConstrainedDecoding", "T", "enableConversationConstrainedDecoding", "", "block", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "buildSessionConfig", "Lselfgemma/talk/ui/llmchat/LlmConversationSessionConfig;", "systemInstruction", "Lcom/google/ai/edge/litertlm/Contents;", "tools", "", "Lcom/google/ai/edge/litertlm/ToolProvider;", "resolveImportedCpuWeightCacheFile", "Ljava/io/File;", "model", "Lselfgemma/talk/data/Model;", "accelerator", "modelPath", "purgeImportedCpuWeightCacheIfPresent", "", "buildConversationConfig", "Lcom/google/ai/edge/litertlm/ConversationConfig;", "samplerConfig", "Lcom/google/ai/edge/litertlm/SamplerConfig;", "restoreConversationAfterResetFailure", "Lcom/google/ai/edge/litertlm/Conversation;", "engine", "Lcom/google/ai/edge/litertlm/Engine;", "previousSessionConfig", "createConversationWithConstrainedDecoding", "config", "toSystemInstructionContents", "app_debug"})
public final class LlmChatModelHelperKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGLlmChatModelHelper";
    
    @kotlin.OptIn(markerClass = {com.google.ai.edge.litertlm.ExperimentalApi.class})
    public static final <T extends java.lang.Object>T withConversationConstrainedDecoding(boolean enableConversationConstrainedDecoding, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends T> block) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.ui.llmchat.LlmConversationSessionConfig buildSessionConfig(@org.jetbrains.annotations.Nullable()
    com.google.ai.edge.litertlm.Contents systemInstruction, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.ai.edge.litertlm.ToolProvider> tools, boolean enableConversationConstrainedDecoding) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.io.File resolveImportedCpuWeightCacheFile(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String accelerator, @org.jetbrains.annotations.NotNull()
    java.lang.String modelPath) {
        return null;
    }
    
    private static final void purgeImportedCpuWeightCacheIfPresent(selfgemma.talk.data.Model model, java.lang.String accelerator, java.lang.String modelPath) {
    }
    
    private static final com.google.ai.edge.litertlm.ConversationConfig buildConversationConfig(com.google.ai.edge.litertlm.SamplerConfig samplerConfig, com.google.ai.edge.litertlm.Contents systemInstruction, java.util.List<? extends com.google.ai.edge.litertlm.ToolProvider> tools) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {com.google.ai.edge.litertlm.ExperimentalApi.class})
    private static final com.google.ai.edge.litertlm.Conversation restoreConversationAfterResetFailure(com.google.ai.edge.litertlm.Engine engine, com.google.ai.edge.litertlm.SamplerConfig samplerConfig, selfgemma.talk.ui.llmchat.LlmConversationSessionConfig previousSessionConfig) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {com.google.ai.edge.litertlm.ExperimentalApi.class})
    private static final com.google.ai.edge.litertlm.Conversation createConversationWithConstrainedDecoding(com.google.ai.edge.litertlm.Engine engine, boolean enableConversationConstrainedDecoding, com.google.ai.edge.litertlm.ConversationConfig config) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final com.google.ai.edge.litertlm.Contents toSystemInstructionContents(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmConversationSessionConfig $this$toSystemInstructionContents) {
        return null;
    }
}