package com.reyozic.hackathon.ui.view.viewhelpers

import android.content.Context
import com.reyozic.hackathon.R
import com.reyozic.hackathon.databinding.AnswerFragmentBinding
import com.reyozic.hackathon.domain.model.TypeQuestions

class AnswerViewHelper(
    val binding: AnswerFragmentBinding,
    val context: Context,
    val mListener:Listener
) {

    private val icon = binding.ivAnswer
    private val answer = binding.tvAnswer
    private val btnClose = binding.ivCancel

    init {
        initElements()
    }

    private fun initElements() {
        btnClose.setOnClickListener {
            mListener.dismissBottom()
        }
    }

    fun loadData(answerR: String, type: TypeQuestions) {
        icon.setImageDrawable(
            context.getDrawable(
                when (type) {
                    TypeQuestions.AFTER -> R.drawable.ic_answer_after
                    TypeQuestions.BEFORE -> R.drawable.ic_answer_before
                    TypeQuestions.WHILE -> R.drawable.ic_answer_now
                    else->R.drawable.ic_answer_after
                }
            )
        )

        answer.text = answerR
    }

    interface Listener{
        fun dismissBottom()
    }
}