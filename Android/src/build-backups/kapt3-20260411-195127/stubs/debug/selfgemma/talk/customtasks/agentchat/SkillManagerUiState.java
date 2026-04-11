package selfgemma.talk.customtasks.agentchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tH\u00c6\u0003Jk\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018\u00a8\u0006,"}, d2 = {"Lselfgemma/talk/customtasks/agentchat/SkillManagerUiState;", "", "loading", "", "skills", "", "Lselfgemma/talk/customtasks/agentchat/SkillState;", "validating", "validationError", "", "importDirectoryUri", "Landroid/net/Uri;", "loadingSkillAllowlist", "featuredSkills", "Lselfgemma/talk/data/AllowedSkill;", "skillAllowlistError", "<init>", "(ZLjava/util/List;ZLjava/lang/String;Landroid/net/Uri;ZLjava/util/List;Ljava/lang/String;)V", "getLoading", "()Z", "getSkills", "()Ljava/util/List;", "getValidating", "getValidationError", "()Ljava/lang/String;", "getImportDirectoryUri", "()Landroid/net/Uri;", "getLoadingSkillAllowlist", "getFeaturedSkills", "getSkillAllowlistError", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class SkillManagerUiState {
    private final boolean loading = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.customtasks.agentchat.SkillState> skills = null;
    private final boolean validating = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String validationError = null;
    @org.jetbrains.annotations.Nullable()
    private final android.net.Uri importDirectoryUri = null;
    private final boolean loadingSkillAllowlist = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.data.AllowedSkill> featuredSkills = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String skillAllowlistError = null;
    
    public SkillManagerUiState(boolean loading, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.customtasks.agentchat.SkillState> skills, boolean validating, @org.jetbrains.annotations.Nullable()
    java.lang.String validationError, @org.jetbrains.annotations.Nullable()
    android.net.Uri importDirectoryUri, boolean loadingSkillAllowlist, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.AllowedSkill> featuredSkills, @org.jetbrains.annotations.Nullable()
    java.lang.String skillAllowlistError) {
        super();
    }
    
    public final boolean getLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.customtasks.agentchat.SkillState> getSkills() {
        return null;
    }
    
    public final boolean getValidating() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getValidationError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getImportDirectoryUri() {
        return null;
    }
    
    public final boolean getLoadingSkillAllowlist() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.AllowedSkill> getFeaturedSkills() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSkillAllowlistError() {
        return null;
    }
    
    public SkillManagerUiState() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.customtasks.agentchat.SkillState> component2() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.AllowedSkill> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.customtasks.agentchat.SkillManagerUiState copy(boolean loading, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.customtasks.agentchat.SkillState> skills, boolean validating, @org.jetbrains.annotations.Nullable()
    java.lang.String validationError, @org.jetbrains.annotations.Nullable()
    android.net.Uri importDirectoryUri, boolean loadingSkillAllowlist, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.AllowedSkill> featuredSkills, @org.jetbrains.annotations.Nullable()
    java.lang.String skillAllowlistError) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}