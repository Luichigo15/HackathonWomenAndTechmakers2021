package com.reyozic.hackathon.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reyozic.hackathon.databinding.ProfileFragmentBinding
import com.reyozic.hackathon.ui.bases.HWTBaseFragment
import com.reyozic.hackathon.ui.view.viewhelpers.ProfileViewHelper

class ProfileFragment():HWTBaseFragment<ProfileFragmentBinding>() {

    private lateinit var mViewHelper:ProfileViewHelper

    companion object{
        @JvmStatic
        fun newInstance():ProfileFragment = ProfileFragment()
    }

    override fun setupFragmentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProfileFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun getViewContainer(): View? {
        return binding.profileContainer
    }

    override fun initElements() {
        mViewHelper = ProfileViewHelper(binding,mContext)
    }
}