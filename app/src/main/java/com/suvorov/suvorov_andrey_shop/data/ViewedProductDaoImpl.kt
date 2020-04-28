package com.suvorov.suvorov_andrey_shop.data

import android.content.SharedPreferences
import androidx.core.content.edit
import com.suvorov.suvorov_andrey_shop.domain.ViewedProductDao

class ViewedProductDaoImpl(
    private val sharedPreferences: SharedPreferences
) : ViewedProductDao {

    private var savedProductIds: List<Long>

        get() = sharedPreferences.getString(PRODUCT_TAG, null)
            ?.split(",")
            ?.mapNotNull { it.toLongOrNull() } ?: emptyList()

        set(value) {
            sharedPreferences.edit {
                putString(PRODUCT_TAG, value.joinToString(","))
            }
        }

    private var savedProductNames: List<String>
        get() = sharedPreferences.getString(PRODUCT_NAME, null)
            ?.split(",")
            ?.map { it } ?: emptyList()

        set(value) {
            sharedPreferences.edit {
                putString(PRODUCT_NAME, value.joinToString(","))
            }
        }

    private var savedProductPrices: List<String>

        get() = sharedPreferences.getString(PRODUCT_PRICE, null)
            ?.split(",")
            ?.map { it } ?: emptyList()

        set(value) {
            sharedPreferences.edit {
                putString(PRODUCT_PRICE, value.joinToString(","))
            }
        }

    override fun addProduct(productId: Long, productName: String, productPrice: String) {

        val productIds: List<Long> = savedProductIds
        val productNames: List<String> = savedProductNames
        val productPrices: List<String> = savedProductPrices

        val newProductIds = mutableListOf<Long>().apply {
            add(productId)
            addAll(productIds.filter { it != productId })
        }

        val newProductNames = mutableListOf<String>().apply {
            add(productName)
            addAll(productNames.filter { !it?.equals(productName) })
        }

        val newProductPrices = mutableListOf<String>().apply {
            add(productPrice)
            addAll(productPrices.filter { !it?.equals(productPrice) })
        }

        savedProductIds = newProductIds
        savedProductNames = newProductNames
        savedProductPrices = newProductPrices
    }

    override fun getAllProductsId(): List<Long> {
        return savedProductIds
    }

    override fun getAllProductsName(): List<String> {
        return savedProductNames
    }

    override fun getAllProductsPrice(): List<String> {
        return savedProductPrices
    }

    companion object {
        private const val PRODUCT_TAG = "PRODUCT_TAG"
        private const val PRODUCT_NAME = "PRODICT_NAME"
        private const val PRODUCT_PRICE = "PRODUCT_PRICE"
    }
}