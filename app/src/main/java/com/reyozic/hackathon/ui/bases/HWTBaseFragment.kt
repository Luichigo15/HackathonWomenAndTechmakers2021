package com.reyozic.hackathon.ui.bases

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class HWTBaseFragment<Binding: ViewBinding>: Fragment() {

    protected var _binding: Binding? = null
    protected lateinit var mView: View
    protected lateinit var mContext: Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = this.setupFragmentView(inflater, container, savedInstanceState)
        mContext = mView.context
        initElements()
        return mView
    }

    abstract fun setupFragmentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View

    protected abstract fun getViewContainer(): View?

    protected open fun initElements(){}

    protected val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}