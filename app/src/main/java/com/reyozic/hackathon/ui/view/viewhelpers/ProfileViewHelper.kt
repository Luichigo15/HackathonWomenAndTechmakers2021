package com.reyozic.hackathon.ui.view.viewhelpers

import android.R
import android.app.AlertDialog
import android.content.Context
import com.reyozic.hackathon.databinding.ProfileFragmentBinding
import android.content.DialogInterface




class ProfileViewHelper(
    val mBinding:ProfileFragmentBinding,
    val mContext:Context

) {
    private val btnContact = mBinding.btnContact

    init{

    }

    private fun initElements(){
        btnContact.setOnClickListener{
            AlertDialog.Builder(mContext)
                .setTitle("Pediste ayuda!!")
                .setMessage("Un especialista se pondrá en  contacto contigo") // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(
                    R.string.yes
                ) { dialog, which ->
                    // Continue with delete operation
                } // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(R.string.no, null)
                .setIcon(R.drawable.ic_dialog_alert)
                .show()
        }
    }
}