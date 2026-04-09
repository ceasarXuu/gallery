package selfgemma.talk.feature.roleplay.roles

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import selfgemma.talk.AppTopBar
import selfgemma.talk.R
import selfgemma.talk.data.AppBarAction
import selfgemma.talk.data.AppBarActionType
import selfgemma.talk.ui.modelmanager.ModelManagerViewModel

private const val TAG = "RoleEditorScreen"
private const val ROLE_EDITOR_MEDIUM_TEXT_MAX_LINES = 8
private const val ROLE_EDITOR_LARGE_TEXT_MAX_LINES = 12
private const val ROLE_EDITOR_XL_TEXT_MAX_LINES = 14
private const val ROLE_EDITOR_TEXTFIELD_BASE_HEIGHT_DP = 64
private const val ROLE_EDITOR_TEXTFIELD_LINE_STEP_DP = 24

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
  var showMissingAvatarExportDialog by remember { mutableStateOf(false) }
  var exportPngAfterAvatarPick by remember { mutableStateOf(false) }
  val context = LocalContext.current

  val importLauncher =
    rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
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
  val avatarLauncher =
    rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri: Uri? ->
      if (uri == null) {
        exportPngAfterAvatarPick = false
      } else {
        takeReadPermission(context = context, uri = uri)
        viewModel.updateAvatarUri(uri.toString())
        if (exportPngAfterAvatarPick) {
          exportPngAfterAvatarPick = false
          val fileName = uiState.name.ifBlank { "role-card" }.replace(Regex("[^a-zA-Z0-9._-]"), "_")
          exportPngLauncher.launch("${fileName}.png")
        }
      }
    }
  val galleryLauncher =
    rememberLauncherForActivityResult(ActivityResultContracts.OpenMultipleDocuments()) { uris: List<Uri> ->
      if (uris.isNotEmpty()) {
        uris.forEach { takeReadPermission(context = context, uri = it) }
        viewModel.addGalleryAssets(uris.map(Uri::toString))
      }
    }

  val handleNavigateUp: () -> Unit = {
    if (modelMenuExpanded) {
      modelMenuExpanded = false
      Log.d(TAG, "dismiss model picker before navigating up")
    } else {
      navigateUp()
    }
  }

  BackHandler { handleNavigateUp() }

  Scaffold(
    modifier = modifier.semantics { testTagsAsResourceId = true },
    topBar = {
      AppTopBar(
        title = if (uiState.isNewRole) stringResource(R.string.role_editor_create_title) else stringResource(R.string.role_editor_edit_title),
        leftAction = AppBarAction(actionType = AppBarActionType.NAVIGATE_UP, actionFn = handleNavigateUp),
        rightAction =
          AppBarAction(
            actionType = AppBarActionType.NAVIGATE_UP,
            actionFn = { viewModel.saveRole { handleNavigateUp() } },
            label = stringResource(R.string.save),
          ),
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

    val tabs =
      listOf(
        RoleEditorTab.CARD to stringResource(R.string.role_editor_tab_card),
        RoleEditorTab.PROMPT to stringResource(R.string.role_editor_tab_prompt),
        RoleEditorTab.LOREBOOK to stringResource(R.string.role_editor_tab_lorebook),
        RoleEditorTab.METADATA to stringResource(R.string.role_editor_tab_metadata),
        RoleEditorTab.MEDIA to stringResource(R.string.role_editor_tab_media),
        RoleEditorTab.INTEROP to stringResource(R.string.role_editor_tab_interop),
      )

    LazyColumn(
      modifier = Modifier.fillMaxSize().padding(innerPadding),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      item {
        PrimaryScrollableTabRow(
          selectedTabIndex = tabs.indexOfFirst { it.first == uiState.selectedTab },
          edgePadding = 0.dp,
        ) {
          tabs.forEach { (tab, title) ->
            Tab(
              selected = uiState.selectedTab == tab,
              onClick = { viewModel.selectTab(tab) },
              text = { Text(title) },
            )
          }
        }
      }
      when (uiState.selectedTab) {
        RoleEditorTab.CARD -> {
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_name_label),
              value = uiState.name,
              onValueChange = viewModel::updateName,
              minLines = 1,
              testTag = "role_editor_name",
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_summary_label),
              value = uiState.description,
              onValueChange = viewModel::updateDescription,
              minLines = 3,
              maxLines = ROLE_EDITOR_LARGE_TEXT_MAX_LINES,
              testTag = "role_editor_description",
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_persona_label),
              value = uiState.personality,
              onValueChange = viewModel::updatePersonality,
              minLines = 4,
              maxLines = ROLE_EDITOR_LARGE_TEXT_MAX_LINES,
              testTag = "role_editor_personality",
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_world_settings_label),
              value = uiState.scenario,
              onValueChange = viewModel::updateScenario,
              minLines = 4,
              maxLines = ROLE_EDITOR_LARGE_TEXT_MAX_LINES,
              testTag = "role_editor_scenario",
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_opening_line_label),
              value = uiState.firstMessage,
              onValueChange = viewModel::updateFirstMessage,
              minLines = 3,
              maxLines = ROLE_EDITOR_MEDIUM_TEXT_MAX_LINES,
              testTag = "role_editor_first_message",
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_message_example_label),
              value = uiState.messageExample,
              onValueChange = viewModel::updateMessageExample,
              minLines = 8,
              maxLines = ROLE_EDITOR_XL_TEXT_MAX_LINES,
              testTag = "role_editor_message_example",
            )
          }
        }
        RoleEditorTab.PROMPT -> {
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_system_prompt_label),
              value = uiState.systemPrompt,
              onValueChange = viewModel::updateSystemPrompt,
              minLines = 6,
              maxLines = ROLE_EDITOR_XL_TEXT_MAX_LINES,
              testTag = "role_editor_system_prompt",
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_post_history_instructions_label),
              value = uiState.postHistoryInstructions,
              onValueChange = viewModel::updatePostHistoryInstructions,
              minLines = 4,
              maxLines = ROLE_EDITOR_MEDIUM_TEXT_MAX_LINES,
              testTag = "role_editor_post_history",
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_alternate_greetings_label),
              subtitle = stringResource(R.string.role_editor_alternate_greetings_hint),
              value = uiState.alternateGreetingsText,
              onValueChange = viewModel::updateAlternateGreetingsText,
              minLines = 4,
              maxLines = ROLE_EDITOR_MEDIUM_TEXT_MAX_LINES,
              testTag = "role_editor_alternate_greetings",
            )
          }
        }
        RoleEditorTab.LOREBOOK -> {
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_lorebook_name_label),
              value = uiState.characterBook.name,
              onValueChange = viewModel::updateCharacterBookName,
              minLines = 1,
              testTag = "role_editor_lorebook_name",
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_lorebook_description_label),
              value = uiState.characterBook.description,
              onValueChange = viewModel::updateCharacterBookDescription,
              minLines = 3,
              maxLines = ROLE_EDITOR_MEDIUM_TEXT_MAX_LINES,
              testTag = "role_editor_lorebook_description",
            )
          }
          item {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
              Box(modifier = Modifier.weight(1f)) {
                EditorTextCard(
                  title = stringResource(R.string.role_editor_lorebook_scan_depth_label),
                  value = uiState.characterBook.scanDepthText,
                  onValueChange = viewModel::updateCharacterBookScanDepth,
                  minLines = 1,
                  testTag = "role_editor_lorebook_scan_depth",
                )
              }
              Box(modifier = Modifier.weight(1f)) {
                EditorTextCard(
                  title = stringResource(R.string.role_editor_lorebook_token_budget_label),
                  value = uiState.characterBook.tokenBudgetText,
                  onValueChange = viewModel::updateCharacterBookTokenBudget,
                  minLines = 1,
                  testTag = "role_editor_lorebook_token_budget",
                )
              }
            }
          }
          item {
            BooleanFieldCard(
              title = stringResource(R.string.role_editor_lorebook_recursive_label),
              checked = uiState.characterBook.recursiveScanning,
              onCheckedChange = viewModel::updateCharacterBookRecursiveScanning,
            )
          }
          item {
            OutlinedButton(
              onClick = viewModel::addCharacterBookEntry,
              modifier = Modifier.fillMaxWidth().testTag("role_editor_lorebook_add_entry"),
            ) {
              Text(stringResource(R.string.role_editor_lorebook_add_entry))
            }
          }
          uiState.characterBook.entries.forEach { entry ->
            item(key = entry.editorId) {
              LorebookEntryCard(
                entry = entry,
                onUpdateId = viewModel::updateCharacterBookEntryId,
                onUpdateKeys = viewModel::updateCharacterBookEntryKeys,
                onUpdateSecondaryKeys = viewModel::updateCharacterBookEntrySecondaryKeys,
                onUpdateComment = viewModel::updateCharacterBookEntryComment,
                onUpdateContent = viewModel::updateCharacterBookEntryContent,
                onUpdateConstant = viewModel::updateCharacterBookEntryConstant,
                onUpdateSelective = viewModel::updateCharacterBookEntrySelective,
                onUpdateInsertionOrder = viewModel::updateCharacterBookEntryInsertionOrder,
                onUpdateEnabled = viewModel::updateCharacterBookEntryEnabled,
                onUpdatePosition = viewModel::updateCharacterBookEntryPosition,
                onUpdateUseRegex = viewModel::updateCharacterBookEntryUseRegex,
                onRemove = viewModel::removeCharacterBookEntry,
              )
            }
          }
        }
        RoleEditorTab.METADATA -> {
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_creator_label),
              value = uiState.creator,
              onValueChange = viewModel::updateCreator,
              minLines = 1,
              testTag = "role_editor_creator",
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_creator_notes_label),
              value = uiState.creatorNotes,
              onValueChange = viewModel::updateCreatorNotes,
              minLines = 4,
              maxLines = ROLE_EDITOR_MEDIUM_TEXT_MAX_LINES,
              testTag = "role_editor_creator_notes",
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_character_version_label),
              value = uiState.characterVersion,
              onValueChange = viewModel::updateCharacterVersion,
              minLines = 1,
              testTag = "role_editor_character_version",
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_tags_label),
              value = uiState.tagsText,
              onValueChange = viewModel::updateTagsText,
              minLines = 2,
              maxLines = 4,
              testTag = "role_editor_tags",
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_talkativeness_label),
              value = uiState.talkativenessText,
              onValueChange = viewModel::updateTalkativenessText,
              minLines = 1,
              testTag = "role_editor_talkativeness",
            )
          }
          item {
            BooleanFieldCard(
              title = stringResource(R.string.role_editor_favorite_label),
              checked = uiState.fav,
              onCheckedChange = viewModel::updateFav,
            )
          }
          item {
            EditorTextCard(
              title = stringResource(R.string.role_editor_safety_policy_label),
              value = uiState.safetyPolicy,
              onValueChange = viewModel::updateSafetyPolicy,
              minLines = 3,
              maxLines = ROLE_EDITOR_MEDIUM_TEXT_MAX_LINES,
              testTag = "role_editor_safety_policy",
            )
          }
          item {
            Card {
              Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
              ) {
                Text(stringResource(R.string.role_editor_default_model_label), style = MaterialTheme.typography.titleSmall)
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
          }
        }
        RoleEditorTab.MEDIA -> {
          item {
            RoleEditorMediaSection(
              avatarUri = uiState.avatarUri,
              avatarSource = uiState.avatarSource,
              galleryAssets = uiState.galleryAssets,
              importedFromStPng = uiState.importedFromStPng,
              showAvatarSection = true,
              showGallerySection = true,
              onPickAvatar = { avatarLauncher.launch(arrayOf("image/*")) },
              onClearAvatar = { viewModel.updateAvatarUri(null) },
              onAddGallery = { galleryLauncher.launch(arrayOf("image/*")) },
              onRenameGalleryAsset = viewModel::updateGalleryAssetName,
              onUpdateGalleryUsage = viewModel::updateGalleryAssetUsage,
              onSetGalleryAsAvatar = viewModel::setGalleryAssetAsAvatar,
              onRemoveGalleryAsset = viewModel::removeGalleryAsset,
            )
          }
        }
        RoleEditorTab.INTEROP -> {
          item {
            ReadonlyInfoCard(
              title = stringResource(R.string.role_editor_interop_title),
              lines =
                listOf(
                  stringResource(R.string.role_editor_interop_source_format, uiState.sourceFormat.name),
                  stringResource(R.string.role_editor_interop_spec, uiState.sourceSpec ?: "-"),
                  stringResource(R.string.role_editor_interop_spec_version, uiState.sourceSpecVersion ?: "-"),
                ) + uiState.compatibilityWarnings.map { warning ->
                  context.getString(R.string.role_editor_interop_warning, warning)
                },
            )
          }
          item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
              OutlinedButton(
                onClick = { importLauncher.launch("*/*") },
                modifier = Modifier.fillMaxWidth().testTag("role_editor_import_st_json"),
              ) {
                Text(stringResource(R.string.role_editor_import_st_card))
              }
              OutlinedButton(
                onClick = {
                  val fileName = uiState.name.ifBlank { "role-card" }.replace(Regex("[^a-zA-Z0-9._-]"), "_")
                  exportJsonLauncher.launch("${fileName}.json")
                },
                modifier = Modifier.fillMaxWidth().testTag("role_editor_export_st_json"),
              ) {
                Text(stringResource(R.string.role_editor_export_st_json))
              }
              OutlinedButton(
                onClick = {
                  if (uiState.avatarUri.isNullOrBlank()) {
                    showMissingAvatarExportDialog = true
                  } else {
                    val fileName = uiState.name.ifBlank { "role-card" }.replace(Regex("[^a-zA-Z0-9._-]"), "_")
                    exportPngLauncher.launch("${fileName}.png")
                  }
                },
                modifier = Modifier.fillMaxWidth().testTag("role_editor_export_st_png"),
              ) {
                Text(stringResource(R.string.role_editor_export_st_png))
              }
            }
          }
        }
      }
      uiState.statusMessage?.let { statusMessage ->
        item { StatusText(statusMessage, isError = false) }
      }
      uiState.errorMessage?.let { errorMessage ->
        item { StatusText(errorMessage, isError = true) }
      }
      if (!uiState.isNewRole && !uiState.builtIn) {
        item {
          OutlinedButton(onClick = { viewModel.deleteRole { handleNavigateUp() } }, modifier = Modifier.fillMaxWidth()) {
            Text(stringResource(R.string.role_editor_delete_button))
          }
        }
      }
    }
  }

  if (showMissingAvatarExportDialog) {
    AlertDialog(
      onDismissRequest = {
        showMissingAvatarExportDialog = false
        exportPngAfterAvatarPick = false
      },
      title = { Text(stringResource(R.string.role_editor_export_png_missing_avatar_title)) },
      text = { Text(stringResource(R.string.role_editor_export_png_missing_avatar_content)) },
      confirmButton = {
        FilledTonalButton(
          onClick = {
            showMissingAvatarExportDialog = false
            val fileName = uiState.name.ifBlank { "role-card" }.replace(Regex("[^a-zA-Z0-9._-]"), "_")
            exportPngLauncher.launch("${fileName}.png")
          },
        ) {
          Text(stringResource(R.string.role_editor_export_png_use_default))
        }
      },
      dismissButton = {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
          OutlinedButton(
            onClick = {
              showMissingAvatarExportDialog = false
              exportPngAfterAvatarPick = true
              avatarLauncher.launch(arrayOf("image/*"))
            },
          ) {
            Text(stringResource(R.string.role_editor_export_png_upload_image))
          }
          OutlinedButton(
            onClick = {
              showMissingAvatarExportDialog = false
              exportPngAfterAvatarPick = false
            },
          ) {
            Text(stringResource(R.string.cancel))
          }
        }
      },
    )
  }
}

