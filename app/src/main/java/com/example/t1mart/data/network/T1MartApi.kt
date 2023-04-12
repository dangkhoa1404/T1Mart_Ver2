package com.example.t1mart.data.network

import com.example.t1mart.data.network.response.ListProducts
import retrofit2.http.GET
import retrofit2.Call

interface T1MartApi {
    @GET("products")
    fun getAllProducts(): Call<ListProducts>
}