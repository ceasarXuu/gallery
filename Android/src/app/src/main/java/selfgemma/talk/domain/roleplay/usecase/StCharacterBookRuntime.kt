package selfgemma.talk.domain.roleplay.usecase

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.util.UUID
import kotlin.math.roundToInt
import kotlin.random.Random
import selfgemma.talk.domain.roleplay.model.StCharacterBook
import selfgemma.talk.domain.roleplay.model.StCharacterBookEntry

internal data class StWorldScanContext(
  val recentMessagesNewestFirst: List<String>,
  val personaDescription: String,
  val characterDescription: String,
  val characterPersonality: String,
  val characterDepthPrompt: String,
  val scenario: String,
  val creatorNotes: String,
  val sessionSummary: String,
  val memories: List<String>,
)

internal data class StRuntimeDepthPromptInsertion(
  val prompt: String,
  val depth: Int,
  val role: String,
)

data class PromptAssemblyResult(
  val prompt: String,
  val updatedChatMetadataJson: String? = null,
)

internal data class StResolvedPromptRuntime(
  val beforePrompt: String = "",
  val afterPrompt: String = "",
  val authorNoteBefore: List<String> = emptyList(),
  val authorNoteAfter: List<String> = emptyList(),
  val exampleBefore: List<String> = emptyList(),
  val exampleAfter: List<String> = emptyList(),
  val depthPrompts: List<StRuntimeDepthPromptInsertion> = emptyList(),
  val outletEntries: Map<String, List<String>> = emptyMap(),
  val updatedChatMetadataJson: String? = null,
)

internal data class StBookEntryRuntimeExtensions(
  val position: Int? = null,
  val depth: Int? = null,
  val role: Int? = null,
  val selectiveLogic: StSelectiveLogic = StSelectiveLogic.AND_ANY,
  val scanDepth: Int? = null,
  val caseSensitive: Boolean? = null,
  val matchWholeWords: Boolean? = null,
  val matchPersonaDescription: Boolean = false,
  val matchCharacterDescription: Boolean = false,
  val matchCharacterPersonality: Boolean = false,
  val matchCharacterDepthPrompt: Boolean = false,
  val matchScenario: Boolean = false,
  val matchCreatorNotes: Boolean = false,
  val useRegex: Boolean = false,
  val preventRecursion: Boolean = false,
  val excludeRecursion: Boolean = false,
  val delayUntilRecursion: Int = 0,
  val probability: Int = 100,
  val useProbability: Boolean = true,
  val outletName: String = "",
  val group: String = "",
  val groupOverride: Boolean = false,
  val groupWeight: Int = 100,
  val sticky: Int? = null,
  val cooldown: Int? = null,
  val delay: Int? = null,
  val ignoreBudget: Boolean = false,
)

private data class RuntimeEntry(
  val entry: StCharacterBookEntry,
  val order: Int,
  val extensions: StBookEntryRuntimeExtensions,
  val stableKey: String,
)

private data class TimedEffectValue(
  val hash: String,
  val start: Int,
  val end: Int,
  val protected: Boolean = false,
)

internal enum class StSelectiveLogic {
  AND_ANY,
  NOT_ALL,
  NOT_ANY,
  AND_ALL,
}

internal enum class StWorldInfoPosition {
  BEFORE,
  AFTER,
  AUTHOR_NOTE_BEFORE,
  AUTHOR_NOTE_AFTER,
  AT_DEPTH,
  EXAMPLE_BEFORE,
  EXAMPLE_AFTER,
  OUTLET,
}

