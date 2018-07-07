package com.app.jsonexample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.jsonexample.AdapterTags
import com.app.jsonexample.ModelData
import com.app.jsonexample.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_one.*

class OneFragment : Fragment() {

    internal lateinit var data: ModelData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_one, container, false)

        val file_name = "animal.json"
        val json_string = activity?.assets?.open(file_name)!!.bufferedReader().use { it.readText() }
        Log.e("data", json_string)

        val gson = GsonBuilder().create()
        data = gson.fromJson(json_string, ModelData::class.java)


        rvLstData?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvLstData?.adapter = AdapterTags(data.category)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = OneFragment().apply {  }
    }
}
