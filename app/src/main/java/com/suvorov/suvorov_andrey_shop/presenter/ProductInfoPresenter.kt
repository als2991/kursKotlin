package com.suvorov.suvorov_andrey_shop.presenter

import com.suvorov.suvorov_andrey_shop.domain.ViewedProductDao
import com.suvorov.suvorov_andrey_shop.domain.model.Product
import com.suvorov.suvorov_andrey_shop.ui.ProductInfoView
import moxy.MvpPresenter

class ProductInfoPresenter(private val viewedProductDao: ViewedProductDao): MvpPresenter<ProductInfoView>() {
    fun onProductShow(product: Product){
        viewedProductDao.addProduct(
            productId = product.id.toLong(),
            productName = product.productName,
            productPrice = "${product.price}")

    }
}