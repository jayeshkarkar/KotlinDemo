package com.app.jsonexample

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    internal lateinit var data: ModelData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = GsonBuilder().create()
        data = gson.fromJson(getDataFromJson("animal.json"), ModelData::class.java)

        Log.e("DATA", data.toString())

        rvList.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rvList.adapter = AdapterTags(data.category)

    }

}
