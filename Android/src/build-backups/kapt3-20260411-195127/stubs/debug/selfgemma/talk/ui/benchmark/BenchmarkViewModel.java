package selfgemma.talk.ui.benchmark;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001aJ\u000e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001aJ\u000e\u0010&\u001a\u00020\u00182\u0006\u0010\'\u001a\u00020(J\u0014\u0010)\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020(0+J\u000e\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u0018J\u000e\u0010.\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u0018J\u0006\u0010/\u001a\u00020\u0014J\u0016\u00100\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u001fJ\u0016\u00102\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u001fJ\u0016\u00103\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u001fJ\u0006\u00104\u001a\u00020\u0014J\u0006\u00105\u001a\u00020\u0014J\u0016\u00106\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00182\u0006\u00107\u001a\u000208J\u0016\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0+H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006="}, d2 = {"Lselfgemma/talk/ui/benchmark/BenchmarkViewModel;", "Landroidx/lifecycle/ViewModel;", "appContext", "Landroid/content/Context;", "dataStoreRepository", "Lselfgemma/talk/data/DataStoreRepository;", "<init>", "(Landroid/content/Context;Lselfgemma/talk/data/DataStoreRepository;)V", "getDataStoreRepository", "()Lselfgemma/talk/data/DataStoreRepository;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lselfgemma/talk/ui/benchmark/BenchmarkUiState;", "get_uiState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "runBenchmark", "", "model", "Lselfgemma/talk/data/Model;", "accelerator", "", "prefillTokens", "", "decodeTokens", "runCount", "setShowResultsViewer", "showResultsViewer", "", "setRunning", "running", "setTotalRunCount", "totalRunCount", "setRunProgress", "completedRunCount", "addBenchmarkResult", "result", "Lselfgemma/talk/proto/BenchmarkResult;", "setBenchmarkResults", "results", "", "deleteBenchmarkResult", "id", "setBaseline", "clearBaseline", "setExpanded", "expanded", "setBasicInfoExpanded", "setStatsExpanded", "expandAll", "collapseAll", "setAggregation", "aggregation", "Lselfgemma/talk/ui/benchmark/Aggregation;", "calculateValueSeries", "Lselfgemma/talk/proto/ValueSeries;", "values", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class BenchmarkViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DataStoreRepository dataStoreRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.ui.benchmark.BenchmarkUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.ui.benchmark.BenchmarkUiState> uiState = null;
    
    @javax.inject.Inject()
    public BenchmarkViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DataStoreRepository dataStoreRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.DataStoreRepository getDataStoreRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.ui.benchmark.BenchmarkUiState> get_uiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.ui.benchmark.BenchmarkUiState> getUiState() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {com.google.ai.edge.litertlm.ExperimentalApi.class})
    public final void runBenchmark(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String accelerator, int prefillTokens, int decodeTokens, int runCount) {
    }
    
    public final void setShowResultsViewer(boolean showResultsViewer) {
    }
    
    public final void setRunning(boolean running) {
    }
    
    public final void setTotalRunCount(int totalRunCount) {
    }
    
    public final void setRunProgress(int completedRunCount) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String addBenchmarkResult(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.proto.BenchmarkResult result) {
        return null;
    }
    
    public final void setBenchmarkResults(@org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.proto.BenchmarkResult> results) {
    }
    
    public final void deleteBenchmarkResult(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final void setBaseline(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final void clearBaseline() {
    }
    
    public final void setExpanded(@org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean expanded) {
    }
    
    public final void setBasicInfoExpanded(@org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean expanded) {
    }
    
    public final void setStatsExpanded(@org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean expanded) {
    }
    
    public final void expandAll() {
    }
    
    public final void collapseAll() {
    }
    
    public final void setAggregation(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.benchmark.Aggregation aggregation) {
    }
    
    private final selfgemma.talk.proto.ValueSeries calculateValueSeries(java.util.List<java.lang.Double> values) {
        return null;
    }
}