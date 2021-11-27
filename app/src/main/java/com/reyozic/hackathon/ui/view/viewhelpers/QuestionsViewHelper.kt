package com.reyozic.hackathon.ui.view.viewhelpers

import com.reyozic.hackathon.databinding.LoginFragmentBinding
import com.reyozic.hackathon.databinding.QuestionsFragmentBinding

class QuestionsViewHelper(
    mBinding: QuestionsFragmentBinding,
    val mListener:Listner
) {

    private val cvBefore = mBinding.cBefore
    private val cvNow = mBinding.cNow
    private val cvAfter = mBinding.cAfter

    init{
        initElements()
    }

    private fun initElements(){

    }

    interface Listner{

    }
}