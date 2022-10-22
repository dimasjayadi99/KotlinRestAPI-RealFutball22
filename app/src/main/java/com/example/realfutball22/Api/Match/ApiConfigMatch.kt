package com.example.realfutball22.Api.Match

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfigMatch {
    const val baseUrl = "http://api.football-data.org/v4/"

    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() : ApiServiceMatch{
        return getRetrofit().create(ApiServiceMatch::class.java)
    }

}