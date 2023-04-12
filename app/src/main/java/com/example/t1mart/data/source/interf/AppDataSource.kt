package com.example.t1mart.data.source.interf

import com.example.t1mart.data.network.response.ListProducts
import retrofit2.Call

interface AppDataSource {
    fun getAllProducts(): Call<ListProducts>
}