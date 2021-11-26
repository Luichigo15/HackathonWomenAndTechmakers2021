package com.reyozic.hackathon.domain.userdata

import android.content.Context
import com.google.gson.Gson
import com.reyozic.hackathon.configuration.HWTPrefs

class HWTUserControl {
    companion object{
        @JvmStatic
        fun saveCurrentUser(context: Context, user: HWTUser){
            var data:String ? = Gson().toJson(user)
            HWTPrefs.getInstance(context)?.put(HWTPrefs.Key.USER_DATA,data)
        }

        @JvmStatic
        fun getCurrentUser(context: Context):HWTUser?{
            var userControl:HWTUser? = null
            if(!HWTPrefs.getInstance(context)?.getString(HWTPrefs.Key.USER_DATA).isNullOrEmpty()){
                userControl= Gson().fromJson(HWTPrefs.getInstance(context)?.getString(HWTPrefs.Key.USER_DATA),HWTUser::class.java)
            }
            return userControl
        }
    }
}