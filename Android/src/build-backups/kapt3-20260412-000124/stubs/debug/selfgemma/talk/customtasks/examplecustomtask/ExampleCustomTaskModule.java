package selfgemma.talk.customtasks.examplecustomtask;

/**
 * A Hilt module that provides the `ExampleCustomTask` implementation.
 *
 * This module is crucial for integrating your custom task into the application's plugin system. By
 * using `@Provides` and `@IntoSet`, you are telling Hilt to add an instance of `ExampleCustomTask`
 * to a `Set<CustomTask>`, which the main app will use to discover all available custom tasks
 * without needing to know about each one individually.
 */
@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c1\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lselfgemma/talk/customtasks/examplecustomtask/ExampleCustomTaskModule;", "", "<init>", "()V", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class ExampleCustomTaskModule {
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.customtasks.examplecustomtask.ExampleCustomTaskModule INSTANCE = null;
    
    private ExampleCustomTaskModule() {
        super();
    }
}