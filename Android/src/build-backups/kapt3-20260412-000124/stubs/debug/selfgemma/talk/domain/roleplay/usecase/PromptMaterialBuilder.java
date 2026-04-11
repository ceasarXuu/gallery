package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 /2\u00020\u0001:\u0003-./B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005Jf\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0002J\u001e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0002J\u0016\u0010\u001f\u001a\u00020 2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u001a\u0010!\u001a\u00020\"*\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020$H\u0002J$\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\'\u001a\u00020(H\u0002J\u0014\u0010)\u001a\u00020\u0018*\u00020\u00182\u0006\u0010*\u001a\u00020(H\u0002J\u0014\u0010+\u001a\u00020\u0018*\u00020,2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/PromptMaterialBuilder;", "", "tokenEstimator", "Lselfgemma/talk/domain/roleplay/usecase/TokenEstimator;", "<init>", "(Lselfgemma/talk/domain/roleplay/usecase/TokenEstimator;)V", "build", "Lselfgemma/talk/domain/roleplay/usecase/PromptMaterial;", "runtimeRole", "Lselfgemma/talk/domain/roleplay/model/StChatRuntimeRole;", "runtimeProfile", "Lselfgemma/talk/domain/roleplay/model/RoleRuntimeProfile;", "summary", "Lselfgemma/talk/domain/roleplay/model/SessionSummary;", "memories", "", "Lselfgemma/talk/domain/roleplay/model/MemoryItem;", "recentMessages", "Lselfgemma/talk/domain/roleplay/model/Message;", "macroContext", "Lselfgemma/talk/domain/roleplay/usecase/StMacroContext;", "resolvedCharacterBook", "Lselfgemma/talk/domain/roleplay/usecase/StResolvedPromptRuntime;", "postHistoryBlock", "", "depthPromptBlock", "combinedExampleDialogue", "buildRecentConversationVariants", "Lselfgemma/talk/domain/roleplay/usecase/PromptMaterialBuilder$ConversationVariants;", "renderRecentConversation", "messages", "buildMemoryVariants", "Lselfgemma/talk/domain/roleplay/usecase/PromptMaterialBuilder$MemoryVariants;", "addCandidate", "", "", "Lselfgemma/talk/domain/roleplay/usecase/PromptSectionCandidate;", "candidate", "selectRecentMessages", "tokenBudget", "", "toPromptLine", "maxLength", "toSpeakerLabel", "Lselfgemma/talk/domain/roleplay/model/MessageSide;", "ConversationVariants", "MemoryVariants", "Companion", "app_debug"})
public final class PromptMaterialBuilder {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.TokenEstimator tokenEstimator = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.text.Regex WHITESPACE_REGEX = null;
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.domain.roleplay.usecase.PromptMaterialBuilder.Companion Companion = null;
    
    @javax.inject.Inject()
    public PromptMaterialBuilder(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.TokenEstimator tokenEstimator) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.PromptMaterial build(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StChatRuntimeRole runtimeRole, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.RoleRuntimeProfile runtimeProfile, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.SessionSummary summary, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.MemoryItem> memories, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.Message> recentMessages, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.StMacroContext macroContext, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.StResolvedPromptRuntime resolvedCharacterBook, @org.jetbrains.annotations.NotNull()
    java.lang.String postHistoryBlock, @org.jetbrains.annotations.NotNull()
    java.lang.String depthPromptBlock, @org.jetbrains.annotations.NotNull()
    java.lang.String combinedExampleDialogue) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.usecase.PromptMaterialBuilder.ConversationVariants buildRecentConversationVariants(selfgemma.talk.domain.roleplay.model.StChatRuntimeRole runtimeRole, java.util.List<selfgemma.talk.domain.roleplay.model.Message> recentMessages) {
        return null;
    }
    
    private final java.lang.String renderRecentConversation(selfgemma.talk.domain.roleplay.model.StChatRuntimeRole runtimeRole, java.util.List<selfgemma.talk.domain.roleplay.model.Message> messages) {
        return null;
    }
    
    private final selfgemma.talk.domain.roleplay.usecase.PromptMaterialBuilder.MemoryVariants buildMemoryVariants(java.util.List<selfgemma.talk.domain.roleplay.model.MemoryItem> memories) {
        return null;
    }
    
    private final void addCandidate(java.util.List<selfgemma.talk.domain.roleplay.usecase.PromptSectionCandidate> $this$addCandidate, selfgemma.talk.domain.roleplay.usecase.PromptSectionCandidate candidate) {
    }
    
    private final java.util.List<selfgemma.talk.domain.roleplay.model.Message> selectRecentMessages(java.util.List<selfgemma.talk.domain.roleplay.model.Message> messages, int tokenBudget) {
        return null;
    }
    
    private final java.lang.String toPromptLine(java.lang.String $this$toPromptLine, int maxLength) {
        return null;
    }
    
    private final java.lang.String toSpeakerLabel(selfgemma.talk.domain.roleplay.model.MessageSide $this$toSpeakerLabel, selfgemma.talk.domain.roleplay.model.StChatRuntimeRole runtimeRole) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/PromptMaterialBuilder$Companion;", "", "<init>", "()V", "WHITESPACE_REGEX", "Lkotlin/text/Regex;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/PromptMaterialBuilder$ConversationVariants;", "", "full", "", "compact", "minimal", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFull", "()Ljava/lang/String;", "getCompact", "getMinimal", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    static final class ConversationVariants {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String full = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String compact = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String minimal = null;
        
        public ConversationVariants(@org.jetbrains.annotations.NotNull()
        java.lang.String full, @org.jetbrains.annotations.NotNull()
        java.lang.String compact, @org.jetbrains.annotations.NotNull()
        java.lang.String minimal) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFull() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCompact() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMinimal() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final selfgemma.talk.domain.roleplay.usecase.PromptMaterialBuilder.ConversationVariants copy(@org.jetbrains.annotations.NotNull()
        java.lang.String full, @org.jetbrains.annotations.NotNull()
        java.lang.String compact, @org.jetbrains.annotations.NotNull()
        java.lang.String minimal) {
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
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/PromptMaterialBuilder$MemoryVariants;", "", "full", "", "compact", "minimal", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFull", "()Ljava/lang/String;", "getCompact", "getMinimal", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    static final class MemoryVariants {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String full = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String compact = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String minimal = null;
        
        public MemoryVariants(@org.jetbrains.annotations.NotNull()
        java.lang.String full, @org.jetbrains.annotations.NotNull()
        java.lang.String compact, @org.jetbrains.annotations.NotNull()
        java.lang.String minimal) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFull() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCompact() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMinimal() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final selfgemma.talk.domain.roleplay.usecase.PromptMaterialBuilder.MemoryVariants copy(@org.jetbrains.annotations.NotNull()
        java.lang.String full, @org.jetbrains.annotations.NotNull()
        java.lang.String compact, @org.jetbrains.annotations.NotNull()
        java.lang.String minimal) {
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
}