package com.reyozic.hackathon.ui.view.viewhelpers

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.reyozic.hackathon.R
import com.reyozic.hackathon.databinding.ResultQuestionsFragmentBinding
import com.reyozic.hackathon.domain.model.QuestionModel
import com.reyozic.hackathon.ui.view.recyclers.QuestionsAdapter

class ResultQuestionsViewHelper(
    mBinding: ResultQuestionsFragmentBinding,
    val mListener: Listener,
    val mContext:Context
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

        searchBar.dropDownVerticalOffset = 15

        searchBar.setDropDownBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    mContext,
                    R.color.white
                )
            )
        )

        searchBar.setDropDownBackgroundDrawable(
            AppCompatResources.getDrawable(
                mContext,
                R.drawable.shape_search_bar
            )
        )
    }

    fun initRecycler(questions:MutableList<QuestionModel>){
        adapterQuestions = QuestionsAdapter(questions,mContext)
        recyclerQuestions.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = adapterQuestions
        }

        val questionsAdapter = questions.map { it.question }
        searchBar.setAdapter(
            ArrayAdapter(
                mContext,
                R.layout.item_search_bar,
                questionsAdapter
            )
        )
    }

    interface Listener{
        fun backPressed()
    }
}