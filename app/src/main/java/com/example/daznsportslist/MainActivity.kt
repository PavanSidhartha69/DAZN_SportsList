package com.example.daznsportslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var adapter: SportsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val randomList : List<String> = listOf("HWLL","ASDAD","gfdgfdg","sdfsfewweffew","asdfsadsadadwqq","SFDDSFDSFsf","AFEEFAFSF","sfdsfdsfdsfds","HWLL","ASDAD","gfdgfdg","sdfsfewweffew","asdfsadsadadwqq","SFDDSFDSFsf","AFEEFAFSF","sfdsfdsfdsfds")

        val list = findViewById<RecyclerView>(R.id.playerList)
        //adapter=SportsListAdapter(randomList,this)
        list.adapter=adapter
        list.layoutManager= LinearLayoutManager(this)
    }
}
