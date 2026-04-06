package selfgemma.talk.feature.roleplay.roles

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
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import selfgemma.talk.AppTopBar
import selfgemma.talk.data.AppBarAction
import selfgemma.talk.data.AppBarActionType
import selfgemma.talk.ui.modelmanager.ModelManagerViewModel

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

  Scaffold(
    modifier = modifier,
    topBar = {
      AppTopBar(
        title = if (uiState.isNewRole) "Create Role" else "Edit Role",
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
        Text("Loading role...", style = MaterialTheme.typography.headlineSmall)
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
          modifier = Modifier.fillMaxWidth(),
          value = uiState.name,
          onValueChange = viewModel::updateName,
          label = { Text("Role name") },
          placeholder = { Text("Enter a character name") },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth(),
          value = uiState.summary,
          onValueChange = viewModel::updateSummary,
          minLines = 2,
          label = { Text("Summary") },
          placeholder = { Text("Short one-line description") },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth(),
          value = uiState.systemPrompt,
          onValueChange = viewModel::updateSystemPrompt,
          minLines = 5,
          label = { Text("System prompt") },
          placeholder = { Text("Describe exactly how the role should speak and behave") },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth(),
          value = uiState.personaDescription,
          onValueChange = viewModel::updatePersonaDescription,
          minLines = 3,
          label = { Text("Persona") },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth(),
          value = uiState.worldSettings,
          onValueChange = viewModel::updateWorldSettings,
          minLines = 3,
          label = { Text("World settings") },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth(),
          value = uiState.openingLine,
          onValueChange = viewModel::updateOpeningLine,
          minLines = 2,
          label = { Text("Opening line") },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth(),
          value = uiState.safetyPolicy,
          onValueChange = viewModel::updateSafetyPolicy,
          minLines = 2,
          label = { Text("Safety policy") },
        )
      }
      item {
        TextField(
          modifier = Modifier.fillMaxWidth(),
          value = uiState.tagsText,
          onValueChange = viewModel::updateTagsText,
          label = { Text("Tags") },
          placeholder = { Text("comma, separated, tags") },
        )
      }
      item {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
          Text("Default model", style = MaterialTheme.typography.labelLarge)
          Box {
            OutlinedButton(onClick = { modelMenuExpanded = true }) {
              Text(uiState.defaultModelId ?: "No default model")
            }
            DropdownMenu(
              expanded = modelMenuExpanded,
              onDismissRequest = { modelMenuExpanded = false },
            ) {
              DropdownMenuItem(
                text = { Text("No default model") },
                onClick = {
                  modelMenuExpanded = false
                  viewModel.updateDefaultModelId(null)
                },
              )
              downloadedModels.forEach { model ->
                DropdownMenuItem(
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
            modifier = Modifier.fillMaxWidth(),
          ) {
            Text(if (uiState.isNewRole) "Create Role" else "Save Changes")
          }
          if (!uiState.isNewRole && !uiState.builtIn) {
            OutlinedButton(
              onClick = { viewModel.deleteRole { navigateUp() } },
              modifier = Modifier.fillMaxWidth(),
            ) {
              Text("Delete Role")
            }
          }
        }
      }
    }
  }
}