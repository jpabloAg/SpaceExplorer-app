package com.udea.spaceexplorer.infrastructure.retrofitService

import com.udea.spaceexplorer.domain.dto.ApodResponse
import com.udea.spaceexplorer.domain.dto.MarsRover
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNasaRetrofitService {
    @GET("planetary/apod")
    suspend fun listMostRecentPictures(
        @Query("api_key") apiKey: String,
        @Query("count") count: Int,
    ) : List<ApodResponse>

    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun listMarsRoverPhotos(
        @Query("api_key") apiKey: String,
        @Query("sol") sol: Int,
    ) : List<MarsRover>
}