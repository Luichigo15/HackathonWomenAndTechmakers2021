package com.reyozic.hackathon.ui.view.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reyozic.hackathon.databinding.CommentsFragmentBinding
import com.reyozic.hackathon.domain.model.PostModel
import com.reyozic.hackathon.ui.bases.HWTBaseBottomSheet
import com.reyozic.hackathon.ui.view.viewhelpers.CommentsViewHelper

class CommentsBottomSheet : HWTBaseBottomSheet<CommentsFragmentBinding>(){

    private lateinit var mViewHelper:CommentsViewHelper
    private lateinit var post:PostModel

    companion object{
        @JvmStatic
        fun newInstance():CommentsBottomSheet = CommentsBottomSheet()
    }

    override fun setupBottomSheetView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CommentsFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun initElements() {
        mViewHelper = CommentsViewHelper(binding,mContext)
        mViewHelper.loadData(post.description,post.comments)
    }

    fun loadData(post:PostModel){
        this.post = post
    }
}