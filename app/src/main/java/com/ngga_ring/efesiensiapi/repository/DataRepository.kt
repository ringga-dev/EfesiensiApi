package com.ngga_ring.efesiensiapi.repository

import android.util.Log
import com.ngga_ring.efesiensiapi.api.ApiService
import com.ngga_ring.efesiensiapi.api.Resource
import com.ngga_ring.efesiensiapi.db.dao.UserDao
import com.ngga_ring.efesiensiapi.models.BaseModels
import com.ngga_ring.efesiensiapi.models.DataModels
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao
) {

    suspend fun getData(limit:String): Resource<BaseModels<List<DataModels>>> {
        return try {
            val response = apiService.getDataPage(limit)
            Log.e("Ringga ::", response.toString())
            if (response.isSuccessful) {
                val userResponse = response.body()
                Resource.success(userResponse)
            } else {
                Resource.error("Data failed")
            }
        } catch (e: Exception) {
            Resource.error(e.localizedMessage ?: "Unknown error occurred")
        }
    }
    suspend fun getUser(): List<DataModels> {
        return userDao.getUser()
    }
    suspend fun saveData(data: List<DataModels>){
        userDao.deleteAll()
        userDao.insertAll(data)
    }
}