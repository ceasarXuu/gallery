/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package selfgemma.talk

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.animation.doOnEnd
import androidx.core.os.bundleOf
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.metrics.performance.JankStats
import androidx.metrics.performance.PerformanceMetricsState
import selfgemma.talk.ui.modelmanager.ModelManagerViewModel
import selfgemma.talk.performance.FrontendPerformanceMonitor
import selfgemma.talk.ui.theme.AppTheme
import com.google.ai.edge.litertlm.ExperimentalApi
import com.google.ai.edge.litertlm.ExperimentalFlags
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val MAIN_ACTIVITY_LOG_TAG = "AGMainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private val modelManagerViewModel: ModelManagerViewModel by viewModels()
  private val jankFrameListener = JankStats.OnFrameListener { frameData ->
    FrontendPerformanceMonitor.recordFrame(frameData)
  }
  private var jankStats: JankStats? = null
  private var splashScreenAboutToExit: Boolean = false
  private var contentSet: Boolean = false

  override fun onCreate(savedInstanceState: Bundle?) {
    val splashScreen = installSplashScreen()
    super.onCreate(savedInstanceState)

    val shouldAnimateSplash = savedInstanceState == null

    fun setMainContent() {
      if (contentSet) {
        return
      }

      setContent {
        AppTheme {
          Surface(modifier = Modifier.fillMaxSize()) {
            SelfGemmaTalkApp(modelManagerViewModel = modelManagerViewModel)

            // Fade out a "mask" that has the same color as the background of the splash screen
            // to reveal the actual app content.
            var startMaskFadeout by remember { mutableStateOf(false) }
            LaunchedEffect(Unit) { startMaskFadeout = true }
            AnimatedVisibility(
              !startMaskFadeout,
              enter = fadeIn(animationSpec = snap(0)),
              exit =
                fadeOut(animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)),
            ) {
              Box(
                modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
              )
            }

            if (shouldAnimateSplash) {
              TavernIntroOverlay()
            }
          }
        }
      }

      @OptIn(ExperimentalApi::class)
      ExperimentalFlags.enableBenchmark = false

      initializePerformanceTrackingIfNeeded()

      contentSet = true
    }

    modelManagerViewModel.loadModelAllowlist()

    if (shouldAnimateSplash) {
      // Set the content when the system-provided splash screen is not shown.
      //
      // This is necessary on some Android versions where the splash screen is optimized away (e.g.,
      // after a force-quit) to ensure the main content is displayed immediately and correctly.
      lifecycleScope.launch {
        delay(1000)
        if (!splashScreenAboutToExit) {
          setMainContent()
        }
      }

      // Cross-fade transition from the splash screen to the main content.
      //
      // The logic performs the following key actions:
      // 1. Synchronizes Timing: It calculates the remaining duration of the default icon
      //    animation. It then delays its own animations to ensure the custom fade-out begins just
      //    before the original icon animation would have finished.
      // 2. Initiates a cross-fade:
      //    - Fade out the splash screen.
      //    - Fade in the main content.
      // 3. Cleans up: An `onEnd` listener on the fade-out animator calls
      //    `splashScreenView.remove()` to properly remove the splash screen from the view hierarchy
      //    once it's fully transparent.
      splashScreen.setOnExitAnimationListener { splashScreenView ->
        splashScreenAboutToExit = true

        val now = System.currentTimeMillis()
        val iconAnimationStartMs = splashScreenView.iconAnimationStartMillis
        val duration = splashScreenView.iconAnimationDurationMillis
        val fadeOut = ObjectAnimator.ofFloat(splashScreenView.view, View.ALPHA, 1f, 0f)
        fadeOut.interpolator = DecelerateInterpolator()
        fadeOut.duration = 300L
        fadeOut.doOnEnd { splashScreenView.remove() }
        lifecycleScope.launch {
          val setContentDelay = duration - (now - iconAnimationStartMs) - 300
          if (setContentDelay > 0) {
            delay(setContentDelay)
          }
          setMainContent()
          fadeOut.start()
        }
      }
    } else {
      setMainContent()
    }

    enableEdgeToEdge()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      // Fix for three-button nav not properly going edge-to-edge.
      // See: https://issuetracker.google.com/issues/298296168
      window.isNavigationBarContrastEnforced = false
    }
    // Keep the screen on while the app is running for better demo experience.
    window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
  }

  override fun onResume() {
    super.onResume()

    FrontendPerformanceMonitor.startForegroundSession(javaClass.simpleName)
    jankStats?.isTrackingEnabled = true

    firebaseAnalytics?.logEvent(
      FirebaseAnalytics.Event.APP_OPEN,
      bundleOf(
        "app_version" to BuildConfig.VERSION_NAME,
        "os_version" to Build.VERSION.SDK_INT.toString(),
        "device_model" to Build.MODEL,
      ),
    )
  }

  override fun onPause() {
    FrontendPerformanceMonitor.endForegroundSession("${javaClass.simpleName}.onPause")
    jankStats?.isTrackingEnabled = false
    super.onPause()
  }

  private fun initializePerformanceTrackingIfNeeded() {
    if (jankStats != null) {
      return
    }

    val metricsStateHolder = PerformanceMetricsState.getHolderForHierarchy(window.decorView)
    metricsStateHolder.state?.putState("Activity", javaClass.simpleName)
    jankStats = JankStats.createAndTrack(window, jankFrameListener).apply {
      isTrackingEnabled = lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)
    }
  }

  companion object {
    private const val TAG = MAIN_ACTIVITY_LOG_TAG
  }
}

