package com.suvorov.suvorov_andrey_shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity(), ProductsView, BasketView {

    private val presenter = BusketPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.basketPrint()
    }

    override fun printPriceProduct(price: Double) {
        Toast.makeText(this,"Price: $price",Toast.LENGTH_LONG).show()
        Log.d("PrintProduct","Price: $price")

    }

    override fun printNameProduct(name: String) {
        Log.d("PrintProduct","$name")
    }

    override fun printAmountBasket(AmountBasket: Double) {
        Log.d("PrintBasket","$AmountBasket")
    }

    override fun printProductsBasket(ProductsBasket: String) {
        Log.d("PrintBasket","$ProductsBasket")
    }




}
