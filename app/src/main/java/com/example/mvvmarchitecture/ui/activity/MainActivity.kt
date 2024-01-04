package com.example.mvvmarchitecture.ui.activity
import com.example.mvvmarchitecture.MainViewModel
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.core.BaseActivity
import com.example.mvvmarchitecture.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(MainViewModel::class.java) {
    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }


    override fun initStart() {
        with(mBinding) {

        }
    }

    override fun intentData() {
    }

}