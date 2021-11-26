package com.reyozic.hackathon.configuration

import android.app.Application
import com.google.firebase.FirebaseApp

class HWTApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(applicationContext)
    }
}