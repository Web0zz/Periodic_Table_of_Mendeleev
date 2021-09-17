package com.web0zz.periodic_table_of_mendeleev.element


import android.content.Context
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.ColorUtils
import com.web0zz.periodic_table_of_mendeleev.R
import com.web0zz.periodic_table_of_mendeleev.data.model.Element

object ElementViewStyle {
    // Calculate color style view
    fun Context.getColorByCalculating(num: Float): Int {
        val percentage = num / 100

        return ColorUtils.setAlphaComponent(
            ResourcesCompat.getColor(resources, R.color.generate_color_default, null),
            (percentage * 255).toInt()
        )
    }

    fun displayByChemicalGroupBlock(element: Element) {
        when (element.chemicalGroup) {
            "Nonmetal" -> {
                element.colorBackground = R.color.group_background_nonmetal
                element.colorText = R.color.group_text_nonmetal
            }
            "Alkali Metal" -> {
                element.colorBackground = R.color.group_background_alkali_metal
                element.colorText = R.color.group_text_alkali_metal
            }
            "Alkaline Earth Metal" -> {
                element.colorBackground = R.color.group_background_alkaline_earth_metal
                element.colorText = R.color.group_text_alkali_alkaline_earth_metal
            }
            "Transition Metal" -> {
                element.colorBackground = R.color.group_background_transition_metal
                element.colorText = R.color.group_text_transition_metal
            }
            "Lanthanide" -> {
                element.colorBackground = R.color.group_background_lanthanide
                element.colorText = R.color.group_text_lanthanide
            }
            "Actinide" -> {
                element.colorBackground = R.color.group_background_actinide
                element.colorText = R.color.group_text_actinide
            }
            "Metalloid" -> {
                element.colorBackground = R.color.group_background_metalloid
                element.colorText = R.color.group_text_metalloid
            }
            "Post-Transition Metal" -> {
                element.colorBackground = R.color.group_background_post_transition_metal
                element.colorText = R.color.group_text_post_transition_metal
            }
            "Noble Gas" -> {
                element.colorBackground = R.color.group_background_noble_gas
                element.colorText = R.color.group_text_noble_gas
            }
        }
    }

    fun displayByStandardStateStyle(element: Element) {
        when (element.standardStyle) {
            "Gas" -> element.colorBackground = R.color.state_background_gas
            "Solid" -> element.colorBackground = R.color.state_background_solid
            "Liquid" -> element.colorBackground = R.color.state_background_liquid
        }

        element.colorText = R.color.default_element_text
    }
}