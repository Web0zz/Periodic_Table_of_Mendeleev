package com.web0zz.periodic_table_of_mendeleev.screen.home.adapter.viewholder


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.periodic_table_of_mendeleev.data.model.Element
import com.web0zz.periodic_table_of_mendeleev.databinding.ViewElementBinding

class ElementViewHolder(private val binding: ViewElementBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(element: Element, position: Int) {
        binding.element = element
        element.getPosition(position)
    }

    companion object {
        fun create(parent: ViewGroup): ElementViewHolder {
            val view = ViewElementBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ElementViewHolder(view)
        }
    }
}