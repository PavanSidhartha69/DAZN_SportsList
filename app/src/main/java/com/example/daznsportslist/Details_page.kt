package com.example.daznsportslist

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.transition.Transition
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.SimpleTarget
import java.io.File
import java.io.FileOutputStream
import java.net.URI


class Details_page : AppCompatActivity() {
    lateinit var bitmap: Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_page)
        val text = findViewById<TextView>(R.id.textView)
        val title = findViewById<TextView>(R.id.matchTitle)
        val img = findViewById<ImageView>(R.id.imageView)
        val Description = intent.getStringExtra("Description")
        val str = intent.getStringExtra("ImageURL")
        text.setText(Description)
        title.setText(intent.getStringExtra("Title"))
        Glide.with(this)
            .load(intent.getStringExtra("ImageURL"))
            .apply(RequestOptions().override(1000,400))
            .centerCrop()
            .into(img)
        var button: Button = findViewById<Button>(R.id.bt_share)
        val imgURI = Uri.parse(str)

        button.setOnClickListener {
            val uri = URI(str)
            val url = uri.toURL()
            Glide.with(this)
                .asBitmap()
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(RequestOptions().override(500, 500)) // specify image size
                .into(object : SimpleTarget<Bitmap>() {
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
                    ) {
                        Log.i("Whatsapp","hiiii")
                        val baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
                        val file = File.createTempFile(baseDir,null)
                        val outputStream = FileOutputStream(file)
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream)
                        outputStream.flush()
                        outputStream.close()
                    }

                })
//            val url = uri.toURL()
//            val connection = url.openConnection()
//            connection.doInput = true
//            connection.connect()
//            val input = connection.getInputStream()
//            val bitmap = BitmapFactory.decodeStream(input)

            val wintent = Intent(Intent.ACTION_SEND)
            //wintent.type = "text/plain"
            wintent.setPackage("com.whatsapp")
            //wintent.putExtra(Intent.EXTRA_TEXT, Description)
            wintent.putExtra(Intent.EXTRA_STREAM,uri)
            wintent.setType("image/jpeg")
            wintent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            //val chooser = Intent.createChooser(wintent, "Share using..")
            startActivity(wintent)
        }

    }
}