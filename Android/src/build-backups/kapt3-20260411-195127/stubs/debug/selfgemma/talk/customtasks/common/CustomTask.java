package selfgemma.talk.customtasks.common;

/**
 * A CustomTask is a user-defined task that can be dynamically added to the app.
 *
 * The user journey for a custom task begins on the home screen, which is organized into categories.
 * These categories correspond to the tabs in the main navigation. Within each category, a list of
 * tasks is displayed. A task represents a specific functionality or use case, and it includes
 * metadata like a label, description, and icon, which are all defined in the `task` property of
 * your `CustomTask` implementation.
 *
 * When a user selects a task on the home screen, they are taken to the task's detail screen. This
 * screen displays the task's description and presents a list of associated models. A single task
 * can have multiple models, allowing the user to choose between different implementations or
 * versions (e.g., different LLM models for a "Chat" task). The user can then select and run a
 * specific model for the task.
 *
 * To create your own custom task, follow these steps:
 * 1. Create a class that implements this `CustomTask` interface.
 * 2. Define the metadata for your task in the `task` property, including its label, description,
 *   and associated models.
 * 3. Implement the `initializeModelFn` and `cleanUpModelFn` functions to handle the setup and
 *   teardown logic for your task's models.
 * 4. Implement the `MainScreen` composable to define the UI for your task's model detail screen.
 *   This is where the user will interact with the model within your task. It's important to note
 *   that this UI will be placed inside a pre-configured `Scaffold` that already handles the app
 *   bar, *which includes the model name, a model selector, and a configuration button. Your focus
 *   here should be on building the main content area of the screen.
 * 5. Create a Hilt module and use `@Provides` and `@IntoSet` to bind your custom task
 *   implementation into a set of `CustomTask`s. This makes your task automatically discoverable by
 *   the app's home screen.
 *
 * For a concrete example of how to implement these steps, see the
 * [com.google.ai.edge.gallery.customtasks.examplecustomtask.ExampleCustomTask] class. This example
 * implements a "Model Viewer" task that displays the text content of a model file for demonstration
 * purpose. See comments there for more details.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JC\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\u000fH&J.\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0001H\'R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0018\u00c0\u0006\u0003"}, d2 = {"Lselfgemma/talk/customtasks/common/CustomTask;", "", "task", "Lselfgemma/talk/data/Task;", "getTask", "()Lselfgemma/talk/data/Task;", "initializeModelFn", "", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "model", "Lselfgemma/talk/data/Model;", "onDone", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "error", "cleanUpModelFn", "Lkotlin/Function0;", "MainScreen", "data", "app_debug"})
public abstract interface CustomTask {
    
    /**
     * The metadata for your task and the models within the task.
     *
     * See comments of [Task] for details.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract selfgemma.talk.data.Task getTask();
    
    /**
     * Called to initialize and prepare a model for use.
     *
     * This function will be called from a coroutine with Dispatchers.Default dispatcher.
     *
     * @param context The application context.
     * @param coroutineScope The coroutine scope for asynchronous operations.
     * @param model The `Model` object containing information about the model to be initialized.
     * @param onDone A callback function to be invoked when initialization is complete. Pass an empty
     *  string on success, or an error message on failure.
     */
    public abstract void initializeModelFn(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDone);
    
    /**
     * Called to clean up resources associated with a model.
     *
     * @param context The application context.
     * @param coroutineScope The coroutine scope for asynchronous operations.
     * @param model The `Model` object to be cleaned up.
     * @param onDone A callback function to be invoked when cleanup is complete.
     */
    public abstract void cleanUpModelFn(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone);
    
    /**
     * The main Composable UI for your custom task's detail screen.
     *
     * @param data The data sent from the app. It will typically be a [CustomTaskData].
     */
    @androidx.compose.runtime.Composable()
    public abstract void MainScreen(@org.jetbrains.annotations.NotNull()
    java.lang.Object data);
}