package com.example.daznsportslist

import android.annotation.SuppressLint
import android.content.Context
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONStringer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class MainActivity : AppCompatActivity() {
    val BASE_URL = "https://mocki.io/v1/"
    lateinit var adapter: SportsListAdapter
    lateinit var jsonString: String
    lateinit var list: RecyclerView
    var listdata = ArrayList<Tiles>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById<RecyclerView>(R.id.playerList)
        //read_json()
        list.layoutManager = LinearLayoutManager(applicationContext)
        getSportsData()

    }

    private fun getSportsData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(SportsListAPI::class.java)
        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<SportsData?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<SportsData?>,
                response: Response<SportsData?>
            ) {
                val responseBody = response.body()!!
                listdata = responseBody.Tiles
                Log.i("LOGGER", listdata.toString())
                adapter = SportsListAdapter(listdata, applicationContext)
                list.adapter = adapter
            }

            override fun onFailure(call: Call<SportsData?>, t: Throwable) {
                Log.i("ONFail", t.toString())
            }
        })
    }

    fun read_json() {

        try {

            try {

                jsonString =
                    this.assets.open(
                        "Details.json"
                    )
                        .bufferedReader()
                        .use { it.readText() }
            } catch (ioException: IOException) {


            }
            val jsonObject = JSONObject(jsonString)
            val ja_data: JSONArray = jsonObject.getJSONArray("Tiles")
            if (ja_data != null) {
                for (i in 0 until ja_data.length()) {
//                    To send individual data
//                    listdata.add(Tiles(
//                        Title= ja_data.getJSONObject(i).getString("Title").toString(),
//                        Description = ja_data.getJSONObject(i).getString("Description").toString(),
//                        Label= ja_data.getJSONObject(i).getString("Label").toString()
//                    ) )


//                    To send whole tile
                    val tile =
                        Gson().fromJson(ja_data.getJSONObject(i).toString(), Tiles::class.java)
                    listdata.add(tile)
                    Log.i("dataLog", tile.toString())
                }
            }

        } catch (e: IOException) {

        }
    }
}
