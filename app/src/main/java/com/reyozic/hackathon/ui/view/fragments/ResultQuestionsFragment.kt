package com.reyozic.hackathon.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reyozic.hackathon.databinding.ResultQuestionsFragmentBinding
import com.reyozic.hackathon.ui.bases.HWTBaseFragment
import com.reyozic.hackathon.ui.view.viewhelpers.ResultQuestionsViewHelper

class ResultQuestionsFragment():HWTBaseFragment<ResultQuestionsFragmentBinding>(),ResultQuestionsViewHelper.Listener {

    private lateinit var mViewHelper: ResultQuestionsViewHelper
    private lateinit var mListener:Listener

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
        mViewHelper = ResultQuestionsViewHelper(binding,this)
    }

    fun setListener(listener: Listener){
        this.mListener = listener
    }

    override fun backPressed() {
        activity?.onBackPressed()
    }

    interface Listener{
    }
}