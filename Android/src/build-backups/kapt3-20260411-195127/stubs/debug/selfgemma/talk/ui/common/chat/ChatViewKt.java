package selfgemma.talk.ui.common.chat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000l\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u00fa\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u000b2$\u0010\u0010\u001a \u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u00182\u001a\b\u0002\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030\u000b2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u00182\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u0018\u00a2\u0006\u0002\b 2\b\b\u0002\u0010!\u001a\u00020\u001e2\b\b\u0002\u0010\"\u001a\u00020\u001e2\u0019\b\u0002\u0010#\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u0018\u00a2\u0006\u0002\b 2\b\b\u0002\u0010$\u001a\u00020\u001e2\b\b\u0002\u0010%\u001a\u00020\u00012\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00182\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010(H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"TAG", "", "ChatView", "", "task", "Lselfgemma/talk/data/Task;", "viewModel", "Lselfgemma/talk/ui/common/chat/ChatViewModel;", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "onSendMessage", "Lkotlin/Function2;", "Lselfgemma/talk/data/Model;", "", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "onRunAgainClicked", "onBenchmarkClicked", "Lkotlin/Function4;", "", "navigateUp", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "onResetSessionClicked", "Lkotlin/Function1;", "onStreamImageMessage", "Lselfgemma/talk/ui/common/chat/ChatMessageImage;", "onStopButtonClicked", "onSkillClicked", "showStopButtonInInputWhenInProgress", "", "composableBelowMessageList", "Landroidx/compose/runtime/Composable;", "showImagePicker", "showAudioPicker", "emptyStateComposable", "allowEditingSystemPrompt", "curSystemPrompt", "onSystemPromptChanged", "sendMessageTrigger", "Lselfgemma/talk/ui/common/chat/SendMessageTrigger;", "app_debug"})
public final class ChatViewKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGChatView";
    
    /**
     * A composable that displays a chat interface, allowing users to interact with different models
     * associated with a given task.
     *
     * This composable provides a horizontal pager for switching between models, a model selector for
     * configuring the selected model, and a chat panel for sending and receiving messages. It also
     * manages model initialization, cleanup, and download status, and handles navigation and system
     * back gestures.
     */
    @androidx.compose.runtime.Composable()
    public static final void ChatView(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatViewModel viewModel, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super selfgemma.talk.data.Model, ? super java.util.List<? extends selfgemma.talk.ui.common.chat.ChatMessage>, kotlin.Unit> onSendMessage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super selfgemma.talk.data.Model, ? super selfgemma.talk.ui.common.chat.ChatMessage, kotlin.Unit> onRunAgainClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function4<? super selfgemma.talk.data.Model, ? super selfgemma.talk.ui.common.chat.ChatMessage, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onBenchmarkClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.data.Model, kotlin.Unit> onResetSessionClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super selfgemma.talk.data.Model, ? super selfgemma.talk.ui.common.chat.ChatMessageImage, kotlin.Unit> onStreamImageMessage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.data.Model, kotlin.Unit> onStopButtonClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSkillClicked, boolean showStopButtonInInputWhenInProgress, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.internal.ComposableFunction1<? super selfgemma.talk.data.Model, kotlin.Unit> composableBelowMessageList, boolean showImagePicker, boolean showAudioPicker, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.internal.ComposableFunction1<? super selfgemma.talk.data.Model, kotlin.Unit> emptyStateComposable, boolean allowEditingSystemPrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String curSystemPrompt, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSystemPromptChanged, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.ui.common.chat.SendMessageTrigger sendMessageTrigger) {
    }
}