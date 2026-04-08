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

## 2026-04-08 Roleplay chat enter-exit benchmark verification

- Goal: verify the user-perceived lag when entering and exiting the roleplay chat page through the real app navigation stack.
- Device: `ONNZ95CAEMMZSKTS`
- Benchmark class: `selfgemma.talk.macrobenchmark.RoleplayChatNavigationBenchmark`

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\scripts\run-frontend-perf.ps1 -Runner auto -ClassFilter selfgemma.talk.macrobenchmark.RoleplayChatNavigationBenchmark#openAndCloseChatFromSessions
adb -s ONNZ95CAEMMZSKTS logcat -d -v time | Select-String -Pattern 'AGAppNavGraph|chat navigation enter completed|chat navigation exit completed|FrontendPerf'
```

Notes:

- This benchmark uses the real `MainActivity` start path plus the sessions list entry, so it covers the same `AppNavHost` transition that users hit in production.
- Keep the seeded long-chat session pinned and visible near the top of the list; the benchmark taps the first sessions card by screen percentage for repeatability.
- For this hotspot, prefer correlating Macrobenchmark frame metrics with runtime `FrontendPerf` interaction logs. Smooth frames alone are not enough if the transition duration itself is too long.

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

## 2026-04-08 Role editor media UX implementation notes

- First-phase media editing stays intentionally narrow:
  - primary avatar
  - project-only cover image
- Do not block media UX improvements on a full `RoleMediaProfile` schema migration. The existing `avatarUri` / `coverUri` fields are enough to make role creation and editing explicitly media-aware now.

PNG import/export notes:

- Importing an ST PNG role card should immediately surface the PNG document URI as the role's primary avatar, so the editor can show the asset the user expects.
- Exporting ST PNG without a primary avatar should not silently fall back. Prompt the user first and offer:
  - use default image
  - upload image
  - cancel

URI handling notes:

- `ActivityResultContracts.OpenDocument` results need `takePersistableUriPermission(..., FLAG_GRANT_READ_URI_PERMISSION)` before storing the URI into role state.

## 2026-04-08 ST runtime alignment verification notes

- Goal: verify imported SillyTavern cards keep ST field semantics at runtime, not just pass parser import.
- Focus for this round:
  - `first_mes` as seeded assistant opener
  - `alternate_greetings` fallback
  - `character_book` activation and position handling
  - `extensions.depth_prompt`
  - `post_history_instructions`

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew.bat :app:compileDebugKotlin
.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.domain.roleplay.usecase.PromptAssemblerTest" --tests "selfgemma.talk.domain.roleplay.usecase.CreateRoleplaySessionUseCaseTest" --tests "selfgemma.talk.domain.roleplay.usecase.StRoleCardDocumentInteropUseCaseTest"
adb install -r .\app\build\outputs\apk\debug\app-debug.apk
adb logcat -c
adb shell am force-stop selfgemma.talk
adb shell am start -n selfgemma.talk/.MainActivity
adb logcat -d -v time | Select-String -Pattern 'SendRoleplayMessage|AndroidRuntime'
```

Notes:

- For ST runtime regressions, unit tests are necessary but not sufficient; always do one overwrite install and one fresh in-app send after prompt assembly changes.
- `SendRoleplayMessage` now logs one `assembled prompt ...` line per generation. Use it to confirm prompt construction happened and to spot abnormal prompt growth after lorebook changes.
- When checking imported cards that contain HTML-heavy greetings, verify both the first seeded assistant bubble and the next generated assistant reply. The opener and the runtime prompt path are different codepaths.

## 2026-04-08 Role editor imported avatar persistence note

- Symptom: after importing an ST PNG card, saving, and reopening the role editor, the avatar preview can disappear even though the imported media profile is still present.
- Root cause: editor loading was reading top-level `avatarUri` / `coverUri` directly instead of resolving through `mediaProfile.primaryAvatar` / `mediaProfile.coverImage`. If legacy columns and media profile drift apart, the editor can render an empty preview while the catalog still has the image.

Fix:

- Prefer `mediaProfile.primaryAvatar?.uri` and `mediaProfile.coverImage?.uri` when mapping `RoleEntity -> RoleCard`.
- In the editor, always load and resave avatar/cover from the resolved primary media URI, not just the legacy top-level columns.

