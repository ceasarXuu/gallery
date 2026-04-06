package selfgemma.talk.feature.roleplay.settings

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.core.os.LocaleListCompat
import selfgemma.talk.AppTopBar
import selfgemma.talk.R
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleplaySettingsScreen(
  navigateUp: () -> Unit,
  onOpenModelLibrary: () -> Unit,
  onOpenLegacyHome: () -> Unit,
  modifier: Modifier = Modifier,
  contentPadding: PaddingValues = PaddingValues(0.dp),
) {
  var showLanguageDialog by remember { mutableStateOf(false) }
  val context = LocalContext.current
  
  val currentLocale = remember {
    val locales = AppCompatDelegate.getApplicationLocales()
    if (locales.isEmpty) {
      Locale.getDefault().language
    } else {
      locales.get(0)?.language ?: ""
    }
  }

  Scaffold(
    modifier = modifier,
    contentWindowInsets = androidx.compose.foundation.layout.WindowInsets(0, 0, 0, 0),
    topBar = {
      AppTopBar(title = stringResource(R.string.tab_settings))
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
        title = stringResource(R.string.settings_language),
        summary = stringResource(R.string.settings_language_summary),
        onClick = { showLanguageDialog = true },
      )
      SettingsCard(
        title = stringResource(R.string.settings_model_library_title),
        summary = stringResource(R.string.settings_model_library_summary),
        onClick = onOpenModelLibrary,
      )
      SettingsCard(
        title = stringResource(R.string.settings_legacy_home_title),
        summary = stringResource(R.string.settings_legacy_home_summary),
        onClick = onOpenLegacyHome,
      )
    }
  }

  if (showLanguageDialog) {
    LanguageSelectionDialog(
      currentLocale = currentLocale,
      onDismiss = { showLanguageDialog = false },
      onLanguageSelected = { localeTag ->
        val localeList = if (localeTag.isEmpty()) {
          LocaleListCompat.getEmptyLocaleList()
        } else {
          LocaleListCompat.forLanguageTags(localeTag)
        }
        AppCompatDelegate.setApplicationLocales(localeList)
        showLanguageDialog = false
      },
    )
  }
}

@Composable
private fun LanguageSelectionDialog(
  currentLocale: String,
  onDismiss: () -> Unit,
  onLanguageSelected: (String) -> Unit,
) {
  val languageOptions = listOf(
    "" to stringResource(R.string.language_system),
    "en" to stringResource(R.string.language_english),
    "zh-CN" to stringResource(R.string.language_chinese),
    "ja" to stringResource(R.string.language_japanese),
    "ko" to stringResource(R.string.language_korean),
  )
  
  var selectedLanguage by remember { mutableStateOf(currentLocale) }

  AlertDialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false),
    title = { Text(stringResource(R.string.settings_language)) },
    text = {
      Column(modifier = Modifier.selectableGroup()) {
        languageOptions.forEach { (localeTag, displayName) ->
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .selectable(
                selected = (localeTag == selectedLanguage),
                onClick = { selectedLanguage = localeTag },
              )
              .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
          ) {
            RadioButton(
              selected = (localeTag == selectedLanguage),
              onClick = { selectedLanguage = localeTag },
            )
            Text(
              text = displayName,
              style = MaterialTheme.typography.bodyLarge,
              modifier = Modifier.padding(start = 8.dp),
            )
          }
        }
      }
    },
    confirmButton = {
      TextButton(onClick = { onLanguageSelected(selectedLanguage) }) {
        Text(stringResource(R.string.ok))
      }
    },
    dismissButton = {
      TextButton(onClick = onDismiss) {
        Text(stringResource(R.string.cancel))
      }
    },
  )
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
