# PR 0 迁移清单：selfgemma.talk 新包隔离

## 目标

这份清单只服务一个目标：在功能开发前，把当前 Android 工程从原 `Google AI Edge Gallery` 身份中切出来，形成独立的 `selfgemma.talk` 产品包。

这不是“顺手改一下包名”，而是一轮完整的应用身份迁移。完成后，新包必须能与原版并装，且不会共享外部配置入口、深链入口、通知标识或本地文件命名。

## 1. 目标身份矩阵

| 项 | 目标值 |
| --- | --- |
| namespace | `selfgemma.talk` |
| applicationId | `selfgemma.talk` |
| deep link scheme | `selfgemma.talk` |
| oauth redirect scheme | `selfgemma.talk.auth` |
| app display name | `SelfGemma Talk` |
| storage prefix | `selfgemma_talk` |
| db name | `selfgemma_talk.db` |
| imports dir | `__selfgemma_talk_imports` |
| allowlist cache | `selfgemma_talk_model_allowlist.json` |
| high priority channel | `selfgemma_talk_high_priority_channel` |
| download channel | `selfgemma_talk_download_notification` |

## 2. 必改文件清单

### 2.1 构建与 Manifest

#### [Android/src/app/build.gradle.kts](Android/src/app/build.gradle.kts)

修改项：

- `namespace = "com.google.ai.edge.gallery"` 改为 `namespace = "selfgemma.talk"`
- `applicationId = "com.google.aiedge.gallery"` 改为 `applicationId = "selfgemma.talk"`
- `manifestPlaceholders["appAuthRedirectScheme"]` 改为 `selfgemma.talk.auth`
- `manifestPlaceholders["applicationName"]` 改为 `selfgemma.talk.SelfGemmaTalkApplication`
- 如果后续禁用 Firebase，记录对应依赖与 plugin 的处理方案

#### [Android/src/app/src/main/AndroidManifest.xml](Android/src/app/src/main/AndroidManifest.xml)

修改项：

- `package="com.google.ai.edge.gallery"` 改为 `package="selfgemma.talk"` 或删除该属性并依赖 namespace
- `android:label="Edge Gallery"` 改为 `@string/app_name`
- `android:name="com.google.ai.edge.gallery.MainActivity"` 改为 `selfgemma.talk.MainActivity`
- deep link scheme 从 `com.google.ai.edge.gallery` 改为 `selfgemma.talk`
- `GalleryFcmMessagingService` 改为 `SelfGemmaTalkFcmMessagingService`
- `com.google.firebase.messaging.default_notification_channel_id` 的值改为 `selfgemma_talk_high_priority_channel`
- FileProvider authority 继续使用 `${applicationId}.provider`，但要验证并装场景

### 2.2 应用入口类

#### [Android/src/app/src/main/java/com/google/ai/edge/gallery/GalleryApplication.kt](Android/src/app/src/main/java/com/google/ai/edge/gallery/GalleryApplication.kt)

建议动作：

- 文件重命名为 `SelfGemmaTalkApplication.kt`
- 类名改为 `SelfGemmaTalkApplication`
- package 改为 `selfgemma.talk`
- 若 PR 0 决定移除 Firebase，则删掉 `FirebaseApp.initializeApp(this)`
- 若保留 Firebase，则保留初始化但改为新工程配置

#### [Android/src/app/src/main/java/com/google/ai/edge/gallery/MainActivity.kt](Android/src/app/src/main/java/com/google/ai/edge/gallery/MainActivity.kt)

建议动作：

- package 改为 `selfgemma.talk`
- 检查所有 analytics / app 名 / nav 入口相关导入是否仍指向旧包

#### [Android/src/app/src/main/java/com/google/ai/edge/gallery/GalleryApp.kt](Android/src/app/src/main/java/com/google/ai/edge/gallery/GalleryApp.kt)

建议动作：

- package 改为 `selfgemma.talk`
- 可选：类名改为 `SelfGemmaTalkApp`

