package com.suvorov.suvorov_andrey_shop.basket

import com.suvorov.suvorov_andrey_shop.checkout.CheckOutPresenter
import com.suvorov.suvorov_andrey_shop.checkout.Product
import moxy.MvpPresenter


class BasketPresenter: MvpPresenter<BasketView>() {

    private val productPresenter = CheckOutPresenter()

    fun SetData(){
        val products = productPresenter.getProductList()
        viewState.setProducts(products)
    }

    fun removeItem(product: Product){
        val position = productPresenter.getProductList().indexOf(product)

    }
}