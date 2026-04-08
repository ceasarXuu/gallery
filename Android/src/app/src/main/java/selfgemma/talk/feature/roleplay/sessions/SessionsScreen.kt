package selfgemma.talk.feature.roleplay.sessions

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Archive
import androidx.compose.material.icons.rounded.Download
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.FileUpload
import androidx.compose.material.icons.rounded.PushPin
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import kotlin.math.roundToInt
import selfgemma.talk.AppTopBar
import selfgemma.talk.data.AppBarAction
import selfgemma.talk.data.AppBarActionType
import selfgemma.talk.R
import selfgemma.talk.performance.TrackPerformanceState
import selfgemma.talk.feature.roleplay.common.RoleAvatar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SessionsScreen(
  onOpenSession: (String) -> Unit,
  onOpenRoleCatalog: () -> Unit,
  onOpenSettings: () -> Unit,
  onOpenModelLibrary: () -> Unit,
  modifier: Modifier =Modifier,
  showFab: Boolean=true,
  contentPadding: PaddingValues=PaddingValues(0.dp),
  viewModel: SessionsViewModel=hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsState()
  var pendingDeleteSessionId by rememberSaveable { mutableStateOf<String?>(null) }
  var pendingImportSessionId by rememberSaveable { mutableStateOf<String?>(null) }
  var pendingExportSessionId by rememberSaveable { mutableStateOf<String?>(null) }
  var expandedSessionId by rememberSaveable { mutableStateOf<String?>(null) }
  val context = LocalContext.current
  val listState = rememberLazyListState()
  val importLauncher =
    rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
      val sessionId = pendingImportSessionId
      pendingImportSessionId = null
      if (sessionId != null && uri != null) {
        viewModel.importChatJsonl(sessionId = sessionId, uri = uri.toString())
      }
    }
  val exportLauncher =
    rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument("application/x-ndjson")) { uri: Uri? ->
      val sessionId = pendingExportSessionId
      pendingExportSessionId = null
      if (sessionId != null && uri != null) {
        viewModel.exportChatJsonl(sessionId = sessionId, uri = uri.toString())
      }
    }

  TrackPerformanceState(
    key = "SessionsList",
    value = if (listState.isScrollInProgress) "scrolling" else null,
  )

  Scaffold(
    modifier=modifier,
    contentWindowInsets=androidx.compose.foundation.layout.WindowInsets(0, 0, 0, 0),
    topBar={
      AppTopBar(
        title=stringResource(R.string.tab_messages),
        rightAction=
          AppBarAction(actionType=AppBarActionType.MENU, actionFn=onOpenRoleCatalog),
      )
    },
    floatingActionButton={
      if (showFab) {
        FloatingActionButton(onClick=onOpenRoleCatalog) {
          Icon(Icons.Rounded.Add, contentDescription=stringResource(R.string.sessions_new_session))
        }
      }
    },
  ) { innerPadding ->
    val combinedPadding=PaddingValues(
      top=innerPadding.calculateTopPadding() + contentPadding.calculateTopPadding(),
      bottom=contentPadding.calculateBottomPadding(),
      start=contentPadding.calculateLeftPadding(androidx.compose.ui.unit.LayoutDirection.Ltr),
      end=contentPadding.calculateRightPadding(androidx.compose.ui.unit.LayoutDirection.Ltr),
    )

    Box(modifier=Modifier.fillMaxSize().padding(combinedPadding)) {
      if (uiState.loading) {
        EmptySessionsState(
          title=stringResource(R.string.sessions_loading),
          onOpenRoleCatalog=onOpenRoleCatalog,
          onOpenModelLibrary=onOpenModelLibrary,
        )
        return@Box
      }

      if (uiState.sessions.isEmpty()) {
        EmptySessionsState(
          title=stringResource(R.string.sessions_empty_title),
          onOpenRoleCatalog=onOpenRoleCatalog,
          onOpenModelLibrary=onOpenModelLibrary,
        )
        return@Box
      }

      LazyColumn(
        state= listState,
        modifier=Modifier.fillMaxSize(),
        contentPadding=PaddingValues(16.dp),
        verticalArrangement=Arrangement.spacedBy(12.dp),
      ) {
        uiState.errorMessage?.let { errorMessage ->
          item {
            Text(
              errorMessage,
              style=MaterialTheme.typography.bodyMedium,
              color=MaterialTheme.colorScheme.error,
            )
          }
        }
        uiState.statusMessage?.let { statusMessage ->
          item {
            Text(
              statusMessage,
              style=MaterialTheme.typography.bodyMedium,
              color=MaterialTheme.colorScheme.primary,
            )
          }
        }

        items(uiState.sessions, key={ it.id }) { session ->
          SessionCard(
            session=session,
            isExpanded=expandedSessionId==session.id,
            onExpandChange={ shouldExpand ->
              expandedSessionId=if (shouldExpand) session.id else null
            },
            onOpen={ onOpenSession(session.id) },
            onImportChat={
              pendingImportSessionId = session.id
              importLauncher.launch("*/*")
            },
            onExportChat={
              pendingExportSessionId = session.id
              val fileName =
                session.roleName.ifBlank { "session" }.replace(Regex("[^a-zA-Z0-9._-]"), "_")
              exportLauncher.launch("${fileName}-${session.id.take(8)}.jsonl")
            },
            onTogglePin={ viewModel.togglePin(session.id) },
            onArchive={ viewModel.archiveSession(session.id) },
            onDelete={ pendingDeleteSessionId=session.id },
          )
        }
      }
    }

    val sessionToDelete=uiState.sessions.firstOrNull { it.id==pendingDeleteSessionId }
    if (sessionToDelete !=null) {
      AlertDialog(
        onDismissRequest={ pendingDeleteSessionId=null },
        title={ Text(stringResource(R.string.sessions_delete_title)) },
        text={
          Text(stringResource(R.string.sessions_delete_content, sessionToDelete.roleName))
        },
        confirmButton={
          androidx.compose.material3.FilledTonalButton(
            onClick={
              viewModel.deleteSession(sessionToDelete.id)
              pendingDeleteSessionId=null
              expandedSessionId=null
            }
          ) {
            Text(stringResource(R.string.delete))
          }
        },
        dismissButton={
          OutlinedButton(onClick={ pendingDeleteSessionId=null }) {
            Text(stringResource(R.string.cancel))
          }
        },
      )
    }
  }
}

