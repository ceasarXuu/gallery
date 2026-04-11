package selfgemma.talk.customtasks.agentchat;

@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c1\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0006"}, d2 = {"Lselfgemma/talk/customtasks/agentchat/AgentChatTaskModule;", "", "<init>", "()V", "provideTask", "Lselfgemma/talk/customtasks/common/CustomTask;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AgentChatTaskModule {
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.customtasks.agentchat.AgentChatTaskModule INSTANCE = null;
    
    private AgentChatTaskModule() {
        super();
    }
    
    @dagger.Provides()
    @dagger.multibindings.IntoSet()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.customtasks.common.CustomTask provideTask() {
        return null;
    }
}