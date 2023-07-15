package com.ngga_ring.efesiensiapi.db.confert

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

object StringConverters {
    var gson = Gson()
    @TypeConverter
    @JvmStatic
    fun stringToList(data: String?): ArrayList<String>? {
        if (data == null) {
            return arrayListOf()
        }
        val listType = object : TypeToken<ArrayList<String>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    @JvmStatic
    fun listToString(data: ArrayList<String>?): String? {
        return gson.toJson(data)
    }
}