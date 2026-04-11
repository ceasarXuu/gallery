package selfgemma.talk.customtasks.agentchat;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aJ\b\u0010\u001b\u001a\u00020\u0018H\u0002J?\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00180!J\u000e\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\'J\u000e\u0010(\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\'J7\u0010)\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00180!J\u000e\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0012J\u000e\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u0012J\u0010\u0010.\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010/\u001a\u00020\u00182\b\u00100\u001a\u0004\u0018\u00010\'J\u0016\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0012J\u000e\u00105\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001eJ\u0014\u00106\u001a\u00020\u00182\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001e08J\u0016\u00109\u001a\u00020\u00182\u0006\u00102\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0012J\u000e\u0010<\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u0012J\f\u0010=\u001a\b\u0012\u0004\u0012\u0002030>J\u000e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u001eJ\u0010\u0010B\u001a\u0004\u0018\u0001032\u0006\u0010#\u001a\u00020\u001eJ\u0018\u0010C\u001a\u0004\u0018\u00010\u001e2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001eJ\u0016\u0010F\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010G\u001a\u00020\u001eJF\u0010H\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u000103\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0>0I2\u0006\u0010J\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00122\b\b\u0002\u0010L\u001a\u00020\u001e2\b\b\u0002\u0010M\u001a\u00020\u001eJk\u0010N\u001a\u00020\u00182\u0006\u0010O\u001a\u00020P2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u001e2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0T2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2!\u0010U\u001a\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00180!J.\u0010V\u001a\u00020\u00182\u0006\u00102\u001a\u0002032\u001e\u0010\u0019\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0T\u0012\u0004\u0012\u00020\u00180!J\u0016\u0010W\u001a\u00020\u00182\u0006\u00102\u001a\u0002032\u0006\u0010E\u001a\u00020\u001eJ\u000e\u0010X\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u001eJ(\u0010Y\u001a\u00020\u00182\u0006\u0010Z\u001a\u00020[2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u001eH\u0002J$\u0010\\\u001a\u00020\u00182\u0006\u0010]\u001a\u00020[2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0TH\u0002J\u0018\u0010^\u001a\u00020\u00182\u0006\u0010_\u001a\u00020\u001e2\u0006\u0010`\u001a\u000203H\u0002J\u0010\u0010a\u001a\u00020[2\u0006\u0010b\u001a\u00020\u001eH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006c"}, d2 = {"Lselfgemma/talk/customtasks/agentchat/SkillManagerViewModel;", "Landroidx/lifecycle/ViewModel;", "dataStoreRepository", "Lselfgemma/talk/data/DataStoreRepository;", "context", "Landroid/content/Context;", "<init>", "(Lselfgemma/talk/data/DataStoreRepository;Landroid/content/Context;)V", "getDataStoreRepository", "()Lselfgemma/talk/data/DataStoreRepository;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lselfgemma/talk/customtasks/agentchat/SkillManagerUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "skillLoaded", "", "getSkillLoaded", "()Z", "setSkillLoaded", "(Z)V", "loadSkills", "", "onDone", "Lkotlin/Function0;", "loadSkillAllowlist", "validateAndAddSkillFromUrl", "url", "", "onSuccess", "onValidationError", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "error", "checkLocalSkillExisted", "directoryUri", "Landroid/net/Uri;", "checkBuiltInSkillExistedForImportedSkill", "validateAndAddSkillFromLocalImport", "setLoading", "loading", "setValidating", "validating", "setValidationError", "setImportDirectoryUri", "uri", "addSkill", "skill", "Lselfgemma/talk/proto/Skill;", "addToDataStore", "deleteSkill", "deleteSkills", "names", "", "setSkillSelected", "Lselfgemma/talk/customtasks/agentchat/SkillState;", "selected", "setAllSkillsSelected", "getSelectedSkills", "", "getSystemPrompt", "Lcom/google/ai/edge/litertlm/Contents;", "baseSystemPrompt", "getSkill", "getJsSkillUrl", "skillName", "scriptName", "getJsSkillWebviewUrl", "getSelectedSkillsNamesAndDescriptions", "convertSkillMdToProto", "Lkotlin/Pair;", "mdContent", "builtIn", "skillUrl", "importDir", "saveSkillEdit", "index", "", "description", "instructions", "scriptsContent", "", "onError", "loadSkillScriptsContent", "deleteSkillScript", "isSkillSelected", "writeSkillMd", "skillMdFile", "Ljava/io/File;", "saveScripts", "scriptDestDir", "updateSkillInDataStore", "oldName", "updatedSkill", "getSkillDestinationDir", "originalImportDirName", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SkillManagerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DataStoreRepository dataStoreRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.customtasks.agentchat.SkillManagerUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.customtasks.agentchat.SkillManagerUiState> uiState = null;
    private boolean skillLoaded = false;
    
    @javax.inject.Inject()
    public SkillManagerViewModel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DataStoreRepository dataStoreRepository, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.DataStoreRepository getDataStoreRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.customtasks.agentchat.SkillManagerUiState> getUiState() {
        return null;
    }
    
    public final boolean getSkillLoaded() {
        return false;
    }
    
    public final void setSkillLoaded(boolean p0) {
    }
    
    public final void loadSkills(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    private final void loadSkillAllowlist() {
    }
    
    public final void validateAndAddSkillFromUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValidationError) {
    }
    
    /**
     * Checks if a local skill with the given [directoryUri] already exists in the app's internal
     * storage.
     */
    public final boolean checkLocalSkillExisted(@org.jetbrains.annotations.NotNull()
    android.net.Uri directoryUri) {
        return false;
    }
    
    /**
     * Checks if a built-in skill with the same name as the skill defined in the provided
     * [directoryUri]'s SKILL.md file already exists.
     */
    public final boolean checkBuiltInSkillExistedForImportedSkill(@org.jetbrains.annotations.NotNull()
    android.net.Uri directoryUri) {
        return false;
    }
    
    public final void validateAndAddSkillFromLocalImport(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValidationError) {
    }
    
    public final void setLoading(boolean loading) {
    }
    
    public final void setValidating(boolean validating) {
    }
    
    public final void setValidationError(@org.jetbrains.annotations.Nullable()
    java.lang.String error) {
    }
    
    public final void setImportDirectoryUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri uri) {
    }
    
    public final void addSkill(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.Skill skill, boolean addToDataStore) {
    }
    
    public final void deleteSkill(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void deleteSkills(@org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> names) {
    }
    
    public final void setSkillSelected(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.customtasks.agentchat.SkillState skill, boolean selected) {
    }
    
    public final void setAllSkillsSelected(boolean selected) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.proto.Skill> getSelectedSkills() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.ai.edge.litertlm.Contents getSystemPrompt(@org.jetbrains.annotations.NotNull()
    java.lang.String baseSystemPrompt) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.proto.Skill getSkill(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getJsSkillUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String skillName, @org.jetbrains.annotations.NotNull()
    java.lang.String scriptName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJsSkillWebviewUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String skillName, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedSkillsNamesAndDescriptions() {
        return null;
    }
    
    /**
     * Converts the content of a skill.md file to a [Skill] proto.
     *
     * The expected format is:
     * ```
     * ---
     * name: name-of-the-skill
     * description: description of the skill
     * metadata:
     *  key: value
     * ---
     *
     * other instructions text
     * ```
     *
     * @return A [Pair] containing the parsed [Skill] proto (or null if errors occurred) and a list of
     *  error messages.
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<selfgemma.talk.proto.Skill, java.util.List<java.lang.String>> convertSkillMdToProto(@org.jetbrains.annotations.NotNull()
    java.lang.String mdContent, boolean builtIn, boolean selected, @org.jetbrains.annotations.NotNull()
    java.lang.String skillUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String importDir) {
        return null;
    }
    
    /**
     * Saves or updates a custom skill.
     */
    public final void saveSkillEdit(int index, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String instructions, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> scriptsContent, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    /**
     * Loads the content of skill scripts from the local file system.
     */
    public final void loadSkillScriptsContent(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.Skill skill, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.Map<java.lang.String, java.lang.String>, kotlin.Unit> onDone) {
    }
    
    /**
     * Deletes a specific script file associated with a locally imported skill.
     */
    public final void deleteSkillScript(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.Skill skill, @org.jetbrains.annotations.NotNull()
    java.lang.String scriptName) {
    }
    
    /**
     * Checks if a skill with the given [skillName] is currently selected.
     */
    public final boolean isSkillSelected(@org.jetbrains.annotations.NotNull()
    java.lang.String skillName) {
        return false;
    }
    
    private final void writeSkillMd(java.io.File skillMdFile, java.lang.String name, java.lang.String description, java.lang.String instructions) {
    }
    
    private final void saveScripts(java.io.File scriptDestDir, java.util.Map<java.lang.String, java.lang.String> scriptsContent) {
    }
    
    private final void updateSkillInDataStore(java.lang.String oldName, selfgemma.talk.proto.Skill updatedSkill) {
    }
    
    private final java.io.File getSkillDestinationDir(java.lang.String originalImportDirName) {
        return null;
    }
}