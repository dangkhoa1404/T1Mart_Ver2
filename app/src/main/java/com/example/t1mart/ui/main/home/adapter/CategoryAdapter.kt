package com.example.t1mart.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.data.network.response.T1mart
import com.example.t1mart.databinding.HomefragmentRecyclerview1CustomBinding

class CategoryAdapter(
    private val newPromotion: ArrayList<T1mart>,
    private var onClick: (String) -> Unit
) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            HomefragmentRecyclerview1CustomBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ).apply {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    newPromotion[adapterPosition].titleText?.let { it1 -> onClick.invoke(it1) }
                }
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(newPromotion[position])
    }

    override fun getItemCount(): Int {
        return newPromotion.size
    }

    class MyViewHolder(private val binding: HomefragmentRecyclerview1CustomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(t1mart: T1mart) {
            binding.run {
                tvIconMarket.text = t1mart.titleText
                Glide.with(itemView.context).load(t1mart.titleImage).into(imgIconMarket)
            }
        }
    }
}