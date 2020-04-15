package com.suvorov.suvorov_andrey_shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductsView {

    private val presenter = BusketPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editList = listOf<EditText>(checkOutSurname, checkOutName,checkOutMiddleName)

        presenter.attachView(this)
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
              it.addTextChangedListener(object : TextWatcher {

                  override fun afterTextChanged(s: Editable?) = presenter.checkEditText(it)

                  override fun beforeTextChanged(
                      s: CharSequence?,
                      start: Int,
                      count: Int,
                      after: Int
                  ) {}

                  override fun onTextChanged(
                      s: CharSequence?,
                      start: Int,
                      before: Int,
                      count: Int
                  ) {}
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

    override fun showErrorForEditText(visible: Boolean, edit: EditText) = edit.showError(visible)




}
