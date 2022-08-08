package com.khldaliyeva.recyclerviewimplementation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExampleAdapter(private val exampleItems: List<ExampleItem>) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {
    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivItem: ImageView = itemView.findViewById(R.id.ivItem)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

    // EXPENSIVE
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent, false)
        return ExampleViewHolder(itemView)
    }

    // INEXPENSIVE
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.ivItem.setImageResource(exampleItems[position].imageRes)
        holder.tvTitle.text = exampleItems[position].title
        holder.tvDescription.text = exampleItems[position].description

        if (position == 0) {
            holder.tvTitle.setBackgroundColor(Color.GREEN)
        }
    }

    override fun getItemCount() = exampleItems.size
}