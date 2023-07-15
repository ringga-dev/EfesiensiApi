package com.ngga_ring.efesiensiapi.db.confert

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ngga_ring.efesiensiapi.models.ContractData
import com.ngga_ring.efesiensiapi.models.Cost
import com.ngga_ring.efesiensiapi.models.TokenInfo

object CostConverters {
    @TypeConverter
    @JvmStatic
    fun stringToCost(data: String?): Cost? {
        val type = Cost::class.java
        return Gson().fromJson(data, type)
    }

    @TypeConverter
    @JvmStatic
    fun CostToString(data: Cost?): String? {
        return Gson().toJson(data)
    }
}