package com.suvorov.suvorov_andrey_shop
import org.junit.Test

class SecondTest{
    @Test
    fun example(){

        /*//Сложность это то, что мешает пониманию программы и внесению в нее изменений
        //Источниками сложности являются сокрытие важной информации (obscurity) и зависимости
        // A philosophy of software design
        val iphoneCase = object {
            private val price = 40.0
            private val salePercent = 30

            fun showPrice(){
                val discountPrice = getDiscountPrice()
                outPrice(discountPrice)
            }

            private fun getDiscountPrice() = price * (1 -  salePercent / 100.0)

            private fun outPrice(myPrice: Double) = println(myPrice)
        }

        println(iphoneCase.showPrice())
    }*/
        class Product (
            /**
             * Must be positive
             *
             */
            private val price: Double,
            private val salePercent: Int = 0
        ){
            init{
                println("Hello")
            }

            /**
             * @return price with applied discount determined by [salePercent]
             *
             * If [salePercent] is more 100 than product will have negative price
             * If [salePercent] less than 0 product price will be increased
             */
            fun calcDiscountPrice() = price * (1 -  salePercent / 100.0)
        }

        val iphoneCase = Product( price = 123.5, salePercent = 30)

        val samsungCase = Product(price = 300.5, salePercent = 99)

        val priceFormatter : PriceFormatter = CleanKotlinPriceFormatter()

        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
        val formattedIphoneCasePrice = priceFormatter.format(discountIphoneCasePrice)
        println(formattedIphoneCasePrice)

        val discountSamsungCasePrice = samsungCase.calcDiscountPrice()
        val formattedSamsungCasePrice = priceFormatter.format(discountSamsungCasePrice)
        println(formattedSamsungCasePrice)
    }

    interface PriceFormatter{
        /**
         * Outputs price in <PRICE>P format
         * If price have not fractional part than it will be printed as integer
         * If price have fractional part than it will be rounded for 2 symbols after "."
         */
        fun format(price:Double):String
    }

    class CleanKotlinPriceFormatter : PriceFormatter{
        override fun format(price: Double): String {
            return <....>

        }

    }
}