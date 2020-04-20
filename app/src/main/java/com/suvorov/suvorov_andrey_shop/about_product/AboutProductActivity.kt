package com.suvorov.suvorov_andrey_shop.about_product

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.suvorov.suvorov_andrey_shop.R
import kotlinx.android.synthetic.main.about_product_activity.*

class AboutProductActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.about_product_activity)

        aboutProductBackImg.setOnClickListener{
            finish()
        }
    }
}