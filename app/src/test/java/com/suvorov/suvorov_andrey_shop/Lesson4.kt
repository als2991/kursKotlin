package com.suvorov.suvorov_andrey_shop


import org.junit.Test

class Lesson4 {

//    @Test
//    fun example() {
//
//        val casePricePrinter: PricePrinter = CasePricePrinter()
//        //val telephonePricePrinter: PricePrinter = TelephonePricePrinter()
//
//        val iphoneCase = Product2(price = 123.5, salePercent = 30)
//        val samsungCase = Product2(price = 124.5, salePercent = 15)
//
//        val products = listOf(iphoneCase,samsungCase)
//
//        val discountPrices = products.map { it.calcDiscountPrice()}
//
//
//
//        MyforEach(discountPrices){discountPrice ->
//            casePricePrinter.printPrice(discountPrice)
//        }
//    }

    /*private fun <TItem> MyforEach(list: List<TItem>, action: (TItem) -> Unit){
        for(item in list){
            action(item)
        }
    }*/
}

//class Product2(
//
//    /**
//     * Must be positive
//     */
//    private val price: Double,
//    private val salePercent: Int = 0
//) {
//    /**
//     * @return price with applied discount determined by [salePercent]
//     *
//     * If [salePercent] is more than 100 than product will have negative price
//     * If [salePercent] less than 0 product price will be increased
//     */
//    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
//}

//interface PricePrinter2 {
//
//    /**
//     * Outputs price in <PRICE>P format.
//     * If price have not fractional part than it will be printed as integer
//     * If price have fractional part than it will be rounded for 2 symbols after "."
//     */
//    fun printPrice(price: Double)
//}
//
//class CasePricePrinter2: PricePrinter {
//    override fun printPrice(price: Double) {
//        when {
//            price % 1.0 != 0.0 -> {
//                println("Case price ${Math.rint(100.0 * price) / 100.0}")
//            }
//            else -> {
//                println("Case price: ${Math.round(price)}")
//            }
//        }
//    }
//}
//
//class TelephonePricePrinter2:PricePrinter {
//    override fun printPrice(price: Double) {
//        when {
//            price % 1.0 != 0.0 -> {
//                println("Telephone price: ${Math.rint(100.0 * price) / 100.0}")
//            }
//            else -> {
//                println("Telephone price: ${Math.round(price)}")
//            }
//        }
//    }
//
//}

