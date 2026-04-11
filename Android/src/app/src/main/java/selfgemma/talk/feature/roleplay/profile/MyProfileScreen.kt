package selfgemma.talk.feature.roleplay.profile

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import selfgemma.talk.AppTopBar
import selfgemma.talk.R
import selfgemma.talk.data.AppBarAction
import selfgemma.talk.data.AppBarActionType
import selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition
import selfgemma.talk.feature.roleplay.common.RoleAvatar
import selfgemma.talk.ui.common.TopBarOverflowMenuButton

private const val TAG = "MyProfileScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyProfileScreen(
  navigateUp: () -> Unit,
  showNavigateUp: Boolean = false,
  modifier: Modifier = Modifier,
  contentPadding: PaddingValues = PaddingValues(0.dp),
  viewModel: MyProfileViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsState()
  val context = LocalContext.current
  var editingSlotId by rememberSaveable { mutableStateOf<String?>(null) }
  var showCreateDialog by rememberSaveable { mutableStateOf(false) }
  var newSlotId by rememberSaveable { mutableStateOf("") }
  var showMenu by rememberSaveable { mutableStateOf(false) }
  var pendingDeleteSlotId by rememberSaveable { mutableStateOf<String?>(null) }
  val isEditing = editingSlotId != null
  val avatarLauncher =
    rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri: Uri? ->
      if (uri != null) {
        takeReadPermission(context = context, uri = uri)
      }
      viewModel.updateAvatarUri(uri?.toString())
    }
  val handleNavigateUp: () -> Unit = {
    if (isEditing) {
      Log.d(TAG, "return from persona editor to persona list")
      editingSlotId = null
    } else {
      Log.d(TAG, "navigate up from my profile")
      navigateUp()
    }
  }

  BackHandler(enabled = showNavigateUp || isEditing) { handleNavigateUp() }

  Scaffold(
    modifier = modifier,
    contentWindowInsets = WindowInsets(0, 0, 0, 0),
    topBar = {
      AppTopBar(
        title =
          if (isEditing) {
            uiState.personaName.ifBlank { editingSlotId ?: uiState.avatarSlotId.ifBlank { stringResource(R.string.tab_me) } }
          } else {
            stringResource(R.string.tab_me)
          },
        leftAction =
          if (showNavigateUp || isEditing) {
            AppBarAction(actionType = AppBarActionType.NAVIGATE_UP, actionFn = handleNavigateUp)
          } else {
            null
          },
        rightAction =
          if (isEditing) {
            AppBarAction(
              actionType = AppBarActionType.NAVIGATE_UP,
              actionFn = {
                viewModel.saveProfile()
                Log.d(TAG, "saved persona and returned to persona list")
                editingSlotId = null
              },
              label = stringResource(R.string.save),
            )
          } else {
            null
          },
        rightActionContent =
          if (!isEditing) {
            {
              TopBarOverflowMenuButton(
                expanded = showMenu,
                onExpandedChange = { showMenu = it },
              ) {
                DropdownMenuItem(
                  text = { Text(stringResource(R.string.create)) },
                  onClick = {
                    showMenu = false
                    newSlotId = ""
                    showCreateDialog = true
                  },
                )
                DropdownMenuItem(
                  text = { Text(stringResource(R.string.reset)) },
                  onClick = {
                    showMenu = false
                    editingSlotId = null
                    viewModel.resetProfile()
                  },
                )
              }
            }
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

    if (isEditing) {
      MyProfileEditorContent(
        uiState = uiState,
        contentPadding = combinedPadding,
        onPersonaNameChange = viewModel::updatePersonaName,
        onPersonaTitleChange = viewModel::updatePersonaTitle,
        onPersonaDescriptionChange = viewModel::updatePersonaDescription,
        onAvatarPick = { avatarLauncher.launch(arrayOf("image/*")) },
        onAvatarClear = { viewModel.updateAvatarUri(null) },
        onPersonaPositionChange = viewModel::updatePersonaPosition,
        onPersonaDepthChange = viewModel::updatePersonaDepth,
        onPersonaRoleChange = viewModel::updatePersonaRole,
      )
    } else {
      MyProfileListContent(
        uiState = uiState,
        contentPadding = combinedPadding,
        onEditSlot = { slotId ->
          viewModel.selectAvatarSlot(slotId)
          editingSlotId = slotId
        },
        onDeleteSlot = { slotId -> pendingDeleteSlotId = slotId },
        onDefaultPersonaChange = viewModel::setDefaultPersona,
      )
    }

    if (showCreateDialog) {
      CreatePersonaSlotDialog(
        slotId = newSlotId,
        onSlotIdChange = { newSlotId = it },
        onDismiss = { showCreateDialog = false },
        onCreate = {
          val normalizedSlotId = newSlotId.trim()
          if (normalizedSlotId.isNotBlank()) {
            viewModel.createAvatarSlot(normalizedSlotId)
            editingSlotId = normalizedSlotId
            newSlotId = ""
            showCreateDialog = false
          }
        },
      )
    }

    val personaToDelete = uiState.personaCards.firstOrNull { it.slotId == pendingDeleteSlotId }
    if (personaToDelete != null) {
      ConfirmDeletePersonaDialog(
        personaName = personaToDelete.personaName,
        onDismiss = { pendingDeleteSlotId = null },
        onConfirm = {
          viewModel.deleteAvatarSlot(personaToDelete.slotId)
          pendingDeleteSlotId = null
        },
      )
    }
  }
}

@Composable
private fun MyProfileListContent(
  uiState: MyProfileUiState,
  contentPadding: PaddingValues,
  onEditSlot: (String) -> Unit,
  onDeleteSlot: (String) -> Unit,
  onDefaultPersonaChange: (String, Boolean) -> Unit,
) {
  LazyColumn(
    modifier = Modifier.fillMaxSize().padding(contentPadding),
    contentPadding = PaddingValues(16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
  ) {
    items(uiState.personaCards, key = { it.slotId }) { persona ->
      PersonaCardItem(
        persona = persona,
        onEdit = { onEditSlot(persona.slotId) },
        onDelete = { onDeleteSlot(persona.slotId) },
        onDefaultPersonaChange = { enabled -> onDefaultPersonaChange(persona.slotId, enabled) },
        deleteEnabled = uiState.personaCards.size > 1,
      )
    }
  }
}

@Composable
private fun PersonaCardItem(
  persona: PersonaSlotCardUiState,
  onEdit: () -> Unit,
  onDelete: () -> Unit,
  onDefaultPersonaChange: (Boolean) -> Unit,
  deleteEnabled: Boolean,
) {
  Card(
    modifier = Modifier.fillMaxWidth(),
    onClick = onEdit,
  ) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        RoleAvatar(
          name = persona.personaName,
          avatarUri = persona.avatarUri,
          modifier = Modifier.size(52.dp),
        )
        Column(
          modifier = Modifier.weight(1f),
          verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
          Text(
            text = persona.personaName,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
          )
          if (persona.personaTitle.isNotBlank()) {
            Text(
              text = persona.personaTitle,
              style = MaterialTheme.typography.bodyMedium,
              color = MaterialTheme.colorScheme.onSurfaceVariant,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis,
            )
          }
        }
      }
      if (persona.personaDescription.isNotBlank()) {
        Text(
          text = persona.personaDescription,
          style = MaterialTheme.typography.bodyMedium,
          maxLines = 3,
          overflow = TextOverflow.Ellipsis,
        )
      }
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        OutlinedButton(
          modifier = Modifier.weight(1f),
          enabled = deleteEnabled,
          onClick = onDelete,
        ) {
          Text(stringResource(R.string.delete))
        }
        DefaultPersonaAction(
          modifier = Modifier.weight(1f),
          checked = persona.isDefault,
          onCheckedChange = onDefaultPersonaChange,
        )
      }
    }
  }
}