@Composable
private fun TavernIntroOverlay() {
  var visible by remember { mutableStateOf(true) }
  val boardScale = remember { Animatable(0.92f) }
  val boardAlpha = remember { Animatable(0f) }
  val glowAlpha = remember { Animatable(0f) }
  val subtitleAlpha = remember { Animatable(0f) }
  val overlayAlpha = remember { Animatable(1f) }

  LaunchedEffect(Unit) {
    Log.d(MAIN_ACTIVITY_LOG_TAG, "tavern intro animation started")
    boardAlpha.animateTo(1f, animationSpec = tween(durationMillis = 320, easing = LinearOutSlowInEasing))
    boardScale.animateTo(1f, animationSpec = tween(durationMillis = 520, easing = FastOutSlowInEasing))
    glowAlpha.animateTo(1f, animationSpec = tween(durationMillis = 700, easing = LinearOutSlowInEasing))
    subtitleAlpha.animateTo(1f, animationSpec = tween(durationMillis = 360, easing = LinearOutSlowInEasing))
    delay(620)
    overlayAlpha.animateTo(0f, animationSpec = tween(durationMillis = 420, easing = FastOutSlowInEasing))
    Log.d(MAIN_ACTIVITY_LOG_TAG, "tavern intro animation finished")
    visible = false
  }

  AnimatedVisibility(
    visible = visible,
    enter = fadeIn(animationSpec = snap(0)),
    exit = fadeOut(animationSpec = tween(durationMillis = 120, easing = FastOutSlowInEasing)),
  ) {
    val palette = rememberTavernSplashPalette()
    Box(
      modifier =
        Modifier
          .fillMaxSize()
          .alpha(overlayAlpha.value)
          .background(brush = palette.backgroundBrush)
    ) {
      Box(
        modifier =
          Modifier
            .align(Alignment.TopCenter)
            .padding(top = 88.dp)
            .size(220.dp)
            .blur(48.dp)
            .alpha(glowAlpha.value * 0.75f)
            .background(color = palette.topGlow, shape = CircleShape)
      )
      Box(
        modifier =
          Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 72.dp)
            .size(width = 280.dp, height = 120.dp)
            .blur(52.dp)
            .alpha(glowAlpha.value * 0.35f)
            .background(color = palette.bottomGlow, shape = CircleShape)
      )
      BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
      ) {
        val boardWidth = maxWidth * 0.7f
        Column(
          modifier =
            Modifier
              .fillMaxWidth()
              .padding(horizontal = 28.dp),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
        ) {
          Box(
            modifier =
              Modifier
                .size(width = 10.dp, height = 54.dp)
                .clip(RoundedCornerShape(999.dp))
                .background(palette.chainColor.copy(alpha = 0.82f))
          )
          Spacer(modifier = Modifier.height(10.dp))
          Box(
            modifier =
              Modifier
                .size(width = boardWidth, height = 196.dp)
                .scale(boardScale.value)
                .alpha(boardAlpha.value)
                .clip(RoundedCornerShape(32.dp))
                .background(brush = palette.boardBrush)
                .border(width = 1.5.dp, color = palette.boardBorder, shape = RoundedCornerShape(32.dp))
                .padding(horizontal = 28.dp, vertical = 24.dp),
            contentAlignment = Alignment.Center,
          ) {
            Box(
              modifier =
                Modifier
                  .matchParentSize()
                  .padding(10.dp)
                  .clip(RoundedCornerShape(24.dp))
                  .border(
                    width = 1.dp,
                    color = palette.innerBorder.copy(alpha = glowAlpha.value),
                    shape = RoundedCornerShape(24.dp),
                  )
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text(
                text = localizedAppTitle(),
                style =
                  MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 34.sp,
                    letterSpacing = 0.4.sp,
                  ),
                color = palette.titleColor.copy(alpha = 0.92f + glowAlpha.value * 0.08f),
                textAlign = TextAlign.Center,
              )
              Spacer(modifier = Modifier.height(10.dp))
              Text(
                text = localizedAppSubtitle(),
                modifier = Modifier.alpha(subtitleAlpha.value),
                style =
                  MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 2.6.sp,
                    fontSize = 14.sp,
                  ),
                color = palette.subtitleColor,
                textAlign = TextAlign.Center,
              )
            }
          }
        }
      }
    }
  }
}

