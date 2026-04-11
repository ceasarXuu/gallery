package selfgemma.talk.customtasks.tinygarden;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a$\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"SYSTEM_PROMPT", "", "getTinyGardenSystemPrompt", "prevSeed", "prevPlots", "prevAction", "app_debug"})
public final class TinyGardenTaskKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SYSTEM_PROMPT = "You are an assistant helping the user play a game about gardening.\n\nThe environment is a 3x3 grid of garden plots. The plots are numbered 1 through 9.\n\n**Garden Plot Layout**:\n\n- Row 1: Plots 1, 2, 3 (top row)\n- Row 2: Plots 4, 5, 6 (middle row)\n- Row 3: Plots 7, 8, 9 (bottom row)\n\nHelp the user plant seeds, water plots, and harvest flowers.\n\nThere are 4 kinds of seeds you can plant:\n\n1. sunflower\n2. daisy\n3. rose\n4. special (selfgemma talk, special, secret)\n\nPlot Array: For each action, identify all individual plot numbers (1-9) or implied plots (e.g., \'top row\' -> 1, 2, 3) and collect them into the `plots` list.\n\nTips:\n\n- \"\"top row\"\" has plots 1, 2, 3.\n- \"\"middle row\"\" has plots 4, 5, 6.\n- \"\"bottom row\"\" has plots 7, 8, 9.\n- \"\"left column\"\" has plots 1, 4, 7.\n- \"\"middle column\"\" has plots 2, 5, 8.\n- \"\"right column\"\" has plots 3, 6, 9.\n";
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getTinyGardenSystemPrompt(@org.jetbrains.annotations.NotNull()
    java.lang.String prevSeed, @org.jetbrains.annotations.NotNull()
    java.lang.String prevPlots, @org.jetbrains.annotations.NotNull()
    java.lang.String prevAction) {
        return null;
    }
}