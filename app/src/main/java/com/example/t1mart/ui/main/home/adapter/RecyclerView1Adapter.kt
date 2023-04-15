package com.example.t1mart.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.data.network.response.T1mart
import com.example.t1mart.databinding.HomefragmentRecyclerview1CustomBinding

class RecyclerView1Adapter(private val newPromotion: ArrayList<T1mart>) :
    RecyclerView.Adapter<RecyclerView1Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            HomefragmentRecyclerview1CustomBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
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