internal class StCharacterBookRuntime(private val tokenEstimator: TokenEstimator) {
  fun resolve(
    book: StCharacterBook?,
    context: StWorldScanContext,
    macroContext: StMacroContext,
    chatMetadataJson: String?,
    chatLength: Int,
  ): StResolvedPromptRuntime {
    if (book == null) {
      return StResolvedPromptRuntime(updatedChatMetadataJson = chatMetadataJson)
    }

    val metadata = parseChatMetadata(chatMetadataJson)
    val entries =
      book.entries
        .orEmpty()
        .filter { (it.enabled ?: true) && !it.content.isNullOrBlank() }
        .mapIndexed { index, entry ->
          RuntimeEntry(
            entry = entry,
            order = entry.insertion_order ?: index,
            extensions = entry.toRuntimeExtensions(),
            stableKey = entry.stableKey(index),
          )
        }
    if (entries.isEmpty()) {
      return StResolvedPromptRuntime(updatedChatMetadataJson = serializeChatMetadata(metadata))
    }

    val activated = linkedMapOf<String, RuntimeEntry>()
    val recursionBuffer = mutableListOf<String>()
    val availableRecursionDelayLevels =
      entries
        .map { it.extensions.delayUntilRecursion }
        .filter { it > 0 }
        .distinct()
        .sorted()
        .toMutableList()
    var currentDelayLevel = availableRecursionDelayLevels.firstOrNull() ?: 0
    if (availableRecursionDelayLevels.isNotEmpty()) {
      availableRecursionDelayLevels.removeAt(0)
    }
    val budget = book.token_budget?.takeIf { it > 0 } ?: Int.MAX_VALUE
    var budgetOverflowed = false
    var recurse = true

    while (recurse) {
      recurse = false
      val candidates =
        entries.filter { runtimeEntry ->
          if (activated.containsKey(runtimeEntry.stableKey)) {
            return@filter false
          }

          val stickyActive = metadata.isTimedEffectActive("sticky", runtimeEntry, entries, chatLength)
          val cooldownActive = metadata.isTimedEffectActive("cooldown", runtimeEntry, entries, chatLength)
          val delayActive = runtimeEntry.extensions.delay?.let { chatLength < it } ?: false

          if (delayActive) {
            return@filter false
          }
          if (cooldownActive && !stickyActive) {
            return@filter false
          }
          if (recursionBuffer.isEmpty() && runtimeEntry.extensions.delayUntilRecursion > 0 && !stickyActive) {
            return@filter false
          }
          if (recursionBuffer.isNotEmpty() && runtimeEntry.extensions.delayUntilRecursion > currentDelayLevel && !stickyActive) {
            return@filter false
          }
          if (recursionBuffer.isNotEmpty() && (book.recursive_scanning == true) && runtimeEntry.extensions.excludeRecursion && !stickyActive) {
            return@filter false
          }
          if (runtimeEntry.entry.constant == true || stickyActive) {
            return@filter true
          }

          val textToScan =
            context.toScanText(
              extensions = runtimeEntry.extensions,
              defaultScanDepth = book.scan_depth,
              recursionBuffer = recursionBuffer,
            )
          if (!runtimeEntry.matchesPrimary(textToScan, macroContext)) {
            return@filter false
          }
          runtimeEntry.matchesSecondary(textToScan, macroContext)
        }
      if (candidates.isEmpty()) {
        if (availableRecursionDelayLevels.isNotEmpty()) {
          currentDelayLevel = availableRecursionDelayLevels.removeAt(0)
          recurse = true
        }
        continue
      }

      val grouped = filterGroupedCandidates(candidates, activated)
      val newlyActivated = mutableListOf<RuntimeEntry>()
      var currentBudgetUsage =
        activated.values
          .filterNot { it.extensions.ignoreBudget }
          .sumOf { tokenEstimator.estimate(macroContext.substitute(it.entry.content).trim()) }

      grouped.forEach { runtimeEntry ->
        if (!runtimeEntry.passesProbability(metadata, entries, chatLength)) {
          return@forEach
        }

        val renderedContent = macroContext.substitute(runtimeEntry.entry.content).trim()
        if (renderedContent.isBlank()) {
          return@forEach
        }
        val contentTokens = tokenEstimator.estimate(renderedContent)
        if (!runtimeEntry.extensions.ignoreBudget && currentBudgetUsage + contentTokens >= budget) {
          budgetOverflowed = true
          return@forEach
        }

        activated[runtimeEntry.stableKey] = runtimeEntry
        newlyActivated += runtimeEntry
        if (!runtimeEntry.extensions.ignoreBudget) {
          currentBudgetUsage += contentTokens
        }
      }

      metadata.setTimedEffects(newlyActivated, chatLength)

      if (!budgetOverflowed && book.recursive_scanning == true) {
        val recursionText =
          newlyActivated
            .filterNot { it.extensions.preventRecursion }
            .joinToString("\n") { macroContext.substitute(it.entry.content).trim() }
            .trim()
        if (recursionText.isNotBlank()) {
          recursionBuffer += recursionText
          recurse = true
        } else if (availableRecursionDelayLevels.isNotEmpty()) {
          currentDelayLevel = availableRecursionDelayLevels.removeAt(0)
          recurse = true
        }
      } else if (!budgetOverflowed && availableRecursionDelayLevels.isNotEmpty()) {
        currentDelayLevel = availableRecursionDelayLevels.removeAt(0)
        recurse = true
      }
    }

    val beforePrompt = mutableListOf<String>()
    val afterPrompt = mutableListOf<String>()
    val authorNoteBefore = mutableListOf<String>()
    val authorNoteAfter = mutableListOf<String>()
    val exampleBefore = mutableListOf<String>()
    val exampleAfter = mutableListOf<String>()
    val depthPrompts = mutableListOf<StRuntimeDepthPromptInsertion>()
    val outletEntries = linkedMapOf<String, MutableList<String>>()

    activated.values.sortedBy { it.order }.forEach { runtimeEntry ->
      val content = macroContext.substitute(runtimeEntry.entry.content).trim()
      if (content.isBlank()) {
        return@forEach
      }
      when (runtimeEntry.resolvePromptPosition()) {
        StWorldInfoPosition.BEFORE -> beforePrompt += content
        StWorldInfoPosition.AFTER -> afterPrompt += content
        StWorldInfoPosition.AUTHOR_NOTE_BEFORE -> authorNoteBefore += content
        StWorldInfoPosition.AUTHOR_NOTE_AFTER -> authorNoteAfter += content
        StWorldInfoPosition.EXAMPLE_BEFORE -> exampleBefore += content
        StWorldInfoPosition.EXAMPLE_AFTER -> exampleAfter += content
        StWorldInfoPosition.AT_DEPTH ->
          depthPrompts +=
            StRuntimeDepthPromptInsertion(
              prompt = content,
              depth = runtimeEntry.extensions.depth ?: 4,
              role = runtimeEntry.extensions.role.toPromptRoleName(),
            )
        StWorldInfoPosition.OUTLET -> {
          val outletName = runtimeEntry.extensions.outletName.ifBlank { "default" }
          outletEntries.getOrPut(outletName) { mutableListOf() }.add(content)
        }
      }
    }

    return StResolvedPromptRuntime(
      beforePrompt = beforePrompt.joinToString("\n").trim(),
      afterPrompt = afterPrompt.joinToString("\n").trim(),
      authorNoteBefore = authorNoteBefore,
      authorNoteAfter = authorNoteAfter,
      exampleBefore = exampleBefore,
      exampleAfter = exampleAfter,
      depthPrompts = depthPrompts.sortedBy { it.depth },
      outletEntries = outletEntries,
      updatedChatMetadataJson = serializeChatMetadata(metadata),
    )
  }

