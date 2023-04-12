package com.example.t1mart.ui.main.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.t1mart.data.Repository
import com.example.t1mart.data.network.response.ListProducts
import com.example.t1mart.data.network.response.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private var repository: Repository = Repository()
    var dataListProducts = MutableLiveData<List<Products>>()

    fun callDataListProducts() {
        repository.getAllProducts().enqueue(object : Callback<ListProducts> {
            override fun onResponse(call: Call<ListProducts>, response: Response<ListProducts>) {
                response.body()?.products.let {
                    dataListProducts.value = it
                }
            }

            override fun onFailure(call: Call<ListProducts?>, t: Throwable) {
                Log.d("callDataFailed", "" + t.message)
            }
        })
    }
}