package com.example.motionlayoutsample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopListViewModel : ViewModel() {

    val animationList = listItemRepository

}

val listItemRepository = MutableLiveData(
    listOf(
        Pair("Example1", "Swipeable Animation like Tinder"),
        Pair("Example2", "An animation that changes the design elements of a button or icon to indicate a functional change"),
        Pair("Example3", "Use of directional space"),
        Pair("Example4", "Hierarchy in Design Elements and Operations"),
        Pair("Example5", "Quick and agile visuals"),
        Pair("Example6", "System state"),
        Pair("Example7", "Fun Animation")
    )
)