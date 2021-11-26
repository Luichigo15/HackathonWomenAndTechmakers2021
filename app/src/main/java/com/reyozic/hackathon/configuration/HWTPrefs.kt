package com.reyozic.hackathon.configuration

import android.content.Context
import android.content.SharedPreferences

class HWTPrefs(context: Context) {
    private var mPreferences: SharedPreferences
    private var mEditor: SharedPreferences.Editor? = null

    object Key {
        private const val PREFIX = "HWT_key_"
        const val USER_DATA = PREFIX +"user_data"
    }

    fun getString(key: String?): String? {
        return getString(key, DEFAULT_STRING)
    }

    fun getInt(key: String?): Int {
        return mPreferences.getInt(key, DEFAULT_INT)
    }

    fun put(key: String?, `val`: String?) {
        doEdit()
        mEditor!!.putString(key, `val`)
        doApply()
    }

    fun put(key: String?, `val`: Int) {
        doEdit()
        mEditor!!.putInt(key, `val`)
        doApply()
    }

    fun put(key: String?, `val`: Boolean) {
        doEdit()
        mEditor!!.putBoolean(key, `val`)
        doApply()
    }

    /*
     * GetValues
     */
    fun getString(key: String?, defaultValue: String?): String? {
        return mPreferences.getString(key, defaultValue)
    }

    fun getBoolean(key: String?): Boolean {
        return getBoolean(key, DEFAULT_BOOLEAN)
    }

    fun getBoolean(key: String?, defaultValue: Boolean): Boolean {
        return mPreferences.getBoolean(key, defaultValue)
    }

    private fun doEdit() {
        if (mEditor == null) {
            mEditor = mPreferences.edit()
        }
    }

    private fun doApply() {
        if (mEditor != null) {
            mEditor!!.apply()
            mEditor = null
        }
    }

    fun clearAllPreferences() {
        mPreferences.edit().clear().apply()
    }

    companion object{
        private const val DEFAULT_STRING = ""
        private const val DEFAULT_INT = -1
        private const val FILE_PREFERENCES = "HWT_gen_prefs"
        private const val DEFAULT_BOOLEAN = false
        private var INSTANCE: HWTPrefs? = null

        @JvmStatic
        fun getInstance(context: Context): HWTPrefs? {
            if (INSTANCE == null) {
                INSTANCE = HWTPrefs(context)
            }
            return INSTANCE
        }
    }

    init{
        mPreferences = context.getSharedPreferences(
            FILE_PREFERENCES,
            Context.MODE_PRIVATE
        )
    }
}