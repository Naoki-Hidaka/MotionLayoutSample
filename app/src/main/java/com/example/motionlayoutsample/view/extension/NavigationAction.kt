package com.example.motionlayoutsample.view.extension

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.navigation.NavDirections
import androidx.navigation.findNavController

@BindingAdapter("navigationAction")
fun navigationAction(
    view: View,
    navDirections: NavDirections? = null
) {

    view.setOnClickListener { v ->
        navDirections?.let {
            v.findNavController().navigate(it)
        } ?: return@setOnClickListener
    }
}