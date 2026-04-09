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
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import kotlinx.coroutines.launch
import selfgemma.talk.AppTopBar
import selfgemma.talk.R
import selfgemma.talk.data.AppBarAction
import selfgemma.talk.data.AppBarActionType
import selfgemma.talk.data.Model
import selfgemma.talk.domain.roleplay.model.RoleMediaUsage
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
    val pagerState = rememberPagerState(initialPage = uiState.selectedTab.ordinal) { tabs.size }
    val pagerScope = rememberCoroutineScope()
    val swipeThresholdPx = with(LocalDensity.current) { 72.dp.toPx() }

    LaunchedEffect(uiState.selectedTab) {
      if (pagerState.currentPage != uiState.selectedTab.ordinal) {
        pagerState.animateScrollToPage(uiState.selectedTab.ordinal)
      }
    }

    LaunchedEffect(pagerState.settledPage) {
      val pagerTab = RoleEditorTab.entries.getOrNull(pagerState.settledPage) ?: return@LaunchedEffect
      if (pagerTab != uiState.selectedTab) {
        Log.d(TAG, "Role editor page changed by swipe tab=$pagerTab")
        viewModel.selectTab(pagerTab)
      }
    }

    Column(
      modifier = Modifier.fillMaxSize().padding(innerPadding),
    ) {
      LazyRow(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 4.dp),
      ) {
        items(tabs) { (tab, title) ->
          Surface(
            onClick = {
              viewModel.selectTab(tab)
              pagerScope.launch {
                pagerState.animateScrollToPage(tab.ordinal)
              }
            },
            shape = MaterialTheme.shapes.large,
            color =
              if (uiState.selectedTab == tab) {
                MaterialTheme.colorScheme.primaryContainer
              } else {
                MaterialTheme.colorScheme.surfaceVariant
              },
            contentColor =
              if (uiState.selectedTab == tab) {
                MaterialTheme.colorScheme.onPrimaryContainer
              } else {
                MaterialTheme.colorScheme.onSurfaceVariant
              },
          ) {
            Text(
              text = title,
              modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
              maxLines = 1,
              softWrap = false,
              overflow = TextOverflow.Ellipsis,
              style = MaterialTheme.typography.titleSmall,
            )
          }
        }
      }

      HorizontalPager(
        state = pagerState,
        userScrollEnabled = false,
        modifier =
          Modifier
            .fillMaxSize()
            .pointerInput(uiState.selectedTab) {
              var totalHorizontalDrag = 0f
              detectHorizontalDragGestures(
                onHorizontalDrag = { change, dragAmount ->
                  totalHorizontalDrag += dragAmount
                  change.consume()
                },
                onDragEnd = {
                  val targetPage =
                    when {
                      totalHorizontalDrag <= -swipeThresholdPx && pagerState.currentPage < tabs.lastIndex -> pagerState.currentPage + 1
                      totalHorizontalDrag >= swipeThresholdPx && pagerState.currentPage > 0 -> pagerState.currentPage - 1
                      else -> null
                    }
                  totalHorizontalDrag = 0f
                  if (targetPage != null) {
                    pagerScope.launch {
                      Log.d(TAG, "Role editor page changed by horizontal gesture targetPage=$targetPage")
                      pagerState.animateScrollToPage(targetPage)
                    }
                  }
                },
              )
            },
      ) { page ->
        when (RoleEditorTab.entries[page]) {
          RoleEditorTab.CARD ->
            RoleEditorCardPage(
              uiState = uiState,
              onUpdateName = viewModel::updateName,
              onUpdateDescription = viewModel::updateDescription,
              onUpdatePersonality = viewModel::updatePersonality,
              onUpdateScenario = viewModel::updateScenario,
              onUpdateFirstMessage = viewModel::updateFirstMessage,
              onUpdateMessageExample = viewModel::updateMessageExample,
            )
          RoleEditorTab.PROMPT ->
            RoleEditorPromptPage(
              uiState = uiState,
              onUpdateSystemPrompt = viewModel::updateSystemPrompt,
              onUpdatePostHistoryInstructions = viewModel::updatePostHistoryInstructions,
              onUpdateAlternateGreetingsText = viewModel::updateAlternateGreetingsText,
            )
          RoleEditorTab.LOREBOOK ->
            RoleEditorLorebookPage(
              uiState = uiState,
              onUpdateCharacterBookName = viewModel::updateCharacterBookName,
              onUpdateCharacterBookDescription = viewModel::updateCharacterBookDescription,
              onUpdateCharacterBookScanDepth = viewModel::updateCharacterBookScanDepth,
              onUpdateCharacterBookTokenBudget = viewModel::updateCharacterBookTokenBudget,
              onUpdateCharacterBookRecursiveScanning = viewModel::updateCharacterBookRecursiveScanning,
              onAddCharacterBookEntry = viewModel::addCharacterBookEntry,
              onUpdateEntryId = viewModel::updateCharacterBookEntryId,
              onUpdateEntryKeys = viewModel::updateCharacterBookEntryKeys,
              onUpdateEntrySecondaryKeys = viewModel::updateCharacterBookEntrySecondaryKeys,
              onUpdateEntryComment = viewModel::updateCharacterBookEntryComment,
              onUpdateEntryContent = viewModel::updateCharacterBookEntryContent,
              onUpdateEntryConstant = viewModel::updateCharacterBookEntryConstant,
              onUpdateEntrySelective = viewModel::updateCharacterBookEntrySelective,
              onUpdateEntryInsertionOrder = viewModel::updateCharacterBookEntryInsertionOrder,
              onUpdateEntryEnabled = viewModel::updateCharacterBookEntryEnabled,
              onUpdateEntryPosition = viewModel::updateCharacterBookEntryPosition,
              onUpdateEntryUseRegex = viewModel::updateCharacterBookEntryUseRegex,
              onRemoveEntry = viewModel::removeCharacterBookEntry,
            )
          RoleEditorTab.METADATA ->
            RoleEditorMetadataPage(
              uiState = uiState,
              downloadedModels = downloadedModels,
              modelMenuExpanded = modelMenuExpanded,
              onModelMenuExpandedChange = { modelMenuExpanded = it },
              onUpdateCreator = viewModel::updateCreator,
              onUpdateCreatorNotes = viewModel::updateCreatorNotes,
              onUpdateCharacterVersion = viewModel::updateCharacterVersion,
              onUpdateTagsText = viewModel::updateTagsText,
              onUpdateTalkativenessText = viewModel::updateTalkativenessText,
              onUpdateFav = viewModel::updateFav,
              onUpdateSafetyPolicy = viewModel::updateSafetyPolicy,
              onUpdateDefaultModelId = viewModel::updateDefaultModelId,
            )
          RoleEditorTab.MEDIA ->
            RoleEditorMediaPage(
              uiState = uiState,
              onPickAvatar = { avatarLauncher.launch(arrayOf("image/*")) },
              onClearAvatar = { viewModel.updateAvatarUri(null) },
              onAddGallery = { galleryLauncher.launch(arrayOf("image/*")) },
              onRenameGalleryAsset = viewModel::updateGalleryAssetName,
              onUpdateGalleryUsage = viewModel::updateGalleryAssetUsage,
              onSetGalleryAsAvatar = viewModel::setGalleryAssetAsAvatar,
              onRemoveGalleryAsset = viewModel::removeGalleryAsset,
            )
          RoleEditorTab.INTEROP ->
            RoleEditorInteropPage(
              uiState = uiState,
              context = context,
              onImportStCard = { importLauncher.launch("*/*") },
              onExportStJson = {
                val fileName = uiState.name.ifBlank { "role-card" }.replace(Regex("[^a-zA-Z0-9._-]"), "_")
                exportJsonLauncher.launch("${fileName}.json")
              },
              onExportStPng = {
                if (uiState.avatarUri.isNullOrBlank()) {
                  showMissingAvatarExportDialog = true
                } else {
                  val fileName = uiState.name.ifBlank { "role-card" }.replace(Regex("[^a-zA-Z0-9._-]"), "_")
                  exportPngLauncher.launch("${fileName}.png")
                }
              },
            )
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
private fun RoleEditorCardPage(
  uiState: RoleEditorUiState,
  onUpdateName: (String) -> Unit,
  onUpdateDescription: (String) -> Unit,
  onUpdatePersonality: (String) -> Unit,
  onUpdateScenario: (String) -> Unit,
  onUpdateFirstMessage: (String) -> Unit,
  onUpdateMessageExample: (String) -> Unit,
) {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
  ) {
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_name_label),
        value = uiState.name,
        onValueChange = onUpdateName,
        minLines = 1,
        testTag = "role_editor_name",
      )
    }
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_summary_label),
        value = uiState.description,
        onValueChange = onUpdateDescription,
        minLines = 3,
        maxLines = ROLE_EDITOR_LARGE_TEXT_MAX_LINES,
        testTag = "role_editor_description",
      )
    }
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_persona_label),
        value = uiState.personality,
        onValueChange = onUpdatePersonality,
        minLines = 4,
        maxLines = ROLE_EDITOR_LARGE_TEXT_MAX_LINES,
        testTag = "role_editor_personality",
      )
    }
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_world_settings_label),
        value = uiState.scenario,
        onValueChange = onUpdateScenario,
        minLines = 4,
        maxLines = ROLE_EDITOR_LARGE_TEXT_MAX_LINES,
        testTag = "role_editor_scenario",
      )
    }
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_opening_line_label),
        value = uiState.firstMessage,
        onValueChange = onUpdateFirstMessage,
        minLines = 3,
        maxLines = ROLE_EDITOR_MEDIUM_TEXT_MAX_LINES,
        testTag = "role_editor_first_message",
      )
    }
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_message_example_label),
        value = uiState.messageExample,
        onValueChange = onUpdateMessageExample,
        minLines = 8,
        maxLines = ROLE_EDITOR_XL_TEXT_MAX_LINES,
        testTag = "role_editor_message_example",
      )
    }
    roleEditorStatusItems(uiState)
  }
}

