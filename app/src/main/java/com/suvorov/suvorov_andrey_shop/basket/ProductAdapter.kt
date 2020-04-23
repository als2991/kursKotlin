package com.suvorov.suvorov_andrey_shop.basket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suvorov.suvorov_andrey_shop.R
import com.suvorov.suvorov_andrey_shop.checkout.Product
import kotlinx.android.synthetic.main.item_product.view.*

//class ProductAdapter(
//    private val onDeleteClick: (string: String) -> Unit
//):RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

class ProductAdapter():RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        )

        private var products : List<Product> = listOf()

    fun SetData(products: List<Product>){
        this.products = products
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
       holder.bind(products[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(product: Product){
            itemView.itemNameProduct.text = product.productName
            itemView.itemDiscount.text = product.discount.toString()
            itemView.itemPrice.text = product.calcDiscountPrice().toString()
            }
        }
}