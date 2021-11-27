package com.reyozic.hackathon.api

import android.os.Handler
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessaging
import com.reyozic.hackathon.domain.model.CommentModel
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
        Handler().postDelayed(
            Runnable() {
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
                                        hashMap["answer"] as String,
                                    )
                                }
                            )
                            callback.invoke(questions)
                        } else {
                            fail.invoke()
                        }
                    }
            }, 1000
        )
    }

    fun saveUser(
        user: HWTUser, callback: () -> Unit,
        fail: () -> Unit
    ) {
        Handler().postDelayed(
            Runnable() {
                FirebaseMessaging.getInstance().token
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            user.token = task.result!!
                            reference.child(HWTApiConstants.USERS)
                                .child(UUID.randomUUID().toString())
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
            }, 1000
        )
    }

    fun getPosts(
        callback: (posts: MutableList<PostModel>) -> Unit,
        fail: () -> Unit
    ) {
        Handler().postDelayed(
            Runnable() {
                reference.child(HWTApiConstants.POSTS)
                    .get().addOnCompleteListener { snapshot ->
                        if (snapshot.isSuccessful) {
                            val postsR = ArrayList<PostModel>()
                            postsR.addAll(
                                snapshot.result!!.children!!.map {
                                    val hashMap = it.value as HashMap<String, Any>

                                    val comments =
                                        if (hashMap["comments"] != null) hashMap["comments"] as ArrayList<Any> else ArrayList()
                                    val listComments = comments.filterNotNull().map { comment ->
                                        val hashMapCom = comment as HashMap<String, Any>
                                        CommentModel(
                                            hashMapCom["comment"] as String,
                                            hashMapCom["date"] as String,
                                        )
                                    }

                                    PostModel(
                                        hashMap["title"] as String,
                                        hashMap["description"] as String,
                                        hashMap["icon"] as String,
                                        hashMap["date"] as String,
                                        listComments as MutableList<CommentModel>
                                    )
                                }
                            )

                            callback.invoke(postsR)
                        } else {
                            fail.invoke()
                        }
                    }
            }, 1000
        )
    }
}