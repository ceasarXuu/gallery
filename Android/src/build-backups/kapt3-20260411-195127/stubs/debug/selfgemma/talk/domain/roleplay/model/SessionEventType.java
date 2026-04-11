package selfgemma.talk.domain.roleplay.model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lselfgemma/talk/domain/roleplay/model/SessionEventType;", "", "<init>", "(Ljava/lang/String;I)V", "MODEL_SWITCH", "SUMMARY_UPDATE", "MEMORY_UPSERT", "RESET", "EXPORT", "CONTEXT_BUDGET_APPLIED", "CONTEXT_OVERFLOW_RECOVERED", "app_debug"})
public enum SessionEventType {
    /*public static final*/ MODEL_SWITCH /* = new MODEL_SWITCH() */,
    /*public static final*/ SUMMARY_UPDATE /* = new SUMMARY_UPDATE() */,
    /*public static final*/ MEMORY_UPSERT /* = new MEMORY_UPSERT() */,
    /*public static final*/ RESET /* = new RESET() */,
    /*public static final*/ EXPORT /* = new EXPORT() */,
    /*public static final*/ CONTEXT_BUDGET_APPLIED /* = new CONTEXT_BUDGET_APPLIED() */,
    /*public static final*/ CONTEXT_OVERFLOW_RECOVERED /* = new CONTEXT_OVERFLOW_RECOVERED() */;
    
    SessionEventType() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<selfgemma.talk.domain.roleplay.model.SessionEventType> getEntries() {
        return null;
    }
}