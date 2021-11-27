package com.reyozic.hackathon.ui.view.viewhelpers

import com.reyozic.hackathon.databinding.LoginFragmentBinding

class LoginViewHelper(
    mBinding: LoginFragmentBinding,
    val mListener:Listner
) {

    private val btnLogin = mBinding.btnLogin
    private val txtEmail = mBinding.txtEmail
    private val txtPassword = mBinding.txtPassword

    init{
        initElements()
    }

    private fun initElements(){
        btnLogin.setOnClickListener {
            mListener.doLogin(txtEmail.text.toString(),txtPassword.text.toString())
        }
    }

    interface Listner{
        fun doLogin(email:String,password:String)
    }
}