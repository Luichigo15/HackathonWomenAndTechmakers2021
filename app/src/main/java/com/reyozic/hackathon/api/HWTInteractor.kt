package com.reyozic.hackathon.api

import android.content.Context
import com.reyozic.hackathon.domain.userdata.HWTUserControl
import com.reyozic.hackathon.ui.interfaces.HWTInterfaces

class HWTInteractor(private val context: Context, private val mcallback: HWTInterfaces.Presenter): HWTInterfaces.Interactor {

    private val currentUser = HWTUserControl.getCurrentUser(context)
}