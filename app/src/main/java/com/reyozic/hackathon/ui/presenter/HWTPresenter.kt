package com.reyozic.hackathon.ui.presenter

import android.content.Context
import com.reyozic.hackathon.api.HWTInteractor
import com.reyozic.hackathon.domain.model.QuestionModel
import com.reyozic.hackathon.ui.interfaces.HWTInterfaces

class HWTPresenter(val context: Context, private val view: HWTInterfaces.View): HWTInterfaces.Presenter {

    val interactor: HWTInterfaces.Interactor = HWTInteractor(context, this)

    override fun getQuestions(url: String) {
        interactor.getQuestions(url)
    }

    override fun resultQuestions(questions: MutableList<QuestionModel>) {
        view.resultQuestions(questions)
    }

    override fun errorService() {
        view.errorService()
    }
}