package selfgemma.talk.customtasks.agentchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aB\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007\u001a \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0002\u001aN\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0018H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"TAG", "", "chatViewJavascriptInterface", "Lselfgemma/talk/customtasks/agentchat/ChatWebViewJavascriptInterface;", "AgentChatScreen", "", "task", "Lselfgemma/talk/data/Task;", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "navigateUp", "Lkotlin/Function0;", "agentTools", "Lselfgemma/talk/customtasks/agentchat/AgentTools;", "viewModel", "Lselfgemma/talk/ui/llmchat/LlmChatViewModel;", "skillManagerViewModel", "Lselfgemma/talk/customtasks/agentchat/SkillManagerViewModel;", "updateProgressPanel", "model", "Lselfgemma/talk/data/Model;", "resetSessionWithCurrentSkills", "curSystemPrompt", "onDone", "Lkotlin/Function1;", "app_debug"})
public final class AgentChatScreenKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGAgentChatScreen";
    @org.jetbrains.annotations.NotNull()
    private static final selfgemma.talk.customtasks.agentchat.ChatWebViewJavascriptInterface chatViewJavascriptInterface = null;
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.layout.ExperimentalLayoutApi.class})
    @androidx.compose.runtime.Composable()
    public static final void AgentChatScreen(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.customtasks.agentchat.AgentTools agentTools, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmchat.LlmChatViewModel viewModel, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.customtasks.agentchat.SkillManagerViewModel skillManagerViewModel) {
    }
    
    private static final void updateProgressPanel(selfgemma.talk.ui.llmchat.LlmChatViewModel viewModel, selfgemma.talk.data.Model model, selfgemma.talk.customtasks.agentchat.AgentTools agentTools) {
    }
    
    private static final void resetSessionWithCurrentSkills(selfgemma.talk.ui.llmchat.LlmChatViewModel viewModel, selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, selfgemma.talk.customtasks.agentchat.SkillManagerViewModel skillManagerViewModel, selfgemma.talk.data.Task task, java.lang.String curSystemPrompt, selfgemma.talk.customtasks.agentchat.AgentTools agentTools, kotlin.jvm.functions.Function1<? super selfgemma.talk.data.Model, kotlin.Unit> onDone) {
    }
}