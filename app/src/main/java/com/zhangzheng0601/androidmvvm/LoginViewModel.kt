package com.zhangzheng0601.androidmvvm

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.zhangzheng0601.androidmvvm.base.BaseViewModel

class LoginViewModel :
    BaseViewModel<BaseViewModel.IView, LoginViewModel.ILoginModel>() {

    interface ILoginModel : IModel {
        fun login(
            username: String?,
            password: String?,
            callback: (isSuccess: Boolean, message: String?) -> Unit
        )

        fun verification(username: String?, password: String?): String?

        fun save(username: String?, password: String?, isChecked: Boolean)

        fun getUserName(): String?

        fun getPassword(): String?

        fun isCheckedRemember(): Boolean
    }

    var username: ObservableField<String> = ObservableField()

    var password: ObservableField<String> = ObservableField()

    var isChecked: ObservableBoolean = ObservableBoolean()

    var onLoginClick = View.OnClickListener {

        val verifyResult = model.verification(username.get(), password.get())
        if (!TextUtils.isEmpty(verifyResult)) {
            view.showToast(verifyResult!!)
            return@OnClickListener
        }

        model.login(username.get(), password.get()) { isSuccess, message ->
            if (isSuccess) {
                onLoginSuccess()
            } else {
                onLoginFail(message)
            }
        }

    }

    var onClearClick = View.OnClickListener {
        username.set("")
        password.set("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (model.isCheckedRemember()) {
            username.set(model.getUserName())
            password.set(model.getPassword())
            isChecked.set(model.isCheckedRemember())
        }
    }

    private fun onLoginSuccess() {
        view.showToast("登陆成功")

        if (isChecked.get()) {
            model.save(username.get(), password.get(), true)
        } else {
            model.save("", "", false)
        }
    }

    private fun onLoginFail(message: String?) {
        view.showToast(message ?: "登陆失败")
    }
}