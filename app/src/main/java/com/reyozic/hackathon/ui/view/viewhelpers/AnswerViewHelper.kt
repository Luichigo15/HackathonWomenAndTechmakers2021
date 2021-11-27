package com.reyozic.hackathon.ui.view.viewhelpers

import android.content.Context

class AnswerViewHelper(
    val binding:AnswerFragmentBinding,
    val context:Context,
) {

    private val icon = binding.
    private val answer = binding.
    private val btnClose = binding

    init{
        initElements()
    }

    private fun initElements(){
        btnClose.setOnClickListener{

        }
    }
}