@Composable
private fun EditorTextCard(
  title: String,
  value: String,
  onValueChange: (String) -> Unit,
  minLines: Int,
  maxLines: Int = minLines,
  testTag: String,
  subtitle: String? = null,
) {
  Card {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Text(title, style = MaterialTheme.typography.titleSmall)
      subtitle?.let {
        Text(it, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
      }
      OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier =
          Modifier
            .fillMaxWidth()
            .heightIn(max = editorTextFieldMaxHeight(maxLines))
            .testTag(testTag),
        minLines = minLines,
        maxLines = maxLines,
      )
    }
  }
}

@Composable
private fun BooleanFieldCard(
  title: String,
  checked: Boolean,
  onCheckedChange: (Boolean) -> Unit,
) {
  Card {
    Row(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      Text(title, style = MaterialTheme.typography.titleSmall)
      Checkbox(checked = checked, onCheckedChange = onCheckedChange)
    }
  }
}

@Composable
private fun ReadonlyInfoCard(
  title: String,
  lines: List<String>,
) {
  Card {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Text(title, style = MaterialTheme.typography.titleSmall)
      lines.forEach { line ->
        Text(line, style = MaterialTheme.typography.bodyMedium)
      }
    }
  }
}

@Composable
private fun StatusText(
  message: String,
  isError: Boolean,
) {
  Text(
    text = message,
    style = MaterialTheme.typography.bodyMedium,
    color = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
  )
}

