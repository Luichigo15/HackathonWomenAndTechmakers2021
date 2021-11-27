package com.reyozic.hackathon.ui.view

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.reyozic.hackathon.databinding.ActivityMainBinding
import com.reyozic.hackathon.domain.constant.HWTActualFragment
import com.reyozic.hackathon.domain.model.QuestionModel
import com.reyozic.hackathon.domain.model.TypeQuestions
import com.reyozic.hackathon.ui.controls.fragment.HWTFragmentContainerHelper
import com.reyozic.hackathon.ui.view.fragments.ResultQuestionsFragment
import com.reyozic.hackathon.ui.view.fragments.QuestionsFragment

class HWTMainActivity : AppCompatActivity(),QuestionsFragment.Listener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var fragmentContainer:HWTFragmentContainerHelper

    private var resultQuestionsFragment: ResultQuestionsFragment = ResultQuestionsFragment.newInstance()
    private var questionsFragment: QuestionsFragment = QuestionsFragment.newInstance()

    private var actualFragment = HWTActualFragment.QUESTIONS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initElements()
    }

    private fun getViewContainer(): View? = binding.content

    private fun initElements(){
        questionsFragment.setListener(this)
        fragmentContainer = HWTFragmentContainerHelper(this,getViewContainer())
        fragmentContainer.updateFragmentContainer(questionsFragment,true)
    }

    override fun showQuestions(questions: MutableList<QuestionModel>,type: TypeQuestions) {
        fragmentContainer.updateFragmentContainer(resultQuestionsFragment,false).also {
            resultQuestionsFragment.loadData(questions,type)
        }

    }
}