@Composable
private fun SessionCard(
  session: SessionListItemUiState,
  isExpanded: Boolean,
  onExpandChange: (Boolean) -> Unit,
  onOpen: () -> Unit,
  onImportChat: () -> Unit,
  onExportChat: () -> Unit,
  onTogglePin: () -> Unit,
  onArchive: () -> Unit,
  onDelete: () -> Unit,
) {
  var offsetX by remember(isExpanded) { mutableFloatStateOf(if (isExpanded) -360f else 0f) }
  val context=LocalContext.current

  val animatedOffsetX by animateFloatAsState(
    targetValue=offsetX,
    animationSpec=
      androidx.compose.animation.core.spring(
        dampingRatio=androidx.compose.animation.core.Spring.DampingRatioNoBouncy,
        stiffness=androidx.compose.animation.core.Spring.StiffnessMedium,
      ),
    label="offset",
  )

  Box(
    modifier=
      Modifier.fillMaxWidth()
        .height(80.dp)
        .clip(MaterialTheme.shapes.large)
        .background(MaterialTheme.colorScheme.errorContainer),
  ) {
    Row(
      modifier=
        Modifier.matchParentSize()
          .padding(start=8.dp, end=4.dp),
      horizontalArrangement=Arrangement.End,
      verticalAlignment=Alignment.CenterVertically,
    ) {
      IconButton(onClick=onImportChat, modifier=Modifier.size(52.dp).background(MaterialTheme.colorScheme.tertiary.copy(alpha=0.15f), CircleShape)) {
        Icon(
          Icons.Rounded.FileUpload,
          contentDescription=stringResource(R.string.sessions_import_chat),
          tint=MaterialTheme.colorScheme.tertiary,
          modifier=Modifier.size(26.dp),
        )
      }
      Spacer(Modifier.width(8.dp))
      IconButton(onClick=onExportChat, modifier=Modifier.size(52.dp).background(MaterialTheme.colorScheme.tertiaryContainer.copy(alpha=0.35f), CircleShape)) {
        Icon(
          Icons.Rounded.Download,
          contentDescription=stringResource(R.string.sessions_export_chat),
          tint=MaterialTheme.colorScheme.onTertiaryContainer,
          modifier=Modifier.size(26.dp),
        )
      }
      Spacer(Modifier.width(8.dp))
      IconButton(onClick=onDelete, modifier=Modifier.size(52.dp).background(MaterialTheme.colorScheme.error.copy(alpha=0.15f), CircleShape)) {
        Icon(
          Icons.Rounded.Delete,
          contentDescription=stringResource(R.string.delete),
          tint=MaterialTheme.colorScheme.error,
          modifier=Modifier.size(26.dp),
        )
      }
      Spacer(Modifier.width(8.dp))
      IconButton(onClick=onArchive, modifier=Modifier.size(52.dp).background(MaterialTheme.colorScheme.secondary.copy(alpha=0.15f), CircleShape)) {
        Icon(
          Icons.Rounded.Archive,
          contentDescription=stringResource(R.string.roles_builtin_title),
          tint=MaterialTheme.colorScheme.secondary,
          modifier=Modifier.size(26.dp),
        )
      }
      Spacer(Modifier.width(8.dp))
      IconButton(onClick=onTogglePin, modifier=Modifier.size(52.dp).background(MaterialTheme.colorScheme.primary.copy(alpha=0.15f), CircleShape)) {
        Icon(
          Icons.Rounded.PushPin,
          contentDescription=stringResource(if (session.pinned) R.string.sessions_unpin else R.string.sessions_pin),
          tint=MaterialTheme.colorScheme.primary,
          modifier=Modifier.size(26.dp),
        )
      }
    }

    Box(
      modifier=
        Modifier.matchParentSize()
          .graphicsLayer {
            translationX=animatedOffsetX
          }
          .background(MaterialTheme.colorScheme.surface)
          .pointerInput(session.id, isExpanded) {
            detectHorizontalDragGestures(
              onDragStart={
                if (!isExpanded) {
                  offsetX=0f
                } else {
                  onExpandChange(false)
                  offsetX=0f
                }
              },
              onHorizontalDrag={ change, dragAmount ->
                change.consume()
                val newOffset=(offsetX + dragAmount).coerceIn(-380f, 0f)
                offsetX=newOffset
              },
              onDragEnd={
                when {
                  offsetX < -160f -> {
                    offsetX=-360f
                    onExpandChange(true)
                  }
                  else -> {
                    offsetX=0f
                    onExpandChange(false)
                  }
                }
              },
            )
          }
          .clickable(
            interactionSource=
              remember { androidx.compose.foundation.interaction.MutableInteractionSource() },
            indication=null,
            enabled=!isExpanded,
          ) {
            onOpen()
          },
    ) {
      Row(
        modifier=Modifier.fillMaxSize().padding(horizontal=16.dp, vertical=12.dp),
        verticalAlignment=Alignment.CenterVertically,
      ) {
        RoleAvatar(
          name = session.roleName,
          avatarUri = session.avatarUri,
          modifier = Modifier.size(56.dp),
        )

        Spacer(Modifier.width(12.dp))

        Column(modifier=Modifier.weight(1f), verticalArrangement=Arrangement.spacedBy(6.dp)) {
          Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement=Arrangement.SpaceBetween,
            verticalAlignment=Alignment.CenterVertically,
          ) {
            Text(
              session.roleName,
              style=MaterialTheme.typography.titleMedium,
              maxLines=1,
              overflow=TextOverflow.Ellipsis,
              modifier=Modifier.weight(1f),
            )
            Text(
              formatTime(session.updatedAt, context),
              style=MaterialTheme.typography.labelSmall,
              color=MaterialTheme.colorScheme.onSurfaceVariant,
            )
          }
          Text(
            session.lastMessage,
            style=MaterialTheme.typography.bodyMedium,
            color=MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines=1,
            overflow=TextOverflow.Ellipsis,
          )
        }
      }
    }
  }
}

