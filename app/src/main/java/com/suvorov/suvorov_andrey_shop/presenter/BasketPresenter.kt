package com.suvorov.suvorov_andrey_shop.presenter

import com.suvorov.suvorov_andrey_shop.domain.model.Product
import com.suvorov.suvorov_andrey_shop.ui.BasketView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class BasketPresenter: MvpPresenter<BasketView>() {


    private val productPresenter = CheckOutPresenter()

    val caseNokia8_1 = Product(
        2290.00,
        5,
        "Case for Nokia 8.1"
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        SetData()
    }

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