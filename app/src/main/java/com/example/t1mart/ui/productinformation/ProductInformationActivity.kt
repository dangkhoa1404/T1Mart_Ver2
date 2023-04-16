package com.example.t1mart.ui.productinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.t1mart.data.network.response.Products
import com.example.t1mart.databinding.ActivityProductInformationBinding
import com.example.t1mart.ui.productinformation.adapter.ProductImageAdapter
import com.example.t1mart.ui.productinformation.adapter.RelatedProductsAdapter
import com.example.t1mart.util.AppConstant
import kotlin.math.roundToInt

class ProductInformationActivity : AppCompatActivity() {
    private lateinit var idProduct: String
    private lateinit var binding: ActivityProductInformationBinding

    private lateinit var viewModel: ProductInformationViewModel
    private var listProducts = mutableListOf<Products>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel =
            ViewModelProvider(this@ProductInformationActivity)[ProductInformationViewModel::class.java]
        idProduct = intent.getStringExtra(AppConstant.ID_CATEGORY) as String
        setDataProduct()
        setDataRelatedProducts()
        setEventListener()
        viewModel.getProductFromID(idProduct)
    }

    private fun setDataRelatedProducts() {
        viewModel.dataListProducts.observe(this) {
            listProducts.run {
                clear()
                listProducts.addAll(it)
            }
            binding.run {
                rvListProducts.adapter = RelatedProductsAdapter(listProducts) {
                    viewModel.getProductFromID(it)
                }
                rvListProducts.adapter?.notifyDataSetChanged()
            }
        }
    }

    private fun setDataProduct() {
        viewModel.productInformation.observe(this) {
            it.run {
                binding.run {
                    Glide.with(this@ProductInformationActivity).load(thumbnail).into(imgThumbnail)
                    tvBrand.text = brand
                    tvTitle.text = title
                    tvCategory.text = category
                    tvRating.text = rating.toString()
                    tvRatings.text = price.toString()
                    tvReviews.text = stock.toString()
                    val salePrice2Digit: Double =
                        (price * 1.0 * (100.0 - discountPercentage)).roundToInt() / 100.0
                    tvSalePrice.text = salePrice2Digit.toString()
                    tvPriceProduct.text = price.toString()
                    tvDiscountPercentage.text = discountPercentage.toString()
                    tvDescription.text = description

                    rvProductImage.adapter = images?.let { it1 -> ProductImageAdapter(it1) }
                    rvProductImage.adapter?.notifyDataSetChanged()

                    category?.let { it1 -> viewModel.getRelatedProducts(it1) }
                }
            }
        }
    }

    private fun setEventListener() {
        binding.imgBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}