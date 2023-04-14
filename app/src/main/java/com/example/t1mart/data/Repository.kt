package com.example.t1mart.data

import com.example.t1mart.data.network.response.ListProducts
import com.example.t1mart.data.source.interf.AppDataSource
import com.example.t1mart.data.source.remote.RemoteDataSource
import retrofit2.Call

class Repository : AppDataSource {
    override fun getAllProducts(): Call<ListProducts> {
        return RemoteDataSource.listProductsApi.getAllProducts()
    }

    override fun getAllProductsFromCategory(type: String): Call<ListProducts> {
        return RemoteDataSource.listProductsApi.getAllProductsFromCategory(type)
    }
}