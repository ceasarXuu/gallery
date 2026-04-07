package selfgemma.talk.data.roleplay.repository

import android.content.Context
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import selfgemma.talk.domain.roleplay.repository.RoleplayInteropDocumentRepository

@Singleton
class AndroidRoleplayInteropDocumentRepository
@Inject
constructor(@ApplicationContext private val context: Context) : RoleplayInteropDocumentRepository {
  override suspend fun readText(uri: String): String =
    withContext(Dispatchers.IO) {
      val parsedUri = Uri.parse(uri)
      context.contentResolver.openInputStream(parsedUri)?.bufferedReader()?.use { it.readText() }
        ?: error("Unable to open input stream for uri=$uri")
    }

  override suspend fun writeText(uri: String, content: String) {
    withContext(Dispatchers.IO) {
      val parsedUri = Uri.parse(uri)
      context.contentResolver.openOutputStream(parsedUri, "wt")?.bufferedWriter()?.use {
        it.write(content)
      } ?: error("Unable to open output stream for uri=$uri")
    }
  }
}
