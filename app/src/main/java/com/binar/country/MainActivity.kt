package com.binar.country

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getflag()

    }

    fun getflag(){
        ApiClient.instance.getAllFlags()
            .enqueue(object : Callback<List<GetAllCountryItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCountryItem>>,
                    response: Response<List<GetAllCountryItem>>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        val adapters = data?.let { AdapterCountry(it) }


                        val lm = LinearLayoutManager(
                            applicationContext,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        recycler.layoutManager = lm
                        recycler.adapter = adapters

                    }
                }

                override fun onFailure(call: Call<List<GetAllCountryItem>>, t: Throwable) {

                }

            })
}



}