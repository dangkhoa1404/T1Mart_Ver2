package com.example.t1mart.ui.productinformation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.t1mart.data.Repository
import com.example.t1mart.data.network.response.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductInformationViewModel : ViewModel() {
    private var repository: Repository = Repository()
    var productInformation = MutableLiveData<Products>()

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
}