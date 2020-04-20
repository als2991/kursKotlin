package com.suvorov.suvorov_andrey_shop.catalog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.suvorov.suvorov_andrey_shop.BaseActivity
import com.suvorov.suvorov_andrey_shop.checkout.CheckoutActivity
import com.suvorov.suvorov_andrey_shop.R
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

        val saveInt = savedInstanceState?.getInt(SAVE_STATE_INT)

        catalogCheckOutBtn.setOnClickListener{
            val intent = Intent(this, CheckoutActivity::class.java).apply {
                putExtra(PRODUCT_ID,1000)
            }
            startActivityForResult(intent,REQUEST_AUTH)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(SAVE_STATE_INT, 89)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && REQUEST_AUTH == requestCode){
            val isUserAuth = data?.extras?.getBoolean(IS_USER_AUTH)
            Log.d(tag,isUserAuth.toString())
        }
    }


    companion object{
        const val PRODUCT_ID = "PRODUCT_ID"
        const val REQUEST_AUTH: Int = 1
        const val IS_USER_AUTH = "IS_USER_AUTH"
        const val SAVE_STATE_INT = "SAVE_STATE_INT"
    }
}