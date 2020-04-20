package com.suvorov.suvorov_andrey_shop.basket

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.suvorov.suvorov_andrey_shop.R
import com.suvorov.suvorov_andrey_shop.checkout.CheckoutActivity
import kotlinx.android.synthetic.main.basket_activity.*


class BasketActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.basket_activity)

        basketBackImg.setOnClickListener{
            finish()
        }

        basketCheckOutBtn.setOnClickListener{
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }
}