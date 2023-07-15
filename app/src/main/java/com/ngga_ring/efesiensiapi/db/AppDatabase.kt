package com.ngga_ring.efesiensiapi.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ngga_ring.efesiensiapi.db.dao.UserDao
import com.ngga_ring.efesiensiapi.models.DataModels

@Database(entities = [DataModels::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}