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

        presenter.attachView(this)

        checkOutSurname.showError(true)
        setListeners()

        checkOutSumValue.text = presenter.calcAmountPrice().toString()
        checkOutSale.text = presenter.calcAmountDiscount().toString()
        checkOutTotalPriceWithSale.text = presenter.calcAmountDiscountPrice().toString()

        checkoutPay.setOnClickListener{
            Toast.makeText(this, checkOutTotalPriceWithSale.text, Toast.LENGTH_LONG).show()
        }
    }


    private fun setListeners(){
    /*  private fun setListeners(editors: List<EditText>){
          editors.forEach {
              it.addTextChangedListener(object : TextWatcher {

                  override fun afterTextChanged(s: Editable?) {
                      val visible = checkSymbols(it.text.toString())
                      it.showError(visible)
                  }

                  override fun beforeTextChanged(
                      s: CharSequence?,
                      start: Int,
                      count: Int,
                      after: Int
                  ) {
                  }

                  override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
              })*/

        //через addTextChangedListener
        checkOutName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val visible = checkSymbols(s.toString())
                checkOutName.showError(visible)}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })

        //через onFocusChangeListener
        checkOutMiddleName.onFocusChangeListener = View.OnFocusChangeListener{v, hashFocus ->
            if (!hashFocus){
                var visible = checkSymbols(checkOutMiddleName.text.toString())
                checkOutMiddleName.showError(visible)
            }
        }
    }

    fun checkSymbols(text: String):Boolean = text.length < 3

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




}
