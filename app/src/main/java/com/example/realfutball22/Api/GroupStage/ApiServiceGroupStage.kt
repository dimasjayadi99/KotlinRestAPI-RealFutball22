package com.example.realfutball22.Api.GroupStage

import com.example.realfutball22.Model.Group.ResponseGroupStage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiServiceGroupStage {
    @GET("competitions/CL/standings")
    fun getGroupStage(@Header("X-Auth-Token") token: String): Call<ResponseGroupStage>

}