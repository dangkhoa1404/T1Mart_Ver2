package com.example.t1mart.ui.main.category

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.t1mart.R
import com.example.t1mart.data.network.response.T1mart
import com.example.t1mart.databinding.FragmentCategoryBinding
import com.example.t1mart.ui.categoryproducts.CategoryProductsActivity
import com.example.t1mart.util.AppConstant

class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    private lateinit var categoryArrayList: ArrayList<T1mart>
    private lateinit var imageCategory: Array<Int>
    private lateinit var titleCategory: Array<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataListCategories()
    }

    private fun setDataListCategories() {
        imageCategory = arrayOf(
            R.drawable.ic_smartphone,
            R.drawable.ic_laptop,
            R.drawable.ic_fragrances,
            R.drawable.ic_skincare,
            R.drawable.ic_groceries,
            R.drawable.ic_home_decoration,
            R.drawable.ic_furniture,
            R.drawable.ic_tops,
            R.drawable.ic_womens_dresses,
            R.drawable.ic_womens_shoes,
            R.drawable.ic_mens_shirts,
            R.drawable.ic_mens_shoes,
            R.drawable.ic_mens_watches,
            R.drawable.ic_womens_watches,
            R.drawable.ic_womens_bags,
            R.drawable.ic_womens_jewellery,
            R.drawable.ic_sunglasses,
            R.drawable.ic_automotive,
            R.drawable.ic_motorcycle,
            R.drawable.ic_lighting
        )
        titleCategory = arrayOf(
            AppConstant.NAME_CATEGORY_1,
            AppConstant.NAME_CATEGORY_2,
            AppConstant.NAME_CATEGORY_3,
            AppConstant.NAME_CATEGORY_4,
            AppConstant.NAME_CATEGORY_5,
            AppConstant.NAME_CATEGORY_6,
            AppConstant.NAME_CATEGORY_7,
            AppConstant.NAME_CATEGORY_8,
            AppConstant.NAME_CATEGORY_9,
            AppConstant.NAME_CATEGORY_10,
            AppConstant.NAME_CATEGORY_11,
            AppConstant.NAME_CATEGORY_12,
            AppConstant.NAME_CATEGORY_13,
            AppConstant.NAME_CATEGORY_14,
            AppConstant.NAME_CATEGORY_15,
            AppConstant.NAME_CATEGORY_16,
            AppConstant.NAME_CATEGORY_17,
            AppConstant.NAME_CATEGORY_18,
            AppConstant.NAME_CATEGORY_19,
            AppConstant.NAME_CATEGORY_20
        )
        categoryArrayList = arrayListOf()
        for (i in imageCategory.indices) {
            val promotion = T1mart(imageCategory[i], titleCategory[i], 0)
            categoryArrayList.add(promotion)
        }
        binding.run {
            rvListCategories.adapter = CategoryAdapter(categoryArrayList) {
                val intent =Intent(requireContext(), CategoryProductsActivity::class.java)
                intent.putExtra(AppConstant.NAME_CATEGORY, it)
                startActivity(intent)
            }
        }
    }
}