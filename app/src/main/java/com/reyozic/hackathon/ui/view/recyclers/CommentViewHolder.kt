package com.reyozic.hackathon.ui.view.recyclers

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.reyozic.hackathon.R
import com.reyozic.hackathon.databinding.ItemCommentBinding
import com.reyozic.hackathon.domain.model.CommentModel

class CommentViewHolder (item: View) : RecyclerView.ViewHolder(item){

    var binding = ItemCommentBinding.bind(item)
    lateinit var context:Context

    fun bindData(comment:CommentModel){
        binding.comment.text = comment.comment
        binding.date.text = comment.date

        val number = (1..5).random()
        binding.avatar.setImageDrawable(
            context.getDrawable(
                when(number){
                    1-> R.drawable.avatar1
                    2-> R.drawable.avatar2
                    3-> R.drawable.avatar3
                    4-> R.drawable.avatar4
                    else-> R.drawable.avatar5
                }
            )
        )
    }
}