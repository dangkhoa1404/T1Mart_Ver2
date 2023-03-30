package com.example.t1mart.ui.main.mall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.t1mart.databinding.FragmentMallBinding

class MallFragment : Fragment() {
    private lateinit var binding: FragmentMallBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMallBinding.inflate(inflater, container, false)
        return binding.root
    }
}