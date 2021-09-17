package com.web0zz.periodic_table_of_mendeleev.element

import com.web0zz.periodic_table_of_mendeleev.adapter.RecyclerAdapter
import com.web0zz.periodic_table_of_mendeleev.data.model.Element
import com.web0zz.periodic_table_of_mendeleev.data.model.Item
import com.web0zz.periodic_table_of_mendeleev.element.DisplayType.*
import com.web0zz.periodic_table_of_mendeleev.element.ElementViewStyle.displayByChemicalGroupBlock
import com.web0zz.periodic_table_of_mendeleev.element.ElementViewStyle.displayByStandardStateStyle

abstract class ElementControl(private val adapter: RecyclerAdapter) {
    private val elements =
        adapter.items.filter { it.getType() == Item.Type.ELEMENT.ordinal }.map { it as Element }

    fun displayElementsBySelectedProperties(displayType: DisplayType) {
        when (displayType) {
            CHEMICAL_GROUP -> elements.forEach { displayByChemicalGroupBlock(it) }
            STANDARD_STATE -> elements.forEach { displayByStandardStateStyle(it) }
        }

        notifyElementDataChanged()
    }

    private fun notifyElementDataChanged() {
        elements.forEach { element ->
            adapter.notifyItemChanged(element.position)
        }
    }
}