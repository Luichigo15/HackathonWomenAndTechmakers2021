package com.reyozic.hackathon.domain.model

import android.content.Context
import android.graphics.drawable.Drawable
import com.reyozic.hackathon.R

data class PostModel(
    val title:String,
    val description:String,
    val icon:String,
    val date:String,
    val comments:MutableList<CommentModel> = ArrayList(),
){
    fun getIcon(context:Context):Drawable{
        return context.getDrawable(
            when(icon){
                "equality"-> R.drawable.ic_equality
                "unite"-> R.drawable.ic_unite
                "violence"-> R.drawable.ic_violence
                "womens"-> R.drawable.ic_womens
                else -> R.drawable.ic_equality
            }
        )!!
    }

    override fun toString(): String {
        return "PostModel(title='$title', description='$description', icon='$icon', date='$date', comments=$comments)"
    }


}
