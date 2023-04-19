package com.example.t1mart.ui.signin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.data.network.response.T1mart
import com.example.t1mart.databinding.AnotherwaySigninCustomBinding

class SignInAdapter(private val logoSignIn: ArrayList<T1mart>) :
    RecyclerView.Adapter<SignInAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            AnotherwaySigninCustomBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(logoSignIn[position])
    }

    override fun getItemCount(): Int {
        return logoSignIn.size
    }

    class MyViewHolder(private val binding: AnotherwaySigninCustomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(t1mart: T1mart) {
            binding.run {
                Glide.with(itemView.context).load(t1mart.titleImage).into(imgAnotherWaySignIn)
            }
        }
    }
}