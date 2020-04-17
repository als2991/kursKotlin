package com.suvorov.suvorov_andrey_shop

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

        catalogCheckOutBtn.setOnClickListener{
            val intent = Intent(this,CheckoutActivity::class.java).apply {
                putExtra(PRODUCT_ID,1000)
            }
            startActivity(intent)
        }

    }


    companion object{
        const val PRODUCT_ID = "PRODUCT_ID"
        const val REQUEST_AUTH :Int = 10
    }
}