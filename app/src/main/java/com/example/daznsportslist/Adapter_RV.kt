package com.example.daznsportslist
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class Adapter_RV (val playerlist : List<String>,val context: Context) : Adapter<Adapter_RV.rv_ViewHolder>() {


    class rv_ViewHolder(itemView: View) : ViewHolder(itemView) {
        val playerName = itemView.findViewById<TextView>(R.id.txtTitle)
        val playerDescription= itemView.findViewById<TextView>(R.id.txtDescription)
        val GotoBtn = itemView.findViewById<Button>(R.id.Goto)
        lateinit var bio: Array<String>
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rv_ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view,parent,false)
        return rv_ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return playerlist.size
    }

    override fun onBindViewHolder(holder: rv_ViewHolder, position: Int) {
        holder.playerName.text= playerlist[position]
        holder.GotoBtn.tag=position

        holder.GotoBtn.setOnClickListener {
            var selectedPos= (it.tag as Int)
            var bundle:Bundle=Bundle().apply {
                putString("info_data", playerlist[selectedPos])
            }
            val intent = Intent(context,Details_page::class.java).apply {
                putExtra("USER_DATA",bundle)
            }
//            bundle.putParcelable("info_data",playerlist.get(selectedPos))//
            context.startActivity(intent)
        }
    }
}