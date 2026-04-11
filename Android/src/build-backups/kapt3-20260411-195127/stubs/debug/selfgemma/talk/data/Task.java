package selfgemma.talk.data;

/**
 * Data class for a task displayed on the home screen
 *
 * Tasks are grouped into categories (see [category] field), which correspond to the tabs on the
 * home screen. The tab bar is hidden if only one category exists. Each task can have a list of
 * associated models (see [Model]], which are shown when the task is selected.
 *
 * To register a custom task, see [com.google.ai.edge.gallery.customtasks.common.CustomTask].
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b=\b\u0086\b\u0018\u00002\u00020\u0001B\u00db\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u001a\u001a\u00020\n\u0012\b\b\u0003\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u00a2\u0006\u0004\b \u0010!J\u0006\u0010A\u001a\u00020\u0015J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010*J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u00c6\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u00c6\u0003J\t\u0010M\u001a\u00020\u0015H\u00c6\u0003J\t\u0010N\u001a\u00020\u0015H\u00c6\u0003J\t\u0010O\u001a\u00020\u0015H\u00c6\u0003J\t\u0010P\u001a\u00020\u0015H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010R\u001a\u00020\nH\u00c6\u0003J\t\u0010S\u001a\u00020\nH\u00c6\u0003J\t\u0010T\u001a\u00020\nH\u00c6\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u00c6\u0003J\u00ec\u0001\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0003\u0010\u001a\u001a\u00020\n2\b\b\u0003\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\n2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u00c6\u0001\u00a2\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u00152\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010Z\u001a\u00020\nH\u00d6\u0001J\t\u0010[\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u0011\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0011\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00104R\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010#R\u0011\u0010\u001a\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u001b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010:R\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010:\"\u0004\b=\u0010>R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010@\u00a8\u0006\\"}, d2 = {"Lselfgemma/talk/data/Task;", "", "id", "", "label", "category", "Lselfgemma/talk/data/CategoryInfo;", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "iconVectorResourceId", "", "description", "shortDescription", "docUrl", "sourceCodeUrl", "models", "", "Lselfgemma/talk/data/Model;", "modelNames", "", "handleModelConfigChangesInTask", "", "experimental", "newFeature", "useThemeColor", "defaultSystemPrompt", "agentNameRes", "textInputPlaceHolderRes", "index", "updateTrigger", "Landroidx/compose/runtime/MutableState;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lselfgemma/talk/data/CategoryInfo;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZZZZLjava/lang/String;IIILandroidx/compose/runtime/MutableState;)V", "getId", "()Ljava/lang/String;", "getLabel", "getCategory", "()Lselfgemma/talk/data/CategoryInfo;", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getIconVectorResourceId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescription", "getShortDescription", "getDocUrl", "getSourceCodeUrl", "getModels", "()Ljava/util/List;", "getModelNames", "getHandleModelConfigChangesInTask", "()Z", "getExperimental", "getNewFeature", "getUseThemeColor", "getDefaultSystemPrompt", "getAgentNameRes", "()I", "getTextInputPlaceHolderRes", "getIndex", "setIndex", "(I)V", "getUpdateTrigger", "()Landroidx/compose/runtime/MutableState;", "allowThinking", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Ljava/lang/String;Lselfgemma/talk/data/CategoryInfo;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZZZZLjava/lang/String;IIILandroidx/compose/runtime/MutableState;)Lselfgemma/talk/data/Task;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Task {
    
    /**
     * The id of the task.
     *
     * The ids in [BuiltInTaskId] are reserved for built-in tasks.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    
    /**
     * The label of the task, for display purpose.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String label = null;
    
    /**
     * The category of the task.
     *
     * We've pre-defined several categories in [Category]. Feel free to create your own category.
     */
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.CategoryInfo category = null;
    
    /**
     * Icon to be shown in the task tile.
     */
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.ui.graphics.vector.ImageVector icon = null;
    
    /**
     * Vector resource id for the icon. This precedes the icon if both are set.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer iconVectorResourceId = null;
    
    /**
     * Description of the task.
     *
     * Will be shown at the top of the task screen.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    
    /**
     * Shorter description (within 6 words) of the task.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String shortDescription = null;
    
    /**
     * (optional)
     *
     * Documentation url for the task.
     *
     * Will be shown below the description on the task screen.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String docUrl = null;
    
    /**
     * (optional)
     *
     * Source code url for the model-related functions.
     *
     * Will be shown below the description on the task screen.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String sourceCodeUrl = null;
    
    /**
     * List of models for the task.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.data.Model> models = null;
    
    /**
     * List of model names for the task.
     *
     * If this field is non-empty, the task will try to find the models with the matching names from
     * the allowlist
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> modelNames = null;
    
    /**
     * Whether to handel model config changes in task's screen itself. The default behavior is to
     * automatically re-initialize the model.
     */
    private final boolean handleModelConfigChangesInTask = false;
    
    /**
     * Whether the task is experimental.
     */
    private final boolean experimental = false;
    
    /**
     * Whether the task should have a "new" badge on home screen.
     */
    private final boolean newFeature = false;
    
    /**
     * Whether to use theme color instead of the task tint color.
     */
    private final boolean useThemeColor = false;
    
    /**
     * The default system prompt for this task.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String defaultSystemPrompt = null;
    
    /**
     * Placeholder text for the name of the agent shown above chat messages.
     */
    private final int agentNameRes = 0;
    
    /**
     * Placeholder text for the text input field.
     */
    private final int textInputPlaceHolderRes = 0;
    private int index;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.Long> updateTrigger = null;
    
    public Task(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.CategoryInfo category, @org.jetbrains.annotations.Nullable()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.Nullable()
    java.lang.Integer iconVectorResourceId, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String shortDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String docUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String sourceCodeUrl, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.Model> models, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> modelNames, boolean handleModelConfigChangesInTask, boolean experimental, boolean newFeature, boolean useThemeColor, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultSystemPrompt, @androidx.annotation.StringRes()
    int agentNameRes, @androidx.annotation.StringRes()
    int textInputPlaceHolderRes, int index, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Long> updateTrigger) {
        super();
    }
    
    /**
     * The id of the task.
     *
     * The ids in [BuiltInTaskId] are reserved for built-in tasks.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    /**
     * The label of the task, for display purpose.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLabel() {
        return null;
    }
    
    /**
     * The category of the task.
     *
     * We've pre-defined several categories in [Category]. Feel free to create your own category.
     */
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.CategoryInfo getCategory() {
        return null;
    }
    
    /**
     * Icon to be shown in the task tile.
     */
    @org.jetbrains.annotations.Nullable()
    public final androidx.compose.ui.graphics.vector.ImageVector getIcon() {
        return null;
    }
    
    /**
     * Vector resource id for the icon. This precedes the icon if both are set.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getIconVectorResourceId() {
        return null;
    }
    
    /**
     * Description of the task.
     *
     * Will be shown at the top of the task screen.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    /**
     * Shorter description (within 6 words) of the task.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getShortDescription() {
        return null;
    }
    
    /**
     * (optional)
     *
     * Documentation url for the task.
     *
     * Will be shown below the description on the task screen.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocUrl() {
        return null;
    }
    
    /**
     * (optional)
     *
     * Source code url for the model-related functions.
     *
     * Will be shown below the description on the task screen.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSourceCodeUrl() {
        return null;
    }
    
    /**
     * List of models for the task.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.Model> getModels() {
        return null;
    }
    
    /**
     * List of model names for the task.
     *
     * If this field is non-empty, the task will try to find the models with the matching names from
     * the allowlist
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getModelNames() {
        return null;
    }
    
    /**
     * Whether to handel model config changes in task's screen itself. The default behavior is to
     * automatically re-initialize the model.
     */
    public final boolean getHandleModelConfigChangesInTask() {
        return false;
    }
    
    /**
     * Whether the task is experimental.
     */
    public final boolean getExperimental() {
        return false;
    }
    
    /**
     * Whether the task should have a "new" badge on home screen.
     */
    public final boolean getNewFeature() {
        return false;
    }
    
    /**
     * Whether to use theme color instead of the task tint color.
     */
    public final boolean getUseThemeColor() {
        return false;
    }
    
    /**
     * The default system prompt for this task.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDefaultSystemPrompt() {
        return null;
    }
    
    /**
     * Placeholder text for the name of the agent shown above chat messages.
     */
    public final int getAgentNameRes() {
        return 0;
    }
    
    /**
     * Placeholder text for the text input field.
     */
    public final int getTextInputPlaceHolderRes() {
        return 0;
    }
    
    public final int getIndex() {
        return 0;
    }
    
    public final void setIndex(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Long> getUpdateTrigger() {
        return null;
    }
    
    public final boolean allowThinking() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.Model> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component11() {
        return null;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final boolean component14() {
        return false;
    }
    
    public final boolean component15() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    public final int component17() {
        return 0;
    }
    
    public final int component18() {
        return 0;
    }
    
    public final int component19() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Long> component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.CategoryInfo component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.compose.ui.graphics.vector.ImageVector component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.Task copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.CategoryInfo category, @org.jetbrains.annotations.Nullable()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.Nullable()
    java.lang.Integer iconVectorResourceId, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String shortDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String docUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String sourceCodeUrl, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.Model> models, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> modelNames, boolean handleModelConfigChangesInTask, boolean experimental, boolean newFeature, boolean useThemeColor, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultSystemPrompt, @androidx.annotation.StringRes()
    int agentNameRes, @androidx.annotation.StringRes()
    int textInputPlaceHolderRes, int index, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Long> updateTrigger) {
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