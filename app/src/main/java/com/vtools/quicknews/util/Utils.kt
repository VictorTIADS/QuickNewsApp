package com.vtools.quicknews.util

fun convertMonthToWord(month:String):String{
    return when (month){
        "01" ->{
            return "Janeiro"
        }
        "02" ->{
            return "Fevereiro"
        }
        "03" ->{
            return "Março"
        }
        "04" ->{
            return "Abril"
        }
        "05" ->{
            return "Maio"
        }
        "06" ->{
            return "Junho"
        }
        "07" ->{
            return "Julho"
        }
        "08" ->{
            return "Agosto"
        }
        "09" ->{
            return "Setembro"
        }
        "10" ->{
            return "Outubro"
        }
        "11" ->{
            return "Novembro"
        }
        "12" ->{
            return "Dezembro"
        }
        else -> {
            return ""
        }
    }
}