package com.reyozic.hackathon.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reyozic.hackathon.databinding.PostsFragmentBinding
import com.reyozic.hackathon.domain.model.PostModel
import com.reyozic.hackathon.ui.bases.HWTBaseFragment
import com.reyozic.hackathon.ui.view.bottomsheet.CommentsBottomSheet
import com.reyozic.hackathon.ui.view.viewhelpers.PostViewHelper

class PostFragment():HWTBaseFragment<PostsFragmentBinding>(),PostViewHelper.Listener {

    private lateinit var mViewHelper: PostViewHelper
    private lateinit var posts:MutableList<PostModel>

    private var commentsBottomSheet = CommentsBottomSheet.newInstance()

    companion object {
        val TAG = PostFragment::class.java.simpleName
        @JvmStatic
        fun newInstance(): PostFragment = PostFragment()
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
        mViewHelper = PostViewHelper(binding,mContext,this)
        mViewHelper.initRecycler(posts)
    }

    fun loadData(posts:MutableList<PostModel>){
        this.posts = posts
    }

    override fun openComments(post: PostModel) {
        commentsBottomSheet.loadData(post)
        commentsBottomSheet.show(requireFragmentManager(),TAG)
    }
}