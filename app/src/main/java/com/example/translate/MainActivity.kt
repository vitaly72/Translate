package com.example.translate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.translate.Present.Present
import com.example.translate.View.IView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var present: Present
        present = Present(this)
        var myList = mutableListOf<String>()
        applicationContext.assets.open("EngUkr.txt").bufferedReader()
            .useLines { it -> myList.addAll(it) }
        translate.setOnClickListener {
            present.translate(myList)
        }
    }

    override fun onLoginResult(messege: String) {
        Toast.makeText(this, messege, Toast.LENGTH_SHORT).show()
    }

    override fun getEngText(): String {
        return engText.text.toString()
    }

    override fun getUkrText(): String {
        return ukrText.text.toString()
    }

    override fun setUkrText(ukrText1: String) {
        this.ukrText.setText(ukrText1)
    }

    override fun setEngText(engText1: String) {
        this.engText.setText(engText1)
    }

}
