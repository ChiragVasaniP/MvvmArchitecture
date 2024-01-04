package com.example.mvvmarchitecture

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<DB : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    protected lateinit var mBinding: DB

    protected lateinit var viewModel: VM

    protected lateinit var mContext: Activity

    override fun onStart() {
        super.onStart()
        mContext=this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(mContext, getLayoutResourceId())
        viewModel = ViewModelProvider(this)[getViewModelClass()]
        intentData()
        initStart()
    }

    abstract fun getLayoutResourceId(): Int

    abstract fun getViewModelClass(): Class<VM>

    abstract fun initStart()

    abstract fun intentData()


     fun showToastMessage(message:String){
         Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
    }

}