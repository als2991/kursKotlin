package com.suvorov.suvorov_andrey_shop.checkout

import moxy.MvpPresenter
import java.util.regex.Pattern

class CheckOutPresenter: MvpPresenter<ProductsView>() {
    private val iphoneXCase = Product(
        price = 123.5,
        salePercent = 29,
        productName = "Case for Iphone X"
    )
    private val samsungGalS9Case = Product(
        price = 100.0,
        salePercent = 10,
        productName = "Case for Samsung Galaxy S9"
    )
    private val lgQ6Case = Product(
        price = 99.99,
        salePercent = 10,
        productName = "Case for LG Q6"
    )
    private val products = listOf(iphoneXCase,samsungGalS9Case,lgQ6Case)

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





    fun calcAmountPrice():Double{
        val amountPrice = products.sumByDouble { it.getPrice() }
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


