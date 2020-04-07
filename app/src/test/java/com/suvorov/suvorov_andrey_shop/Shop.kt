package com.suvorov.suvorov_andrey_shop

import org.junit.Test

val iphoneXCase = ProductShop(price = 123.5, salePercent = 29, name = "Case for Iphone X")
val samsungGalS9Case = ProductShop(price = 100.0, salePercent = 10, name = "Case for Samsung Galaxy S9")
val lgQ6Case = ProductShop(price = 99.99, salePercent = 10, name = "LG Q6")
val listProducts = listOf(iphoneXCase,samsungGalS9Case,lgQ6Case)
val basketShop = BasketShop(listProducts)

@Test
fun main() {
    val printerBasketProducts : PrinterBasket = PrinterBasketProducts()

    val listBasketProducts = basketShop.GetListProductBaskets()
    printerBasketProducts.print(listBasketProducts)
}

class ProductShop(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0,
    private val name: String
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
    fun getNameProductShop(): String = this.name
}

//don't use now
/*interface PricePrinterShop {

    *//**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     *//*
    fun printPrice(price: Double)
}

class ProductPricePrinterShop: PricePrinterShop {
    override fun printPrice(price: Double) {
        when {
            price % 1.0 != 0.0 -> {
                println(Math.rint(100.0 * price) / 100.0)
            }
            else -> {
                println(Math.round(price))
            }
        }
    }
}*/

class BasketShop(
    private val listProductBaskets: List<ProductShop>
){
    fun GetListProductBaskets(): List<ProductShop> = listProductBaskets

    fun calcAmountPrice(): Double{
        var basketAmountPrice = 0.0
        listProductBaskets.forEach{ productShop ->
            val priceProduct = productShop.calcDiscountPrice()
            basketAmountPrice += priceProduct
        }
        return basketAmountPrice
    }
}

interface PrinterBasket{
    fun print(listBasket:List<ProductShop>)
}

class PrinterBasketProducts: PrinterBasket {
    override fun print(listBasket: List<ProductShop>) {
        listBasket.forEach { product ->
            val nameProduct = product.getNameProductShop()
            val discountPriceProduct = product.calcDiscountPrice()
            val index = listBasket.indexOf(product) + 1
            println("$index. $nameProduct - prise $discountPriceProduct")
        }
        println("Amount products in Basket: ${basketShop.calcAmountPrice()}")

    }
}