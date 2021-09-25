package com.web0zz.periodic_table_of_mendeleev.screen.splash

import android.os.CountDownTimer
import com.web0zz.periodic_table_of_mendeleev.MainActivity
import com.web0zz.periodic_table_of_mendeleev.base.BaseFragment
import com.web0zz.periodic_table_of_mendeleev.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun resumeUi() = (requireActivity() as MainActivity).supportActionBar!!.hide()

    override fun stopUi() = (requireActivity() as MainActivity).supportActionBar!!.show()

    override fun initUi() {
        object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                (requireActivity() as MainActivity).initHome()
            }
        }.start()
    }

    companion object {
        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }
}