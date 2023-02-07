package com.example.realfutball22.Api.Match

import com.example.realfutball22.Model.Match.ResponseAllMatch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceMatch {
    // Endpoint of Match Response API With Status Scheduled
    @GET("teams/{id}/matches")
    fun getMatchScheduled(@Path("id") id : Int, @Query("status") status : String, @Header("X-Auth-Token") token : String) : Call<ResponseAllMatch>

    @GET("teams/{id}/matches")
    fun getMatchScheduledPDorCL(@Path("id") id : Int, @Query("status") status : String, @Query("competitions") competitions : String, @Header("X-Auth-Token") token : String) : Call<ResponseAllMatch>

    // Endpoint of Match Response API With Status Finished
    @GET("teams/{id}/matches")
    fun getMatchFinished(@Path("id") id : Int, @Query("status") status : String, @Header("X-Auth-Token") token : String) : Call<ResponseAllMatch>

    @GET("teams/{id}/matches")
    fun getMatchFinishedPDorCL(@Path("id") id : Int, @Query("status") status : String, @Query("competitions") competitions : String, @Header("X-Auth-Token") token : String) : Call<ResponseAllMatch>

}