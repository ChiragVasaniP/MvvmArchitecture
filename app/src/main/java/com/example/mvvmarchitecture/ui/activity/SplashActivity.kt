package com.example.mvvmarchitecture.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.core.BaseActivity
import com.example.mvvmarchitecture.core.BaseViewModel
import com.example.mvvmarchitecture.databinding.ActivitySplashAcitivtyBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import startActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashAcitivtyBinding,BaseViewModel>(BaseViewModel::class.java) {

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_splash_acitivty
    }

    override fun initStart() {
        lifecycleScope.launch{
            delay(3000)
            startActivity<MainActivity>()
        }

    }

    override fun intentData() {
    }
}