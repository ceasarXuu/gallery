package selfgemma.talk.feature.roleplay.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import selfgemma.talk.AppTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleplaySettingsScreen(
  navigateUp: () -> Unit,
  onOpenModelLibrary: () -> Unit,
  onOpenLegacyHome: () -> Unit,
  modifier: Modifier = Modifier,
  contentPadding: PaddingValues = PaddingValues(0.dp),
) {
  Scaffold(
    modifier = modifier,
    contentWindowInsets = androidx.compose.foundation.layout.WindowInsets(0, 0, 0, 0),
    topBar = {
      AppTopBar(title = "设置")
    },
  ) { innerPadding ->
    val combinedPadding = PaddingValues(
      top = innerPadding.calculateTopPadding() + contentPadding.calculateTopPadding(),
      bottom = contentPadding.calculateBottomPadding(),
      start = contentPadding.calculateLeftPadding(androidx.compose.ui.unit.LayoutDirection.Ltr),
      end = contentPadding.calculateRightPadding(androidx.compose.ui.unit.LayoutDirection.Ltr),
    )

    Column(
      modifier = Modifier.fillMaxSize().padding(combinedPadding).padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      SettingsCard(
        title = "模型库",
        summary = "下载、导入和管理本地模型",
        onClick = onOpenModelLibrary,
      )
      SettingsCard(
        title = "旧版主页",
        summary = "打开之前的Gallery主页作为备用入口",
        onClick = onOpenLegacyHome,
      )
    }
  }
}

@Composable
private fun SettingsCard(title: String, summary: String, onClick: () -> Unit) {
  Card(
    modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
  ) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
      Text(title, style = MaterialTheme.typography.titleMedium)
      Text(
        summary,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
    }
  }
}
