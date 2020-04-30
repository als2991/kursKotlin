package com.suvorov.suvorov_andrey_shop.presenter

import com.suvorov.suvorov_andrey_shop.domain.MainApi
import com.suvorov.suvorov_andrey_shop.domain.ViewedProductDao
import com.suvorov.suvorov_andrey_shop.ui.CatalogView
import kotlinx.coroutines.*
import moxy.InjectViewState
import moxy.MvpPresenter
import okhttp3.Dispatcher

@InjectViewState
class CatalogPresenter(
    private val mainApi: MainApi,
    private val viewedProductDao: ViewedProductDao
) : BasePresenter<CatalogView>(){

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
        val productIds = viewedProductDao.getAllProductsId()
        val productNames = viewedProductDao.getAllProductsName()
        val productPrices = viewedProductDao.getAllProductsPrice()
        viewState.showProductIds(productIds, productNames, productPrices)
    }



    //срабатывает когда View первый раз аттачится (загрузка продуктов, установка данных итд)
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

            //setData()

        launch{
            val remoteProducts = mainApi.allProduct(author = "default")
            val productNames = remoteProducts.map { remoteProduct -> remoteProduct.name }
            viewState.setCategories(productNames)
        }

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