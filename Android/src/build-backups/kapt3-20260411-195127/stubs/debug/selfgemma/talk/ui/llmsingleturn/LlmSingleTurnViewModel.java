package selfgemma.talk.ui.llmsingleturn;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0018J\u001e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u001e\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001f"}, d2 = {"Lselfgemma/talk/ui/llmsingleturn/LlmSingleTurnViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lselfgemma/talk/ui/llmsingleturn/LlmSingleTurnUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "generateResponse", "", "task", "Lselfgemma/talk/data/Task;", "model", "Lselfgemma/talk/data/Model;", "input", "", "selectPromptTemplate", "promptTemplateType", "Lselfgemma/talk/ui/llmsingleturn/PromptTemplateType;", "setInProgress", "inProgress", "", "setPreparing", "preparing", "updateResponse", "response", "stopResponse", "createUiState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class LlmSingleTurnViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<selfgemma.talk.ui.llmsingleturn.LlmSingleTurnUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.ui.llmsingleturn.LlmSingleTurnUiState> uiState = null;
    
    @javax.inject.Inject()
    public LlmSingleTurnViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<selfgemma.talk.ui.llmsingleturn.LlmSingleTurnUiState> getUiState() {
        return null;
    }
    
    public final void generateResponse(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Task task, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String input) {
    }
    
    public final void selectPromptTemplate(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmsingleturn.PromptTemplateType promptTemplateType) {
    }
    
    public final void setInProgress(boolean inProgress) {
    }
    
    public final void setPreparing(boolean preparing) {
    }
    
    public final void updateResponse(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.ui.llmsingleturn.PromptTemplateType promptTemplateType, @org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    public final void stopResponse(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Model model) {
    }
    
    private final selfgemma.talk.ui.llmsingleturn.LlmSingleTurnUiState createUiState() {
        return null;
    }
}