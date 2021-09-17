package com.web0zz.periodic_table_of_mendeleev.element


import android.content.Context
import com.web0zz.periodic_table_of_mendeleev.adapter.RecyclerAdapter
import com.web0zz.periodic_table_of_mendeleev.data.model.Element
import com.web0zz.periodic_table_of_mendeleev.data.model.Item
import com.web0zz.periodic_table_of_mendeleev.element.DisplayType.*
import com.web0zz.periodic_table_of_mendeleev.element.ElementViewStyle.displayByChemicalGroupBlock
import com.web0zz.periodic_table_of_mendeleev.element.ElementViewStyle.displayByStandardStateStyle
import com.web0zz.periodic_table_of_mendeleev.element.ElementViewStyle.getColorByCalculating

abstract class ElementControl(private val adapter: RecyclerAdapter, private val context: Context) {
    private val elements =
        adapter.items.filter { it.getType() == Item.Type.ELEMENT.ordinal }.map { it as Element }

    private fun Element.setGeneratedColor(value: String) {
        this.colorBackground = context.getColorByCalculating(value.toFloat())

        notifyElementDataChanged()
    }

    fun displayElementsBySelectedProperties(displayType: DisplayType) {
        when (displayType) {
            CHEMICAL_GROUP -> elements.forEach { displayByChemicalGroupBlock(it) }
            STANDARD_STATE -> elements.forEach { displayByStandardStateStyle(it) }
            ATOMIC_MASS -> elements.forEach { it.setGeneratedColor(it.atomicWeight) }
            /*ELECTRONEGATIVITY -> elements.forEach { it.setGeneratedColor(it.electronegativity) }
            IONIZATION_ENERGY -> elements.forEach { it.setGeneratedColor(it.ionizationEnergy) }
            ELECTRON_AFFINITY -> elements.forEach { it.setGeneratedColor(it.electronAffinity) }
            MELTING_POINT -> elements.forEach { it.setGeneratedColor(it.meltingPoint) }
            BOILING_POINT -> elements.forEach { it.setGeneratedColor(it.boilingPoint) }
            DENSITY -> elements.forEach { it.setGeneratedColor(it.density) }
            YEAR_DISCOVERED -> elements.forEach { it.setGeneratedColor(it.yearDiscovered) }*/
            else -> elements.forEach { displayByChemicalGroupBlock(it) }
        }

        notifyElementDataChanged()
    }

    private fun notifyElementDataChanged() {
        elements.forEach { element ->
            adapter.notifyItemChanged(element.position)
        }
    }
}