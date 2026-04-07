# ST 兼容实现拆分清单

## 1. 基线原则

1. 每个文件只承担单一职责。
2. 解析、映射、持久化、UI、运行时拼装分层实现。
3. 兼容逻辑优先放在 `interop` 包，不散落到业务代码各处。
4. 新增能力时优先扩展 canonical schema，不直接扩展旧 `RoleCard`。

## 2. 推荐文件上限

建议作为重构时的软约束：

1. parser / mapper / serializer 单文件控制在 200 行左右。
2. ViewModel 单文件控制在 300 行左右。
3. Compose Screen 单文件控制在 250 行左右。
4. 超过上限时优先拆 section、state、event handler。

## 3. 角色卡实现清单

### 3.1 领域模型

- [ ] `CardCoreModels.kt`
- [ ] `CardInteropModels.kt`
- [ ] `CharacterBookModels.kt`
- [ ] `RuntimeProfileModels.kt`

### 3.2 导入解析

- [ ] `StCardJsonParser.kt`
- [ ] `StCardPngParser.kt`
- [ ] `StCardSpecDetector.kt`
- [ ] `StCardValidator.kt`

### 3.3 归一映射

- [ ] `ImportedCardNormalizer.kt`
- [ ] `LegacyRoleToCoreMapper.kt`
- [ ] `CoreToLegacyPromptMapper.kt`

### 3.4 导出

- [ ] `StCardJsonSerializer.kt`
- [ ] `StCardPngSerializer.kt`
- [ ] `StCardExportFacade.kt`

## 4. 聊天记录实现清单

### 4.1 领域模型

- [ ] `ChatInteropModels.kt`
- [ ] `MessageVariantModels.kt`
- [ ] `ChatMetadataModels.kt`

### 4.2 导入解析

- [ ] `StChatJsonlParser.kt`
- [ ] `StChatValidator.kt`
- [ ] `ImportedChatNormalizer.kt`

### 4.3 导出

- [ ] `StChatJsonlSerializer.kt`
- [ ] `StChatExportFacade.kt`

## 5. 数据层清单

- [ ] `RoleInteropEntityPayloads.kt`
- [ ] `RoleInteropJsonConverters.kt`
- [ ] `RoleMigrationMapper.kt`
- [ ] `RoleInteropRepository.kt`

## 6. UI 清单

### 6.1 编辑页状态

- [ ] `RoleEditorUiState.kt`
- [ ] `RoleEditorEvents.kt`
- [ ] `RoleEditorFieldState.kt`

### 6.2 编辑页 section

- [ ] `RoleBasicSection.kt`
- [ ] `RoleStCardSection.kt`
- [ ] `RoleKnowledgeSection.kt`
- [ ] `RoleRuntimeSection.kt`
- [ ] `RoleInteropSection.kt`

### 6.3 导入导出

- [ ] `RoleImportExportViewModel.kt`
- [ ] `RoleImportExportSection.kt`

## 7. Prompt 层清单

- [ ] `PromptInput.kt`
- [ ] `PromptInstructionAssembler.kt`
- [ ] `PromptLoreAssembler.kt`
- [ ] `PromptMemoryAssembler.kt`
- [ ] `PromptHistoryAssembler.kt`
- [ ] `PromptAssembler.kt` 仅做 orchestrator

## 8. 测试清单

### 8.1 单元测试

- [ ] v1 -> canonical
- [ ] v2 -> canonical
- [ ] v3 -> canonical
- [ ] canonical -> v2 json
- [ ] png metadata read/write
- [ ] st jsonl parse/serialize
- [ ] legacy role migration

### 8.2 集成测试

- [ ] 导入 ST 卡后进入编辑页字段正确
- [ ] 导出后可被 ST 再次导入
- [ ] 导入 ST jsonl 后聊天顺序、swipes、hidden message 不丢

## 9. 提交策略

建议按以下小主题独立提交：

1. canonical schema 与 interop model
2. role db migration
3. card import parser
4. card export serializer
5. chat import/export
6. editor UI refactor
7. prompt assembler refactor
8. logging / diagnostics

每个主题提交后都补对应日志与验证记录，避免后续回滚困难。
