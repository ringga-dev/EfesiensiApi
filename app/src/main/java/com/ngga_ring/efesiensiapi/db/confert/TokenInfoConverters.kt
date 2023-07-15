package com.ngga_ring.efesiensiapi.db.confert

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ngga_ring.efesiensiapi.models.ContractData
import com.ngga_ring.efesiensiapi.models.TokenInfo

object TokenInfoConverters {
    @TypeConverter
    @JvmStatic
    fun stringToTokenInfo(data: String?): TokenInfo? {
        val type = TokenInfo::class.java
        return Gson().fromJson(data, type)
    }

    @TypeConverter
    @JvmStatic
    fun tokenInfoToString(data: TokenInfo?): String? {
        return Gson().toJson(data)
    }
}