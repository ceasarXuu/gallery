package selfgemma.talk;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lselfgemma/talk/DefaultAppLifecycleProvider;", "Lselfgemma/talk/AppLifecycleProvider;", "<init>", "()V", "_isAppInForeground", "", "value", "isAppInForeground", "()Z", "setAppInForeground", "(Z)V", "app_debug"})
public final class DefaultAppLifecycleProvider implements selfgemma.talk.AppLifecycleProvider {
    private boolean _isAppInForeground = false;
    
    public DefaultAppLifecycleProvider() {
        super();
    }
    
    @java.lang.Override()
    public boolean isAppInForeground() {
        return false;
    }
    
    @java.lang.Override()
    public void setAppInForeground(boolean value) {
    }
}