package com.reyozic.hackathon.ui.view.recyclers

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.reyozic.hackathon.databinding.ItemPostBinding
import com.reyozic.hackathon.domain.model.PostModel

class PostsViewHolder (item: View) : RecyclerView.ViewHolder(item){

    var binding = ItemPostBinding.bind(item)
    lateinit var mContext: Context

    fun bindData(post: PostModel){
        binding.date.text = post.date
        binding.iconPost.setImageDrawable(post.getIcon(mContext))
        binding.title.text = post.title
    }
}