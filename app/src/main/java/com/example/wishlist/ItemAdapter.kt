package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val priceTextView: TextView
        val linkTextView: TextView
        init {
            nameTextView = itemView.findViewById(R.id.nameTv)
            priceTextView = itemView.findViewById(R.id.priceTv)
            linkTextView = itemView.findViewById(R.id.linkTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_layout, parent, false)
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.nameTextView.text = item.name
        holder.priceTextView.text = item.price
        holder.linkTextView.text = item.link
    }
}