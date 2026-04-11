package selfgemma.talk.ui.common.chat;

/**
 * ViewModel responsible for managing the chat UI state and handling chat-related operations.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0016J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 J \u0010!\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&J\u001e\u0010\'\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,J\u001e\u0010-\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010.\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010/\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010JB\u00100\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00101\u001a\u00020&2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020&2\u0006\u00107\u001a\u00020&2\n\b\u0002\u00108\u001a\u0004\u0018\u000109J\u0016\u0010:\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020\f2\u0006\u00102\u001a\u000203J\u000e\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u000203J\u000e\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u000203J6\u0010B\u001a\u00020\f2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002090D2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002090D2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010F\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010G\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006H"}, d2 = {"Lselfgemma/talk/ui/common/chat/ChatViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lselfgemma/talk/ui/common/chat/ChatUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "addMessage", "", "model", "Lselfgemma/talk/data/Model;", "message", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "insertMessageAfter", "anchorMessage", "messageToAdd", "removeMessageAt", "index", "", "removeLastMessage", "clearAllMessages", "truncateMessages", "size", "getMessages", "", "getLastMessage", "getLastMessageWithType", "type", "Lselfgemma/talk/ui/common/chat/ChatMessageType;", "getLastMessageWithTypeAndSide", "side", "Lselfgemma/talk/ui/common/chat/ChatSide;", "updateLastThinkingMessageContentIncrementally", "partialContent", "", "updateLastTextMessageContentIncrementally", "latencyMs", "", "updateLastTextMessageLlmBenchmarkResult", "llmBenchmarkResult", "Lselfgemma/talk/ui/common/chat/ChatMessageBenchmarkLlmResult;", "replaceLastMessage", "replaceMessage", "updateStreamingMessage", "updateCollapsableProgressPanelMessage", "title", "inProgress", "", "doneIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "addItemTitle", "addItemDescription", "customData", "", "addLogMessageToLastCollapsableProgressPanel", "logMessage", "Lselfgemma/talk/ui/common/chat/LogMessage;", "setInProgress", "setIsResettingSession", "isResettingSession", "setPreparing", "preparing", "addConfigChangedMessage", "oldConfigValues", "", "newConfigValues", "getMessageIndex", "createUiState", "app_debug"})
public abstract class ChatViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.ui.common.chat.ChatUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.ui.common.chat.ChatUiState> uiState = null;
    
    public ChatViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.ui.common.chat.ChatUiState> getUiState() {
        return null;
    }
    
    public final void addMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessage message) {
    }
    
    public final void insertMessageAfter(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessage anchorMessage, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessage messageToAdd) {
    }
    
    public final void removeMessageAt(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, int index) {
    }
    
    public final void removeLastMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
    }
    
    public final void clearAllMessages(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
    }
    
    public final void truncateMessages(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, int size) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.ui.common.chat.ChatMessage> getMessages(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.ui.common.chat.ChatMessage getLastMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.ui.common.chat.ChatMessage getLastMessageWithType(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessageType type) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.ui.common.chat.ChatMessage getLastMessageWithTypeAndSide(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessageType type, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatSide side) {
        return null;
    }
    
    public final void updateLastThinkingMessageContentIncrementally(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String partialContent) {
    }
    
    public final void updateLastTextMessageContentIncrementally(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String partialContent, float latencyMs) {
    }
    
    public final void updateLastTextMessageLlmBenchmarkResult(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessageBenchmarkLlmResult llmBenchmarkResult) {
    }
    
    public final void replaceLastMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessage message, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessageType type) {
    }
    
    public final void replaceMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, int index, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessage message) {
    }
    
    public final void updateStreamingMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessage message) {
    }
    
    public final void updateCollapsableProgressPanelMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String title, boolean inProgress, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector doneIcon, @org.jetbrains.annotations.NotNull()
    java.lang.String addItemTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String addItemDescription, @org.jetbrains.annotations.Nullable()
    java.lang.Object customData) {
    }
    
    public final void addLogMessageToLastCollapsableProgressPanel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.LogMessage logMessage) {
    }
    
    public final void setInProgress(boolean inProgress) {
    }
    
    public final void setIsResettingSession(boolean isResettingSession) {
    }
    
    public final void setPreparing(boolean preparing) {
    }
    
    public final void addConfigChangedMessage(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> oldConfigValues, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> newConfigValues, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
    }
    
    public final int getMessageIndex(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessage message) {
        return 0;
    }
    
    private final selfgemma.talk.ui.common.chat.ChatUiState createUiState() {
        return null;
    }
}