  private fun RuntimeEntry.matchesPrimary(textToScan: String, macroContext: StMacroContext): Boolean {
    return entry.keys
      .orEmpty()
      .filter(String::isNotBlank)
      .any { key ->
        textToScan.matchesKeyword(
          keyword = macroContext.substitute(key).trim(),
          extensions = extensions,
        )
      }
  }

  private fun RuntimeEntry.matchesSecondary(textToScan: String, macroContext: StMacroContext): Boolean {
    val keys = entry.secondary_keys.orEmpty().filter(String::isNotBlank)
    if (entry.selective != true || keys.isEmpty()) {
      return true
    }
    val matches =
      keys.map { key ->
        textToScan.matchesKeyword(
          keyword = macroContext.substitute(key).trim(),
          extensions = extensions,
        )
      }
    return when (extensions.selectiveLogic) {
      StSelectiveLogic.AND_ANY -> matches.any { it }
      StSelectiveLogic.NOT_ALL -> matches.any { matched -> !matched }
      StSelectiveLogic.NOT_ANY -> matches.none { it }
      StSelectiveLogic.AND_ALL -> matches.all { it }
    }
  }

  private fun RuntimeEntry.passesProbability(
    metadata: JsonObject,
    allEntries: List<RuntimeEntry>,
    chatLength: Int,
  ): Boolean {
    if (!extensions.useProbability || extensions.probability >= 100) {
      return true
    }
    if (metadata.isTimedEffectActive("sticky", this, allEntries, chatLength)) {
      return true
    }
    return Random.nextInt(100) < extensions.probability
  }

