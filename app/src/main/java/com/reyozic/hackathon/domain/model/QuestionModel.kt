package com.reyozic.hackathon.domain.model

data class QuestionModel(
    val question:String,
    val likes:Long,
    val answer:String
){
    override fun toString(): String {
        return "QuestionModel(question='$question', likes=$likes, answer='$answer')"
    }
}
