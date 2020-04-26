package com.suvorov.suvorov_andrey_shop.ui

import com.suvorov.suvorov_andrey_shop.domain.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface BasketView:MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProducts(list: List<Product>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun removeItem(position:Int)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun addItem(position: Int)
}