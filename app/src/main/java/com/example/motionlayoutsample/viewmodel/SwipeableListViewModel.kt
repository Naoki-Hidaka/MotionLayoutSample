package com.example.motionlayoutsample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SwipeableListViewModel : ViewModel() {

    val swipeableList = swipeableListRepository
}

val swipeableListRepository = MutableLiveData(
    listOf(
        "item1",
        "item2",
        "item3",
        "item4",
        "item5",
        "item6",
        "item7",
        "item8",
        "item9",
        "item10"
    )
)