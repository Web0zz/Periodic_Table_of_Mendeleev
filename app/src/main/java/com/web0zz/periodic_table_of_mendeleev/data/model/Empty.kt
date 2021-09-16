package com.web0zz.periodic_table_of_mendeleev.data.model

data class Empty(
    val sizeColumn: Int,
) : Item() {
    override fun getType() = Type.EMPTY.ordinal
}
