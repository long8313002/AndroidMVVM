package com.zhangzheng0601.androidmvvm

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.zhangzheng0601.androidmvvm.base.BaseActivity
import com.zhangzheng0601.androidmvvm.base.BaseView
import com.zhangzheng0601.androidmvvm.base.BaseViewModel
import com.zhangzheng0601.androidmvvm.databinding.ActivityLoginBinding
import com.zhangzheng0601.androidmvvm.model.LoginModel
import com.zhangzheng0601.androidmvvm.model.LoginRequest
import com.zhangzheng0601.androidmvvm.model.LoginSave
import com.zhangzheng0601.androidmvvm.model.LoginVerification


class MainActivity : BaseActivity<BaseViewModel.IView,LoginViewModel.ILoginModel, LoginViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.loginViewModel = viewModel
    }

    override fun createViewModel(): LoginViewModel {
        return LoginViewModel()
    }

    override fun createModel(): LoginViewModel.ILoginModel {
        val loginSave = LoginSave(this)
        val loginRequest = LoginRequest()
        val loginVerification = LoginVerification()
        return LoginModel(loginSave,loginVerification,loginRequest)
    }

    override fun createView(): BaseViewModel.IView {
        return BaseView(this)
    }
}
