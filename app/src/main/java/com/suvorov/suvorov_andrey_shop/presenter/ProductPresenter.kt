package com.suvorov.suvorov_andrey_shop.presenter

import com.suvorov.suvorov_andrey_shop.domain.model.Product
import moxy.MvpPresenter

class ProductPresenter:MvpPresenter <ProductsView>() {

    private val products = createProduct()

    private fun createProduct(): MutableList<Product> {
        val products = mutableListOf<Product>()
        for (i in 1..12){
            products.add(
                Product(
                    id = i,
                    productName = "product$i",
                    price = 1000.0 + 100.0 * i,
                    discount = i,
                    imageUrl = ""
                ))
        }
        return products
    }

    fun getProducts(): MutableList<Product> = products


    /**
     * @return price with applied discount determined by [discount]
     *
     * If [discount] is more than 100 than product will have negative price
     * If [discount] less than 0 product price will be increased
     */

}