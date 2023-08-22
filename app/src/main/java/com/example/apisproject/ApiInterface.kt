package com.example.apisproject

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    fun getproductdata(): Call<MyData>
}