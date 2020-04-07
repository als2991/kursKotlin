package com.suvorov.suvorov_andrey_shop


import org.junit.Test

class Lesson5 {
    private val presenter5 = Presenter5()

    @Test
    fun example() {
        presenter5.productPricePrint5()
        presenter5.productNamePrint5()
        presenter5.myPricePrint5()
    }
}

class Presenter5{
    private val pricePrinter5: PricePrinter5 = CasePricePrinter5()

    private val iphoneCase = Product5(price = 123.5, salePercent = 30, productName = "IphoneCase")
    private val samsungCase = Product5(price = 100.0, salePercent = 10, productName = "SamsungCase")
    private val products5 = listOf(iphoneCase,samsungCase)

    fun myPricePrint5(){
        products5.forEach{product ->
            pricePrinter5.print5(product.calcDiscountPrice5())
        }
    }

    fun productNamePrint5(){
        products5.forEach{product ->
            pricePrinter5.print5(product.getProductName5())
        }
    }

    fun productPricePrint5(){
        products5.forEach { product ->
            pricePrinter5.print5("${product.getProductName5()}: ${product.calcDiscountPrice5()}")
        }
    }
}

class Product5(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0,
    private val productName: String
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice5(): Double = price * (1 - salePercent / 100.0)
    fun getProductName5(): String = productName
}

interface PricePrinter5 {

    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print5(price: Double)
    fun print5(name: String)

}

class CasePricePrinter5: PricePrinter5 {
    override fun print5(price: Double) {
        when {
            price % 1.0 != 0.0 -> {
                println("Case price ${Math.rint(100.0 * price) / 100.0}")
            }
            else -> {
                println("Case price: ${Math.round(price)}")
            }
        }
    }

    override fun print5(name: String) {
        println(name)
    }
}
