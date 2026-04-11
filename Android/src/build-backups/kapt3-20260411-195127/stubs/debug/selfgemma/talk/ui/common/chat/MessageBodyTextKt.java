package selfgemma.talk.ui.common.chat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"markdownBlockPattern", "Lkotlin/text/Regex;", "markdownInlinePattern", "MessageBodyText", "", "message", "Lselfgemma/talk/ui/common/chat/ChatMessageText;", "inProgress", "", "shouldRenderMarkdown", "isStreaming", "app_debug"})
public final class MessageBodyTextKt {
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.text.Regex markdownBlockPattern = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.text.Regex markdownInlinePattern = null;
    
    /**
     * Composable function to display the text content of a ChatMessageText.
     */
    @androidx.compose.runtime.Composable()
    public static final void MessageBodyText(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.common.chat.ChatMessageText message, boolean inProgress) {
    }
    
    private static final boolean shouldRenderMarkdown(selfgemma.talk.ui.common.chat.ChatMessageText message, boolean isStreaming) {
        return false;
    }
}