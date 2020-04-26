package com.suvorov.suvorov_andrey_shop.domain.model

data class CreateOrderModel(

    /*
    ** Модель для создания заказа
     */
    var surname: String = "",
    var mame: String = "",
    var middleName: String = "",
    var phone: String = ""
)