@Composable
private fun localizedAppTitle(): String {
  val context = LocalContext.current
  return context.getString(R.string.app_name)
}

@Composable
private fun localizedAppSubtitle(): String {
  val context = LocalContext.current
  return when (context.resources.configuration.locales[0].language) {
    "zh" -> "TAVERN OF GEMMA"
    else -> "WELCOME TO THE TAVERN"
  }
}

@Composable
private fun rememberTavernSplashPalette(): TavernSplashPalette {
  val isDarkTheme =
    when (AppCompatDelegate.getDefaultNightMode()) {
      AppCompatDelegate.MODE_NIGHT_YES -> true
      AppCompatDelegate.MODE_NIGHT_NO -> false
      else -> isSystemInDarkTheme()
    }

  return if (isDarkTheme) {
    TavernSplashPalette(
      backgroundBrush =
        Brush.verticalGradient(
          colors = listOf(Color(0xFF171110), Color(0xFF231915), Color(0xFF120E0D)),
        ),
      boardBrush =
        Brush.verticalGradient(
          colors = listOf(Color(0xFF5F4032), Color(0xFF432B23), Color(0xFF2B1A17)),
        ),
      boardBorder = Color(0xFFC79B62),
      innerBorder = Color(0xFFF7D39B),
      titleColor = Color(0xFFFFE8BF),
      subtitleColor = Color(0xFFD9B178),
      topGlow = Color(0xBFFFBB5D),
      bottomGlow = Color(0x66A04B2B),
      chainColor = Color(0xFF83604C),
    )
  } else {
    TavernSplashPalette(
      backgroundBrush =
        Brush.verticalGradient(
          colors = listOf(Color(0xFFF8E7D1), Color(0xFFF3D4AF), Color(0xFFE8C08F)),
        ),
      boardBrush =
        Brush.verticalGradient(
          colors = listOf(Color(0xFF8D5E41), Color(0xFF744A34), Color(0xFF5D392A)),
        ),
      boardBorder = Color(0xFFF5D08A),
      innerBorder = Color(0xFFFFE3B4),
      titleColor = Color(0xFFFFF1D8),
      subtitleColor = Color(0xFFF3D0A1),
      topGlow = Color(0x99FFB24A),
      bottomGlow = Color(0x668A4B2A),
      chainColor = Color(0xFF9D7A5C),
    )
  }
}

private data class TavernSplashPalette(
  val backgroundBrush: Brush,
  val boardBrush: Brush,
  val boardBorder: Color,
  val innerBorder: Color,
  val titleColor: Color,
  val subtitleColor: Color,
  val topGlow: Color,
  val bottomGlow: Color,
  val chainColor: Color,
)
