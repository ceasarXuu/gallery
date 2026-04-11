package selfgemma.talk.domain.roleplay.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lselfgemma/talk/domain/roleplay/usecase/PromptSectionPriority;", "", "rank", "", "<init>", "(Ljava/lang/String;II)V", "getRank", "()I", "REQUIRED", "HIGH", "MEDIUM", "LOW", "OPTIONAL", "app_debug"})
public enum PromptSectionPriority {
    /*public static final*/ REQUIRED /* = new REQUIRED(0) */,
    /*public static final*/ HIGH /* = new HIGH(0) */,
    /*public static final*/ MEDIUM /* = new MEDIUM(0) */,
    /*public static final*/ LOW /* = new LOW(0) */,
    /*public static final*/ OPTIONAL /* = new OPTIONAL(0) */;
    private final int rank = 0;
    
    PromptSectionPriority(int rank) {
    }
    
    public final int getRank() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<selfgemma.talk.domain.roleplay.usecase.PromptSectionPriority> getEntries() {
        return null;
    }
}