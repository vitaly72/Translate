package com.example.translate.Model

interface IDictionary {
    fun translateFromEngToUkr(engText:String):String
    fun translateFromUkrToEng(ukrText:String):String
    fun isValidDate(text:String): String
    fun loadFromFile(list:MutableList<String>,bool:Boolean)
}