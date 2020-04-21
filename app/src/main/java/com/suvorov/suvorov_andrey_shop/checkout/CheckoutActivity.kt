package com.suvorov.suvorov_andrey_shop.checkout

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.EditText
import com.suvorov.suvorov_andrey_shop.*
import com.suvorov.suvorov_andrey_shop.catalog.CatalogActivity.Companion.PRODUCT_ID
import kotlinx.android.synthetic.main.checkout_activity.*


class CheckoutActivity : BaseActivity(), ProductsView {

    private val presenter = CheckOutPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkout_activity)

        presenter.attachView(this)

        val editList = listOf<EditText>(checkOutSurname, checkOutName,checkOutMiddleName,checkOutPhone)
        setListeners(editList)

        checkOutBackImg.setOnClickListener{
            finish()
        }

        val productID = intent.extras?.getInt(PRODUCT_ID,-1)
        Log.d(tag,productID.toString())

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

    override fun showErrorForEditText(visible: Boolean, fieldType: FieldType){
      when (fieldType){
          FieldType.SURNAME -> checkOutSurname.showError(visible)
          FieldType.NAME -> checkOutName.showError(visible)
          FieldType.MIDDLE_NAME -> checkOutMiddleName.showError(visible)
          FieldType.PHONE -> checkOutPhone.showError(visible)
      }

    }



}
