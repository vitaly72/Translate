package com.example.translate.Present

import com.example.translate.Model.Dictionary
import com.example.translate.View.IView

class Present : IPresent {
    var IView: IView

    constructor(_view: IView) {
        IView = _view
    }


    override fun translate(list: MutableList<String>) {

        var engInputText = IView.getEngText().toString()
        var ukrInputText = IView.getUkrText().toString()
        if (engInputText.isNotEmpty() && ukrInputText.length == 0) {
            var ukrText = Dictionary(list).translateFromEngToUkr(engInputText)
            if (ukrText != "null") {
                this.IView.setUkrText(ukrText)
                this.IView.onLoginResult("Good")
            } else {
                this.IView.onLoginResult("Not find translate")
            }
        }
        if (engInputText.length == 0 && ukrInputText.isNotEmpty()) {
            var engText = Dictionary(list).translateFromUkrToEng(ukrInputText)
            if (engText != "null") {
                this.IView.setEngText(engText)
                this.IView.onLoginResult("Good")
            } else {
                this.IView.onLoginResult("Not find translate")
            }
        }


    }
}