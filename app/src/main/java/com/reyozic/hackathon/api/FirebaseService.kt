package com.reyozic.hackathon.api

import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessaging
import com.reyozic.hackathon.domain.model.PostModel
import com.reyozic.hackathon.domain.model.QuestionModel
import com.reyozic.hackathon.domain.userdata.HWTUser
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class FirebaseService {

    companion object {
        val instance = FirebaseService()
        private val reference = FirebaseDatabase.getInstance().reference
    }

    fun getQuestions(
        url: String,
        callback: (questions: MutableList<QuestionModel>) -> Unit,
        fail: () -> Unit
    ) {
        reference.child(url)
            .get().addOnCompleteListener { snapshot ->
                if (snapshot.isSuccessful) {
                    val questions = ArrayList<QuestionModel>()
                    questions.addAll(
                        snapshot.result!!.children!!.map {
                            val hashMap = it.value as HashMap<String, Any>
                            QuestionModel(
                                hashMap["question"] as String,
                                hashMap["likes"] as Long,
                                hashMap["answer"] as String
                            )
                        }
                    )
                    callback.invoke(questions)
                } else {
                    fail.invoke()
                }
            }
    }

    fun saveUser(
        user: HWTUser, callback: () -> Unit,
        fail: () -> Unit
    ) {
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    user.token = task.result!!
                    reference.child(HWTApiConstants.USERS).child(UUID.randomUUID().toString())
                        .setValue(user)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                callback.invoke()
                            } else {
                                fail.invoke()
                            }
                        }
                } else {
                    fail.invoke()
                }
            }
    }

    fun getPosts(
        callback: (posts: MutableList<PostModel>) -> Unit,
        fail: () -> Unit
    ) {
        reference.child(HWTApiConstants.POSTS)
            .get().addOnCompleteListener { snapshot ->
                if (snapshot.isSuccessful) {
                    val postsR = ArrayList<PostModel>()
                    postsR.addAll(
                        snapshot.result!!.children!!.map {
                            val hashMap = it.value as HashMap<String, Any>
                            PostModel(
                                hashMap["title"] as String,
                                hashMap["description"] as String,
                                hashMap["icon"] as String,
                                hashMap["date"] as String
                            )
                        }
                    )
                    callback.invoke(postsR)
                } else {
                    fail.invoke()
                }
            }
    }
}