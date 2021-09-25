package com.web0zz.periodic_table_of_mendeleev


import android.view.Menu
import android.view.MenuItem
import com.web0zz.periodic_table_of_mendeleev.base.BaseActivity
import com.web0zz.periodic_table_of_mendeleev.databinding.ActivityMainBinding
import com.web0zz.periodic_table_of_mendeleev.element.DisplayType
import com.web0zz.periodic_table_of_mendeleev.screen.home.HomeFragment
import com.web0zz.periodic_table_of_mendeleev.screen.splash.SplashFragment
import com.web0zz.periodic_table_of_mendeleev.util.TransactionUtil.makeTransaction

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    private lateinit var homeFragment: HomeFragment

    override fun initUi() {
        setSupportActionBar(activityBinding.myToolbar)

        initSplash()
    }

    private fun initSplash() {
        makeTransaction {
            this.replace(
                activityBinding.mainFrameLayout.id,
                SplashFragment.newInstance()
            )
        }
    }

    fun initHome() {
        makeTransaction {
            this.replace(
                activityBinding.mainFrameLayout.id,
                HomeFragment.newInstance().also { homeFragment = it }
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.show_by_name -> {
            homeFragment.elementControl.displayElementsBySelectedProperties(DisplayType.NAME)
            true
        }

        R.id.show_by_chemical -> {
            homeFragment.elementControl.displayElementsBySelectedProperties(DisplayType.CHEMICAL_GROUP)
            true
        }

        R.id.show_by_standard -> {
            homeFragment.elementControl.displayElementsBySelectedProperties(DisplayType.STANDARD_STATE)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}