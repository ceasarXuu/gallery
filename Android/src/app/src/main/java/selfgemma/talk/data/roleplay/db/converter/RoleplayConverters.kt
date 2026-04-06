package selfgemma.talk.data.roleplay.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import selfgemma.talk.domain.roleplay.model.MemoryCategory
import selfgemma.talk.domain.roleplay.model.MessageKind
import selfgemma.talk.domain.roleplay.model.MessageSide
import selfgemma.talk.domain.roleplay.model.MessageStatus
import selfgemma.talk.domain.roleplay.model.SessionEventType

class RoleplayConverters {
  private val gson = Gson()

  @TypeConverter
  fun fromStringList(value: List<String>?): String {
    return gson.toJson(value ?: emptyList<String>())
  }

  @TypeConverter
  fun toStringList(value: String?): List<String> {
    if (value.isNullOrBlank()) {
      return emptyList()
    }

    val listType = object : TypeToken<List<String>>() {}.type
    return gson.fromJson(value, listType) ?: emptyList()
  }

  @TypeConverter
  fun fromMessageSide(value: MessageSide): String {
    return value.name
  }

  @TypeConverter
  fun toMessageSide(value: String): MessageSide {
    return enumValueOf(value)
  }

  @TypeConverter
  fun fromMessageKind(value: MessageKind): String {
    return value.name
  }

  @TypeConverter
  fun toMessageKind(value: String): MessageKind {
    return enumValueOf(value)
  }

  @TypeConverter
  fun fromMessageStatus(value: MessageStatus): String {
    return value.name
  }

  @TypeConverter
  fun toMessageStatus(value: String): MessageStatus {
    return enumValueOf(value)
  }

  @TypeConverter
  fun fromMemoryCategory(value: MemoryCategory): String {
    return value.name
  }

  @TypeConverter
  fun toMemoryCategory(value: String): MemoryCategory {
    return enumValueOf(value)
  }

  @TypeConverter
  fun fromSessionEventType(value: SessionEventType): String {
    return value.name
  }

  @TypeConverter
  fun toSessionEventType(value: String): SessionEventType {
    return enumValueOf(value)
  }
}