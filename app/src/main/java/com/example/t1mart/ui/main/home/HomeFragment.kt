package com.example.t1mart.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.t1mart.R
import com.example.t1mart.data.network.response.Products
import com.example.t1mart.data.network.response.T1mart
import com.example.t1mart.databinding.FragmentHomeBinding
import com.example.t1mart.ui.categoryproducts.CategoryProductsActivity
import com.example.t1mart.ui.main.home.adapter.*
import com.example.t1mart.ui.productinformation.ProductInformationActivity
import com.example.t1mart.util.AppConstant
import kotlin.math.abs

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var promotionArrayList: ArrayList<T1mart>
    private lateinit var imagePromotion: Array<Int>
    private lateinit var titlePromotion: Array<String>
    private lateinit var imageBrand: Array<Int>

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageListCombo: ArrayList<Int>
    private lateinit var adapter: ViewPagerAdapter

    private lateinit var viewModel: HomeViewModel
    private var listProducts = mutableListOf<Products>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this@HomeFragment)[HomeViewModel::class.java]
        setDataPromotion()
        setDataSliderPromotion()
        setDataCollection()
        setDataGenuineBrand()
        setDataCategories()
        setDataListProducts()
        viewModel.callDataListProducts()
    }

    private fun setDataListProducts() {
        viewModel.dataListProducts.observe(viewLifecycleOwner) {
            listProducts.run {
                clear()
                listProducts.addAll(it)
            }
            binding.run {
                rvListProducts.adapter = HomeAdapter(listProducts) {
                    val intent = Intent(requireContext(), ProductInformationActivity::class.java)
                    intent.putExtra(AppConstant.ID_CATEGORY, it)
                    startActivity(intent)
                }
                rvListProducts.adapter?.notifyDataSetChanged()
            }
        }
    }

    private fun setDataPromotion() {
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
            AppConstant.PROMOTION_1,
            AppConstant.PROMOTION_2,
            AppConstant.PROMOTION_3,
            AppConstant.PROMOTION_4,
            AppConstant.PROMOTION_5,
            AppConstant.PROMOTION_6,
            AppConstant.PROMOTION_7
        )
        promotionArrayList = arrayListOf()
        for (i in imagePromotion.indices) {
            val promotion = T1mart(imagePromotion[i], titlePromotion[i], 0)
            promotionArrayList.add(promotion)
        }
        binding.run {
            homeRecyclerview1.adapter = RecyclerView1Adapter(promotionArrayList)
        }
    }

    private fun setDataSliderPromotion() {
        binding.run {
            viewPager2 = vpCombo
            handler = Handler(Looper.myLooper()!!)
            imageListCombo = ArrayList()

            imageListCombo.add(R.drawable.img_banner1)
            imageListCombo.add(R.drawable.img_banner2)
            imageListCombo.add(R.drawable.img_banner3)
            imageListCombo.add(R.drawable.img_banner4)
            imageListCombo.add(R.drawable.img_banner5)
            imageListCombo.add(R.drawable.img_banner6)

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
                handler.postDelayed(runnable, 2500)
            }
        })
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setDataCollection() {
        imagePromotion = arrayOf(
            R.drawable.ic_rv2_coffeecan,
            R.drawable.ic_rv2_laptop,
            R.drawable.ic_rv2_headphone,
            R.drawable.ic_rv2_phone,
            R.drawable.ic_rv2_shampoo,
            R.drawable.ic_rv2_chocopie,
            R.drawable.ic_rv2_tv,
        )
        titlePromotion = arrayOf(
            AppConstant.TOP_1,
            AppConstant.TOP_2,
            AppConstant.TOP_3,
            AppConstant.TOP_4,
            AppConstant.TOP_5,
            AppConstant.TOP_6,
            AppConstant.TOP_7
        )
        promotionArrayList = arrayListOf()
        for (i in imagePromotion.indices) {
            val promotion = T1mart(imagePromotion[i], titlePromotion[i], 0)
            promotionArrayList.add(promotion)
        }
        binding.run {
            homeRecyclerview2.adapter = RecyclerView2Adapter(promotionArrayList) {
                val intent = Intent(requireContext(), ProductInformationActivity::class.java)
                intent.putExtra(AppConstant.ID_CATEGORY, it)
                startActivity(intent)
            }
        }
    }

    private fun setDataGenuineBrand() {
        imagePromotion = arrayOf(
            R.drawable.ic_rv3_img_logitech,
            R.drawable.ic_rv3_img_nhanam,
            R.drawable.ic_rv2_tv,
            R.drawable.ic_rv3_img_strongbow,
            R.drawable.ic_rv3_img_sunhouse,
            R.drawable.ic_rv3_img_unilever
        )
        titlePromotion = arrayOf(
            AppConstant.SALE_1,
            AppConstant.SALE_2,
            AppConstant.SALE_3,
            AppConstant.SALE_4,
            AppConstant.SALE_5,
            AppConstant.SALE_6
        )
        imageBrand = arrayOf(
            R.drawable.ic_rv3_logo_logitech,
            R.drawable.ic_rv3_logo_nhanam,
            R.drawable.ic_rv3_logo_samsung,
            R.drawable.ic_rv3_logo_strongbow,
            R.drawable.ic_rv3_logo_sunhouse,
            R.drawable.ic_rv3_logo_unilever,
        )
        promotionArrayList = arrayListOf()
        for (i in imagePromotion.indices) {
            val promotion = T1mart(imagePromotion[i], titlePromotion[i], imageBrand[i])
            promotionArrayList.add(promotion)
        }
        binding.run {
            homeRecyclerview3.adapter = RecyclerView3Adapter(promotionArrayList) {
                val intent = Intent(requireContext(), CategoryProductsActivity::class.java)
                intent.putExtra(AppConstant.NAME_CATEGORY, it)
                startActivity(intent)
            }
        }
    }

    private fun setDataCategories() {
        imagePromotion = arrayOf(
            R.drawable.ic_smartphone,
            R.drawable.ic_laptop,
            R.drawable.ic_fragrances,
            R.drawable.ic_skincare,
            R.drawable.ic_furniture,
            R.drawable.ic_mens_shirts,
            R.drawable.ic_womens_bags,
            R.drawable.ic_womens_jewellery,
            R.drawable.ic_sunglasses,
        )
        titlePromotion = arrayOf(
            AppConstant.NAME_CATEGORY_1,
            AppConstant.NAME_CATEGORY_2,
            AppConstant.NAME_CATEGORY_3,
            AppConstant.NAME_CATEGORY_4,
            AppConstant.NAME_CATEGORY_7,
            AppConstant.NAME_CATEGORY_11,
            AppConstant.NAME_CATEGORY_15,
            AppConstant.NAME_CATEGORY_16,
            AppConstant.NAME_CATEGORY_17
        )
        promotionArrayList = arrayListOf()
        for (i in imagePromotion.indices) {
            val promotion = T1mart(imagePromotion[i], titlePromotion[i], 0)
            promotionArrayList.add(promotion)
        }
        binding.run {
            homeRecyclerview4.adapter = CategoryAdapter(promotionArrayList) {
                val intent = Intent(requireContext(), CategoryProductsActivity::class.java)
                intent.putExtra(AppConstant.NAME_CATEGORY, it)
                startActivity(intent)
            }
        }
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