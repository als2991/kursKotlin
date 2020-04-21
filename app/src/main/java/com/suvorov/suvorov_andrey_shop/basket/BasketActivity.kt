package com.suvorov.suvorov_andrey_shop.basket

import android.content.Intent
import android.os.Bundle
import com.suvorov.suvorov_andrey_shop.BaseActivity
import com.suvorov.suvorov_andrey_shop.R
import com.suvorov.suvorov_andrey_shop.catalog.CatalogActivity.Companion.IS_USER_AUTH
import com.suvorov.suvorov_andrey_shop.catalog.CatalogActivity.Companion.REQUEST_AUTH
import com.suvorov.suvorov_andrey_shop.checkout.CheckoutActivity
import kotlinx.android.synthetic.main.basket_activity.*


class BasketActivity: BaseActivity() {

    private var isAuth: Boolean = false

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
    }
}