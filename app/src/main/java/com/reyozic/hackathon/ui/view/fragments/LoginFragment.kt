package com.reyozic.hackathon.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reyozic.hackathon.databinding.LoginFragmentBinding
import com.reyozic.hackathon.ui.bases.HWTBaseFragment
import com.reyozic.hackathon.ui.view.viewhelpers.LoginViewHelper

class LoginFragment() : HWTBaseFragment<LoginFragmentBinding>(),LoginViewHelper.Listner {

    private lateinit var mViewHelper:LoginViewHelper
    private lateinit var mListener:Listener

    companion object{
        @JvmStatic
        fun newInstance():LoginFragment = LoginFragment()
    }

    override fun setupFragmentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun getViewContainer(): View? {
        return binding.loginContainer
    }

    override fun initElements() {
        mViewHelper = LoginViewHelper(binding,this)
    }

    fun setListener(listener:Listener){
        this.mListener = listener
    }

    override fun doLogin(email:String,password:String) {
        if(email.isNotEmpty() && password.isNotEmpty()){
            mListener.acceptLogin()
        }else{
            mListener.refuseLogin()
        }
    }

    interface Listener{
        fun acceptLogin()
        fun refuseLogin()
    }
}