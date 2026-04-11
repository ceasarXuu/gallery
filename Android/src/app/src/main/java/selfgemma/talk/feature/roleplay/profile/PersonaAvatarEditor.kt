package selfgemma.talk.feature.roleplay.profile

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas as AndroidCanvas
import android.graphics.Paint
import android.graphics.Rect
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.exifinterface.media.ExifInterface
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import kotlin.math.max
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import selfgemma.talk.R
import selfgemma.talk.common.decodeSampledBitmapFromUri
import selfgemma.talk.common.rotateBitmap

private const val TAG = "PersonaAvatarEditor"
private const val AVATAR_OUTPUT_SIZE = 512
private const val MIN_ZOOM = 1f
private const val MAX_ZOOM = 4f

internal data class PersonaAvatarEditorDraft(
  val sourceUri: String,
  val zoom: Float = 1f,
  val offsetX: Float = 0f,
  val offsetY: Float = 0f,
)

internal data class CropSourceRect(
  val left: Float,
  val top: Float,
  val right: Float,
  val bottom: Float,
)

@Composable
internal fun PersonaAvatarEditorDialog(
  draft: PersonaAvatarEditorDraft,
  onDismiss: () -> Unit,
  onPickReplacement: () -> Unit,
  onClearAvatar: () -> Unit,
  onSave: suspend (Bitmap) -> Unit,
) {
  val context = LocalContext.current
  val bitmapState =
    produceState<Bitmap?>(initialValue = null, draft.sourceUri) {
      value = loadEditableBitmap(context = context, avatarUri = draft.sourceUri)
    }
  var zoom by remember(draft.sourceUri) { mutableFloatStateOf(draft.zoom.coerceIn(MIN_ZOOM, MAX_ZOOM)) }
  var offsetX by remember(draft.sourceUri) { mutableFloatStateOf(draft.offsetX) }
  var offsetY by remember(draft.sourceUri) { mutableFloatStateOf(draft.offsetY) }
  var isSaving by remember { mutableStateOf(false) }

  val bitmap = bitmapState.value
  LaunchedEffect(bitmap, draft.sourceUri) {
    if (bitmap != null) {
      val squareSizePx = AVATAR_OUTPUT_SIZE.toFloat()
      val baseScale = calculateBaseScale(bitmap = bitmap, squareSizePx = squareSizePx)
      val clampedOffset = clampOffset(bitmap, squareSizePx, baseScale * zoom, offsetX, offsetY)
      offsetX = clampedOffset.first
      offsetY = clampedOffset.second
    }
  }

  AlertDialog(
    onDismissRequest = { if (!isSaving) onDismiss() },
    title = { Text(stringResource(R.string.my_profile_avatar_edit_title)) },
    text = {
      Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
      ) {
        Text(
          text = stringResource(R.string.my_profile_avatar_edit_hint),
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        if (bitmap == null) {
          Box(
            modifier = Modifier.fillMaxWidth().height(320.dp),
            contentAlignment = Alignment.Center,
          ) {
            CircularProgressIndicator()
          }
        } else {
          PersonaAvatarCropSurface(
            bitmap = bitmap,
            zoom = zoom,
            offsetX = offsetX,
            offsetY = offsetY,
            onTransform = { nextZoom, nextOffsetX, nextOffsetY ->
              zoom = nextZoom
              offsetX = nextOffsetX
              offsetY = nextOffsetY
            },
          )
        }
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
          OutlinedButton(
            enabled = !isSaving,
            onClick = onPickReplacement,
          ) {
            Text(stringResource(R.string.role_editor_media_replace))
          }
          if (!isSaving) {
            TextButton(
              onClick = onClearAvatar,
            ) {
              Text(stringResource(R.string.role_editor_media_clear))
            }
          }
        }
      }
    },
    confirmButton = {
      FilledTonalButton(
        enabled = bitmap != null && !isSaving,
        onClick = {
          if (bitmap == null || isSaving) {
            return@FilledTonalButton
          }
          isSaving = true
        },
      ) {
        if (isSaving) {
          CircularProgressIndicator(modifier = Modifier.size(18.dp), strokeWidth = 2.dp)
        } else {
          Text(stringResource(R.string.save))
        }
      }
    },
    dismissButton = {
      TextButton(
        enabled = !isSaving,
        onClick = onDismiss,
      ) {
        Text(stringResource(R.string.cancel))
      }
    },
  )

  LaunchedEffect(isSaving, bitmap) {
    if (!isSaving || bitmap == null) {
      return@LaunchedEffect
    }
    val croppedBitmap =
      cropAvatarBitmap(
        bitmap = bitmap,
        zoom = zoom,
        offsetX = offsetX,
        offsetY = offsetY,
        outputSize = AVATAR_OUTPUT_SIZE,
      )
    runCatching {
      onSave(croppedBitmap)
      Log.d(TAG, "saved cropped persona avatar source=${draft.sourceUri} zoom=$zoom offsetX=$offsetX offsetY=$offsetY")
    }.onFailure { error ->
      Log.e(TAG, "failed to save cropped persona avatar source=${draft.sourceUri}", error)
      isSaving = false
    }
  }
}

