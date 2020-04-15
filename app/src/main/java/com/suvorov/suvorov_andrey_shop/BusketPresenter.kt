package com.suvorov.suvorov_andrey_shop

import moxy.MvpPresenter

class BusketPresenter: MvpPresenter<ProductsView>() {
    private val iphoneXCase = Product(price = 123.5, salePercent = 29, productName = "Case for Iphone X")
    private val samsungGalS9Case = Product(price = 100.0, salePercent = 10, productName = "Case for Samsung Galaxy S9")
    private val lgQ6Case = Product(price = 99.99, salePercent = 10, productName = "Case for LG Q6")
    private val products = listOf(iphoneXCase,samsungGalS9Case,lgQ6Case)

    private val model = CreateOrderModel()


    fun calcAmountPrice():Double{
        val amountPrice = products.sumByDouble { it.getPrice() }
        return amountPrice
    }

    fun calcAmountDiscount(): Double{
        val amountDiscount = products.sumByDouble { it.calcDiscount() }
        return amountDiscount
    }

    fun calcAmountDiscountPrice(): Double {
        val amountDiscountPrice = products.sumByDouble { it.calcDiscountPrice() }
        return amountDiscountPrice
    }


    fun pricePrint(){
        val allPrice = calcAmountDiscountPrice()
        viewState.printPriceProduct(allPrice)
    }

    fun productNamePrint(){
        products.forEach{product ->
            viewState.printNameProduct(product.getProductName())
        }
    }

}


