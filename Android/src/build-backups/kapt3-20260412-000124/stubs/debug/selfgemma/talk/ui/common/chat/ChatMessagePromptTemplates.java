package selfgemma.talk.ui.common.chat;

/**
 * Chat message for showing prompt templates.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lselfgemma/talk/ui/common/chat/ChatMessagePromptTemplates;", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "templates", "", "Lselfgemma/talk/data/PromptTemplate;", "showMakeYourOwn", "", "<init>", "(Ljava/util/List;Z)V", "getTemplates", "()Ljava/util/List;", "getShowMakeYourOwn", "()Z", "app_debug"})
public final class ChatMessagePromptTemplates extends selfgemma.talk.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.data.PromptTemplate> templates = null;
    private final boolean showMakeYourOwn = false;
    
    public ChatMessagePromptTemplates(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.PromptTemplate> templates, boolean showMakeYourOwn) {
        super(null, null, 0.0F, null, false, false);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.PromptTemplate> getTemplates() {
        return null;
    }
    
    public final boolean getShowMakeYourOwn() {
        return false;
    }
}