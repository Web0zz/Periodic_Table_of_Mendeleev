package com.web0zz.periodic_table_of_mendeleev.data.model

data class Element(
    val title: String,
    val longTitle: String,
    val number: String,
    val colorBackground: Int,
    val colorText: Int,
    var isVisible: Boolean? = true,
    val onClickElement: (Element) -> Unit,
) : Item() {
    override fun getType() = Type.ELEMENT.ordinal
    var position: Int = 0

    fun getPosition(p: Int) {
        position = p
    }

    fun onClick() {
        onClickElement(this)
    }
}
