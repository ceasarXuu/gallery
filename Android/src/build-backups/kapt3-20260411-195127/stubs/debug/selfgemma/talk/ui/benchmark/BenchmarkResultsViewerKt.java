package selfgemma.talk.ui.benchmark;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001aG\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0003\u00a2\u0006\u0002\u0010\u0014\u001aV\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0003\u001a\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u001a\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u00a8\u0006 "}, d2 = {"BenchmarkResultsViewer", "", "initialModelName", "", "modelManagerViewModel", "Lselfgemma/talk/ui/modelmanager/ModelManagerViewModel;", "viewModel", "Lselfgemma/talk/ui/benchmark/BenchmarkViewModel;", "onClose", "Lkotlin/Function0;", "StatRow", "label", "value", "modifier", "Landroidx/compose/ui/Modifier;", "unit", "baselineValue", "", "lessIsBetter", "", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Double;Z)V", "ValueSeriesRow", "valueSeries", "Lselfgemma/talk/proto/ValueSeries;", "aggregation", "Lselfgemma/talk/ui/benchmark/Aggregation;", "baselineValueSeries", "baselineAggregation", "getBenchmarkResultCsv", "llmResult", "Lselfgemma/talk/proto/LlmBenchmarkResult;", "getAggregationValue", "app_debug"})
public final class BenchmarkResultsViewerKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void BenchmarkResultsViewer(@org.jetbrains.annotations.NotNull()
    java.lang.String initialModelName, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.benchmark.BenchmarkViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClose) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void StatRow(java.lang.String label, java.lang.String value, androidx.compose.ui.Modifier modifier, java.lang.String unit, java.lang.Double baselineValue, boolean lessIsBetter) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ValueSeriesRow(java.lang.String label, selfgemma.talk.proto.ValueSeries valueSeries, selfgemma.talk.ui.benchmark.Aggregation aggregation, androidx.compose.ui.Modifier modifier, java.lang.String unit, selfgemma.talk.proto.ValueSeries baselineValueSeries, selfgemma.talk.ui.benchmark.Aggregation baselineAggregation, boolean lessIsBetter) {
    }
    
    private static final java.lang.String getBenchmarkResultCsv(selfgemma.talk.proto.LlmBenchmarkResult llmResult, selfgemma.talk.ui.benchmark.Aggregation aggregation) {
        return null;
    }
    
    private static final double getAggregationValue(selfgemma.talk.proto.ValueSeries valueSeries, selfgemma.talk.ui.benchmark.Aggregation aggregation) {
        return 0.0;
    }
}