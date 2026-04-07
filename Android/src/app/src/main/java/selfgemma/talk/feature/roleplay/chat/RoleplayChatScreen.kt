package selfgemma.talk.feature.roleplay.chat

import android.os.SystemClock
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Send
import androidx.compose.material.icons.rounded.SwapHoriz
import androidx.compose.material.icons.rounded.FolderOpen
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import kotlinx.coroutines.delay
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import selfgemma.talk.AppTopBar
import selfgemma.talk.data.AppBarAction
import selfgemma.talk.data.AppBarActionType
import selfgemma.talk.data.BuiltInTaskId
import selfgemma.talk.data.Model
import selfgemma.talk.domain.roleplay.model.Message
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.MessageStatus
import selfgemma.talk.performance.TrackPerformanceState
import selfgemma.talk.ui.modelmanager.ModelInitializationStatusType
import selfgemma.talk.ui.modelmanager.ModelManagerViewModel
import androidx.compose.ui.res.stringResource
import selfgemma.talk.R

private const val TAG = "RoleplayChatScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleplayChatScreen(
  modelManagerViewModel: ModelManagerViewModel,
  navigateUp: () -> Unit,
  onOpenModelLibrary: () -> Unit,
  modifier: Modifier = Modifier,
  viewModel: RoleplayChatViewModel = hiltViewModel(),
) {
  val context = LocalContext.current
  val density = LocalDensity.current
  val uiState by viewModel.uiState.collectAsState()
  val modelManagerUiState by modelManagerViewModel.uiState.collectAsState()
  val activeModel = uiState.session?.activeModelId?.let(modelManagerViewModel::getModelByName)
  val downloadedModels =
    remember(
      modelManagerUiState.modelDownloadStatus,
      modelManagerUiState.modelImportingUpdateTrigger,
    ) {
      modelManagerViewModel.getAllDownloadedModels()
    }
  val llmChatTask = modelManagerViewModel.getTaskById(BuiltInTaskId.LLM_CHAT)
  val listState = rememberLazyListState()
  val lastMessage = uiState.messages.lastOrNull()
  val roleName = uiState.role?.name ?: stringResource(R.string.chat_assistant)
  val imeBottom = WindowInsets.ime.getBottom(density)
  val screenOpenTimestamp = remember { SystemClock.elapsedRealtime() }
  var hasCompletedInitialPositioning by rememberSaveable(uiState.session?.id) { mutableStateOf(false) }
  var hasLoggedInitialPositioning by rememberSaveable(uiState.session?.id) { mutableStateOf(false) }
  var previousMessageCount by rememberSaveable(uiState.session?.id) { mutableStateOf(0) }
  val latestListItemIndex =
    remember(uiState.messages.size) {
      calculateLatestListItemIndex(
        messageCount = uiState.messages.size,
      )
    }

  TrackPerformanceState(
    key = "RoleplayChatList",
    value = if (listState.isScrollInProgress) "scrolling" else null,
  )

  val activeModelStatus = activeModel?.let { modelManagerUiState.modelInitializationStatus[it.name]?.status }
  val isActiveModelInitialized =
    activeModel != null && activeModelStatus == ModelInitializationStatusType.INITIALIZED
  val isActiveModelInitializing =
    activeModel != null &&
      (activeModel.initializing || activeModelStatus == ModelInitializationStatusType.INITIALIZING)
  var showMenu by remember { mutableStateOf(false) }
  var showModelPicker by remember { mutableStateOf(false) }

  LaunchedEffect(activeModel?.name, activeModelStatus) {
    if (
      activeModel != null &&
        llmChatTask != null &&
        !isActiveModelInitialized &&
        !isActiveModelInitializing
    ) {
      modelManagerViewModel.initializeModel(context = context, task = llmChatTask, model = activeModel)
    }
  }

  LaunchedEffect(imeBottom, latestListItemIndex, hasCompletedInitialPositioning) {
    if (
      hasCompletedInitialPositioning &&
        imeBottom > 0 &&
        latestListItemIndex >= 0 &&
        shouldKeepLatestMessageVisible(listState, latestListItemIndex)
    ) {
      scrollToItem(listState = listState, itemIndex = latestListItemIndex, animate = false)
    }
  }

  LaunchedEffect(latestListItemIndex, uiState.messages.size) {
    if (latestListItemIndex < 0) {
      previousMessageCount = 0
      return@LaunchedEffect
    }

    if (!hasCompletedInitialPositioning) {
      scrollToItem(listState = listState, itemIndex = latestListItemIndex, animate = false)
      hasCompletedInitialPositioning = true
      previousMessageCount = uiState.messages.size
      if (!hasLoggedInitialPositioning) {
        hasLoggedInitialPositioning = true
        Log.d(
          TAG,
          "initial chat positioned sessionId=${uiState.session?.id} messageCount=${uiState.messages.size} elapsed=${SystemClock.elapsedRealtime() - screenOpenTimestamp}ms",
        )
      }
      return@LaunchedEffect
    }

    val messageCountIncreased = uiState.messages.size > previousMessageCount
    previousMessageCount = uiState.messages.size
    if (messageCountIncreased && shouldKeepLatestMessageVisible(listState, latestListItemIndex)) {
      scrollToItem(listState = listState, itemIndex = latestListItemIndex, animate = true)
    }
  }

  LaunchedEffect(lastMessage?.id, lastMessage?.content, lastMessage?.status, hasCompletedInitialPositioning) {
    if (
      hasCompletedInitialPositioning &&
        latestListItemIndex >= 0 &&
        shouldKeepLatestMessageVisible(listState, latestListItemIndex)
    ) {
      scrollToItem(listState = listState, itemIndex = latestListItemIndex, animate = false)
    }
  }

  Box(modifier = modifier) {
    Scaffold(
      topBar = {
        AppTopBar(
          title = uiState.role?.name ?: stringResource(R.string.chat_title),
          leftAction = AppBarAction(actionType = AppBarActionType.NAVIGATE_UP, actionFn = navigateUp),
          rightAction = AppBarAction(actionType = AppBarActionType.MENU, actionFn = { showMenu = true }),
        )
      },
  ) { innerPadding ->
    if (uiState.loading) {
      Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding).padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Text(stringResource(R.string.chat_loading_session), style = MaterialTheme.typography.headlineSmall)
      }
      return@Scaffold
    }

    if (activeModel == null && uiState.messages.isEmpty()) {
      Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding).padding(24.dp),
        verticalArrangement = Arrangement.Center,
      ) {
        Text(stringResource(R.string.chat_missing_model_title), style = MaterialTheme.typography.headlineSmall)
        Text(
          stringResource(R.string.chat_missing_model_content),
          modifier = Modifier.padding(top = 12.dp),
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        downloadedModels.firstOrNull()?.let { fallbackModel ->
          OutlinedButton(
            modifier = Modifier.padding(top = 20.dp),
            onClick = { viewModel.switchModel(fallbackModel.name) },
          ) {
            Text(stringResource(R.string.chat_use_model, fallbackModel.displayName.ifEmpty { fallbackModel.name }))
          }
        }
        FilledTonalButton(
          modifier = Modifier.padding(top = 12.dp),
          onClick = onOpenModelLibrary,
        ) {
          Text(stringResource(R.string.chat_open_model_library))
        }
      }
      return@Scaffold
    }

    Column(
      modifier =
        Modifier.fillMaxSize()
          .padding(innerPadding)
          .consumeWindowInsets(innerPadding)
          .imePadding()
    ) {
      if (activeModel == null) {
        MissingModelBanner(
          downloadedModels = downloadedModels,
          onSwitchModel = viewModel::switchModel,
          onOpenModelLibrary = onOpenModelLibrary,
        )
      }

      LazyColumn(
        state = listState,
        modifier = Modifier.weight(1f).fillMaxWidth(),
        contentPadding = PaddingValues(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
      ) {

        items(uiState.messages, key = { it.id }) { message ->
          ChatMessageBubble(
            message = message,
            roleName = roleName,
            animateOnEnter = hasCompletedInitialPositioning && message.id == lastMessage?.id,
          )
        }
      }

      Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        uiState.errorMessage?.let { errorMessage ->
          Text(
            text = errorMessage,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error,
          )
        }

        ChatComposer(
          draft = uiState.draft,
          onDraftChange = viewModel::updateDraft,
          canSend = activeModel != null && uiState.draft.isNotBlank(),
          onSend = {
            activeModel?.let { currentModel ->
              viewModel.sendMessage(currentModel)
            }
          },
        )
      }
    }
  }

  DropdownMenu(
      expanded = showMenu,
      onDismissRequest = { showMenu = false },
      offset = DpOffset(x = (-10).dp, y = (-80).dp),
    ) {
      DropdownMenuItem(
        text = { Text("切换模型") },
        onClick = {
          showMenu = false
          showModelPicker = true
        },
        leadingIcon = {
          Icon(Icons.Rounded.SwapHoriz, contentDescription = null)
        }
      )
      DropdownMenuItem(
        text = { Text("打开模型库") },
        onClick = {
          showMenu = false
          onOpenModelLibrary()
        },
        leadingIcon = {
          Icon(Icons.Rounded.FolderOpen, contentDescription = null)
        }
      )
    }

    if (showModelPicker && downloadedModels.isNotEmpty()) {
      AlertDialog(
        onDismissRequest = { showModelPicker = false },
        title = { Text("选择模型") },
        text = {
          Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            downloadedModels.forEach { model ->
              Surface(
                shape = RoundedCornerShape(12.dp),
                color = if (model.name == activeModel?.name) MaterialTheme.colorScheme.primaryContainer
                       else MaterialTheme.colorScheme.surfaceContainerLowest,
                modifier = Modifier
                  .fillMaxWidth()
                  .clickable {
                    viewModel.switchModel(model.name)
                    showModelPicker = false
                  }
                  .padding(12.dp)
              ) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                  Text(
                    model.displayName.ifEmpty { model.name },
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = if (model.name == activeModel?.name) FontWeight.Bold else FontWeight.Normal,
                    modifier = Modifier.weight(1f)
                  )
                  if (model.name == activeModel?.name) {
                    Icon(Icons.Rounded.Check, contentDescription = "当前使用", tint = MaterialTheme.colorScheme.primary)
                  }
                }
              }
            }
          }
        },
        confirmButton = {}
      )
    }
  }
}

