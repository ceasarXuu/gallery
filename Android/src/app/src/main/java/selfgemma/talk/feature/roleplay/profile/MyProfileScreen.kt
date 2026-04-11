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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
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
private const val PERSONA_NAME_MAX_CHARS = 120
private const val PERSONA_DESCRIPTION_MAX_CHARS = 600
private const val PERSONA_DEPTH_MAX_CHARS = 4

private data class PersonaTextFieldSpec(
  val maxChars: Int? = null,
)

private enum class PersonaHelpTopic(val titleRes: Int, val bodyRes: Int) {
  NAME(R.string.my_profile_persona_name_title, R.string.my_profile_help_name_body),
  DESCRIPTION(R.string.my_profile_persona_description_title, R.string.my_profile_help_description_body),
  POSITION(R.string.my_profile_persona_position_title, R.string.my_profile_help_position_body),
  DEPTH(R.string.my_profile_persona_depth_title, R.string.my_profile_help_depth_body),
  ROLE(R.string.my_profile_persona_role_title, R.string.my_profile_help_role_body),
}

private fun personaTextFieldSpec(topic: PersonaHelpTopic?): PersonaTextFieldSpec? =
  when (topic) {
    PersonaHelpTopic.NAME -> PersonaTextFieldSpec(maxChars = PERSONA_NAME_MAX_CHARS)
    PersonaHelpTopic.DESCRIPTION -> PersonaTextFieldSpec(maxChars = PERSONA_DESCRIPTION_MAX_CHARS)
    PersonaHelpTopic.DEPTH -> PersonaTextFieldSpec(maxChars = PERSONA_DEPTH_MAX_CHARS)
    else -> null
  }

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
  val focusManager = LocalFocusManager.current
  val keyboardController = LocalSoftwareKeyboardController.current
  // Keep editor affordances transient so process/task recreation re-enters from persisted profile state.
  var editingSlotId by remember { mutableStateOf<String?>(null) }
  var showCreateDialog by remember { mutableStateOf(false) }
  var newSlotId by remember { mutableStateOf("") }
  var showMenu by remember { mutableStateOf(false) }
  var pendingDeleteSlotId by remember { mutableStateOf<String?>(null) }
  var activeHelpTopic by remember { mutableStateOf<PersonaHelpTopic?>(null) }
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
                focusManager.clearFocus(force = true)
                keyboardController?.hide()
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
        onPersonaDescriptionChange = viewModel::updatePersonaDescription,
        onAvatarPick = { avatarLauncher.launch(arrayOf("image/*")) },
        onAvatarClear = { viewModel.updateAvatarUri(null) },
        onPersonaPositionChange = viewModel::updatePersonaPosition,
        onPersonaDepthChange = viewModel::updatePersonaDepth,
        onPersonaRoleChange = viewModel::updatePersonaRole,
        onShowHelp = { topic ->
          Log.d(TAG, "open persona help topic=$topic")
          activeHelpTopic = topic
        },
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

    val helpTopic = activeHelpTopic
    if (helpTopic != null) {
      PersonaHelpDialog(
        topic = helpTopic,
        onDismiss = { activeHelpTopic = null },
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
  onPersonaDescriptionChange: (String) -> Unit,
  onAvatarPick: () -> Unit,
  onAvatarClear: () -> Unit,
  onPersonaPositionChange: (StPersonaDescriptionPosition) -> Unit,
  onPersonaDepthChange: (String) -> Unit,
  onPersonaRoleChange: (Int) -> Unit,
  onShowHelp: (PersonaHelpTopic) -> Unit,
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
    EditorCard(
      title = stringResource(R.string.my_profile_persona_name_title),
      helpTopic = PersonaHelpTopic.NAME,
      onShowHelp = onShowHelp,
    ) {
      PersonaOutlinedTextField(
        value = uiState.personaName,
        onValueChange = onPersonaNameChange,
        modifier = Modifier.fillMaxWidth(),
        maxLines = 1,
        helpTopic = PersonaHelpTopic.NAME,
      )
    }
    EditorCard(
      title = stringResource(R.string.my_profile_persona_description_title),
      helpTopic = PersonaHelpTopic.DESCRIPTION,
      onShowHelp = onShowHelp,
    ) {
      PersonaOutlinedTextField(
        value = uiState.personaDescription,
        onValueChange = onPersonaDescriptionChange,
        modifier = Modifier.fillMaxWidth(),
        minLines = 4,
        maxLines = 8,
        helpTopic = PersonaHelpTopic.DESCRIPTION,
      )
    }
    PersonaPositionCard(
      selected = uiState.personaPosition,
      onSelected = onPersonaPositionChange,
      onShowHelp = onShowHelp,
    )
    if (uiState.personaPosition == StPersonaDescriptionPosition.AT_DEPTH) {
      EditorCard(
        title = stringResource(R.string.my_profile_persona_depth_title),
        helpTopic = PersonaHelpTopic.DEPTH,
        onShowHelp = onShowHelp,
      ) {
        PersonaOutlinedTextField(
          value = uiState.personaDepth,
          onValueChange = onPersonaDepthChange,
          modifier = Modifier.fillMaxWidth(),
          maxLines = 1,
          helpTopic = PersonaHelpTopic.DEPTH,
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
      }
      PersonaRoleCard(
        selectedRole = uiState.personaRole,
        onSelected = onPersonaRoleChange,
        onShowHelp = onShowHelp,
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
  onShowHelp: (PersonaHelpTopic) -> Unit,
) {
  Card(modifier = Modifier.fillMaxWidth()) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp).selectableGroup(),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      PersonaFieldHeader(
        title = stringResource(R.string.my_profile_persona_position_title),
        helpTopic = PersonaHelpTopic.POSITION,
        onShowHelp = onShowHelp,
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
  onShowHelp: (PersonaHelpTopic) -> Unit,
) {
  Card(modifier = Modifier.fillMaxWidth()) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp).selectableGroup(),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      PersonaFieldHeader(
        title = stringResource(R.string.my_profile_persona_role_title),
        helpTopic = PersonaHelpTopic.ROLE,
        onShowHelp = onShowHelp,
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
  helpTopic: PersonaHelpTopic? = null,
  onShowHelp: ((PersonaHelpTopic) -> Unit)? = null,
  content: @Composable () -> Unit,
) {
  Card(modifier = Modifier.fillMaxWidth()) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      PersonaFieldHeader(
        title = title,
        helpTopic = helpTopic,
        onShowHelp = onShowHelp,
      )
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
      Text(
        text = stringResource(R.string.my_profile_avatar_title),
        style = MaterialTheme.typography.titleMedium,
      )
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

@Composable
private fun PersonaFieldHeader(
  title: String,
  helpTopic: PersonaHelpTopic? = null,
  onShowHelp: ((PersonaHelpTopic) -> Unit)? = null,
) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    Text(
      text = title,
      style = MaterialTheme.typography.titleMedium,
      modifier = Modifier.weight(1f),
    )
    if (helpTopic != null && onShowHelp != null) {
      IconButton(onClick = { onShowHelp(helpTopic) }) {
        Icon(
          imageVector = Icons.Outlined.HelpOutline,
          contentDescription = stringResource(R.string.cd_help),
        )
      }
    }
  }
}

@Composable
private fun PersonaHelpDialog(
  topic: PersonaHelpTopic,
  onDismiss: () -> Unit,
) {
  val paragraphs = stringResource(topic.bodyRes).split("\n\n")
  AlertDialog(
    onDismissRequest = onDismiss,
    title = { Text(stringResource(topic.titleRes)) },
    text = {
      LazyColumn(
        modifier = Modifier.fillMaxWidth().heightIn(max = 420.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
      ) {
        items(paragraphs) { paragraph ->
          Text(paragraph, style = MaterialTheme.typography.bodyMedium)
        }
      }
    },
    confirmButton = {
      FilledTonalButton(onClick = onDismiss) {
        Text(stringResource(R.string.ok))
      }
    },
  )
}

@Composable
private fun PersonaOutlinedTextField(
  value: String,
  onValueChange: (String) -> Unit,
  modifier: Modifier = Modifier,
  minLines: Int = 1,
  maxLines: Int = minLines,
  helpTopic: PersonaHelpTopic? = null,
  keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
  val fieldSpec = personaTextFieldSpec(helpTopic)
  val currentCount = value.length
  val maxChars = fieldSpec?.maxChars
  val isOverLimit = maxChars != null && currentCount > maxChars
  LaunchedEffect(isOverLimit, helpTopic, currentCount, maxChars) {
    if (isOverLimit && helpTopic != null && maxChars != null) {
      Log.w(TAG, "persona field exceeds budget topic=$helpTopic count=$currentCount limit=$maxChars")
    }
  }
  OutlinedTextField(
    value = value,
    onValueChange = onValueChange,
    modifier = modifier,
    minLines = minLines,
    maxLines = maxLines,
    singleLine = maxLines == 1,
    isError = isOverLimit,
    keyboardOptions = keyboardOptions,
    supportingText = {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
      ) {
        Text(
          text =
            if (maxChars != null) {
              stringResource(R.string.role_editor_character_count_with_limit, currentCount, maxChars)
            } else {
              stringResource(R.string.role_editor_character_count_without_limit, currentCount)
            },
          style = MaterialTheme.typography.labelSmall,
          color =
            if (isOverLimit) {
              MaterialTheme.colorScheme.error
            } else {
              MaterialTheme.colorScheme.onSurfaceVariant
            },
        )
      }
    },
  )
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
