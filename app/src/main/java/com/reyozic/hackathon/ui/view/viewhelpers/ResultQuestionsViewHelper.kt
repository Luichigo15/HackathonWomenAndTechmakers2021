package com.reyozic.hackathon.ui.view.viewhelpers

import android.util.Log
import com.reyozic.hackathon.databinding.ResultQuestionsFragmentBinding

class ResultQuestionsViewHelper(
    mBinding: ResultQuestionsFragmentBinding,
    val mListener: Listener
) {

    private val btnBack = mBinding.btnBack
    private val searchBar = mBinding.searchBar
    private val recyclerQuestions = mBinding.recyclerQuestions

    init{
        initElements()
    }

    private fun initElements(){
        btnBack.setOnClickListener{mListener.backPressed()}
    }

    interface Listener{
        fun backPressed()
    }
}