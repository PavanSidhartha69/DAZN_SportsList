package com.example.daznsportslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class json_main : AppCompatActivity() {
    lateinit var adapter: SportsListAdapter
    lateinit var list : RecyclerView
    lateinit var jsonString:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_main)
        read_json()
    }
    fun read_json()
    {

        var json : String?=null

       try{
           /*val inputStream:InputStream=assets.open("Details.json")
           json=  inputStream.bufferedReader().use{it.readText()}
           val streamReader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
           val responseStrBuilder = StringBuilder()
           val size: Int = inputStream.available()
           val buffer: ByteArray = ByteArray(size)
           inputStream.read(buffer)
           inputStream.close()

        //   var inputStr: String?
//           while (streamReader.readLine() != null) responseStrBuilder.append(
//               inputStr
//           )

          // val json = String(buffer, "UTF-8")*/
           list = findViewById(R.id.json_text)
           try {

               jsonString =
                  this.assets.open(
                      "Details.json")
                   .bufferedReader()
                   .use { it.readText() }
           } catch (ioException: IOException) {


           }
           val jsonObject = JSONObject(jsonString)
           val ja_data: JSONArray = jsonObject.getJSONArray("Tiles")
           val listdata = ArrayList<Tiles>()
            if (ja_data != null) {
               for (i in 0 until ja_data.length()) {
                   listdata.add(Tiles(Label = ja_data.getJSONObject(i).getString("Label")) )
               }
           }
           adapter= SportsListAdapter(listdata,this)

           list.adapter=adapter
           list.layoutManager=LinearLayoutManager(this)
       } catch (e : IOException)
       {

       }
    }
}