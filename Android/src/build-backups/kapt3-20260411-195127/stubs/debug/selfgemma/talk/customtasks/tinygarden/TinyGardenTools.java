package selfgemma.talk.customtasks.tinygarden;

/**
 * A class that defines the tools available to the Tiny Garden game.
 *
 * Instructions:
 * https://github.com/google-ai-edge/LiteRT-LM/blob/main/kotlin/README.md#6-defining-and-using-tools
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B*\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007J.\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\b\b\u0001\u0010\u0015\u001a\u00020\u000f2\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007J$\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007R,\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lselfgemma/talk/customtasks/tinygarden/TinyGardenTools;", "Lcom/google/ai/edge/litertlm/ToolSet;", "onFunctionCalled", "Lkotlin/Function1;", "Lselfgemma/talk/customtasks/tinygarden/TinyGardenCommand;", "Lkotlin/ParameterName;", "name", "command", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnFunctionCalled", "()Lkotlin/jvm/functions/Function1;", "waterPlots", "", "", "", "plots", "", "", "plantSeed", "seed", "harvestPlots", "app_debug"})
public final class TinyGardenTools implements com.google.ai.edge.litertlm.ToolSet {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<selfgemma.talk.customtasks.tinygarden.TinyGardenCommand, kotlin.Unit> onFunctionCalled = null;
    
    public TinyGardenTools(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.customtasks.tinygarden.TinyGardenCommand, kotlin.Unit> onFunctionCalled) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<selfgemma.talk.customtasks.tinygarden.TinyGardenCommand, kotlin.Unit> getOnFunctionCalled() {
        return null;
    }
    
    /**
     * Waters one or more garden plots.
     */
    @com.google.ai.edge.litertlm.Tool(description = "Water one or more garden plots.")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> waterPlots(@com.google.ai.edge.litertlm.ToolParam(description = "The IDs of the plots to water.")
    @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> plots) {
        return null;
    }
    
    /**
     * Plants a seed in one or more garden plots.
     */
    @com.google.ai.edge.litertlm.Tool(description = "Plant a seed in one or more garden plots.")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> plantSeed(@com.google.ai.edge.litertlm.ToolParam(description = "The name of the seed to plant.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String seed, @com.google.ai.edge.litertlm.ToolParam(description = "The IDs of the plots to plant a seed in.")
    @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> plots) {
        return null;
    }
    
    /**
     * Harvests one or more garden plots.
     */
    @com.google.ai.edge.litertlm.Tool(description = "Harvest one or more garden plots.")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> harvestPlots(@com.google.ai.edge.litertlm.ToolParam(description = "The IDs of the plots to harvest.")
    @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> plots) {
        return null;
    }
}