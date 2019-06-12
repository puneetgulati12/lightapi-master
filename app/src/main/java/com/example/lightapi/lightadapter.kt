package com.example.lightapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*
import java.util.ArrayList

class Lightadapter (val any1 : ArrayList<light>) : RecyclerView.Adapter<Lightadapter.LightHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): LightHolder {
        val li = LayoutInflater.from(p0.context)
        val inflater = li.inflate(R.layout.item_row , p0 , false)
        return LightHolder(inflater)

    }

    override fun getItemCount(): Int {

        return  any1.size
    }

    override fun onBindViewHolder(lightHolder: Lightadapter.LightHolder, p1: Int) {
        val current = any1[p1]
        lightHolder.itemView.satellite.text = current.satellite
        lightHolder.itemView.count.text = current.count.toString()
        lightHolder.itemView.vismedian.text = current.vis_median
    }

    class LightHolder (itemView: View) : RecyclerView.ViewHolder(itemView)

}