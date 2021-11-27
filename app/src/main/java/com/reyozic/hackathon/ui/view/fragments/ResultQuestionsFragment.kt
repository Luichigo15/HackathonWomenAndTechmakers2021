package com.reyozic.hackathon.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reyozic.hackathon.databinding.ResultQuestionsFragmentBinding
import com.reyozic.hackathon.domain.model.QuestionModel
import com.reyozic.hackathon.ui.bases.HWTBaseFragment
import com.reyozic.hackathon.ui.view.viewhelpers.ResultQuestionsViewHelper

class ResultQuestionsFragment():HWTBaseFragment<ResultQuestionsFragmentBinding>(),ResultQuestionsViewHelper.Listener {

    private lateinit var mViewHelper: ResultQuestionsViewHelper
    private lateinit var questions:MutableList<QuestionModel>

    companion object{
        @JvmStatic
        fun newInstance():ResultQuestionsFragment = ResultQuestionsFragment()
    }

    override fun setupFragmentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ResultQuestionsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun getViewContainer(): View? {
        return binding.resultQuestionsContainer
    }

    override fun initElements() {
        mViewHelper = ResultQuestionsViewHelper(binding,this,mContext)
        mViewHelper.initRecycler(questions)
    }

    override fun backPressed() {
        activity?.onBackPressed()
    }

    fun loadData(questions:MutableList<QuestionModel>){
        this.questions = questions
    }
}