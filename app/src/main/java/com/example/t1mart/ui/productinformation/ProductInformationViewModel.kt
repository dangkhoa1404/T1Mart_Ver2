package com.example.t1mart.ui.productinformation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.t1mart.data.Repository
import com.example.t1mart.data.network.response.ListProducts
import com.example.t1mart.data.network.response.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductInformationViewModel : ViewModel() {
    private var repository: Repository = Repository()
    var productInformation = MutableLiveData<Products>()
    var dataListProducts = MutableLiveData<List<Products>>()

    fun getProductFromID(id: String) {
        repository.getProductFromID(id).enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                response.body().let {
                    productInformation.value = it
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.d("callDataFailed", "" + t.message)
            }
        })
    }

    fun getRelatedProducts(type: String) {
        repository.getAllProductsFromCategory(type).enqueue(object : Callback<ListProducts> {
            override fun onResponse(call: Call<ListProducts>, response: Response<ListProducts>) {
                response.body()?.products.let {
                    dataListProducts.value = it
                }
            }

            override fun onFailure(call: Call<ListProducts>, t: Throwable) {
                Log.d("callDataFailed", "" + t.message)
            }
        })
    }
}