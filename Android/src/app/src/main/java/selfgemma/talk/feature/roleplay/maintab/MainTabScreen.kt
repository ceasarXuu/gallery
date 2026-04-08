package selfgemma.talk.feature.roleplay.maintab

import android.os.SystemClock
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Chat
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import selfgemma.talk.performance.FrontendPerformanceMonitor
import selfgemma.talk.performance.TrackPerformanceState
import selfgemma.talk.ui.modelmanager.ModelManagerViewModel
import selfgemma.talk.R

private data class TabItem(
  val titleResId: Int,
  val icon: ImageVector,
)

private val tabs = listOf(
  TabItem(R.string.tab_messages, Icons.Rounded.Chat),
  TabItem(R.string.tab_roles, Icons.Rounded.Face),
  TabItem(R.string.tab_settings, Icons.Rounded.Settings),
)

private const val TAG = "MainTabScreen"

@Composable
fun MainTabScreen(
  modelManagerViewModel: ModelManagerViewModel,
  onOpenSession: (String) -> Unit,
  onOpenRoleCatalog: () -> Unit,
  onOpenSettings: () -> Unit,
  onOpenModelLibrary: () -> Unit,
  onOpenChat: (String) -> Unit,
  onCreateRole: () -> Unit,
  onEditRole: (String) -> Unit,
  navigateUp: () -> Unit,
  modifier: Modifier = Modifier,
) {
  val pagerState = rememberPagerState(pageCount = { tabs.size })
  val scope = rememberCoroutineScope()

  val currentPage by remember { derivedStateOf { pagerState.currentPage } }
  val targetPage by remember { derivedStateOf { pagerState.targetPage } }
  val isScrollInProgress by remember { derivedStateOf { pagerState.isScrollInProgress } }
  val currentPageName = when (currentPage) {
    0 -> "messages"
    1 -> "roles"
    else -> "settings"
  }
  val handleNavigateUp: () -> Unit = {
    if (currentPage == 0) {
      Log.d(TAG, "navigate up from root tab, delegating to host")
      navigateUp()
    } else {
      Log.d(TAG, "navigate up from secondary tab page=$currentPage, returning to messages tab")
      scope.launch { pagerState.animateScrollToPage(page = 0) }
    }
  }

  val fabDuration = 150

  TrackPerformanceState(key = "MainTab", value = currentPageName)

  LaunchedEffect(currentPage, isScrollInProgress) {
    if (!isScrollInProgress) {
      android.util.Log.d(TAG, "Tab切换完成: currentPage=$currentPage, 响应时间监控")
    }
  }

  BackHandler(enabled = currentPage != 0) { handleNavigateUp() }

  Scaffold(
    modifier = modifier,
    contentWindowInsets = WindowInsets(0, 0, 0, 0),
    floatingActionButton = {
      AnimatedVisibility(
        visible = currentPage == 0 && !isScrollInProgress,
        enter = fadeIn(animationSpec = tween(fabDuration)) + slideInVertically(
          animationSpec = tween(fabDuration),
          initialOffsetY = { it / 2 },
        ),
        exit = fadeOut(animationSpec = tween(fabDuration)) + slideOutVertically(
          animationSpec = tween(fabDuration),
          targetOffsetY = { it / 2 },
        ),
      ) {
        FloatingActionButton(
          onClick = onOpenRoleCatalog,
          containerColor = MaterialTheme.colorScheme.primaryContainer,
          contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ) {
          Icon(Icons.Rounded.Add, contentDescription = stringResource(R.string.sessions_new_session))
        }
      }
    },
    bottomBar = {
      NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        tonalElevation = 8.dp,
        modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars),
      ) {
        tabs.forEachIndexed { index, tab ->
          val isSelected = currentPage == index
          NavigationBarItem(
            selected = isSelected,
            onClick = {
              if (currentPage != index) {
                scope.launch {
                  val startTime = SystemClock.elapsedRealtime()
                  pagerState.scrollToPage(page = index)
                  val duration = SystemClock.elapsedRealtime() - startTime
                  FrontendPerformanceMonitor.recordInteraction(
                    name = "main_tab_switch",
                    durationMs = duration,
                  )
                  android.util.Log.d(TAG, "Tab切换耗时: ${duration}ms, 目标: $index")
                }
              }
            },
            icon = {
              Icon(
                imageVector = tab.icon,
                contentDescription = stringResource(tab.titleResId),
              )
            },
            label = { Text(stringResource(tab.titleResId)) },
            colors = NavigationBarItemDefaults.colors(
              selectedIconColor = MaterialTheme.colorScheme.primary,
              selectedTextColor = MaterialTheme.colorScheme.primary,
              indicatorColor = MaterialTheme.colorScheme.primaryContainer,
              unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
              unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
            ),
          )
        }
      }
    },
  ) { innerPadding ->
    HorizontalPager(
      state = pagerState,
      modifier = Modifier.fillMaxSize(),
      beyondViewportPageCount = 2,
      pageSpacing = 0.dp,
      key = { page -> page },
    ) { page ->
      when (page) {
        0 -> {
          selfgemma.talk.feature.roleplay.sessions.SessionsScreen(
            onOpenSession = onOpenSession,
            onOpenRoleCatalog = onOpenRoleCatalog,
            onOpenSettings = onOpenSettings,
            onOpenModelLibrary = onOpenModelLibrary,
            showFab = false,
            contentPadding = innerPadding,
          )
        }
        1 -> {
          selfgemma.talk.feature.roleplay.roles.RoleCatalogScreen(
            modelManagerViewModel = modelManagerViewModel,
            navigateUp = handleNavigateUp,
            onOpenChat = onOpenChat,
            onCreateRole = onCreateRole,
            onEditRole = onEditRole,
            showNavigateUp = false,
            contentPadding = innerPadding,
          )
        }
        2 -> {
          selfgemma.talk.feature.roleplay.settings.RoleplaySettingsScreen(
            navigateUp = handleNavigateUp,
            onOpenModelLibrary = onOpenModelLibrary,
            showNavigateUp = false,
            contentPadding = innerPadding,
          )
        }
      }
    }
  }
}
