package com.suvorov.suvorov_andrey_shop.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suvorov.suvorov_andrey_shop.R
import kotlinx.android.synthetic.main.item_look_product_activity.view.*

class LookProductAdapter: RecyclerView.Adapter<LookProductAdapter.ViewHolder>() {

    private var lookProducts: List<Long> = listOf()

    fun setData(lookProducts : List<Long>){
        this.lookProducts = lookProducts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_look_product_activity, parent, false)
        )

    override fun getItemCount(): Int = lookProducts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lookProducts[position])

    }

   class ViewHolder(private val containerView: View): RecyclerView.ViewHolder(containerView){
        fun bind(id: Long){
            containerView.itemId.text = "$id"
        }
    }

}