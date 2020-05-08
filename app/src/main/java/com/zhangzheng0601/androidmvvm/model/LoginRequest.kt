package com.zhangzheng0601.androidmvvm.model

internal class LoginRequest: LoginModel.IRequest {
    override fun login(
        username: String?,
        password: String?,
        callback: (isSuccess: Boolean, message: String?) -> Unit
    ) {

        if(username.equals("1111")&&password.equals("2222")){
            callback(true,null)
        }else{
            callback(false,"用户名、密码错误")
        }
    }
}