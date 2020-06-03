package com.example.translate.Model

import java.io.*

class Dictionary : IDictionary {
    var map: MutableMap<String, String>
    var list:MutableList<String>
    var map1: MutableMap<String, String>
    var bool=false

    constructor(list:MutableList<String>) {
        this.map = HashMap<String, String>();
        this.map1 = HashMap<String, String>();
        this.list=list

    }

    override fun translateFromEngToUkr(engText: String): String {
        bool=true
        loadFromFile(list,bool)
        return map.get(engText).toString()
    }

    override fun translateFromUkrToEng(ukrText: String): String {
        bool=false
        loadFromFile(list,bool)
        return map.get(ukrText).toString()
    }

    override fun isValidDate(text: String): String {
        return ""
    }


    override fun loadFromFile(list:MutableList<String>,bool:Boolean) {

        for (s in list) {
            var words:Array<String>
            words=s.split(";").toTypedArray() // "cat;kit"  -> ["cat", "kit"]
            if(bool==true)this.map.put(words.get(0), words.get(1))
            if(bool==false)this.map.put(words.get(1), words.get(0))
        }
    }
}

