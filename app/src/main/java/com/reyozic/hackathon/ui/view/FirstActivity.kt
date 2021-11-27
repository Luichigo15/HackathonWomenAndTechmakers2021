package com.reyozic.hackathon.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.reyozic.hackathon.R
import com.reyozic.hackathon.databinding.ActivityFirstBinding
import com.reyozic.hackathon.databinding.ActivityMainBinding
import com.reyozic.hackathon.domain.constant.HWTActualFragment
import com.reyozic.hackathon.ui.controls.fragment.HWTFragmentContainerHelper
import com.reyozic.hackathon.ui.view.fragments.LoginFragment

class FirstActivity : AppCompatActivity(), LoginFragment.Listener{

    private lateinit var binding: ActivityFirstBinding

    private var loginFragment:LoginFragment = LoginFragment.newInstance()

    private lateinit var fragmentContainer:HWTFragmentContainerHelper

    private var actualFragment:HWTActualFragment = HWTActualFragment.LOGIN

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initElements()
    }

    private fun getViewContainer(): View?{
        return binding.content
    }

    private fun initElements(){
        loginFragment.setListener(this)

        fragmentContainer = HWTFragmentContainerHelper(this,getViewContainer())
        fragmentContainer.updateFragmentContainer(loginFragment,true)
    }

    override fun acceptLogin() {
        val i = Intent(this,HWTMainActivity::class.java)
        startActivity(i)
        this.finish()
    }

    override fun refuseLogin(case:Int) {
        Toast.makeText(this,
            if(case==1)
                resources.getString(R.string.refuse_login)
            else
                resources.getString(R.string.unable_login)
            ,Toast.LENGTH_SHORT).show()
    }
}