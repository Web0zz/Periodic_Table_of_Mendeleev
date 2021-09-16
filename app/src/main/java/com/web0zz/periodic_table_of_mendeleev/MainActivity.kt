package com.web0zz.periodic_table_of_mendeleev


import com.web0zz.periodic_table_of_mendeleev.base.BaseActivity
import com.web0zz.periodic_table_of_mendeleev.databinding.ActivityMainBinding
import com.web0zz.periodic_table_of_mendeleev.screen.home.HomeFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun initUi() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(
            activityBinding.mainFrameLayout.id,
            HomeFragment.newInstance()
        )
        transaction.commit()
    }
}