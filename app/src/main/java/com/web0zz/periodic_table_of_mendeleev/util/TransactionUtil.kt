package com.web0zz.periodic_table_of_mendeleev.util

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction

object TransactionUtil {
    fun FragmentActivity.makeTransaction(
        action: FragmentTransaction.() -> Unit,
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.action()
        transaction.commit()
    }
}