package com.web0zz.periodic_table_of_mendeleev.data.model

import com.web0zz.periodic_table_of_mendeleev.R
import kotlin.random.Random

data class Element(
    val symbol: String,
    val title: String,
    val number: String,
    val atomicWeight: String,
    val electronConfig: String,
    val chemicalGroup: String,
    val standardStyle: String,
    val electronegativity: String,
    val ionizationEnergy: String,
    val electronAffinity: String,
    val meltingPoint: String,
    val boilingPoint: String,
    val density: String,
    val atomicRadius: String,
    var position: Int = 0,
    var colorBackground: Int = R.color.light_background,
    var colorText: Int = R.color.white,
    var contentText: String = title,
) : Item() {
    override fun getType() = Type.ELEMENT.ordinal

    val sampleImage: Int = listOf(
        R.drawable.sample_1,
        R.drawable.sample_2,
        R.drawable.sample_3,
        R.drawable.sample_4,
        R.drawable.sample_5,
        R.drawable.sample_6,
        R.drawable.sample_7,
        R.drawable.sample_8,
        R.drawable.sample_9,
        R.drawable.sample_10,
    )[Random.nextInt(10)]
}
