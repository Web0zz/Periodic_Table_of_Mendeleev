package com.web0zz.periodic_table_of_mendeleev


import com.web0zz.periodic_table_of_mendeleev.base.BaseActivity
import com.web0zz.periodic_table_of_mendeleev.databinding.ActivityMainBinding
import com.web0zz.periodic_table_of_mendeleev.screen.home.HomeFragment
import com.web0zz.periodic_table_of_mendeleev.screen.splash.SplashFragment
import com.web0zz.periodic_table_of_mendeleev.util.TransactionUtil.makeTransaction

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun initUi() {
        makeTransaction {
            this.add(
                activityBinding.mainFrameLayout.id,
                SplashFragment.newInstance()
            )
        }
    }

    fun initHome() {
        makeTransaction {
            this.add(
                activityBinding.mainFrameLayout.id,
                HomeFragment.newInstance()
            )
        }
    }
}