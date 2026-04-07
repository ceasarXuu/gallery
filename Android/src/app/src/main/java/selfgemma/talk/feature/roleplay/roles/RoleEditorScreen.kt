package selfgemma.talk.feature.roleplay.roles

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import selfgemma.talk.AppTopBar
import selfgemma.talk.data.AppBarAction
import selfgemma.talk.data.AppBarActionType
import selfgemma.talk.ui.modelmanager.ModelManagerViewModel
import selfgemma.talk.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleEditorScreen(
  modelManagerViewModel: ModelManagerViewModel,
  navigateUp: () -> Unit,
  modifier: Modifier = Modifier,
  viewModel: RoleEditorViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsState()
  val downloadedModels = modelManagerViewModel.getAllDownloadedModels()
  var modelMenuExpanded by remember { mutableStateOf(false) }
  val importLauncher =
    rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri: Uri? ->
      uri?.let { viewModel.importStCardFromUri(it.toString()) }
    }
  val exportJsonLauncher =
    rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument("application/json")) { uri: Uri? ->
      uri?.let { viewModel.exportStCardToUri(it.toString()) }
    }
  val exportPngLauncher =
    rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument("image/png")) { uri: Uri? ->
      uri?.let { viewModel.exportStCardToUri(it.toString()) }
    }

  Scaffold(
    modifier = modifier.semantics { testTagsAsResourceId = true },
    topBar = {
      AppTopBar(
        title = if (uiState.isNewRole) stringResource(R.string.role_editor_create_title) else stringResource(R.string.role_editor_edit_title),
        leftAction = AppBarAction(actionType = AppBarActionType.NAVIGATE_UP, actionFn = navigateUp),
      )
    },
  ) { innerPadding ->
    if (uiState.loading) {
      Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding).padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Text(stringResource(R.string.role_editor_loading), style = MaterialTheme.typography.headlineSmall)
      }
      return@Scaffold
    }

    LazyColumn(
      modifier = Modifier.fillMaxSize().padding(innerPadding),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      item {
        TextField(
          modifier = Modifier.fillMaxWidth().testTag("role_editor_name"),
          value = uiState.name,
          onValueChange = viewModel::updateName,
          label = { Text(stringResource(R.string.role_editor_name_label)) },
          placeholder = { Text(stringResource(R.string.role_editor_name_placeholder)) },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth().testTag("role_editor_summary"),
          value = uiState.summary,
          onValueChange = viewModel::updateSummary,
          minLines = 2,
          label = { Text(stringResource(R.string.role_editor_summary_label)) },
          placeholder = { Text(stringResource(R.string.role_editor_summary_placeholder)) },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth().testTag("role_editor_system_prompt"),
          value = uiState.systemPrompt,
          onValueChange = viewModel::updateSystemPrompt,
          minLines = 5,
          label = { Text(stringResource(R.string.role_editor_system_prompt_label)) },
          placeholder = { Text(stringResource(R.string.role_editor_system_prompt_placeholder)) },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth().testTag("role_editor_persona"),
          value = uiState.personaDescription,
          onValueChange = viewModel::updatePersonaDescription,
          minLines = 3,
          label = { Text(stringResource(R.string.role_editor_persona_label)) },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth().testTag("role_editor_world_settings"),
          value = uiState.worldSettings,
          onValueChange = viewModel::updateWorldSettings,
          minLines = 3,
          label = { Text(stringResource(R.string.role_editor_world_settings_label)) },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth().testTag("role_editor_opening_line"),
          value = uiState.openingLine,
          onValueChange = viewModel::updateOpeningLine,
          minLines = 2,
          label = { Text(stringResource(R.string.role_editor_opening_line_label)) },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth().testTag("role_editor_safety_policy"),
          value = uiState.safetyPolicy,
          onValueChange = viewModel::updateSafetyPolicy,
          minLines = 2,
          label = { Text(stringResource(R.string.role_editor_safety_policy_label)) },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth().testTag("role_editor_tags"),
          value = uiState.tagsText,
          onValueChange = viewModel::updateTagsText,
          label = { Text(stringResource(R.string.role_editor_tags_label)) },
          placeholder = { Text(stringResource(R.string.role_editor_tags_placeholder)) },
        )
      }
      item {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
          Text(stringResource(R.string.role_editor_default_model_label), style = MaterialTheme.typography.labelLarge)
          Box {
            OutlinedButton(onClick = { modelMenuExpanded = true }) {
              Text(uiState.defaultModelId ?: stringResource(R.string.role_editor_no_default_model))
            }
            DropdownMenu(
              expanded = modelMenuExpanded,
              onDismissRequest = { modelMenuExpanded = false },
            ) {
              DropdownMenuItem(
                text = { Text(stringResource(R.string.role_editor_no_default_model)) },
                onClick = {
                  modelMenuExpanded = false
                  viewModel.updateDefaultModelId(null)
                },
              )
              downloadedModels.forEach { model ->DropdownMenuItem(
                  text = { Text(model.displayName.ifEmpty { model.name }) },
                  onClick = {
                    modelMenuExpanded = false
                    viewModel.updateDefaultModelId(model.name)
                  },
                )
              }
            }
          }
        }
      }
      item {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
          OutlinedButton(
            onClick = { importLauncher.launch(arrayOf("application/json", "image/png")) },
            modifier = Modifier.fillMaxWidth().testTag("role_editor_import_st_json"),
          ) {
            Text("Import ST Role Card")
          }
          OutlinedButton(
            onClick = {
              val fileName = uiState.name.ifBlank { "role-card" }.replace(Regex("[^a-zA-Z0-9._-]"), "_")
              exportJsonLauncher.launch("${fileName}.json")
            },
            modifier = Modifier.fillMaxWidth().testTag("role_editor_export_st_json"),
          ) {
            Text("Export ST Role Card JSON")
          }
          OutlinedButton(
            onClick = {
              val fileName = uiState.name.ifBlank { "role-card" }.replace(Regex("[^a-zA-Z0-9._-]"), "_")
              exportPngLauncher.launch("${fileName}.png")
            },
            modifier = Modifier.fillMaxWidth().testTag("role_editor_export_st_png"),
          ) {
            Text("Export ST Role Card PNG")
          }
        }
      }
      uiState.statusMessage?.let { statusMessage ->
        item {
          Text(
            statusMessage,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
          )
        }
      }
      uiState.errorMessage?.let { errorMessage ->
        item {
          Text(
            errorMessage,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error,
          )
        }
      }
      item {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
          FilledTonalButton(
            onClick = { viewModel.saveRole { navigateUp() } },
            modifier = Modifier.fillMaxWidth().testTag("role_editor_save"),
          ) {
            Text(if (uiState.isNewRole) stringResource(R.string.role_editor_create_button) else stringResource(R.string.role_editor_save_button))
          }
          if (!uiState.isNewRole && !uiState.builtIn) {
            OutlinedButton(
              onClick = { viewModel.deleteRole { navigateUp() } },
              modifier = Modifier.fillMaxWidth(),
            ) {
              Text(stringResource(R.string.role_editor_delete_button))
            }
          }
        }
      }
    }
  }
}
