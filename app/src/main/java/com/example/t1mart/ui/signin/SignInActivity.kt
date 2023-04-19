package com.example.t1mart.ui.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t1mart.R
import com.example.t1mart.data.network.response.T1mart
import com.example.t1mart.databinding.ActivitySignInBinding
import com.example.t1mart.ui.signup.SignUpActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var logoSignInArrayList: ArrayList<T1mart>
    private lateinit var logoSignIn: Array<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setDataLogoSignIn()
        setEventListener()
    }

    private fun setDataLogoSignIn() {
        logoSignIn = arrayOf(
            R.drawable.ic_logo_google,
            R.drawable.ic_logo_facebook,
            R.drawable.ic_logo_twitter,

            )
        logoSignInArrayList = arrayListOf()
        for (i in logoSignIn.indices) {
            val promotion = T1mart(logoSignIn[i], null, 0)
            logoSignInArrayList.add(promotion)
        }
        binding.run {
            rvAnotherWaySignIn.adapter = SignInAdapter(logoSignInArrayList)
        }
    }

    private fun setEventListener() {
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

}