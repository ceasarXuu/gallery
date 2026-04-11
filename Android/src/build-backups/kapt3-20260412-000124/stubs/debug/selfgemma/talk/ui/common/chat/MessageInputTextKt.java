package selfgemma.talk.ui.common.chat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000j\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u00ed\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\b\b\u0001\u0010\u0010\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00122\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00030\u00122\b\b\u0002\u0010\u0016\u001a\u00020\n2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182#\b\u0002\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00030\u00122\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00122\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u001a\b\u0002\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0014\u0012\u0004\u0012\u00020\u00030\u00122\u001a\b\u0002\u0010\"\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0014\u0012\u0004\u0012\u00020\u00030\u00122\b\b\u0002\u0010$\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020\n2\b\b\u0002\u0010\'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020\n2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0007\u001a\u0016\u0010*\u001a\u00020\u00032\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0003\u001a8\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00142\u0018\u00101\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0014\u0012\u0004\u0012\u00020\u00030\u0012H\u0002\u001a,\u00102\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\u0006\u00103\u001a\u0002002\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00030\u0012H\u0002\u001a\u001a\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020!2\b\b\u0002\u00107\u001a\u00020\rH\u0002\u001a$\u00108\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\u0012H\u0002\u001a2\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010;\u001a\b\u0012\u0004\u0012\u00020!0\u00142\f\u0010<\u001a\b\u0012\u0004\u0012\u00020#0\u00142\u0006\u0010=\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"TAG", "", "MessageInputText", "", "task", "Lselfgemma/talk/data/Task;", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "curMessage", "isResettingSession", "", "inProgress", "imageCount", "", "audioClipMessageCount", "modelInitializing", "textFieldPlaceHolderRes", "onValueChanged", "Lkotlin/Function1;", "onSendMessage", "", "Lselfgemma/talk/ui/common/chat/ChatMessage;", "modelPreparing", "onOpenPromptTemplatesClicked", "Lkotlin/Function0;", "onStopButtonClicked", "onSetAudioRecorderVisible", "Lkotlin/ParameterName;", "name", "visible", "onAmplitudeChanged", "onSkillsClicked", "onPickedImagesChanged", "Landroid/graphics/Bitmap;", "onPickedAudioClipsChanged", "Lselfgemma/talk/common/AudioClip;", "showPromptTemplatesInMenu", "showSkillsPicker", "showImagePicker", "showAudioPicker", "showStopButtonWhenInProgress", "onImageLimitExceeded", "MediaPanelCloseButton", "onClicked", "handleImagesSelected", "context", "Landroid/content/Context;", "uris", "Landroid/net/Uri;", "onImagesSelected", "handleAudioWavSelected", "uri", "onAudioSelected", "resizeBitmap", "originalBitmap", "size", "checkFrontCamera", "callback", "createMessagesToSend", "pickedImages", "audioClips", "text", "app_debug"})
public final class MessageInputTextKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGMessageInputText";
    
    /**
     * Composable function to display a text input field for composing chat messages.
     *
     * This function renders a row containing a text field for message input and a send button. It
     * handles message composition, input validation, and sending messages.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void MessageInputText(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    java.lang.String curMessage, boolean isResettingSession, boolean inProgress, int imageCount, int audioClipMessageCount, boolean modelInitializing, @androidx.annotation.StringRes()
    int textFieldPlaceHolderRes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChanged, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends selfgemma.talk.ui.common.chat.ChatMessage>, kotlin.Unit> onSendMessage, boolean modelPreparing, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onOpenPromptTemplatesClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onStopButtonClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onSetAudioRecorderVisible, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onAmplitudeChanged, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSkillsClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<android.graphics.Bitmap>, kotlin.Unit> onPickedImagesChanged, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<selfgemma.talk.common.AudioClip>, kotlin.Unit> onPickedAudioClipsChanged, boolean showPromptTemplatesInMenu, boolean showSkillsPicker, boolean showImagePicker, boolean showAudioPicker, boolean showStopButtonWhenInProgress, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onImageLimitExceeded) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void MediaPanelCloseButton(kotlin.jvm.functions.Function0<kotlin.Unit> onClicked) {
    }
    
    private static final void handleImagesSelected(android.content.Context context, java.util.List<? extends android.net.Uri> uris, kotlin.jvm.functions.Function1<? super java.util.List<android.graphics.Bitmap>, kotlin.Unit> onImagesSelected) {
    }
    
    private static final void handleAudioWavSelected(android.content.Context context, android.net.Uri uri, kotlin.jvm.functions.Function1<? super selfgemma.talk.common.AudioClip, kotlin.Unit> onAudioSelected) {
    }
    
    /**
     * Resizes a given Bitmap to fit within a square of a specified size, while maintaining its original
     * aspect ratio.
     */
    private static final android.graphics.Bitmap resizeBitmap(android.graphics.Bitmap originalBitmap, int size) {
        return null;
    }
    
    private static final void checkFrontCamera(android.content.Context context, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> callback) {
    }
    
    private static final java.util.List<selfgemma.talk.ui.common.chat.ChatMessage> createMessagesToSend(java.util.List<android.graphics.Bitmap> pickedImages, java.util.List<selfgemma.talk.common.AudioClip> audioClips, java.lang.String text) {
        return null;
    }
}