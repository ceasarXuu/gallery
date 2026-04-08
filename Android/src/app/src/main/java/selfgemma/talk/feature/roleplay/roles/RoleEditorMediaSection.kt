package selfgemma.talk.feature.roleplay.roles

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import selfgemma.talk.R
import selfgemma.talk.common.decodeSampledBitmapFromUri
import selfgemma.talk.domain.roleplay.model.RoleMediaAsset
import selfgemma.talk.domain.roleplay.model.RoleMediaSource
import selfgemma.talk.domain.roleplay.model.RoleMediaUsage
import selfgemma.talk.domain.roleplay.model.RoleSpriteAsset

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RoleEditorMediaSection(
  avatarUri: String?,
  coverUri: String?,
  avatarSource: RoleMediaSource?,
  coverSource: RoleMediaSource?,
  galleryAssets: List<RoleMediaAsset>,
  spriteAssets: List<RoleSpriteAsset>,
  importedFromStPng: Boolean,
  onPickAvatar: () -> Unit,
  onClearAvatar: () -> Unit,
  onPickCover: () -> Unit,
  onClearCover: () -> Unit,
  onAddGallery: () -> Unit,
  onRenameGalleryAsset: (String, String) -> Unit,
  onUpdateGalleryUsage: (String, RoleMediaUsage) -> Unit,
  onSetGalleryAsAvatar: (String) -> Unit,
  onSetGalleryAsCover: (String) -> Unit,
  onRemoveGalleryAsset: (String) -> Unit,
  onAddSprites: () -> Unit,
  onRenameSpriteAsset: (String, String) -> Unit,
  onUpdateSpriteStateTag: (String, String) -> Unit,
  onRemoveSpriteAsset: (String) -> Unit,
  modifier: Modifier = Modifier,
) {
  Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
    Text(
      text = stringResource(R.string.role_editor_media_title),
      style = MaterialTheme.typography.titleMedium,
    )
    Text(
      text = stringResource(R.string.role_editor_media_summary),
      style = MaterialTheme.typography.bodyMedium,
      color = MaterialTheme.colorScheme.onSurfaceVariant,
    )
    MediaCompatibilitySummary(
      hasAvatar = !avatarUri.isNullOrBlank(),
      hasCover = !coverUri.isNullOrBlank(),
      galleryCount = galleryAssets.size,
      spriteCount = spriteAssets.size,
      importedFromStPng = importedFromStPng,
    )
    RoleMediaCard(
      title = stringResource(R.string.role_editor_avatar_title),
      subtitle = stringResource(R.string.role_editor_avatar_summary),
      uri = avatarUri,
      emptyLabel = stringResource(R.string.role_editor_avatar_empty),
      statusLabel =
        when {
          avatarUri.isNullOrBlank() -> stringResource(R.string.role_editor_media_status_missing)
          avatarSource == RoleMediaSource.ST_PNG_IMPORT || importedFromStPng -> stringResource(R.string.role_editor_media_status_st_png)
          else -> stringResource(R.string.role_editor_media_status_local)
        },
      onPick = onPickAvatar,
      onClear = onClearAvatar,
      previewAspectRatio = 1f,
    )
    RoleMediaCard(
      title = stringResource(R.string.role_editor_cover_title),
      subtitle = stringResource(R.string.role_editor_cover_summary),
      uri = coverUri,
      emptyLabel = stringResource(R.string.role_editor_cover_empty),
      statusLabel =
        if (coverUri.isNullOrBlank()) {
          stringResource(R.string.role_editor_media_status_missing)
        } else if (coverSource == RoleMediaSource.ST_PNG_IMPORT) {
          stringResource(R.string.role_editor_media_status_st_png)
        } else {
          stringResource(R.string.role_editor_media_status_project_only)
        },
      onPick = onPickCover,
      onClear = onClearCover,
      previewAspectRatio = 16f / 9f,
    )
    GalleryAssetsCard(
      assets = galleryAssets,
      onAddGallery = onAddGallery,
      onUpdateName = onRenameGalleryAsset,
      onUpdateUsage = onUpdateGalleryUsage,
      onSetAsAvatar = onSetGalleryAsAvatar,
      onSetAsCover = onSetGalleryAsCover,
      onRemove = onRemoveGalleryAsset,
    )
    SpriteAssetsCard(
      assets = spriteAssets,
      onAddSprite = onAddSprites,
      onUpdateName = onRenameSpriteAsset,
      onUpdateStateTag = onUpdateSpriteStateTag,
      onRemove = onRemoveSpriteAsset,
    )
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun MediaCompatibilitySummary(
  hasAvatar: Boolean,
  hasCover: Boolean,
  galleryCount: Int,
  spriteCount: Int,
  importedFromStPng: Boolean,
) {
  Card {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      Text(
        text = stringResource(R.string.role_editor_media_export_summary_title),
        style = MaterialTheme.typography.titleSmall,
      )
      FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        AssistChip(
          onClick = {},
          enabled = false,
          label = {
            Text(
              if (hasAvatar) {
                stringResource(R.string.role_editor_media_export_st_png_ready)
              } else {
                stringResource(R.string.role_editor_media_export_st_png_missing)
              }
            )
          },
        )
        AssistChip(
          onClick = {},
          enabled = false,
          label = {
            Text(
              if (hasCover) {
                stringResource(R.string.role_editor_media_export_cover_project_only)
              } else {
                stringResource(R.string.role_editor_media_export_cover_empty)
              }
            )
          },
        )
        AssistChip(
          onClick = {},
          enabled = false,
          label = { Text(stringResource(R.string.role_editor_media_export_gallery_count, galleryCount)) },
        )
        AssistChip(
          onClick = {},
          enabled = false,
          label = { Text(stringResource(R.string.role_editor_media_export_sprite_count, spriteCount)) },
        )
        if (importedFromStPng) {
          AssistChip(
            onClick = {},
            enabled = false,
            label = { Text(stringResource(R.string.role_editor_media_status_st_png)) },
          )
        }
      }
      Text(
        text = stringResource(R.string.role_editor_media_export_summary_body),
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
    }
  }
}

