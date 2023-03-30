package com.example.t1mart.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.t1mart.ui.main.home.HomeFragment
import com.example.t1mart.ui.main.information.InformationFragment
import com.example.t1mart.ui.main.mall.MallFragment

class MainAdapter(fragmentManager : FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 ->HomeFragment()
            1 -> MallFragment()
            else -> InformationFragment()
        }
    }
}