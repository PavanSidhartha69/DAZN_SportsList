package com.example.daznsportslist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.adapters.TextViewBindingAdapter.setText

class Details_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var button: Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_item)
        val text = findViewById<TextView>(R.id.textView)
        val Description = intent.getStringExtra("Description")
        text.setText(Description)

        button = findViewById(R.id.bt_share)



        button.setOnClickListener({
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra("Share this", Description)

            val chooser = Intent.createChooser(intent, "Share using..")
            startActivity(chooser)
        })

    }
}