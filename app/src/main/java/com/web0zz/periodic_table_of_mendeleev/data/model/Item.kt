package com.web0zz.periodic_table_of_mendeleev.data.model

sealed class Item {
    abstract fun getType(): Int

    enum class Type {
        NUMBER,
        ELEMENT,
        EMPTY
    }
}