Verification:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew.bat :app:compileDebugKotlin
.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.data.roleplay.mapper.RoleplayMappersTest"
adb install -r .\app\build\outputs\apk\debug\app-debug.apk
```
- Keep image-picking launchers separate from ST card import launchers; once media UX exists, sharing a single picker creates confusing state coupling.
## 2026-04-07 Roleplay chat overflow menu positioning

- Symptom: the chat page top-right overflow menu opened near the bottom-right of the screen instead of the app bar action.
- Root cause: `DropdownMenu` was mounted against the full-screen chat root and then corrected with a hard-coded negative `DpOffset`, so the popup anchor drifted as layout bounds changed.

Fix:

- Mount the active overflow menu inside the top bar container, aligned with the top-end action area.
- Remove dependence on hard-coded popup offsets; let Compose position the menu from the local anchor.
- Keep a lightweight `RoleplayChatScreen` log when the overflow menu opens or dismisses so future regressions can be correlated with session state quickly.

## 2026-04-07 Roleplay edge-back verification

- Goal: verify that roleplay detail pages consume system back instead of letting the app fall to background before returning to the previous in-app page.
- Verified pages this round:
  - role catalog standalone route
  - role editor standalone route
  - roleplay chat route
  - root settings tab top bar state

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew :app:compileDebugKotlin
.\gradlew :app:assembleDebug

adb -s ONNZ95CAEMMZSKTS install -r .\app\build\outputs\apk\debug\app-debug.apk
adb -s ONNZ95CAEMMZSKTS shell am force-stop selfgemma.talk
adb -s ONNZ95CAEMMZSKTS logcat -c
adb -s ONNZ95CAEMMZSKTS shell am start -n selfgemma.talk/.MainActivity

# Use KEYCODE_BACK to verify the same back dispatcher path used by gesture navigation.
adb -s ONNZ95CAEMMZSKTS shell input keyevent 4
adb -s ONNZ95CAEMMZSKTS shell uiautomator dump /sdcard/verify.xml
adb -s ONNZ95CAEMMZSKTS pull /sdcard/verify.xml .\..\tmp_verify.xml
adb -s ONNZ95CAEMMZSKTS logcat -d -v time | Select-String -Pattern 'RoleplayChatScreen|RoleCatalogScreen|RoleEditorScreen|RoleplaySettingsScreen|AndroidRuntime'
```

Verification notes:

- For Compose screens, `BackHandler` handles both hardware/software back and gesture back through the same dispatcher, so `input keyevent 4` is a valid fast regression check before spending time on manual edge-swipe runs.
- Validate both log and UI tree:
  - log should contain the screen-specific `system back navigate up ...` line
  - dumped hierarchy should land on the expected previous screen, not launcher
- When a screen is reused inside a root tab and as a standalone route, verify both modes:
  - standalone route should show a back affordance and consume back
  - root tab should not show a misleading back affordance

## 2026-04-07 PowerShell Gradle entry note

- In this repo, Gradle commands must run from `D:\gallery\Android\src`; `D:\gallery\Android` does not contain the wrapper script.
- On PowerShell, use `.\gradlew.bat ...` from that directory for build verification.

## 2026-04-08 Role media phase-2 notes

- When media editing expands beyond primary avatar and cover, keep `RoleMediaProfile` as the source of truth and mirror `avatarUri/coverUri` from it for legacy callers. This avoids spreading gallery/sprite assumptions into ST interop code.
- `RoleCatalogScreen`, session list, and chat bubbles should consume `primaryAvatarUri()` instead of raw `avatarUri`, otherwise imported ST PNG avatars and future media-profile-only updates drift apart.
- For role editor pickers, keep one launcher per asset class:
  - `OpenDocument` for primary avatar and cover
  - `OpenMultipleDocuments` for gallery and sprite assets
  Mixing them makes it easy to wire the wrong callback and silently overwrite the primary avatar.
