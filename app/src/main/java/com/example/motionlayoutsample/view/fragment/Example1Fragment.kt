package com.example.motionlayoutsample.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.motionlayoutsample.R
import com.example.motionlayoutsample.databinding.ItemCardviewBinding
import com.example.motionlayoutsample.viewmodel.SwipeableListViewModel

class Example1Fragment : Fragment() {

    private val viewModel: SwipeableListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_example1, container, false)
    }

    /*

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentExample1Binding.inflate(inflater, container, false).let {
        it.recyclerView.apply {
            adapter = SwipeableListAdapter()
            layoutManager = LinearLayoutManager(context)
        }
        it.lifecycleOwner = viewLifecycleOwner
        it.root
    }

    private inner class SwipeableListAdapter : RecyclerView.Adapter<SwipeableListItemViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): SwipeableListItemViewHolder = SwipeableListItemViewHolder(ItemCardviewBinding.inflate(
            LayoutInflater.from(context), parent, false))

        override fun onBindViewHolder(holder: SwipeableListItemViewHolder, position: Int) {
            holder.binding.also {
                it.lifecycleOwner = viewLifecycleOwner
                it.listItem = viewModel.swipeableList.value?.get(position)
            }
        }

        override fun getItemCount(): Int = viewModel.swipeableList.value?.size ?: 0
    }

    private inner class SwipeableListItemViewHolder(val binding: ItemCardviewBinding): RecyclerView.ViewHolder(binding.root)

     */
}