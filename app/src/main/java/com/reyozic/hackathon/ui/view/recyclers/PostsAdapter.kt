package com.reyozic.hackathon.ui.view.recyclers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reyozic.hackathon.R
import com.reyozic.hackathon.domain.model.PostModel

class PostsAdapter (val posts:MutableList<PostModel>,val mContext:Context):RecyclerView.Adapter<PostsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return PostsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = posts[position]
        holder.mContext = mContext
        holder.bindData(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}