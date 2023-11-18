package com.udea.spaceexplorer.infrastructure.retrofitService

import com.udea.spaceexplorer.domain.dto.Planet
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiNinjaRetrofitService {
    @GET("planets")
    suspend fun getPlanetDetail(
        @Header("X-Api-Key") apiKey: String,
        @Query("name") name: String,
    ) : List<Planet>
}