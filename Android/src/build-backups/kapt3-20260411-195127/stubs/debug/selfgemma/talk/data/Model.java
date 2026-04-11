package selfgemma.talk.data;

/**
 * A model for a task (see [Task]).
 *
 * A task can have multiple models. For example, a task might be "LLM Chat", and it might have
 * models such as Gemma2, Gemma3, etc.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\bD\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001B\u00bd\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u0015\u0012\b\b\u0002\u0010!\u001a\u00020\u0015\u0012\b\b\u0002\u0010\"\u001a\u00020\u0015\u0012\b\b\u0002\u0010#\u001a\u00020\u0015\u0012\b\b\u0002\u0010$\u001a\u00020\u0015\u0012\b\b\u0002\u0010%\u001a\u00020\f\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\u0007\u0012\b\b\u0002\u0010(\u001a\u00020\'\u0012\b\b\u0002\u0010)\u001a\u00020\u0015\u0012\b\b\u0002\u0010*\u001a\u00020\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010,\u001a\u00020\u0015\u0012\b\b\u0002\u0010-\u001a\u00020\u0015\u0012\u0014\b\u0002\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010/\u0012\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010/\u0012\b\b\u0002\u00101\u001a\u00020\u000f\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b3\u00104J\u0006\u0010s\u001a\u00020tJ\u0018\u0010u\u001a\u00020\u00032\u0006\u0010v\u001a\u00020w2\b\b\u0002\u0010x\u001a\u00020\u0003J\u0018\u0010y\u001a\u00020\f2\u0006\u0010z\u001a\u00020{2\b\b\u0002\u0010|\u001a\u00020\fJ\u0018\u0010}\u001a\u00020~2\u0006\u0010z\u001a\u00020{2\b\b\u0002\u0010|\u001a\u00020~J\u0018\u0010\u007f\u001a\u00020\u00152\u0006\u0010z\u001a\u00020{2\b\b\u0002\u0010|\u001a\u00020\u0015J\u0019\u0010\u0080\u0001\u001a\u00020\u00032\u0006\u0010z\u001a\u00020{2\b\b\u0002\u0010|\u001a\u00020\u0003J\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003J#\u0010\u0082\u0001\u001a\u00020\u00012\u0006\u0010z\u001a\u00020{2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u0010|\u001a\u00020\u0001H\u0002J\n\u0010\u0085\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010@J\n\u0010\u008c\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008d\u0001\u001a\u00020\u000fH\u00c6\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007H\u00c6\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0017H\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0007H\u00c6\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u009f\u0001\u001a\u00020\fH\u00c6\u0003J\u0010\u0010\u00a0\u0001\u001a\b\u0012\u0004\u0012\u00020\'0\u0007H\u00c6\u0003J\n\u0010\u00a1\u0001\u001a\u00020\'H\u00c6\u0003J\n\u0010\u00a2\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u00a3\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u00a4\u0001\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\n\u0010\u00a5\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u00a6\u0001\u001a\u00020\u0015H\u00c6\u0003J\u0016\u0010\u00a7\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010/H\u00c6\u0003J\u0016\u0010\u00a8\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010/H\u00c6\u0003J\n\u0010\u00a9\u0001\u001a\u00020\u000fH\u00c6\u0003J\f\u0010\u00aa\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00c8\u0003\u0010\u00ab\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010\u001d\u001a\u00020\u00032\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00072\b\b\u0002\u0010 \u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u00152\b\b\u0002\u0010$\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020\f2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\u00072\b\b\u0002\u0010(\u001a\u00020\'2\b\b\u0002\u0010)\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010,\u001a\u00020\u00152\b\b\u0002\u0010-\u001a\u00020\u00152\u0014\b\u0002\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010/2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010/2\b\b\u0002\u00101\u001a\u00020\u000f2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0003\u0010\u00ac\u0001J\u0015\u0010\u00ad\u0001\u001a\u00020\u00152\t\u0010\u00ae\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u00af\u0001\u001a\u00020\fH\u00d6\u0001J\n\u0010\u00b0\u0001\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00106R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00106R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u00106R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010:R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010A\u001a\u0004\b?\u0010@R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u00106R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u00106R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u00106R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010:R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010HR\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u00106R\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u00106R\u0011\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010HR\u0011\u0010\u001b\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010HR\u0011\u0010\u001c\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010HR\u0011\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u00106R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010:R\u0011\u0010 \u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010HR\u0011\u0010!\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010HR\u0011\u0010\"\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010HR\u0011\u0010#\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010HR\u0011\u0010$\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010HR\u0011\u0010%\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010:R\u0011\u0010(\u001a\u00020\'\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0011\u0010)\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010HR\u001a\u0010*\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u00106\"\u0004\b]\u0010^R\u001c\u0010+\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010,\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010H\"\u0004\bd\u0010eR\u001a\u0010-\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010H\"\u0004\bg\u0010eR&\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR&\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010i\"\u0004\bm\u0010kR\u001a\u00101\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010D\"\u0004\bo\u0010pR\u001c\u00102\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u00106\"\u0004\br\u0010^\u00a8\u0006\u00b1\u0001"}, d2 = {"Lselfgemma/talk/data/Model;", "", "name", "", "displayName", "info", "configs", "", "Lselfgemma/talk/data/Config;", "learnMoreUrl", "bestForTaskIds", "minDeviceMemoryInGb", "", "url", "sizeInBytes", "", "downloadFileName", "version", "extraDataFiles", "Lselfgemma/talk/data/ModelDataFile;", "isLlm", "", "runtimeType", "Lselfgemma/talk/data/RuntimeType;", "localFileRelativeDirPathOverride", "localModelFilePathOverride", "showRunAgainButton", "showBenchmarkButton", "isZip", "unzipDir", "llmPromptTemplates", "Lselfgemma/talk/data/PromptTemplate;", "llmSupportImage", "llmSupportAudio", "llmSupportTinyGarden", "llmSupportMobileActions", "llmSupportThinking", "llmMaxToken", "accelerators", "Lselfgemma/talk/data/Accelerator;", "visionAccelerator", "imported", "normalizedName", "instance", "initializing", "cleanUpAfterInit", "configValues", "", "prevConfigValues", "totalBytes", "accessToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;ZLselfgemma/talk/data/RuntimeType;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/util/List;ZZZZZILjava/util/List;Lselfgemma/talk/data/Accelerator;ZLjava/lang/String;Ljava/lang/Object;ZZLjava/util/Map;Ljava/util/Map;JLjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getDisplayName", "getInfo", "getConfigs", "()Ljava/util/List;", "setConfigs", "(Ljava/util/List;)V", "getLearnMoreUrl", "getBestForTaskIds", "getMinDeviceMemoryInGb", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "getSizeInBytes", "()J", "getDownloadFileName", "getVersion", "getExtraDataFiles", "()Z", "getRuntimeType", "()Lselfgemma/talk/data/RuntimeType;", "getLocalFileRelativeDirPathOverride", "getLocalModelFilePathOverride", "getShowRunAgainButton", "getShowBenchmarkButton", "getUnzipDir", "getLlmPromptTemplates", "getLlmSupportImage", "getLlmSupportAudio", "getLlmSupportTinyGarden", "getLlmSupportMobileActions", "getLlmSupportThinking", "getLlmMaxToken", "()I", "getAccelerators", "getVisionAccelerator", "()Lselfgemma/talk/data/Accelerator;", "getImported", "getNormalizedName", "setNormalizedName", "(Ljava/lang/String;)V", "getInstance", "()Ljava/lang/Object;", "setInstance", "(Ljava/lang/Object;)V", "getInitializing", "setInitializing", "(Z)V", "getCleanUpAfterInit", "setCleanUpAfterInit", "getConfigValues", "()Ljava/util/Map;", "setConfigValues", "(Ljava/util/Map;)V", "getPrevConfigValues", "setPrevConfigValues", "getTotalBytes", "setTotalBytes", "(J)V", "getAccessToken", "setAccessToken", "preProcess", "", "getPath", "context", "Landroid/content/Context;", "fileName", "getIntConfigValue", "key", "Lselfgemma/talk/data/ConfigKey;", "defaultValue", "getFloatConfigValue", "", "getBooleanConfigValue", "getStringConfigValue", "getExtraDataFile", "getTypedConfigValue", "valueType", "Lselfgemma/talk/data/ValueType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;ZLselfgemma/talk/data/RuntimeType;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/util/List;ZZZZZILjava/util/List;Lselfgemma/talk/data/Accelerator;ZLjava/lang/String;Ljava/lang/Object;ZZLjava/util/Map;Ljava/util/Map;JLjava/lang/String;)Lselfgemma/talk/data/Model;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Model {
    
    /**
     * The name of the model.
     *
     * This field is used to uniquely identify this model among all the tasks.
     *
     * IMPORTANT: it shouldn't contain "/" character.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    
    /**
     * The display name of the model, for display purpose.
     *
     * If this field is not set, the `name` field above will be used as the default display name.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String displayName = null;
    
    /**
     * (optional)
     *
     * A description or information about the model (Markdown supported).
     *
     * Displayed in the expanded model info card.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String info = null;
    
    /**
     * (optional)
     *
     * A list of configurable parameters for the model.
     *
     * If set, a gear icon appears on the right side of the model main screen's app bar. When
     * selected, a dialog pops up, allowing users to update the model's configurations.
     *
     * See [Config] for more details
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.List<? extends selfgemma.talk.data.Config> configs;
    
    /**
     * (optional)
     *
     * The url to jump to when clicking "learn more" in model's info card.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String learnMoreUrl = null;
    
    /**
     * (optional)
     *
     * The task type ids that this model is best for.
     *
     * When set, the model's info card is pinned to the top of the model list when the corresponding
     * task is selected, expanded by default, and displays a "best overall" banner.
     *
     * Each task should only have one such model.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> bestForTaskIds = null;
    
    /**
     * (optional)
     *
     * The minimum device memory in GB to run the model.
     *
     * If set, a warning dialog will be shown when user trying to download the model or enter the
     * model screen.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer minDeviceMemoryInGb = null;
    
    /**
     * The URL to download the model from.
     *
     * If the url is from HuggingFace, we will automatically prompt users to fetch access token if the
     * model is gated.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String url = null;
    
    /**
     * The size of the model file in bytes.
     *
     * This will be used to calculate download progress.
     */
    private final long sizeInBytes = 0L;
    
    /**
     * The name of the downloaded model file.
     *
     * It will be used to define the file path on local device to store the downloaded model.
     * {context.getExternalFilesDir}/{normalizedName}/{version}/{downloadFileName}
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String downloadFileName = null;
    
    /**
     * (optional)
     *
     * The version of the model.
     *
     * It will be used to define the file path on local device to store the downloaded model.
     * {context.getExternalFilesDir}/{normalizedName}/{version}/{downloadFileName}
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String version = null;
    
    /**
     * (optional, experimental)
     *
     * A list of additional data files required by the model.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.data.ModelDataFile> extraDataFiles = null;
    
    /**
     * Whether the model is LLM or not.
     */
    private final boolean isLlm = false;
    
    /**
     * The type of local runtime environment to use for running the model.
     */
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.RuntimeType runtimeType = null;
    
    /**
     * Set this to a relative path pointing to a dir (e.g., my_model/local_dir/) if you want to
     * manually manage model files instead of downloading them. This dir is relative to the app's
     * "External Files Directory", which is: /storage/emulated/0/Android/data/<app_id>/files/.
     *
     * The <app_id> depends on how the app was built.
     * For the current SelfGemma Talk package, it is `selfgemma.talk`.
     *
     * For example, if this field is set to "my_model/local_dir/", then the location you should push
     * files to is (assuming non-github builds):
     *
     * /storage/emulated/0/Android/data/selfgemma.talk/files/my_model/local_dir/
     *
     * You can get the full path to a specific file within your code using `Model.getPath(Context,
     * fileNameToGet)`.
     *
     * Using this field is recommended when:
     * - Your model files are not publicly accessible on the internet (e.g. private models).
     * - Your "model" or experience requires multiple files. Manually pushing these files to the
     *  device and using Model.getPath() for each one is often simpler than downloading them,
     *  especially for demos.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String localFileRelativeDirPathOverride = null;
    
    /**
     * When set, the app will try to use this path to find the model file.
     *
     * For testing purpose only.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String localModelFilePathOverride = null;
    
    /**
     * Whether to show the "run again" button in the UI.
     */
    private final boolean showRunAgainButton = false;
    
    /**
     * Whether to show the "benchmark" button in the UI.
     */
    private final boolean showBenchmarkButton = false;
    
    /**
     * Indicates whether the model is a zip file.
     */
    private final boolean isZip = false;
    
    /**
     * The name of the directory to unzip the model to (if it's a zip file).
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String unzipDir = null;
    
    /**
     * The prompt templates for the model (only for LLM).
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.data.PromptTemplate> llmPromptTemplates = null;
    
    /**
     * Whether the LLM model supports image input.
     */
    private final boolean llmSupportImage = false;
    
    /**
     * Whether the LLM model supports audio input.
     */
    private final boolean llmSupportAudio = false;
    
    /**
     * Whether the LLM model supports tiny garden.
     */
    private final boolean llmSupportTinyGarden = false;
    
    /**
     * Whether the LLM model supports mobile actions.
     */
    private final boolean llmSupportMobileActions = false;
    
    /**
     * Whether the LLM model supports thinking mode.
     */
    private final boolean llmSupportThinking = false;
    
    /**
     * The max token for llm model.
     */
    private final int llmMaxToken = 0;
    
    /**
     * Compatible accelerators.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<selfgemma.talk.data.Accelerator> accelerators = null;
    
    /**
     * Accelerator for running vision encoder.
     */
    @org.jetbrains.annotations.NotNull()
    private final selfgemma.talk.data.Accelerator visionAccelerator = null;
    
    /**
     * Whether the model is imported or not.
     */
    private final boolean imported = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String normalizedName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object instance;
    private boolean initializing;
    private boolean cleanUpAfterInit;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.String, ? extends java.lang.Object> configValues;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.String, ? extends java.lang.Object> prevConfigValues;
    private long totalBytes;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String accessToken;
    
    public Model(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String displayName, @org.jetbrains.annotations.NotNull()
    java.lang.String info, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends selfgemma.talk.data.Config> configs, @org.jetbrains.annotations.NotNull()
    java.lang.String learnMoreUrl, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> bestForTaskIds, @org.jetbrains.annotations.Nullable()
    java.lang.Integer minDeviceMemoryInGb, @org.jetbrains.annotations.NotNull()
    java.lang.String url, long sizeInBytes, @org.jetbrains.annotations.NotNull()
    java.lang.String downloadFileName, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.ModelDataFile> extraDataFiles, boolean isLlm, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.RuntimeType runtimeType, @org.jetbrains.annotations.NotNull()
    java.lang.String localFileRelativeDirPathOverride, @org.jetbrains.annotations.NotNull()
    java.lang.String localModelFilePathOverride, boolean showRunAgainButton, boolean showBenchmarkButton, boolean isZip, @org.jetbrains.annotations.NotNull()
    java.lang.String unzipDir, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.PromptTemplate> llmPromptTemplates, boolean llmSupportImage, boolean llmSupportAudio, boolean llmSupportTinyGarden, boolean llmSupportMobileActions, boolean llmSupportThinking, int llmMaxToken, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends selfgemma.talk.data.Accelerator> accelerators, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Accelerator visionAccelerator, boolean imported, @org.jetbrains.annotations.NotNull()
    java.lang.String normalizedName, @org.jetbrains.annotations.Nullable()
    java.lang.Object instance, boolean initializing, boolean cleanUpAfterInit, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> configValues, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> prevConfigValues, long totalBytes, @org.jetbrains.annotations.Nullable()
    java.lang.String accessToken) {
        super();
    }
    
    /**
     * The name of the model.
     *
     * This field is used to uniquely identify this model among all the tasks.
     *
     * IMPORTANT: it shouldn't contain "/" character.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    /**
     * The display name of the model, for display purpose.
     *
     * If this field is not set, the `name` field above will be used as the default display name.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    /**
     * (optional)
     *
     * A description or information about the model (Markdown supported).
     *
     * Displayed in the expanded model info card.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInfo() {
        return null;
    }
    
    /**
     * (optional)
     *
     * A list of configurable parameters for the model.
     *
     * If set, a gear icon appears on the right side of the model main screen's app bar. When
     * selected, a dialog pops up, allowing users to update the model's configurations.
     *
     * See [Config] for more details
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.Config> getConfigs() {
        return null;
    }
    
    /**
     * (optional)
     *
     * A list of configurable parameters for the model.
     *
     * If set, a gear icon appears on the right side of the model main screen's app bar. When
     * selected, a dialog pops up, allowing users to update the model's configurations.
     *
     * See [Config] for more details
     */
    public final void setConfigs(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends selfgemma.talk.data.Config> p0) {
    }
    
    /**
     * (optional)
     *
     * The url to jump to when clicking "learn more" in model's info card.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLearnMoreUrl() {
        return null;
    }
    
    /**
     * (optional)
     *
     * The task type ids that this model is best for.
     *
     * When set, the model's info card is pinned to the top of the model list when the corresponding
     * task is selected, expanded by default, and displays a "best overall" banner.
     *
     * Each task should only have one such model.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getBestForTaskIds() {
        return null;
    }
    
    /**
     * (optional)
     *
     * The minimum device memory in GB to run the model.
     *
     * If set, a warning dialog will be shown when user trying to download the model or enter the
     * model screen.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMinDeviceMemoryInGb() {
        return null;
    }
    
    /**
     * The URL to download the model from.
     *
     * If the url is from HuggingFace, we will automatically prompt users to fetch access token if the
     * model is gated.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    /**
     * The size of the model file in bytes.
     *
     * This will be used to calculate download progress.
     */
    public final long getSizeInBytes() {
        return 0L;
    }
    
    /**
     * The name of the downloaded model file.
     *
     * It will be used to define the file path on local device to store the downloaded model.
     * {context.getExternalFilesDir}/{normalizedName}/{version}/{downloadFileName}
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDownloadFileName() {
        return null;
    }
    
    /**
     * (optional)
     *
     * The version of the model.
     *
     * It will be used to define the file path on local device to store the downloaded model.
     * {context.getExternalFilesDir}/{normalizedName}/{version}/{downloadFileName}
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVersion() {
        return null;
    }
    
    /**
     * (optional, experimental)
     *
     * A list of additional data files required by the model.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.ModelDataFile> getExtraDataFiles() {
        return null;
    }
    
    /**
     * Whether the model is LLM or not.
     */
    public final boolean isLlm() {
        return false;
    }
    
    /**
     * The type of local runtime environment to use for running the model.
     */
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.RuntimeType getRuntimeType() {
        return null;
    }
    
    /**
     * Set this to a relative path pointing to a dir (e.g., my_model/local_dir/) if you want to
     * manually manage model files instead of downloading them. This dir is relative to the app's
     * "External Files Directory", which is: /storage/emulated/0/Android/data/<app_id>/files/.
     *
     * The <app_id> depends on how the app was built.
     * For the current SelfGemma Talk package, it is `selfgemma.talk`.
     *
     * For example, if this field is set to "my_model/local_dir/", then the location you should push
     * files to is (assuming non-github builds):
     *
     * /storage/emulated/0/Android/data/selfgemma.talk/files/my_model/local_dir/
     *
     * You can get the full path to a specific file within your code using `Model.getPath(Context,
     * fileNameToGet)`.
     *
     * Using this field is recommended when:
     * - Your model files are not publicly accessible on the internet (e.g. private models).
     * - Your "model" or experience requires multiple files. Manually pushing these files to the
     *  device and using Model.getPath() for each one is often simpler than downloading them,
     *  especially for demos.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocalFileRelativeDirPathOverride() {
        return null;
    }
    
    /**
     * When set, the app will try to use this path to find the model file.
     *
     * For testing purpose only.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocalModelFilePathOverride() {
        return null;
    }
    
    /**
     * Whether to show the "run again" button in the UI.
     */
    public final boolean getShowRunAgainButton() {
        return false;
    }
    
    /**
     * Whether to show the "benchmark" button in the UI.
     */
    public final boolean getShowBenchmarkButton() {
        return false;
    }
    
    /**
     * Indicates whether the model is a zip file.
     */
    public final boolean isZip() {
        return false;
    }
    
    /**
     * The name of the directory to unzip the model to (if it's a zip file).
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUnzipDir() {
        return null;
    }
    
    /**
     * The prompt templates for the model (only for LLM).
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.PromptTemplate> getLlmPromptTemplates() {
        return null;
    }
    
    /**
     * Whether the LLM model supports image input.
     */
    public final boolean getLlmSupportImage() {
        return false;
    }
    
    /**
     * Whether the LLM model supports audio input.
     */
    public final boolean getLlmSupportAudio() {
        return false;
    }
    
    /**
     * Whether the LLM model supports tiny garden.
     */
    public final boolean getLlmSupportTinyGarden() {
        return false;
    }
    
    /**
     * Whether the LLM model supports mobile actions.
     */
    public final boolean getLlmSupportMobileActions() {
        return false;
    }
    
    /**
     * Whether the LLM model supports thinking mode.
     */
    public final boolean getLlmSupportThinking() {
        return false;
    }
    
    /**
     * The max token for llm model.
     */
    public final int getLlmMaxToken() {
        return 0;
    }
    
    /**
     * Compatible accelerators.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.Accelerator> getAccelerators() {
        return null;
    }
    
    /**
     * Accelerator for running vision encoder.
     */
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.Accelerator getVisionAccelerator() {
        return null;
    }
    
    /**
     * Whether the model is imported or not.
     */
    public final boolean getImported() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNormalizedName() {
        return null;
    }
    
    public final void setNormalizedName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getInstance() {
        return null;
    }
    
    public final void setInstance(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
    }
    
    public final boolean getInitializing() {
        return false;
    }
    
    public final void setInitializing(boolean p0) {
    }
    
    public final boolean getCleanUpAfterInit() {
        return false;
    }
    
    public final void setCleanUpAfterInit(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> getConfigValues() {
        return null;
    }
    
    public final void setConfigValues(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> getPrevConfigValues() {
        return null;
    }
    
    public final void setPrevConfigValues(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> p0) {
    }
    
    public final long getTotalBytes() {
        return 0L;
    }
    
    public final void setTotalBytes(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAccessToken() {
        return null;
    }
    
    public final void setAccessToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final void preProcess() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
        return null;
    }
    
    public final int getIntConfigValue(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.ConfigKey key, int defaultValue) {
        return 0;
    }
    
    public final float getFloatConfigValue(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.ConfigKey key, float defaultValue) {
        return 0.0F;
    }
    
    public final boolean getBooleanConfigValue(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.ConfigKey key, boolean defaultValue) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStringConfigValue(@org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.ConfigKey key, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultValue) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final selfgemma.talk.data.ModelDataFile getExtraDataFile(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    private final java.lang.Object getTypedConfigValue(selfgemma.talk.data.ConfigKey key, selfgemma.talk.data.ValueType valueType, java.lang.Object defaultValue) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.ModelDataFile> component12() {
        return null;
    }
    
    public final boolean component13() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.RuntimeType component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    public final boolean component17() {
        return false;
    }
    
    public final boolean component18() {
        return false;
    }
    
    public final boolean component19() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.PromptTemplate> component21() {
        return null;
    }
    
    public final boolean component22() {
        return false;
    }
    
    public final boolean component23() {
        return false;
    }
    
    public final boolean component24() {
        return false;
    }
    
    public final boolean component25() {
        return false;
    }
    
    public final boolean component26() {
        return false;
    }
    
    public final int component27() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.Accelerator> component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.Accelerator component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component30() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component31() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component32() {
        return null;
    }
    
    public final boolean component33() {
        return false;
    }
    
    public final boolean component34() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> component35() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> component36() {
        return null;
    }
    
    public final long component37() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component38() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<selfgemma.talk.data.Config> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final long component9() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.Model copy(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String displayName, @org.jetbrains.annotations.NotNull()
    java.lang.String info, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends selfgemma.talk.data.Config> configs, @org.jetbrains.annotations.NotNull()
    java.lang.String learnMoreUrl, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> bestForTaskIds, @org.jetbrains.annotations.Nullable()
    java.lang.Integer minDeviceMemoryInGb, @org.jetbrains.annotations.NotNull()
    java.lang.String url, long sizeInBytes, @org.jetbrains.annotations.NotNull()
    java.lang.String downloadFileName, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.ModelDataFile> extraDataFiles, boolean isLlm, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.RuntimeType runtimeType, @org.jetbrains.annotations.NotNull()
    java.lang.String localFileRelativeDirPathOverride, @org.jetbrains.annotations.NotNull()
    java.lang.String localModelFilePathOverride, boolean showRunAgainButton, boolean showBenchmarkButton, boolean isZip, @org.jetbrains.annotations.NotNull()
    java.lang.String unzipDir, @org.jetbrains.annotations.NotNull()
    java.util.List<selfgemma.talk.data.PromptTemplate> llmPromptTemplates, boolean llmSupportImage, boolean llmSupportAudio, boolean llmSupportTinyGarden, boolean llmSupportMobileActions, boolean llmSupportThinking, int llmMaxToken, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends selfgemma.talk.data.Accelerator> accelerators, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.data.Accelerator visionAccelerator, boolean imported, @org.jetbrains.annotations.NotNull()
    java.lang.String normalizedName, @org.jetbrains.annotations.Nullable()
    java.lang.Object instance, boolean initializing, boolean cleanUpAfterInit, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> configValues, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> prevConfigValues, long totalBytes, @org.jetbrains.annotations.Nullable()
    java.lang.String accessToken) {
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