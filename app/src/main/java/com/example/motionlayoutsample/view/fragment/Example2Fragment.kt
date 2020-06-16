package com.example.motionlayoutsample.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.motionlayoutsample.databinding.FragmentExample2Binding

class Example2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentExample2Binding.inflate(inflater, container, false).let {
        it.lifecycleOwner = viewLifecycleOwner
        it.root
    }
}