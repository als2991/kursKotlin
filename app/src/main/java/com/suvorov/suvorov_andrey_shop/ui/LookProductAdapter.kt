package com.suvorov.suvorov_andrey_shop.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suvorov.suvorov_andrey_shop.R
import kotlinx.android.synthetic.main.item_look_product_activity.view.*

class LookProductAdapter: RecyclerView.Adapter<LookProductAdapter.ViewHolder>() {

    private var lookProductsId: List<Long> = listOf()
    private var lookProductsName: List<String> = listOf()
    private var lookProductsPrice: List<String> = listOf()

    fun setData(lookProductsId : List<Long>, lookProductsName : List<String>, lookProductsPrice : List<String>){
        this.lookProductsId = lookProductsId
        this.lookProductsName = lookProductsName
        this.lookProductsPrice = lookProductsPrice
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_look_product_activity, parent, false)
        )

    override fun getItemCount(): Int = lookProductsId.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lookProductsId[position],lookProductsName[position], lookProductsPrice[position])

    }

   class ViewHolder(private val containerView: View): RecyclerView.ViewHolder(containerView){
        fun bind(id: Long, name: String, price: String){
            containerView.itemId.text = "$id"
            containerView.itemName.text = name
            containerView.itemPrice.text = price
        }
    }

}