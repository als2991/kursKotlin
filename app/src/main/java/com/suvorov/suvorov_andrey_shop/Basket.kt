package com.suvorov.suvorov_andrey_shop

class Basket (
    private val products: List<Product>
){
    fun GetProducts(): List<Product> = products

    fun calcAmountPrice(): Double{
        val basketAmountPrice = products.sumByDouble { it.calcDiscountPrice() }
        return basketAmountPrice
    }
}