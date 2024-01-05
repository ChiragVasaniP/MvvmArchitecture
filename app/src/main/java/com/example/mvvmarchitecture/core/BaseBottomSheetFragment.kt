package com.example.mvvmarchitecture.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.mvvmarchitecture.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetFragment<T : ViewDataBinding>(val resourceId:Int) : BottomSheetDialogFragment() {

    private var _binding: T? = null
    protected val binding: T
        get() = _binding!!


    abstract fun setup()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): T {
        return DataBindingUtil.inflate(inflater, resourceId, container, false)
    }

    fun showWithAnimation(manager: FragmentManager, tag: String?) {
        val transaction = manager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_NONE)
        transaction.setCustomAnimations(
            R.anim.slide_up, // Enter animation
            R.anim.slide_down // Exit animation
        )
        transaction.add(this, tag)
        transaction.commitAllowingStateLoss()
    }
}
