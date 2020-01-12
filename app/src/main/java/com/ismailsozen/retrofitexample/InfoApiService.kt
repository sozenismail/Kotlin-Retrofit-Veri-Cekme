package com.ismailsozen.retrofitexample

import retrofit2.Call
import retrofit2.http.GET

interface InfoApiService{


    @GET("posts")
    fun getInfo(): Call<List<Info>>


}