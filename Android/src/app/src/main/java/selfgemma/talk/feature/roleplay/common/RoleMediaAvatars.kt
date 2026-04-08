package selfgemma.talk.feature.roleplay.common

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import selfgemma.talk.common.decodeSampledBitmapFromUri

@Composable
fun RoleAvatar(
  name: String,
  avatarUri: String?,
  modifier: Modifier = Modifier,
) {
  val context = LocalContext.current
  val bitmapState =
    produceState<Bitmap?>(initialValue = null, avatarUri) {
      value =
        avatarUri?.takeIf { it.isNotBlank() }?.let {
          runCatching {
            decodeSampledBitmapFromUri(
              context = context,
              uri = Uri.parse(it),
              reqWidth = 256,
              reqHeight = 256,
            )
          }.getOrNull()
        }
    }

  if (bitmapState.value != null) {
    Image(
      bitmap = checkNotNull(bitmapState.value).asImageBitmap(),
      contentDescription = null,
      modifier = modifier.clip(CircleShape),
      contentScale = ContentScale.Crop,
    )
    return
  }

  Box(
    modifier =
      modifier.clip(CircleShape)
        .background(MaterialTheme.colorScheme.surfaceContainerHighest),
    contentAlignment = Alignment.Center,
  ) {
    Text(
      text = name.trim().firstOrNull()?.uppercase() ?: "?",
      style = MaterialTheme.typography.titleMedium,
      color = MaterialTheme.colorScheme.primary,
    )
  }
}
