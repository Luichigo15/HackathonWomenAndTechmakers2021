package com.reyozic.hackathon.ui.view.viewhelpers

import android.content.Context
import com.reyozic.hackathon.databinding.CommentsFragmentBinding

class CommentsViewHelper(
    val binding: CommentsFragmentBinding,
    val context: Context,
) {

    private val recyclerComments = binding.recyclerComments
    private val story = binding.story

    fun loadData(story:String){
        //this.story.text = story
    }
}