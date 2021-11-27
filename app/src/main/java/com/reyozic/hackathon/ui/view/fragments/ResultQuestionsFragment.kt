package com.reyozic.hackathon.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reyozic.hackathon.databinding.ResultQuestionsFragmentBinding
import com.reyozic.hackathon.domain.model.QuestionModel
import com.reyozic.hackathon.domain.model.TypeQuestions
import com.reyozic.hackathon.ui.bases.HWTBaseFragment
import com.reyozic.hackathon.ui.view.bottomsheet.AnswerBottomSheet
import com.reyozic.hackathon.ui.view.viewhelpers.ResultQuestionsViewHelper

class ResultQuestionsFragment():HWTBaseFragment<ResultQuestionsFragmentBinding>(),ResultQuestionsViewHelper.Listener {

    private lateinit var mViewHelper: ResultQuestionsViewHelper
    private lateinit var questions:MutableList<QuestionModel>
    private lateinit var type:TypeQuestions

    private var answerBottomSheet = AnswerBottomSheet.newInstance()

    companion object{
        val TAG = ResultQuestionsFragment::class.java.simpleName
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
        mViewHelper.initRecycler(questions,type)
    }

    override fun backPressed() {
        activity?.onBackPressed()
    }

    override fun openAnswer(answer: String) {
        answerBottomSheet.loadData(answer,type)
        answerBottomSheet.show(requireFragmentManager(),TAG)
    }

    fun loadData(questions:MutableList<QuestionModel>,type:TypeQuestions){
        this.questions = questions
        this.type = type
    }
}