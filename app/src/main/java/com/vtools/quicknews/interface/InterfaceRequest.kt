package com.vtools.quicknews.`interface`

import com.vtools.quicknews.model.Request
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InterfaceRequest {
    @GET("v2/{endpoint}")
    fun getNews(
        @Path("endpoint")endPoint:String = "everything",
        @Query("q")search:String = "pernambuco",
        @Query("language")language:String = "pt",
        @Query("category")category:String = "",
        @Query("country")country:String = "",
        @Query("apiKey")apiKey:String = "5d984c7e027e4edfa5ad7c8e1a323959"
    ): Call<Request>
}