@Composable
private fun RoleEditorPromptPage(
  uiState: RoleEditorUiState,
  onUpdateSystemPrompt: (String) -> Unit,
  onUpdatePostHistoryInstructions: (String) -> Unit,
  onUpdateAlternateGreetingsText: (String) -> Unit,
) {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
  ) {
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_system_prompt_label),
        value = uiState.systemPrompt,
        onValueChange = onUpdateSystemPrompt,
        minLines = 6,
        maxLines = ROLE_EDITOR_XL_TEXT_MAX_LINES,
        testTag = "role_editor_system_prompt",
      )
    }
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_post_history_instructions_label),
        value = uiState.postHistoryInstructions,
        onValueChange = onUpdatePostHistoryInstructions,
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
        onValueChange = onUpdateAlternateGreetingsText,
        minLines = 4,
        maxLines = ROLE_EDITOR_MEDIUM_TEXT_MAX_LINES,
        testTag = "role_editor_alternate_greetings",
      )
    }
    roleEditorStatusItems(uiState)
  }
}

@Composable
private fun RoleEditorLorebookPage(
  uiState: RoleEditorUiState,
  onUpdateCharacterBookName: (String) -> Unit,
  onUpdateCharacterBookDescription: (String) -> Unit,
  onUpdateCharacterBookScanDepth: (String) -> Unit,
  onUpdateCharacterBookTokenBudget: (String) -> Unit,
  onUpdateCharacterBookRecursiveScanning: (Boolean) -> Unit,
  onAddCharacterBookEntry: () -> Unit,
  onUpdateEntryId: (String, String) -> Unit,
  onUpdateEntryKeys: (String, String) -> Unit,
  onUpdateEntrySecondaryKeys: (String, String) -> Unit,
  onUpdateEntryComment: (String, String) -> Unit,
  onUpdateEntryContent: (String, String) -> Unit,
  onUpdateEntryConstant: (String, Boolean) -> Unit,
  onUpdateEntrySelective: (String, Boolean) -> Unit,
  onUpdateEntryInsertionOrder: (String, String) -> Unit,
  onUpdateEntryEnabled: (String, Boolean) -> Unit,
  onUpdateEntryPosition: (String, String) -> Unit,
  onUpdateEntryUseRegex: (String, Boolean) -> Unit,
  onRemoveEntry: (String) -> Unit,
) {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
  ) {
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_lorebook_name_label),
        value = uiState.characterBook.name,
        onValueChange = onUpdateCharacterBookName,
        minLines = 1,
        testTag = "role_editor_lorebook_name",
      )
    }
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_lorebook_description_label),
        value = uiState.characterBook.description,
        onValueChange = onUpdateCharacterBookDescription,
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
            onValueChange = onUpdateCharacterBookScanDepth,
            minLines = 1,
            testTag = "role_editor_lorebook_scan_depth",
          )
        }
        Box(modifier = Modifier.weight(1f)) {
          EditorTextCard(
            title = stringResource(R.string.role_editor_lorebook_token_budget_label),
            value = uiState.characterBook.tokenBudgetText,
            onValueChange = onUpdateCharacterBookTokenBudget,
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
        onCheckedChange = onUpdateCharacterBookRecursiveScanning,
      )
    }
    item {
      OutlinedButton(
        onClick = onAddCharacterBookEntry,
        modifier = Modifier.fillMaxWidth().testTag("role_editor_lorebook_add_entry"),
      ) {
        Text(stringResource(R.string.role_editor_lorebook_add_entry))
      }
    }
    uiState.characterBook.entries.forEach { entry ->
      item(key = entry.editorId) {
        LorebookEntryCard(
          entry = entry,
          onUpdateId = onUpdateEntryId,
          onUpdateKeys = onUpdateEntryKeys,
          onUpdateSecondaryKeys = onUpdateEntrySecondaryKeys,
          onUpdateComment = onUpdateEntryComment,
          onUpdateContent = onUpdateEntryContent,
          onUpdateConstant = onUpdateEntryConstant,
          onUpdateSelective = onUpdateEntrySelective,
          onUpdateInsertionOrder = onUpdateEntryInsertionOrder,
          onUpdateEnabled = onUpdateEntryEnabled,
          onUpdatePosition = onUpdateEntryPosition,
          onUpdateUseRegex = onUpdateEntryUseRegex,
          onRemove = onRemoveEntry,
        )
      }
    }
    roleEditorStatusItems(uiState)
  }
}

