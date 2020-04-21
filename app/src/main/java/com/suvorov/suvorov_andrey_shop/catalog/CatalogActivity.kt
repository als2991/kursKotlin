package com.suvorov.suvorov_andrey_shop.catalog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.suvorov.suvorov_andrey_shop.BaseActivity
import com.suvorov.suvorov_andrey_shop.R
import com.suvorov.suvorov_andrey_shop.about_product.AboutProductActivity
import com.suvorov.suvorov_andrey_shop.basket.BasketActivity
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

        // working variant with example putExtra
        catalogBasketImg.setOnClickListener {
            val intent = Intent(this, BasketActivity::class.java).apply {
                putExtra(PRODUCT_ID,1000)
            }
            startActivityForResult(intent, REQUEST_AUTH)
        }

        catalogInfoImg.setOnClickListener {
        val intent = Intent(this, AboutProductActivity::class.java )
        startActivity(intent)
        }
    }




    //example how save in Bundle
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SAVE_STATE_INT, 89)
    }

    //example how read resultCode for another activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && REQUEST_AUTH == requestCode){
            val isUserAuth = data?.extras?.getBoolean(IS_USER_AUTH)
            Log.d(tag,isUserAuth.toString())
        }
    }

    //example replacements static java
    companion object{
        const val PRODUCT_ID = "PRODUCT_ID"
        const val REQUEST_AUTH: Int = 1
        const val IS_USER_AUTH = "IS_USER_AUTH"
        const val SAVE_STATE_INT = "SAVE_STATE_INT"
    }
}