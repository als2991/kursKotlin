package com.suvorov.suvorov_andrey_shop

class BusketPresenter(
    private val viewProduct: ProductsView,
    private val viewBasket: BasketView
) {
    private val iphoneXCase = Product(price = 123.5, salePercent = 29, productName = "Case for Iphone X")
    private val samsungGalS9Case = Product(price = 100.0, salePercent = 10, productName = "Case for Samsung Galaxy S9")
    private val lgQ6Case = Product(price = 99.99, salePercent = 10, productName = "Case for LG Q6")
    private val products = listOf(iphoneXCase,samsungGalS9Case,lgQ6Case)

    val basket = Basket(products)

    fun pricePrint(){
        val allPrice = products.sumByDouble { it.calcDiscountPrice() }
        viewProduct.printPriceProduct(allPrice)
    }

    fun productNamePrint(){
        products.forEach{product ->
            viewProduct.printNameProduct(product.getProductName())
        }
    }

    fun basketPrint(){
        val productsBasket = basket.GetProducts()
        productsBasket.forEach { product ->
            val nameProduct = product.getProductName()
            val discountPriceProduct = product.calcDiscountPrice()
            viewBasket.printProductsBasket("$nameProduct: $discountPriceProduct")
        }
        viewBasket.printAmountBasket(basket.calcAmountPrice())
    }
}


