package com.web0zz.periodic_table_of_mendeleev.screen.home.adapter.util

import androidx.recyclerview.widget.DiffUtil
import com.web0zz.periodic_table_of_mendeleev.data.model.Item

open class DiffCallback(
    private val oldItems: List<Item>,
    private val newItems: List<Item>,
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}