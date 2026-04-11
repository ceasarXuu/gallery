package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 92\u00020\u0001:\u00019B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005Jh\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eJt\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eJh\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\b\b\u0002\u0010\u0017\u001a\u00020\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\'2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013H\u0002J\u0014\u0010*\u001a\u00020\r*\u00020+2\u0006\u0010\"\u001a\u00020#H\u0002JN\u0010,\u001a\u00020-2\u0006\u0010\"\u001a\u00020#2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u00101\u001a\u0004\u0018\u000102*\u0004\u0018\u0001032\u0006\u0010/\u001a\u000200H\u0002J\f\u00104\u001a\u00020\r*\u000202H\u0002J\f\u00104\u001a\u00020\r*\u000205H\u0002J\u0013\u00106\u001a\u00020\r*\u0004\u0018\u000107H\u0002\u00a2\u0006\u0002\u00108R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/PromptAssembler;", "", "tokenEstimator", "Lselfgemma/talk/domain/roleplay/usecase/TokenEstimator;", "<init>", "(Lselfgemma/talk/domain/roleplay/usecase/TokenEstimator;)V", "characterBookRuntime", "Lselfgemma/talk/domain/roleplay/usecase/StCharacterBookRuntime;", "materialBuilder", "Lselfgemma/talk/domain/roleplay/usecase/PromptMaterialBuilder;", "contextBudgetPlanner", "Lselfgemma/talk/domain/roleplay/usecase/ContextBudgetPlanner;", "assemble", "", "role", "Lselfgemma/talk/domain/roleplay/model/RoleCard;", "summary", "Lselfgemma/talk/domain/roleplay/model/SessionSummary;", "memories", "", "Lselfgemma/talk/domain/roleplay/model/MemoryItem;", "recentMessages", "Lselfgemma/talk/domain/roleplay/model/Message;", "pendingUserInput", "generationTrigger", "userProfile", "Lselfgemma/talk/domain/roleplay/model/StUserProfile;", "contextProfile", "Lselfgemma/talk/domain/roleplay/model/ModelContextProfile;", "budgetMode", "Lselfgemma/talk/domain/roleplay/usecase/PromptBudgetMode;", "assembleForSession", "Lselfgemma/talk/domain/roleplay/usecase/PromptAssemblyResult;", "chatMetadataJson", "runtimeRole", "Lselfgemma/talk/domain/roleplay/model/StChatRuntimeRole;", "runtimeSession", "Lselfgemma/talk/domain/roleplay/model/StChatRuntimeSession;", "runtimeProfile", "Lselfgemma/talk/domain/roleplay/model/RoleRuntimeProfile;", "selectRecentMessages", "messages", "toSpeakerLabel", "Lselfgemma/talk/domain/roleplay/model/MessageSide;", "buildStScanContext", "Lselfgemma/talk/domain/roleplay/usecase/StWorldScanContext;", "dialogueWindow", "macroContext", "Lselfgemma/talk/domain/roleplay/usecase/StMacroContext;", "toDepthPrompt", "Lselfgemma/talk/domain/roleplay/usecase/DepthPromptInsertion;", "Lcom/google/gson/JsonObject;", "toPromptSection", "Lselfgemma/talk/domain/roleplay/usecase/StRuntimeDepthPromptInsertion;", "toPromptRoleName", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "Companion", "app_debug"})
public final class PromptAssembler {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.TokenEstimator tokenEstimator = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.StCharacterBookRuntime characterBookRuntime = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.PromptMaterialBuilder materialBuilder = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.ContextBudgetPlanner contextBudgetPlanner = null;
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.domain.roleplay.usecase.PromptAssembler.Companion Companion = null;
    
    @javax.inject.Inject()
    public PromptAssembler(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.TokenEstimator tokenEstimator) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String assemble(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleCard role, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.SessionSummary summary, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.MemoryItem> memories, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.Message> recentMessages, @org.jetbrains.annotations.NotNull()
    java.lang.String pendingUserInput, @org.jetbrains.annotations.NotNull()
    java.lang.String generationTrigger, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StUserProfile userProfile, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.ModelContextProfile contextProfile, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode budgetMode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.PromptAssemblyResult assembleForSession(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.RoleCard role, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.SessionSummary summary, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.MemoryItem> memories, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.Message> recentMessages, @org.jetbrains.annotations.NotNull()
    java.lang.String pendingUserInput, @org.jetbrains.annotations.NotNull()
    java.lang.String generationTrigger, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StUserProfile userProfile, @org.jetbrains.annotations.Nullable()
    java.lang.String chatMetadataJson, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.ModelContextProfile contextProfile, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode budgetMode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.PromptAssemblyResult assembleForSession(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StChatRuntimeRole runtimeRole, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StChatRuntimeSession runtimeSession, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.SessionSummary summary, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.MemoryItem> memories, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.Message> recentMessages, @org.jetbrains.annotations.NotNull()
    java.lang.String pendingUserInput, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile runtimeProfile, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.ModelContextProfile contextProfile, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.PromptBudgetMode budgetMode) {
        return null;
    }
    
    private final java.util.List<selfgemma.talk.domain.roleplay.model.Message> selectRecentMessages(java.util.List<selfgemma.talk.domain.roleplay.model.Message> messages) {
        return null;
    }
    
    private final java.lang.String toSpeakerLabel(selfgemma.talk.domain.roleplay.model.MessageSide $this$toSpeakerLabel, selfgemma.talk.domain.roleplay.model.StChatRuntimeRole runtimeRole) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.usecase.StWorldScanContext buildStScanContext(selfgemma.talk.domain.roleplay.model.StChatRuntimeRole runtimeRole, selfgemma.talk.domain.roleplay.model.SessionSummary summary, java.util.List<selfgemma.talk.domain.roleplay.model.MemoryItem> memories, java.util.List<selfgemma.talk.domain.roleplay.model.Message> dialogueWindow, java.lang.String pendingUserInput, java.lang.String generationTrigger, selfgemma.talk.domain.roleplay.usecase.StMacroContext macroContext) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.usecase.DepthPromptInsertion toDepthPrompt(com.google.gson.JsonObject $this$toDepthPrompt, selfgemma.talk.domain.roleplay.usecase.StMacroContext macroContext) {
        return null;
    }
    
    private final java.lang.String toPromptSection(selfgemma.talk.domain.roleplay.usecase.DepthPromptInsertion $this$toPromptSection) {
        return null;
    }
    
    private final java.lang.String toPromptSection(selfgemma.talk.domain.roleplay.usecase.StRuntimeDepthPromptInsertion $this$toPromptSection) {
        return null;
    }
    
    private final java.lang.String toPromptRoleName(java.lang.Integer $this$toPromptRoleName) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/PromptAssembler$Companion;", "", "<init>", "()V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}