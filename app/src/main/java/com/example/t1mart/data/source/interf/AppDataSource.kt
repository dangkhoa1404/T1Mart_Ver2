package com.example.t1mart.data.source.interf

import com.example.t1mart.data.network.response.ListProducts
import com.example.t1mart.data.network.response.Products
import retrofit2.Call

interface AppDataSource {
    fun getAllProducts(): Call<ListProducts>
    fun getAllProductsFromCategory(type: String): Call<ListProducts>
    fun getProductFromID(id: String): Call<Products>
}