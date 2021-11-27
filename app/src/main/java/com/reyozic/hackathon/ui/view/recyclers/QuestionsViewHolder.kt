package com.reyozic.hackathon.ui.view.recyclers

import android.content.Context
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.reyozic.hackathon.R
import com.reyozic.hackathon.databinding.ItemQuestionBinding
import com.reyozic.hackathon.domain.model.QuestionModel

class QuestionsViewHolder(item: View) : RecyclerView.ViewHolder(item) {

    var binding = ItemQuestionBinding.bind(item)
    lateinit var mContext: Context

    fun bindData(question: QuestionModel) {
        binding.count.text = question.likes.toString()
        binding.question.text = question.question

        binding.like.setOnClickListener {
            if (binding.like.tag.equals("nolike")) {
                binding.like.tag = "like"
                binding.like.setImageDrawable(mContext.getDrawable(R.drawable.ic_favorite_red))
            } else {
                binding.like.tag = "nolike"
                binding.like.setImageDrawable(mContext.getDrawable(R.drawable.ic_favorite))
            }
        }
    }
}
