package com.reyozic.hackathon.ui.view.recyclers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reyozic.hackathon.R
import com.reyozic.hackathon.domain.model.CommentModel

class CommentAdapter(val comments:MutableList<CommentModel>,val mContext:Context):RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment,parent,false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]
        holder.context = mContext
        holder.bindData(comment)
    }

    override fun getItemCount(): Int {
        return comments.size
    }
}