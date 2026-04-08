package selfgemma.talk.data.roleplay.mapper

import org.junit.Assert.assertEquals
import org.junit.Test
import selfgemma.talk.data.roleplay.db.entity.RoleEntity
import selfgemma.talk.domain.roleplay.model.RoleMediaAsset
import selfgemma.talk.domain.roleplay.model.RoleMediaKind
import selfgemma.talk.domain.roleplay.model.RoleMediaProfile
import selfgemma.talk.domain.roleplay.model.RoleMediaSource

class RoleplayMappersTest {
  @Test
  fun toDomain_prefersPrimaryAvatarFromMediaProfileWhenLegacyAvatarColumnIsBlank() {
    val mediaProfile =
      RoleMediaProfile(
        primaryAvatar =
          RoleMediaAsset(
            id = "avatar-1",
            kind = RoleMediaKind.PRIMARY_AVATAR,
            uri = "content://cards/imported-avatar.png",
            source = RoleMediaSource.ST_PNG_IMPORT,
            createdAt = 1L,
            updatedAt = 1L,
          )
      )

    val entity =
      RoleEntity(
        id = "role-1",
        name = "Iris",
        avatarUri = null,
        coverUri = null,
        summary = "Archivist",
        systemPrompt = "Stay in character.",
        mediaProfileJson = RoleplayInteropJsonCodec.encodeRoleMediaProfile(mediaProfile),
        createdAt = 1L,
        updatedAt = 1L,
      )

    val role = entity.toDomain()

    assertEquals("content://cards/imported-avatar.png", role.avatarUri)
    assertEquals("content://cards/imported-avatar.png", role.mediaProfile?.primaryAvatar?.uri)
  }
}
