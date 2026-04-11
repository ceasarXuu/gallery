package selfgemma.talk.customtasks.agentchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0$2\b\b\u0001\u0010&\u001a\u00020%H\u0007J2\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020(0$2\b\b\u0001\u0010&\u001a\u00020%2\b\b\u0001\u0010)\u001a\u00020%2\b\b\u0001\u0010*\u001a\u00020%H\u0007J(\u0010+\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0$2\b\b\u0001\u0010,\u001a\u00020%2\b\b\u0001\u0010-\u001a\u00020%H\u0007J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u00061"}, d2 = {"Lselfgemma/talk/customtasks/agentchat/AgentTools;", "Lcom/google/ai/edge/litertlm/ToolSet;", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "skillManagerViewModel", "Lselfgemma/talk/customtasks/agentchat/SkillManagerViewModel;", "getSkillManagerViewModel", "()Lselfgemma/talk/customtasks/agentchat/SkillManagerViewModel;", "setSkillManagerViewModel", "(Lselfgemma/talk/customtasks/agentchat/SkillManagerViewModel;)V", "_actionChannel", "Lkotlinx/coroutines/channels/Channel;", "Lselfgemma/talk/common/AgentAction;", "actionChannel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getActionChannel", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "resultImageToShow", "Lselfgemma/talk/common/CallJsSkillResultImage;", "getResultImageToShow", "()Lselfgemma/talk/common/CallJsSkillResultImage;", "setResultImageToShow", "(Lselfgemma/talk/common/CallJsSkillResultImage;)V", "resultWebviewToShow", "Lselfgemma/talk/common/CallJsSkillResultWebview;", "getResultWebviewToShow", "()Lselfgemma/talk/common/CallJsSkillResultWebview;", "setResultWebviewToShow", "(Lselfgemma/talk/common/CallJsSkillResultWebview;)V", "loadSkill", "", "", "skillName", "runJs", "", "scriptName", "data", "runIntent", "intent", "parameters", "sendAgentAction", "", "action", "app_debug"})
public final class AgentTools implements com.google.ai.edge.litertlm.ToolSet {
    public android.content.Context context;
    public selfgemma.talk.customtasks.agentchat.SkillManagerViewModel skillManagerViewModel;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<selfgemma.talk.common.AgentAction> _actionChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.ReceiveChannel<selfgemma.talk.common.AgentAction> actionChannel = null;
    @org.jetbrains.annotations.Nullable()
    private selfgemma.talk.common.CallJsSkillResultImage resultImageToShow;
    @org.jetbrains.annotations.Nullable()
    private selfgemma.talk.common.CallJsSkillResultWebview resultWebviewToShow;
    
    public AgentTools() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.customtasks.agentchat.SkillManagerViewModel getSkillManagerViewModel() {
        return null;
    }
    
    public final void setSkillManagerViewModel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.customtasks.agentchat.SkillManagerViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.channels.ReceiveChannel<selfgemma.talk.common.AgentAction> getActionChannel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.common.CallJsSkillResultImage getResultImageToShow() {
        return null;
    }
    
    public final void setResultImageToShow(@org.jetbrains.annotations.Nullable()
    selfgemma.talk.common.CallJsSkillResultImage p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.common.CallJsSkillResultWebview getResultWebviewToShow() {
        return null;
    }
    
    public final void setResultWebviewToShow(@org.jetbrains.annotations.Nullable()
    selfgemma.talk.common.CallJsSkillResultWebview p0) {
    }
    
    /**
     * Loads skill.
     */
    @com.google.ai.edge.litertlm.Tool(description = "Loads a skill.")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> loadSkill(@com.google.ai.edge.litertlm.ToolParam(description = "The name of the skill to load.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String skillName) {
        return null;
    }
    
    /**
     * Call JS skill
     */
    @com.google.ai.edge.litertlm.Tool(description = "Runs JS script")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> runJs(@com.google.ai.edge.litertlm.ToolParam(description = "The name of skill")
    @org.jetbrains.annotations.NotNull()
    java.lang.String skillName, @com.google.ai.edge.litertlm.ToolParam(description = "The script name to run. Use \'index.html\' if not provided by user")
    @org.jetbrains.annotations.NotNull()
    java.lang.String scriptName, @com.google.ai.edge.litertlm.ToolParam(description = "The data to pass to the script. Use empty string if not provided by user")
    @org.jetbrains.annotations.NotNull()
    java.lang.String data) {
        return null;
    }
    
    @com.google.ai.edge.litertlm.Tool(description = "Run an Android intent. It is used to interact with the app to perform certain actions.")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> runIntent(@com.google.ai.edge.litertlm.ToolParam(description = "The intent to run.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String intent, @com.google.ai.edge.litertlm.ToolParam(description = "A JSON string containing the parameter values required for the intent.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String parameters) {
        return null;
    }
    
    public final void sendAgentAction(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.common.AgentAction action) {
    }
}