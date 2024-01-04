package com.example.mvvmarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding,ViewModel>() {

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModelClass(): Class<ViewModel> {
        TODO("Not yet implemented")
    }

    override fun initStart() {
        TODO("Not yet implemented")
    }

    override fun intentData() {
        TODO("Not yet implemented")
    }

}