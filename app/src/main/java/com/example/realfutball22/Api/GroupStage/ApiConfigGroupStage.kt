package com.example.realfutball22.Api.GroupStage

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfigGroupStage {
    const val base_url = "http://api.football-data.org/v4/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService(): ApiServiceGroupStage {
        return getRetrofit().create(ApiServiceGroupStage::class.java)
    }

}