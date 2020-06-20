package com.example.motionlayoutsample.view.fragment

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.ButtonBarLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.motionlayoutsample.R
import com.example.motionlayoutsample.databinding.FragmentExample2DetailBinding
import com.example.motionlayoutsample.view.extension.popUpButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_practice.*

class Example2DetailFragment : Fragment() {

    private val args: Example2DetailFragmentArgs by navArgs()
    private var buttonType: ButtonType = ButtonType.MENU

    private var buttonList: List<Triple<FloatingActionButton, Float, Long>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentExample2DetailBinding.inflate(inflater, container, false).let {
        buttonList = listOf(
            Triple(it.button1, 0.5F, 100L),
            Triple(it.button2, 0.7F, 200L),
            Triple(it.button3, 1F, 300L)
        )
        
        it.cardView.transitionName = args.transitionName
        it.lifecycleOwner = viewLifecycleOwner
        it.menuActionButton.setOnClickListener { _ ->
            buttonType = when(buttonType) {
                ButtonType.MENU -> {
                    it.menuActionButton.setImageDrawable(resources.getDrawable(R.drawable.ic_action_cancel_white, context?.theme))
                    it.scrollView.alpha = 0.5F
                    buttonList?.forEach {
                        it.first.popUpButton(it.third, it.second)
                    }
                    ButtonType.CANCEL
                }
                ButtonType.CANCEL -> {
                    it.menuActionButton.setImageDrawable(resources.getDrawable(R.drawable.ic_action_menu_white, context?.theme))
                    it.scrollView.alpha = 1F
                    buttonList?.forEach {
                        it.first.hide()
                    }
                    ButtonType.MENU
                }
            }
        }
        it.root
    }
}

enum class ButtonType {
    MENU,
    CANCEL
}