@Composable
private fun RoleEditorMetadataPage(
  uiState: RoleEditorUiState,
  downloadedModels: List<Model>,
  modelMenuExpanded: Boolean,
  onModelMenuExpandedChange: (Boolean) -> Unit,
  onUpdateCreator: (String) -> Unit,
  onUpdateCreatorNotes: (String) -> Unit,
  onUpdateCharacterVersion: (String) -> Unit,
  onUpdateTagsText: (String) -> Unit,
  onUpdateTalkativenessText: (String) -> Unit,
  onUpdateFav: (Boolean) -> Unit,
  onUpdateSafetyPolicy: (String) -> Unit,
  onUpdateDefaultModelId: (String?) -> Unit,
) {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
  ) {
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_creator_label),
        value = uiState.creator,
        onValueChange = onUpdateCreator,
        minLines = 1,
        testTag = "role_editor_creator",
      )
    }
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_creator_notes_label),
        value = uiState.creatorNotes,
        onValueChange = onUpdateCreatorNotes,
        minLines = 4,
        maxLines = ROLE_EDITOR_MEDIUM_TEXT_MAX_LINES,
        testTag = "role_editor_creator_notes",
      )
    }
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_character_version_label),
        value = uiState.characterVersion,
        onValueChange = onUpdateCharacterVersion,
        minLines = 1,
        testTag = "role_editor_character_version",
      )
    }
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_tags_label),
        value = uiState.tagsText,
        onValueChange = onUpdateTagsText,
        minLines = 2,
        maxLines = 4,
        testTag = "role_editor_tags",
      )
    }
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_talkativeness_label),
        value = uiState.talkativenessText,
        onValueChange = onUpdateTalkativenessText,
        minLines = 1,
        testTag = "role_editor_talkativeness",
      )
    }
    item {
      BooleanFieldCard(
        title = stringResource(R.string.role_editor_favorite_label),
        checked = uiState.fav,
        onCheckedChange = onUpdateFav,
      )
    }
    item {
      EditorTextCard(
        title = stringResource(R.string.role_editor_safety_policy_label),
        value = uiState.safetyPolicy,
        onValueChange = onUpdateSafetyPolicy,
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
            OutlinedButton(onClick = { onModelMenuExpandedChange(true) }) {
              Text(uiState.defaultModelId ?: stringResource(R.string.role_editor_no_default_model))
            }
            DropdownMenu(
              expanded = modelMenuExpanded,
              onDismissRequest = { onModelMenuExpandedChange(false) },
            ) {
              DropdownMenuItem(
                text = { Text(stringResource(R.string.role_editor_no_default_model)) },
                onClick = {
                  onModelMenuExpandedChange(false)
                  onUpdateDefaultModelId(null)
                },
              )
              downloadedModels.forEach { model ->
                DropdownMenuItem(
                  text = { Text(model.displayName.ifEmpty { model.name }) },
                  onClick = {
                    onModelMenuExpandedChange(false)
                    onUpdateDefaultModelId(model.name)
                  },
                )
              }
            }
          }
        }
      }
    }
    roleEditorStatusItems(uiState)
  }
}

