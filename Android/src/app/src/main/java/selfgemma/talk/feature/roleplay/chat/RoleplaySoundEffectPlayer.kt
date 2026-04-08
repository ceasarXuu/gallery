package selfgemma.talk.feature.roleplay.chat

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.util.Log
import selfgemma.talk.R

private const val TAG = "RoleplaySoundEffects"

object RoleplaySoundEffectPlayer {
  private val playbackAttributes =
    AudioAttributes.Builder()
      .setUsage(AudioAttributes.USAGE_MEDIA)
      .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
      .build()

  fun prepare(context: Context) {
    // MediaPlayer has no preload contract comparable to SoundPool. Keep this as a no-op
    // so callers can retain the same lifecycle without special branching.
    Log.d(TAG, "player prepared mode=mediaplayer usage=media")
  }

  fun playSend(context: Context) {
    play(context = context, resId = R.raw.iphone_send, label = "send")
  }

  fun playReceive(context: Context) {
    play(context = context, resId = R.raw.iphone_back, label = "receive")
  }

  private fun play(context: Context, resId: Int, label: String) {
    runCatching {
      val player = checkNotNull(MediaPlayer.create(context.applicationContext, resId)) {
        "MediaPlayer.create returned null for $label sound."
      }
      player.setAudioAttributes(playbackAttributes)
      player.setVolume(1f, 1f)
      player.setOnCompletionListener { completedPlayer ->
        completedPlayer.release()
        Log.d(TAG, "playback completed label=$label")
      }
      player.setOnErrorListener { erroredPlayer, what, extra ->
        Log.e(TAG, "playback error label=$label what=$what extra=$extra")
        erroredPlayer.release()
        true
      }
      player.start()
      Log.d(TAG, "playback started label=$label")
    }
      .onFailure { error ->
        Log.e(TAG, "playback failed label=$label", error)
      }
  }
}
