package com.suvorov.suvorov_andrey_shop.domain

import retrofit2.http.GET

interface MainApi {

    data class RemoteProduct(
        val id: String,
        val name: String,
        val price: Double,
        val discountPercent: Int,
        val description: String,
        val imageUrl: String,
        val attributes: List<Attribute>
    ) {
        data class Attribute(
            val name: String,
            val value: String
        )
    }

    @GET("product/all/default")
    suspend fun allProduct(): List<RemoteProduct>
}