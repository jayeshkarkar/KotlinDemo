package com.app.jsonexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.list_item.view.*

class AdapterTags(val tags: List<ModelData.Category>) : RecyclerView.Adapter<AdapterTags.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val pos = tags.get(position)
        holder.view.tvTitle.text = pos.sub_title
        holder.view.tvTags.text = pos.tags
        holder.view.tvTitle.setOnClickListener {
            Toast.makeText(holder.view.context, "" + pos.tags, Toast.LENGTH_SHORT).show()

        }

    }

    override fun getItemCount(): Int {
        return tags.count()
    }

    class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
