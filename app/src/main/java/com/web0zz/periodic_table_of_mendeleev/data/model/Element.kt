package com.web0zz.periodic_table_of_mendeleev.data.model

import com.web0zz.periodic_table_of_mendeleev.R

data class Element(
    val symbol: String,
    val title: String,
    val number: String,
    val atomicWeight: String,
    val electronConfig: String,
    val chemicalGroup: String? = "",
    val standardStyle: String? = "",
    val electronegativity: String? = "",
    val ionizationEnergy: String? = "",
    val electronAffinity: String? = "",
    val meltingPoint: String? = "",
    val boilingPoint: String? = "",
    val density: String? = "",
    val atomicRadius: String? = "",
    val yearDiscovered: String? = "",
    var position: Int = 0,
    var colorBackground: Int = R.color.light_background,
    var colorText: Int = R.color.white,
    var contentText: String = title,
) : Item() {
    override fun getType() = Type.ELEMENT.ordinal
}
