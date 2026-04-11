package selfgemma.talk.data.roleplay.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rH\u0016J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0015J(\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096@\u00a2\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010%J$\u0010\'\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0096@\u00a2\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020-H\u0096@\u00a2\u0006\u0002\u00100J\u001c\u00101\u001a\b\u0012\u0004\u0012\u0002020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0016\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000202H\u0096@\u00a2\u0006\u0002\u00105J\u0016\u00106\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0011H\u0082@\u00a2\u0006\u0002\u0010%J\u0016\u00107\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lselfgemma/talk/data/roleplay/repository/RoomConversationRepository;", "Lselfgemma/talk/domain/roleplay/repository/ConversationRepository;", "sessionDao", "Lselfgemma/talk/data/roleplay/db/dao/SessionDao;", "messageDao", "Lselfgemma/talk/data/roleplay/db/dao/MessageDao;", "sessionSummaryDao", "Lselfgemma/talk/data/roleplay/db/dao/SessionSummaryDao;", "sessionEventDao", "Lselfgemma/talk/data/roleplay/db/dao/SessionEventDao;", "<init>", "(Lselfgemma/talk/data/roleplay/db/dao/SessionDao;Lselfgemma/talk/data/roleplay/db/dao/MessageDao;Lselfgemma/talk/data/roleplay/db/dao/SessionSummaryDao;Lselfgemma/talk/data/roleplay/db/dao/SessionEventDao;)V", "observeSessions", "Lkotlinx/coroutines/flow/Flow;", "", "Lselfgemma/talk/domain/roleplay/model/Session;", "observeMessages", "Lselfgemma/talk/domain/roleplay/model/Message;", "sessionId", "", "listMessages", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSession", "createSession", "roleId", "modelId", "userProfile", "Lselfgemma/talk/domain/roleplay/model/StUserProfile;", "(Ljava/lang/String;Ljava/lang/String;Lselfgemma/talk/domain/roleplay/model/StUserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSession", "", "session", "(Lselfgemma/talk/domain/roleplay/model/Session;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "archiveSession", "deleteSession", "appendMessage", "message", "(Lselfgemma/talk/domain/roleplay/model/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMessage", "replaceMessages", "messages", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nextMessageSeq", "", "getSummary", "Lselfgemma/talk/domain/roleplay/model/SessionSummary;", "upsertSummary", "summary", "(Lselfgemma/talk/domain/roleplay/model/SessionSummary;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listEvents", "Lselfgemma/talk/domain/roleplay/model/SessionEvent;", "appendEvent", "event", "(Lselfgemma/talk/domain/roleplay/model/SessionEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncSessionMetadata", "resyncSessionMetadata", "app_debug"})
public final class RoomConversationRepository implements selfgemma.talk.domain.roleplay.repository.ConversationRepository {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.roleplay.db.dao.SessionDao sessionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.roleplay.db.dao.MessageDao messageDao = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.roleplay.db.dao.SessionSummaryDao sessionSummaryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.roleplay.db.dao.SessionEventDao sessionEventDao = null;
    
    @javax.inject.Inject()
    public RoomConversationRepository(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.dao.SessionDao sessionDao, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.dao.MessageDao messageDao, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.dao.SessionSummaryDao sessionSummaryDao, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.roleplay.db.dao.SessionEventDao sessionEventDao) {
        super();
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
    
    private final java.lang.Object syncSessionMetadata(selfgemma.talk.domain.roleplay.model.Message message, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object resyncSessionMetadata(java.lang.String sessionId, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}