package com.example.mvvmarchitecture.core

import DP
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.mvvmarchitecture.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetFragment<T : ViewDataBinding>(val resourceId: Int) :
    BottomSheetDialogFragment() {

    lateinit var _binding: T
    protected val binding: T
        get() = _binding


    abstract fun setup()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as? BottomSheetDialog
        dialog?.setOnShowListener { dialogInterface ->
            val bottomSheetDialog = dialogInterface as BottomSheetDialog
            val bottomSheet = bottomSheetDialog.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.let {
                // Set elevation to the entire BottomSheet
                bottomSheet.elevation = 16F.DP // Set your desired elevation here
            }
        }
        return dialog ?: super.onCreateDialog(savedInstanceState)
    }




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding(inflater, container)
        addTopLine()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }

    private fun addTopLine() {
        val frameLayout = FrameLayout(requireContext())

        val frameLayoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        frameLayoutParams.topMargin = 10.DP // Adjust top margin as needed
        frameLayoutParams.bottomMargin = 15.DP // Adjust bottom margin as needed
        frameLayout.layoutParams = frameLayoutParams

        // Adding horizontal line
        val horizontalLine = View(requireContext())
        val shapeDrawable = ShapeDrawable()
        val roundRectShape = RoundRectShape(
            floatArrayOf(20f, 20f, 20f, 20f, 20f, 20f, 20f, 20f), // Radius for each corner
            null,
            null
        )
        shapeDrawable.shape = roundRectShape
        shapeDrawable.paint.color = Color.BLACK
        horizontalLine.background = shapeDrawable
        val lineParams = FrameLayout.LayoutParams(50.DP, 5.DP)
        lineParams.gravity = Gravity.CENTER_HORIZONTAL
        lineParams.topMargin = 0.DP
        lineParams.bottomMargin = 0.DP
        horizontalLine.layoutParams = lineParams
        frameLayout.addView(horizontalLine)

        // Adding close icon ImageView
        /*        val closeIcon = ImageView(requireContext())
                closeIcon.setImageResource(android.R.drawable.ic_menu_close_clear_cancel) // Replace with your close icon drawable
                closeIcon.setColorFilter(Color.BLACK)
                // Set layout parameters for the close icon
                val iconParams = FrameLayout.LayoutParams(
                    25.DP,
                    25.DP
                )
                iconParams.gravity = Gravity.END or Gravity.TOP
                iconParams.topMargin = -5.DP
                iconParams.marginEnd = 5.DP // Adjust margin as needed
                closeIcon.layoutParams = iconParams
                frameLayout.addView(closeIcon)

                // Add the FrameLayout to the parent layout*/
        (binding.root as? ViewGroup)?.addView(frameLayout, 0)
    }


    override fun onDestroyView() {
        super.onDestroyView()
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
