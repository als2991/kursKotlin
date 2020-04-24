package com.suvorov.suvorov_andrey_shop.basket

import com.suvorov.suvorov_andrey_shop.checkout.CheckOutPresenter
import com.suvorov.suvorov_andrey_shop.checkout.Product
import moxy.MvpPresenter


class BasketPresenter: MvpPresenter<BasketView>() {


    private val productPresenter = CheckOutPresenter()

    val caseNokia8_1 = Product(
        2290.00,
        5,
        "Case for Nokia 8.1"
    )

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

    fun addItem(product: Product){
        val productList = productPresenter.getProductList()
        productList.add(product)
        val position = productList.indexOf(product)
        viewState.addItem(position)
    }
}