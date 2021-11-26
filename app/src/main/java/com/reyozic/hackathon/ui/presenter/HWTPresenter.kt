package com.reyozic.hackathon.ui.presenter

import android.content.Context
import com.reyozic.hackathon.api.HWTInteractor
import com.reyozic.hackathon.ui.interfaces.HWTInterfaces

class HWTPresenter(val context: Context, private val view: HWTInterfaces.View): HWTInterfaces.Presenter {

    val interactor: HWTInterfaces.Interactor = HWTInteractor(context, this)
}