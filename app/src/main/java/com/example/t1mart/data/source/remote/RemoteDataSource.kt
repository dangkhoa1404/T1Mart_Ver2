package com.example.t1mart.data.source.remote

import com.example.t1mart.data.network.T1MartApi
import com.example.t1mart.data.network.response.ListProducts
import com.example.t1mart.data.source.interf.AppDataSource
import com.example.t1mart.util.AppConstant
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource : AppDataSource {
    override fun getAllProducts(): Call<ListProducts> {
        return listProductsApi.getAllProducts()
    }

    override fun getAllProductsFromCategory(type: String): Call<ListProducts> {
        return listProductsApi.getAllProductsFromCategory(type)
    }

    companion object {
        var listProductsApi: T1MartApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(AppConstant.LIST_PRODUCTS)
            .build()
            .create(T1MartApi::class.java)
    }
}