package com.ngga_ring.efesiensiapi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ngga_ring.efesiensiapi.api.Resource
import com.ngga_ring.efesiensiapi.models.BaseModels
import com.ngga_ring.efesiensiapi.models.DataModels
import com.ngga_ring.efesiensiapi.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val userRepository: DataRepository,
) : ViewModel() {

    fun getData(limit:String): LiveData<Resource<BaseModels<List<DataModels>>>> {
        val dataResult = MutableLiveData<Resource<BaseModels<List<DataModels>>>>()
        dataResult.value = Resource.loading()

        viewModelScope.launch {
            try {
                val resource = userRepository.getData(limit)
                dataResult.value = resource
            } catch (e: Exception) {
                val errorMessage = e.localizedMessage ?: "Unknown error occurred"
                dataResult.value = Resource.error(errorMessage)
            }
        }
        return dataResult
    }

    fun getoffline(): LiveData<Resource<List<DataModels>>> {
        val dataResult = MutableLiveData<Resource<List<DataModels>>>()

        viewModelScope.launch {
            try {
                val resource = userRepository.getUser()
                dataResult.value = Resource.success(resource)
            } catch (e: Exception) {
                val errorMessage = e.localizedMessage ?: "Unknown error occurred"
                dataResult.value = Resource.error(errorMessage)
            }
        }
        return dataResult
    }

    fun saveData(data: List<DataModels>): MutableLiveData<Resource<List<DataModels>>> {
        val dataResult = MutableLiveData<Resource<List<DataModels>>>()
        viewModelScope.launch {
            try {
                userRepository.saveData(data)
                dataResult.value = Resource.success(data)
            } catch (e: Exception) {
                val errorMessage = e.localizedMessage ?: "Unknown error occurred"
                dataResult.value = Resource.error(errorMessage)
            }
        }
        return dataResult
    }
}