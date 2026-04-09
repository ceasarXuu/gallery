## 2026-04-10 Role editor AI compression and undo/redo verification

- Goal: verify role editor fields with length budgets can be AI-compressed under the target limit, and top-level `undo` / `redo` actions work during editing.
- Page: role editor
- Related logs: `RoleEditorScreen`, `RoleEditorViewModel`

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew.bat :app:compileDebugKotlin
.\gradlew.bat --no-daemon :app:testDebugUnitTest --tests "selfgemma.talk.feature.roleplay.roles.RoleEditorViewModelTest"
.\gradlew.bat :app:installDebug
adb -s ONNZ95CAEMMZSKTS shell am force-stop selfgemma.talk
adb -s ONNZ95CAEMMZSKTS shell am start -n selfgemma.talk/.MainActivity
adb -s ONNZ95CAEMMZSKTS logcat -c
adb -s ONNZ95CAEMMZSKTS logcat -v time | Select-String -Pattern 'RoleEditorScreen|RoleEditorViewModel|AndroidRuntime'
```

Manual verification flow:

- Open role editor and confirm the top area exposes `Undo` and `Redo` buttons.
- Edit at least one text field such as `Description`, tap `Undo`, then tap `Redo`, and confirm content rolls back and reapplies without leaving the current tab.
- With at least one local model installed, tap `AI Compress` on an over-limit field and confirm the field becomes non-editable until compression completes.
- Confirm compression success logs include source length, target length, and result length.
- Start a compression, then leave the editor before it finishes; confirm logs print cancellation plus original-content restore and the unfinished result is not applied.
- Remove or disable all local models, tap `AI Compress`, and confirm the editor shows a user-facing reminder to add a model or pick the editor assistant model in Settings.

Notes:

- Reuse the roleplay settings page to choose a dedicated editor assistant model. If no explicit model is configured, fall back to the first available local model.
- Keep compression failure behavior honest: if the model returns blank text or still exceeds the target length, keep the original field content and surface a clear error instead of silently truncating.
- Treat role editor compression as a single in-flight task. LiteRT-LM conversation state is simpler and more predictable when the editor does not attempt multiple parallel compressions against the same model session.

## 2026-04-10 Role editor ST-native rewrite verification

- Goal: verify the role editor no longer presents a project-only `Basic / Persona / World / Other` abstraction after ST runtime alignment work.
- The rewritten editor is organized around ST-native sections:
  - `Card`
  - `Prompt`
  - `Lorebook`
  - `Metadata`
  - `Media`
  - `Interop`

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew.bat :app:compileDebugKotlin
.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.feature.roleplay.roles.RoleEditorViewModelTest"
.\gradlew.bat :app:installDebug
adb -s ONNZ95CAEMMZSKTS shell am force-stop selfgemma.talk
adb -s ONNZ95CAEMMZSKTS shell am start -n selfgemma.talk/.MainActivity
adb -s ONNZ95CAEMMZSKTS shell uiautomator dump /sdcard/role_editor_dump.xml
adb -s ONNZ95CAEMMZSKTS shell cat /sdcard/role_editor_dump.xml | Select-String -Pattern 'Card|Prompt|Lorebook|Metadata|Interop|Example dialogue|Post-history instructions'
adb -s ONNZ95CAEMMZSKTS logcat -d -v time | Select-String -Pattern 'RoleEditorViewModel|AndroidRuntime'
```

Notes:

- After importing an ST card, verify `Lorebook` exposes entry-level fields directly instead of hiding them behind runtime-only compilation.
- Keep the editor draft as an ST-shaped form state and only compile `runtimeProfile` on save; do not let the UI round-trip through simplified canonical text buckets.
- Log `source format`, `lore entry count`, and `tag count` on import/save. These are high-signal diagnostics when users report "the editor still doesn't look like ST".
- For long-card verification, cap multiline editor fields with `maxLines` plus `heightIn(max=...)`. In Compose Material 3 this keeps the field internally scrollable and prevents description/prompt fields from stretching the entire page.
- For editor tabs with 5+ sections, prefer `ScrollableTabRow` over squeezing all tabs into one row. This avoids forced line wraps and keeps the active tab readable on narrow devices.
- Also clamp tab labels to `maxLines = 1`, `softWrap = false`, and `overflow = Ellipsis`. A scrollable tab row alone does not stop the `Text` inside each tab from wrapping when localized labels get wider.
- Keep destructive role actions outside the role editor. If the catalog/list page already owns delete, do not repeat a full-width delete button inside every editor tab state; it adds noise and increases accidental-delete risk during editing.
- For multi-section editors, make the section pills and content area share one pager state. Scrollable pills without horizontal swipe support create a false tab expectation and make the UI feel broken on mobile.
- In the role editor, required-state hints and parameter help should come from the same header component. If the required badge and help trigger are implemented separately, they drift quickly and some fields end up undocumented or visually inconsistent.

