package selfgemma.talk.feature.roleplay.roles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import kotlinx.coroutines.launch
import selfgemma.talk.AppTopBar
import selfgemma.talk.data.AppBarAction
import selfgemma.talk.data.AppBarActionType
import selfgemma.talk.ui.modelmanager.ModelManagerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleCatalogScreen(
  modelManagerViewModel: ModelManagerViewModel,
  navigateUp: () -> Unit,
  onOpenChat: (String) -> Unit,
  onCreateRole: () -> Unit,
  onEditRole: (String) -> Unit,
  onOpenModelLibrary: () -> Unit,
  modifier: Modifier = Modifier,
  contentPadding: PaddingValues = PaddingValues(0.dp),
  viewModel: RoleCatalogViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsState()
  val scope = rememberCoroutineScope()
  val downloadedModels = modelManagerViewModel.getAllDownloadedModels()
  val downloadedModelIds = downloadedModels.map { it.name }.toSet()
  val defaultModelId = downloadedModels.firstOrNull()?.name
  var pendingDeleteRoleId by rememberSaveable { mutableStateOf<String?>(null) }

  Scaffold(
    modifier = modifier,
    contentWindowInsets = androidx.compose.foundation.layout.WindowInsets(0, 0, 0, 0),
    topBar = {
      AppTopBar(
        title = "角色",
        leftAction = AppBarAction(actionType = AppBarActionType.NAVIGATE_UP, actionFn = navigateUp),
      )
    },
  ) { innerPadding ->
    val combinedPadding = PaddingValues(
      top = innerPadding.calculateTopPadding() + contentPadding.calculateTopPadding(),
      bottom = contentPadding.calculateBottomPadding(),
      start = contentPadding.calculateLeftPadding(androidx.compose.ui.unit.LayoutDirection.Ltr),
      end = contentPadding.calculateRightPadding(androidx.compose.ui.unit.LayoutDirection.Ltr),
    )

    LazyColumn(
      modifier = Modifier.fillMaxSize().padding(combinedPadding),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      item {
        Card(shape = RoundedCornerShape(20.dp)) {
          Column(
            modifier =
              Modifier.fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
          ) {
            Text("Create and tune roles", style = MaterialTheme.typography.titleMedium)
            Text(
              if (downloadedModels.isEmpty()) {
                "You can create and edit role cards now. Download a local model before starting a session."
              } else {
                "Create custom roles with text fields only, then start a new session with a local model."
              },
              style = MaterialTheme.typography.bodyMedium,
              color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
              FilledTonalButton(onClick = onCreateRole) {
                Text("Create Role")
              }
              OutlinedButton(onClick = onOpenModelLibrary) {
                Text("Model Library")
              }
            }
          }
        }
      }

      if (uiState.builtInRoles.isNotEmpty()) {
        item {
          Text("Built-in Roles", style = MaterialTheme.typography.titleMedium)
        }
      }
      items(uiState.builtInRoles, key = { it.id }) { role ->
        val preferredModelId =
          when {
            role.defaultModelId != null && role.defaultModelId in downloadedModelIds -> role.defaultModelId
            else -> defaultModelId
          }
        RoleCardItem(
          role = role,
          activeModelId = preferredModelId,
          canStart = defaultModelId != null,
          onStart =
            if (defaultModelId != null) {
              {
                scope.launch {
                  val sessionId =
                    viewModel.createSession(
                      roleId = role.id,
                      modelId = checkNotNull(preferredModelId),
                    )
                  onOpenChat(sessionId)
                }
              }
            } else {
              null
            },
        )
      }
      if (uiState.customRoles.isNotEmpty()) {
        item {
          Text("Custom Roles", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(top = 12.dp))
        }
      }
      items(uiState.customRoles, key = { it.id }) { role ->
        val preferredModelId =
          when {
            role.defaultModelId != null && role.defaultModelId in downloadedModelIds -> role.defaultModelId
            else -> defaultModelId
          }
        RoleCardItem(
          role = role,
          activeModelId = preferredModelId,
          canStart = defaultModelId != null,
          onStart =
            if (defaultModelId != null) {
              {
                scope.launch {
                  val sessionId =
                    viewModel.createSession(
                      roleId = role.id,
                      modelId = checkNotNull(preferredModelId),
                    )
                  onOpenChat(sessionId)
                }
              }
            } else {
              null
            },
          onEdit = { onEditRole(role.id) },
          onDelete = { pendingDeleteRoleId = role.id },
        )
      }
    }

    val roleToDelete = uiState.customRoles.firstOrNull { it.id == pendingDeleteRoleId }
    if (roleToDelete != null) {
      AlertDialog(
        onDismissRequest = { pendingDeleteRoleId = null },
        title = { Text("Delete role") },
        text = {
          Text("Deleting ${roleToDelete.name} will also remove its sessions and saved memories.")
        },
        confirmButton = {
          FilledTonalButton(
            onClick = {
              viewModel.deleteRole(roleToDelete.id)
              pendingDeleteRoleId = null
            }
          ) {
            Text("Delete")
          }
        },
        dismissButton = {
          OutlinedButton(onClick = { pendingDeleteRoleId = null }) {
            Text("Cancel")
          }
        },
      )
    }
  }
}

@Composable
private fun RoleCardItem(
  role: selfgemma.talk.domain.roleplay.model.RoleCard,
  activeModelId: String?,
  canStart: Boolean,
  onStart: (() -> Unit)? = null,
  onEdit: (() -> Unit)? = null,
  onDelete: (() -> Unit)? = null,
) {
  Card(modifier = Modifier.fillMaxWidth()) {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
      Text(role.name, style = MaterialTheme.typography.titleMedium)
      Text(role.summary, style = MaterialTheme.typography.bodyMedium)
      Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
          role.tags.joinToString(separator = " • ").ifBlank { "roleplay" },
          style = MaterialTheme.typography.labelMedium,
          color = MaterialTheme.colorScheme.primary,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
        )
        Text(
          activeModelId ?: "No model",
          style = MaterialTheme.typography.labelSmall,
          color = MaterialTheme.colorScheme.secondary,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
        )
      }
      Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        FilledTonalButton(onClick = { onStart?.invoke() }, enabled = canStart && onStart != null) {
          Text("Start Session")
        }
        if (onEdit != null) {
          OutlinedButton(onClick = onEdit) {
            Text("Edit")
          }
        }
        if (onDelete != null) {
          OutlinedButton(onClick = onDelete) {
            Text("Delete")
          }
        }
      }
    }
  }
}