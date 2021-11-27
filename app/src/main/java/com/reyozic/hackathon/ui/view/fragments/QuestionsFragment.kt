package com.reyozic.hackathon.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reyozic.hackathon.databinding.LoginFragmentBinding
import com.reyozic.hackathon.databinding.QuestionsFragmentBinding
import com.reyozic.hackathon.ui.bases.HWTBaseFragment
import com.reyozic.hackathon.ui.view.viewhelpers.LoginViewHelper
import com.reyozic.hackathon.ui.view.viewhelpers.QuestionsViewHelper

class QuestionsFragment() : HWTBaseFragment<QuestionsFragmentBinding>(),QuestionsViewHelper.Listner {

    private lateinit var mViewHelper:QuestionsViewHelper
    private lateinit var mListener:Listener

    companion object{
        @JvmStatic
        fun newInstance():QuestionsFragment = QuestionsFragment()
    }

    override fun setupFragmentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = QuestionsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun getViewContainer(): View? {
        return binding.questionsContainer
    }

    override fun initElements() {
        mViewHelper = QuestionsViewHelper(binding,this)
    }

    fun setListener(listener:Listener){
        this.mListener = listener
    }



    interface Listener{

    }
}