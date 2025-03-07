package com.example.animalrecyleview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(private val itemList: List<Item>, private val context: Context) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.itemImage)

        init {
            view.setOnClickListener {
                val position = adapterPosition
                if (position == RecyclerView.NO_POSITION) return@setOnClickListener  // Chặn crash nếu position sai

                val item = itemList[position]
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("id", item.id)
                    putExtra("name", item.name)
                    putExtra("description", item.description)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.imageView.setImageResource(item.imageResId)
    }

    override fun getItemCount() = itemList.size
}
