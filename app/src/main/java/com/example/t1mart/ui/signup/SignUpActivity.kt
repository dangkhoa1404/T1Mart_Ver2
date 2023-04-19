package com.example.t1mart.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t1mart.R
import com.example.t1mart.data.network.response.T1mart
import com.example.t1mart.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var logoSignUpArrayList: ArrayList<T1mart>
    private lateinit var logoSignUp: Array<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setDataLogoSignUp()
        setEventListener()
    }

    private fun setDataLogoSignUp() {
        logoSignUp = arrayOf(
            R.drawable.ic_logo_google,
            R.drawable.ic_logo_facebook,
            R.drawable.ic_logo_twitter,

            )
        logoSignUpArrayList = arrayListOf()
        for (i in logoSignUp.indices) {
            val promotion = T1mart(logoSignUp[i], null, 0)
            logoSignUpArrayList.add(promotion)
        }
        binding.run {
            rvAnotherWaySignIn.adapter = SignUpAdapter(logoSignUpArrayList)
        }
    }

    private fun setEventListener() {
        binding.tvSignUp.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}