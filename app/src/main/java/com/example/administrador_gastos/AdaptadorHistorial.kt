package com.example.administrador_gastos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorHistorial constructor(
    private var names: List<String>,
    var layout: Int,
    private var itemListener: OnItemClickListener
) : RecyclerView.Adapter<AdaptadorHistorial.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtViewName: TextView = itemView.findViewById(R.id.textViewName)

        fun bind(name: String?, position: Int) {
            txtViewName.text = name
            itemView.setOnClickListener {
                itemListener.onItemClick(name, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(names[position], position)
    }

    fun updateData(newData: List<String>) {
        names = newData
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(name: String?, position: Int)
    }
}
