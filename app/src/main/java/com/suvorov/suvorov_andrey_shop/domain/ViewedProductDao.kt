package com.suvorov.suvorov_andrey_shop.domain

interface ViewedProductDao {

    /**
     * save this product id as viewed
     */
    fun addProduct(productId:Long, productName: String, productPrice:String)

    /**
     * get all viewed product ids
     * might be empty
     */
    fun getAllProductsId(): List<Long>
    fun getAllProductsName(): List<String>
    fun getAllProductsPrice(): List<String>
}