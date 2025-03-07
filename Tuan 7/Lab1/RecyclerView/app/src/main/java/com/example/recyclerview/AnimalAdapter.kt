package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class AnimalAdapter(
    private val animals: List<Animal>,
    private val clickListener: (Animal) -> Unit
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    inner class AnimalViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView =
            itemView.findViewById(R.id.nameTextView)
        init {
            itemView.setOnClickListener {
                clickListener(animals[adapterPosition])
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }
    override fun onBindViewHolder(holder: AnimalViewHolder,
                                  position: Int) {
        holder.nameTextView.text = animals[position].name
    }
    override fun getItemCount(): Int = animals.size
}