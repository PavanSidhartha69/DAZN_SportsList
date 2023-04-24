package com.example.daznsportslist

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.daznsportslist.databinding.ItemViewBinding

class SportsListAdapter(val playerList: List<Tiles>, val context: Context) :
    Adapter<SportsListAdapter.rv_ViewHolder>() {
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
        Log.i("msg", playerList[position].toString())
        holder.binding!!.playerName = playerList[position].Title
//        holder.binding!!.playerDescription = playerList[position].Description
        holder.binding.cardView.setOnClickListener {
            val intent = Intent(context, Details_page::class.java)
            intent.putExtra("Description", playerList[position].Description.toString())
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent)
        }
    }
}