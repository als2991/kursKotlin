package com.suvorov.suvorov_andrey_shop.about_product


import android.os.Bundle
import com.suvorov.suvorov_andrey_shop.BaseActivity
import com.suvorov.suvorov_andrey_shop.R
import kotlinx.android.synthetic.main.about_product_activity.*

class AboutProductActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_product_activity)

        aboutProductBackImg.setOnClickListener{
            finish()
        }
    }
}