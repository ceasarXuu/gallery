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

## 2026-04-07 Roleplay chat send orchestration verification

- Goal: verify the new roleplay chat send experience for continued typing, merge-on-resend, and delayed LLM dispatch.
- Key tags: `RoleplayChatViewModel`, `SendRoleplayMessage`

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew :app:compileDebugKotlin
adb logcat -c
adb shell am force-stop selfgemma.talk
adb shell am start -n selfgemma.talk/.MainActivity
adb logcat -v time | Select-String -Pattern 'RoleplayChatViewModel|SendRoleplayMessage|AndroidRuntime'
```

What to verify in logcat:

- When the user sends and keeps editing, `RoleplayChatViewModel` should print `dispatch paused ... reason=draft changed while send pending`.
- When the user sends again before the assistant reply lands, `RoleplayChatViewModel` should print `send merge requested ...` and the previous assistant seed should end as interrupted without showing a visible empty bubble.
- The next actual request should print `dispatch starting ... pendingCount=<n> combinedLength=<n>`, and `SendRoleplayMessage` should print `queued assistant seed ... userMessageCount=<n>`, proving multiple user messages were merged into one model call.

Manual verification flow:

- Open a roleplay session and send message A.
- Immediately continue typing message B; wait for the debounce window and confirm the first request is delayed while editing continues.
- Send message B before any assistant text appears; confirm the old generation is interrupted and the next dispatch reports `userMessageCount=2`.
- Keep the input focused during the assistant run and send message C; confirm the input stays editable and the send button remains in normal send state.

## 2026-04-07 Roleplay ST interop parser verification

- Goal: verify ST role card compatibility work at the parser/serializer layer before wiring UI import/export.
- Scope in this phase: ST v2 `json` only.

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew.bat :app:compileDebugKotlin
.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.data.roleplay.interop.stcard.StV2CardParserTest"
```

Notes:

- Run `compileDebugKotlin` first; it catches DTO/package/mapping breakage faster than going straight to unit tests.
- The focused unit test is enough to verify the current round-trip contract: parse ST v2 JSON into canonical `RoleCardCore`, then serialize back into ST v2 shape.
- Current build still emits unrelated Kotlin context-parameter and Moshi KAPT deprecation warnings; treat them as baseline noise unless the task specifically targets build tooling.

## 2026-04-07 Roleplay ST chat jsonl verification

- Goal: verify ST chat compatibility work at the jsonl parser/serializer layer before wiring chat import/export UI.
- Scope in this phase: ST native `jsonl` only.

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew.bat :app:compileDebugKotlin
.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.data.roleplay.interop.stchat.StChatJsonlParserTest" --tests "selfgemma.talk.domain.roleplay.usecase.StChatJsonlInteropUseCaseTest"
```

Notes:

- Keep the parser/serializer tests separate from repository or UI tests; the goal here is to lock the wire format first.
- The current implementation preserves ST-specific fields like `extra`, `swipes`, `swipe_id`, and `chat_metadata` through `metadataJson` bridging, so tests should assert field presence rather than exact pretty-print spacing.
- Do not run `:app:compileDebugKotlin` and `:app:testDebugUnitTest` in parallel. They can race on `app\build\tmp\kotlin-classes\debug` and produce false build failures about unreadable or missing class outputs.

## 2026-04-07 Role editor ST card file-flow notes

- Current role editor integration only wires ST role card `json` import/export, not PNG and not chat `jsonl`.
- UI flow uses Android document contracts rather than direct file paths:
  - import: `ActivityResultContracts.OpenDocument`
  - export: `ActivityResultContracts.CreateDocument("application/json")`

Notes:

- Keep file IO in `RoleplayInteropDocumentRepository`; do not read `ContentResolver` directly from ViewModel or Compose screen.
- Import currently loads ST JSON into the editor state and waits for an explicit save, which is safer than auto-persisting over an existing role.

## 2026-04-07 Roleplay ST interop document workflow notes

- Goal: verify the end-to-end ST compatibility chain after wiring UI entry points and PNG support.
- Scope in this phase:
  - role card `json` and `png`
  - chat `jsonl`

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew.bat :app:compileDebugKotlin
.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.domain.roleplay.usecase.StChatSessionInteropUseCaseTest" --tests "selfgemma.talk.domain.roleplay.usecase.StRoleCardDocumentInteropUseCaseTest" --tests "selfgemma.talk.data.roleplay.interop.stcardpng.StPngRoleCardCodecTest"
```

