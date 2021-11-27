package com.reyozic.hackathon.ui.view.viewhelpers

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.reyozic.hackathon.R
import com.reyozic.hackathon.databinding.CommentsFragmentBinding
import com.reyozic.hackathon.domain.model.CommentModel
import com.reyozic.hackathon.ui.view.recyclers.CommentAdapter

class CommentsViewHelper(
    val binding: CommentsFragmentBinding,
    val context: Context,
) {

    private val recyclerComments = binding.recyclerComments
    private val story = binding.story
    private val countComments = binding.commentsLabel

    private lateinit var adapterComments:CommentAdapter

    @SuppressLint("StringFormatMatches")
    fun loadData(story:String, comments:MutableList<CommentModel>){
        this.story.text = story

        adapterComments = CommentAdapter(comments,context)
        recyclerComments.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = adapterComments
        }

        countComments.text = context.resources.getString(R.string.comments,comments.size)
    }
}