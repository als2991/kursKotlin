package com.suvorov.suvorov_andrey_shop

interface ProductsView{
    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun printPriceProduct(price: Double)
    fun printNameProduct(name: String)
}