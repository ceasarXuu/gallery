package selfgemma.talk.feature.roleplay.profile

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import selfgemma.talk.AppTopBar
import selfgemma.talk.R
import selfgemma.talk.data.AppBarAction
import selfgemma.talk.data.AppBarActionType
import selfgemma.talk.domain.roleplay.model.StPersonaDescriptionPosition

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
  var showSlotDialog by rememberSaveable { mutableStateOf(false) }
  var selectedSlotId by rememberSaveable { mutableStateOf("") }
  var newSlotId by rememberSaveable { mutableStateOf("") }
  val handleNavigateUp: () -> Unit = {
    Log.d(TAG, "navigate up from my profile")
    navigateUp()
  }

  BackHandler(enabled = showNavigateUp) { handleNavigateUp() }

  Scaffold(
    modifier = modifier,
    contentWindowInsets = WindowInsets(0, 0, 0, 0),
    topBar = {
      AppTopBar(
        title = stringResource(R.string.tab_me),
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
      modifier =
        Modifier
          .fillMaxSize()
          .padding(combinedPadding)
          .verticalScroll(rememberScrollState())
          .padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      ClickableInfoCard(
        title = stringResource(R.string.my_profile_avatar_slot_title),
        value = uiState.avatarSlotId,
        summary = stringResource(R.string.my_profile_avatar_slot_summary),
        onClick = {
          selectedSlotId = uiState.avatarSlotId
          newSlotId = ""
          showSlotDialog = true
        },
      )
      EditorCard(title = stringResource(R.string.my_profile_persona_name_title)) {
        OutlinedTextField(
          value = uiState.personaName,
          onValueChange = viewModel::updatePersonaName,
          modifier = Modifier.fillMaxWidth(),
          singleLine = true,
        )
      }
      EditorCard(title = stringResource(R.string.my_profile_persona_title_title)) {
        OutlinedTextField(
          value = uiState.personaTitle,
          onValueChange = viewModel::updatePersonaTitle,
          modifier = Modifier.fillMaxWidth(),
          singleLine = true,
        )
      }
      EditorCard(title = stringResource(R.string.my_profile_persona_description_title)) {
        OutlinedTextField(
          value = uiState.personaDescription,
          onValueChange = viewModel::updatePersonaDescription,
          modifier = Modifier.fillMaxWidth(),
          minLines = 4,
        )
      }
      PersonaPositionCard(
        selected = uiState.personaPosition,
        onSelected = viewModel::updatePersonaPosition,
      )
      if (uiState.personaPosition == StPersonaDescriptionPosition.AT_DEPTH) {
        EditorCard(title = stringResource(R.string.my_profile_persona_depth_title)) {
          OutlinedTextField(
            value = uiState.personaDepth,
            onValueChange = viewModel::updatePersonaDepth,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
          )
        }
        PersonaRoleCard(
          selectedRole = uiState.personaRole,
          onSelected = viewModel::updatePersonaRole,
        )
      }
      ToggleCard(
        title = stringResource(R.string.my_profile_default_persona_title),
        summary = stringResource(R.string.my_profile_default_persona_summary),
        checked = uiState.defaultPersonaEnabled,
        onCheckedChange = viewModel::updateDefaultPersonaEnabled,
      )
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
      ) {
        OutlinedButton(
          modifier = Modifier.weight(1f),
          onClick = viewModel::resetProfile,
        ) {
          Text(stringResource(R.string.my_profile_reset))
        }
        TextButton(
          modifier = Modifier.weight(1f),
          enabled = uiState.dirty,
          onClick = viewModel::saveProfile,
        ) {
          Text(stringResource(R.string.my_profile_save))
        }
      }
    }

    if (showSlotDialog) {
      PersonaSlotDialog(
        availableSlotIds = uiState.availableSlotIds,
        selectedSlotId = selectedSlotId,
        newSlotId = newSlotId,
        onSelectedSlotChange = { selectedSlotId = it },
        onNewSlotIdChange = { newSlotId = it },
        onDismiss = { showSlotDialog = false },
        onConfirmSelection = {
          viewModel.selectAvatarSlot(selectedSlotId)
          showSlotDialog = false
        },
        onCreateSlot = {
          viewModel.createAvatarSlot(newSlotId)
          showSlotDialog = false
        },
      )
    }
  }
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
private fun ClickableInfoCard(
  title: String,
  value: String,
  summary: String?,
  onClick: () -> Unit,
  enabled: Boolean = true,
) {
  Card(modifier = Modifier.fillMaxWidth()) {
    Column(
      modifier =
        Modifier
          .fillMaxWidth()
          .clickable(enabled = enabled, onClick = onClick)
          .padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
      Text(text = title, style = MaterialTheme.typography.titleMedium)
      Text(
        text = value,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
      if (!summary.isNullOrBlank()) {
        Text(
          text = summary,
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }
    }
  }
}

@Composable
private fun PersonaSlotDialog(
  availableSlotIds: List<String>,
  selectedSlotId: String,
  newSlotId: String,
  onSelectedSlotChange: (String) -> Unit,
  onNewSlotIdChange: (String) -> Unit,
  onDismiss: () -> Unit,
  onConfirmSelection: () -> Unit,
  onCreateSlot: () -> Unit,
) {
  AlertDialog(
    onDismissRequest = onDismiss,
    title = { Text(stringResource(R.string.my_profile_avatar_slot_dialog_title)) },
    text = {
      Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Column(
          modifier = Modifier.selectableGroup(),
          verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
          availableSlotIds.forEach { slotId ->
            PositionOptionRow(
              label = slotId,
              selected = slotId == selectedSlotId,
              onClick = { onSelectedSlotChange(slotId) },
            )
          }
        }
        OutlinedTextField(
          value = newSlotId,
          onValueChange = onNewSlotIdChange,
          modifier = Modifier.fillMaxWidth(),
          singleLine = true,
          label = { Text(stringResource(R.string.my_profile_avatar_slot_new_label)) },
        )
      }
    },
    confirmButton = {
      TextButton(
        enabled = selectedSlotId.isNotBlank(),
        onClick = onConfirmSelection,
      ) {
        Text(stringResource(R.string.my_profile_avatar_slot_use_selected))
      }
    },
    dismissButton = {
      Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        TextButton(
          enabled = newSlotId.trim().isNotBlank(),
          onClick = onCreateSlot,
        ) {
          Text(stringResource(R.string.create))
        }
        TextButton(onClick = onDismiss) {
          Text(stringResource(R.string.cancel))
        }
      }
    },
  )
}

@Composable
private fun ToggleCard(
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
