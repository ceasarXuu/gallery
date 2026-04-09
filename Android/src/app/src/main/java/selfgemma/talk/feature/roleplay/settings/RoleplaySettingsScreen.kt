package selfgemma.talk.feature.roleplay.settings

import androidx.appcompat.app.AppCompatDelegate
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.core.os.LocaleListCompat
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import selfgemma.talk.AppTopBar
import selfgemma.talk.data.AppBarAction
import selfgemma.talk.data.AppBarActionType
import selfgemma.talk.R
import selfgemma.talk.data.Model
import selfgemma.talk.ui.modelmanager.ModelManagerViewModel

private const val TAG = "RoleplaySettingsScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleplaySettingsScreen(
  modelManagerViewModel: ModelManagerViewModel,
  navigateUp: () -> Unit,
  onOpenModelLibrary: () -> Unit,
  showNavigateUp: Boolean = false,
  modifier: Modifier = Modifier,
  contentPadding: PaddingValues = PaddingValues(0.dp),
  viewModel: RoleplaySettingsViewModel = hiltViewModel(),
) {
  var showLanguageDialog by remember { mutableStateOf(false) }
  var showAssistantModelDialog by remember { mutableStateOf(false) }
  val currentLocaleTag = AppCompatDelegate.getApplicationLocales().toLanguageTags().substringBefore(',')
  val uiState by viewModel.uiState.collectAsState()
  val downloadedModels = modelManagerViewModel.getAllDownloadedModels()
  val resolvedAssistantModel =
    downloadedModels.firstOrNull { it.name == uiState.roleEditorAssistantModelId }
      ?: downloadedModels.firstOrNull()
  val handleNavigateUp: () -> Unit = {
    if (showLanguageDialog) {
      showLanguageDialog = false
      Log.d(TAG, "dismiss language dialog before navigating up")
    } else if (showAssistantModelDialog) {
      showAssistantModelDialog = false
      Log.d(TAG, "dismiss assistant model dialog before navigating up")
    } else {
      Log.d(TAG, "navigate up from settings")
      navigateUp()
    }
  }

  BackHandler(enabled = showNavigateUp || showLanguageDialog || showAssistantModelDialog) { handleNavigateUp() }

  Scaffold(
    modifier = modifier,
    contentWindowInsets = androidx.compose.foundation.layout.WindowInsets(0, 0, 0, 0),
    topBar = {
      AppTopBar(
        title = stringResource(R.string.tab_settings),
        leftAction =
          if (showNavigateUp) {
            AppBarAction(actionType = AppBarActionType.NAVIGATE_UP, actionFn = handleNavigateUp)
          } else {
            null
          },
      )
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
      ToggleSettingsCard(
        title = stringResource(R.string.settings_message_sounds_title),
        summary = stringResource(R.string.settings_message_sounds_summary),
        checked = uiState.messageSoundsEnabled,
        onCheckedChange = viewModel::setMessageSoundsEnabled,
      )
      SettingsCard(
        title = stringResource(R.string.settings_model_library_title),
        summary = stringResource(R.string.settings_model_library_summary),
        onClick = onOpenModelLibrary,
      )
      SettingsCard(
        title = stringResource(R.string.settings_role_editor_assistant_model_title),
        summary =
          resolvedAssistantModel?.displayName?.ifEmpty { resolvedAssistantModel.name }
            ?: stringResource(R.string.settings_role_editor_assistant_model_none),
        onClick = { showAssistantModelDialog = true },
      )
    }
  }

  if (showLanguageDialog) {
    LanguageSelectionDialog(
      currentLocaleTag = currentLocaleTag,
      onDismiss = { showLanguageDialog = false },
      onLanguageSelected = { localeTag ->
        val localeList = if (localeTag.isBlank()) {
          LocaleListCompat.getEmptyLocaleList()
        } else {
          LocaleListCompat.forLanguageTags(localeTag)
        }
        AppCompatDelegate.setApplicationLocales(localeList)
        showLanguageDialog = false
      },
    )
  }

  if (showAssistantModelDialog) {
    AssistantModelSelectionDialog(
      downloadedModels = downloadedModels,
      currentModelId = resolvedAssistantModel?.name,
      onDismiss = { showAssistantModelDialog = false },
      onOpenModelLibrary = {
        showAssistantModelDialog = false
        onOpenModelLibrary()
      },
      onModelSelected = { modelId ->
        viewModel.setRoleEditorAssistantModelId(modelId)
        showAssistantModelDialog = false
      },
      onResetToDefault = {
        viewModel.setRoleEditorAssistantModelId(null)
        showAssistantModelDialog = false
      },
    )
  }
}

@Composable
private fun AssistantModelSelectionDialog(
  downloadedModels: List<Model>,
  currentModelId: String?,
  onDismiss: () -> Unit,
  onOpenModelLibrary: () -> Unit,
  onModelSelected: (String) -> Unit,
  onResetToDefault: () -> Unit,
) {
  AlertDialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false),
    title = { Text(stringResource(R.string.settings_role_editor_assistant_model_title)) },
    text = {
      if (downloadedModels.isEmpty()) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
          Text(stringResource(R.string.settings_role_editor_assistant_model_empty))
          TextButton(onClick = onOpenModelLibrary) {
            Text(stringResource(R.string.settings_model_library_title))
          }
        }
      } else {
        Column(
          modifier = Modifier.verticalScroll(rememberScrollState()).selectableGroup(),
          verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
          downloadedModels.forEach { model ->
            val modelLabel = model.displayName.ifEmpty { model.name }
            Row(
              modifier =
                Modifier
                  .fillMaxWidth()
                  .selectable(
                    selected = model.name == currentModelId,
                    onClick = { onModelSelected(model.name) },
                  )
                  .padding(vertical = 12.dp),
              verticalAlignment = Alignment.CenterVertically,
            ) {
              RadioButton(
                selected = model.name == currentModelId,
                onClick = { onModelSelected(model.name) },
              )
              Column(
                modifier = Modifier.padding(start = 8.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
              ) {
                Text(modelLabel, style = MaterialTheme.typography.bodyLarge)
                if (model.name != modelLabel) {
                  Text(
                    model.name,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                  )
                }
              }
            }
          }
        }
      }
    },
    confirmButton = {
      if (downloadedModels.isNotEmpty()) {
        TextButton(onClick = onResetToDefault) {
          Text(stringResource(R.string.settings_role_editor_assistant_model_reset_default))
        }
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
private fun LanguageSelectionDialog(
  currentLocaleTag: String,
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

  var selectedLanguage by remember(currentLocaleTag) { mutableStateOf(currentLocaleTag) }

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

@Composable
private fun ToggleSettingsCard(
  title: String,
  summary: String,
  checked: Boolean,
  onCheckedChange: (Boolean) -> Unit,
) {
  Card(
    modifier = Modifier.fillMaxWidth().clickable { onCheckedChange(!checked) },
  ) {
    Row(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      horizontalArrangement = Arrangement.spacedBy(12.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.spacedBy(6.dp),
      ) {
        Text(title, style = MaterialTheme.typography.titleMedium)
        Text(
          summary,
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }
      Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
      )
    }
  }
}
