package com.web0zz.periodic_table_of_mendeleev.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.periodic_table_of_mendeleev.adapter.viewholder.ElementViewHolder
import com.web0zz.periodic_table_of_mendeleev.adapter.viewholder.EmptyViewHolder
import com.web0zz.periodic_table_of_mendeleev.adapter.viewholder.NumberViewHolder
import com.web0zz.periodic_table_of_mendeleev.data.model.Element
import com.web0zz.periodic_table_of_mendeleev.data.model.Item
import com.web0zz.periodic_table_of_mendeleev.data.model.Item.Type.*
import com.web0zz.periodic_table_of_mendeleev.data.model.Number

class RecyclerAdapter(
    var items: List<Item>,
    private val onElementClicked: (Element) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int) = items[position].getType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            NUMBER.ordinal -> NumberViewHolder.create(parent)
            ELEMENT.ordinal -> ElementViewHolder.create(parent) {
                onElementClicked(items[it] as Element)
            }
            EMPTY.ordinal -> EmptyViewHolder.create(parent)
            else -> throw Exception("Unknown view type exception")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NumberViewHolder -> holder.bind(items[position] as Number)
            is ElementViewHolder -> holder.bind(items[position] as Element, position)
            is EmptyViewHolder -> holder.bind()
            else -> throw Exception("Unknown view type exception")
        }
    }

    override fun getItemCount() = items.size
}