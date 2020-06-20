package com.example.motionlayoutsample.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutsample.databinding.FragmentExample2Binding
import com.example.motionlayoutsample.databinding.ItemExample2Binding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Example2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentExample2Binding.inflate(inflater, container, false).let {
        it.recyclerView.apply {
            adapter = ListAdapter()
            layoutManager = LinearLayoutManager(context)
        }
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()

        view.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }
    }

    inner class ListAdapter : RecyclerView.Adapter<ListItemViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder = ListItemViewHolder(
            ItemExample2Binding.inflate(LayoutInflater.from(context), parent, false)
        )

        override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
            holder.binding.also {
                it.cardView.transitionName = position.toString()
                it.directions = Example2FragmentDirections.actionExample2FragmentToExample2DetailFragment(it.cardView.transitionName)
                it.navigationSeed = mapOf<View, String>(it.cardView to it.cardView.transitionName)
            }
        }

        override fun getItemCount(): Int = 10
    }

    inner class ListItemViewHolder(val binding: ItemExample2Binding): RecyclerView.ViewHolder(binding.root)
}