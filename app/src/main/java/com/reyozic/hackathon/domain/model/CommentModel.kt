package com.reyozic.hackathon.domain.model

data class CommentModel(
    val comment:String,
    val date:String
){
    override fun toString(): String {
        return "CommentModel(comment='$comment', date='$date')"
    }
}
