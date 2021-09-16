package com.web0zz.periodic_table_of_mendeleev.screen.home.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.periodic_table_of_mendeleev.data.model.Empty
import com.web0zz.periodic_table_of_mendeleev.databinding.ViewEmptyBinding

class EmptyViewHolder(binding: ViewEmptyBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(empty: Empty) {}

    companion object {
        fun create(parent: ViewGroup): EmptyViewHolder {
            val view = ViewEmptyBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return EmptyViewHolder(view)
        }
    }
}