@Composable
private fun RoleMediaCard(
  title: String,
  subtitle: String,
  uri: String?,
  emptyLabel: String,
  statusLabel: String,
  onPick: () -> Unit,
  onClear: () -> Unit,
  previewAspectRatio: Float,
) {
  Card {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
          Text(title, style = MaterialTheme.typography.titleSmall)
          Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
          )
        }
        AssistChip(onClick = {}, enabled = false, label = { Text(statusLabel) })
      }

      RoleMediaPreview(
        uri = uri,
        emptyLabel = emptyLabel,
        previewAspectRatio = previewAspectRatio,
      )

      Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedButton(onClick = onPick) {
          Text(if (uri.isNullOrBlank()) stringResource(R.string.role_editor_media_add) else stringResource(R.string.role_editor_media_replace))
        }
        if (!uri.isNullOrBlank()) {
          OutlinedButton(onClick = onClear) {
            Text(stringResource(R.string.role_editor_media_clear))
          }
        }
      }
    }
  }
}

@Composable
private fun GalleryAssetsCard(
  assets: List<RoleMediaAsset>,
  onAddGallery: () -> Unit,
  onUpdateName: (String, String) -> Unit,
  onUpdateUsage: (String, RoleMediaUsage) -> Unit,
  onSetAsAvatar: (String) -> Unit,
  onSetAsCover: (String) -> Unit,
  onRemove: (String) -> Unit,
) {
  Card {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
          Text(stringResource(R.string.role_editor_gallery_title), style = MaterialTheme.typography.titleSmall)
          Text(
            text = stringResource(R.string.role_editor_gallery_summary),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
          )
        }
        OutlinedButton(onClick = onAddGallery) {
          Text(stringResource(R.string.role_editor_gallery_add))
        }
      }
      if (assets.isEmpty()) {
        Text(
          text = stringResource(R.string.role_editor_gallery_empty),
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      } else {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
          assets.forEach { asset ->
            GalleryAssetItem(
              asset = asset,
              onUpdateName = onUpdateName,
              onUpdateUsage = onUpdateUsage,
              onSetAsAvatar = onSetAsAvatar,
              onSetAsCover = onSetAsCover,
              onRemove = onRemove,
            )
          }
        }
      }
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun GalleryAssetItem(
  asset: RoleMediaAsset,
  onUpdateName: (String, String) -> Unit,
  onUpdateUsage: (String, RoleMediaUsage) -> Unit,
  onSetAsAvatar: (String) -> Unit,
  onSetAsCover: (String) -> Unit,
  onRemove: (String) -> Unit,
) {
  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(12.dp),
      verticalAlignment = Alignment.Top,
    ) {
      Box(modifier = Modifier.size(96.dp)) {
        RoleMediaPreview(
          uri = asset.uri,
          emptyLabel = stringResource(R.string.role_editor_gallery_empty),
          previewAspectRatio = 1f,
        )
      }
      Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        OutlinedTextField(
          value = asset.displayName.orEmpty(),
          onValueChange = { onUpdateName(asset.id, it) },
          label = { Text(stringResource(R.string.role_editor_media_asset_name)) },
          modifier = Modifier.fillMaxWidth(),
          singleLine = true,
        )
        UsageSelector(
          currentUsage = asset.usage,
          onSelected = { onUpdateUsage(asset.id, it) },
        )
      }
    }
    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
      OutlinedButton(onClick = { onSetAsAvatar(asset.id) }) {
        Text(stringResource(R.string.role_editor_gallery_set_avatar))
      }
      OutlinedButton(onClick = { onSetAsCover(asset.id) }) {
        Text(stringResource(R.string.role_editor_gallery_set_cover))
      }
      OutlinedButton(onClick = { onRemove(asset.id) }) {
        Text(stringResource(R.string.role_editor_media_remove))
      }
    }
  }
}

