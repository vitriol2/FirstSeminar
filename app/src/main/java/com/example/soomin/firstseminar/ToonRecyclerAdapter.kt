package com.example.soomin.firstseminar

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ToonRecyclerAdapter(val ctx : Context, val dataList : ArrayList<ToonData>) : RecyclerView.Adapter<ToonRecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.rv_toon, p0, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.title.text = dataList[p1].title
    }

    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.rv_toon_title) as TextView
    }
}

data class ToonData(val title : String)