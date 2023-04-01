package com.example.t1mart.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.t1mart.R
import com.example.t1mart.databinding.ActivityMainBinding
import com.example.t1mart.ui.main.home.HomeFragment
import com.example.t1mart.ui.main.information.InformationFragment
import com.example.t1mart.ui.main.mall.MallFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        replaceFragment(HomeFragment())
        binding.navigationMart.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.mall -> replaceFragment(MallFragment())
                R.id.account -> replaceFragment(InformationFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flMart, fragment)
        fragmentTransaction.commit()
    }
}