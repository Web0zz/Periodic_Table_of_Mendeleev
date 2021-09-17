package com.web0zz.periodic_table_of_mendeleev.screen.home

import android.view.animation.AnimationUtils
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.web0zz.periodic_table_of_mendeleev.R
import com.web0zz.periodic_table_of_mendeleev.adapter.RecyclerAdapter
import com.web0zz.periodic_table_of_mendeleev.base.BaseFragment
import com.web0zz.periodic_table_of_mendeleev.data.dummy.DummyData
import com.web0zz.periodic_table_of_mendeleev.data.model.Element
import com.web0zz.periodic_table_of_mendeleev.databinding.FragmentHomeBinding
import com.web0zz.periodic_table_of_mendeleev.element.DisplayType
import com.web0zz.periodic_table_of_mendeleev.element.ElementControl
import com.web0zz.periodic_table_of_mendeleev.screen.detail.DetailDialog

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getLayoutId() = R.layout.fragment_home

    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var elementControl: ElementControl

    override fun initUi() {
        val data = DummyData

        fragmentDataBinding.periodicTableRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(10, StaggeredGridLayoutManager.HORIZONTAL)
            animation = AnimationUtils.loadAnimation(context, R.anim.recyclerview_anim)
            adapter = RecyclerAdapter(data.listAdapter) { element ->
                onClickElement(element)
            }.apply { recyclerAdapter = this }
            setHasFixedSize(true)
        }

        elementControl = object : ElementControl(recyclerAdapter) {}

        elementControl.displayElementsBySelectedProperties(DisplayType.CHEMICAL_GROUP)
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