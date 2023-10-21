package com.udea.spaceexplorer.infrastructure.retrofitService

import com.udea.spaceexplorer.domain.dto.ApodResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNasaRetrofitService {
    @GET("planetary/apod")
    suspend fun listMostRecentPictures(
        @Query("api_key") apiKey: String,
        @Query("count") count: Int,
    ) : List<ApodResponse>
}