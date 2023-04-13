package com.example.t1mart.ui.main.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.data.network.response.T1mart
import com.example.t1mart.databinding.ListCategoriesCustomBinding

class CategoryAdapter(private val newCategory: ArrayList<T1mart>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ListCategoriesCustomBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(newCategory[position])
    }

    override fun getItemCount(): Int {
        return newCategory.size
    }

    class MyViewHolder(private val binding: ListCategoriesCustomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(t1mart: T1mart) {
            binding.run {
                tvCategory.text = t1mart.titleText
                Glide.with(itemView.context).load(t1mart.titleImage).into(imgCategory)
            }
        }
    }
}