@Composable
private fun PersonaAvatarCropSurface(
  bitmap: Bitmap,
  zoom: Float,
  offsetX: Float,
  offsetY: Float,
  onTransform: (Float, Float, Float) -> Unit,
) {
  BoxWithConstraints(
    modifier =
      Modifier
        .fillMaxWidth()
        .height(320.dp)
        .clip(MaterialTheme.shapes.extraLarge)
        .background(MaterialTheme.colorScheme.surfaceContainerHigh),
  ) {
    val density = LocalDensity.current
    val squareSizeDp = maxWidth.coerceAtMost(maxHeight)
    val squareSizePx = with(density) { squareSizeDp.toPx() }
    val baseScale = remember(bitmap, squareSizePx) { calculateBaseScale(bitmap = bitmap, squareSizePx = squareSizePx) }
    val actualScale = baseScale * zoom

    Box(
      modifier =
        Modifier
          .align(Alignment.Center)
          .size(squareSizeDp)
          .pointerInput(bitmap, zoom, offsetX, offsetY) {
            detectTransformGestures { _, pan, gestureZoom, _ ->
              val nextZoom = (zoom * gestureZoom).coerceIn(MIN_ZOOM, MAX_ZOOM)
              val nextActualScale = baseScale * nextZoom
              val nextOffset =
                clampOffset(
                  bitmap = bitmap,
                  squareSizePx = squareSizePx,
                  actualScale = nextActualScale,
                  offsetX = offsetX + pan.x,
                  offsetY = offsetY + pan.y,
                )
              onTransform(nextZoom, nextOffset.first, nextOffset.second)
            }
          },
      contentAlignment = Alignment.Center,
    ) {
      androidx.compose.foundation.Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier =
          Modifier.graphicsLayer {
            scaleX = actualScale
            scaleY = actualScale
            translationX = offsetX
            translationY = offsetY
          },
      )
      Canvas(
        modifier =
          Modifier
            .fillMaxSize()
            .graphicsLayer(
              compositingStrategy = CompositingStrategy.Offscreen,
            ),
      ) {
        val diameter = size.minDimension
        val circleTopLeft = Offset((size.width - diameter) / 2f, (size.height - diameter) / 2f)
        drawRect(color = Color.Black.copy(alpha = 0.55f))
        drawCircle(
          color = Color.Transparent,
          radius = diameter / 2f,
          center = center,
          blendMode = BlendMode.Clear,
        )
        drawCircle(
          color = Color.White.copy(alpha = 0.9f),
          radius = diameter / 2f,
          center = center,
          style = Stroke(width = 3.dp.toPx()),
        )
        drawCircle(
          color = Color.White.copy(alpha = 0.2f),
          radius = diameter / 2f - 14.dp.toPx(),
          center = center,
          style = Stroke(width = 1.dp.toPx()),
        )
        drawRect(
          color = Color.Transparent,
          topLeft = circleTopLeft,
          size = Size(diameter, diameter),
        )
      }
    }
  }
}

internal suspend fun savePersonaAvatarBitmap(
  context: Context,
  slotId: String,
  bitmap: Bitmap,
): String =
  withContext(Dispatchers.IO) {
    val avatarDir = File(context.filesDir, "persona-avatars").apply { mkdirs() }
    val safeSlotId = slotId.ifBlank { "default" }.replace(Regex("[^a-zA-Z0-9._-]"), "_")
    val avatarFile = File(avatarDir, "persona_avatar_$safeSlotId.png")
    FileOutputStream(avatarFile).use { stream ->
      bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
    }
    Log.d(TAG, "persisted persona avatar slotId=$slotId path=${avatarFile.absolutePath} size=${bitmap.width}x${bitmap.height}")
    Uri.fromFile(avatarFile).toString()
  }

