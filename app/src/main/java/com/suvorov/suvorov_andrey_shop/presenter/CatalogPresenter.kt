package com.suvorov.suvorov_andrey_shop.presenter

import com.suvorov.suvorov_andrey_shop.domain.ViewedProductDao
import com.suvorov.suvorov_andrey_shop.ui.CatalogView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class CatalogPresenter(
    private val viewedProductDao: ViewedProductDao
) : MvpPresenter<CatalogView>(){

    //изменяемый лист
    private val list = mutableListOf(
        "Телевизоры",
        "Телефоны",
        "Планшеты",
        "Часы",
        "Компьютеры",
        "Ноутбуки"
    )

    //срабатывает когда View Died
    override fun destroyView(view: CatalogView?) {
        super.destroyView(view)
    }

    //срабатывает когда View аттачится (например поворот экрана)
    override fun attachView(view: CatalogView?) {
        super.attachView(view)
        val productIds = viewedProductDao.getAllProducts()
        viewState.showProductIds(productIds)
    }

    //срабатывает когда View первый раз аттачится (загрузка продуктов, установка данных итд)
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setData()
    }

    fun setData(){
        viewState.setCategories(list)
    }

    fun removeItem(category: String){
        val position = list.indexOf(category)
        list.remove(category)
        viewState.removeItem(position)
    }

}