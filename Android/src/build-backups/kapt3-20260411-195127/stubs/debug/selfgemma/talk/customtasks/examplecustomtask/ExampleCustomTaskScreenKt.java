package selfgemma.talk.customtasks.examplecustomtask;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"EXAMPLE_CUSTOM_TASK_CONFIG_KEY_FONT_SIZE", "Lselfgemma/talk/data/ConfigKey;", "getEXAMPLE_CUSTOM_TASK_CONFIG_KEY_FONT_SIZE", "()Lselfgemma/talk/data/ConfigKey;", "EXAMPLE_CUSTOM_TASK_CONFIG_KEY_MAX_CHAR_COUNT", "getEXAMPLE_CUSTOM_TASK_CONFIG_KEY_MAX_CHAR_COUNT", "EXAMPLE_CUSTOM_TASK_CONFIGS", "", "Lselfgemma/talk/data/NumberSliderConfig;", "getEXAMPLE_CUSTOM_TASK_CONFIGS", "()Ljava/util/List;", "ExampleCustomTaskScreen", "", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "viewModel", "Lselfgemma/talk/customtasks/examplecustomtask/ExampleCustomTaskViewModel;", "app_debug"})
public final class ExampleCustomTaskScreenKt {
    
    /**
     * Configuration keys for the `ExampleCustomTask`.
     *
     * These keys are used to uniquely identify and retrieve values for configurable parameters within a
     * model.
     */
    @org.jetbrains.annotations.NotNull()
    private static final selfgemma.talk.data.ConfigKey EXAMPLE_CUSTOM_TASK_CONFIG_KEY_FONT_SIZE = null;
    @org.jetbrains.annotations.NotNull()
    private static final selfgemma.talk.data.ConfigKey EXAMPLE_CUSTOM_TASK_CONFIG_KEY_MAX_CHAR_COUNT = null;
    
    /**
     * A list of configurable parameters for the `ExampleCustomTask`'s models.
     *
     * This list defines two user-adjustable settings that appear in the model configuration dialog:
     * 1. Font size: A `NumberSliderConfig` that allows the user to change the text font size.
     *   `needReinitialization = false` indicates that changing this value **does not** require the
     *   model to be reloaded, as it's a simple UI change.
     * 2. Max character count: A `NumberSliderConfig` to cap the amount of text displayed.
     *   `needReinitialization = true` indicates that changing this value **does** require the
     *   `initializeModelFn` to be called again to re-read and truncate the model file content.
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<selfgemma.talk.data.NumberSliderConfig> EXAMPLE_CUSTOM_TASK_CONFIGS = null;
    
    /**
     * Configuration keys for the `ExampleCustomTask`.
     *
     * These keys are used to uniquely identify and retrieve values for configurable parameters within a
     * model.
     */
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.data.ConfigKey getEXAMPLE_CUSTOM_TASK_CONFIG_KEY_FONT_SIZE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.data.ConfigKey getEXAMPLE_CUSTOM_TASK_CONFIG_KEY_MAX_CHAR_COUNT() {
        return null;
    }
    
    /**
     * A list of configurable parameters for the `ExampleCustomTask`'s models.
     *
     * This list defines two user-adjustable settings that appear in the model configuration dialog:
     * 1. Font size: A `NumberSliderConfig` that allows the user to change the text font size.
     *   `needReinitialization = false` indicates that changing this value **does not** require the
     *   model to be reloaded, as it's a simple UI change.
     * 2. Max character count: A `NumberSliderConfig` to cap the amount of text displayed.
     *   `needReinitialization = true` indicates that changing this value **does** require the
     *   `initializeModelFn` to be called again to re-read and truncate the model file content.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<selfgemma.talk.data.NumberSliderConfig> getEXAMPLE_CUSTOM_TASK_CONFIGS() {
        return null;
    }
    
    /**
     * The main screen of the example custom task.
     */
    @androidx.compose.runtime.Composable()
    public static final void ExampleCustomTaskScreen(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.customtasks.examplecustomtask.ExampleCustomTaskViewModel viewModel) {
    }
}