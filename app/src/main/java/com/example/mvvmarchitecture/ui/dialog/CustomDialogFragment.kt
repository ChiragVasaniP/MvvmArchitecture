package com.example.mvvmarchitecture.ui.dialog

import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.core.BaseDialogFragment
import com.example.mvvmarchitecture.databinding.ActivityMainBinding

class CustomDialogFragment : BaseDialogFragment<ActivityMainBinding>() {

    override fun getLayoutRes(): Int {
        return R.layout.activity_main // Replace with your layout resource ID
    }

    override fun setupDialogView(binding: ActivityMainBinding) {
        // Implement your dialog view setup here using the provided binding
//        binding.cancelButton.setOnClickListener {
//            dismiss() // Dismiss the dialog on cancel button click
//        }
        // Other setup logic as needed
    }
}
