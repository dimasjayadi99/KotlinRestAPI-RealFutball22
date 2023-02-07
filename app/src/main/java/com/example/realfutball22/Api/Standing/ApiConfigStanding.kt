package com.example.realfutball22.Api.Standing

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfigStanding {

    const val baseURL = "http://api.football-data.org/v4/"

    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() : ApiServiceStanding {
        return getRetrofit().create(ApiServiceStanding::class.java)
    }

}