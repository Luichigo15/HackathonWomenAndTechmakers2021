package com.reyozic.hackathon.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reyozic.hackathon.databinding.AnswerFragmentBinding
import com.reyozic.hackathon.domain.model.TypeQuestions
import com.reyozic.hackathon.ui.bases.HWTBaseBottomSheet
import com.reyozic.hackathon.ui.view.viewhelpers.AnswerViewHelper

class AnswerBottomSheet() : HWTBaseBottomSheet<AnswerFragmentBinding>(){

    private lateinit var mViewHelper: AnswerViewHelper

    private lateinit var type:TypeQuestions
    private lateinit var answer:String

    companion object{
        @JvmStatic
        fun newInstance():AnswerBottomSheet = AnswerBottomSheet()
    }

    override fun setupBottomSheetView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AnswerFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun initElements() {
        mViewHelper = AnswerViewHelper(binding,mContext)
        mViewHelper.loadData(answer,type)
    }

    fun loadData(answerR:String,type:TypeQuestions){
        this.answer = answerR
        this.type = type
    }
}