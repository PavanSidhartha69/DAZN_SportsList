package com.example.daznsportslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.daznsportslist.databinding.ActivityMainBinding
import com.example.daznsportslist.databinding.ItemViewBinding

class Adapter_RV(val playerList: List<String>) : Adapter<Adapter_RV.rv_ViewHolder>() {
    class rv_ViewHolder(val binding: ItemViewBinding?) : RecyclerView.ViewHolder(binding!!.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rv_ViewHolder {
        val vbinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return rv_ViewHolder(vbinding)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: rv_ViewHolder, position: Int) {
        holder.binding!!.playerName = playerList[position]
    }
}