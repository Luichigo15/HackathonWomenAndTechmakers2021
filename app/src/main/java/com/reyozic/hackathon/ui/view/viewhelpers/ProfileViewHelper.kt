package com.reyozic.hackathon.ui.view.viewhelpers

import android.app.AlertDialog
import android.content.Context
import com.reyozic.hackathon.R
import com.reyozic.hackathon.databinding.ProfileFragmentBinding

class ProfileViewHelper(
    val mBinding:ProfileFragmentBinding,
    val mContext:Context

) {
    private val btnContact = mBinding.btnContact

    init{
        initElements()
    }

    private fun initElements(){
        btnContact.setOnClickListener{
            AlertDialog.Builder(mContext)
                .setTitle("Pediste ayuda!!")
                .setMessage("Un especialista se pondrá en  contacto contigo")
                .setPositiveButton(
                    "OK"
                ) { dialog, which ->
                }
                .setIcon(R.drawable.ic_help_alert)
                .show()
        }
    }
}