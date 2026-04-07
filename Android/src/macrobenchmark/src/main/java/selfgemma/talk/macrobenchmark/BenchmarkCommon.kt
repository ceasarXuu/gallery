package selfgemma.talk.macrobenchmark

import android.os.SystemClock
import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import kotlin.math.roundToInt

internal const val TARGET_PACKAGE = "selfgemma.talk"
internal const val STARTUP_ITERATIONS = 8
internal const val FLOW_ITERATIONS = 6
internal const val STRESS_ITERATIONS = 6
internal const val ROLE_CREATION_ITERATIONS = 4

private const val UI_TIMEOUT_MS = 10_000L
private const val APP_FOREGROUND_TIMEOUT_MS = 5_000L
private const val ROLEPLAY_BENCHMARK_SEEDER_ACTIVITY =
  "selfgemma.talk.performance.benchmark.RoleplayBenchmarkSeederActivity"
private const val ROLEPLAY_BENCHMARK_SURFACE_ACTIVITY =
  "selfgemma.talk.performance.benchmark.RoleplayBenchmarkSurfaceActivity"

internal const val ROLEPLAY_BENCHMARK_STRESS_SCENARIO = "roleplay_stress_v1"
internal const val ROLEPLAY_LONG_CHAT_ROLE_NAME = "Benchmark Long Chat Role"
internal const val ROLEPLAY_LONG_CHAT_SESSION_ID = "benchmark-session-long-chat"
internal const val ROLEPLAY_SURFACE_SESSIONS = "sessions"
internal const val ROLEPLAY_SURFACE_ROLES = "roles"
internal const val ROLEPLAY_SURFACE_ROLE_EDITOR = "role_editor"
internal const val ROLEPLAY_SURFACE_CHAT = "chat"

private const val LONG_CHAT_SCROLL_X = 0.5f
private const val ROLE_EDITOR_NAME_Y = 0.14f
private const val ROLE_EDITOR_SUMMARY_Y = 0.24f
private const val ROLE_EDITOR_SYSTEM_PROMPT_Y = 0.37f
private const val ROLE_EDITOR_SAVE_BUTTON_Y = 0.92f
private const val ROLE_EDITOR_INPUT_X = 0.5f

internal val macrobenchmarkDevice: UiDevice
  get() = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

internal fun MacrobenchmarkScope.seedRoleplayScenario(scenario: String) {
  macrobenchmarkDevice.ensureDeviceAwake()

  val output =
    macrobenchmarkDevice.executeShellCommand(
      "am start -W -n $TARGET_PACKAGE/$ROLEPLAY_BENCHMARK_SEEDER_ACTIVITY --es scenario $scenario"
    )

  check(output.contains("Status: ok")) {
    "Failed to seed roleplay benchmark scenario '$scenario': $output"
  }
}

internal fun MacrobenchmarkScope.startAppAndWait() {
  macrobenchmarkDevice.ensureDeviceAwake()
  pressHome()
  startActivityAndWait()
  macrobenchmarkDevice.waitForAppToSettle()
  macrobenchmarkDevice.requireTargetAppForeground("start app")
}

internal fun MacrobenchmarkScope.launchRoleplayBenchmarkSurface(
  surface: String,
  sessionId: String? = null,
) {
  macrobenchmarkDevice.ensureDeviceAwake()

  val sessionArgument = sessionId?.let { " --es sessionId $it" } ?: ""
  val output =
    macrobenchmarkDevice.executeShellCommand(
      "am start -S -W -n $TARGET_PACKAGE/$ROLEPLAY_BENCHMARK_SURFACE_ACTIVITY --es surface $surface$sessionArgument"
    )

  check(output.contains("Status: ok")) {
    "Failed to launch roleplay benchmark surface '$surface': $output"
  }

  macrobenchmarkDevice.waitForAppToSettle()
  macrobenchmarkDevice.requireTargetAppForeground("launch surface $surface")
}

internal fun UiDevice.swipeLeftAcrossContent() {
  requireTargetAppForeground("swipe left across content")
  val y = (displayHeight * 0.48f).toInt()
  swipe((displayWidth * 0.82f).toInt(), y, (displayWidth * 0.18f).toInt(), y, 24)
}