## 2026-04-10 LiteRT-LM single-session reset failure

- Symptom on device: roleplay chat shows `Failed to create conversation: FAILED_PRECONDITION: A session already exists. Only one session is supported at a time.`
- Root cause: LiteRT-LM only allows one live conversation session per engine. If `resetConversation()` tries to `createConversation()` before closing the previous one, the reset path fails deterministically.

Verification commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew.bat :app:compileDebugKotlin
.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.ui.llmchat.LlmChatModelHelperTest"
.\gradlew.bat :app:installDebug
adb -s ONNZ95CAEMMZSKTS shell am force-stop selfgemma.talk
adb -s ONNZ95CAEMMZSKTS shell am start -n selfgemma.talk/.MainActivity
adb -s ONNZ95CAEMMZSKTS shell uiautomator dump
adb -s ONNZ95CAEMMZSKTS shell cat /sdcard/window_dump.xml | Select-String -Pattern 'A session already exists|FAILED_PRECONDITION|黑木 智子'
adb -s ONNZ95CAEMMZSKTS logcat -d -v time | Select-String -Pattern 'AGLlmChatModelHelper|SendRoleplayMessage|FAILED_PRECONDITION|AndroidRuntime'
```

Notes:

- `resetConversation()` must close the previous conversation before creating the replacement session.
- Because closing first can still leave the engine without a usable conversation if replacement creation fails, keep a best-effort fallback restore path so the runtime does not remain in an unrecoverable half-reset state.
- When reproducing with `uiautomator dump`, use the dumped text as ground truth for user-visible backend errors; this is faster than relying on screenshot inspection alone.

## 2026-04-09 Roleplay chat UX regression verification

- Goal: verify the roleplay chat fixes for send-time auto-scroll, tap-outside keyboard dismissal, and role avatar top alignment on a real device.
- Device: `ONNZ95CAEMMZSKTS`
- Page: roleplay session detail chat

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew :app:compileDebugKotlin
.\gradlew :app:assembleDebug
adb -s ONNZ95CAEMMZSKTS install -r .\app\build\outputs\apk\debug\app-debug.apk
adb -s ONNZ95CAEMMZSKTS shell am force-stop selfgemma.talk
adb -s ONNZ95CAEMMZSKTS logcat -c
adb -s ONNZ95CAEMMZSKTS shell am start -n selfgemma.talk/.MainActivity
adb -s ONNZ95CAEMMZSKTS logcat -d -v time | Select-String -Pattern 'RoleplayChatScreen|RoleplayChatViewModel|SendRoleplayMessage|AndroidRuntime'
```

Manual verification flow:

- Open the first roleplay session card from the sessions tab.
- Tap the composer to open the IME, then tap the message list area outside the composer.
- Confirm logcat prints `keyboard dismissed by outside tap ...`, the `EditText` focus drops, and the message list height expands back to the pre-IME state.
- Type a short message and tap send while the IME is open.
- Confirm logcat prints `auto scroll to latest after message append ...`, then confirm the new user bubble is still visible near the bottom after the assistant placeholder/error arrives.
- Check the latest role message bubble in the dump: the avatar bounds should start above or level with the bubble top, not align to the bubble bottom.

Notes:

- On long sessions the current model can still fail with `Input token ids are too long`; treat that as existing model/prompt pressure, not a regression in chat-page scrolling or layout.
- `uiautomator dump` is enough to verify avatar vertical placement quickly: compare the role avatar bounds with the adjacent bubble bounds in the latest message block.

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

## 2026-04-08 ST canonical schema migration notes

