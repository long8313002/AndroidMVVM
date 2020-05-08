package com.zhangzheng0601.androidmvvm.model

import android.content.Context
import android.content.SharedPreferences

internal class LoginSave(var context: Context) : LoginModel.ISave {

    private val sp: SharedPreferences =
        context.getSharedPreferences("login_save", Context.MODE_PRIVATE)

    companion object {
        const val USER_NAME = "username"
        const val PASSWORD = "password"
        const val CHECKED = "isChecked"
    }


    override fun save(username: String?, password: String?,isChecked:Boolean) {
        sp.edit().putString(USER_NAME, username).putString(PASSWORD, password).putBoolean(CHECKED,isChecked).apply()
    }

    override fun getUserName(): String? {
        return sp.getString(USER_NAME, "")
    }

    override fun getPassword(): String? {
        return sp.getString(PASSWORD, "")
    }

    override fun isChecked(): Boolean {
        return sp.getBoolean(CHECKED, false)
    }
}