package com.suvorov.suvorov_andrey_shop.domain.model

data class Product(
    /**
     * Must be positive
     */
    val price: Double,
    val discount: Int = 0,
    val productName: String
) {
    /**
     * @return price with applied discount determined by [discount]
     *
     * If [discount] is more than 100 than product will have negative price
     * If [discount] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - discount / 100.0)
    fun calcDiscount():Double = discount / 100.0 * price
}