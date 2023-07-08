package com.example.cleanarchitecture.utillity

import androidx.room.TypeConverter
import java.util.Date

object DataConverter {
    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return if (dateLong == null) null else Date(dateLong)
    }

    @TypeConverter
    fun fromDate(date: Date?): Long?{
        return date?.time
    }
}