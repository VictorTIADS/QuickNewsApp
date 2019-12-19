package com.vtools.quicknews.viewmodel.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vtools.quicknews.model.BaseModel
import com.vtools.quicknews.model.Request
import com.vtools.quicknews.repository.ServiceRequestRepository

class HomeViewModel(val service:ServiceRequestRepository) : ViewModel() {
    val dataNews = MutableLiveData <BaseModel<Request>>()



    fun getNews(){
        dataNews.value = BaseModel(null, BaseModel.Companion.STATUS.LOADING,null)
        service.getNewsFromApi({
            dataNews.value = BaseModel(it, BaseModel.Companion.STATUS.SUCCESS,null)
        },{
            dataNews.value = BaseModel(null, BaseModel.Companion.STATUS.ERROR,it)
        })
    }

    fun getNewsSearch(query:String){
        dataNews.value = BaseModel(null, BaseModel.Companion.STATUS.LOADING,null)
        service.getNewsWithSearchFromApi(query,{
            dataNews.value = BaseModel(it, BaseModel.Companion.STATUS.SUCCESS,null)
        },{
            dataNews.value = BaseModel(null, BaseModel.Companion.STATUS.ERROR,it)
        })
    }
}