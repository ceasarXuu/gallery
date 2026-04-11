package selfgemma.talk.ui.llmchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0096\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\t2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000b2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b\u00132\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\u0017H\u0007\u001a2\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020 H\u0007\u001a2\u0010!\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\"H\u0007\u001a\u0092\u0002\u0010#\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b\u00132\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\t2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\u0017H\u0007\u00a8\u0006%"}, d2 = {"LlmChatScreen", "", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "navigateUp", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "taskId", "", "onFirstToken", "Lkotlin/Function1;", "Lselfgemma/talk/data/Model;", "onGenerateResponseDone", "onSkillClicked", "onResetSessionClickedOverride", "Lkotlin/Function2;", "Lselfgemma/talk/data/Task;", "composableBelowMessageList", "Landroidx/compose/runtime/Composable;", "viewModel", "Lselfgemma/talk/ui/llmchat/LlmChatViewModel;", "allowEditingSystemPrompt", "", "curSystemPrompt", "onSystemPromptChanged", "emptyStateComposable", "sendMessageTrigger", "Lselfgemma/talk/ui/common/chat/SendMessageTrigger;", "showImagePicker", "showAudioPicker", "LlmAskImageScreen", "Lselfgemma/talk/ui/llmchat/LlmAskImageViewModel;", "LlmAskAudioScreen", "Lselfgemma/talk/ui/llmchat/LlmAskAudioViewModel;", "ChatViewWrapper", "Lselfgemma/talk/ui/llmchat/LlmChatViewModelBase;", "app_debug"})
public final class LlmChatScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void LlmChatScreen(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    java.lang.String taskId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.data.Model, kotlin.Unit> onFirstToken, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.data.Model, kotlin.Unit> onGenerateResponseDone, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSkillClicked, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function2<? super selfgemma.talk.data.Task, ? super selfgemma.talk.data.Model, kotlin.Unit> onResetSessionClickedOverride, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.internal.ComposableFunction1<? super selfgemma.talk.data.Model, kotlin.Unit> composableBelowMessageList, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmChatViewModel viewModel, boolean allowEditingSystemPrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String curSystemPrompt, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSystemPromptChanged, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.internal.ComposableFunction1<? super selfgemma.talk.data.Model, kotlin.Unit> emptyStateComposable, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.ui.common.chat.SendMessageTrigger sendMessageTrigger, boolean showImagePicker, boolean showAudioPicker) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LlmAskImageScreen(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmAskImageViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LlmAskAudioScreen(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmAskAudioViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ChatViewWrapper(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmChatViewModelBase viewModel, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    java.lang.String taskId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSkillClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.data.Model, kotlin.Unit> onFirstToken, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.data.Model, kotlin.Unit> onGenerateResponseDone, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function2<? super selfgemma.talk.data.Task, ? super selfgemma.talk.data.Model, kotlin.Unit> onResetSessionClickedOverride, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.internal.ComposableFunction1<? super selfgemma.talk.data.Model, kotlin.Unit> composableBelowMessageList, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.internal.ComposableFunction1<? super selfgemma.talk.data.Model, kotlin.Unit> emptyStateComposable, boolean allowEditingSystemPrompt, @org.jetbrains.annotations.NotNull()
    java.lang.String curSystemPrompt, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSystemPromptChanged, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.ui.common.chat.SendMessageTrigger sendMessageTrigger, boolean showImagePicker, boolean showAudioPicker) {
    }
}