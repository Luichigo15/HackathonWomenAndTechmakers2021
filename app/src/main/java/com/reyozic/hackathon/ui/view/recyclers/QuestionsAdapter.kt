package com.reyozic.hackathon.ui.view.recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reyozic.hackathon.R
import com.reyozic.hackathon.domain.model.QuestionModel

class QuestionsAdapter(val questions:MutableList<QuestionModel>) :RecyclerView.Adapter<QuestionsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question,parent,false)
        return QuestionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        val question = questions[position]
        holder.bindData(question)
    }

    override fun getItemCount(): Int {
        return questions.size
    }
}