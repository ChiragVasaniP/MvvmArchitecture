package com.example.mvvmarchitecture.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.example.mvvmarchitecture.R

abstract class BaseDialogFragment<DB : ViewDataBinding> : DialogFragment() {

    private var _binding: DB? = null
    protected val binding: DB
        get() = _binding ?: throw IllegalStateException("Binding not initialized")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog?.window?.setBackgroundDrawableResource(R.drawable.curved_top_background)
        dialog?.window?.attributes?.windowAnimations = R.style.DialogAnimation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDialogView(binding)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int

    open fun setupDialogView(binding: DB) {

    }
}
