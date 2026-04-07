## 2026-04-07 Android debug build and device install

- Workspace: `D:\gallery`
- Gradle project root: `D:\gallery\Android\src`
- Package name: `selfgemma.talk`
- Launch activity: `selfgemma.talk/.MainActivity`

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew :app:compileDebugKotlin
.\gradlew :app:assembleDebug
adb devices
adb install -r .\app\build\outputs\apk\debug\app-debug.apk
adb shell am start -n selfgemma.talk/.MainActivity
```

Notes:

- Use `install -r` for covered debug installs to preserve app data when verifying chat regressions.
- Run `compileDebugKotlin` before full packaging to catch Kotlin issues faster.
- If launch succeeds but UI state looks stale, force-stop once with `adb shell am force-stop selfgemma.talk` and start again.

## 2026-04-07 Roleplay chat detail perf verification

- Goal: verify first-open performance for the roleplay chat detail page on a real device without depending on manual navigation.
- Device: `ONNZ95CAEMMZSKTS`
- Useful when the target issue is tied to long conversation history rendering.

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew :app:assembleBenchmark
adb -s ONNZ95CAEMMZSKTS install -r .\app\build\outputs\apk\benchmark\app-benchmark.apk
adb -s ONNZ95CAEMMZSKTS logcat -c
adb -s ONNZ95CAEMMZSKTS shell am broadcast -a selfgemma.talk.action.SEED_ROLEPLAY_BENCHMARK -n selfgemma.talk/.performance.benchmark.RoleplayBenchmarkReceiver --es scenario roleplay_stress_v1
adb -s ONNZ95CAEMMZSKTS shell am start -n selfgemma.talk/.performance.benchmark.RoleplayBenchmarkSurfaceActivity --es surface chat --es sessionId benchmark-session-long-chat
adb -s ONNZ95CAEMMZSKTS logcat -d | Select-String -Pattern 'RoleplayChatScreen|initial chat positioned|AndroidRuntime'
adb -s ONNZ95CAEMMZSKTS shell uiautomator dump /sdcard/roleplay_chat_dump.xml
adb -s ONNZ95CAEMMZSKTS pull /sdcard/roleplay_chat_dump.xml .\..\tmp_roleplay_chat_verify.xml
```

Notes:

- `RoleplayBenchmarkReceiver` can seed a long conversation quickly; the current stress fixture yields `messages=400`.
- `RoleplayBenchmarkSurfaceActivity` can jump straight into `benchmark-session-long-chat`, which is much faster and more repeatable than tapping through the main UI.
- The log tag `RoleplayChatScreen` now emits `initial chat positioned ... elapsed=<n>ms`, which is the fastest sanity check that the detail page reached initial bottom positioning.
