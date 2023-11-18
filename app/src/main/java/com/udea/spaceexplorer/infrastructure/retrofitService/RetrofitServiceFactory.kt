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

    fun makeRetrofitServiceOpenNotify(): ApiOpenNotifyRetrofitService {
        return Retrofit.Builder()
            .baseUrl("http://api.open-notify.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiOpenNotifyRetrofitService::class.java)
    }

    fun makeRetrofitServiceNinja(): ApiNinjaRetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiNinjaRetrofitService::class.java)
    }
}