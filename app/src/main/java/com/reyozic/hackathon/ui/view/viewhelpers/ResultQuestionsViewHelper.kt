package com.reyozic.hackathon.ui.view.viewhelpers

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.reyozic.hackathon.databinding.ResultQuestionsFragmentBinding
import com.reyozic.hackathon.domain.model.QuestionModel
import com.reyozic.hackathon.ui.view.recyclers.QuestionsAdapter

class ResultQuestionsViewHelper(
    mBinding: ResultQuestionsFragmentBinding,
    val mListener: Listener
) {

    private val btnBack = mBinding.btnBack
    private val searchBar = mBinding.searchBar
    private val recyclerQuestions = mBinding.recyclerQuestions

    private lateinit var adapterQuestions:QuestionsAdapter

    init{
        initElements()
    }

    private fun initElements(){
        btnBack.setOnClickListener{mListener.backPressed()}
    }

    private fun initRecycler(questions:MutableList<QuestionModel>){
        adapterQuestions = QuestionsAdapter(questions)
        recyclerQuestions.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = adapterQuestions
        }
    }

    interface Listener{
        fun backPressed()
    }
}