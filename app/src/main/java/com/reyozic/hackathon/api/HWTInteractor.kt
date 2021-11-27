package com.reyozic.hackathon.api

import android.content.Context
import com.reyozic.hackathon.domain.userdata.HWTUserControl
import com.reyozic.hackathon.ui.interfaces.HWTInterfaces

class HWTInteractor(private val context: Context, private val mCallback: HWTInterfaces.Presenter): HWTInterfaces.Interactor {

    private val currentUser = HWTUserControl.getCurrentUser(context)
    private val firabaseService = FirebaseService()

    override fun getQuestions(url: String) {
        firabaseService.getQuestions(url,{
            mCallback.resultQuestions(it)
        },{
            mCallback.errorService()
        })
    }
}