- Goal: stop treating SillyTavern cards as an app-private compatibility projection and persist the canonical ST card object as the source of truth.

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew.bat :app:compileDebugKotlin
.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.data.roleplay.interop.stcard.StV2CardParserTest" --tests "selfgemma.talk.domain.roleplay.usecase.StV2RoleCardInteropUseCaseTest" --tests "selfgemma.talk.domain.roleplay.usecase.PromptAssemblerTest" --tests "selfgemma.talk.domain.roleplay.usecase.StSampleCardsRegressionTest"
adb devices
adb install -r .\app\build\outputs\apk\debug\app-debug.apk
```

Notes:

- `cardCoreJson` should store the ST card object itself, not a flattened app-specific mirror. Keep app-level `summary/persona/world/openingLine` only as projections derived from the canonical ST structure.
- Runtime logic should read from `cardCore.data.*` first and only fall back to top-level mirrored fields where ST itself does so.
- Legacy/v1 import normalization should follow ST `convertToV2` semantics closely:
  - fill both top-level legacy mirrors and `data.*`
  - create `chat` with ST-style humanized timestamp
  - backfill `talkativeness/fav` into both legacy mirror and `data.extensions`
- When replacing the schema, update regression tests to build real ST card objects. Do not preserve old `RoleCardCore`-style test fixtures through compatibility shims, or the test suite will stop proving the migration.
- Real-device overwrite verification is still required after schema migrations, but if `adb devices` returns an empty list, capture that blocker explicitly rather than claiming install coverage.

## 2026-04-09 SAF import contract note

- One-shot import flows such as ST role-card import and chat-history import should use `ActivityResultContracts.GetContent`, not `OpenDocument`.
- In this app those imports read the selected file immediately and persist the parsed content, not the source `Uri`. Using `OpenDocument` there adds unnecessary SAF result complexity and can surface device-specific return-path noise during `DocumentsUI -> app` handoff.
- Keep `OpenDocument` / `OpenMultipleDocuments` only for flows that must retain long-lived read access to the picked `Uri`, such as avatar or gallery assets stored by reference.
- For Xiaomi/HyperOS real-device regression, a non-fatal `ActivityThread: fail in deliverResultsIfNeeded` log showed up when returning from a role-card import driven by `OpenDocument`; after changing one-shot import entry points to `GetContent`, rerun the same picker path before treating the issue as fixed.
- ST PNG imports with embedded avatars must not persist the original picker `content://` as the role avatar source of truth. After import/save/reopen, that transient grant can disappear and the editor will show a missing avatar. Persist the imported PNG into app-private storage and point `primaryAvatar` at that internal file instead.
- If the long-term goal is “app model is a superset of ST”, move `RoleCard` to `stCard + app extras` and demote `summary/persona/world/openingLine/tags` to projections. Keeping both as peer source-of-truth fields guarantees drift during import, editing, and export.
- The next drift point after moving `RoleCard` to `stCard + app extras` is the editor state. If the editor only edits projected fields and rebuilds `stCard` on save, it reintroduces schema drift immediately. Keep `RoleEditorUiState` holding the canonical `stCard` and update that object on each field edit.
## 2026-04-09 ST legacy and macro alignment note

- Legacy/v1 ST normalization must carry more than the six classic top-level fields. Cards in the wild also depend on top-level `system_prompt`, `post_history_instructions`, `alternate_greetings`, `character_book`, and `extensions`; dropping those makes import look successful while runtime semantics drift from ST.
- ST placeholder handling is runtime substitution, not import-time rewriting. Apply `{{user}}`, `{{char}}`, and related card-field macros when seeding `first_mes`, assembling prompt sections, and evaluating world info keys/content.
- Legacy placeholders `<USER>`, `<BOT>`, and `<CHAR>` should flow through the same substitution path. Converting them only at render time keeps stored card JSON intact while matching old-card ST behavior.
- After touching ST normalization or macro substitution, rerun:
  - `.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.domain.roleplay.usecase.CreateRoleplaySessionUseCaseTest" --tests "selfgemma.talk.domain.roleplay.usecase.PromptAssemblerTest" --tests "selfgemma.talk.domain.roleplay.usecase.StRoleCardDocumentInteropUseCaseTest" --tests "selfgemma.talk.domain.roleplay.usecase.StSampleCardsRegressionTest" --no-daemon`

## 2026-04-09 ST world-info runtime note

