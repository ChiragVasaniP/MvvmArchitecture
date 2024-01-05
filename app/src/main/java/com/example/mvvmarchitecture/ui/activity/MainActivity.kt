package com.example.mvvmarchitecture.ui.activity
import com.example.mvvmarchitecture.MainViewModel
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.core.BaseActivity
import com.example.mvvmarchitecture.databinding.ActivityMainBinding
import com.example.mvvmarchitecture.ui.dialog.YourBottomSheetFragment

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(MainViewModel::class.java) {
    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main

    }


    override fun initStart() {

        val bottomSheetFragment = YourBottomSheetFragment()
        bottomSheetFragment.showWithAnimation(supportFragmentManager, "yourBottomSheetTag")
        with(mBinding) {

        }
    }

    override fun intentData() {
    }

}