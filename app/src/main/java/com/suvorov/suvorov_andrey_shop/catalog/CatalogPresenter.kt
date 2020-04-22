package com.suvorov.suvorov_andrey_shop.catalog

import moxy.MvpPresenter

class CatalogPresenter : MvpPresenter<CatalogView>(){

    //изменяемый лист
    private val list = mutableListOf(
        "Телевизоры",
        "Телефоны",
        "Планшеты",
        "Часы",
        "Компьютеры",
        "Ноутбуки"
    )

    fun setData(){
        viewState.setCategories(list)
    }

    fun removeItem(category: String){
        val position = list.indexOf(category)
        list.remove(category)
        viewState.removeItem(position)
    }

}