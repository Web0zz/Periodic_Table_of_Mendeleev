package com.web0zz.periodic_table_of_mendeleev.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding>(
    private val inflateLayout: (LayoutInflater, ViewGroup?, Boolean) -> B
) : Fragment() {
    fun getDataBinding() = fragmentDataBinding

    private var _fragmentDataBinding: B? = null
    protected val fragmentDataBinding get() = _fragmentDataBinding!!

    open fun initUi() {}
    open fun resumeUi() {}
    open fun stopUi() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // View is created using layout Id
        _fragmentDataBinding = inflateLayout(layoutInflater, container, false)
        return fragmentDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    override fun onResume() {
        super.onResume()
        resumeUi()
    }

    override fun onStop() {
        super.onStop()
        stopUi()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentDataBinding = null
    }
}
