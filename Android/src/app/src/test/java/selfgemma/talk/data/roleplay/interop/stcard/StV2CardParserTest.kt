package selfgemma.talk.data.roleplay.interop.stcard

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import selfgemma.talk.domain.roleplay.model.CharacterBook
import selfgemma.talk.domain.roleplay.model.CharacterBookEntry
import selfgemma.talk.domain.roleplay.model.RoleCardCore
import selfgemma.talk.domain.roleplay.model.RoleCardSpecVersion

class StV2CardParserTest {
  private val parser = StV2CardParser()
  private val serializer = StV2CardSerializer()

  @Test
  fun parse_reads_core_fields_from_v2_json() {
    val parsed =
      parser.parse(
        """
        {
          "spec": "chara_card_v2",
          "spec_version": "2.0",
          "data": {
            "name": "Seraphina",
            "description": "A gentle forest guardian.",
            "personality": "Warm and observant.",
            "scenario": "A moonlit healing grove.",
            "first_mes": "You finally woke up.",
            "mes_example": "User: Hello\nSeraphina: Welcome back.",
            "creator_notes": "Imported test card",
            "system_prompt": "Stay in character.",
            "post_history_instructions": "Prefer continuity.",
            "alternate_greetings": ["Hello there.", "You are safe now."],
            "tags": ["fantasy", "healer"],
            "creator": "tester",
            "character_version": "1.2",
            "extensions": {"depth_prompt": {"depth": 4}},
            "character_book": {
              "name": "Lore",
              "entries": [
                {
                  "id": 1,
                  "keys": ["grove"],
                  "content": "The grove shifts with moonlight."
                }
              ]
            }
          }
        }
        """.trimIndent()
      )

    assertEquals("Seraphina", parsed.core.name)
    assertEquals(RoleCardSpecVersion.ST_V2, parsed.core.spec)
    assertEquals("Warm and observant.", parsed.core.personality)
    assertEquals(2, parsed.core.alternateGreetings.size)
    assertEquals(1, parsed.core.characterBook?.entries?.size)
    assertTrue(parsed.interopState.rawCardJson?.contains("chara_card_v2") == true)
  }

  @Test
  fun serialize_writes_v2_shape_with_legacy_mirror_fields() {
    val json =
      serializer.serialize(
        RoleCardCore(
          spec = RoleCardSpecVersion.ST_V2,
          name = "Captain Astra",
          description = "Mission-first captain.",
          personality = "Calm and decisive.",
          scenario = "Deep-space survey mission.",
          firstMessage = "Crew report.",
          messageExample = "User: Status?\nAstra: Stable.",
          creatorNotes = "seed",
          systemPrompt = "Stay immersive.",
          postHistoryInstructions = "Keep continuity.",
          alternateGreetings = listOf("Crew report.", "What changed on my watch?"),
          tags = listOf("sci-fi", "captain"),
          creator = "selfgemma",
          characterVersion = "2.0",
          characterBook =
            CharacterBook(
              name = "Ship Notes",
              entries =
                listOf(
                  CharacterBookEntry(
                    id = 1,
                    keys = listOf("Meridian"),
                    content = "The Meridian is an aging survey ship."
                  )
                )
            ),
          extensionsJson = """{"depth_prompt":{"depth":4}}""",
        )
      )

    assertTrue(json.contains(""""spec": "chara_card_v2""""))
    assertTrue(json.contains(""""spec_version": "2.0""""))
    assertTrue(json.contains(""""name": "Captain Astra""""))
    assertTrue(json.contains(""""first_mes": "Crew report.""""))
    assertTrue(json.contains(""""system_prompt": "Stay immersive.""""))
    assertTrue(json.contains(""""alternate_greetings""""))
  }
}
