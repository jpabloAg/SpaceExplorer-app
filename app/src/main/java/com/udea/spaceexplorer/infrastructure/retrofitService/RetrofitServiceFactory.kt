package com.udea.spaceexplorer.infrastructure.retrofitService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceFactory {
    fun makeRetrofitService(): ApiNasaRetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiNasaRetrofitService::class.java)
    }
}