private fun loadEditableBitmap(
  context: Context,
  avatarUri: String,
): Bitmap? {
  return runCatching {
    val uri = Uri.parse(avatarUri)
    val inputStream =
      if (uri.scheme == null || uri.scheme == "file") {
        FileInputStream(uri.path ?: "")
      } else {
        context.contentResolver.openInputStream(uri)
      }
    val orientation =
      inputStream?.use { stream ->
        ExifInterface(stream).getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
      } ?: ExifInterface.ORIENTATION_NORMAL
    decodeSampledBitmapFromUri(context, uri, 2048, 2048)?.let { originalBitmap ->
      rotateBitmap(originalBitmap, orientation)
    }
  }.onFailure { error ->
    Log.e(TAG, "failed to decode editable avatar uri=$avatarUri", error)
  }.getOrNull()
}

private fun calculateBaseScale(
  bitmap: Bitmap,
  squareSizePx: Float,
): Float = max(squareSizePx / bitmap.width.toFloat(), squareSizePx / bitmap.height.toFloat())

private fun clampOffset(
  bitmap: Bitmap,
  squareSizePx: Float,
  actualScale: Float,
  offsetX: Float,
  offsetY: Float,
): Pair<Float, Float> {
  val halfOverflowX = max((bitmap.width * actualScale - squareSizePx) / 2f, 0f)
  val halfOverflowY = max((bitmap.height * actualScale - squareSizePx) / 2f, 0f)
  return offsetX.coerceIn(-halfOverflowX, halfOverflowX) to offsetY.coerceIn(-halfOverflowY, halfOverflowY)
}

internal fun cropAvatarBitmap(
  bitmap: Bitmap,
  zoom: Float,
  offsetX: Float,
  offsetY: Float,
  outputSize: Int,
): Bitmap {
  val sourceRect =
    calculateCropSourceRect(
      bitmapWidth = bitmap.width,
      bitmapHeight = bitmap.height,
      zoom = zoom,
      offsetX = offsetX,
      offsetY = offsetY,
      outputSize = outputSize,
    )

  return Bitmap.createBitmap(outputSize, outputSize, Bitmap.Config.ARGB_8888).also { output ->
    val canvas = AndroidCanvas(output)
    val sourceRectInt =
      Rect(
        sourceRect.left.toInt(),
        sourceRect.top.toInt(),
        sourceRect.right.toInt(),
        sourceRect.bottom.toInt(),
      )
    val destRect = Rect(0, 0, outputSize, outputSize)
    canvas.drawBitmap(bitmap, sourceRectInt, destRect, Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG))
  }
}

internal fun calculateCropSourceRect(
  bitmapWidth: Int,
  bitmapHeight: Int,
  zoom: Float,
  offsetX: Float,
  offsetY: Float,
  outputSize: Int,
): CropSourceRect {
  val squareSizePx = outputSize.toFloat()
  val normalizedScale =
    max(
      squareSizePx / bitmapWidth.toFloat(),
      squareSizePx / bitmapHeight.toFloat(),
    ) * zoom.coerceIn(MIN_ZOOM, MAX_ZOOM)
  val clampedOffset = clampOffsetForBounds(bitmapWidth, bitmapHeight, squareSizePx, normalizedScale, offsetX, offsetY)
  val srcWidth = squareSizePx / normalizedScale
  val srcHeight = squareSizePx / normalizedScale
  val srcLeft = bitmapWidth / 2f - srcWidth / 2f - clampedOffset.first / normalizedScale
  val srcTop = bitmapHeight / 2f - srcHeight / 2f - clampedOffset.second / normalizedScale
  val safeLeft = srcLeft.coerceIn(0f, bitmapWidth - srcWidth)
  val safeTop = srcTop.coerceIn(0f, bitmapHeight - srcHeight)
  return CropSourceRect(safeLeft, safeTop, safeLeft + srcWidth, safeTop + srcHeight)
}

private fun clampOffsetForBounds(
  bitmapWidth: Int,
  bitmapHeight: Int,
  squareSizePx: Float,
  actualScale: Float,
  offsetX: Float,
  offsetY: Float,
): Pair<Float, Float> {
  val halfOverflowX = max((bitmapWidth * actualScale - squareSizePx) / 2f, 0f)
  val halfOverflowY = max((bitmapHeight * actualScale - squareSizePx) / 2f, 0f)
  return offsetX.coerceIn(-halfOverflowX, halfOverflowX) to offsetY.coerceIn(-halfOverflowY, halfOverflowY)
}
