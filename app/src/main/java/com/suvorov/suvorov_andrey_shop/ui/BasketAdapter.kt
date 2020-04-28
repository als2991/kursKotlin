package com.suvorov.suvorov_andrey_shop.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suvorov.suvorov_andrey_shop.R
import com.suvorov.suvorov_andrey_shop.domain.model.Product
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_product.*
import kotlinx.android.synthetic.main.item_product.view.*

class BasketAdapter(
    private val onDeleteClick: (product: Product) -> Unit,
    private val onProductClick: (product: Product) -> Unit
):RecyclerView.Adapter<BasketAdapter.ViewHolder>() {

    inner class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer{

        fun bind(product: Product){
            itemNameProduct.text = product.productName
            itemDiscount.text = "${product.discount}%"
            itemPrice.text = "${product.calcDiscountPrice()} Р"

            itemView.deleteIv.setOnClickListener { onDeleteClick(product) }
            containerView.setOnClickListener { onProductClick(product) }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        )

        private var products : List<Product> = listOf()

    fun setData(products: List<Product>){
        this.products = products
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(products[position])
    }

}