@Composable
private fun RoleEditorMediaPage(
  uiState: RoleEditorUiState,
  onPickAvatar: () -> Unit,
  onClearAvatar: () -> Unit,
  onAddGallery: () -> Unit,
  onRenameGalleryAsset: (String, String) -> Unit,
  onUpdateGalleryUsage: (String, RoleMediaUsage) -> Unit,
  onSetGalleryAsAvatar: (String) -> Unit,
  onRemoveGalleryAsset: (String) -> Unit,
) {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
  ) {
    item {
      RoleEditorMediaSection(
        avatarUri = uiState.avatarUri,
        avatarSource = uiState.avatarSource,
        galleryAssets = uiState.galleryAssets,
        importedFromStPng = uiState.importedFromStPng,
        showAvatarSection = true,
        showGallerySection = true,
        onPickAvatar = onPickAvatar,
        onClearAvatar = onClearAvatar,
        onAddGallery = onAddGallery,
        onRenameGalleryAsset = onRenameGalleryAsset,
        onUpdateGalleryUsage = onUpdateGalleryUsage,
        onSetGalleryAsAvatar = onSetGalleryAsAvatar,
        onRemoveGalleryAsset = onRemoveGalleryAsset,
      )
    }
    roleEditorStatusItems(uiState)
  }
}

