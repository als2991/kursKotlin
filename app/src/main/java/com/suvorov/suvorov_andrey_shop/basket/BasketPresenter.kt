package com.suvorov.suvorov_andrey_shop.basket

import com.suvorov.suvorov_andrey_shop.checkout.CheckOutPresenter
import com.suvorov.suvorov_andrey_shop.checkout.Product
import moxy.MvpPresenter


class BasketPresenter: MvpPresenter<BasketView>() {


    private val productPresenter = CheckOutPresenter()

    fun SetData(){
        val productsList = productPresenter.getProductList()
        viewState.setProducts(productsList)
    }

    fun removeItem(product: Product){
        val productsList = productPresenter.getProductList()
        val position = productsList.indexOf(product)
        productsList.remove(product)
        viewState.removeItem(position)

    }
}