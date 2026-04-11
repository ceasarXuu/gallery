package selfgemma.talk.customtasks.mobileactions;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0007J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0007J<\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\f2\b\b\u0001\u0010\u0010\u001a\u00020\f2\b\b\u0001\u0010\u0011\u001a\u00020\f2\b\b\u0001\u0010\u0012\u001a\u00020\fH\u0007J2\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0001\u0010\u0014\u001a\u00020\f2\b\b\u0001\u0010\u0015\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\fH\u0007J\u001e\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0001\u0010\u0018\u001a\u00020\fH\u0007J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0007J(\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0001\u0010\u001b\u001a\u00020\f2\b\b\u0001\u0010\u001c\u001a\u00020\fH\u0007R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001d"}, d2 = {"Lselfgemma/talk/customtasks/mobileactions/MobileActionsTools;", "Lcom/google/ai/edge/litertlm/ToolSet;", "onFunctionCalled", "Lkotlin/Function1;", "Lselfgemma/talk/customtasks/mobileactions/Action;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnFunctionCalled", "()Lkotlin/jvm/functions/Function1;", "turnOnFlashlight", "", "", "turnOffFlashlight", "createContact", "firstName", "lastName", "phoneNumber", "email", "sendEmail", "to", "subject", "body", "showLocationOnMap", "location", "openWifiSettings", "createCalendarEvent", "datetime", "title", "app_debug"})
public final class MobileActionsTools implements com.google.ai.edge.litertlm.ToolSet {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<selfgemma.talk.customtasks.mobileactions.Action, kotlin.Unit> onFunctionCalled = null;
    
    public MobileActionsTools(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super selfgemma.talk.customtasks.mobileactions.Action, kotlin.Unit> onFunctionCalled) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<selfgemma.talk.customtasks.mobileactions.Action, kotlin.Unit> getOnFunctionCalled() {
        return null;
    }
    
    /**
     * Turns on flashlight.
     */
    @com.google.ai.edge.litertlm.Tool(description = "Turns the flashlight on")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> turnOnFlashlight() {
        return null;
    }
    
    /**
     * Turns off flashlight.
     */
    @com.google.ai.edge.litertlm.Tool(description = "Turns the flashlight off")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> turnOffFlashlight() {
        return null;
    }
    
    /**
     * Creates contact.
     */
    @com.google.ai.edge.litertlm.Tool(description = "Creates a contact in the phone\'s contact list.")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> createContact(@com.google.ai.edge.litertlm.ToolParam(description = "The first name of the contact.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String firstName, @com.google.ai.edge.litertlm.ToolParam(description = "The last name of the contact.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String lastName, @com.google.ai.edge.litertlm.ToolParam(description = "The phone number of the contact.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @com.google.ai.edge.litertlm.ToolParam(description = "The email address of the contact.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return null;
    }
    
    /**
     * Sends email.
     */
    @com.google.ai.edge.litertlm.Tool(description = "Sends an email.")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> sendEmail(@com.google.ai.edge.litertlm.ToolParam(description = "The email address of the recipient.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String to, @com.google.ai.edge.litertlm.ToolParam(description = "The subject of the email.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String subject, @com.google.ai.edge.litertlm.ToolParam(description = "The body of the email.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String body) {
        return null;
    }
    
    /**
     * Shows location on map.
     */
    @com.google.ai.edge.litertlm.Tool(description = "Shows a location on the map.")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> showLocationOnMap(@com.google.ai.edge.litertlm.ToolParam(description = "The location to search for. May be the name of a place, a business, or an address.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String location) {
        return null;
    }
    
    /**
     * Opens wifi settings.
     */
    @com.google.ai.edge.litertlm.Tool(description = "Opens the WiFi settings.")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> openWifiSettings() {
        return null;
    }
    
    /**
     * Creates calendar events.
     */
    @com.google.ai.edge.litertlm.Tool(description = "Creates a new calendar event.")
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> createCalendarEvent(@com.google.ai.edge.litertlm.ToolParam(description = "The date and time of the event in the format YYYY-MM-DDTHH:MM:SS.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String datetime, @com.google.ai.edge.litertlm.ToolParam(description = "The title of the event.")
    @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
}