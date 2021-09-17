package com.web0zz.periodic_table_of_mendeleev.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.web0zz.periodic_table_of_mendeleev.databinding.FragmentPopupDetailBinding

abstract class BaseCustomDialog<B : ViewDataBinding> : DialogFragment() {
    abstract fun getLayoutId(): Int

    private var _dialogDataBinding: FragmentPopupDetailBinding? = null
    protected val dialogDataBinding get() = _dialogDataBinding!!

    open fun Bundle.getArgumentsToVariable() {}

    open fun initUi() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getArgumentsToVariable()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // View is created using layout Id
        _dialogDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return dialogDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _dialogDataBinding = null
    }
}