package com.app.jsonexample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    fun getDataFromJson(filename: String): String? {

        var json: String? = null

        try {
            json = applicationContext.assets.open(filename).bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return json

    }

}