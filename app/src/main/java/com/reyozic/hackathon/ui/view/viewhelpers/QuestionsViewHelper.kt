package com.reyozic.hackathon.ui.view.viewhelpers

import com.reyozic.hackathon.api.HWTApiConstants
import com.reyozic.hackathon.databinding.QuestionsFragmentBinding

class QuestionsViewHelper(
    mBinding: QuestionsFragmentBinding,
    val mListener:Listener
) {

    private val cvBefore = mBinding.cBefore
    private val cvWhile = mBinding.cNow
    private val cvAfter = mBinding.cAfter

    init{
        initElements()
    }

    private fun initElements(){
        cvBefore.setOnClickListener { mListener.getQuestions(HWTApiConstants.QUESTIONS_BEFORE) }
        cvAfter.setOnClickListener { mListener.getQuestions(HWTApiConstants.QUESTIONS_AFTER) }
        cvWhile.setOnClickListener { mListener.getQuestions(HWTApiConstants.QUESTIONS_WHILE) }
    }

    interface Listener{
        fun getQuestions(url:String)
    }
}