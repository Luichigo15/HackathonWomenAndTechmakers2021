package com.reyozic.hackathon.ui.controls.fragment

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class HWTFragmentContainerHelper(val mActivity: AppCompatActivity, private val mFragmentContainer: View?) {

    fun updateFragmentContainer(
        fragment: Fragment,
        isReplacement: Boolean
    ) {
        updateContainer(
            fragment,
            isReplacement,
            FragmentTransaction.TRANSIT_FRAGMENT_FADE
        )
    }

    private fun updateContainer(
        fragment: Fragment,
        isReplacement: Boolean,
        fragmentTransaction: Int
    ) {
        if (mFragmentContainer != null) {
            val fragmentId = mFragmentContainer.id
            val fm = mActivity.supportFragmentManager
            val ft = fm.beginTransaction()
            if (isReplacement) {
                if (fm.backStackEntryCount > 0) {
                    cleanBackStack(fm)
                }
                ft.replace(fragmentId, fragment)
            } else {
                val fragToHide = fm.findFragmentById(fragmentId)
                if (fragToHide != null) {
                    ft.hide(fragToHide)
                    ft.setTransition(fragmentTransaction)
                }
                ft.addToBackStack(null)
                ft.add(fragmentId, fragment)
            }
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            ft.commit()
        }
    }

    private fun cleanBackStack(fm: FragmentManager) {
        val firstId = fm.getBackStackEntryAt(0).id
        fm.popBackStack(firstId, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    fun clearAll(fm: FragmentManager){
        for (i in 0 until fm.backStackEntryCount) {
            fm.popBackStack()
        }
    }
}