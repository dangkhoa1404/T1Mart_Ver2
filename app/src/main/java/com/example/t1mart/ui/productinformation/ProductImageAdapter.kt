package com.example.t1mart.ui.productinformation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.databinding.ProductImageCustomBinding

class ProductImageAdapter(private val imageProduct: List<String>) :
    RecyclerView.Adapter<ProductImageAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ProductImageCustomBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(imageProduct[position])
    }

    override fun getItemCount(): Int {
        return imageProduct.size
    }

    class MyViewHolder(private val binding: ProductImageCustomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(images: String) {
            binding.run {
                images.run {
                    Glide.with(itemView.context).load(images).into(imgProduct)
                }
            }
        }
    }
}