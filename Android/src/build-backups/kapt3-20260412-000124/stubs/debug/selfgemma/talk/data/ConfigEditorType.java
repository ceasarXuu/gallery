package selfgemma.talk.data;

/**
 * The types of configuration editors available.
 *
 * This enum defines the different UI components used to edit configuration values. Each type
 * corresponds to a specific editor widget, such as a slider or a switch.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lselfgemma/talk/data/ConfigEditorType;", "", "<init>", "(Ljava/lang/String;I)V", "LABEL", "NUMBER_SLIDER", "BOOLEAN_SWITCH", "SEGMENTED_BUTTON", "BOTTOMSHEET_SELECTOR", "app_debug"})
public enum ConfigEditorType {
    /*public static final*/ LABEL /* = new LABEL() */,
    /*public static final*/ NUMBER_SLIDER /* = new NUMBER_SLIDER() */,
    /*public static final*/ BOOLEAN_SWITCH /* = new BOOLEAN_SWITCH() */,
    /*public static final*/ SEGMENTED_BUTTON /* = new SEGMENTED_BUTTON() */,
    /*public static final*/ BOTTOMSHEET_SELECTOR /* = new BOTTOMSHEET_SELECTOR() */;
    
    ConfigEditorType() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<selfgemma.talk.data.ConfigEditorType> getEntries() {
        return null;
    }
}