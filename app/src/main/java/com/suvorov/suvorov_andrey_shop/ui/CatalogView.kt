package com.suvorov.suvorov_andrey_shop.ui

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface CatalogView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setCategories(list: List<String>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun removeItem(position: Int)


    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showProductIds(productIds: List<Long>, productNames: List<String>, productPrice:List<String>)
}