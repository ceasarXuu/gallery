package selfgemma.talk.feature.roleplay.roles

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import selfgemma.talk.AppTopBar
import selfgemma.talk.R
import selfgemma.talk.data.AppBarAction
import selfgemma.talk.data.AppBarActionType
import kotlinx.coroutines.launch
import selfgemma.talk.performance.TrackPerformanceState
import selfgemma.talk.ui.modelmanager.ModelManagerViewModel
import selfgemma.talk.domain.roleplay.model.primaryAvatarUri
import selfgemma.talk.feature.roleplay.common.RoleAvatar
import selfgemma.talk.ui.common.TopBarOverflowMenuButton

private const val TAG = "RoleCatalogScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleCatalogScreen(
  modelManagerViewModel: ModelManagerViewModel,
  navigateUp: () -> Unit,
  onOpenChat: (String) -> Unit,
  onCreateRole: () -> Unit,
  onEditRole: (String) -> Unit,
  showNavigateUp: Boolean = false,
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
  val listState = rememberLazyListState()
  var showMenu by rememberSaveable { mutableStateOf(false) }

  val importLauncher =
    rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
      uri?.let { viewModel.importStRoleCard(it.toString()) }
    }

  TrackPerformanceState(
    key = "RoleCatalogList",
    value = if (listState.isScrollInProgress) "scrolling" else null,
  )

  val handleNavigateUp: () -> Unit = {
    if (pendingDeleteRoleId != null) {
      pendingDeleteRoleId = null
      Log.d(TAG, "dismiss delete dialog before navigating up")
    } else {
      Log.d(TAG, "navigate up from role catalog")
      navigateUp()
    }
  }

  BackHandler(enabled = showNavigateUp) {
    handleNavigateUp()
  }

  Scaffold(
    modifier = modifier.semantics { testTagsAsResourceId = true },
    contentWindowInsets = androidx.compose.foundation.layout.WindowInsets(0, 0, 0, 0),
    topBar = {
      AppTopBar(
        title = stringResource(R.string.tab_roles),
        leftAction =
          if (showNavigateUp) {
            AppBarAction(actionType = AppBarActionType.NAVIGATE_UP, actionFn = handleNavigateUp)
          } else {
            null
          },
        rightActionContent = {
          TopBarOverflowMenuButton(
            expanded = showMenu,
            onExpandedChange = { showMenu = it },
          ) {
            DropdownMenuItem(
              text = { Text(stringResource(R.string.roles_menu_create)) },
              onClick = {
                showMenu = false
                onCreateRole()
              },
            )
            DropdownMenuItem(
              text = { Text(stringResource(R.string.roles_menu_import)) },
              onClick = {
                showMenu = false
                importLauncher.launch("*/*")
              },
            )
          }
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

    LazyColumn(
      state = listState,
      modifier = Modifier.fillMaxSize().padding(combinedPadding),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      uiState.errorMessage?.let { errorMessage ->
        item {
          Text(
            errorMessage,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error,
          )
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

      if (uiState.builtInRoles.isNotEmpty()) {
        item {
          Text(stringResource(R.string.roles_builtin_title), style = MaterialTheme.typography.titleMedium)
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
          Text(stringResource(R.string.roles_custom_title), style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(top = 12.dp))
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
        title = { Text(stringResource(R.string.roles_delete_title)) },
        text = {
          Text(stringResource(R.string.roles_delete_content, roleToDelete.name))
        },
        confirmButton = {
          FilledTonalButton(
            onClick = {
              viewModel.deleteRole(roleToDelete.id)
              pendingDeleteRoleId = null
            }
          ) {
            Text(stringResource(R.string.delete))
          }
        },
        dismissButton = {
          OutlinedButton(onClick = { pendingDeleteRoleId = null }) {
            Text(stringResource(R.string.cancel))
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
      Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
        RoleAvatar(
          name = role.name,
          avatarUri = role.primaryAvatarUri(),
          modifier = Modifier.size(52.dp),
        )
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
          Text(role.name, style = MaterialTheme.typography.titleMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)
          if (role.primaryAvatarUri().isNullOrBlank()) {
            Text(
              text = stringResource(R.string.role_catalog_no_avatar),
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
          }
        }
      }
      Text(
        role.summary,
        style = MaterialTheme.typography.bodyMedium,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
      )
      Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
          role.tags.joinToString(separator = " • ").ifBlank { stringResource(R.string.roles_default_tag) },
          style = MaterialTheme.typography.labelMedium,
          color = MaterialTheme.colorScheme.primary,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
        )
        Text(
          activeModelId ?: stringResource(R.string.roles_no_model),
          style = MaterialTheme.typography.labelSmall,
          color = MaterialTheme.colorScheme.secondary,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
        )
      }
      Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        FilledTonalButton(onClick = { onStart?.invoke() }, enabled = canStart && onStart != null) {
          Text(stringResource(R.string.roles_start_session))
        }
        if (onEdit != null) {
          OutlinedButton(onClick = onEdit) {
            Text(stringResource(R.string.edit))
          }
        }
        if (onDelete != null) {
          OutlinedButton(onClick = onDelete) {
            Text(stringResource(R.string.delete))
          }
        }
      }
    }
  }
}
