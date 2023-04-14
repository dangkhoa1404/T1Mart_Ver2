package com.example.t1mart.data.network

import com.example.t1mart.data.network.response.ListProducts
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface T1MartApi {
    @GET("products")
    fun getAllProducts(): Call<ListProducts>
    @GET("products/category/{index}")
    fun getAllProductsFromCategory(@Path("index") type: String): Call<ListProducts>
}