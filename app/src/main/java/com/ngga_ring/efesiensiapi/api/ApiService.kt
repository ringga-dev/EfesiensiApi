package com.ngga_ring.efesiensiapi.api

import com.ngga_ring.efesiensiapi.models.BaseModels
import com.ngga_ring.efesiensiapi.models.DataModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("transaction?sort=-timestamp&count=true&start=0&start_timestamp=1529856000000&end_timestamp=1680503191391")
    suspend fun getDataPage(
        @Query("limit") sort: String
    ): Response<BaseModels<List<DataModels>>>
}