- `character_book` 对齐不能只停在 `enabled + position + keyword contains`。要把扫描阶段和插入阶段拆开实现，否则一旦补 `recursive_scanning`、`group`、`sticky/cooldown`，代码会直接缠死在 `PromptAssembler` 里。
- 这个仓库当前最合适的 ST timed world-info 状态存放点是 `Session.interopChatMetadataJson`。它已经随会话持久化，也不会污染角色卡本身；把 `timedWorldInfo` 放进这里，比新加一套 session 表字段更便于继续兼容 ST chat metadata。
- `sticky/cooldown` 的判定依赖“聊天条数前进”。如果第二次装配 prompt 时 chat 长度没有增长，ST 会把未受保护的 timed effect 移除，所以回归测试必须构造“会话已前进”的消息序列，不能只重复同一条消息。
- `token_budget` 在当前实现里最稳定的近似方式是直接对 lore content 做 token 估算并限制激活条目。测试预算边界时不要按“词数”估，当前 `TokenEstimator` 是按 `normalized.length / 4` 近似。
- `outlet` 在本项目里还没有 ST 那套 extension prompt outlet 基建时，至少要把内容显式挂到 prompt 中并保留 outlet 名称，避免解析到了却静默丢失。

## 2026-04-09 ST world-info runtime note

- The app now has a dedicated [`StCharacterBookRuntime`](D:/gallery/Android/src/app/src/main/java/selfgemma/talk/domain/roleplay/usecase/StCharacterBookRuntime.kt) path instead of burying all world-info logic inside `PromptAssembler`. Continue extending ST world-info semantics there, then keep `PromptAssembler` focused on prompt layout.
- `sticky`, `cooldown`, and related ST world-info timed effects need session-level persistence. In this app the least invasive place is `Session.interopChatMetadataJson`; update it during prompt assembly so the next turn sees the timed world-info state.
- `transformDebugUnitTestClassesWithAsm` is still an intermittent Gradle infrastructure failure in this workspace. If targeted roleplay tests compile and run but a broader unit-test invocation dies there with `NoSuchFileException ... transformDebugUnitTestClassesWithAsm`, treat it as a build-pipeline issue unless a focused test also fails.
- Useful verification split for ST world-info work:
  - semantic regression: `.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.domain.roleplay.usecase.PromptAssemblerTest" --tests "selfgemma.talk.domain.roleplay.usecase.StSampleCardsRegressionTest" --tests "selfgemma.talk.domain.roleplay.usecase.CreateRoleplaySessionUseCaseTest" --no-daemon`
  - installable product check: `.\gradlew.bat :app:assembleDebug --no-daemon`
- Remaining ST world-info parity work tends to hide in non-obvious fields, not the main key/content path. Prioritize checking `character_filter`, leading-content decorators like `@@activate` / `@@dont_activate`, inclusion-group scoring, and outlet naming before assuming a card is fully aligned.
- In this app's single-character roleplay flow, `character_filter` can only be approximated against the active role name and role tags. ST has richer filtering through its character file/tag map, so keep this limitation explicit when reviewing parity claims.

## 2026-04-09 ST trigger alignment note

- ST world-info `extensions.triggers` is not just a preserved field. If runtime ignores it, cards that rely on `normal` / `quiet` / `continue` separation will silently over-activate lore entries.
- In this app, wire generation-type filtering through prompt assembly explicitly instead of leaving it implicit in UI state. Default to `normal` for standard send-message turns until more ST generation modes are added.
- After touching trigger filtering, rerun:
  - `.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.domain.roleplay.usecase.PromptAssemblerTest" --tests "selfgemma.talk.domain.roleplay.usecase.StSampleCardsRegressionTest" --no-daemon`

## 2026-04-09 ST timed/group note

- `timedWorldInfo` compatibility is not only about persisting some JSON. ST keys timed entries by lore entry uid, so local runtime should read id-keyed metadata in addition to any app-specific fallback key, or imported ST chats will lose sticky/cooldown state.
- Group scoring must use the current scan's actual match score, not the number of configured keys on the entry. Otherwise inclusion groups drift exactly on the cards that depend on overlapping keyword sets.
- `atDepth` entries should be merged by `(depth, role)` before prompt assembly. Emitting one block per lore row preserves data but still changes ST ordering and injection shape.

## 2026-04-09 ST scan-depth note

- ST `min activations` is a separate scan phase, not just more recursion. When the runtime deepens scanning to satisfy minimum activations, it should increase chat depth without pulling in the recursion buffer.
- Lore activation should scan ST-style sources only: recent chat plus explicitly opted-in character fields. App-local session summaries and memory items are useful prompt context, but they should not secretly participate in ST world-info keyword activation.
- If `max_recursion_steps` is present in ST world-info settings, enforce it as a hard cap on evaluation loops. Otherwise a rolebook that chains recursive activations can still drift from ST even when individual entry semantics look correct.
- When focused unit tests suddenly fail in `:app:kaptGenerateStubsDebugUnitTestKotlin` with `lookups.tab is already registered` or `Could not delete ... caches-jvm`, treat it as the known Kotlin/KAPT cache lock issue in this workspace. The fastest recovery path here is:
  - `.\gradlew.bat --stop`
  - delete `app\build\kotlin\kaptGenerateStubsDebugUnitTestKotlin\cacheable\caches-jvm`
  - rerun the focused test command

