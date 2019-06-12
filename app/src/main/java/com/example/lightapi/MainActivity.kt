package com.example.lightapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import com.google.gson.reflect.TypeToken



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val httpClient = OkHttpClient.Builder().build()

        val baseurl = "http://api.nightlights.io/months/1993.3-1993.4/states/"

        btnsubmit.setOnClickListener {
            val name = et.text.toString()
            val request = Request.Builder().url("$baseurl$name${"/districts"}").build()
            httpClient.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    val responseBody = response.body()
                    val result = responseBody?.string()
                    val gson = Gson()

                    val listType = object : TypeToken<List<light>>(){}.type

                    val light = gson.fromJson<ArrayList<light>>(result , listType)
                    runOnUiThread {
                        recyler.layoutManager = LinearLayoutManager(baseContext)
                        recyler.adapter = Lightadapter(light)
                    }

                }

            })

        }


    }
}
