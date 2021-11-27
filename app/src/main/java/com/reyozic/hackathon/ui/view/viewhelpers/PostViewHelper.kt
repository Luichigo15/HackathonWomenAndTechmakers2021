package com.reyozic.hackathon.ui.view.viewhelpers

import android.content.Context
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.reyozic.hackathon.R
import com.reyozic.hackathon.databinding.PostsFragmentBinding
import com.reyozic.hackathon.domain.model.PostModel
import com.reyozic.hackathon.domain.model.QuestionModel
import com.reyozic.hackathon.domain.model.TypeQuestions
import com.reyozic.hackathon.ui.view.recyclers.PostsAdapter
import com.reyozic.hackathon.ui.view.recyclers.QuestionsAdapter

class PostViewHelper(
    mBinding:PostsFragmentBinding,
    val mContext:Context
) {

    private val recyclerPosts = mBinding.recyclerPosts

    private lateinit var adapterPost:PostsAdapter

    fun initRecycler(posts:MutableList<PostModel>){
        adapterPost = PostsAdapter(posts,mContext)
        recyclerPosts.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = adapterPost
        }
    }

}