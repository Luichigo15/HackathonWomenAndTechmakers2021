package com.reyozic.hackathon.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reyozic.hackathon.databinding.PostsFragmentBinding
import com.reyozic.hackathon.domain.model.PostModel
import com.reyozic.hackathon.ui.bases.HWTBaseFragment
import com.reyozic.hackathon.ui.view.viewhelpers.PostViewHelper

class PostFragment():HWTBaseFragment<PostsFragmentBinding>() {

    private lateinit var mViewHelper: PostViewHelper
    private lateinit var posts:MutableList<PostModel>

    companion object {
        @JvmStatic
        fun newInstsnce(): PostFragment = PostFragment()
    }

    override fun setupFragmentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PostsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun getViewContainer(): View? {
        return binding.postsContainer
    }

    override fun initElements() {
        mViewHelper = PostViewHelper(binding,mContext)
        mViewHelper.initRecycler(posts)
    }

    fun loadData(posts:MutableList<PostModel>){
        this.posts = posts
    }
}