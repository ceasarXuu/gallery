package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\bL\b\u0080\b\u0018\u00002\u00020\u0001B\u00c3\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\n\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0#\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\'J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\'J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\'J\t\u0010O\u001a\u00020\u0007H\u00c6\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\'J\u0010\u0010Q\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010/J\u0010\u0010R\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010/J\t\u0010S\u001a\u00020\nH\u00c6\u0003J\t\u0010T\u001a\u00020\nH\u00c6\u0003J\t\u0010U\u001a\u00020\nH\u00c6\u0003J\t\u0010V\u001a\u00020\nH\u00c6\u0003J\t\u0010W\u001a\u00020\nH\u00c6\u0003J\t\u0010X\u001a\u00020\nH\u00c6\u0003J\t\u0010Y\u001a\u00020\nH\u00c6\u0003J\t\u0010Z\u001a\u00020\nH\u00c6\u0003J\t\u0010[\u001a\u00020\nH\u00c6\u0003J\t\u0010\\\u001a\u00020\u0003H\u00c6\u0003J\t\u0010]\u001a\u00020\u0003H\u00c6\u0003J\t\u0010^\u001a\u00020\nH\u00c6\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010/J\t\u0010`\u001a\u00020\u001aH\u00c6\u0003J\t\u0010a\u001a\u00020\u001aH\u00c6\u0003J\t\u0010b\u001a\u00020\nH\u00c6\u0003J\t\u0010c\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\'J\u0010\u0010e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\'J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\'J\t\u0010g\u001a\u00020\nH\u00c6\u0003J\u000f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u001a0#H\u00c6\u0003J\u00ca\u0002\u0010i\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010!\u001a\u00020\n2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0#H\u00c6\u0001\u00a2\u0006\u0002\u0010jJ\u0013\u0010k\u001a\u00020\n2\b\u0010l\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010m\u001a\u00020\u0003H\u00d6\u0001J\t\u0010n\u001a\u00020\u001aH\u00d6\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010\'R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010\'R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010(\u001a\u0004\b*\u0010\'R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010(\u001a\u0004\b-\u0010\'R\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u00100\u001a\u0004\b1\u0010/R\u0011\u0010\f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0011\u0010\u000e\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0011\u0010\u0010\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0011\u0010\u0011\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0011\u0010\u0012\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00103R\u0011\u0010\u0013\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u00103R\u0011\u0010\u0014\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u00103R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0011\u0010\u0017\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u00103R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u00100\u001a\u0004\b@\u0010/R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010BR\u0011\u0010\u001c\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u00103R\u0011\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010=R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010(\u001a\u0004\bF\u0010\'R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010(\u001a\u0004\bG\u0010\'R\u0015\u0010 \u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010(\u001a\u0004\bH\u0010\'R\u0011\u0010!\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u00103R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0#\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010K\u00a8\u0006o"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/StBookEntryRuntimeExtensions;", "", "position", "", "depth", "role", "selectiveLogic", "Lselfgemma/talk/domain/roleplay/usecase/StSelectiveLogic;", "scanDepth", "caseSensitive", "", "matchWholeWords", "matchPersonaDescription", "matchCharacterDescription", "matchCharacterPersonality", "matchCharacterDepthPrompt", "matchScenario", "matchCreatorNotes", "useRegex", "preventRecursion", "excludeRecursion", "delayUntilRecursion", "probability", "useProbability", "useGroupScoring", "outletName", "", "group", "groupOverride", "groupWeight", "sticky", "cooldown", "delay", "ignoreBudget", "triggers", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lselfgemma/talk/domain/roleplay/usecase/StSelectiveLogic;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZZZZZZZZIIZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/util/List;)V", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDepth", "getRole", "getSelectiveLogic", "()Lselfgemma/talk/domain/roleplay/usecase/StSelectiveLogic;", "getScanDepth", "getCaseSensitive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMatchWholeWords", "getMatchPersonaDescription", "()Z", "getMatchCharacterDescription", "getMatchCharacterPersonality", "getMatchCharacterDepthPrompt", "getMatchScenario", "getMatchCreatorNotes", "getUseRegex", "getPreventRecursion", "getExcludeRecursion", "getDelayUntilRecursion", "()I", "getProbability", "getUseProbability", "getUseGroupScoring", "getOutletName", "()Ljava/lang/String;", "getGroup", "getGroupOverride", "getGroupWeight", "getSticky", "getCooldown", "getDelay", "getIgnoreBudget", "getTriggers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lselfgemma/talk/domain/roleplay/usecase/StSelectiveLogic;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZZZZZZZZIIZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/util/List;)Lselfgemma/talk/domain/roleplay/usecase/StBookEntryRuntimeExtensions;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class StBookEntryRuntimeExtensions {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer position = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer depth = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer role = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.domain.roleplay.usecase.StSelectiveLogic selectiveLogic = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer scanDepth = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean caseSensitive = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean matchWholeWords = null;
    private final boolean matchPersonaDescription = false;
    private final boolean matchCharacterDescription = false;
    private final boolean matchCharacterPersonality = false;
    private final boolean matchCharacterDepthPrompt = false;
    private final boolean matchScenario = false;
    private final boolean matchCreatorNotes = false;
    private final boolean useRegex = false;
    private final boolean preventRecursion = false;
    private final boolean excludeRecursion = false;
    private final int delayUntilRecursion = 0;
    private final int probability = 0;
    private final boolean useProbability = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean useGroupScoring = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String outletName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String group = null;
    private final boolean groupOverride = false;
    private final int groupWeight = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer sticky = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer cooldown = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer delay = null;
    private final boolean ignoreBudget = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> triggers = null;
    
    public StBookEntryRuntimeExtensions(@org.jetbrains.annotations.Nullable()
    java.lang.Integer position, @org.jetbrains.annotations.Nullable()
    java.lang.Integer depth, @org.jetbrains.annotations.Nullable()
    java.lang.Integer role, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.StSelectiveLogic selectiveLogic, @org.jetbrains.annotations.Nullable()
    java.lang.Integer scanDepth, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean caseSensitive, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean matchWholeWords, boolean matchPersonaDescription, boolean matchCharacterDescription, boolean matchCharacterPersonality, boolean matchCharacterDepthPrompt, boolean matchScenario, boolean matchCreatorNotes, boolean useRegex, boolean preventRecursion, boolean excludeRecursion, int delayUntilRecursion, int probability, boolean useProbability, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean useGroupScoring, @org.jetbrains.annotations.NotNull()
    java.lang.String outletName, @org.jetbrains.annotations.NotNull()
    java.lang.String group, boolean groupOverride, int groupWeight, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sticky, @org.jetbrains.annotations.Nullable()
    java.lang.Integer cooldown, @org.jetbrains.annotations.Nullable()
    java.lang.Integer delay, boolean ignoreBudget, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> triggers) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getDepth() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRole() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.StSelectiveLogic getSelectiveLogic() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getScanDepth() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getCaseSensitive() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getMatchWholeWords() {
        return null;
    }
    
    public final boolean getMatchPersonaDescription() {
        return false;
    }
    
    public final boolean getMatchCharacterDescription() {
        return false;
    }
    
    public final boolean getMatchCharacterPersonality() {
        return false;
    }
    
    public final boolean getMatchCharacterDepthPrompt() {
        return false;
    }
    
    public final boolean getMatchScenario() {
        return false;
    }
    
    public final boolean getMatchCreatorNotes() {
        return false;
    }
    
    public final boolean getUseRegex() {
        return false;
    }
    
    public final boolean getPreventRecursion() {
        return false;
    }
    
    public final boolean getExcludeRecursion() {
        return false;
    }
    
    public final int getDelayUntilRecursion() {
        return 0;
    }
    
    public final int getProbability() {
        return 0;
    }
    
    public final boolean getUseProbability() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getUseGroupScoring() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOutletName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGroup() {
        return null;
    }
    
    public final boolean getGroupOverride() {
        return false;
    }
    
    public final int getGroupWeight() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSticky() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCooldown() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getDelay() {
        return null;
    }
    
    public final boolean getIgnoreBudget() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTriggers() {
        return null;
    }
    
    public StBookEntryRuntimeExtensions() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean component11() {
        return false;
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
    
    public final boolean component16() {
        return false;
    }
    
    public final int component17() {
        return 0;
    }
    
    public final int component18() {
        return 0;
    }
    
    public final boolean component19() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component22() {
        return null;
    }
    
    public final boolean component23() {
        return false;
    }
    
    public final int component24() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component27() {
        return null;
    }
    
    public final boolean component28() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component29() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.StSelectiveLogic component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.usecase.StBookEntryRuntimeExtensions copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer position, @org.jetbrains.annotations.Nullable()
    java.lang.Integer depth, @org.jetbrains.annotations.Nullable()
    java.lang.Integer role, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.usecase.StSelectiveLogic selectiveLogic, @org.jetbrains.annotations.Nullable()
    java.lang.Integer scanDepth, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean caseSensitive, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean matchWholeWords, boolean matchPersonaDescription, boolean matchCharacterDescription, boolean matchCharacterPersonality, boolean matchCharacterDepthPrompt, boolean matchScenario, boolean matchCreatorNotes, boolean useRegex, boolean preventRecursion, boolean excludeRecursion, int delayUntilRecursion, int probability, boolean useProbability, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean useGroupScoring, @org.jetbrains.annotations.NotNull()
    java.lang.String outletName, @org.jetbrains.annotations.NotNull()
    java.lang.String group, boolean groupOverride, int groupWeight, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sticky, @org.jetbrains.annotations.Nullable()
    java.lang.Integer cooldown, @org.jetbrains.annotations.Nullable()
    java.lang.Integer delay, boolean ignoreBudget, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> triggers) {
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