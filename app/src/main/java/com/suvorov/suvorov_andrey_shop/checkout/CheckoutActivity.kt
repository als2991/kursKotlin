package com.suvorov.suvorov_andrey_shop.checkout

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.suvorov.suvorov_andrey_shop.*
import com.suvorov.suvorov_andrey_shop.catalog.CatalogActivity.Companion.IS_USER_AUTH
import com.suvorov.suvorov_andrey_shop.catalog.CatalogActivity.Companion.PRODUCT_ID
import com.suvorov.suvorov_andrey_shop.catalog.CatalogActivity.Companion.REQUEST_AUTH
import kotlinx.android.synthetic.main.checkout_activity.*


class CheckoutActivity : BaseActivity(), ProductsView {

    private val presenter = BusketPresenter()
    private var isAuth: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkout_activity)

        presenter.attachView(this)
        val productID = intent.extras?.getInt(PRODUCT_ID,-1)
        Log.d(tag,productID.toString())


        val editList = listOf<EditText>(checkOutSurname, checkOutName,checkOutMiddleName,checkOutPhone)
        setListeners(editList)

        checkoutPay.setOnClickListener{
            isAuth = true
            setResult(REQUEST_AUTH, Intent().apply {
                putExtra(IS_USER_AUTH,isAuth)
            })

        }

        checkOutBackImg.setOnClickListener{
            finish()
        }

        //checkOutSumValue.text = presenter.calcAmountPrice().toString()
        //checkOutSale.text = presenter.calcAmountDiscount().toString()
        //checkOutTotalPriceWithSale.text = presenter.calcAmountDiscountPrice().toString()

        //checkoutPay.setOnClickListener{
        //    Toast.makeText(this, checkOutTotalPriceWithSale.text, Toast.LENGTH_LONG).show()
        //}
    }

      private fun setListeners(editors: List<EditText>) {
          editors.forEach {
              val editType: FieldType = when(it.id){
                  R.id.checkOutSurname -> FieldType.SURNAME
                  R.id.checkOutName -> FieldType.NAME
                  R.id.checkOutMiddleName -> FieldType.MIDDLE_NAME
                  R.id.checkOutPhone -> FieldType.PHONE
                  else -> FieldType.NONE
              }
              it.addTextChangedListener(object : SimpleTextWatcher() {

                  override fun afterTextChanged(s: Editable?) {
                      super.afterTextChanged(s)
                      presenter.checkEditText(it.text.toString(),editType)
                  }
              })
          }
      }



    fun EditText.showError(visible: Boolean){
        val drawable = if(visible) R.drawable.ic_error
        else 0

        this.setCompoundDrawablesWithIntrinsicBounds(0,0,drawable,0)
    }

    override fun printPriceProduct(price: Double) {
        Toast.makeText(this,"Price: $price",Toast.LENGTH_LONG).show()
        Log.d("PrintProduct","Price: $price")
    }

    override fun printNameProduct(name: String) {
        Log.d("PrintProduct","$name")
    }

    override fun showErrorForEditText(visible: Boolean, fieldType: FieldType){
      when (fieldType){
          FieldType.SURNAME -> checkOutSurname.showError(visible)
          FieldType.NAME -> checkOutName.showError(visible)
          FieldType.MIDDLE_NAME -> checkOutMiddleName.showError(visible)
          FieldType.PHONE -> checkOutPhone.showError(visible)
      }
    }




}
