package selfgemma.talk.feature.roleplay.chat

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import selfgemma.talk.R

private const val TAG = "RoleplaySoundEffects"

object RoleplaySoundEffectPlayer {
  fun playSend(context: Context) {
    play(context, R.raw.iphone_send)
  }

  fun playReceive(context: Context) {
    play(context, R.raw.iphone_back)
  }

  private fun play(context: Context, resId: Int) {
    try {
      val mediaPlayer = MediaPlayer.create(context.applicationContext, resId) ?: return
      mediaPlayer.setOnCompletionListener { player ->
        player.reset()
        player.release()
      }
      mediaPlayer.setOnErrorListener { player, _, _ ->
        player.reset()
        player.release()
        true
      }
      mediaPlayer.start()
    } catch (exception: Exception) {
      Log.d(TAG, "failed to play sound resId=$resId", exception)
    }
  }
}
