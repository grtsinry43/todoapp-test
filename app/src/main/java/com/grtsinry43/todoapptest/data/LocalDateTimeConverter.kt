package com.grtsinry43.todoapptest.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class LocalDateTimeConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
fun fromTimestamp(value: Long?): LocalDateTime? {
    return value?.let {
        LocalDateTime.ofInstant(Instant.ofEpochMilli(it), ZoneOffset.UTC)
    }
}

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toTimestamp(dateTime: LocalDateTime?): Long? {
        return dateTime?.atZone(ZoneOffset.UTC)?.toInstant()?.toEpochMilli()
    }
}