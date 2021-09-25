package com.web0zz.periodic_table_of_mendeleev.data.model

data class IndexNumber(
    val indexNo: String,
    val isRow: Boolean?,
) : Item() {
    override fun getType() = Type.INDEX_NUMBER.ordinal
}