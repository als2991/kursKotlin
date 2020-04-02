package com.suvorov.suvorov_andrey_shop

import org.junit.Test

class Lesson3 {

    @Test
    fun example() {

        val iphoneCase = Product(price = 123.5, salePercent = 30)

        val pricePrinter: PricePrinter = ProductPricePrinter()

        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
        pricePrinter.print(discountIphoneCasePrice)
    }
}

class Product(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
}

interface PricePrinter {

    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)
}

class ProductPricePrinter: PricePrinter {
    override fun print(price: Double) {
        when {
            price % 1.0 != 0.0 -> {
                println(Math.rint(100.0 * price) / 100.0)
            }
            else -> {
                println(Math.round(price))
            }
        }
    }
}