@Composable
private fun ChatMessageBubble(
  message: Message,
  roleName: String,
  animateOnEnter: Boolean,
) {
  val isUser = message.side == MessageSide.USER
  val content: @Composable () -> Unit = {
    Column(
      modifier = Modifier.fillMaxWidth(),
      horizontalAlignment = if (isUser) Alignment.End else Alignment.Start,
    ) {
      Text(
        text = if (isUser) stringResource(R.string.chat_you) else roleName,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
        modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 6.dp),
        fontWeight = FontWeight.Medium,
      )

      Surface(
        modifier = Modifier.widthIn(max = 340.dp),
        shape = RoundedCornerShape(18.dp),
        tonalElevation = if (isUser) 1.dp else 0.5.dp,
        shadowElevation = if (isUser) 1.dp else 0.5.dp,
        color = if (isUser) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceContainerHighest,
      ) {
        Column(
          modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
          verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
          if (isUser) {
            Text(
              text = stringResource(R.string.chat_message_read),
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.primary,
              fontWeight = FontWeight.SemiBold,
            )
          }
          if (message.status == MessageStatus.STREAMING) {
            TypingIndicator()
          } else {
            Text(
              text = message.displayText(),
              style = MaterialTheme.typography.bodyLarge,
              lineHeight = 22.sp,
            )
          }
        }
      }
    }
  }

  if (animateOnEnter) {
    AnimatedVisibility(
      visible = true,
      enter = fadeIn(
        animationSpec = spring(
          stiffness = Spring.StiffnessMediumLow,
          dampingRatio = Spring.DampingRatioMediumBouncy,
        )
      ) + slideInHorizontally(
        animationSpec = spring(
          stiffness = Spring.StiffnessMediumLow,
          dampingRatio = Spring.DampingRatioMediumBouncy,
        ),
        initialOffsetX = { if (isUser) it / 3 else -it / 3 },
      ) + scaleIn(
        animationSpec = spring(
          stiffness = Spring.StiffnessMediumLow,
          dampingRatio = Spring.DampingRatioMediumBouncy,
        ),
        initialScale = 0.9f,
      ),
      exit = fadeOut() + scaleOut(targetScale = 0.9f),
    ) {
      content()
    }
  } else {
    content()
  }
}

