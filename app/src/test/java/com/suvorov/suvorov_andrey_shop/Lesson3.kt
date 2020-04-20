package com.suvorov.suvorov_andrey_shop

import org.junit.Test

class Lesson3 {

    @Test
    fun example() {

//        val casePricePrinter: PricePrinter = CasePricePrinter()
//        val telephonePricePrinter: PricePrinter = TelephonePricePrinter()
//
//        val iphoneCase =
//            com.suvorov.suvorov_andrey_shop.checkout.Product(price = 123.5, salePercent = 30,)
//        val iphoneTelephone =
//            com.suvorov.suvorov_andrey_shop.checkout.Product(price = 50000.0, salePercent = 5,)
//
//        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
//        val discountIphoneTelephonePrice = iphoneTelephone.calcDiscountPrice()
//
//        casePricePrinter.print(discountIphoneCasePrice)
//        telephonePricePrinter.print(discountIphoneTelephonePrice)
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

class CasePricePrinter: PricePrinter {
    override fun print(price: Double) {
        when {
            price % 1.0 != 0.0 -> {
                println("Case price ${Math.rint(100.0 * price) / 100.0}")
            }
            else -> {
                println("Case price: ${Math.round(price)}")
            }
        }
    }
}

class TelephonePricePrinter:PricePrinter {
    override fun print(price: Double) {
        when {
            price % 1.0 != 0.0 -> {
                println("Telephone price: ${Math.rint(100.0 * price) / 100.0}")
            }
            else -> {
                println("Telephone price: ${Math.round(price)}")
            }
        }
    }

}
