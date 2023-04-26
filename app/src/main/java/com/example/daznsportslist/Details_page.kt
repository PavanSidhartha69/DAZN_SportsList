package com.example.daznsportslist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Details_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_page)
        val text = findViewById<TextView>(R.id.textView)
        val title = findViewById<TextView>(R.id.matchTitle)
        val Description = intent.getStringExtra("Description")
        text.setText(Description)
        title.setText(intent.getStringExtra("Title"))
        var button: Button = findViewById<Button>(R.id.bt_share)

        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, Description)

            val chooser = Intent.createChooser(intent, "Share using..")
            startActivity(chooser)
        }

    }
}