package com.web0zz.periodic_table_of_mendeleev.screen.home

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.web0zz.periodic_table_of_mendeleev.screen.detail.DetailDialog
import com.web0zz.periodic_table_of_mendeleev.R
import com.web0zz.periodic_table_of_mendeleev.screen.home.adapter.RecyclerAdapter
import com.web0zz.periodic_table_of_mendeleev.base.BaseFragment
import com.web0zz.periodic_table_of_mendeleev.data.dummy.DummyData
import com.web0zz.periodic_table_of_mendeleev.data.model.Element
import com.web0zz.periodic_table_of_mendeleev.data.model.Item
import com.web0zz.periodic_table_of_mendeleev.databinding.LayoutHomeBinding

class HomeFragment : BaseFragment<LayoutHomeBinding>() {
    override fun getLayoutId() = R.layout.layout_home

    lateinit var recyclerAdapter: RecyclerAdapter

    private val filterHistory = mutableListOf<String>()

    override fun initUi() {
        val data = DummyData
        data.onClickDetail = { onClickDetail(it) }

        fragmentDataBinding.rowNumberRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            animation = AnimationUtils.loadAnimation(context, R.anim.row_anim)
            adapter = RecyclerAdapter(data.rowNumber)
        }

        fragmentDataBinding.periodicTableRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(10, StaggeredGridLayoutManager.HORIZONTAL)
            animation = AnimationUtils.loadAnimation(context, R.anim.recyclerview_anim)
            adapter = RecyclerAdapter(data.listAdapter).apply { recyclerAdapter = this }
            setHasFixedSize(true)
        }
    }

    private fun filterElement(filterTitle: String) {
        recyclerAdapter.items.filter { it.getType() == Item.Type.ELEMENT.ordinal }
            .filter { (it as Element).title == filterTitle }
            .forEach {
                (it as Element).isVisible = false
                recyclerAdapter.notifyItemChanged(it.position)

                filterHistory.add(filterTitle)
            }
    }

    private fun clearFilter() {
        filterHistory.forEach { itemName ->
            recyclerAdapter.items.filter { it.getType() == Item.Type.ELEMENT.ordinal }
                .filter { (it as Element).title == itemName }
                .forEach {
                    (it as Element).isVisible = true
                    recyclerAdapter.notifyItemChanged(it.position)
                }
        }

        filterHistory.clear()
    }

    private fun onClickDetail(element: Element) {
        DetailDialog().show(childFragmentManager, "DetailFragment")
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}