  private fun filterGroupedCandidates(
    candidates: List<RuntimeEntry>,
    activated: Map<String, RuntimeEntry>,
  ): List<RuntimeEntry> {
    if (candidates.none { it.extensions.group.isNotBlank() }) {
      return candidates.sortedWith(compareByDescending<RuntimeEntry> { it.extensions.sticky ?: 0 }.thenBy { it.order })
    }

    val kept = candidates.toMutableList()
    val grouped =
      linkedMapOf<String, MutableList<RuntimeEntry>>().apply {
        candidates
          .filter { it.extensions.group.isNotBlank() }
          .forEach { runtimeEntry ->
            runtimeEntry.extensions.group
              .split(',')
              .map(String::trim)
              .filter(String::isNotBlank)
              .forEach { groupName ->
                getOrPut(groupName) { mutableListOf() }.add(runtimeEntry)
              }
          }
        }
    grouped.forEach { (groupName, groupEntries) ->
      if (groupEntries.isEmpty()) {
        return@forEach
      }
      if (activated.values.any { it.extensions.group.split(',').map(String::trim).contains(groupName) }) {
        kept.removeAll(groupEntries)
        return@forEach
      }
      val overrides = groupEntries.filter { it.extensions.groupOverride }.sortedBy { it.order }
      val winner =
        when {
          overrides.isNotEmpty() -> overrides.first()
          else -> weightedPick(groupEntries)
        }
      kept.removeAll(groupEntries.filterNot { it == winner })
    }
    return kept.sortedWith(compareByDescending<RuntimeEntry> { it.extensions.sticky ?: 0 }.thenBy { it.order })
  }

  private fun weightedPick(entries: List<RuntimeEntry>): RuntimeEntry {
    val total = entries.sumOf { it.extensions.groupWeight.coerceAtLeast(1) }
    var roll = Random.nextInt(total.coerceAtLeast(1))
    entries.forEach { entry ->
      roll -= entry.extensions.groupWeight.coerceAtLeast(1)
      if (roll < 0) {
        return entry
      }
    }
    return entries.first()
  }
}

private fun StCharacterBookEntry.stableKey(index: Int): String {
  val base = buildString {
    append(id ?: index)
    append(':')
    append(comment.orEmpty())
    append(':')
    append(content.orEmpty())
  }
  return UUID.nameUUIDFromBytes(base.toByteArray()).toString()
}

private fun StCharacterBookEntry.toRuntimeExtensions(): StBookEntryRuntimeExtensions {
  val extensions = extensions ?: JsonObject()
  return StBookEntryRuntimeExtensions(
    position = extensions.intOrNull("position"),
    depth = extensions.intOrNull("depth"),
    role = extensions.intOrNull("role"),
    selectiveLogic =
      when (extensions.intOrNull("selectiveLogic")) {
        1 -> StSelectiveLogic.NOT_ALL
        2 -> StSelectiveLogic.NOT_ANY
        3 -> StSelectiveLogic.AND_ALL
        else -> StSelectiveLogic.AND_ANY
      },
    scanDepth = extensions.intOrNull("scan_depth"),
    caseSensitive = extensions.booleanOrNull("case_sensitive"),
    matchWholeWords = extensions.booleanOrNull("match_whole_words"),
    matchPersonaDescription = extensions.booleanOrNull("match_persona_description") ?: false,
    matchCharacterDescription = extensions.booleanOrNull("match_character_description") ?: false,
    matchCharacterPersonality = extensions.booleanOrNull("match_character_personality") ?: false,
    matchCharacterDepthPrompt = extensions.booleanOrNull("match_character_depth_prompt") ?: false,
    matchScenario = extensions.booleanOrNull("match_scenario") ?: false,
    matchCreatorNotes = extensions.booleanOrNull("match_creator_notes") ?: false,
    useRegex = use_regex ?: false,
    preventRecursion = extensions.booleanOrNull("prevent_recursion") ?: false,
    excludeRecursion = extensions.booleanOrNull("exclude_recursion") ?: false,
    delayUntilRecursion = extensions.intOrNull("delay_until_recursion") ?: 0,
    probability = (extensions.doubleOrNull("probability") ?: 100.0).roundToInt().coerceIn(0, 100),
    useProbability = extensions.booleanOrNull("useProbability") ?: true,
    outletName = extensions.stringOrNull("outlet_name").orEmpty(),
    group = extensions.stringOrNull("group").orEmpty(),
    groupOverride = extensions.booleanOrNull("group_override") ?: false,
    groupWeight = extensions.intOrNull("group_weight") ?: 100,
    sticky = extensions.intOrNull("sticky"),
    cooldown = extensions.intOrNull("cooldown"),
    delay = extensions.intOrNull("delay"),
    ignoreBudget = extensions.booleanOrNull("ignore_budget") ?: false,
  )
}

