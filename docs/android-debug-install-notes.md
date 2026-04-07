# Android Debug Install Notes

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
