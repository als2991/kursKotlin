package com.suvorov.suvorov_andrey_shop.checkout

import moxy.MvpPresenter
import java.util.regex.Pattern

class CheckOutPresenter: MvpPresenter<ProductsView>() {
    private val iphone11ProCase = Product(
        price = 5999.0,
        discount = 5,
        productName = "Case for Iphone 11 Pro"
    )
    private val iphone11Case = Product(
        price = 5250.0,
        discount = 5,
        productName = "Case for Iphone 11"
    )
    private val iphoneXSCase = Product(
        price = 4990.0,
        discount = 15,
        productName = "Case for Iphone XS"
    )
    private val iphoneXCase = Product(
        price = 4790.0,
        discount = 15,
        productName = "Case for Iphone X"
    )
    private val iphone8Case = Product(
        price = 3990.0,
        discount = 15,
        productName = "Case for Iphone 8"
    )
    private val iphone7Case = Product(
        price = 3390.0,
        discount = 10,
        productName = "Case for Iphone 7"
    )
    private val iphone6Case = Product(
        price = 2870.0,
        discount = 22,
        productName = "Case for Iphone 6"
    )
    private val iphone5Case = Product(
        price = 1999.0,
        discount = 0,
        productName = "Case for Iphone 5"
    )
    private val samsungGalS9Case = Product(
        price = 2499.99,
        discount = 5,
        productName = "Case for Samsung Galaxy S9"
    )
    private val lgQ5Case = Product(
        price = 2499.99,
        discount = 5,
        productName = "Case for LG Q5"
    )
    private val lgQ6Case = Product(
        price = 2499.99,
        discount = 5,
        productName = "Case for LG Q6"
    )
    private val XiaomiMi5Case = Product(
        price = 1990.00,
        discount = 5,
        productName = "Case for LG Xiaomi Mi5"
    )
    private val XiaomiMi5SCase = Product(
        price = 1990.00,
        discount = 5,
        productName = "Case for LG Xiaomi Mi5S"
    )
    private val XiaomiMi8Case = Product(
        price = 1990.00,
        discount = 5,
        productName = "Case for LG Xiaomi Mi8"
    )
    private val products = mutableListOf(iphone11ProCase, iphone11Case,iphoneXSCase,iphoneXCase,
        iphone8Case,iphone7Case,iphone6Case,iphone5Case,samsungGalS9Case,lgQ6Case,lgQ5Case,
        XiaomiMi5Case,XiaomiMi5SCase,XiaomiMi8Case)

    private val model = CreateOrderModel()

    private fun checkSymbols(text: String):Boolean = text.length < 3

    private fun checkPhone(text: String):Boolean {

        //val pattern = Regex("^((8|\\+7)?){10}\$")
        //val res = pattern.containsMatchIn("text")
        //return res
        if(text == "") return true
        val firstChars = text.substring(0,1)
        if (firstChars == "+" && text.length == 12) return false
        return !(firstChars == "8" && text.length == 11)
    }

    fun checkEditText(
        text: String,
        fieldType: FieldType
    ){
        when(fieldType){
            FieldType.SURNAME -> model.surname
            FieldType.NAME -> model.mame
            FieldType.MIDDLE_NAME -> model.middleName
            FieldType.PHONE -> model.phone
        }
        if (fieldType == FieldType.PHONE) viewState.showErrorForEditText(checkPhone(text),fieldType)
        else viewState.showErrorForEditText(checkSymbols(text), fieldType)
    }

    fun getProductList() = products


    fun calcAmountPrice():Double{
        val amountPrice = products.sumByDouble { it.price }
        return amountPrice
    }

    fun calcAmountDiscount(): Double{
        val amountDiscount = products.sumByDouble { it.calcDiscount() }
        return amountDiscount
    }

    fun calcAmountDiscountPrice(): Double {
        val amountDiscountPrice = products.sumByDouble { it.calcDiscountPrice() }
        return amountDiscountPrice
    }

}

enum class FieldType {
    SURNAME,NAME, MIDDLE_NAME, PHONE, NONE
}


