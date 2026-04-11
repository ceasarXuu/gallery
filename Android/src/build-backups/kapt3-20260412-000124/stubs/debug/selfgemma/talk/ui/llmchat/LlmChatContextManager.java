package selfgemma.talk.ui.llmchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005JF\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J,\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J,\u0010\u001c\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\fH\u0002J\f\u0010!\u001a\u00020\t*\u00020\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lselfgemma/talk/ui/llmchat/LlmChatContextManager;", "", "tokenEstimator", "Lselfgemma/talk/domain/roleplay/usecase/TokenEstimator;", "<init>", "(Lselfgemma/talk/domain/roleplay/usecase/TokenEstimator;)V", "buildPlan", "Lselfgemma/talk/ui/llmchat/LlmChatContextPlan;", "baseSystemPrompt", "", "historyMessages", "", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "pendingInput", "pendingImageCount", "", "pendingAudioCount", "contextProfile", "Lselfgemma/talk/domain/roleplay/model/ModelContextProfile;", "preferredMode", "Lselfgemma/talk/ui/llmchat/LlmChatContextMode;", "selectRecentLines", "historyLines", "budgetTokens", "buildSummaryLines", "olderLines", "fitToBudget", "text", "buildPrompt", "summaryLines", "recentLines", "toHistoryLine", "message", "toHistorySpeaker", "Lselfgemma/talk/ui/common/chat/ChatSide;", "Companion", "app_debug"})
public final class LlmChatContextManager {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.TokenEstimator tokenEstimator = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.text.Regex WHITESPACE_REGEX = null;
    @org.jetbrains.annotations.NotNull()
    private static final selfgemma.talk.ui.llmchat.LlmChatContextManager.Companion Companion = null;
    
    public LlmChatContextManager(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.TokenEstimator tokenEstimator) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.llmchat.LlmChatContextPlan buildPlan(@org.jetbrains.annotations.NotNull()
    java.lang.String baseSystemPrompt, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends selfgemma.talk.ui.common.chat.ChatMessage> historyMessages, @org.jetbrains.annotations.NotNull()
    java.lang.String pendingInput, int pendingImageCount, int pendingAudioCount, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.ModelContextProfile contextProfile, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmChatContextMode preferredMode) {
        return null;
    }
    
    private final java.util.List<java.lang.String> selectRecentLines(java.util.List<java.lang.String> historyLines, int budgetTokens) {
        return null;
    }
    
    private final java.util.List<java.lang.String> buildSummaryLines(java.util.List<java.lang.String> olderLines, int budgetTokens, selfgemma.talk.ui.llmchat.LlmChatContextMode preferredMode) {
        return null;
    }
    
    private final java.lang.String fitToBudget(java.lang.String text, int budgetTokens) {
        return null;
    }
    
    private final java.lang.String buildPrompt(java.lang.String baseSystemPrompt, java.util.List<java.lang.String> summaryLines, java.util.List<java.lang.String> recentLines) {
        return null;
    }
    
    private final java.lang.String toHistoryLine(selfgemma.talk.ui.common.chat.ChatMessage message) {
        return null;
    }
    
    private final java.lang.String toHistorySpeaker(selfgemma.talk.ui.common.chat.ChatSide $this$toHistorySpeaker) {
        return null;
    }
    
    public LlmChatContextManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lselfgemma/talk/ui/llmchat/LlmChatContextManager$Companion;", "", "<init>", "()V", "WHITESPACE_REGEX", "Lkotlin/text/Regex;", "getWHITESPACE_REGEX", "()Lkotlin/text/Regex;", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.text.Regex getWHITESPACE_REGEX() {
            return null;
        }
    }
}