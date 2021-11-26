package com.reyozic.hackathon.ui.controls.loader

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import com.airbnb.lottie.LottieAnimationView
import com.reyozic.hackathon.R

class HWTAnimatedLoader(context: Context) : Dialog(context) {

    private lateinit var animationView: LottieAnimationView

    companion object {
        @JvmStatic
        fun newInstance(context: Context): HWTAnimatedLoader {
            return HWTAnimatedLoader(context)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context.setTheme(R.style.HWTDialogWaiTheme)
        window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        init()
    }

    private fun init() {
        setContentView(R.layout.loader_dialog)
        setCancelable(false)
        animationView = findViewById(R.id.zmr_la_animationView)
    }

    override fun show() {
        if (!isShowing) {
            super.show()
        }
    }

    override fun dismiss() {
        if (isShowing) {
            super.dismiss()
        }
    }
}