@Composable
private fun LorebookEntryCard(
  entry: RoleEditorCharacterBookEntryState,
  onUpdateId: (String, String) -> Unit,
  onUpdateKeys: (String, String) -> Unit,
  onUpdateSecondaryKeys: (String, String) -> Unit,
  onUpdateComment: (String, String) -> Unit,
  onUpdateContent: (String, String) -> Unit,
  onUpdateConstant: (String, Boolean) -> Unit,
  onUpdateSelective: (String, Boolean) -> Unit,
  onUpdateInsertionOrder: (String, String) -> Unit,
  onUpdateEnabled: (String, Boolean) -> Unit,
  onUpdatePosition: (String, String) -> Unit,
  onUpdateUseRegex: (String, Boolean) -> Unit,
  onRemove: (String) -> Unit,
) {
  Card {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      Text(stringResource(R.string.role_editor_lorebook_entry_title), style = MaterialTheme.typography.titleSmall)
      OutlinedTextField(
        value = entry.idText,
        onValueChange = { onUpdateId(entry.editorId, it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.role_editor_lorebook_entry_id_label)) },
      )
      OutlinedTextField(
        value = entry.keysText,
        onValueChange = { onUpdateKeys(entry.editorId, it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.role_editor_lorebook_entry_keys_label)) },
      )
      OutlinedTextField(
        value = entry.secondaryKeysText,
        onValueChange = { onUpdateSecondaryKeys(entry.editorId, it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.role_editor_lorebook_entry_secondary_keys_label)) },
      )
      OutlinedTextField(
        value = entry.comment,
        onValueChange = { onUpdateComment(entry.editorId, it) },
        modifier = Modifier.fillMaxWidth().heightIn(max = editorTextFieldMaxHeight(ROLE_EDITOR_MEDIUM_TEXT_MAX_LINES)),
        label = { Text(stringResource(R.string.role_editor_lorebook_entry_comment_label)) },
        minLines = 2,
        maxLines = ROLE_EDITOR_MEDIUM_TEXT_MAX_LINES,
      )
      OutlinedTextField(
        value = entry.content,
        onValueChange = { onUpdateContent(entry.editorId, it) },
        modifier = Modifier.fillMaxWidth().heightIn(max = editorTextFieldMaxHeight(ROLE_EDITOR_LARGE_TEXT_MAX_LINES)),
        label = { Text(stringResource(R.string.role_editor_lorebook_entry_content_label)) },
        minLines = 4,
        maxLines = ROLE_EDITOR_LARGE_TEXT_MAX_LINES,
      )
      OutlinedTextField(
        value = entry.insertionOrderText,
        onValueChange = { onUpdateInsertionOrder(entry.editorId, it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.role_editor_lorebook_entry_order_label)) },
      )
      OutlinedTextField(
        value = entry.position,
        onValueChange = { onUpdatePosition(entry.editorId, it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.role_editor_lorebook_entry_position_label)) },
      )
      BooleanFieldCard(
        title = stringResource(R.string.role_editor_lorebook_entry_enabled_label),
        checked = entry.enabled,
        onCheckedChange = { onUpdateEnabled(entry.editorId, it) },
      )
      BooleanFieldCard(
        title = stringResource(R.string.role_editor_lorebook_entry_constant_label),
        checked = entry.constant,
        onCheckedChange = { onUpdateConstant(entry.editorId, it) },
      )
      BooleanFieldCard(
        title = stringResource(R.string.role_editor_lorebook_entry_selective_label),
        checked = entry.selective,
        onCheckedChange = { onUpdateSelective(entry.editorId, it) },
      )
      BooleanFieldCard(
        title = stringResource(R.string.role_editor_lorebook_entry_regex_label),
        checked = entry.useRegex,
        onCheckedChange = { onUpdateUseRegex(entry.editorId, it) },
      )
      OutlinedButton(onClick = { onRemove(entry.editorId) }, modifier = Modifier.fillMaxWidth()) {
        Text(stringResource(R.string.role_editor_lorebook_remove_entry))
      }
    }
  }
}

private fun editorTextFieldMaxHeight(maxLines: Int) =
  (ROLE_EDITOR_TEXTFIELD_BASE_HEIGHT_DP + ((maxLines - 1).coerceAtLeast(0) * ROLE_EDITOR_TEXTFIELD_LINE_STEP_DP)).dp

private fun takeReadPermission(context: android.content.Context, uri: Uri) {
  runCatching {
    context.contentResolver.takePersistableUriPermission(
      uri,
      Intent.FLAG_GRANT_READ_URI_PERMISSION,
    )
  }
}
