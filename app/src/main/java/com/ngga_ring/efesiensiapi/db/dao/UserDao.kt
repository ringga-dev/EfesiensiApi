package com.ngga_ring.efesiensiapi.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ngga_ring.efesiensiapi.models.DataModels

@Dao
interface UserDao {

    @Query("SELECT * FROM datamodels")
    suspend fun getUser(): List<DataModels>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(dataList: List<DataModels>)

    @Query("DELETE FROM datamodels")
    suspend fun deleteAll()


}