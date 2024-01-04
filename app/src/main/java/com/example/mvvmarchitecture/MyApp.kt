package com.example.mvvmarchitecture

import android.app.Application
import com.example.mvvmarchitecture.db.ObjectBox

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        ObjectBox.init(this)
    }

    companion object {
        private lateinit var instance: MyApp

        @JvmStatic
        fun getInstance(): MyApp {
            return instance
        }
    }
}