@Composable
private fun ConfirmDeletePersonaDialog(
  personaName: String,
  onDismiss: () -> Unit,
  onConfirm: () -> Unit,
) {
  AlertDialog(
    onDismissRequest = onDismiss,
    title = { Text(stringResource(R.string.my_profile_delete_title)) },
    text = {
      Text(
        stringResource(
          R.string.my_profile_delete_content,
          personaName,
        ),
      )
    },
    confirmButton = {
      TextButton(onClick = onConfirm) {
        Text(stringResource(R.string.delete))
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
private fun MyProfileEditorContent(
  uiState: MyProfileUiState,
  contentPadding: PaddingValues,
  onPersonaNameChange: (String) -> Unit,
  onPersonaTitleChange: (String) -> Unit,
  onPersonaDescriptionChange: (String) -> Unit,
  onAvatarPick: () -> Unit,
  onAvatarClear: () -> Unit,
  onPersonaPositionChange: (StPersonaDescriptionPosition) -> Unit,
  onPersonaDepthChange: (String) -> Unit,
  onPersonaRoleChange: (Int) -> Unit,
) {
  Column(
    modifier =
      Modifier
        .fillMaxSize()
        .padding(contentPadding)
        .verticalScroll(rememberScrollState())
        .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
  ) {
    PersonaAvatarCard(
      name = uiState.personaName,
      avatarUri = uiState.avatarUri,
      onPickAvatar = onAvatarPick,
      onClearAvatar = onAvatarClear,
    )
    EditorCard(title = stringResource(R.string.my_profile_persona_name_title)) {
      OutlinedTextField(
        value = uiState.personaName,
        onValueChange = onPersonaNameChange,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
      )
    }
    EditorCard(title = stringResource(R.string.my_profile_persona_title_title)) {
      OutlinedTextField(
        value = uiState.personaTitle,
        onValueChange = onPersonaTitleChange,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
      )
    }
    EditorCard(title = stringResource(R.string.my_profile_persona_description_title)) {
      OutlinedTextField(
        value = uiState.personaDescription,
        onValueChange = onPersonaDescriptionChange,
        modifier = Modifier.fillMaxWidth(),
        minLines = 4,
      )
    }
    PersonaPositionCard(
      selected = uiState.personaPosition,
      onSelected = onPersonaPositionChange,
    )
    if (uiState.personaPosition == StPersonaDescriptionPosition.AT_DEPTH) {
      EditorCard(title = stringResource(R.string.my_profile_persona_depth_title)) {
        OutlinedTextField(
          value = uiState.personaDepth,
          onValueChange = onPersonaDepthChange,
          modifier = Modifier.fillMaxWidth(),
          singleLine = true,
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
      }
      PersonaRoleCard(
        selectedRole = uiState.personaRole,
        onSelected = onPersonaRoleChange,
      )
    }
  }
}

@Composable
private fun CreatePersonaSlotDialog(
  slotId: String,
  onSlotIdChange: (String) -> Unit,
  onDismiss: () -> Unit,
  onCreate: () -> Unit,
) {
  AlertDialog(
    onDismissRequest = onDismiss,
    title = {
      Text("${stringResource(R.string.create)} ${stringResource(R.string.my_profile_avatar_slot_title)}")
    },
    text = {
      OutlinedTextField(
        value = slotId,
        onValueChange = onSlotIdChange,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        label = { Text(stringResource(R.string.my_profile_avatar_slot_new_label)) },
      )
    },
    confirmButton = {
      TextButton(
        enabled = slotId.trim().isNotBlank(),
        onClick = onCreate,
      ) {
        Text(stringResource(R.string.create))
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
private fun PersonaPositionCard(
  selected: StPersonaDescriptionPosition,
  onSelected: (StPersonaDescriptionPosition) -> Unit,
) {
  Card(modifier = Modifier.fillMaxWidth()) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp).selectableGroup(),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Text(
        text = stringResource(R.string.my_profile_persona_position_title),
        style = MaterialTheme.typography.titleMedium,
      )
      PositionOptionRow(
        label = stringResource(R.string.my_profile_persona_position_in_prompt),
        selected = selected == StPersonaDescriptionPosition.IN_PROMPT,
        onClick = { onSelected(StPersonaDescriptionPosition.IN_PROMPT) },
      )
      PositionOptionRow(
        label = stringResource(R.string.my_profile_persona_position_top_an),
        selected = selected == StPersonaDescriptionPosition.TOP_AN,
        onClick = { onSelected(StPersonaDescriptionPosition.TOP_AN) },
      )
      PositionOptionRow(
        label = stringResource(R.string.my_profile_persona_position_bottom_an),
        selected = selected == StPersonaDescriptionPosition.BOTTOM_AN,
        onClick = { onSelected(StPersonaDescriptionPosition.BOTTOM_AN) },
      )
      PositionOptionRow(
        label = stringResource(R.string.my_profile_persona_position_at_depth),
        selected = selected == StPersonaDescriptionPosition.AT_DEPTH,
        onClick = { onSelected(StPersonaDescriptionPosition.AT_DEPTH) },
      )
      PositionOptionRow(
        label = stringResource(R.string.my_profile_persona_position_none),
        selected = selected == StPersonaDescriptionPosition.NONE,
        onClick = { onSelected(StPersonaDescriptionPosition.NONE) },
      )
    }
  }
}

@Composable
private fun PersonaRoleCard(
  selectedRole: Int,
  onSelected: (Int) -> Unit,
) {
  Card(modifier = Modifier.fillMaxWidth()) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp).selectableGroup(),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Text(
        text = stringResource(R.string.my_profile_persona_role_title),
        style = MaterialTheme.typography.titleMedium,
      )
      PositionOptionRow(
        label = stringResource(R.string.my_profile_persona_role_system),
        selected = selectedRole == 0,
        onClick = { onSelected(0) },
      )
      PositionOptionRow(
        label = stringResource(R.string.my_profile_persona_role_user),
        selected = selectedRole == 1,
        onClick = { onSelected(1) },
      )
      PositionOptionRow(
        label = stringResource(R.string.my_profile_persona_role_assistant),
        selected = selectedRole == 2,
        onClick = { onSelected(2) },
      )
    }
  }
}

@Composable
private fun PositionOptionRow(
  label: String,
  selected: Boolean,
  onClick: () -> Unit,
) {
  Row(
    modifier =
      Modifier
        .fillMaxWidth()
        .selectable(selected = selected, onClick = onClick)
        .padding(vertical = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    RadioButton(selected = selected, onClick = onClick)
    Text(
      text = label,
      modifier = Modifier.padding(start = 8.dp),
      style = MaterialTheme.typography.bodyLarge,
    )
  }
}

@Composable
private fun EditorCard(
  title: String,
  content: @Composable () -> Unit,
) {
  Card(modifier = Modifier.fillMaxWidth()) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      Text(text = title, style = MaterialTheme.typography.titleMedium)
      content()
    }
  }
}

@Composable
private fun PersonaAvatarCard(
  name: String,
  avatarUri: String?,
  onPickAvatar: () -> Unit,
  onClearAvatar: () -> Unit,
) {
  Card(modifier = Modifier.fillMaxWidth()) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      RoleAvatar(
        name = name,
        avatarUri = avatarUri,
        modifier = Modifier.size(96.dp),
      )
      Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        FilledTonalButton(onClick = onPickAvatar) {
          Text(
            if (avatarUri.isNullOrBlank()) {
              stringResource(R.string.role_editor_media_add)
            } else {
              stringResource(R.string.role_editor_media_replace)
            },
          )
        }
        if (!avatarUri.isNullOrBlank()) {
          TextButton(onClick = onClearAvatar) {
            Text(stringResource(R.string.role_editor_media_clear))
          }
        }
      }
    }
  }
}

private fun takeReadPermission(context: android.content.Context, uri: Uri) {
  runCatching {
    context.contentResolver.takePersistableUriPermission(
      uri,
      Intent.FLAG_GRANT_READ_URI_PERMISSION,
    )
  }
}

@Composable
private fun DefaultPersonaAction(
  modifier: Modifier = Modifier,
  checked: Boolean,
  onCheckedChange: (Boolean) -> Unit,
) {
  Row(
    modifier =
      modifier
        .clickable { onCheckedChange(!checked) }
        .padding(horizontal = 8.dp, vertical = 4.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(
      modifier = Modifier.weight(1f),
      text = stringResource(R.string.my_profile_set_default_action),
      style = MaterialTheme.typography.labelLarge,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
    )
    Switch(
      checked = checked,
      onCheckedChange = onCheckedChange,
    )
  }
}
