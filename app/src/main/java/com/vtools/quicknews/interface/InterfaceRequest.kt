package com.vtools.quicknews.`interface`

import com.vtools.quicknews.model.Request
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InterfaceRequest {
    @GET("v2/{endpoint}")
    fun getNews(
        @Path("endpoint")endPoint:String = "top-headlines",
        @Query("q")search:String = "",
        @Query("language")language:String = "",
        @Query("category")category:String = "",
        @Query("country")country:String = "br",
        @Query("apiKey")apiKey:String = "5d984c7e027e4edfa5ad7c8e1a323959"
    ): Call<Request>
}