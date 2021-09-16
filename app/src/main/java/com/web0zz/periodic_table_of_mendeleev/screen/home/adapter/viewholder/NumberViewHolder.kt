package com.web0zz.periodic_table_of_mendeleev.screen.home.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.periodic_table_of_mendeleev.data.model.Number
import com.web0zz.periodic_table_of_mendeleev.databinding.ViewNumberBinding

class NumberViewHolder(private val binding: ViewNumberBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(number: Number) {
        binding.lineNumber = number
    }

    companion object {
        fun create(parent: ViewGroup): NumberViewHolder {
            val view = ViewNumberBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return NumberViewHolder(view)
        }
    }
}