package com.suvorov.suvorov_andrey_shop

class BusketPresenter(
    private val viewProduct: ProductsView,
    private val viewBasket: BasketView
) {
    private val iphoneXCase = Product(price = 123.5, salePercent = 29, productName = "Case for Iphone X")
    private val samsungGalS9Case = Product(price = 100.0, salePercent = 10, productName = "Case for Samsung Galaxy S9")
    private val lgQ6Case = Product(price = 99.99, salePercent = 10, productName = "Case for LG Q6")
    private val products = listOf(iphoneXCase,samsungGalS9Case,lgQ6Case)


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


//    fun pricePrint(){
//        val allPrice = basket.calcAmountDiscountPrice()
//        viewProduct.printPriceProduct(allPrice)
//    }
//
//    fun productNamePrint(){
//        products.forEach{product ->
//            viewProduct.printNameProduct(product.getProductName())
//        }
//    }
//
//    fun basketPrint(){
//        val productsBasket = basket.GetProducts()
//        productsBasket.forEach { product ->
//            val nameProduct = product.getProductName()
//            val discountPriceProduct = product.calcDiscountPrice()
//            viewBasket.printProductsBasket("$nameProduct: $discountPriceProduct")
//        }
//        viewBasket.printAmountBasket(basket.calcAmountDiscountPrice())
//    }
}


