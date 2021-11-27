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
import com.reyozic.hackathon.domain.model.TypeQuestions
import com.reyozic.hackathon.ui.view.recyclers.QuestionsAdapter
import com.reyozic.hackathon.ui.view.recyclers.QuestionsViewHolder

class ResultQuestionsViewHelper(
    mBinding: ResultQuestionsFragmentBinding,
    val mListener: Listener,
    val mContext:Context
):QuestionsViewHolder.Listener {

    private val btnBack = mBinding.btnBack
    private val searchBar = mBinding.searchBar
    private val recyclerQuestions = mBinding.recyclerQuestions
    private val title = mBinding.titleQuestions

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

    fun initRecycler(questions:MutableList<QuestionModel>,type:TypeQuestions){
        adapterQuestions = QuestionsAdapter(questions,mContext,this)
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

        when(type){
            TypeQuestions.AFTER->title.text = mContext.resources.getString(R.string.after_hass)
            TypeQuestions.BEFORE->title.text = mContext.resources.getString(R.string.before_hass)
            TypeQuestions.WHILE->title.text = mContext.resources.getString(R.string.while_hass)
        }
    }

    interface Listener{
        fun backPressed()
        fun openAnswer(answer: String)
    }

    override fun openAnswer(answer: String) {
        mListener.openAnswer(answer)
    }
}