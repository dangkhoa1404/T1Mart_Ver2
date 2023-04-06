package com.example.t1mart.ui.main.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.t1mart.R
import com.example.t1mart.data.network.response.T1mart
import com.example.t1mart.databinding.FragmentHomeBinding
import com.example.t1mart.ui.main.home.adapter.RecyclerView1Adapter
import com.example.t1mart.ui.main.home.adapter.ViewPagerAdapter
import kotlin.math.abs

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var promotionArrayList: ArrayList<T1mart>
    private lateinit var imagePromotion: Array<Int>
    private lateinit var titlePromotion: Array<String>

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageListCombo: ArrayList<Int>
    private lateinit var adapter: ViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataRecyclerView1()
        setDataImageSlider()
    }

    private fun setDataRecyclerView1() {
        imagePromotion = arrayOf(
            R.drawable.ic_clearance_sale,
            R.drawable.ic_market,
            R.drawable.ic_preferential,
            R.drawable.ic_sale,
            R.drawable.ic_finance,
            R.drawable.ic_cheap,
            R.drawable.ic_shopping,
        )
        titlePromotion = arrayOf(
            "Xả kho",
            "Đi chợ ngon",
            "Ưu đãi",
            "Mã giảm giá",
            "Tài chính",
            "Hàng giảm giá",
            "Mua sắm thả ga"
        )
        promotionArrayList = arrayListOf()
        for (i in imagePromotion.indices) {
            val promotion = T1mart(imagePromotion[i], titlePromotion[i])
            promotionArrayList.add(promotion)
        }
        binding.run {
            homeRecyclerview1.adapter = RecyclerView1Adapter(promotionArrayList)
        }
    }

    private fun setDataImageSlider() {
        binding.run {
            viewPager2 = vpCombo
            handler = Handler(Looper.myLooper()!!)
            imageListCombo = ArrayList()

            imageListCombo.add(R.drawable.img_combo1)
            imageListCombo.add(R.drawable.img_combo2)
            imageListCombo.add(R.drawable.img_combo3)
            imageListCombo.add(R.drawable.img_combo4)

            adapter = ViewPagerAdapter(imageListCombo, viewPager2)

            viewPager2.adapter = adapter
            viewPager2.offscreenPageLimit = 3
            viewPager2.clipToPadding = false
            viewPager2.clipChildren = false
            viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }
        viewPager2.setPageTransformer(transformer)
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 3000)
    }

}