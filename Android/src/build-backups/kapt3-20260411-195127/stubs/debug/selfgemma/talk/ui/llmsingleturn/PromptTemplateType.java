package selfgemma.talk.ui.llmsingleturn;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001Bo\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012D\b\u0002\u0010\u0006\u001a>\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016RM\u0010\u0006\u001a>\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e\u00a8\u0006\u001f"}, d2 = {"Lselfgemma/talk/ui/llmsingleturn/PromptTemplateType;", "", "label", "", "config", "Lselfgemma/talk/ui/llmsingleturn/PromptTemplateConfig;", "genFullPrompt", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "userInput", "", "", "inputEditorValues", "Landroidx/compose/ui/text/AnnotatedString;", "examplePrompts", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lselfgemma/talk/ui/llmsingleturn/PromptTemplateConfig;Lkotlin/jvm/functions/Function2;Ljava/util/List;)V", "getLabel", "()Ljava/lang/String;", "getConfig", "()Lselfgemma/talk/ui/llmsingleturn/PromptTemplateConfig;", "getGenFullPrompt", "()Lkotlin/jvm/functions/Function2;", "getExamplePrompts", "()Ljava/util/List;", "FREE_FORM", "REWRITE_TONE", "SUMMARIZE_TEXT", "CODE_SNIPPET", "app_debug"})
@kotlin.Suppress(names = {"ImmutableEnum"})
public enum PromptTemplateType {
    /*public static final*/ FREE_FORM /* = new FREE_FORM(null, null, null, null) */,
    /*public static final*/ REWRITE_TONE /* = new REWRITE_TONE(null, null, null, null) */,
    /*public static final*/ SUMMARIZE_TEXT /* = new SUMMARIZE_TEXT(null, null, null, null) */,
    /*public static final*/ CODE_SNIPPET /* = new CODE_SNIPPET(null, null, null, null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String label = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.ui.llmsingleturn.PromptTemplateConfig config = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<java.lang.String, java.util.Map<java.lang.String, ? extends java.lang.Object>, androidx.compose.ui.text.AnnotatedString> genFullPrompt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> examplePrompts = null;
    
    PromptTemplateType(java.lang.String label, selfgemma.talk.ui.llmsingleturn.PromptTemplateConfig config, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.util.Map<java.lang.String, ? extends java.lang.Object>, androidx.compose.ui.text.AnnotatedString> genFullPrompt, java.util.List<java.lang.String> examplePrompts) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLabel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.ui.llmsingleturn.PromptTemplateConfig getConfig() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<java.lang.String, java.util.Map<java.lang.String, ? extends java.lang.Object>, androidx.compose.ui.text.AnnotatedString> getGenFullPrompt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getExamplePrompts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<selfgemma.talk.ui.llmsingleturn.PromptTemplateType> getEntries() {
        return null;
    }
}