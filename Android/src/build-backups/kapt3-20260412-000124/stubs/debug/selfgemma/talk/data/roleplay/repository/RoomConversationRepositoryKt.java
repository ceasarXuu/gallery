package selfgemma.talk.data.roleplay.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"DEFAULT_SESSION_TITLE", "", "SESSION_TITLE_MAX_LENGTH", "", "SESSION_EXCERPT_MAX_LENGTH", "mergeWithMessage", "Lselfgemma/talk/data/roleplay/db/entity/SessionEntity;", "message", "Lselfgemma/talk/domain/roleplay/model/Message;", "completedTurns", "deriveSessionTitle", "currentTitle", "toExcerpt", "app_debug"})
public final class RoomConversationRepositoryKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_SESSION_TITLE = "New Session";
    private static final int SESSION_TITLE_MAX_LENGTH = 48;
    private static final int SESSION_EXCERPT_MAX_LENGTH = 140;
    
    private static final selfgemma.talk.data.roleplay.db.entity.SessionEntity mergeWithMessage(selfgemma.talk.data.roleplay.db.entity.SessionEntity $this$mergeWithMessage, selfgemma.talk.domain.roleplay.model.Message message, int completedTurns) {
        return null;
    }
    
    private static final java.lang.String deriveSessionTitle(java.lang.String currentTitle, selfgemma.talk.domain.roleplay.model.Message message) {
        return null;
    }
    
    private static final java.lang.String toExcerpt(java.lang.String $this$toExcerpt) {
        return null;
    }
}