package com.example.retrofitandrecyclerview

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {


    @GET("api")
    fun getImages(@Query("key") key:String):Call<ImageResponse>

}