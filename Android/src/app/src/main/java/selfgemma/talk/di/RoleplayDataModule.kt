package selfgemma.talk.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import selfgemma.talk.data.roleplay.db.RoleplayDatabase
import selfgemma.talk.data.roleplay.db.dao.MemoryDao
import selfgemma.talk.data.roleplay.db.dao.MessageDao
import selfgemma.talk.data.roleplay.db.dao.RoleDao
import selfgemma.talk.data.roleplay.db.dao.SessionDao
import selfgemma.talk.data.roleplay.db.dao.SessionEventDao
import selfgemma.talk.data.roleplay.db.dao.SessionSummaryDao
import selfgemma.talk.data.roleplay.repository.RoomConversationRepository
import selfgemma.talk.data.roleplay.repository.RoomMemoryRepository
import selfgemma.talk.data.roleplay.repository.RoomRoleRepository
import selfgemma.talk.domain.roleplay.repository.ConversationRepository
import selfgemma.talk.domain.roleplay.repository.MemoryRepository
import selfgemma.talk.domain.roleplay.repository.RoleRepository

private const val ROLEPLAY_DATABASE_NAME = "selfgemma_talk.db"

@Module
@InstallIn(SingletonComponent::class)
object RoleplayDatabaseModule {
  @Provides
  @Singleton
  fun provideRoleplayDatabase(@ApplicationContext context: Context): RoleplayDatabase {
    return Room.databaseBuilder(context, RoleplayDatabase::class.java, ROLEPLAY_DATABASE_NAME)
      .fallbackToDestructiveMigration(true)
      .build()
  }

  @Provides
  fun provideRoleDao(database: RoleplayDatabase): RoleDao {
    return database.roleDao()
  }

  @Provides
  fun provideSessionDao(database: RoleplayDatabase): SessionDao {
    return database.sessionDao()
  }

  @Provides
  fun provideMessageDao(database: RoleplayDatabase): MessageDao {
    return database.messageDao()
  }

  @Provides
  fun provideSessionSummaryDao(database: RoleplayDatabase): SessionSummaryDao {
    return database.sessionSummaryDao()
  }

  @Provides
  fun provideMemoryDao(database: RoleplayDatabase): MemoryDao {
    return database.memoryDao()
  }

  @Provides
  fun provideSessionEventDao(database: RoleplayDatabase): SessionEventDao {
    return database.sessionEventDao()
  }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RoleplayRepositoryModule {
  @Binds
  @Singleton
  abstract fun bindConversationRepository(
    implementation: RoomConversationRepository
  ): ConversationRepository

  @Binds
  @Singleton
  abstract fun bindRoleRepository(implementation: RoomRoleRepository): RoleRepository

  @Binds
  @Singleton
  abstract fun bindMemoryRepository(implementation: RoomMemoryRepository): MemoryRepository
}