private fun RuntimeEntry.resolvePromptPosition(): StWorldInfoPosition {
  return extensions.position?.toWorldInfoPosition()
    ?: if (entry.position.equals("before_char", ignoreCase = true)) {
      StWorldInfoPosition.BEFORE
    } else {
      StWorldInfoPosition.AFTER
    }
}

private fun StWorldScanContext.toScanText(
  extensions: StBookEntryRuntimeExtensions,
  defaultScanDepth: Int?,
  recursionBuffer: List<String>,
): String {
  val scanDepth = (extensions.scanDepth ?: defaultScanDepth ?: 4).coerceAtLeast(0)
  val recentChat =
    recentMessagesNewestFirst
      .take(scanDepth)
      .joinToString("\n")
  val selectedGlobalFields =
    buildList {
        if (extensions.matchPersonaDescription) add(personaDescription)
        if (extensions.matchCharacterDescription) add(characterDescription)
        if (extensions.matchCharacterPersonality) add(characterPersonality)
        if (extensions.matchCharacterDepthPrompt) add(characterDepthPrompt)
        if (extensions.matchScenario) add(scenario)
        if (extensions.matchCreatorNotes) add(creatorNotes)
      }
      .filter(String::isNotBlank)
  val appContext =
    buildList {
      sessionSummary.takeIf(String::isNotBlank)?.let(::add)
      addAll(memories)
    }

  return buildList {
      recursionBuffer.filter(String::isNotBlank).forEach(::add)
      recentChat.takeIf(String::isNotBlank)?.let(::add)
      addAll(selectedGlobalFields)
      addAll(appContext)
    }
    .joinToString("\n")
}

private fun String.matchesKeyword(keyword: String, extensions: StBookEntryRuntimeExtensions): Boolean {
  if (isBlank() || keyword.isBlank()) {
    return false
  }
  if (extensions.useRegex || keyword.isRegexPattern()) {
    val regex = keyword.toRegexOrNull(caseSensitive = extensions.caseSensitive ?: false) ?: return false
    return regex.containsMatchIn(this)
  }

  val caseSensitive = extensions.caseSensitive ?: false
  val haystack = if (caseSensitive) this else lowercase()
  val needle = if (caseSensitive) keyword else keyword.lowercase()
  if (extensions.matchWholeWords == true) {
    val parts = needle.split(Regex("\\s+")).filter(String::isNotBlank)
    if (parts.size > 1) {
      return haystack.contains(needle)
    }
    val regex = Regex("""(?:^|\W)(${Regex.escape(needle)})(?:$|\W)""")
    return regex.containsMatchIn(haystack)
  }
  return haystack.contains(needle)
}

private fun String.isRegexPattern(): Boolean = startsWith("/") && lastIndexOf('/') > 0

private fun String.toRegexOrNull(caseSensitive: Boolean): Regex? {
  return runCatching {
    if (isRegexPattern()) {
      val lastSlashIndex = lastIndexOf('/')
      val body = substring(1, lastSlashIndex)
      val flags = substring(lastSlashIndex + 1)
      var options = emptySet<RegexOption>()
      if (!caseSensitive && !flags.contains('i')) {
        options = options + RegexOption.IGNORE_CASE
      }
      if (flags.contains('i')) {
        options = options + RegexOption.IGNORE_CASE
      }
      Regex(body, options)
    } else {
      Regex(this, if (caseSensitive) emptySet() else setOf(RegexOption.IGNORE_CASE))
    }
  }.getOrNull()
}

private fun parseChatMetadata(chatMetadataJson: String?): JsonObject {
  return runCatching {
    JsonParser.parseString(chatMetadataJson ?: "{}").asJsonObject
  }.getOrElse { JsonObject() }
}

private fun serializeChatMetadata(metadata: JsonObject): String = metadata.toString()

