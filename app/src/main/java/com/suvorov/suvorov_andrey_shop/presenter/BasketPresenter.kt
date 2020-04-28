package com.suvorov.suvorov_andrey_shop.presenter

import com.suvorov.suvorov_andrey_shop.domain.model.Product
import com.suvorov.suvorov_andrey_shop.ui.BasketView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class BasketPresenter: MvpPresenter<BasketView>() {

    val productsList = ProductPresenter().getProducts()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setData()
    }

    private fun setData(){
        viewState.setProducts(productsList)
    }

    fun removeItem(product: Product){
        val position = productsList.indexOf(product)
        productsList.remove(product)
        viewState.removeItem(position)
    }

    fun addItem(){
        var newid: Int = 0
        productsList.forEach { product ->
            if(product.id > newid) newid = product.id
        }
        newid++
        val product = Product(
            id = newid,
            productName = "Product$newid",
            price = 1000.0 + 100.0 * newid,
            discount = newid,
            imageUrl = ""
        )
        productsList.add(product)
        val position = productsList.indexOf(product)
        viewState.addItem(position)
    }

    fun onProductClick(product: Product){
        viewState.showProductInfo(product)
    }
}