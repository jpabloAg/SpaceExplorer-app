package com.udea.spaceexplorer.infrastructure.retrofitService

import com.udea.spaceexplorer.domain.dto.ApodResponse
import com.udea.spaceexplorer.domain.dto.ISSPosition
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiOpenNotifyRetrofitService {
    @GET("iss-now.json")
    suspend fun GetISSPosition(
    ) : ISSPosition
}