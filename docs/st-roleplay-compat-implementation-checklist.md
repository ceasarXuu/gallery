# ST 鍏煎瀹炵幇鎷嗗垎娓呭崟

## 1. 鍩虹嚎鍘熷垯

1. 姣忎釜鏂囦欢鍙壙鎷呭崟涓€鑱岃矗銆?2. 瑙ｆ瀽銆佹槧灏勩€佹寔涔呭寲銆乁I銆佽繍琛屾椂鎷艰鍒嗗眰瀹炵幇銆?3. 鍏煎閫昏緫浼樺厛鏀惧湪 `interop` 鍖咃紝涓嶆暎钀藉埌涓氬姟浠ｇ爜鍚勫銆?4. 鏂板鑳藉姏鏃朵紭鍏堟墿灞?canonical schema锛屼笉鐩存帴鎵╁睍鏃?`RoleCard`銆?
## 1.1 褰撳墠杩涘害

- [x] `RoleplayInteropModels.kt`
- [x] `RoleplayInteropJsonCodec.kt`
- [x] `RoleplayRoleInteropMappers.kt`
- [x] `RoleEntity` 澧炲姞 interop JSON 鎵胯浇鍒?- [x] `RoleCard` 澧炲姞 canonical/interop/runtime 鎵胯浇瀛楁
- [x] `RoleplayDatabase` 鍗囩骇鍒?`version = 2`
- [x] 鏈湴鎵ц `:app:compileDebugKotlin`

## 2. 鎺ㄨ崘鏂囦欢涓婇檺

寤鸿浣滀负閲嶆瀯鏃剁殑杞害鏉燂細

1. parser / mapper / serializer 鍗曟枃浠舵帶鍒跺湪 200 琛屽乏鍙炽€?2. ViewModel 鍗曟枃浠舵帶鍒跺湪 300 琛屽乏鍙炽€?3. Compose Screen 鍗曟枃浠舵帶鍒跺湪 250 琛屽乏鍙炽€?4. 瓒呰繃涓婇檺鏃朵紭鍏堟媶 section銆乻tate銆乪vent handler銆?
## 3. 瑙掕壊鍗″疄鐜版竻鍗?
### 3.1 棰嗗煙妯″瀷

- [x] `CardCoreModels.kt`
- [x] `CardInteropModels.kt`
- [ ] `CharacterBookModels.kt`
- [x] `RuntimeProfileModels.kt`

### 3.2 瀵煎叆瑙ｆ瀽

- [x] `StCardJsonParser.kt`
- [ ] `StCardPngParser.kt`
- [ ] `StCardSpecDetector.kt`
- [ ] `StCardValidator.kt`

### 3.3 褰掍竴鏄犲皠

- [x] `ImportedCardNormalizer.kt`
- [x] `LegacyRoleToCoreMapper.kt`
- [ ] `CoreToLegacyPromptMapper.kt`

### 3.4 瀵煎嚭

- [x] `StCardJsonSerializer.kt`
- [ ] `StCardPngSerializer.kt`
- [ ] `StCardExportFacade.kt`

## 4. 鑱婂ぉ璁板綍瀹炵幇娓呭崟

### 4.1 棰嗗煙妯″瀷

- [ ] `ChatInteropModels.kt`
- [ ] `MessageVariantModels.kt`
- [ ] `ChatMetadataModels.kt`

### 4.2 瀵煎叆瑙ｆ瀽

- [ ] `StChatJsonlParser.kt`
- [ ] `StChatValidator.kt`
- [ ] `ImportedChatNormalizer.kt`

### 4.3 瀵煎嚭

- [ ] `StChatJsonlSerializer.kt`
- [ ] `StChatExportFacade.kt`

## 5. 鏁版嵁灞傛竻鍗?
- [ ] `RoleInteropEntityPayloads.kt`
- [ ] `RoleInteropJsonConverters.kt`
- [x] `RoleMigrationMapper.kt`
- [ ] `RoleInteropRepository.kt`

## 6. UI 娓呭崟

### 6.1 缂栬緫椤电姸鎬?
- [ ] `RoleEditorUiState.kt`
- [ ] `RoleEditorEvents.kt`
- [ ] `RoleEditorFieldState.kt`

### 6.2 缂栬緫椤?section

- [ ] `RoleBasicSection.kt`
- [ ] `RoleStCardSection.kt`
- [ ] `RoleKnowledgeSection.kt`
- [ ] `RoleRuntimeSection.kt`
- [ ] `RoleInteropSection.kt`

### 6.3 瀵煎叆瀵煎嚭

- [ ] `RoleImportExportViewModel.kt`
- [ ] `RoleImportExportSection.kt`

## 7. Prompt 灞傛竻鍗?
- [ ] `PromptInput.kt`
- [ ] `PromptInstructionAssembler.kt`
- [ ] `PromptLoreAssembler.kt`
- [ ] `PromptMemoryAssembler.kt`
- [ ] `PromptHistoryAssembler.kt`
- [ ] `PromptAssembler.kt` 浠呭仛 orchestrator

## 8. 娴嬭瘯娓呭崟

### 8.1 鍗曞厓娴嬭瘯

- [ ] v1 -> canonical
- [x] v2 -> canonical
- [ ] v3 -> canonical
- [x] canonical -> v2 json
- [ ] png metadata read/write
- [ ] st jsonl parse/serialize
- [ ] legacy role migration

### 8.2 闆嗘垚娴嬭瘯

- [ ] 瀵煎叆 ST 鍗″悗杩涘叆缂栬緫椤靛瓧娈垫纭?- [ ] 瀵煎嚭鍚庡彲琚?ST 鍐嶆瀵煎叆
- [ ] 瀵煎叆 ST jsonl 鍚庤亰澶╅『搴忋€乻wipes銆乭idden message 涓嶄涪

## 9. 鎻愪氦绛栫暐

寤鸿鎸変互涓嬪皬涓婚鐙珛鎻愪氦锛?
1. canonical schema 涓?interop model
2. role db migration
3. card import parser
4. card export serializer
5. chat import/export
6. editor UI refactor
7. prompt assembler refactor
8. logging / diagnostics

姣忎釜涓婚鎻愪氦鍚庨兘琛ュ搴旀棩蹇椾笌楠岃瘉璁板綍锛岄伩鍏嶅悗缁洖婊氬洶闅俱€?
