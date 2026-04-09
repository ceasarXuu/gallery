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

### Splash intro verification

For the Compose-based tavern sign intro overlay, screenshots taken too early will only capture the system splash icon. Use a later capture window after app launch:

```powershell
adb -s ONNZ95CAEMMZSKTS shell am force-stop selfgemma.talk
adb -s ONNZ95CAEMMZSKTS shell am start -n selfgemma.talk/.MainActivity
Start-Sleep -Milliseconds 1400
adb -s ONNZ95CAEMMZSKTS exec-out screencap -p > D:\gallery\tmp_tavern_overlay.png
adb -s ONNZ95CAEMMZSKTS logcat -d -s AGMainActivity
```

- Around `200ms` to `1000ms` after launch, this device still often shows only the system splash icon.
- Around `1400ms` after launch, the app-level tavern sign animation is visible and can be validated by screenshot.
- `AGMainActivity` now logs `tavern intro animation started/finished`, which is enough to distinguish "still in app intro" from "app did not render first content yet".

### MP4 splash replacement

If a startup video is provided directly in the repo root, copy it into `app/src/main/res/raw/` with a resource-safe lowercase name and let the app-level splash overlay play that raw resource:

```powershell
Copy-Item D:\gallery\GemmaTavern.mp4 D:\gallery\Android\src\app\src\main\res\raw\gemma_tavern.mp4 -Force
```

Verification sequence:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew.bat :app:installDebug
adb -s ONNZ95CAEMMZSKTS shell am force-stop selfgemma.talk
adb -s ONNZ95CAEMMZSKTS shell am start -n selfgemma.talk/.MainActivity
Start-Sleep -Milliseconds 250
adb -s ONNZ95CAEMMZSKTS exec-out screencap -p > D:\gallery\tmp_video_splash_early.png
Start-Sleep -Milliseconds 1200
adb -s ONNZ95CAEMMZSKTS exec-out screencap -p > D:\gallery\tmp_video_splash_mid.png
adb -s ONNZ95CAEMMZSKTS logcat -d -s AGMainActivity
```

- Early frame should show only the static warm-color system splash background, with no old four-shape animated icon.
- Mid frame should show the MP4 content itself.
- `AGMainActivity` should log `tavern intro video prepared` once the `VideoView` starts successfully.

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
