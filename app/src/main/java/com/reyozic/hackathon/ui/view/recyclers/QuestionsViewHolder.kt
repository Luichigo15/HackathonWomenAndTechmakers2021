package com.reyozic.hackathon.ui.view.recyclers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.reyozic.hackathon.databinding.ItemQuestionBinding
import com.reyozic.hackathon.domain.model.QuestionModel

class QuestionsViewHolder(item:View) : RecyclerView.ViewHolder(item){

    var binding = ItemQuestionBinding.bind(item)

    fun bindData(question:QuestionModel){
        binding.count.text = question.likes.toString()
        binding.question.text = question.question
    }
}