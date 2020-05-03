package com.suvorov.suvorov_andrey_shop.ui

import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.suvorov.suvorov_andrey_shop.R
import com.suvorov.suvorov_andrey_shop.data.ViewedProductDaoImpl
import com.suvorov.suvorov_andrey_shop.domain.MainApi
import com.suvorov.suvorov_andrey_shop.presenter.CatalogPresenter
import kotlinx.android.synthetic.main.catalog_layout.*
import moxy.ktx.moxyPresenter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatalogActivity: BaseActivity(), CatalogView {

      private val presenter by moxyPresenter {
          val retrofit = Retrofit.Builder()
              .baseUrl(getString(R.string.url_server))
              .addConverterFactory(GsonConverterFactory.create())
              .build()
          val service = retrofit.create(MainApi::class.java)

          CatalogPresenter(
              mainApi = service,
              viewedProductDao = ViewedProductDaoImpl(sharedPreferences),
              context = this
          )
      }
      private val adapter = CategoryAdapter { category ->
          presenter.removeItem(category)
      }

    private val adapterLook = LookProductAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

        //example when save value in Bundle
        Log.d(tag, "saveInstanceState = $savedInstanceState")
        val savedInt = savedInstanceState?.getInt(SAVE_STATE_INT)
        Log.d(tag, "saveInd = $savedInt")

        // working variant with example putExtra
        catalogBasketImg.setOnClickListener {
            val intent = Intent(this, BasketActivity::class.java).apply {
                putExtra(PRODUCT_ID,1000)
            }
            startActivityForResult(intent,
                REQUEST_AUTH
            )
        }

          categoryRv.layoutManager = LinearLayoutManager(this)
          categoryRv.adapter = adapter

          lookRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
          lookRv.adapter = adapterLook

    }

    override fun setCategories(list: List<String>) {
       adapter.setData(list)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
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


    override fun showProductIds(productIds: List<Long>, productNames: List<String>, productPrice: List<String>) {
        adapterLook.setData(productIds, productNames, productPrice)
        //Toast.makeText(this,productIds.joinToString ( "," ), Toast.LENGTH_LONG).show()
    }

    override fun showError(text: String) {
        Toast.makeText(this, text,Toast.LENGTH_LONG).show()
    }


    //example replacements static java
    companion object{
        const val PRODUCT_ID = "PRODUCT_ID"
        const val REQUEST_AUTH: Int = 1
        const val IS_USER_AUTH = "IS_USER_AUTH"
        const val SAVE_STATE_INT = "SAVE_STATE_INT"
    }
}

val AppCompatActivity.sharedPreferences: SharedPreferences
    get() = getSharedPreferences("data", MODE_PRIVATE)