### 2.3 推送、通知与下载

#### [Android/src/app/src/main/java/com/google/ai/edge/gallery/FcmMessagingService.kt](Android/src/app/src/main/java/com/google/ai/edge/gallery/FcmMessagingService.kt)

建议动作：

- 文件重命名为 `SelfGemmaTalkFcmMessagingService.kt`
- 类名改为 `SelfGemmaTalkFcmMessagingService`
- package 改为 `selfgemma.talk`
- `channelId = "gallery_high_priority_push_channel"` 改为 `selfgemma_talk_high_priority_channel`
- 通知标题字符串改成新产品文案
- 如果 PR 0 决定移除 Firebase，则整文件和 Manifest service 一并移除

#### [Android/src/app/src/main/java/com/google/ai/edge/gallery/data/DownloadRepository.kt](Android/src/app/src/main/java/com/google/ai/edge/gallery/data/DownloadRepository.kt)

修改项：

- `channelId = "download_notification"` 改为 `selfgemma_talk_download_notification`
- `channelName = "AI Edge Gallery download notification"` 改为 `SelfGemma Talk download notification`
- 所有 deep link `com.google.ai.edge.gallery://...` 改为 `selfgemma.talk://...`

#### [Android/src/app/src/main/java/com/google/ai/edge/gallery/worker/DownloadWorker.kt](Android/src/app/src/main/java/com/google/ai/edge/gallery/worker/DownloadWorker.kt)

修改项：

- `Class.forName("com.google.ai.edge.gallery.MainActivity")` 改为 `Class.forName("selfgemma.talk.MainActivity")`
- 更稳妥的做法：不要再用硬编码反射类名，直接改成对新 `MainActivity::class.java` 的显式引用

### 2.4 本地存储命名

#### [Android/src/app/src/main/java/com/google/ai/edge/gallery/di/AppModule.kt](Android/src/app/src/main/java/com/google/ai/edge/gallery/di/AppModule.kt)

修改项：

- `settings.pb` 改为 `selfgemma_talk_settings.pb`
- `cutouts.pb` 改为 `selfgemma_talk_cutouts.pb`
- `user_data.pb` 改为 `selfgemma_talk_user_data.pb`
- `benchmark_results.pb` 改为 `selfgemma_talk_benchmark_results.pb`
- `skills.pb` 改为 `selfgemma_talk_skills.pb`
- package 与 import 全部同步到新根包

#### [Android/src/app/src/main/java/com/google/ai/edge/gallery/data/Model.kt](Android/src/app/src/main/java/com/google/ai/edge/gallery/data/Model.kt)

修改项：

- `IMPORTS_DIR = "__imports"` 改为 `IMPORTS_DIR = "__selfgemma_talk_imports"`

#### [Android/src/app/src/main/java/com/google/ai/edge/gallery/ui/modelmanager/ModelManagerViewModel.kt](Android/src/app/src/main/java/com/google/ai/edge/gallery/ui/modelmanager/ModelManagerViewModel.kt)

修改项：

- `MODEL_ALLOWLIST_FILENAME = "model_allowlist.json"` 改为 `selfgemma_talk_model_allowlist.json`
- 所有 `IMPORTS_DIR` 相关路径随常量同步更新

#### 新增数据库命名约束

如果 PR 0 同时引入 roleplay 数据库，则数据库文件名直接固定为：

- `selfgemma_talk.db`

### 2.5 proto 与生成代码命名

#### [Android/src/app/src/main/proto/settings.proto](Android/src/app/src/main/proto/settings.proto)
#### [Android/src/app/src/main/proto/skill.proto](Android/src/app/src/main/proto/skill.proto)
#### [Android/src/app/src/main/proto/benchmark.proto](Android/src/app/src/main/proto/benchmark.proto)

修改项：

- `package com.google.ai.edge.gallery.proto;` 改为 `package selfgemma.talk.proto;`
- `option java_package = "com.google.ai.edge.gallery.proto";` 改为 `option java_package = "selfgemma.talk.proto";`

