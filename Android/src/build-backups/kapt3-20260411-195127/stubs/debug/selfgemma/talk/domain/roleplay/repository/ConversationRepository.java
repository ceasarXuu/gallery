package selfgemma.talk.domain.roleplay.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ*\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00a6@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\u001bJ$\u0010\u001d\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020#H\u00a6@\u00a2\u0006\u0002\u0010&J\u001c\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\u00042\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020(H\u00a6@\u00a2\u0006\u0002\u0010+\u00a8\u0006,\u00c0\u0006\u0003"}, d2 = {"Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;", "", "observeSessions", "Lkotlinx/coroutines/flow/Flow;", "", "Lselfgemma/talk/domain/roleplay/model/Session;", "observeMessages", "Lselfgemma/talk/domain/roleplay/model/Message;", "sessionId", "", "listMessages", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSession", "createSession", "roleId", "modelId", "userProfile", "Lselfgemma/talk/domain/roleplay/model/StUserProfile;", "(Ljava/lang/String;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/StUserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSession", "", "session", "(Lselfgemma/talk/domain/roleplay/model/Session;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "archiveSession", "deleteSession", "appendMessage", "message", "(Lselfgemma/talk/domain/roleplay/model/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMessage", "replaceMessages", "messages", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nextMessageSeq", "", "getSummary", "Lselfgemma/talk/domain/roleplay/model/SessionSummary;", "upsertSummary", "summary", "(Lselfgemma/talk/domain/roleplay/model/SessionSummary;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listEvents", "Lselfgemma/talk/domain/roleplay/model/SessionEvent;", "appendEvent", "event", "(Lselfgemma/talk/domain/roleplay/model/SessionEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ConversationRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<selfgemma.talk.domain.roleplay.model.Session>> observeSessions();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<selfgemma.talk.domain.roleplay.model.Message>> observeMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object listMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.domain.roleplay.model.Message>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.model.Session> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createSession(@org.jetbrains.annotations.NotNull()
    java.lang.String roleId, @org.jetbrains.annotations.NotNull()
    java.lang.String modelId, @org.jetbrains.annotations.Nullable()
    selfgemma.talk.domain.roleplay.model.StUserProfile userProfile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.model.Session> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSession(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Session session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object archiveSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object appendMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Message message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateMessage(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.Message message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object replaceMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.domain.roleplay.model.Message> messages, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object nextMessageSeq(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSummary(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super selfgemma.talk.domain.roleplay.model.SessionSummary> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsertSummary(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.SessionSummary summary, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object listEvents(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<selfgemma.talk.domain.roleplay.model.SessionEvent>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object appendEvent(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.SessionEvent event, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}