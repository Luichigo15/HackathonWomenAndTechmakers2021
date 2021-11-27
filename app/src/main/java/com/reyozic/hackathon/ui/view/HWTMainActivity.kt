package com.reyozic.hackathon.ui.view

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.reyozic.hackathon.databinding.ActivityMainBinding
import com.reyozic.hackathon.domain.constant.HWTActualFragment
import com.reyozic.hackathon.ui.controls.fragment.HWTFragmentContainerHelper

class HWTMainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    private lateinit var fragmentContainer:HWTFragmentContainerHelper

    private var actualFragment = HWTActualFragment.QUESTIONS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initElements()
    }

    private fun getViewContainer(): View? = binding.content

    private fun initElements(){
        fragmentContainer = HWTFragmentContainerHelper(this,getViewContainer())

    }
}