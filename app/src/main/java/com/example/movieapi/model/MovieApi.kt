package com.example.movieapi.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET(".")
    fun getMovie(
        @Query("t") name:String,
        @Query("apikey") key:String = "726f863f"
    ): Call<MovieModel>

}