package com.web0zz.periodic_table_of_mendeleev.screen.splash

import android.os.CountDownTimer
import com.web0zz.periodic_table_of_mendeleev.MainActivity
import com.web0zz.periodic_table_of_mendeleev.R
import com.web0zz.periodic_table_of_mendeleev.base.BaseFragment
import com.web0zz.periodic_table_of_mendeleev.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override fun getLayoutId() = R.layout.fragment_splash

    override fun initUi() {
        val mainActivity = (requireActivity() as MainActivity)

        object : CountDownTimer(3150, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                mainActivity.initHome()
            }
        }.start()
    }

    companion object {
        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }
}