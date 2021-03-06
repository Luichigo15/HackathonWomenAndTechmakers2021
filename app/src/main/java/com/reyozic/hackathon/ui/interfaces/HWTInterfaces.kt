package com.reyozic.hackathon.ui.interfaces

import com.reyozic.hackathon.domain.model.PostModel
import com.reyozic.hackathon.domain.model.QuestionModel
import com.reyozic.hackathon.domain.model.TypeQuestions
import com.reyozic.hackathon.domain.userdata.HWTUser

interface HWTInterfaces {

    interface View{
        fun resultQuestions(questions:MutableList<QuestionModel>,type: TypeQuestions){}
        fun errorService(){}
        fun resultUser(){}
        fun resultPosts(posts: MutableList<PostModel>){}
    }

    interface Presenter{
        fun getQuestions(url:String)
        fun resultQuestions(questions:MutableList<QuestionModel>,type: TypeQuestions)
        fun errorService()
        fun saveUser(user:HWTUser)
        fun resultUser()
        fun getPosts()
        fun resultPosts(posts: MutableList<PostModel>)
    }

    interface Interactor{
        fun getQuestions(url:String)
        fun saveUser(user:HWTUser)
        fun getPosts()
    }
}