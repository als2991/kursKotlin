package com.suvorov.suvorov_andrey_shop

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import java.util.*

class MathTest{

    @Test
    /*fun  main(){
        val iphoneCase = object{
            private val price = 40
            private val salePercent = 30

            fun showPrice(){
                val discountPrice = getDiscountPrice()
            }

            private fun getDiscountPrice() = price * (1 - salePercent / 100.0)



        }
    }*/

    fun main() {

        class Product(
            /**
             * Must be positive
             */
            private val price: Double,
            private val salePercent: Int = 0
        ) {
            init{
                println("Hello")
            }

            /**
             * @return price with applied discount determined by [salePercent]
             * If [salePercent] is more than 100 than product will hve negative price
             * If [salePercent] is than 0 product price will be increased
             *
             */
            fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
        }


        val iphoneCase = Product(price = 30.0, salePercent = 4)
        val samsungCase = Product(20.0,10)



        val discountIphonePrice = iphoneCase.calcDiscountPrice()
        println(discountIphonePrice)

        val discountSamsungPrice = samsungCase.calcDiscountPrice()
        println(discountSamsungPrice)
    }
}

interface PriceFormatter{
    /**1
     * Outputs price in <Price> P format
     * If price have not fractional part than it will be printed as integer
     *If price have fractiobal price than it will be rounded for 2 symbols after "."
     */
    fun format(price: Double): String
}

/*
class CleanKotlinPriceFormatter : PriceFormatter {
    override fun format(price: Double): String {
        return <...>
    }
}*/
