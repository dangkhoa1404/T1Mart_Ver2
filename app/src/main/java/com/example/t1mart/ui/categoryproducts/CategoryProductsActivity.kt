package com.example.t1mart.ui.categoryproducts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.t1mart.data.network.response.Products
import com.example.t1mart.databinding.ActivityCategoryProductsBinding
import com.example.t1mart.util.AppConstant

class CategoryProductsActivity : AppCompatActivity() {
    private lateinit var nameCategory: String
    private lateinit var binding: ActivityCategoryProductsBinding

    private lateinit var viewModel: CategoryProductsViewModel
    private var listProducts = mutableListOf<Products>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel =
            ViewModelProvider(this@CategoryProductsActivity)[CategoryProductsViewModel::class.java]
        nameCategory = intent.getStringExtra(AppConstant.NAME_CATEGORY) as String
        setTitleCategory()
        setDataListCategoryProducts()
        setEventListener()
        viewModel.getAllProductsFromCategory(nameCategory)
    }

    private fun setEventListener() {
        binding.imgBack.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setTitleCategory() {
        binding.run {
            when (nameCategory) {
                AppConstant.NAME_CATEGORY_1 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_1
                AppConstant.NAME_CATEGORY_2 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_2
                AppConstant.NAME_CATEGORY_3 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_3
                AppConstant.NAME_CATEGORY_4 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_4
                AppConstant.NAME_CATEGORY_5 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_5
                AppConstant.NAME_CATEGORY_6 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_6
                AppConstant.NAME_CATEGORY_7 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_7
                AppConstant.NAME_CATEGORY_8 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_8
                AppConstant.NAME_CATEGORY_9 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_9
                AppConstant.NAME_CATEGORY_10 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_10
                AppConstant.NAME_CATEGORY_11 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_11
                AppConstant.NAME_CATEGORY_12 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_12
                AppConstant.NAME_CATEGORY_13 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_13
                AppConstant.NAME_CATEGORY_14 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_14
                AppConstant.NAME_CATEGORY_15 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_15
                AppConstant.NAME_CATEGORY_16 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_16
                AppConstant.NAME_CATEGORY_17 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_17
                AppConstant.NAME_CATEGORY_18 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_18
                AppConstant.NAME_CATEGORY_19 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_19
                AppConstant.NAME_CATEGORY_20 -> tvCategory.text = AppConstant.TITLE_NAME_CATEGORY_20
                else -> {}
            }
        }
    }

    private fun setDataListCategoryProducts() {
        viewModel.dataListProducts.observe(this) {
            listProducts.run {
                clear()
                listProducts.addAll(it)
            }
            binding.run {
                rvListProducts.adapter = CategoryProductsAdapter(listProducts)
                rvListProducts.adapter?.notifyDataSetChanged()
            }
        }
    }
}