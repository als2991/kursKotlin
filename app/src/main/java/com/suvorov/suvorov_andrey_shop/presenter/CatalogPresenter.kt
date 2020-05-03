package com.suvorov.suvorov_andrey_shop.presenter

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.suvorov.suvorov_andrey_shop.R
import com.suvorov.suvorov_andrey_shop.domain.MainApi
import com.suvorov.suvorov_andrey_shop.domain.ViewedProductDao
import com.suvorov.suvorov_andrey_shop.ui.CatalogView
import kotlinx.coroutines.*
import moxy.InjectViewState
import java.net.ConnectException
import java.net.UnknownHostException

@InjectViewState
class CatalogPresenter(
    private val mainApi: MainApi,
    private val viewedProductDao: ViewedProductDao,
    private val context: Context
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
        hasConnection(context)

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

    //from SDK level < 29
    private fun hasConnection(context: Context){
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        var result = false

        if(activeNetwork != null) result = activeNetwork.isConnectedOrConnecting
        if(!result) viewState.showError(context.getString(R.string.no_connect_internet))
    }

    override fun onFailure(e: Throwable) {
        super.onFailure(e)
         if (e is UnknownHostException || e is ConnectException)
             viewState.showError(context.getString(R.string.no_connect_server))
    }

}