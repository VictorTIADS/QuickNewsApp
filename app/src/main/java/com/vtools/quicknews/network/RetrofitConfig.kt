package com.vtools.quicknews.network

import com.vtools.quicknews.`interface`.InterfaceRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig(){
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun interfaceData() = retrofit.create(InterfaceRequest::class.java)
}