- `:app:testDebugUnitTest` on this workspace can finish generating HTML/XML reports and still hang on Gradle/Kotlin daemon shutdown. When that happens, check `app/build/reports/tests/testDebugUnitTest/` and `app/build/test-results/testDebugUnitTest/` before treating it as a product regression.
- Real-device verification blocker encountered this round:
  - `assembleDebug` first failed on resource packaging because `benchmark_tokens_limit_message` used non-positional `%d` placeholders in multiple locales.
  - After fixing that, the workspace still has broader Gradle/Kotlin/KAPT instability:
    - `compileDebugKotlin` can report daemon-state corruption such as `Expected compiler error, but got exitCode=OK`
    - downstream `hiltAggregateDepsDebug` / `compileDebugJavaWithJavac` can then fail on missing generated classes unrelated to the roleplay media changes
  - Conclusion: for this repo, `compileDebugKotlin` is currently a reliable signal for local code correctness, but `assembleDebug` is not yet stable enough to serve as a regression gate until the build pipeline itself is repaired.

## 2026-04-08 Roleplay localization notes

- Adding feature text only to `values/strings.xml` is not enough in this app. Existing locale folders `values-en`, `values-ja`, `values-ko`, and `values-zh-rCN` must be updated in the same change, otherwise the UI silently falls back to base strings and ships a mixed-language experience.
- For roleplay screens, audit both XML resources and Compose/Kotlin hardcoded text. New import/export status toasts and editor button labels can easily hide in `ViewModel` string construction, not just in `Screen` composables.
- This workspace contains historical mojibake in some locale files and one duplicated menu block in `RoleplayChatScreen.kt`; when `apply_patch` cannot match those lines reliably, replace the exact block and immediately re-run `:app:compileDebugKotlin` to catch any brace drift before moving on.
- For `role_editor_*` resources, the first pass is easy to miss because media titles, summaries, compatibility hints, and export prompt text are separate from the later status/error strings. Diff locale keys against base `values/strings.xml` instead of relying on eyeballing the page.
- If `adb install -r` fails with `INSTALL_PARSE_FAILED_NOT_APK` right after a successful local build, retry with `adb install --no-streaming -r ...` before suspecting the APK itself. This repo's debug APK is large enough that streamed install can fail while push install still succeeds.
- When trimming role editor media UI, prefer deleting only screen-level modules first and leaving the underlying `RoleMediaProfile` schema untouched. This keeps ST import/export compatibility stable while simplifying the editing experience.

- 2026-04-08 Role editor UI verification: startup success does not prove the editor page changed. For navigation-sensitive Compose screens, verify the real target page with db shell uiautomator dump after each tap, and confirm distinctive texts such as the role editor tab titles before calling the change installed.

## 2026-04-08 ST role card import alignment notes

- Goal: align card import behavior with SillyTavern's actual import path, not only with the nominal v2 validator.

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.domain.roleplay.usecase.StRoleCardDocumentInteropUseCaseTest" --tests "selfgemma.talk.domain.roleplay.usecase.CreateRoleplaySessionUseCaseTest" --tests "selfgemma.talk.domain.roleplay.usecase.PromptAssemblerTest"
```

Notes:

- Some cards in the wild are legacy/v1-shaped but also include a partial `data` object. To match ST import behavior, normalize those cards from the top-level v1 fields and ignore partial `data` payloads during legacy import.
- Do not place `first_mes` into the system prompt. ST treats it as the opening assistant message; prompt injection changes the role behavior and makes embedded HTML/formatting blocks show up in the wrong place.
- In the current app architecture, the closest ST-equivalent behavior is: preserve `first_mes` on the role card, seed it as the first assistant message when a new session is created, and keep it out of prompt assembly.
- `character_book` cannot stay as a dead preserved blob if the goal is ST-aligned import behavior. Even a simplified runtime pass should at least respect enabled entries, entry position (`before_char` / `after_char`), and key matching against the live conversation context.
- `post_history_instructions` belongs after recent conversation context, not in the core character section. Putting it earlier weakens its intended effect and diverges from how ST uses it as a post-history instruction block.
- `alternate_greetings` should be preserved even if the UI does not expose greeting switching yet. Use the first alternate greeting as the fallback opening message only when `first_mes` itself is blank.
- Imported ST cards can legally have an empty `system_prompt`. Do not block save on that field in the editor; requiring it forces users to patch cards that ST itself accepts.
- If an ST card ships HTML-heavy greetings, chat rendering must not dump raw tags back to the user. In this app, detect HTML/Markdown in message bubbles and render it as rich text instead of plain `Text`.
