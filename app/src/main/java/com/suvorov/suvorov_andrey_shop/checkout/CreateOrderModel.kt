package com.suvorov.suvorov_andrey_shop.checkout

data class CreateOrderModel(

    /*
    ** Модель для создания заказа
     */
    var surname: String = "",
    var mame: String = "",
    var middleName: String = "",
    var phone: String = ""
)
