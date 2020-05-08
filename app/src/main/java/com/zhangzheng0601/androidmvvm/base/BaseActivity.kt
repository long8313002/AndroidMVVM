package com.zhangzheng0601.androidmvvm.base

import android.app.Activity
import android.os.Bundle

abstract class BaseActivity<V:BaseViewModel.IView,M: BaseViewModel.IModel,VM: BaseViewModel<V,M>>:Activity() {

    protected lateinit var viewModel:VM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = createViewModel()
        viewModel.attach(createModel(),createView())

        viewModel.onCreate(savedInstanceState)
    }

    abstract fun createViewModel():VM

    abstract fun createModel():M

    abstract fun createView():V

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onStop() {
        super.onStop()
        viewModel.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }


}