package com.example.daznsportslist
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class Adapter_RV(val playerList: List<String>) : Adapter<Adapter_RV.rv_ViewHolder>() {


    class rv_ViewHolder(itemView: View) : ViewHolder(itemView) {
        val playerName = itemView.findViewById<TextView>(R.id.txtTitle)
        val playerDescription = itemView.findViewById<TextView>(R.id.txtDescription)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rv_ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return rv_ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: rv_ViewHolder, position: Int) {
        holder.playerName.text = playerList[position]
    }
}