package selfgemma.talk.feature.roleplay.chat

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import android.util.Log
import selfgemma.talk.R

private const val TAG = "RoleplaySoundEffects"

object RoleplaySoundEffectPlayer {
  private val lock = Any()
  private var soundPool: SoundPool? = null
  private var sendSoundId = 0
  private var receiveSoundId = 0
  private var sendLoaded = false
  private var receiveLoaded = false
  private var pendingSendPlay = false
  private var pendingReceivePlay = false

  fun prepare(context: Context) {
    synchronized(lock) {
      if (soundPool != null) {
        return
      }

      val pool =
        SoundPool.Builder()
          .setMaxStreams(2)
          .setAudioAttributes(
            AudioAttributes.Builder()
              .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
              .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
              .build()
          )
          .build()

      pool.setOnLoadCompleteListener { readyPool, sampleId, status ->
        synchronized(lock) {
          if (status != 0) {
            Log.d(TAG, "sound load failed sampleId=$sampleId status=$status")
            return@setOnLoadCompleteListener
          }

          when (sampleId) {
            sendSoundId -> {
              sendLoaded = true
              Log.d(TAG, "send sound loaded")
              if (pendingSendPlay) {
                pendingSendPlay = false
                playLoaded(readyPool, sendSoundId)
              }
            }
            receiveSoundId -> {
              receiveLoaded = true
              Log.d(TAG, "receive sound loaded")
              if (pendingReceivePlay) {
                pendingReceivePlay = false
                playLoaded(readyPool, receiveSoundId)
              }
            }
          }
        }
      }

      sendSoundId = pool.load(context.applicationContext, R.raw.iphone_send, 1)
      receiveSoundId = pool.load(context.applicationContext, R.raw.iphone_back, 1)
      soundPool = pool
      Log.d(TAG, "sound pool prepared sendSoundId=$sendSoundId receiveSoundId=$receiveSoundId")
    }
  }

  fun playSend(context: Context) {
    synchronized(lock) {
      prepare(context)
      val pool = soundPool ?: return
      if (!sendLoaded) {
        pendingSendPlay = true
        Log.d(TAG, "send sound queued until load completes")
        return
      }
      playLoaded(pool, sendSoundId)
    }
  }

  fun playReceive(context: Context) {
    synchronized(lock) {
      prepare(context)
      val pool = soundPool ?: return
      if (!receiveLoaded) {
        pendingReceivePlay = true
        Log.d(TAG, "receive sound queued until load completes")
        return
      }
      playLoaded(pool, receiveSoundId)
    }
  }

  private fun playLoaded(pool: SoundPool, soundId: Int) {
    val streamId = pool.play(soundId, 1f, 1f, 1, 0, 1f)
    Log.d(TAG, "play sound soundId=$soundId streamId=$streamId")
  }
}
