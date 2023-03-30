package com.example.t1mart.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.t1mart.R
import com.example.t1mart.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTabLayout()
    }

    private fun setTabLayout() {
        binding.run {
            tlT1Mart.addTab(tlT1Mart.newTab().setText(R.string.home))
            tlT1Mart.addTab(tlT1Mart.newTab().setText(R.string.mall))
            tlT1Mart.addTab(tlT1Mart.newTab().setText(R.string.information))

            vpT1Mart.adapter=MainAdapter(supportFragmentManager, lifecycle)

            tlT1Mart.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    vpT1Mart.currentItem = tab.position
                }
                override fun onTabUnselected(tab: TabLayout.Tab?) {}
                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })

            vpT1Mart.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    tlT1Mart.selectTab(tlT1Mart.getTabAt(position))
                }
            })
        }
    }
}