private fun formatTime(timestamp: Long, context: android.content.Context): String {
  val now=System.currentTimeMillis()
  val diff=now - timestamp
  return when {
    diff < 60_000L -> context.getString(R.string.sessions_minutes_ago, 0).replace("0", "")
    diff < 3600_000L -> context.getString(R.string.sessions_minutes_ago, diff / 60_000L)
    diff < 86400_000L -> context.getString(R.string.sessions_hours_ago, diff / 3600_000L)
    diff < 604800_000L -> context.getString(R.string.sessions_days_ago, diff / 86400_000L)
    else ->
      java.text.SimpleDateFormat("MM-dd", java.util.Locale.getDefault()).format(java.util.Date(timestamp))
  }
}

@Composable
private fun EmptySessionsState(
  title: String,
  onOpenRoleCatalog: () -> Unit,
  onOpenModelLibrary: () -> Unit,
) {
  Column(
    modifier=Modifier.fillMaxSize().padding(24.dp),
    verticalArrangement=Arrangement.Center,
    horizontalAlignment=Alignment.CenterHorizontally,
  ) {
    Text(title, style=MaterialTheme.typography.headlineSmall)
    Text(
      stringResource(R.string.sessions_empty_content),
      modifier=Modifier.padding(top=12.dp),
      style=MaterialTheme.typography.bodyMedium,
      color=MaterialTheme.colorScheme.onSurfaceVariant,
    )
    Row(modifier=Modifier.padding(top=20.dp), horizontalArrangement=Arrangement.spacedBy(12.dp)) {
      androidx.compose.material3.FilledTonalButton(onClick=onOpenRoleCatalog) {
        Text(stringResource(R.string.sessions_choose_role))
      }
      androidx.compose.material3.OutlinedButton(onClick=onOpenModelLibrary) {
        Text(stringResource(R.string.sessions_model_library))
      }
    }
  }
}
