package com.reyozic.hackathon.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reyozic.hackathon.databinding.LoginFragmentBinding
import com.reyozic.hackathon.domain.userdata.HWTUser
import com.reyozic.hackathon.ui.bases.HWTBaseFragment
import com.reyozic.hackathon.ui.controls.loader.HWTAnimatedLoader
import com.reyozic.hackathon.ui.interfaces.HWTInterfaces
import com.reyozic.hackathon.ui.presenter.HWTPresenter
import com.reyozic.hackathon.ui.view.viewhelpers.LoginViewHelper

class LoginFragment() : HWTBaseFragment<LoginFragmentBinding>(),LoginViewHelper.Listner,
    HWTInterfaces.View{

    private lateinit var mViewHelper:LoginViewHelper
    private lateinit var mListener:Listener

    private lateinit var mPresenter: HWTPresenter

    private lateinit var loader: HWTAnimatedLoader

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
        mPresenter = HWTPresenter(requireContext(),this)
        mViewHelper = LoginViewHelper(binding,this)
        loader = HWTAnimatedLoader(requireContext())
    }

    fun setListener(listener:Listener){
        this.mListener = listener
    }

    override fun doLogin(email:String,password:String) {
        if(email.isNotEmpty() && password.isNotEmpty()){
            saveUser(HWTUser(email,password))
        }else{
            mListener.refuseLogin(1)
        }
    }

    private fun saveUser(user:HWTUser){
        loader.show()
        mPresenter.saveUser(user)
    }

    override fun resultUser() {
        loader.dismiss()
        mListener.acceptLogin()
    }

    override fun errorService() {
        loader.dismiss()
        mListener.refuseLogin(2)
    }

    interface Listener{
        fun acceptLogin()
        fun refuseLogin(case:Int)
    }
}