package selfgemma.talk.feature.roleplay.chat

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RoleplayChatScreenTest {
  @Test
  fun `text only send can reuse multimodal session`() {
    assertTrue(
      canReuseRoleplayModelSession(
        supportImage = true,
        supportAudio = true,
        needsImage = false,
        needsAudio = false,
      )
    )
  }

  @Test
  fun `image send cannot reuse text only session`() {
    assertFalse(
      canReuseRoleplayModelSession(
        supportImage = false,
        supportAudio = false,
        needsImage = true,
        needsAudio = false,
      )
    )
  }

  @Test
  fun `audio send can reuse fully capable session`() {
    assertTrue(
      canReuseRoleplayModelSession(
        supportImage = true,
        supportAudio = true,
        needsImage = false,
        needsAudio = true,
      )
    )
  }

  @Test
  fun `audio send cannot reuse image only session`() {
    assertFalse(
      canReuseRoleplayModelSession(
        supportImage = true,
        supportAudio = false,
        needsImage = false,
        needsAudio = true,
      )
    )
  }
}
