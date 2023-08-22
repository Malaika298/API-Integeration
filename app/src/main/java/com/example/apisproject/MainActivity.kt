package com.example.apisproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apisproject.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val retrofitBuilder = Retrofit.Builder()

            .baseUrl("https://dummyjson.com/")

            .addConverterFactory(GsonConverterFactory.create())

            .build()

            .create(ApiInterface::class.java)

//        get data from interface
        val retrofitData = retrofitBuilder.getproductdata()

//        ctrl shift space press for response or failure method
        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {

                var responseBody = response.body()

                val productList = responseBody?.products!!

                myAdapter = MyAdapter(this@MainActivity, productList)

                binding.recyclerView.adapter = myAdapter

                binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
//                data append using string builder
//
//                val collectDataInS = StringBuilder()

//                if (productList != null)

//                    for (myData in productList){
//
//                        collectDataInS.append(myData.title + " ")
//
//                }
//
//
//                binding.tVshowData.text = collectDataInS
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("Main Activity ", "On Failure" +  t.message)
            }
        })
    }
}