@Composable
private fun UsageSelector(
  currentUsage: RoleMediaUsage,
  onSelected: (RoleMediaUsage) -> Unit,
) {
  var expanded by remember { mutableStateOf(false) }
  Box {
    OutlinedButton(onClick = { expanded = true }) {
      Text(usageLabel(currentUsage))
    }
    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
      RoleMediaUsage.entries.forEach { usage ->
        DropdownMenuItem(
          text = { Text(usageLabel(usage)) },
          onClick = {
            expanded = false
            onSelected(usage)
          },
        )
      }
    }
  }
}

@Composable
private fun SpriteAssetsCard(
  assets: List<RoleSpriteAsset>,
  onAddSprite: () -> Unit,
  onUpdateName: (String, String) -> Unit,
  onUpdateStateTag: (String, String) -> Unit,
  onRemove: (String) -> Unit,
) {
  Card {
    Column(
      modifier = Modifier.fillMaxWidth().padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
          Text(stringResource(R.string.role_editor_sprite_title), style = MaterialTheme.typography.titleSmall)
          Text(
            text = stringResource(R.string.role_editor_sprite_summary),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
          )
        }
        OutlinedButton(onClick = onAddSprite) {
          Text(stringResource(R.string.role_editor_sprite_add))
        }
      }
      if (assets.isEmpty()) {
        Text(
          text = stringResource(R.string.role_editor_sprite_empty),
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      } else {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
          assets.forEach { asset ->
            SpriteAssetItem(
              asset = asset,
              onUpdateName = onUpdateName,
              onUpdateStateTag = onUpdateStateTag,
              onRemove = onRemove,
            )
          }
        }
      }
    }
  }
}

@Composable
private fun SpriteAssetItem(
  asset: RoleSpriteAsset,
  onUpdateName: (String, String) -> Unit,
  onUpdateStateTag: (String, String) -> Unit,
  onRemove: (String) -> Unit,
) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(12.dp),
    verticalAlignment = Alignment.Top,
  ) {
    Box(modifier = Modifier.size(88.dp)) {
      RoleMediaPreview(
        uri = asset.uri,
        emptyLabel = stringResource(R.string.role_editor_sprite_empty),
        previewAspectRatio = 1f,
      )
    }
    Column(
      modifier = Modifier.weight(1f),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      OutlinedTextField(
        value = asset.displayName.orEmpty(),
        onValueChange = { onUpdateName(asset.id, it) },
        label = { Text(stringResource(R.string.role_editor_media_asset_name)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
      )
      OutlinedTextField(
        value = asset.stateTag,
        onValueChange = { onUpdateStateTag(asset.id, it) },
        label = { Text(stringResource(R.string.role_editor_sprite_state_tag)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
      )
      OutlinedButton(onClick = { onRemove(asset.id) }) {
        Text(stringResource(R.string.role_editor_media_remove))
      }
    }
  }
}

@Composable
private fun RoleMediaPreview(
  uri: String?,
  emptyLabel: String,
  previewAspectRatio: Float,
) {
  val context = LocalContext.current
  val bitmapState =
    produceState<Bitmap?>(initialValue = null, uri) {
      value =
        uri?.let {
          runCatching {
            decodeSampledBitmapFromUri(
              context = context,
              uri = Uri.parse(it),
              reqWidth = 720,
              reqHeight = 720,
            )
          }.getOrNull()
        }
    }

  if (bitmapState.value != null) {
    Image(
      bitmap = checkNotNull(bitmapState.value).asImageBitmap(),
      contentDescription = null,
      modifier =
        Modifier.fillMaxWidth()
          .aspectRatio(previewAspectRatio)
          .background(
            color = MaterialTheme.colorScheme.surfaceContainerHighest,
            shape = RoundedCornerShape(18.dp),
          ),
      contentScale = ContentScale.Crop,
    )
    return
  }

  Box(
    modifier =
      Modifier.fillMaxWidth()
        .aspectRatio(previewAspectRatio)
        .background(
          color = MaterialTheme.colorScheme.surfaceContainerHighest,
          shape = RoundedCornerShape(18.dp),
        ),
    contentAlignment = Alignment.Center,
  ) {
    Text(
      text = emptyLabel,
      style = MaterialTheme.typography.bodyMedium,
      color = MaterialTheme.colorScheme.onSurfaceVariant,
      maxLines = 2,
      overflow = TextOverflow.Ellipsis,
      modifier = Modifier.padding(horizontal = 16.dp),
    )
  }
}

@Composable
private fun usageLabel(usage: RoleMediaUsage): String {
  return when (usage) {
    RoleMediaUsage.UNSPECIFIED -> stringResource(R.string.role_editor_media_usage_unspecified)
    RoleMediaUsage.PORTRAIT -> stringResource(R.string.role_editor_media_usage_portrait)
    RoleMediaUsage.EXPRESSION -> stringResource(R.string.role_editor_media_usage_expression)
    RoleMediaUsage.SCENE -> stringResource(R.string.role_editor_media_usage_scene)
    RoleMediaUsage.REFERENCE -> stringResource(R.string.role_editor_media_usage_reference)
  }
}
