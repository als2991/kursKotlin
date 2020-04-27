package com.suvorov.suvorov_andrey_shop.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    /**
     * Must be positive
     */
    val id: Int,
    val productName: String,
    val price: Double,
    val discount: Int = 0,
    val imageUrl: String

) : Parcelable {

    fun calcDiscountPrice(): Double = price * (1 - discount / 100.0)
    fun calcDiscount():Double = discount / 100.0 * price
}

