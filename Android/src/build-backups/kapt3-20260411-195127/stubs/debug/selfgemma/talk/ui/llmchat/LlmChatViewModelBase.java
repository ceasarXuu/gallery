package selfgemma.talk.ui.llmchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u00a8\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u00152\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ`\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\r2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\b\b\u0002\u0010%\u001a\u00020\u001aJR\u0010&\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\'\u001a\u00020(2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001aJN\u0010)\u001a\u00020*2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J(\u00103\u001a\u0002042\u0006\u0010\b\u001a\u00020\t2\u0006\u00105\u001a\u00020*2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0018\u00106\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J.\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u0002092\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lselfgemma/talk/ui/llmchat/LlmChatViewModelBase;", "Lselfgemma/talk/ui/common/chat/ChatViewModel;", "<init>", "()V", "contextManager", "Lselfgemma/talk/ui/llmchat/LlmChatContextManager;", "generateResponse", "", "model", "Lselfgemma/talk/data/Model;", "input", "", "images", "", "Landroid/graphics/Bitmap;", "audioMessages", "Lselfgemma/talk/ui/common/chat/ChatMessageAudioClip;", "currentTurnMessages", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "currentSystemPrompt", "onFirstToken", "Lkotlin/Function1;", "onDone", "Lkotlin/Function0;", "onError", "allowThinking", "", "supportImage", "supportAudio", "stopResponse", "resetSession", "task", "Lselfgemma/talk/data/Task;", "systemInstruction", "Lcom/google/ai/edge/litertlm/Contents;", "tools", "Lcom/google/ai/edge/litertlm/ToolProvider;", "enableConversationConstrainedDecoding", "runAgain", "message", "Lselfgemma/talk/ui/common/chat/ChatMessageText;", "buildContextPlan", "Lselfgemma/talk/ui/llmchat/LlmChatContextPlan;", "currentInput", "imageCount", "", "audioCount", "contextProfile", "Lselfgemma/talk/domain/roleplay/model/ModelContextProfile;", "preferredMode", "Lselfgemma/talk/ui/llmchat/LlmChatContextMode;", "prepareConversationForAttempt", "Lselfgemma/talk/ui/llmchat/LlmChatPreparationResult;", "plan", "resolveBaseSystemPrompt", "handleError", "context", "Landroid/content/Context;", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "errorMessage", "app_debug"})
@kotlin.OptIn(markerClass = {com.google.ai.edge.litertlm.ExperimentalApi.class})
public class LlmChatViewModelBase extends selfgemma.talk.ui.common.chat.ChatViewModel {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.llmchat.LlmChatContextManager contextManager = null;
    
    public LlmChatViewModelBase() {
        super();
    }
    
    public final void generateResponse(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String input, @org.jetbrains.annotations.NotNull()
    java.util.List<android.graphics.Bitmap> images, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.ui.common.chat.ChatMessageAudioClip> audioMessages, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends selfgemma.talk.ui.common.chat.ChatMessage> currentTurnMessages, @org.jetbrains.annotations.NotNull()
    java.lang.String currentSystemPrompt, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.data.Model, kotlin.Unit> onFirstToken, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError, boolean allowThinking, boolean supportImage, boolean supportAudio) {
    }
    
    public final void stopResponse(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
    }
    
    public final void resetSession(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.Nullable()
    com.google.ai.edge.litertlm.Contents systemInstruction, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.ai.edge.litertlm.ToolProvider> tools, boolean supportImage, boolean supportAudio, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone, boolean enableConversationConstrainedDecoding) {
    }
    
    public final void runAgain(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessageText message, @org.jetbrains.annotations.NotNull()
    java.lang.String currentSystemPrompt, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError, boolean allowThinking, boolean supportImage, boolean supportAudio) {
    }
    
    private final selfgemma.talk.ui.llmchat.LlmChatContextPlan buildContextPlan(selfgemma.talk.data.Model model, java.util.List<? extends selfgemma.talk.ui.common.chat.ChatMessage> currentTurnMessages, java.lang.String currentSystemPrompt, java.lang.String currentInput, int imageCount, int audioCount, selfgemma.talk.domain.roleplay.model.ModelContextProfile contextProfile, selfgemma.talk.ui.llmchat.LlmChatContextMode preferredMode) {
        return null;
    }
    
    private final selfgemma.talk.ui.llmchat.LlmChatPreparationResult prepareConversationForAttempt(selfgemma.talk.data.Model model, selfgemma.talk.ui.llmchat.LlmChatContextPlan plan, boolean supportImage, boolean supportAudio) {
        return null;
    }
    
    private final java.lang.String resolveBaseSystemPrompt(selfgemma.talk.data.Model model, java.lang.String currentSystemPrompt) {
        return null;
    }
    
    public final void handleError(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMessage) {
    }
}