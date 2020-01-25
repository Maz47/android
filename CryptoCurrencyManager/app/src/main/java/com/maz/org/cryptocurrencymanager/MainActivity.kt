package com.maz.org.cryptocurrencymanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        getFirst10()
    }

//    private fun getFirst10() {
//        val client = OkHttpClient()
//        val request = Request.Builder().url("https://api.coinmarketcap.com/v1/ticker/?start=0&limit=10").build()
//        client.newCall(request).enqueue(object : Callback {
//
//            override fun onFailure(call: Call, e: IOException) {
//                Log.d("ERROR", e.toString())
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                val body = response.body!!.toString()
//                val gson = Gson()
//                val newCurrencies = gson.fromJson<List<CurrencyModel>>(body, object : TypeToken<List<CurrencyModel>>(){}.type)
//                runOnUiThread{
//                    currencies.addAll(newCurrencies)
//                    adapter.setLoaded()
//                }
//
//            }
//
//        })
//
//    }
}
