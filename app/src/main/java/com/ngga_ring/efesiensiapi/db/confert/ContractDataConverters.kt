package com.ngga_ring.efesiensiapi.db.confert

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ngga_ring.efesiensiapi.models.ContractData

object ContractDataConverters {
    @TypeConverter
    @JvmStatic
    fun stringToContractData(data: String?): ContractData? {
        val type = ContractData::class.java
        return Gson().fromJson(data, type)
    }

    @TypeConverter
    @JvmStatic
    fun contractDataToString(data: ContractData?): String? {
        return Gson().toJson(data)
    }
}