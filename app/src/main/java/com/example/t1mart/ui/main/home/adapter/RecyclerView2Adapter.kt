package com.example.t1mart.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.data.network.response.T1mart
import com.example.t1mart.databinding.HomefragmentRecyclerview1CustomBinding
import com.example.t1mart.databinding.HomefragmentRecyclerview2CustomBinding
import com.example.t1mart.util.AppConstant

class RecyclerView2Adapter(
    private val newPromotion: ArrayList<T1mart>,
    private var onClick: (String) -> Unit
) :
    RecyclerView.Adapter<RecyclerView2Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            HomefragmentRecyclerview2CustomBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ).apply {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    val randomNumber = (1..100).random()
                    onClick.invoke(randomNumber.toString())
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

    class MyViewHolder(private val binding: HomefragmentRecyclerview2CustomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(t1mart: T1mart) {
            binding.run {
                tvDesProduct.text = t1mart.titleText
                Glide.with(itemView.context).load(t1mart.titleImage).into(imgProduct)
            }
        }
    }
}