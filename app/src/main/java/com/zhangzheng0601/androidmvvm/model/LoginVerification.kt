package com.zhangzheng0601.androidmvvm.model

import android.text.TextUtils

class LoginVerification: LoginModel.IVerification {

    override fun verification(username: String?, password: String?): String? {
        if(TextUtils.isEmpty(username)){
            return "用户名不能为空"
        }

        if(TextUtils.isEmpty(password)){
            return "密码不能为空"
        }

        if(username?.length?:0 >10 ){
            return "用户名过长"
        }

        if(password?.length?:0 >10 ){
            return "密码过长"
        }

        return null
    }
}