Notes:

- `compileDebugKotlin` and `testDebugUnitTest` must run sequentially. Running them in parallel can corrupt KAPT/Hilt generated sources under `app\build\generated\source\kapt\debug` and produce false unreadable-file errors.
- PNG role card import currently follows ST precedence exactly: read `ccv3` first, then `chara`; because the app canonical parser is still v2-first, the document import layer normalizes `chara_card_v3` payloads back to v2 before mapping.
- Keep file-format detection in `RoleplayInteropDocumentRepository.getMetadata()` and document-level usecases. Do not branch on URI strings inside Compose or ViewModel code.

## 2026-04-07 Android real-device overwrite install verification

- Goal: verify the ST interop work survives a real-device overwrite install and a cold launch.

Reusable commands:

```powershell
Set-Location D:\gallery
adb devices

Set-Location D:\gallery\Android\src
.\gradlew.bat :app:assembleDebug

adb install -r "D:\gallery\Android\src\app\build\outputs\apk\debug\app-debug.apk"
adb shell am force-stop selfgemma.talk
adb logcat -c
adb shell am start -n selfgemma.talk/.MainActivity
Start-Sleep -Seconds 6
adb shell pidof selfgemma.talk
adb logcat -d -v time | Select-String -Pattern 'AndroidRuntime|FATAL EXCEPTION|selfgemma.talk|Room|SQLite|Hilt'
```

Verification notes:

- On this round the target device was `ONNZ95CAEMMZSKTS`.
- `adb install -r` succeeded, so overwrite install is valid with the current signing/build output.
- Cold launch reached `Displayed selfgemma.talk/.MainActivity` and `pidof selfgemma.talk` returned a live pid, with no `AndroidRuntime` / `FATAL EXCEPTION` crash during startup capture.
- Keep unrelated local worktree changes out of validation commits. This round there were still unrelated edits in `RoleplayChatScreen.kt` and untracked audio files.

## 2026-04-07 Roleplay message sound routing issue

- Symptom: send/receive sound effects log `SoundPool.play()` successfully but are inaudible on-device.
- Root cause on the verified device: `AudioAttributes.USAGE_ASSISTANCE_SONIFICATION` is routed to `STREAM_SYSTEM`, and that stream was muted by the current ringer/vibrate state even while media volume was high.

Fix:

- In `RoleplaySoundEffectPlayer`, route chat sound effects through media:
  - `usage = USAGE_MEDIA`
  - `legacy stream = STREAM_MUSIC`

Verification aid:

```powershell
adb shell dumpsys audio | Select-String -Pattern 'STREAM_MUSIC|STREAM_SYSTEM|ringer mode'
adb logcat -d -v time | Select-String -Pattern 'RoleplaySoundEffects'
```

Notes:

- If user expectation is “chat sound follows media volume”, do not use sonification/system streams here.
- A successful `streamId` from `SoundPool.play()` is not enough to prove audibility; stream routing must be checked against `dumpsys audio`.
## 2026-04-07 Roleplay chat overflow menu positioning

- Symptom: the chat page top-right overflow menu opened near the bottom-right of the screen instead of the app bar action.
- Root cause: `DropdownMenu` was mounted against the full-screen chat root and then corrected with a hard-coded negative `DpOffset`, so the popup anchor drifted as layout bounds changed.

Fix:

- Mount the active overflow menu inside the top bar container, aligned with the top-end action area.
- Remove dependence on hard-coded popup offsets; let Compose position the menu from the local anchor.
- Keep a lightweight `RoleplayChatScreen` log when the overflow menu opens or dismisses so future regressions can be correlated with session state quickly.
