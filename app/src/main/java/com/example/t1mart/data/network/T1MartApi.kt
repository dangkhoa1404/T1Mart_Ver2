package com.example.t1mart.data.network

import com.example.t1mart.data.network.response.ListProducts
import com.example.t1mart.data.network.response.Products
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface T1MartApi {
    @GET("products")
    fun getAllProducts(): Call<ListProducts>
    @GET("products/category/{index}")
    fun getAllProductsFromCategory(@Path("index") type: String): Call<ListProducts>

    @GET("products/{index}")
    fun getProductFromID(@Path("index") id: String): Call<Products>
}