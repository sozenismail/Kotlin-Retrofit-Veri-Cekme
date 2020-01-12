package com.ismailsozen.retrofitexample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InfoServiceProvider{

    private val retrofit:Retrofit=Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.SERVER_URL)
        .build()

    private val apiService:InfoApiService=retrofit.create(InfoApiService::class.java)

    fun getInfoService():InfoApiService=apiService

}