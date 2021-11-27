package com.reyozic.hackathon.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.reyozic.hackathon.R
import com.reyozic.hackathon.databinding.QuestionsFragmentBinding
import com.reyozic.hackathon.domain.model.QuestionModel
import com.reyozic.hackathon.domain.model.TypeQuestions
import com.reyozic.hackathon.ui.bases.HWTBaseFragment
import com.reyozic.hackathon.ui.controls.loader.HWTAnimatedLoader
import com.reyozic.hackathon.ui.interfaces.HWTInterfaces
import com.reyozic.hackathon.ui.presenter.HWTPresenter
import com.reyozic.hackathon.ui.view.viewhelpers.QuestionsViewHelper

class QuestionsFragment() : HWTBaseFragment<QuestionsFragmentBinding>(),QuestionsViewHelper.Listener,
    HWTInterfaces.View {

    private lateinit var mViewHelper:QuestionsViewHelper
    private lateinit var mListener:Listener

    private lateinit var mPresenter:HWTPresenter

    private lateinit var loader:HWTAnimatedLoader

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
        mPresenter = HWTPresenter(requireContext(),this)
        mViewHelper = QuestionsViewHelper(binding,this)
        loader = HWTAnimatedLoader(requireContext())
    }

    fun setListener(listener:Listener){
        this.mListener = listener
    }

    override fun getQuestions(url: String,) {
        loader.show()
        mPresenter.getQuestions(url)
    }

    override fun resultQuestions(questions: MutableList<QuestionModel>,type: TypeQuestions) {
        loader.dismiss()
        if(questions.size==0){
            errorService()
        }else{
            mListener.showQuestions(questions,type)
        }
    }

    override fun errorService() {
        loader.dismiss()
        Toast.makeText(context,requireContext().resources.getString(R.string.error_loading),Toast.LENGTH_SHORT).show()
    }

    interface Listener{
        fun showQuestions(questions: MutableList<QuestionModel>,type: TypeQuestions)
    }
}