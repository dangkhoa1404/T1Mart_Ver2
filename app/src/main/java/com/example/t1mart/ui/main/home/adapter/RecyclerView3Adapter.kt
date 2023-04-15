package com.example.t1mart.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.data.network.response.T1mart
import com.example.t1mart.databinding.HomefragmentRecyclerview3CustomBinding
import com.example.t1mart.util.AppConstant

class RecyclerView3Adapter(
    private val newPromotion: ArrayList<T1mart>,
    private var onClick: (String) -> Unit
) :
    RecyclerView.Adapter<RecyclerView3Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            HomefragmentRecyclerview3CustomBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ).apply {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    val category = listOf(
                        AppConstant.NAME_CATEGORY_1,
                        AppConstant.NAME_CATEGORY_2,
                        AppConstant.NAME_CATEGORY_3,
                        AppConstant.NAME_CATEGORY_4,
                        AppConstant.NAME_CATEGORY_5,
                        AppConstant.NAME_CATEGORY_6,
                        AppConstant.NAME_CATEGORY_7,
                        AppConstant.NAME_CATEGORY_8,
                        AppConstant.NAME_CATEGORY_9,
                        AppConstant.NAME_CATEGORY_10,
                        AppConstant.NAME_CATEGORY_11,
                        AppConstant.NAME_CATEGORY_12,
                        AppConstant.NAME_CATEGORY_13,
                        AppConstant.NAME_CATEGORY_14,
                        AppConstant.NAME_CATEGORY_15,
                        AppConstant.NAME_CATEGORY_16,
                        AppConstant.NAME_CATEGORY_17,
                        AppConstant.NAME_CATEGORY_18,
                        AppConstant.NAME_CATEGORY_19,
                        AppConstant.NAME_CATEGORY_20
                    ).random()
                    onClick.invoke(category)
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

    class MyViewHolder(private val binding: HomefragmentRecyclerview3CustomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(t1mart: T1mart) {
            binding.run {
                tvDesProduct.text = t1mart.titleText
                Glide.with(itemView.context).load(t1mart.titleImage).into(imgProduct)
                Glide.with(itemView.context).load(t1mart.titleBrand).into(imgBrandProduct)
            }
        }
    }
}