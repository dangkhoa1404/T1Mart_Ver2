package com.example.t1mart.data.network.response

import com.google.gson.annotations.SerializedName

data class T1mart(
    var titleImage: Int?,
    var titleText: String?,
    var titleBrand: Int?
)

data class ListProducts(
    @SerializedName("products")
    var products: List<Products>?,
)

data class Products(
    @SerializedName("id")
    var id: Long?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("price")
    var price: Long,
    @SerializedName("discountPercentage")
    var discountPercentage: Double,
    @SerializedName("rating")
    var rating: Double?,
    @SerializedName("stock")
    var stock: Long?,
    @SerializedName("brand")
    var brand: String?,
    @SerializedName("category")
    var category: String?,
    @SerializedName("thumbnail")
    var thumbnail: String,
    @SerializedName("images")
    var images: List<String>?
)
