package com.example.mvvmarchitecture.core

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel>(private val VmClass: Class<VM>) :
    AppCompatActivity(),CoroutineScope by MainScope() {

    lateinit var mBinding: DB

    lateinit var viewModel: VM

    lateinit var mContext: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        mBinding = DataBindingUtil.setContentView(mContext, getLayoutResourceId())
        viewModel = ViewModelProvider(this)[VmClass]
        mBinding.lifecycleOwner = this
        mBinding.executePendingBindings()
        intentData()
        initStart()
        observeData()
    }

    open fun observeData() {
        with(viewModel) {

            apiError.observe(this@BaseActivity) { apiError ->
                showErrorMessageToast(apiError)
            }

            apiLoading.observe(this@BaseActivity) { isLoading ->
                if (isLoading) {
                    showProgressDialog()
                } else {
                    hideProgressDialog()
                }
            }

        }
    }

    private fun showProgressDialog() {

    }

    private fun hideProgressDialog() {

    }

    @LayoutRes
    abstract fun getLayoutResourceId(): Int


    abstract fun initStart()

    abstract fun intentData()


    open fun showErrorMessageToast(error: String) {
        Toast.makeText(mContext, error, Toast.LENGTH_SHORT).show()
    }

    open fun showToastMessage(message: String) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
    }

}