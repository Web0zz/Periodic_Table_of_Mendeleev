package com.web0zz.periodic_table_of_mendeleev.element


import com.web0zz.periodic_table_of_mendeleev.R
import com.web0zz.periodic_table_of_mendeleev.data.model.Element

object ElementViewStyle {

    fun displayByChemicalGroupBlock(element: Element) {
        when (element.chemicalGroup) {
            "Nonmetal" -> {
                element.colorBackground = R.color.group_background_nonmetal
                element.colorText = R.color.group_text_nonmetal
                element.contentText = element.chemicalGroup
            }
            "Alkali Metal" -> {
                element.colorBackground = R.color.group_background_alkali_metal
                element.colorText = R.color.group_text_alkali_metal
                element.contentText = element.chemicalGroup
            }
            "Alkaline E. Metal" -> {
                element.colorBackground = R.color.group_background_alkaline_earth_metal
                element.colorText = R.color.group_text_alkali_alkaline_earth_metal
                element.contentText = element.chemicalGroup
            }
            "Transition Metal" -> {
                element.colorBackground = R.color.group_background_transition_metal
                element.colorText = R.color.group_text_transition_metal
                element.contentText = element.chemicalGroup
            }
            "Lanthanide" -> {
                element.colorBackground = R.color.group_background_lanthanide
                element.colorText = R.color.group_text_lanthanide
                element.contentText = element.chemicalGroup
            }
            "Actinide" -> {
                element.colorBackground = R.color.group_background_actinide
                element.colorText = R.color.group_text_actinide
                element.contentText = element.chemicalGroup
            }
            "Metalloid" -> {
                element.colorBackground = R.color.group_background_metalloid
                element.colorText = R.color.group_text_metalloid
                element.contentText = element.chemicalGroup
            }
            "Halogen" -> {
                element.colorBackground = R.color.group_background_halogen
                element.colorText = R.color.group_text_halogen
                element.contentText = element.chemicalGroup
            }
            "Post-Transition Metal" -> {
                element.colorBackground = R.color.group_background_post_transition_metal
                element.colorText = R.color.group_text_post_transition_metal
                element.contentText = element.chemicalGroup
            }
            "Noble Gas" -> {
                element.colorBackground = R.color.group_background_noble_gas
                element.colorText = R.color.group_text_noble_gas
                element.contentText = element.chemicalGroup
            }
        }
    }

    fun displayByStandardStateStyle(element: Element) {
        when (element.standardStyle) {
            "Gas" -> {
                element.colorBackground = R.color.state_background_gas
                element.contentText = element.standardStyle
            }
            "Solid" -> {
                element.colorBackground = R.color.state_background_solid
                element.contentText = element.standardStyle
            }
            "Liquid" -> {
                element.colorBackground = R.color.state_background_liquid
                element.contentText = element.standardStyle
            }
        }

        element.colorText = R.color.default_element_text
    }

    fun displayByName(element: Element) {
        element.contentText = element.title
    }
}