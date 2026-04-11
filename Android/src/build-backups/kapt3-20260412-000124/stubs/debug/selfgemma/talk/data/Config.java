package selfgemma.talk.data;

/**
 * Base class for configuration settings.
 *
 * @param type The type of configuration editor.
 * @param key The unique key for the configuration setting.
 * @param defaultValue The default value for the configuration setting.
 * @param valueType The data type of the configuration value.
 * @param needReinitialization Indicates whether the model needs to be reinitialized after changing
 *  this config.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0001X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lselfgemma/talk/data/Config;", "", "type", "Lselfgemma/talk/data/ConfigEditorType;", "key", "Lselfgemma/talk/data/ConfigKey;", "defaultValue", "valueType", "Lselfgemma/talk/data/ValueType;", "needReinitialization", "", "<init>", "(Lselfgemma/talk/data/ConfigEditorType;Lselfgemma/talk/data/ConfigKey;Ljava/lang/Object;Lselfgemma/talk/data/ValueType;Z)V", "getType", "()Lselfgemma/talk/data/ConfigEditorType;", "getKey", "()Lselfgemma/talk/data/ConfigKey;", "getDefaultValue", "()Ljava/lang/Object;", "getValueType", "()Lselfgemma/talk/data/ValueType;", "getNeedReinitialization", "()Z", "app_debug"})
public class Config {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.ConfigEditorType type = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.ConfigKey key = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object defaultValue = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.ValueType valueType = null;
    private final boolean needReinitialization = false;
    
    public Config(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.ConfigEditorType type, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.ConfigKey key, @org.jetbrains.annotations.NotNull()
    java.lang.Object defaultValue, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.ValueType valueType, boolean needReinitialization) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.ConfigEditorType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.data.ConfigKey getKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.Object getDefaultValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.data.ValueType getValueType() {
        return null;
    }
    
    public boolean getNeedReinitialization() {
        return false;
    }
}