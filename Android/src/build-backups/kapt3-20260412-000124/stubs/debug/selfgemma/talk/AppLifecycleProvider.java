package selfgemma.talk;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007\u00c0\u0006\u0003"}, d2 = {"Lselfgemma/talk/AppLifecycleProvider;", "", "isAppInForeground", "", "()Z", "setAppInForeground", "(Z)V", "app_debug"})
public abstract interface AppLifecycleProvider {
    
    public abstract boolean isAppInForeground();
    
    public abstract void setAppInForeground(boolean p0);
}