@Composable
private fun RoleEditorInteropPage(
  uiState: RoleEditorUiState,
  context: android.content.Context,
  onImportStCard: () -> Unit,
  onExportStJson: () -> Unit,
  onExportStPng: () -> Unit,
) {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
  ) {
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
          onClick = onImportStCard,
          modifier = Modifier.fillMaxWidth().testTag("role_editor_import_st_json"),
        ) {
          Text(stringResource(R.string.role_editor_import_st_card))
        }
        OutlinedButton(
          onClick = onExportStJson,
          modifier = Modifier.fillMaxWidth().testTag("role_editor_export_st_json"),
        ) {
          Text(stringResource(R.string.role_editor_export_st_json))
        }
        OutlinedButton(
          onClick = onExportStPng,
          modifier = Modifier.fillMaxWidth().testTag("role_editor_export_st_png"),
        ) {
          Text(stringResource(R.string.role_editor_export_st_png))
        }
      }
    }
    roleEditorStatusItems(uiState)
  }
}

private fun androidx.compose.foundation.lazy.LazyListScope.roleEditorStatusItems(uiState: RoleEditorUiState) {
  uiState.statusMessage?.let { statusMessage ->
    item { StatusText(statusMessage, isError = false) }
  }
  uiState.errorMessage?.let { errorMessage ->
    item { StatusText(errorMessage, isError = true) }
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
