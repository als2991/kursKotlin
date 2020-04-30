package com.suvorov.suvorov_andrey_shop.domain

import retrofit2.http.GET
import retrofit2.http.Path

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

    @GET("product/all/{author}")
    suspend fun allProduct(@Path("author") author: String): List<RemoteProduct>
}