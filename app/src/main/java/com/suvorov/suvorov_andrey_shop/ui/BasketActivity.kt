package com.suvorov.suvorov_andrey_shop.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.suvorov.suvorov_andrey_shop.R
import com.suvorov.suvorov_andrey_shop.ui.CatalogActivity.Companion.IS_USER_AUTH
import com.suvorov.suvorov_andrey_shop.ui.CatalogActivity.Companion.REQUEST_AUTH
import com.suvorov.suvorov_andrey_shop.domain.model.Product
import com.suvorov.suvorov_andrey_shop.presenter.BasketPresenter
import kotlinx.android.synthetic.main.basket_activity.*
import moxy.ktx.moxyPresenter


class BasketActivity: BaseActivity(), BasketView {

    private var isAuth: Boolean = false
    private val presenter by moxyPresenter { BasketPresenter() }
    private val adapter = ProductAdapter { product ->
        presenter.removeItem(product)
    }


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

        basketAddImg.setOnClickListener { presenter.addItem(presenter.caseNokia8_1) }

        productsRv.layoutManager = LinearLayoutManager(this)
        productsRv.adapter = adapter

    }

    override fun setProducts(list: List<Product>) {
        adapter.SetData(list)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }

    override fun addItem(position: Int) {
        adapter.notifyItemInserted(position)
    }
}