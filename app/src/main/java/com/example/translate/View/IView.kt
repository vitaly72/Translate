package com.example.translate.View

interface IView {
    fun onLoginResult(messege: String)
    fun getEngText():String
    fun getUkrText():String
    fun setUkrText(ukrText1:String)
    fun setEngText(engText1:String)
}