## 2026-04-09 ST-first chat runtime note

- If the product definition is "ST chat layer integrated natively", the chat pipeline should not read app projection fields directly. Build a dedicated ST runtime role/session object first, then let opener seeding, macro substitution, prompt assembly, and chat export all consume that same object.
- `RoleCard` can keep app-level policy and media fields, but ST chat semantics should resolve from `StChatRuntimeRole(card=stCard, ...)` plus session-side ST metadata/trigger state. This avoids drifting back to mixed source-of-truth behavior as the app evolves.

## 2026-04-09 Android regex note

- Android's regex engine is less forgiving than the desktop/JVM path for malformed escaped braces. For ST macro matching, use `\{\{ ... \}\}` explicitly on both sides; leaving the trailing `}}` unescaped can pass some local checks but crash at class initialization on device with `PatternSyntaxException`.
- When a roleplay action crashes immediately on tap before any repository or network work, always grab `AndroidRuntime` first. In this case the failure surfaced as `ExceptionInInitializerError` on `StMacroSubstitutionKt.<clinit>`, which pointed straight to a bad top-level `Regex(...)` initializer rather than session creation logic.

## 2026-04-09 LiteRT imported CPU cache note

- If chat-page entry dies 1-2 seconds later with `APP CRASH(NATIVE)` and the tombstone points at `com.google.ai.edge.litertlm.Engine.initialize` / `liblitertlm_jni.so`, inspect whether an imported CPU model already has a sibling `*.xnnpack_cache` file.
- On this workspace/device, `gemma-4-E4B-it.litertlm` crashed only when LiteRT-LM loaded an existing imported CPU XNNPACK cache; deleting the sidecar cache let the same chat/session open and rebuild the cache successfully.
- The app-side mitigation is to purge `modelPath + ".xnnpack_cache"` before `Engine.initialize()` for imported CPU models. Do not rely on Java exception handling here; this failure is native `SIGABRT`, so the only safe fix is to prevent the bad cache from reaching native init at all.

## 2026-04-09 Roleplay context-budget refactor note

- When refactoring prompt assembly for small-context on-device models, keep validation split into two layers:
  - compile check: `.\gradlew.bat :app:compileDebugKotlin`
  - focused unit tests: `.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.domain.roleplay.usecase.PromptAssemblerTest" --tests "selfgemma.talk.domain.roleplay.usecase.ContextBudgetPlannerTest" --tests "selfgemma.talk.domain.roleplay.model.ModelContextProfileTest" --tests "selfgemma.talk.domain.roleplay.usecase.CompileRuntimeRoleProfileUseCaseTest"`
- In this workspace the Gradle wrapper lives under `D:\gallery\Android\src`, not `D:\gallery` or `D:\gallery\Android`. If PowerShell says `gradlew.bat` is not recognized, check the working directory before treating it as a build failure.
- `PromptAssembler` regressions after a budget-layer refactor are often macro-substitution regressions rather than budget math errors. If old prompt tests suddenly fail on `{{user}}` / `{{char}}`, inspect whether the new material-builder stage still applies `StMacroContext.substitute(...)` before budgeting.
- Keep the ST runtime split explicit:
  - `StCharacterBookRuntime` decides activation and `chat_metadata`
  - the budget planner only decides what activated text survives into the final prompt
- If the budget planner tests are flaky, the usual cause is test budgets that are not tight enough to force compaction. Lower `usableInputTokens` in the test profile until the intended degradation path is actually exercised.
- Input-overflow recovery on this app needs to cover both `resetConversation(...)` and `runInference(...)`. With the current rough token estimator, a prompt can pass preflight but still fail at runtime; only handling inference errors leaves a real gap for small 4k models.
- For observability, don't stop at `Log.d/w`. Roleplay send-message turns already have `SessionEvent`; use it for prompt compaction and overflow recovery so one problematic session can be diagnosed without digging through transient device logs.
- `LlmChatModelHelper.resetConversation(...)` now rethrows after logging. Any built-in task that calls it directly, such as `llmsingleturn`, `tinygarden`, or `mobileactions`, must catch reset failures explicitly or the old silent-reset failure will become a broken send flow.
- For generic `llmchat`, the safer small-context path is "rebuild from UI history each turn" rather than trusting LiteRT conversation state to carry unbounded history. Validate that path with:
  - `.\gradlew.bat :app:testDebugUnitTest --tests "selfgemma.talk.ui.llmchat.LlmChatModelHelperTest" --tests "selfgemma.talk.ui.llmchat.LlmChatContextManagerTest" --tests "selfgemma.talk.ui.llmchat.LlmChatOverflowRecoveryTest"`
  - `.\gradlew.bat :app:assembleDebug`
