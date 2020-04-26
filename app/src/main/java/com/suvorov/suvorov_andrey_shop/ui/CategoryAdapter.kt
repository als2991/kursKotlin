package com.suvorov.suvorov_andrey_shop.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suvorov.suvorov_andrey_shop.R

import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(
    private val onDeleteClick: (string: String) -> Unit
): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    //создает новый объект ViewHolder, когда RecyclerView нуждается в этом (создание строки списка в Layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )

    private var categories : List<String> = listOf()

    fun SetData(categories : List<String>){
        this.categories = categories
        notifyDataSetChanged()
    }
    // общее количество элементов списка
    override fun getItemCount(): Int = categories.size

    //принимает объект ViewHolderа и устанавливает необходимые данные для строки в View компоненте(прокидываем данные, которые необходимо отобразить)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(text: String){
            itemView.categoryTv.text = text

            itemView.deleteIv.setOnClickListener {
                onDeleteClick(text)
            }
        }

    }
}