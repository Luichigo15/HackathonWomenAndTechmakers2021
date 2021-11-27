package com.reyozic.hackathon.ui.interfaces

import com.reyozic.hackathon.domain.model.QuestionModel

interface HWTInterfaces {

    interface  View{
            fun resultQuestions(questions:MutableList<QuestionModel>)
            fun errorService()
    }

    interface Presenter{
        fun getQuestions(url:String)
        fun resultQuestions(questions:MutableList<QuestionModel>)
        fun errorService()
    }

    interface Interactor{
        fun getQuestions(url:String)
    }
}