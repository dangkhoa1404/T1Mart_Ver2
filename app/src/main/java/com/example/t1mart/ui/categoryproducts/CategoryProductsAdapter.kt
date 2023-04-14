package com.example.t1mart.ui.categoryproducts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.data.network.response.Products
import com.example.t1mart.databinding.ListProductsCustomBinding
import kotlin.math.roundToInt

class CategoryProductsAdapter(private val listProducts: List<Products>) :
    RecyclerView.Adapter<CategoryProductsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ListProductsCustomBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(listProducts[position])
    }

    override fun getItemCount(): Int {
        return listProducts.size
    }

    class MyViewHolder(private val binding: ListProductsCustomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(products: Products) {
            binding.run {
                products.run {
                    Glide.with(itemView.context).load(thumbnail).into(imgThumbnailProduct)
                    tvTitleProduct.text = title
                    tvCategoryProduct.text = category
                    tvPriceProduct.text = price.toString()
                    tvRatingProduct.text = rating.toString()
                    val salePrice: Double = price * 1.0 * (100.0 - discountPercentage)
                    val salePrice2Digit: Double = salePrice.roundToInt() / 100.0
                    tvSalePriceProduct.text = salePrice2Digit.toString()
                }
            }
        }
    }
}