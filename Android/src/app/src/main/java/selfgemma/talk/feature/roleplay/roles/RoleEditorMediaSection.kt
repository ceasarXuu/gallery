package selfgemma.talk.feature.roleplay.roles

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
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

@Composable
fun RoleEditorMediaSection(
  avatarUri: String?,
  coverUri: String?,
  importedFromStPng: Boolean,
  onPickAvatar: () -> Unit,
  onClearAvatar: () -> Unit,
  onPickCover: () -> Unit,
  onClearCover: () -> Unit,
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
    RoleMediaCard(
      title = stringResource(R.string.role_editor_avatar_title),
      subtitle = stringResource(R.string.role_editor_avatar_summary),
      uri = avatarUri,
      emptyLabel = stringResource(R.string.role_editor_avatar_empty),
      statusLabel =
        when {
          avatarUri.isNullOrBlank() -> stringResource(R.string.role_editor_media_status_missing)
          importedFromStPng -> stringResource(R.string.role_editor_media_status_st_png)
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
        } else {
          stringResource(R.string.role_editor_media_status_project_only)
        },
      onPick = onPickCover,
      onClear = onClearCover,
      previewAspectRatio = 16f / 9f,
    )
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
        .height(if (previewAspectRatio > 1f) 140.dp else 220.dp)
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
