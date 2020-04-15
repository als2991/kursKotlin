package com.suvorov.suvorov_andrey_shop

import android.widget.EditText
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProductsView:MvpView{
    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun printPriceProduct(price: Double)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun printNameProduct(name: String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForEditText(visible: Boolean, edit: EditText)
}