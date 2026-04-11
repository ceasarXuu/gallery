package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0015H\u0016J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u001aJ(\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096@\u00a2\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0003H\u0096@\u00a2\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010&\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010\'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010)J$\u0010+\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@\u00a2\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020.2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0018\u0010/\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u00102J\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u00106R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u00067"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/FakeConversationRepository;", "Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;", "session", "Lselfgemma/talk/domain/roleplay/model/Session;", "messages", "", "Lselfgemma/talk/domain/roleplay/model/Message;", "<init>", "(Lselfgemma/talk/domain/roleplay/model/Session;Ljava/util/List;)V", "savedSummary", "Lselfgemma/talk/domain/roleplay/model/SessionSummary;", "getSavedSummary", "()Lselfgemma/talk/domain/roleplay/model/SessionSummary;", "setSavedSummary", "(Lselfgemma/talk/domain/roleplay/model/SessionSummary;)V", "events", "", "Lselfgemma/talk/domain/roleplay/model/SessionEvent;", "getEvents", "()Ljava/util/List;", "observeSessions", "Lkotlinx/coroutines/flow/Flow;", "observeMessages", "sessionId", "", "listMessages", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSession", "createSession", "roleId", "modelId", "userProfile", "Lselfgemma/talk/domain/roleplay/model/StUserProfile;", "(Ljava/lang/String;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/StUserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSession", "", "(Lselfgemma/talk/domain/roleplay/model/Session;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "archiveSession", "deleteSession", "appendMessage", "message", "(Lselfgemma/talk/domain/roleplay/model/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMessage", "replaceMessages", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nextMessageSeq", "", "getSummary", "upsertSummary", "summary", "(Lselfgemma/talk/domain/roleplay/model/SessionSummary;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listEvents", "appendEvent", "event", "(Lselfgemma/talk/domain/roleplay/model/SessionEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debugUnitTest"})
final class FakeConversationRepository implements selfgemma.talk.domain.roleplay.repository.ConversationRepository {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.model.Session session = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.domain.roleplay.model.Message> messages = null;
    @org.jetbrains.annotations.Nullable()
    private selfgemma.talk.domain.roleplay.model.SessionSummary savedSummary;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.domain.roleplay.model.SessionEvent> events = null;
    
    public FakeConversationRepository(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Session session, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.Message> messages) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.domain.roleplay.model.SessionSummary getSavedSummary() {
        return null;
    }
    
    public final void setSavedSummary(@org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.SessionSummary p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.domain.roleplay.model.SessionEvent> getEvents() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<selfgemma.talk.domain.roleplay.model.Session>> observeSessions() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<selfgemma.talk.domain.roleplay.model.Message>> observeMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object listMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.domain.roleplay.model.Message>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.model.Session> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object createSession(@org.jetbrains.annotations.NotNull()
    java.lang.String roleId, @org.jetbrains.annotations.NotNull()
    java.lang.String modelId, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.StUserProfile userProfile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.model.Session> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateSession(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Session session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object archiveSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object appendMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Message message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Message message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object replaceMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.Message> messages, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object nextMessageSeq(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getSummary(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.model.SessionSummary> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object upsertSummary(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.SessionSummary summary, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object listEvents(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.domain.roleplay.model.SessionEvent>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object appendEvent(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.SessionEvent event, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}