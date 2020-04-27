package com.suvorov.suvorov_andrey_shop.ui

import android.os.Bundle
import com.suvorov.suvorov_andrey_shop.R
import com.suvorov.suvorov_andrey_shop.domain.model.Product
import com.suvorov.suvorov_andrey_shop.presenter.ProductInfoPresenter
import kotlinx.android.synthetic.main.product_info_activity.*
import com.bumptech.glide.Glide
import com.suvorov.suvorov_andrey_shop.data.ViewedProductDaoImpl
import moxy.ktx.moxyPresenter

class ProductInfoActivity: BaseActivity(), ProductInfoView {

    private val presenter by moxyPresenter { ProductInfoPresenter(
        ViewedProductDaoImpl(sharedPreferences)
    ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_info_activity)

        aboutProductBackImg.setOnClickListener{
            finish()
        }

        val product = intent?.getParcelableExtra<Product>(PRODUCT_TAG) ?: return
        Glide
            .with(productInfoImage.context)
            .load(product.imageUrl)
            .error(R.mipmap.ic_launcher)
            .into(productInfoImage)
        productInfoName.text = product.productName
        productInfoPrice.text = product.price.toString()
        presenter.onProductShow(product)
    }

    companion object {
        const val PRODUCT_TAG = "PRODUCT_TAG"
    }
}