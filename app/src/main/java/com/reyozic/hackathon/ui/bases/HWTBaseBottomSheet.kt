package com.reyozic.hackathon.ui.bases

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.reyozic.hackathon.R

abstract class HWTBaseBottomSheet<Binding : ViewBinding> : BottomSheetDialogFragment(),DialogInterface.OnShowListener{

    protected var _binding: Binding? = null
    protected lateinit var mView: View
    protected lateinit var mContext: Context

    protected var isShowing: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = this.setupBottomSheetView(inflater, container, savedInstanceState)
        mContext = mView.context
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initElements()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener(this)
        return dialog
    }

    open fun setStyle() {
        setStyle(DialogFragment.STYLE_NORMAL, R.style.HWTBottomSheetStyle)
    }

    abstract fun setupBottomSheetView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View

    protected abstract fun initElements()

    open fun loadData() {}

    protected val binding get() = _binding!!

    override fun onShow(dialog: DialogInterface?) {
        loadData()
    }

    override fun show(manager: FragmentManager, tag: String?) {
        if (!isShowing) {
            isShowing = true
            super.show(manager, tag)
        }
    }

    override fun dismiss() {
        if (isShowing) {
            isShowing = false
            super.dismiss()
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        isShowing = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        isShowing = false
    }
}