package selfgemma.talk.data;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a_\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0013\u001a&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006\u001a\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0007\u00a8\u0006\u0018"}, d2 = {"convertValueToTargetType", "", "value", "valueType", "Lselfgemma/talk/data/ValueType;", "createLlmChatConfigs", "", "Lselfgemma/talk/data/Config;", "defaultMaxToken", "", "defaultMaxContextLength", "defaultTopK", "defaultTopP", "", "defaultTemperature", "accelerators", "Lselfgemma/talk/data/Accelerator;", "supportThinking", "", "(ILjava/lang/Integer;IFFLjava/util/List;Z)Ljava/util/List;", "createLlmChatConfigsForNpuModel", "getConfigValueString", "", "config", "app_debug"})
public final class ConfigKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.Object convertValueToTargetType(@org.jetbrains.annotations.NotNull()
    java.lang.Object value, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.ValueType valueType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<selfgemma.talk.data.Config> createLlmChatConfigs(int defaultMaxToken, @org.jetbrains.annotations.Nullable()
    java.lang.Integer defaultMaxContextLength, int defaultTopK, float defaultTopP, float defaultTemperature, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends selfgemma.talk.data.Accelerator> accelerators, boolean supportThinking) {
        return null;
    }
    
    /**
     * Creates the configuration settings for an LLM model that only supports NPU.
     *
     * For now NPU models don't support setting topK, topP, and temperature.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<selfgemma.talk.data.Config> createLlmChatConfigsForNpuModel(int defaultMaxToken, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends selfgemma.talk.data.Accelerator> accelerators) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getConfigValueString(@org.jetbrains.annotations.NotNull()
    java.lang.Object value, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Config config) {
        return null;
    }
}