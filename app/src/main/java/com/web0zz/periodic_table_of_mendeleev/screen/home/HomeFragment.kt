package com.web0zz.periodic_table_of_mendeleev.screen.home

import android.view.animation.AnimationUtils
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.periodic_table_of_mendeleev.R
import com.web0zz.periodic_table_of_mendeleev.adapter.RecyclerAdapter
import com.web0zz.periodic_table_of_mendeleev.base.BaseFragment
import com.web0zz.periodic_table_of_mendeleev.data.dummy.DummyData
import com.web0zz.periodic_table_of_mendeleev.data.model.Element
import com.web0zz.periodic_table_of_mendeleev.data.model.Item
import com.web0zz.periodic_table_of_mendeleev.databinding.FragmentHomeBinding
import com.web0zz.periodic_table_of_mendeleev.element.DisplayType
import com.web0zz.periodic_table_of_mendeleev.element.ElementControl
import com.web0zz.periodic_table_of_mendeleev.screen.detail.DetailDialog

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var elementControl: ElementControl

    override fun initUi() {
        val data = DummyData

        data.apply {
            initGroups(columnList)
            initPeriodicTable(listAdapter)
        }

        elementControl = object : ElementControl(recyclerAdapter) {}

        elementControl.displayElementsBySelectedProperties(DisplayType.CHEMICAL_GROUP)
    }

    private fun initGroups(data: List<Item>) {
        fragmentDataBinding.periodsRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            animation = AnimationUtils.loadAnimation(context, R.anim.recyclerview_anim)
            adapter = RecyclerAdapter(data) {}
                .apply { recyclerAdapter = this }
        }
    }

    private fun initPeriodicTable(data: List<Item>) {
        fragmentDataBinding.periodicTableRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 11, GridLayoutManager.HORIZONTAL, false)
            animation = AnimationUtils.loadAnimation(context, R.anim.recyclerview_anim)
            adapter = RecyclerAdapter(data) { element ->
                onClickElement(element)
            }.apply { recyclerAdapter = this }
        }
    }

    private fun onClickElement(element: Element) {
        val bundleData = bundleOf(Pair("elementSymbol", element.symbol))
        val detail = DetailDialog()

        detail.arguments = bundleData
        detail.show(childFragmentManager, "DetailFragment")
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}