@Composable
private fun MissingModelBanner(
  downloadedModels: List<Model>,
  onSwitchModel: (String) -> Unit,
  onOpenModelLibrary: () -> Unit,
) {
  Surface(
    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
    shape = RoundedCornerShape(18.dp),
    tonalElevation = 1.dp,
    color = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.45f),
  ) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      Text(
        text = stringResource(R.string.chat_missing_model_title),
        style = MaterialTheme.typography.titleMedium,
      )
      Text(
        text = stringResource(R.string.chat_missing_model_content),
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
      Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        downloadedModels.firstOrNull()?.let { fallbackModel ->
          OutlinedButton(onClick = { onSwitchModel(fallbackModel.name) }) {
            Text(
              stringResource(
                R.string.chat_use_model,
                fallbackModel.displayName.ifEmpty { fallbackModel.name },
              )
            )
          }
        }
        FilledTonalButton(onClick = onOpenModelLibrary) {
          Text(stringResource(R.string.chat_open_model_library))
        }
      }
    }
  }
}

@Composable
private fun ChatComposer(
  draft: String,
  onDraftChange: (String) -> Unit,
  canSend: Boolean,
  onSend: () -> Unit,
) {
  Surface(
    shape = RoundedCornerShape(28.dp),
    tonalElevation = 3.dp,
    shadowElevation = 4.dp,
    color = MaterialTheme.colorScheme.surface,
    modifier = Modifier
      .fillMaxWidth()
      .shadow(
        elevation = 6.dp,
        shape = RoundedCornerShape(28.dp),
        ambientColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
        spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.04f)
      )
      .border(
        width = 1.dp,
        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.8f),
        shape = RoundedCornerShape(28.dp)
      ),
  ) {
    Row(
      modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      TextField(
        modifier = Modifier.weight(1f),
        value = draft,
        onValueChange = onDraftChange,
        minLines = 1,
        maxLines = 4,
        placeholder = { Text(stringResource(R.string.chat_message_placeholder)) },
        colors =
          TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
          ),
      )

      IconButton(
        onClick = onSend,
        enabled = canSend,
        colors =
          IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
            disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
          ),
        modifier = Modifier
          .size(44.dp)
          .shadow(
            elevation = if (canSend) 6.dp else 2.dp,
            shape = CircleShape,
            ambientColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
            spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
          )
      ) {
        Icon(
          imageVector = Icons.AutoMirrored.Rounded.Send,
          contentDescription = stringResource(R.string.chat_send_message),
          modifier = Modifier.size(22.dp),
        )
      }
    }
  }
}

