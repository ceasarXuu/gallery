package selfgemma.talk.di;

@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c1\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0007J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0007J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0007J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0007J&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0007J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0007J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0007J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0007JN\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0007J\u001a\u0010%\u001a\u00020&2\b\b\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\'\u001a\u00020\u001dH\u0007\u00a8\u0006("}, d2 = {"Lselfgemma/talk/di/AppModule;", "", "<init>", "()V", "provideSettingsSerializer", "Landroidx/datastore/core/Serializer;", "Lselfgemma/talk/proto/Settings;", "provideCutoutSerializer", "Lselfgemma/talk/proto/CutoutCollection;", "provideUserDataSerializer", "Lselfgemma/talk/proto/UserData;", "provideBenchmarkResultsSerializer", "Lselfgemma/talk/proto/BenchmarkResults;", "provideSkillsSerializer", "Lselfgemma/talk/proto/Skills;", "provideSettingsDataStore", "Landroidx/datastore/core/DataStore;", "context", "Landroid/content/Context;", "settingsSerializer", "provideCutoutsDataStore", "cutoutsSerializer", "provideUserDataDataStore", "userDataSerializer", "provideBenchmarkResultsDataStore", "benchmarkResultsSerializer", "provideSkillsDataStore", "skillsSerializer", "provideAppLifecycleProvider", "Lselfgemma/talk/AppLifecycleProvider;", "provideDataStoreRepository", "Lselfgemma/talk/data/DataStoreRepository;", "dataStore", "userDataDataStore", "cutoutsDataStore", "benchmarkResultsStore", "skillsDataStore", "provideDownloadRepository", "Lselfgemma/talk/data/DownloadRepository;", "lifecycleProvider", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final selfgemma.talk.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.core.Serializer<selfgemma.talk.proto.Settings> provideSettingsSerializer() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.core.Serializer<selfgemma.talk.proto.CutoutCollection> provideCutoutSerializer() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.core.Serializer<selfgemma.talk.proto.UserData> provideUserDataSerializer() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.core.Serializer<selfgemma.talk.proto.BenchmarkResults> provideBenchmarkResultsSerializer() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.core.Serializer<selfgemma.talk.proto.Skills> provideSkillsSerializer() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.core.DataStore<selfgemma.talk.proto.Settings> provideSettingsDataStore(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.Serializer<selfgemma.talk.proto.Settings> settingsSerializer) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.core.DataStore<selfgemma.talk.proto.CutoutCollection> provideCutoutsDataStore(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.Serializer<selfgemma.talk.proto.CutoutCollection> cutoutsSerializer) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.core.DataStore<selfgemma.talk.proto.UserData> provideUserDataDataStore(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.Serializer<selfgemma.talk.proto.UserData> userDataSerializer) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.core.DataStore<selfgemma.talk.proto.BenchmarkResults> provideBenchmarkResultsDataStore(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.Serializer<selfgemma.talk.proto.BenchmarkResults> benchmarkResultsSerializer) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.core.DataStore<selfgemma.talk.proto.Skills> provideSkillsDataStore(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.Serializer<selfgemma.talk.proto.Skills> skillsSerializer) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.AppLifecycleProvider provideAppLifecycleProvider() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.DataStoreRepository provideDataStoreRepository(@org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<selfgemma.talk.proto.Settings> dataStore, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<selfgemma.talk.proto.UserData> userDataDataStore, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<selfgemma.talk.proto.CutoutCollection> cutoutsDataStore, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<selfgemma.talk.proto.BenchmarkResults> benchmarkResultsStore, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<selfgemma.talk.proto.Skills> skillsDataStore) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final selfgemma.talk.data.DownloadRepository provideDownloadRepository(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    selfgemma.talk.AppLifecycleProvider lifecycleProvider) {
        return null;
    }
}