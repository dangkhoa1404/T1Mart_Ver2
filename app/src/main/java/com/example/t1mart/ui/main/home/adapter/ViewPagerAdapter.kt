package com.example.t1mart.ui.main.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.t1mart.databinding.ViewpagerCustomBinding

class ViewPagerAdapter(
    private val imageListCombo: ArrayList<Int>,
    private val viewPager2: ViewPager2
) :
    RecyclerView.Adapter<ViewPagerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ViewpagerCustomBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageView.setImageResource(imageListCombo[position])
        if (position == imageListCombo.size - 1) {
            viewPager2.post(runnable)
        }
    }

    override fun getItemCount(): Int {
        return imageListCombo.size
    }

    class MyViewHolder(binding: ViewpagerCustomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.imgCombo
    }

    @SuppressLint("NotifyDataSetChanged")
    private val runnable = Runnable {
        imageListCombo.addAll(imageListCombo)
        notifyDataSetChanged()
    }
}