注意事项：

- 这是高影响改动，会牵引大量 import 变化
- 如果 PR 0 不想同时做 proto 包迁移，最少也要先做 app 包名、Manifest、外部标识和文件命名隔离
- 但从长期一致性来看，proto java_package 最终也应迁移到新包体系

### 2.6 文案与对外品牌

#### [Android/src/app/src/main/res/values/strings.xml](Android/src/app/src/main/res/values/strings.xml)

建议优先替换的字符串：

- `app_name` -> `SelfGemma Talk`
- `app_name_first_part` -> `SelfGemma`
- `app_name_second_part` -> `Talk`
- `gallery_news_notification_title` -> `SelfGemma Talk News` 或直接移除该能力
- `tos_dialog_title_app` 中的 `Google AI Edge Gallery` -> `SelfGemma Talk`

#### [Android/src/app/src/main/java/com/google/ai/edge/gallery/ui/home/HomeScreen.kt](Android/src/app/src/main/java/com/google/ai/edge/gallery/ui/home/HomeScreen.kt)

修改项：

- 检查硬编码 `AI Edge Gallery` / `Edge Gallery` 文本并替换

#### [Android/src/app/src/main/java/com/google/ai/edge/gallery/ui/common/tos/GemmaTermsOfUseDialog.kt](Android/src/app/src/main/java/com/google/ai/edge/gallery/ui/common/tos/GemmaTermsOfUseDialog.kt)

修改项：

- 文案 `Gemma models on the Google AI Edge Gallery app...` 改为 `Gemma models on the SelfGemma Talk app...`

### 2.7 Firebase 与 analytics

#### [Android/src/app/src/main/java/com/google/ai/edge/gallery/Analytics.kt](Android/src/app/src/main/java/com/google/ai/edge/gallery/Analytics.kt)

修改项：

- package 改到新根包
- 如果保留 Firebase，则继续使用但切到新 Firebase 工程
- 如果 PR 0 决定去 Firebase，则这里应变成空实现或删除所有 analytics 入口

建议：

- PR 0 直接决定 Firebase 策略，不要拖到功能开发阶段

## 3. 推荐提交顺序

### Step 1

先改构建标识：

- `build.gradle.kts`
- `AndroidManifest.xml`
- `strings.xml`

### Step 2

再改入口类和反射类名：

- `GalleryApplication.kt`
- `MainActivity.kt`
- `FcmMessagingService.kt`
- `DownloadWorker.kt`

### Step 3

再改本地存储命名：

- `AppModule.kt`
- `Model.kt`
- `ModelManagerViewModel.kt`

### Step 4

最后决定是否同时迁移 proto 包与 Firebase：

- `settings.proto`
- `skill.proto`
- `benchmark.proto`
- `Analytics.kt`

## 4. 推荐搜索命令

PR 0 完成前，至少要跑一轮全局搜索，确保没有明显残留：

```text
com.google.ai.edge.gallery
com.google.aiedge.gallery
Edge Gallery
AI Edge Gallery
gallery_high_priority_push_channel
download_notification
model_allowlist.json
__imports
settings.pb
user_data.pb
skills.pb
benchmark_results.pb
cutouts.pb
```

## 5. 合并前验收

合并 PR 0 前必须验证：

1. 新 app 可以和原 app 同时安装。
2. 新包的图标、应用名、通知和 deeplink 都不会再显示或命中旧产品。
3. 本地 DataStore、数据库、allowlist 缓存和 imports 目录全部改成 `selfgemma_talk` 前缀。
4. 如果没有配置新 Firebase，应用也不会因为 Firebase 初始化或 Manifest 节点而崩溃。
5. `Class.forName`、Manifest 类名和 provider authority 不再引用旧包。

## 6. PR 0 后的进入条件

只有 PR 0 完成后，才建议开始：

- Room 持久化层
- roleplay 新导航
- 会话与角色仓储
- 新聊天页与发送链路

否则后续开发会一边写功能一边返工标识层。