private fun Message.displayText(): String {
  if (content.isNotBlank()) {
    return content
  }

  return when (status) {
    MessageStatus.STREAMING -> "..."
    MessageStatus.INTERRUPTED -> "Response stopped."
    MessageStatus.FAILED -> errorMessage ?: "Response failed."
    else -> "Empty message"
  }
}

private fun MessageStatus.toDisplayLabel(): String {
  return when (this) {
    MessageStatus.PENDING -> "Pending"
    MessageStatus.STREAMING -> "Streaming"
    MessageStatus.COMPLETED -> "Completed"
    MessageStatus.FAILED -> "Failed"
    MessageStatus.INTERRUPTED -> "Stopped"
  }
}

@Composable
private fun TypingIndicator() {
  val dots = listOf(0, 1, 2)
  Row(
    horizontalArrangement = Arrangement.spacedBy(4.dp),
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.padding(vertical = 8.dp)
  ) {
    dots.forEach { index ->
      var animating by remember { mutableStateOf(false) }
      LaunchedEffect(Unit) {
        delay(index * 200L)
        animating = true
      }

      Surface(
        modifier = Modifier.size(8.dp),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
      ) {}
    }
  }
}

private fun shouldKeepLatestMessageVisible(listState: LazyListState, latestItemIndex: Int): Boolean {
  val layoutInfo = listState.layoutInfo
  val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull() ?: return true
  val bottomGap =
    lastVisibleItem.offset + lastVisibleItem.size - layoutInfo.viewportEndOffset
  return lastVisibleItem.index >= latestItemIndex - 1 && bottomGap < 120
}

private suspend fun scrollToItem(listState: LazyListState, itemIndex: Int, animate: Boolean) {
  if (itemIndex < 0) {
    return
  }

  if (animate) {
    listState.animateScrollToItem(index = itemIndex)
  } else {
    listState.scrollToItem(index = itemIndex)
  }
}

private fun calculateLatestListItemIndex(
  messageCount: Int,
): Int {
  if (messageCount == 0) {
    return -1
  }

  return messageCount - 1
}
