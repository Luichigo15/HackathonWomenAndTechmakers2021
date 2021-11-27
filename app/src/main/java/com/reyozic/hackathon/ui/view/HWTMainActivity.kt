package com.reyozic.hackathon.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.reyozic.hackathon.R
import com.reyozic.hackathon.databinding.ActivityMainBinding
import com.reyozic.hackathon.domain.constant.HWTActualFragment
import com.reyozic.hackathon.domain.model.PostModel
import com.reyozic.hackathon.domain.model.QuestionModel
import com.reyozic.hackathon.domain.model.TypeQuestions
import com.reyozic.hackathon.ui.controls.fragment.HWTFragmentContainerHelper
import com.reyozic.hackathon.ui.controls.loader.HWTAnimatedLoader
import com.reyozic.hackathon.ui.interfaces.HWTInterfaces
import com.reyozic.hackathon.ui.presenter.HWTPresenter
import com.reyozic.hackathon.ui.view.fragments.PostFragment
import com.reyozic.hackathon.ui.view.fragments.ResultQuestionsFragment
import com.reyozic.hackathon.ui.view.fragments.QuestionsFragment

class HWTMainActivity : AppCompatActivity(),QuestionsFragment.Listener, HWTInterfaces.View {

    private lateinit var binding: ActivityMainBinding

    private lateinit var fragmentContainer:HWTFragmentContainerHelper

    private var resultQuestionsFragment: ResultQuestionsFragment = ResultQuestionsFragment.newInstance()
    private var questionsFragment: QuestionsFragment = QuestionsFragment.newInstance()
    private var postsFragment:PostFragment = PostFragment.newInstance()

    private var actualFragment = HWTActualFragment.QUESTIONS

    private lateinit var mPresenter: HWTPresenter

    private lateinit var loader: HWTAnimatedLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initElements()
    }

    private fun getViewContainer(): View? = binding.content

    private fun initElements(){
        mPresenter = HWTPresenter(this,this)

        loader = HWTAnimatedLoader(this)

        questionsFragment.setListener(this)

        fragmentContainer = HWTFragmentContainerHelper(this,getViewContainer())
        fragmentContainer.updateFragmentContainer(questionsFragment,true)

        binding.bottomBar.onTabSelected = {
            fragmentContainer.clearAll(supportFragmentManager)
            when(it.id){
                R.id.tab_questions->fragmentContainer.updateFragmentContainer(questionsFragment,true)
                R.id.tab_stories->loadPosts()
            }
        }
    }

    private fun loadPosts(){
        loader.show()
        mPresenter.getPosts()
    }

    override fun showQuestions(questions: MutableList<QuestionModel>,type: TypeQuestions) {
        fragmentContainer.updateFragmentContainer(resultQuestionsFragment,false).also {
            resultQuestionsFragment.loadData(questions,type)
        }
    }

    override fun resultPosts(posts: MutableList<PostModel>) {
        loader.dismiss()
        fragmentContainer.updateFragmentContainer(postsFragment,true).also {
            postsFragment.loadData(posts)
        }
    }

    override fun errorService() {
        Toast.makeText(this,resources.getString(R.string.error_loading),Toast.LENGTH_SHORT).show()
    }
}