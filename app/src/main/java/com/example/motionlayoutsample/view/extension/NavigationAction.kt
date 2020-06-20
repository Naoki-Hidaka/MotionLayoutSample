package com.example.motionlayoutsample.view.extension

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.navOptions
import com.example.motionlayoutsample.R

@BindingAdapter("navigationAction", "navigationSeeds", requireAll = false)
fun navigationAction(
    view: View,
    navDirections: NavDirections? = null,
    navDirectionSeeds: Map<View, String>? = null
) {

    navDirections ?: return

    val animation = navOptions {
        anim {
            enter = R.anim.transaction_slide_in_enter
            exit = R.anim.transaction_slide_in_exit
            popEnter = R.anim.transition_slide_out_enter
            popExit = R.anim.transition_slide_out_exit
        }
    }

    view.setOnClickListener { v ->
        navDirections.let { directions ->
            navDirectionSeeds?.let {
                it.forEach { sharedElement ->
                    FragmentNavigator.Extras.Builder().apply {
                        addSharedElement(sharedElement.key, sharedElement.value)
                    }.build().also { sharedExtras ->
                        v.findNavController().navigate(directions, sharedExtras)
                    }
                }
            } ?: animation.also {
                v.findNavController().navigate(directions, it)
            }
        }
    }
}