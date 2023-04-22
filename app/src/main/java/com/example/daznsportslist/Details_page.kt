package com.example.daznsportslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.adapters.TextViewBindingAdapter.setText

class Details_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_item)
        val text = findViewById<TextView>(R.id.textView)
        val Description = intent.getStringExtra("Description")
        text.setText(Description)
    }
}