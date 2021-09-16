package com.web0zz.periodic_table_of_mendeleev.data.model

data class Number(
    val number: String,
    val isRow: Boolean?,
) : Item() {
    override fun getType() = Type.NUMBER.ordinal
}