package com.zhangzheng0601.androidmvvm.base

import android.graphics.Bitmap
import android.os.Bundle

abstract class BaseViewModel<V: BaseViewModel.IView,M : BaseViewModel.IModel> {

    interface IModel

    interface IView{
        fun showToast(message: String)

        fun getString(resId: Int):String?

        fun getBitmap(resId:Int): Bitmap?
    }

    protected lateinit var model: M

    protected lateinit var view:V

    fun attach(model: M,view:V) {
        this.model = model
        this.view= view
    }


    open fun onCreate(savedInstanceState: Bundle?) {

    }

    open fun onPause() {

    }

    open fun onResume() {

    }

    open fun onStop() {

    }

    open fun onDestroy() {

    }
}