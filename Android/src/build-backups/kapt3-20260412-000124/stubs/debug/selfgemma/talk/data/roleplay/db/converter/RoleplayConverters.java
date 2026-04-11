package selfgemma.talk.data.roleplay.db.converter;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0007J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lselfgemma/talk/data/roleplay/db/converter/RoleplayConverters;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "fromStringList", "", "value", "", "toStringList", "fromMessageSide", "Lselfgemma/talk/domain/roleplay/model/MessageSide;", "toMessageSide", "fromMessageKind", "Lselfgemma/talk/domain/roleplay/model/MessageKind;", "toMessageKind", "fromMessageStatus", "Lselfgemma/talk/domain/roleplay/model/MessageStatus;", "toMessageStatus", "fromMemoryCategory", "Lselfgemma/talk/domain/roleplay/model/MemoryCategory;", "toMemoryCategory", "fromSessionEventType", "Lselfgemma/talk/domain/roleplay/model/SessionEventType;", "toSessionEventType", "app_debug"})
public final class RoleplayConverters {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    public RoleplayConverters() {
        super();
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromStringList(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> toStringList(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromMessageSide(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.MessageSide value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.MessageSide toMessageSide(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromMessageKind(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.MessageKind value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.MessageKind toMessageKind(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromMessageStatus(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.MessageStatus value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.MessageStatus toMessageStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromMemoryCategory(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.MemoryCategory value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.MemoryCategory toMemoryCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromSessionEventType(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.SessionEventType value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.domain.roleplay.model.SessionEventType toSessionEventType(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
}