internal fun UiDevice.swipeRightAcrossContent() {
  requireTargetAppForeground("swipe right across content")
  val y = (displayHeight * 0.48f).toInt()
  swipe((displayWidth * 0.18f).toInt(), y, (displayWidth * 0.82f).toInt(), y, 24)
}

internal fun UiDevice.swipeUpThroughList() {
  requireTargetAppForeground("swipe up through list")
  val x = displayWidth / 2
  swipe(x, (displayHeight * 0.82f).toInt(), x, (displayHeight * 0.28f).toInt(), 20)
}

internal fun UiDevice.swipeDownThroughList() {
  requireTargetAppForeground("swipe down through list")
  val x = displayWidth / 2
  swipe(x, (displayHeight * 0.30f).toInt(), x, (displayHeight * 0.78f).toInt(), 20)
}

internal fun UiDevice.tapBottomNavigationItem(index: Int, itemCount: Int = 3) {
  require(index in 0 until itemCount) { "Bottom navigation index out of range: $index" }
  requireTargetAppForeground("tap bottom navigation item $index")

  val x = (displayWidth * ((index * 2f) + 1f) / (itemCount * 2f)).toInt()
  val y = (displayHeight * 0.93f).toInt()
  click(x, y)
}

internal fun UiDevice.waitForAppToSettle() {
  waitForIdle()
  waitForIdle(UI_TIMEOUT_MS)
  Thread.sleep(400)
  waitForIdle()
}

internal fun UiDevice.ensureDeviceAwake() {
  if (!isScreenOn) {
    wakeUp()
  }

  executeShellCommand("wm dismiss-keyguard")
  waitForIdle(UI_TIMEOUT_MS)
}

internal fun UiDevice.tapPercent(xPercent: Float, yPercent: Float) {
  requireTargetAppForeground("tap screen percent $xPercent,$yPercent")
  val x = (displayWidth * xPercent).roundToInt()
  val y = (displayHeight * yPercent).roundToInt()
  click(x, y)
  waitForIdle()
}

internal fun UiDevice.focusRoleEditorName() {
  tapPercent(xPercent = ROLE_EDITOR_INPUT_X, yPercent = ROLE_EDITOR_NAME_Y)
}

internal fun UiDevice.focusRoleEditorSummary() {
  tapPercent(xPercent = ROLE_EDITOR_INPUT_X, yPercent = ROLE_EDITOR_SUMMARY_Y)
}

internal fun UiDevice.focusRoleEditorSystemPrompt() {
  tapPercent(xPercent = ROLE_EDITOR_INPUT_X, yPercent = ROLE_EDITOR_SYSTEM_PROMPT_Y)
}

internal fun UiDevice.tapRoleEditorSave() {
  tapPercent(xPercent = 0.5f, yPercent = ROLE_EDITOR_SAVE_BUTTON_Y)
}

internal fun UiDevice.replaceText(value: String) {
  requireTargetAppForeground("replace text")
  executeShellCommand("input keycombination 113 29")
  executeShellCommand("input keyevent 67")
  executeShellCommand("input text ${value.toShellInputTextArg()}")
  waitForIdle()
}

internal fun UiDevice.requireTargetAppForeground(interactionName: String) {
  val deadline = SystemClock.uptimeMillis() + APP_FOREGROUND_TIMEOUT_MS
  var observedPackageName = currentPackageName

  while (SystemClock.uptimeMillis() < deadline) {
    if (observedPackageName == TARGET_PACKAGE) {
      return
    }

    waitForIdle(250)
    observedPackageName = currentPackageName
  }

  check(observedPackageName == TARGET_PACKAGE) {
    "Refusing to perform benchmark interaction '$interactionName' because $TARGET_PACKAGE is not in the foreground. Current package: ${observedPackageName ?: "unknown"}"
  }
}

private fun String.toShellInputTextArg(): String {
  return buildString(length + 16) {
    for (char in this@toShellInputTextArg) {
      when (char) {
        ' ' -> append("%s")
        '\n' -> append("%n")
        '&' -> append("\\&")
        '<' -> append("\\<")
        '>' -> append("\\>")
        '|' -> append("\\|")
        ';' -> append("\\;")
        '(' -> append("\\(")
        ')' -> append("\\)")
        else -> append(char)
      }
    }
  }
}