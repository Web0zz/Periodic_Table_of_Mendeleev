package com.web0zz.periodic_table_of_mendeleev.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.periodic_table_of_mendeleev.R
import com.web0zz.periodic_table_of_mendeleev.data.model.Element
import com.web0zz.periodic_table_of_mendeleev.databinding.ViewElementBinding

class ElementViewHolder(
    private val binding: ViewElementBinding,
    onElementClicked: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    init {
        itemView.setOnClickListener {
            onElementClicked(adapterPosition)
        }
    }

    fun bind(element: Element, position: Int) {
        binding.element = element
        element.position = position

        val elementAnim = AnimationUtils.loadAnimation(this.itemView.context, R.anim.element_anim)
        binding.root.startAnimation(elementAnim)
    }

    companion object {
        fun create(parent: ViewGroup, onElementClicked: (Int) -> Unit): ElementViewHolder {
            val view = ViewElementBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ElementViewHolder(view, onElementClicked)
        }
    }
}