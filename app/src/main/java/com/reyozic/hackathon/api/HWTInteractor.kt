package com.reyozic.hackathon.api

import android.content.Context
import com.reyozic.hackathon.domain.model.TypeQuestions
import com.reyozic.hackathon.domain.userdata.HWTUser
import com.reyozic.hackathon.domain.userdata.HWTUserControl
import com.reyozic.hackathon.ui.interfaces.HWTInterfaces

class HWTInteractor(private val context: Context, private val mCallback: HWTInterfaces.Presenter):
    HWTInterfaces.Interactor{

    private lateinit var currentUser:HWTUserControl
    private val firabaseService = FirebaseService()

    override fun getQuestions(url: String) {
        firabaseService.getQuestions(url,{
            mCallback.resultQuestions(
                it,
                when(url){
                    HWTApiConstants.QUESTIONS_AFTER->TypeQuestions.AFTER
                    HWTApiConstants.QUESTIONS_BEFORE->TypeQuestions.BEFORE
                    HWTApiConstants.QUESTIONS_WHILE->TypeQuestions.WHILE
                    else -> TypeQuestions.AFTER
                }
            )
        },{
            mCallback.errorService()
        })
    }

    override fun saveUser(user: HWTUser) {
        firabaseService.saveUser(
            user,{
                mCallback.resultUser()
            },
            {
                mCallback.errorService()
            }
        )
    }

    override fun getPosts() {
        firabaseService.getPosts({
            mCallback.resultPosts(it)
        },{
            mCallback.errorService()
        })
    }
}