package com.reyozic.hackathon.ui.interfaces

import com.reyozic.hackathon.domain.model.QuestionModel
import com.reyozic.hackathon.domain.model.TypeQuestions

interface HWTInterfaces {

    interface  View{
            fun resultQuestions(questions:MutableList<QuestionModel>,type: TypeQuestions)
            fun errorService()
    }

    interface Presenter{
        fun getQuestions(url:String)
        fun resultQuestions(questions:MutableList<QuestionModel>,type: TypeQuestions)
        fun errorService()
    }

    interface Interactor{
        fun getQuestions(url:String)
    }
}