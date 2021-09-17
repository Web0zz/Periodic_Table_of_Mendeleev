package com.web0zz.periodic_table_of_mendeleev.screen.detail

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.web0zz.periodic_table_of_mendeleev.R
import com.web0zz.periodic_table_of_mendeleev.base.BaseCustomDialog
import com.web0zz.periodic_table_of_mendeleev.data.dummy.DummyData
import com.web0zz.periodic_table_of_mendeleev.data.model.Element
import com.web0zz.periodic_table_of_mendeleev.data.model.Item
import com.web0zz.periodic_table_of_mendeleev.databinding.FragmentPopupDetailBinding
import kotlin.properties.Delegates


class DetailDialog : BaseCustomDialog<FragmentPopupDetailBinding>() {
    override fun getLayoutId() = R.layout.fragment_popup_detail

    private var selectedElementSymbol by Delegates.notNull<String>()
    private lateinit var selectedElement: Element

    override fun Bundle.getArgumentsToVariable() {
        selectedElementSymbol = this.getString(ELEMENT_SYMBOL)!!

        getElement()
    }

    override fun initUi() {
        dialogDataBinding.element = selectedElement
        dialogDataBinding.myInterface = this
    }

    fun expandDetail() {
        when (dialogDataBinding.closeMoreDetailImageButton.isVisible) {
            true -> {
                dialogDataBinding.closeMoreDetailImageButton.visibility = View.GONE
                dialogDataBinding.moreDetailImageButton.visibility = View.VISIBLE
                dialogDataBinding.expandedDetail.visibility = View.GONE
            }
            false -> {
                dialogDataBinding.closeMoreDetailImageButton.visibility = View.VISIBLE
                dialogDataBinding.moreDetailImageButton.visibility = View.GONE
                dialogDataBinding.expandedDetail.visibility = View.VISIBLE
            }
        }
    }

    private fun getElement() {
        selectedElement = DummyData.listAdapter.filter { it.getType() == Item.Type.ELEMENT.ordinal }
            .find { (it as Element).symbol == selectedElementSymbol } as Element
    }

    companion object {
        private const val ELEMENT_SYMBOL = "elementSymbol"
    }
}