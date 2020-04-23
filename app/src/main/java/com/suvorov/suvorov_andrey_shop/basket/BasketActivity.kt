package com.suvorov.suvorov_andrey_shop.basket

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.suvorov.suvorov_andrey_shop.BaseActivity
import com.suvorov.suvorov_andrey_shop.R
import com.suvorov.suvorov_andrey_shop.catalog.CatalogActivity.Companion.IS_USER_AUTH
import com.suvorov.suvorov_andrey_shop.catalog.CatalogActivity.Companion.REQUEST_AUTH
import com.suvorov.suvorov_andrey_shop.checkout.CheckOutPresenter
import com.suvorov.suvorov_andrey_shop.checkout.CheckoutActivity
import com.suvorov.suvorov_andrey_shop.checkout.Product
import kotlinx.android.synthetic.main.basket_activity.*


class BasketActivity: BaseActivity(), BasketView {

    private var isAuth: Boolean = false
    private val presenter = BasketPresenter()
    private val adapter = ProductAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basket_activity)

        //working variant with example return requestCode
        basketBackImg.setOnClickListener{
            isAuth = true
            setResult(REQUEST_AUTH, Intent().apply {
                putExtra(IS_USER_AUTH,isAuth)
            })
            finish()
        }

        basketCheckOutBtn.setOnClickListener{
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }

        productsRv.layoutManager = LinearLayoutManager(this)
        productsRv.adapter = adapter

        presenter.attachView(this)
        presenter.SetData()


    }

    override fun setProducts(list: List<Product>) {
        adapter.SetData(list)
    }

    override fun removeItem(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}