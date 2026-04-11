package selfgemma.talk.ui.common.tos;

/**
 * ViewModel responsible for managing terms of services related tasks.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lselfgemma/talk/ui/common/tos/TosViewModel;", "Landroidx/lifecycle/ViewModel;", "dataStoreRepository", "Lselfgemma/talk/data/DataStoreRepository;", "<init>", "(Lselfgemma/talk/data/DataStoreRepository;)V", "getIsTosAccepted", "", "acceptTos", "", "getIsGemmaTermsOfUseAccepted", "acceptGemmaTermsOfUse", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public class TosViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.DataStoreRepository dataStoreRepository = null;
    
    @javax.inject.Inject()
    public TosViewModel(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.DataStoreRepository dataStoreRepository) {
        super();
    }
    
    public final boolean getIsTosAccepted() {
        return false;
    }
    
    public final void acceptTos() {
    }
    
    public final boolean getIsGemmaTermsOfUseAccepted() {
        return false;
    }
    
    public final void acceptGemmaTermsOfUse() {
    }
}