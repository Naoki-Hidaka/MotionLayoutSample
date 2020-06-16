package com.example.motionlayoutsample.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutsample.databinding.FragmentTopBinding
import com.example.motionlayoutsample.databinding.ItemTopListBinding
import com.example.motionlayoutsample.viewmodel.TopListViewModel

class TopFragment : Fragment() {

    private val viewModel: TopListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentTopBinding.inflate(inflater, container, false).let {
        it.recyclerView.also {
            it.adapter = TopListAdapter()
            it.layoutManager = LinearLayoutManager(context)
        }
        it.lifecycleOwner = viewLifecycleOwner
        it.root
    }

    private inner class TopListAdapter : RecyclerView.Adapter<TopListItemViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopListItemViewHolder = TopListItemViewHolder(
            ItemTopListBinding.inflate(LayoutInflater.from(context), parent, false)
        )

        override fun onBindViewHolder(holder: TopListItemViewHolder, position: Int) {
            holder.binding.also {
                it.listItem = viewModel.animationList.value?.get(position)
                it.lifecycleOwner = viewLifecycleOwner
                it.isLast = (itemCount - 1) == position
                it.navDirections = when(position) {
                    0 -> TopFragmentDirections.actionTopFragmentToExample1Fragment()
                    7 -> TopFragmentDirections.actionTopFragmentToPracticeFragment()
                    else -> null
                }
            }
        }

        override fun getItemCount(): Int = viewModel.animationList.value?.size ?: 0
    }

    private inner class TopListItemViewHolder(val binding: ItemTopListBinding): RecyclerView.ViewHolder(binding.root)
}