- `llmchat` cannot keep relying on LiteRT conversation as the only source of history. For small on-device windows, rebuild each turn from `system prompt + compressed history + current input`, otherwise the visible UI history and the hidden runtime conversation drift until `error code 3` appears with no recovery path.
- `LlmChatModelHelper.resetConversation()` must surface failures upward. If helper code swallows the exception, every upper-layer overflow retry path becomes fake and reset-time overflows silently bypass the budget manager.
- Shared overflow detection belongs in one runtime utility, not duplicated string matching in each feature module. Once that helper exists, normalize raw overflow messages before showing them to users so a failed final retry does not expose `error code 3` directly.
- For `llmchat` reset flows, never leave `resetConversation()` inside an unbounded retry loop. A persistent bad system prompt or other deterministic reset-time failure will pin `isResettingSession` forever and hide the real error from the user.
- History compaction only helps when overflow comes from prompt/history sections. If the current turn by itself already consumes the usable input budget, fail fast and surface a normalized message instead of pretending a smaller history can make the request fit.
- `resetConversation()` must not close the old LiteRT conversation before the replacement is created successfully. If creation fails after closing the old conversation, upper layers may surface a friendly error while the runtime is already stranded on a dead session.
- When `llmchat` rebuilds conversation state every turn, preserve the last successful session config, not just the visible UI prompt. Tool lists, constrained-decoding flags, and any expanded system prompt layers such as skill-injected instructions have to survive the rebuild path.
- The per-turn budgeted prompt is runtime-only material. Do not persist it back as the session's base system prompt, or the next turn will treat compressed history as part of the permanent instruction set and recursively summarize a summary.
- Budget planners for 4k-class on-device models need a final invariant check on the fully assembled prompt, not only on section budgets. Header text and first-line allowances can otherwise push the final prompt back over the available token budget.
- If LiteRT engine init succeeds but conversation creation fails, close the engine in the same error path. Otherwise the failure never reaches normal cleanup because `model.instance` was never assigned, and native resources leak across retries.

## 2026-04-10 Role editor field-help and counter note

- For role-editor text inputs, centralize counters in one shared composable instead of attaching per-field helper labels. This keeps `Card`, `Prompt`, `Lorebook`, and metadata inputs visually consistent and avoids missing nested lore-entry fields.
- On-device role editing benefits from showing editor budgets even when they are not yet hard save-time validators. A red `current/max` counter is enough to surface prompt-pressure risk without breaking imported cards that already exceed the suggested budget.
- Detailed field help should explain four things, not just one sentence: what the field does, what happens if it is empty or disabled, what value ranges mean, and what content/length is recommended for a 4k-class local model.
- The help dialog body can outgrow `AlertDialog` quickly once field docs become useful. Make the dialog text area scrollable, or long multi-paragraph help will clip on smaller phones.
- Add explicit logs for `help opened` and `field exceeds budget` in the role editor. These two events are enough to diagnose whether users are discovering the guidance and which fields most often drift beyond the intended editor budgets.

## 2026-04-10 Role editor text-field clipping note

- For the role-name input, the real bottleneck was total control height, not the tab/header typography. The previous `64dp` cap had to hold both the outlined field and the `5/120` counter, which left roughly `48dp` of editable content height on this device.
- Single-line role-editor fields should reserve at least `80dp` total height when a supporting counter is shown. That keeps the normal `56dp` outlined container plus the supporting text line from competing for the same vertical budget.
- `PlatformTextStyle(includeFontPadding = true)` should stay on the text-field input text itself, but it is not sufficient alone if the field height is capped too tightly.
- When verifying OEM-font clipping, always compare the exact failing `EditText` bounds from `uiautomator dump` with the rendered screenshot. Header text, tab text, and text-field text have different layout paths and should be debugged separately.
