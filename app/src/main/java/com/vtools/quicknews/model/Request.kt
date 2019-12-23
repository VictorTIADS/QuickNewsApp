package com.vtools.quicknews.model

data class Request(val status:String? = null,val totalResults:Int,val articles:ArrayList<Article>)