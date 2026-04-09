package selfgemma.talk.domain.roleplay.model

private const val DEFAULT_ST_RUNTIME_USER_NAME = "User"
private const val DEFAULT_ST_RUNTIME_TRIGGER = "normal"

data class StChatRuntimeRole(
  val card: StCharacterCard,
  val userName: String = DEFAULT_ST_RUNTIME_USER_NAME,
  val safetyPolicy: String = "",
)

data class StChatRuntimeSession(
  val chatMetadataJson: String? = null,
  val generationTrigger: String = DEFAULT_ST_RUNTIME_TRIGGER,
)

fun RoleCard.toStChatRuntimeRole(userName: String = DEFAULT_ST_RUNTIME_USER_NAME): StChatRuntimeRole {
  return StChatRuntimeRole(
    card = stCard,
    userName = userName,
    safetyPolicy = safetyPolicy,
  )
}

fun Session.toStChatRuntimeSession(generationTrigger: String = DEFAULT_ST_RUNTIME_TRIGGER): StChatRuntimeSession {
  return StChatRuntimeSession(
    chatMetadataJson = interopChatMetadataJson,
    generationTrigger = generationTrigger,
  )
}

fun StChatRuntimeRole.name(): String = card.resolvedName()

fun StChatRuntimeRole.summary(): String = card.resolvedDescription()

fun StChatRuntimeRole.systemPrompt(): String = card.resolvedSystemPrompt()

fun StChatRuntimeRole.personaDescription(): String = card.resolvedPersonality()

fun StChatRuntimeRole.worldSettings(): String = card.resolvedScenario()

fun StChatRuntimeRole.openingMessage(): String = card.resolvedFirstMessage()

fun StChatRuntimeRole.exampleDialoguesRaw(): String = card.resolvedMessageExample()

fun StChatRuntimeRole.tags(): List<String> = card.resolvedTags()

fun StChatRuntimeRole.cardData(): StCharacterCardData = card.cardDataOrEmpty()
