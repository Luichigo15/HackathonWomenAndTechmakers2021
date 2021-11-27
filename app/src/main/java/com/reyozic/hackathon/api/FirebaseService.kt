package com.reyozic.hackathon.api

import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.reyozic.hackathon.domain.model.QuestionModel

class FirebaseService {

    fun getQuestions(url:String,callback:(questions:MutableList<QuestionModel>)->Unit,fail:()->Unit){
        FirebaseDatabase.getInstance().reference.child(url)
            .get().addOnCompleteListener {
                snapshot->
                if(snapshot.isSuccessful){
                    val questions = ArrayList<QuestionModel>()
                    questions.addAll(
                        snapshot.result!!.children!!.map {
                            val hashMap = it.value as HashMap<String,Any>
                            QuestionModel(
                                hashMap["question"] as String,
                                hashMap["likes"] as Long,
                                hashMap["answer"] as String
                            )
                        }
                    )
                    callback.invoke(questions)
                }else{
                    fail.invoke()
                }
            }
    }
}