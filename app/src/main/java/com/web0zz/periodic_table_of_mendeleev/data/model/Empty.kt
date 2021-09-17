package com.web0zz.periodic_table_of_mendeleev.data.model

object Empty : Item() {
    override fun getType() = Type.EMPTY.ordinal
}
