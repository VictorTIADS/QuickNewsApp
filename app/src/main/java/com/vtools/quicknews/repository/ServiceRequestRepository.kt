package com.vtools.quicknews.repository

import com.vtools.quicknews.model.Request
import com.vtools.quicknews.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceRequestRepository() {

    fun getNewsFromApi(Succes: (data: Request) -> Unit,Error: (message: String) -> Unit) {
        val request = RetrofitConfig().interfaceData()
        request.getNews().enqueue(object : Callback<Request>{
            override fun onFailure(call: Call<Request>, t: Throwable) {
                Error(t.message)
            }

            override fun onResponse(call: Call<Request>, response: Response<Request>) {
                if (response.isSuccessful) {

                    if (response.body()!=null){
                        Succes(response.body()!!)
                    }
                }
            }
        })
    }

    fun getNewsWithSearchFromApi(query:String, Succes: (data: Request) -> Unit, Error: (message: String) -> Unit) {
        val request = RetrofitConfig().interfaceData()
        request.getNews(search = query).enqueue(object : Callback<Request>{
            override fun onFailure(call: Call<Request>, t: Throwable) {
                Error(t.message)
            }

            override fun onResponse(call: Call<Request>, response: Response<Request>) {
                if (response.isSuccessful) {

                    if (response.body()!=null){
                        Succes(response.body()!!)
                    }
                }
            }
        })
    }


}