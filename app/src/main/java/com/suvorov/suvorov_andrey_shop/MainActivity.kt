package com.suvorov.suvorov_andrey_shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Field

class MainActivity : AppCompatActivity(), ProductsView {

    private val presenter = BusketPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)

        val editList = listOf<EditText>(checkOutSurname, checkOutName,checkOutMiddleName)
        setListeners(editList)

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
      }
    }




}
