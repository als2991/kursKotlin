package com.suvorov.suvorov_andrey_shop.presenter

import com.suvorov.suvorov_andrey_shop.domain.model.CreateOrderModel
import com.suvorov.suvorov_andrey_shop.domain.model.Product
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class CheckOutPresenter: MvpPresenter<ProductsView>() {

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
}

enum class FieldType {
    SURNAME,NAME, MIDDLE_NAME, PHONE, NONE
}


