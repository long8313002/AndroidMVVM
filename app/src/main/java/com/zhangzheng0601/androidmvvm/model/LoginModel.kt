package com.zhangzheng0601.androidmvvm.model

import com.zhangzheng0601.androidmvvm.LoginViewModel

class LoginModel(var save: ISave, var verify: IVerification, var request: IRequest) :
    LoginViewModel.ILoginModel {

    interface ISave {
        fun save(username: String?, password: String?, isChecked: Boolean)

        fun getUserName(): String?

        fun getPassword(): String?

        fun isChecked(): Boolean
    }

    interface IVerification {

        fun verification(username: String?, password: String?): String?
    }

    interface IRequest {
        fun login(
            username: String?, password: String?,
            callback: (isSuccess: Boolean, message: String?) -> Unit
        )
    }


    override fun login(
        username: String?, password: String?,
        callback: (isSuccess: Boolean, message: String?) -> Unit
    ) {
        request.login(username, password, callback)
    }


    override fun verification(username: String?, password: String?): String? {
        return verify.verification(username, password)
    }

    override fun save(username: String?, password: String?, isChecked: Boolean) {
        save.save(username, password, isChecked)
    }

    override fun getUserName(): String? {
        return save.getUserName()
    }

    override fun getPassword(): String? {
        return save.getPassword()
    }

    override fun isCheckedRemember(): Boolean {
        return save.isChecked()
    }
}