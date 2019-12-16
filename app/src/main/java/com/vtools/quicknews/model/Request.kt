package com.vtools.quicknews.model

data class Request(val status:String,val totalResults:Int,val articles:ArrayList<Article>)