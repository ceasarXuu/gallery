# Android Debug Install Notes

## 2026-04-10

### Rename build overwrite install check

Verified after app display-name rename on device `ONNZ95CAEMMZSKTS`.

Run from `D:\gallery\Android\src`:

```powershell
.\gradlew.bat :app:assembleDebug
.\gradlew.bat :app:installDebug
adb -s ONNZ95CAEMMZSKTS shell monkey -p selfgemma.talk -c android.intent.category.LAUNCHER 1
adb -s ONNZ95CAEMMZSKTS shell dumpsys package selfgemma.talk | findstr /I "MainActivity"
```

### Notes

- `:app:installDebug` is enough for overwrite install on the connected device; no uninstall step was needed.
- After rename-only resource changes, still launch the app once on device instead of assuming the launcher label/resource merge is correct.
- For this workspace, package name remains `selfgemma.talk` even though the user-facing app name is now `Gemma Tavern` / `杰伊玛酒馆`.

## 2026-04-07

### Stable command sequence

Run from `D:\gallery\Android\src`:

```powershell
.\gradlew.bat :app:compileDebugKotlin
.\gradlew.bat :app:installDebug
adb shell am start -n selfgemma.talk/.MainActivity
adb shell dumpsys activity activities | Select-String -Pattern 'topResumedActivity'
```

### Why this sequence

- `:app:compileDebugKotlin` catches Kotlin API drift faster than waiting for the full install task.
- `:app:installDebug` already does overwrite install to the connected device, so there is no need to uninstall first.
- `adb shell am start -n selfgemma.talk/.MainActivity` is enough to foreground the app after install.
- `dumpsys activity activities` is a quick way to confirm the app is actually resumed on device, instead of assuming the launch succeeded.

### Operational notes

- The repository contains a lot of generated files under `Android\src\app\build`; avoid broad full-repo text searches there when troubleshooting source logic.
- When validating send-path changes, clear logcat first if you need clean timing logs:

```powershell
adb logcat -c
adb logcat -d -s RoleplayChatViewModel SendRoleplayMessage AndroidRuntime
```