private fun JsonObject.isTimedEffectActive(
  type: String,
  entry: RuntimeEntry,
  allEntries: List<RuntimeEntry>,
  chatLength: Int,
): Boolean {
  val timedWorldInfo = getOrCreateObject("timedWorldInfo")
  val bucket = timedWorldInfo.getOrCreateObject(type)
  val effect = bucket.getAsJsonObject(entry.stableKey)
  if (effect == null) {
    return false
  }

  val start = effect.intOrNull("start") ?: 0
  val end = effect.intOrNull("end") ?: 0
  val protected = effect.booleanOrNull("protected") ?: false
  val hash = effect.stringOrNull("hash").orEmpty()
  val matchingEntry = allEntries.find { it.stableKey == hash || it.stableKey == entry.stableKey }
  if (chatLength <= start && !protected) {
    bucket.remove(entry.stableKey)
    return false
  }
  if (matchingEntry == null) {
    if (chatLength >= end) {
      bucket.remove(entry.stableKey)
    }
    return false
  }
  if (chatLength >= end) {
    bucket.remove(entry.stableKey)
    if (type == "sticky" && entry.extensions.cooldown != null) {
      val cooldownBucket = timedWorldInfo.getOrCreateObject("cooldown")
      cooldownBucket.add(
        entry.stableKey,
        JsonObject().apply {
          addProperty("hash", entry.stableKey)
          addProperty("start", chatLength)
          addProperty("end", chatLength + entry.extensions.cooldown)
          addProperty("protected", true)
        },
      )
    }
    return type == "cooldown" && entry.extensions.cooldown != null
  }
  return true
}

private fun JsonObject.setTimedEffects(entries: List<RuntimeEntry>, chatLength: Int) {
  val timedWorldInfo = getOrCreateObject("timedWorldInfo")
  val stickyBucket = timedWorldInfo.getOrCreateObject("sticky")
  val cooldownBucket = timedWorldInfo.getOrCreateObject("cooldown")
  entries.forEach { entry ->
    entry.extensions.sticky?.takeIf { it > 0 }?.let { sticky ->
      if (!stickyBucket.has(entry.stableKey)) {
        stickyBucket.add(
          entry.stableKey,
          JsonObject().apply {
            addProperty("hash", entry.stableKey)
            addProperty("start", chatLength)
            addProperty("end", chatLength + sticky)
            addProperty("protected", false)
          },
        )
      }
    }
    entry.extensions.cooldown?.takeIf { it > 0 }?.let { cooldown ->
      if (!cooldownBucket.has(entry.stableKey)) {
        cooldownBucket.add(
          entry.stableKey,
          JsonObject().apply {
            addProperty("hash", entry.stableKey)
            addProperty("start", chatLength)
            addProperty("end", chatLength + cooldown)
            addProperty("protected", false)
          },
        )
      }
    }
  }
}

private fun JsonObject.getOrCreateObject(key: String): JsonObject {
  val existing = getAsJsonObject(key)
  if (existing != null) {
    return existing
  }
  return JsonObject().also { add(key, it) }
}

private fun JsonObject.intOrNull(key: String): Int? =
  get(key)?.takeIf { it.isJsonPrimitive }?.asString?.toIntOrNull()

private fun JsonObject.doubleOrNull(key: String): Double? =
  get(key)?.takeIf { it.isJsonPrimitive }?.asString?.toDoubleOrNull()

private fun JsonObject.booleanOrNull(key: String): Boolean? {
  val value = get(key)?.takeIf { it.isJsonPrimitive } ?: return null
  return when {
    value.asJsonPrimitive.isBoolean -> value.asBoolean
    value.asJsonPrimitive.isString -> value.asString.toBooleanStrictOrNull()
    else -> null
  }
}

private fun JsonObject.stringOrNull(key: String): String? =
  get(key)?.takeIf { it.isJsonPrimitive }?.asString

private fun Int?.toPromptRoleName(): String {
  return when (this) {
    1 -> "user"
    2 -> "assistant"
    else -> "system"
  }
}

internal fun Int.toWorldInfoPosition(): StWorldInfoPosition {
  return when (this) {
    0 -> StWorldInfoPosition.BEFORE
    1 -> StWorldInfoPosition.AFTER
    2 -> StWorldInfoPosition.AUTHOR_NOTE_BEFORE
    3 -> StWorldInfoPosition.AUTHOR_NOTE_AFTER
    4 -> StWorldInfoPosition.AT_DEPTH
    5 -> StWorldInfoPosition.EXAMPLE_BEFORE
    6 -> StWorldInfoPosition.EXAMPLE_AFTER
    7 -> StWorldInfoPosition.OUTLET
    else -> StWorldInfoPosition.AFTER
  }
}
