package com.web0zz.periodic_table_of_mendeleev.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.periodic_table_of_mendeleev.databinding.ViewEmptyBinding

class EmptyViewHolder(binding: ViewEmptyBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind() {}

    companion object {
        fun create(parent: ViewGroup): EmptyViewHolder {
            val view = ViewEmptyBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return EmptyViewHolder(view)
        }
    }
}