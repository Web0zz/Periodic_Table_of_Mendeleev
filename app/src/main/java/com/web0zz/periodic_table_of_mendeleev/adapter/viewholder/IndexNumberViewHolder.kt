package com.web0zz.periodic_table_of_mendeleev.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.periodic_table_of_mendeleev.data.model.IndexNumber
import com.web0zz.periodic_table_of_mendeleev.databinding.ViewIndexNumberBinding

class IndexNumberViewHolder(private val binding: ViewIndexNumberBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(number: IndexNumber) {
        binding.indexNumber = number
    }

    companion object {
        fun create(parent: ViewGroup): IndexNumberViewHolder {
            val view = ViewIndexNumberBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return IndexNumberViewHolder(view)
        }
    }
}