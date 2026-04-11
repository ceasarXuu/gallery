package selfgemma.talk.data;

/**
 * Configuration setting for a number slider.
 *
 * @param sliderMin The minimum value of the slider.
 * @param sliderMax The maximum value of the slider.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lselfgemma/talk/data/NumberSliderConfig;", "Lselfgemma/talk/data/Config;", "key", "Lselfgemma/talk/data/ConfigKey;", "sliderMin", "", "sliderMax", "defaultValue", "valueType", "Lselfgemma/talk/data/ValueType;", "needReinitialization", "", "<init>", "(Lselfgemma/talk/data/ConfigKey;FFFLselfgemma/talk/data/ValueType;Z)V", "getKey", "()Lselfgemma/talk/data/ConfigKey;", "getSliderMin", "()F", "getSliderMax", "getDefaultValue", "()Ljava/lang/Float;", "getValueType", "()Lselfgemma/talk/data/ValueType;", "getNeedReinitialization", "()Z", "app_debug"})
public final class NumberSliderConfig extends selfgemma.talk.data.Config {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.ConfigKey key = null;
    private final float sliderMin = 0.0F;
    private final float sliderMax = 0.0F;
    private final float defaultValue = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.ValueType valueType = null;
    private final boolean needReinitialization = false;
    
    public NumberSliderConfig(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.ConfigKey key, float sliderMin, float sliderMax, float defaultValue, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.ValueType valueType, boolean needReinitialization) {
        super(null, null, null, null, false);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.data.ConfigKey getKey() {
        return null;
    }
    
    public final float getSliderMin() {
        return 0.0F;
    }
    
    public final float getSliderMax() {
        return 0.0F;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.Float getDefaultValue() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.data.ValueType getValueType() {
        return null;
    }
    
    @java.lang.Override()
    public boolean getNeedReinitialization() {
        return false;
    }
}