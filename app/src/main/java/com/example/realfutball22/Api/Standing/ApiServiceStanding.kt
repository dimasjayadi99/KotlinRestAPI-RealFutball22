package com.example.realfutball22.Api.Standing

import com.example.realfutball22.Model.ResponseStanding
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiServiceStanding {
    @GET("competitions/PD/standings")
    fun getStanding(@Header("X-Auth-Token") token : String) : Call<ResponseStanding>
}