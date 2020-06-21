package com.example.motionlayoutsample.view.fragment

import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.ButtonBarLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.motionlayoutsample.R
import com.example.motionlayoutsample.databinding.FragmentExample2DetailBinding
import com.example.motionlayoutsample.view.extension.popUpButton
import com.example.motionlayoutsample.view.extension.shrinkingButton
import com.example.motionlayoutsample.viewmodel.Example2DetailViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_practice.*

class Example2DetailFragment : Fragment() {


    private val args: Example2DetailFragmentArgs by navArgs()
    private var buttonType: ButtonType = ButtonType.MENU

    private var buttonList: List<Pair<Button, Long>>? = null

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
            Pair(it.button1, 100L),
            Pair(it.button2, 200L),
            Pair(it.button3, 300L)
        )
        it.cardView.transitionName = args.transitionName
        it.lifecycleOwner = viewLifecycleOwner
        it.menuActionButton.setOnClickListener { _ ->
            buttonType = when(buttonType) {
                ButtonType.MENU -> {
                    it.menuActionButton.setImageDrawable(resources.getDrawable(R.drawable.ic_action_cancel_white, context?.theme))
                    it.scrollView.alpha = 0.5F
                    buttonList?.forEach {
                        it.first.popUpButton(it.second)
                    }
                    ButtonType.CANCEL
                }
                ButtonType.CANCEL -> {
                    it.menuActionButton.setImageDrawable(resources.getDrawable(R.drawable.ic_action_menu_white, context?.theme))
                    it.scrollView.alpha = 1F
                    buttonList?.forEach {
                        it.first.shrinkingButton()
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