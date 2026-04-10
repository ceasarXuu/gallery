## 2026-04-11 Messages tab FAB removal verification note

- Goal: verify a messages-tab-only UI cleanup that removes the redundant bottom-right `+` floating action button without changing session list behavior.

Reusable commands:

```powershell
Set-Location D:\gallery\Android\src
.\gradlew.bat :app:compileDebugKotlin
```

Notes:

- For a Compose-only chrome change that does not alter strings, navigation routes, or persistence, run `:app:compileDebugKotlin` first. It is the fastest regression gate for removed imports, stale composables, and scaffold slot changes.
- If the button being removed is injected by a parent `Scaffold`, verify the page-level screen first before editing the child list screen. In this codebase the messages tab FAB lived in `MainTabScreen`, not in the `SessionsScreen` content tree used by the tab body.
