package selfgemma.talk.data;

/**
 * Repository for managing data using Proto DataStore.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u00002\u00020\u0001BM\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0016\u0010&\u001a\u00020\u00102\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\u0012H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0012H\u0016J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0010H\u0016J\b\u0010-\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020\u0010H\u0016J\b\u0010/\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u00020+H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\u000e\u00105\u001a\b\u0012\u0004\u0012\u0002040\u0012H\u0016J\u0010\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u000204H\u0016J\u0016\u00108\u001a\u00020\u00102\f\u00109\u001a\b\u0012\u0004\u0012\u0002040\u0012H\u0016J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020+H\u0016J\b\u0010<\u001a\u00020+H\u0016J\u0010\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020+H\u0016J\b\u0010?\u001a\u00020+H\u0016J\u0010\u0010@\u001a\u00020\u00102\u0006\u0010>\u001a\u00020+H\u0016J\b\u0010A\u001a\u00020+H\u0016J\u0010\u0010B\u001a\u00020\u00102\u0006\u0010>\u001a\u00020+H\u0016J\b\u0010C\u001a\u00020+H\u0016J\u0012\u0010D\u001a\u00020\u00102\b\u0010E\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010F\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010G\u001a\u00020\u00102\b\u0010E\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010H\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010I\u001a\u00020\u00102\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020KH\u0016J\u0010\u0010M\u001a\u00020\u00102\u0006\u0010N\u001a\u00020OH\u0016J\u000e\u0010P\u001a\b\u0012\u0004\u0012\u00020O0\u0012H\u0016J\u0010\u0010Q\u001a\u00020\u00102\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020\u00102\u0006\u0010U\u001a\u00020VH\u0016J\u0016\u0010W\u001a\u00020\u00102\f\u0010X\u001a\b\u0012\u0004\u0012\u00020V0\u0012H\u0016J\u0018\u0010Y\u001a\u00020\u00102\u0006\u0010U\u001a\u00020V2\u0006\u0010Z\u001a\u00020+H\u0016J\u0010\u0010[\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020+H\u0016J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00020V0\u0012H\u0016J\u0010\u0010]\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u0013H\u0016J\u001c\u0010_\u001a\u00020\u00102\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00130aH\u0096@\u00a2\u0006\u0002\u0010bJ\u0010\u0010c\u001a\u00020\u00102\u0006\u0010d\u001a\u00020\u0013H\u0016J\u0010\u0010e\u001a\u00020\u00102\u0006\u0010d\u001a\u00020\u0013H\u0016J\u0010\u0010f\u001a\u00020+2\u0006\u0010d\u001a\u00020\u0013H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006g"}, d2 = {"Lselfgemma/talk/data/DefaultDataStoreRepository;", "Lselfgemma/talk/data/DataStoreRepository;", "dataStore", "Landroidx/datastore/core/DataStore;", "Lselfgemma/talk/proto/Settings;", "userDataDataStore", "Lselfgemma/talk/proto/UserData;", "cutoutDataStore", "Lselfgemma/talk/proto/CutoutCollection;", "benchmarkResultsDataStore", "Lselfgemma/talk/proto/BenchmarkResults;", "skillsDataStore", "Lselfgemma/talk/proto/Skills;", "<init>", "(Landroidx/datastore/core/DataStore;Landroidx/datastore/core/DataStore;Landroidx/datastore/core/DataStore;Landroidx/datastore/core/DataStore;Landroidx/datastore/core/DataStore;)V", "saveTextInputHistory", "", "history", "", "", "readTextInputHistory", "saveTheme", "theme", "Lselfgemma/talk/proto/Theme;", "readTheme", "saveSecret", "key", "value", "readSecret", "deleteSecret", "saveAccessTokenData", "accessToken", "refreshToken", "expiresAt", "", "clearAccessTokenData", "readAccessTokenData", "Lselfgemma/talk/proto/AccessTokenData;", "saveImportedModels", "importedModels", "Lselfgemma/talk/proto/ImportedModel;", "readImportedModels", "isTosAccepted", "", "acceptTos", "isGemmaTermsOfUseAccepted", "acceptGemmaTermsOfUse", "getHasRunTinyGarden", "setHasRunTinyGarden", "hasRun", "addCutout", "cutout", "Lselfgemma/talk/proto/Cutout;", "getAllCutouts", "setCutout", "newCutout", "setCutouts", "cutouts", "setHasSeenBenchmarkComparisonHelp", "seen", "getHasSeenBenchmarkComparisonHelp", "setMessageSoundsEnabled", "enabled", "areMessageSoundsEnabled", "setLiveTokenSpeedEnabled", "isLiveTokenSpeedEnabled", "setStreamingOutputEnabled", "isStreamingOutputEnabled", "setRoleEditorAssistantModelId", "modelId", "getRoleEditorAssistantModelId", "setLastUsedLlmModelId", "getLastUsedLlmModelId", "setStUserProfile", "profile", "Lselfgemma/talk/domain/roleplay/model/StUserProfile;", "getStUserProfile", "addBenchmarkResult", "result", "Lselfgemma/talk/proto/BenchmarkResult;", "getAllBenchmarkResults", "deleteBenchmarkResult", "index", "", "addSkill", "skill", "Lselfgemma/talk/proto/Skill;", "setSkills", "skills", "setSkillSelected", "selected", "setAllSkillsSelected", "getAllSkills", "deleteSkill", "name", "deleteSkills", "names", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addViewedPromoId", "promoId", "removeViewedPromoId", "hasViewedPromo", "app_debug"})
public final class DefaultDataStoreRepository implements selfgemma.talk.data.DataStoreRepository {
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.core.DataStore<selfgemma.talk.proto.Settings> dataStore = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.core.DataStore<selfgemma.talk.proto.UserData> userDataDataStore = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.core.DataStore<selfgemma.talk.proto.CutoutCollection> cutoutDataStore = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.core.DataStore<selfgemma.talk.proto.BenchmarkResults> benchmarkResultsDataStore = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.core.DataStore<selfgemma.talk.proto.Skills> skillsDataStore = null;
    
    public DefaultDataStoreRepository(@org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<selfgemma.talk.proto.Settings> dataStore, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<selfgemma.talk.proto.UserData> userDataDataStore, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<selfgemma.talk.proto.CutoutCollection> cutoutDataStore, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<selfgemma.talk.proto.BenchmarkResults> benchmarkResultsDataStore, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<selfgemma.talk.proto.Skills> skillsDataStore) {
        super();
    }
    
    @java.lang.Override()
    public void saveTextInputHistory(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> history) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.String> readTextInputHistory() {
        return null;
    }
    
    @java.lang.Override()
    public void saveTheme(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.Theme theme) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.proto.Theme readTheme() {
        return null;
    }
    
    @java.lang.Override()
    public void saveSecret(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.String readSecret(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return null;
    }
    
    @java.lang.Override()
    public void deleteSecret(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    @java.lang.Override()
    public void saveAccessTokenData(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    java.lang.String refreshToken, long expiresAt) {
    }
    
    @java.lang.Override()
    public void clearAccessTokenData() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public selfgemma.talk.proto.AccessTokenData readAccessTokenData() {
        return null;
    }
    
    @java.lang.Override()
    public void saveImportedModels(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.proto.ImportedModel> importedModels) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<selfgemma.talk.proto.ImportedModel> readImportedModels() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isTosAccepted() {
        return false;
    }
    
    @java.lang.Override()
    public void acceptTos() {
    }
    
    @java.lang.Override()
    public boolean isGemmaTermsOfUseAccepted() {
        return false;
    }
    
    @java.lang.Override()
    public void acceptGemmaTermsOfUse() {
    }
    
    @java.lang.Override()
    public boolean getHasRunTinyGarden() {
        return false;
    }
    
    @java.lang.Override()
    public void setHasRunTinyGarden(boolean hasRun) {
    }
    
    @java.lang.Override()
    public void addCutout(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.Cutout cutout) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<selfgemma.talk.proto.Cutout> getAllCutouts() {
        return null;
    }
    
    @java.lang.Override()
    public void setCutout(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.Cutout newCutout) {
    }
    
    @java.lang.Override()
    public void setCutouts(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.proto.Cutout> cutouts) {
    }
    
    @java.lang.Override()
    public void setHasSeenBenchmarkComparisonHelp(boolean seen) {
    }
    
    @java.lang.Override()
    public boolean getHasSeenBenchmarkComparisonHelp() {
        return false;
    }
    
    @java.lang.Override()
    public void setMessageSoundsEnabled(boolean enabled) {
    }
    
    @java.lang.Override()
    public boolean areMessageSoundsEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public void setLiveTokenSpeedEnabled(boolean enabled) {
    }
    
    @java.lang.Override()
    public boolean isLiveTokenSpeedEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public void setStreamingOutputEnabled(boolean enabled) {
    }
    
    @java.lang.Override()
    public boolean isStreamingOutputEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public void setRoleEditorAssistantModelId(@org.jetbrains.annotations.Nullable()
    java.lang.String modelId) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getRoleEditorAssistantModelId() {
        return null;
    }
    
    @java.lang.Override()
    public void setLastUsedLlmModelId(@org.jetbrains.annotations.Nullable()
    java.lang.String modelId) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getLastUsedLlmModelId() {
        return null;
    }
    
    @java.lang.Override()
    public void setStUserProfile(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.domain.roleplay.model.StUserProfile profile) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public selfgemma.talk.domain.roleplay.model.StUserProfile getStUserProfile() {
        return null;
    }
    
    @java.lang.Override()
    public void addBenchmarkResult(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.BenchmarkResult result) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<selfgemma.talk.proto.BenchmarkResult> getAllBenchmarkResults() {
        return null;
    }
    
    @java.lang.Override()
    public void deleteBenchmarkResult(int index) {
    }
    
    @java.lang.Override()
    public void addSkill(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.Skill skill) {
    }
    
    @java.lang.Override()
    public void setSkills(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.proto.Skill> skills) {
    }
    
    @java.lang.Override()
    public void setSkillSelected(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.Skill skill, boolean selected) {
    }
    
    @java.lang.Override()
    public void setAllSkillsSelected(boolean selected) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<selfgemma.talk.proto.Skill> getAllSkills() {
        return null;
    }
    
    @java.lang.Override()
    public void deleteSkill(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteSkills(@org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> names, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public void addViewedPromoId(@org.jetbrains.annotations.NotNull()
    java.lang.String promoId) {
    }
    
    @java.lang.Override()
    public void removeViewedPromoId(@org.jetbrains.annotations.NotNull()
    java.lang.String promoId) {
    }
    
    @java.lang.Override()
    public boolean hasViewedPromo(@org.jetbrains.annotations.NotNull()
    java.lang.String promoId) {
        return false;
    }
}