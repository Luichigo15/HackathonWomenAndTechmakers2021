package com.reyozic.hackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.reyozic.hackathon.ui.controls.loader.HWTAnimatedLoader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mLoader: HWTAnimatedLoader = HWTAnimatedLoader.newInstance(this)

        mLoader.show()
    }
}